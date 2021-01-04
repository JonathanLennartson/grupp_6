package xCountrySkiingContest;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.stage.Stage;
import javafx.util.Callback;

public class MainTable {

    static TableView<Data> table;
    static ObservableList<Data> tvObservableList;

    @SuppressWarnings("unchecked")
	public static void show() {
        Stage stage = new Stage();
    	table = new TableView<>();
    	tvObservableList = FXCollections.observableArrayList();    	
    	
    	stage.setTitle("Skidtävling!!");
        stage.setWidth(600);
        stage.setHeight(600);

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPrefWidth(600);
        table.setPrefHeight(600);
        
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

        Scene scene = new Scene(new Group(table));
//        scene.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

//    private static void setTableappearance() {
//        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//        table.setPrefWidth(600);
//        table.setPrefHeight(600);
//    }

    private static void fillTableObservableListWithSampleData() {

//        tvObservableList.addAll(new Data(1, "Rosie Brennan"),
//                                new Data(2, "Tatiana Sorina"), 
//                                new Data(3, "Therese Johaug"), 
//                                new Data(4, "Natalia Nepryaeva"),
//                                new Data(5, "Nadine Fähndrich"),
//                                new Data(6, "Anamarija Lampic"),
//                                new Data(7, "Ebba Andersson"),
//                                new Data(8, "Jessica Diggins"),
//                                new Data(9, "Yulia Stupak"),
//                                new Data(10, "Frida Karlsson "));
    }

    private static void addButtonToTable() {
        @SuppressWarnings("unchecked")
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
    
    private static void addLapButtonToTable() {
        @SuppressWarnings("rawtypes")
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



