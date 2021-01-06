package xCountrySkiingContest;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MainTable extends Application {

	private final TableView<Data> table = new TableView<>();
	private final ObservableList<Data> tvObservableList = FXCollections.observableArrayList();

	BorderPane jaktPane, massPane, individPane;
	Stage window;
	Scene mainScene, individScene, masScene, jaktScene;
	ComboBox<String> menu;
	Button selectMenuButton;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		window = primaryStage;

		menu = new ComboBox<>();
		menu.getItems().addAll("Individuell Start", "Masstart", "Jaktstart");
		menu.setPromptText("V‰lj Din Start-Typ");

		selectMenuButton = new Button("V‰lj");
		selectMenuButton.setOnAction(e -> menuButtonClicked());

		window.setTitle("Skidt√§vling!!");
		window.setWidth(600);
		window.setHeight(600);

		setTableappearance();

		fillTableObservableListWithSampleData();
		table.setItems(tvObservableList);

		addButtonToTable();

		addLapButtonToTable();

		TableColumn<Data, Integer> colId = new TableColumn<>("StartNummer");
		colId.setCellValueFactory(new PropertyValueFactory<>("id"));

		TableColumn<Data, String> colName = new TableColumn<>("Namn");
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<Data, Integer> colTime = new TableColumn<>("Tid");
		colId.setCellValueFactory(new PropertyValueFactory<>("id"));

		table.getColumns().addAll(colId, colName, colTime);

		BorderPane layout = new BorderPane();
		HBox menuLayout = new HBox(40);

		menuLayout.getChildren().addAll(menu, selectMenuButton);

		menuLayout.setPadding(new Insets(20, 20, 20, 20));
		layout.setTop(menuLayout);
		layout.setCenter(table);

		mainScene = new Scene(layout, 500, 200);
		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		});

		mainScene.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
		window.setScene(mainScene);
		window.show();
	}

	private void closeProgram() {
		Boolean answer = ConfirmBox.display("Confirm Exit", "Are you sure you want to exit? ");
		if (answer) {
			window.close();
		}
	}

	private void menuButtonClicked() {
		menu.getValue();
		if (menu.getValue() == "Individuell Start") {
			individuellStart();
		} else if (menu.getValue() == "Jaktstart") {
			jaktStart();
		} else if (menu.getValue() == "Masstart") {
			masStart();
		}
	}

	private void masStart() {

	}

	private void individuellStart() {

	}

	private void jaktStart() {

	}

	private void setTableappearance() {
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.setPrefWidth(600);
		table.setPrefHeight(600);
	}

	private void fillTableObservableListWithSampleData() {

		tvObservableList.addAll(new Data(1, "Rosie Brennan"), new Data(2, "Tatiana Sorina"),
				new Data(3, "Therese Johaug"), new Data(4, "Natalia Nepryaeva"), new Data(5, "Nadine F√§hndrich"),
				new Data(6, "Anamarija Lampic"), new Data(7, "Ebba Andersson"), new Data(8, "Jessica Diggins"),
				new Data(9, "Yulia Stupak"), new Data(10, "Frida Karlsson "));
	}

	private void addButtonToTable() {
		TableColumn<Data, Void> colBtn = new TableColumn("Start/Stopp");

		Callback<TableColumn<Data, Void>, TableCell<Data, Void>> cellFactory = new Callback<TableColumn<Data, Void>, TableCell<Data, Void>>() {
			@Override
			public TableCell<Data, Void> call(final TableColumn<Data, Void> param) {
				final TableCell<Data, Void> cell = new TableCell<Data, Void>() {

					private final Button btn = new Button("Start");

					{
						btn.setOnAction((ActionEvent event) -> {
							btn.setText("Stop");
							Data data = getTableView().getItems().get(getIndex());
							System.out.println("selectedData: " + data);
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
		TableColumn<Data, Void> colLap = new TableColumn("Mellantid");

		Callback<TableColumn<Data, Void>, TableCell<Data, Void>> cellFactory = new Callback<TableColumn<Data, Void>, TableCell<Data, Void>>() {
			@Override
			public TableCell<Data, Void> call(final TableColumn<Data, Void> param) {
				final TableCell<Data, Void> cell = new TableCell<Data, Void>() {

					private final Button btnLap = new Button("Lap");

					{
						btnLap.setOnAction((ActionEvent event) -> {
							Data data = getTableView().getItems().get(getIndex());
							System.out.println("selectedData: " + data);
							// TODO Chronometer for each cometitor.
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

	public class Data {

		private int id;
		private String name;

		private Data(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int ID) {
			this.id = ID;
		}

		public String getName() {
			return name;
		}

		public void setName(String nme) {
			this.name = nme;
		}

		@Override
		public String toString() {
			return "id: " + id + " - " + "name: " + name;
		}

	}

}
