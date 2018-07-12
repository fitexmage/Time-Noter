/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timenoter.util;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author fitexmage
 */
public class Message {
    
    public static void setMessage(Stage theStage, String header){
        Alert theAlert = new Alert(Alert.AlertType.INFORMATION);
        theAlert.setTitle("Messege");
        theAlert.setHeaderText(header);
        theAlert.initOwner(theStage);
        theAlert.show();
    }
}
