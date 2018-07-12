package timenoter;

import timenoter.model.User;
import timenoter.controller.NavCntl;
import timenoter.controller.LoginCntl;
import timenoter.model.Data;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fitexmage
 */
public class TimeNoter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Data.setTheData(new Data());
        LoginCntl.getTheLoginCntl(stage).setUpScene();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                if (User.getTheUser() != null) {
                    Data.getTheData().saveAll();
                    System.out.println("Save successfully!");
                    stage.close();
                    NavCntl.getTheNavCntl().recommendation.cancel();
                }
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
