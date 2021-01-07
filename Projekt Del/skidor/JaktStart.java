package skidor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class JaktStart {
	
	private final TableView<Competitor> table = new TableView<>();
    private final ObservableList<Competitor> tvObservableList = FXCollections.observableArrayList();
    ChronoMeter cM;   
 
    public void show() {
    	
    	Stage stage = new Stage();
    	cM = new ChronoMeter();
    	
        stage.setTitle("Skidtävling!!");
        stage.setWidth(600);
        stage.setHeight(600);
        
        Button startBtn = new Button("Starta tävlingen");
		startBtn.setOnAction(e -> cM.start());

		Button stopBtn = new Button("Stoppa tävlingen");
		stopBtn.setOnAction(e -> {
        	cM.stopp();
        	cM.reset();
        });
		
        
        setTableappearance();

        fillTableObservableListWithSampleData();
        table.setItems(tvObservableList);
        
        addLapButtonToTable();
        addButtonToTable();        
        

        TableColumn<Competitor, Integer> colStartNr = new TableColumn<>("StartNummer");
        colStartNr.setCellValueFactory(new PropertyValueFactory<>("nr"));

        TableColumn<Competitor, String> colName = new TableColumn<>("Namn");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<Competitor, Integer> colLapTime = new TableColumn<>("Mellantid");
        colLapTime.setCellValueFactory(new PropertyValueFactory<>("lapTime"));
        
        TableColumn<Competitor, Integer> colTime = new TableColumn<>("Tid");
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        
        
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

        tvObservableList.addAll(new Competitor(1, "Rosie Brennan"),
                                new Competitor(2, "Tatiana Sorina"), 
                                new Competitor(3, "Therese Johaug"), 
                                new Competitor(4, "Natalia Nepryaeva"),
                                new Competitor(5, "Nadine Fähndrich"),
                                new Competitor(6, "Anamarija Lampic"),
                                new Competitor(7, "Ebba Andersson"),
                                new Competitor(8, "Jessica Diggins"),
                                new Competitor(9, "Yulia Stupak"),
                                new Competitor(10, "Frida Karlsson "));
    }

    private void addButtonToTable() {
        TableColumn<Competitor, Void> colBtn = new TableColumn("Start/Stopp");

        Callback<TableColumn<Competitor, Void>, TableCell<Competitor, Void>> cellFactory = new Callback<TableColumn<Competitor, Void>, TableCell<Competitor, Void>>() {
            @Override
            public TableCell<Competitor, Void> call(final TableColumn<Competitor, Void> param) {
                final TableCell<Competitor, Void> cell = new TableCell<Competitor, Void>() {

                    private final Button btn = new Button("Stop");
                    

                    {
                        btn.setOnAction((ActionEvent event) -> {
                        
                        	Competitor competitor = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + competitor);
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
        TableColumn<Competitor, Void> colLap = new TableColumn("Mellantid");

        Callback<TableColumn<Competitor, Void>, TableCell<Competitor, Void>> cellFactory = new Callback<TableColumn<Competitor, Void>, TableCell<Competitor, Void>>() {
            @Override
            public TableCell<Competitor, Void> call(final TableColumn<Competitor, Void> param) {
                final TableCell<Competitor, Void> cell = new TableCell<Competitor, Void>() {

                    private final Button btnLap = new Button("Lap");

                    {
                        btnLap.setOnAction((ActionEvent event) -> {
                        	Competitor competitor = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + competitor);
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



