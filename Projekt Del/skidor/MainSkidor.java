package skidor;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainSkidor extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        MenyFlikar first = new MenyFlikar();
    	first.show();
    }

}

