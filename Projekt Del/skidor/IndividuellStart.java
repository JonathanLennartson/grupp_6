package skidor;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
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

public class IndividuellStart {

	private final TableView<Competitor> table = new TableView<>();
	private final ObservableList<Competitor> tvObservableList = FXCollections.observableArrayList();
	private Thread startTimers;
	
	private ChronoMeter cM;
	private Task<Void> task;

	public void show() {

		Stage stage = new Stage();
		cM = new ChronoMeter();

		stage.setTitle("Xcountry skii race!!");
		stage.setWidth(600);
		stage.setHeight(600);

		Button startBtn = new Button("Start race");
		startBtn.setOnAction(e -> {
			cM.start();

			task = new Task<Void>() {
				
				public Void call() throws InterruptedException {					
					
					for (Competitor comp : XMLhandler.list) {						
						comp.startTimer();
						Thread.sleep(5000);
					}
					task.cancel();
					return null;
				}
			};
			
			startTimers = new Thread(task);			
			startTimers.start();
			
		});		

		Button stopBtn = new Button("Stoppa tävlingen");
		stopBtn.setOnAction(e -> {
			cM.stopp();
			cM.reset();			
			task.cancel();
			
			
		});

		setTableappearance();

		fillTableObservableListWithSampleData();
		table.setItems(tvObservableList);

		
		addLapButtonToTable();
		addButtonToTable();

		TableColumn<Competitor, Integer> colStartNr = new TableColumn<>("StartNumber");
		colStartNr.setCellValueFactory(new PropertyValueFactory<>("nr"));

		TableColumn<Competitor, String> colName = new TableColumn<>("Name");
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<Competitor, Integer> colLapTime = new TableColumn<>("Laptime");
		colLapTime.setCellValueFactory(new PropertyValueFactory<>("lapTime"));

		TableColumn<Competitor, String> colTime = new TableColumn<>("Time");
		colTime.setCellValueFactory(cellData -> cellData.getValue().getTimerProperty());

		table.getColumns().addAll(colStartNr, colName, colLapTime, colTime);

		HBox hBox = new HBox(20);
		hBox.getChildren().addAll(startBtn, stopBtn, cM);

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
			competitor.setTime("00:00.000");
		}

	}

	private void addButtonToTable() {
		TableColumn<Competitor, Void> colBtn = new TableColumn("Stop");

		Callback<TableColumn<Competitor, Void>, TableCell<Competitor, Void>> cellFactory = new Callback<TableColumn<Competitor, Void>, TableCell<Competitor, Void>>() {
			@Override
			public TableCell<Competitor, Void> call(final TableColumn<Competitor, Void> param) {
				final TableCell<Competitor, Void> cell = new TableCell<Competitor, Void>() {

					private final Button btn = new Button("Stop");

					{
						btn.setOnAction((ActionEvent event) -> {

							Competitor competitor = getTableView().getItems().get(getIndex());
							System.out.println("selectedData: " + competitor.getName());
							competitor.stopTimer();

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
		TableColumn<Competitor, Void> colLap = new TableColumn("Laptime");

		Callback<TableColumn<Competitor, Void>, TableCell<Competitor, Void>> cellFactory = new Callback<TableColumn<Competitor, Void>, TableCell<Competitor, Void>>() {
			@Override
			public TableCell<Competitor, Void> call(final TableColumn<Competitor, Void> param) {
				final TableCell<Competitor, Void> cell = new TableCell<Competitor, Void>() {

					private final Button btnLap = new Button("Lap");

					{
						btnLap.setOnAction((ActionEvent event) -> {
							Competitor competitor = getTableView().getItems().get(getIndex());
							System.out.println("selectedData: " + competitor);									
							table.getItems().add(competitor);
							
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
