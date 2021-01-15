package skidor;

import java.util.ArrayList;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MasStart {

	private final TableView<Competitor> table = new TableView<>();
	private final ObservableList<Competitor> tvObservableList = FXCollections.observableArrayList();
	private Boolean startButtonBoolean = true;
	private Boolean stopButtonBoolean = true;

	ChronoMeter mainTime;
	ArrayList<Competitor> competitorList = new ArrayList<Competitor>();

	public void show() {

		Stage stage = new Stage();
		mainTime = new ChronoMeter();

		stage.setTitle("Mass Start");
		stage.setWidth(600);
		stage.setHeight(600);

		Button startBtn = new Button("Start Race");
		startBtn.setOnAction(e -> {
			if (startButtonBoolean == true) {
				for (Competitor competitor : tvObservableList) {
					competitor.setStopButtonPressed(false);
					competitor.setLapButtonPressed(false);
				}

				mainTime.start();
			}
			startButtonBoolean = false;
		});

		Button stopBtn = new Button("Stop Race");

		stopBtn.setOnAction(e -> {
			mainTime.stopp();
			mainTime.reset();

			for (Competitor competitor : tvObservableList) {
				competitorList.add(competitor);
			}

			if (stopButtonBoolean == true) {
				PursuitStartTime pursuitStartTimeHandler = new PursuitStartTime();
				pursuitStartTimeHandler.setTotalTimeSec();
				Collections.sort(competitorList, Competitor.totalTimeSecComparator);
				pursuitStartTimeHandler.setPursuitStartTime(competitorList);

				XMLhandler.encode(competitorList);
			}
			stopButtonBoolean = false;
		});

		setTableappearance();

		fillTableObservableListWithSampleData();
		table.setItems(tvObservableList);

		addLapButtonToTable();
		addButtonToTable();

		TableColumn<Competitor, Integer> colStartNr = new TableColumn<>("Start Number");
		colStartNr.setCellValueFactory(new PropertyValueFactory<>("nr"));

		TableColumn<Competitor, String> colName = new TableColumn<>("Name");
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<Competitor, Integer> colLapTime = new TableColumn<>("Lap Time");
		colLapTime.setCellValueFactory(new PropertyValueFactory<>("lapTime"));

		TableColumn<Competitor, Integer> colTime = new TableColumn<>("Tid");
		colTime.setCellValueFactory(new PropertyValueFactory<>("stopTime"));

		table.getColumns().addAll(colStartNr, colName, colLapTime, colTime);

		HBox hBox = new HBox(20);
		HBox buttons = new HBox(30);
		buttons.getChildren().addAll(startBtn, stopBtn);
		buttons.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(buttons, mainTime);

		VBox vBox = new VBox(20);
		vBox.getChildren().addAll(hBox, table);

		Scene scene = new Scene(new Group(vBox));
		scene.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}

	private void setTableappearance() {
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.setPrefWidth(600);
		table.setPrefHeight(600);
	}

	private void fillTableObservableListWithSampleData() {
		XMLhandler.decode();
		for (Competitor competitor : XMLhandler.list) {
			tvObservableList.addAll(competitor);
			competitor.setLapTime("00:00.000");
			competitor.setStopTime("00:00.000");
		}

	}

	private void addButtonToTable() {
		TableColumn<Competitor, Void> colBtn = new TableColumn("");

		Callback<TableColumn<Competitor, Void>, TableCell<Competitor, Void>> cellFactory = new Callback<TableColumn<Competitor, Void>, TableCell<Competitor, Void>>() {
			@Override
			public TableCell<Competitor, Void> call(final TableColumn<Competitor, Void> param) {
				final TableCell<Competitor, Void> cell = new TableCell<Competitor, Void>() {

					private final Button btn = new Button("Stop");

					{
						btn.setOnAction((ActionEvent event) -> {

							Competitor competitor = getTableView().getItems().get(getIndex());
							mainTime.setTimerTid();
							competitor.setStopTime(mainTime.getTimerTid());
							table.refresh();
							competitor.setStopButtonPressed(true);

						});
					}

					@Override
					public void updateItem(Void item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
						} else {
							setGraphic(btn);
						}
					}
				};
				return cell;
			}
		};

		colBtn.setCellFactory(cellFactory);

		table.getColumns().add(colBtn);

	}

	private void addLapButtonToTable() {
		TableColumn<Competitor, Void> colLap = new TableColumn("");

		Callback<TableColumn<Competitor, Void>, TableCell<Competitor, Void>> cellFactory = new Callback<TableColumn<Competitor, Void>, TableCell<Competitor, Void>>() {
			@Override
			public TableCell<Competitor, Void> call(final TableColumn<Competitor, Void> param) {
				final TableCell<Competitor, Void> cell = new TableCell<Competitor, Void>() {

					private final Button btnLap = new Button("Lap");

					{
						btnLap.setOnAction((ActionEvent event) -> {

							Competitor competitor = getTableView().getItems().get(getIndex());
							
							if (competitor.getStopButtonPressed() == false
									&& competitor.getLapButtonPressed() == false) {

								mainTime.setTimerTid();
								competitor.setLapTime(mainTime.getTimerTid());
								table.refresh();
								competitor.setLapButtonPressed(true);
								table.refresh();
							}

						});
					}

					@Override
					public void updateItem(Void item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
						} else {
							setGraphic(btnLap);
						}
					}
				};
				return cell;
			}
		};

		colLap.setCellFactory(cellFactory);

		table.getColumns().add(colLap);

	}

}
