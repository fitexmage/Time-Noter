/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timenoter.model;

import javafx.scene.control.Button;

/**
 *
 * @author fitexmage
 */
public class ObservableFriend {
    
    private String name;
    private Button operation1;
    private Button operation2;
    
    public ObservableFriend(String name, Button operation1, Button operation2){
        this.name = name;
        this.operation1 = operation1;
        this.operation2 = operation2;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the operation1
     */
    public Button getOperation1() {
        return operation1;
    }

    /**
     * @param operation1 the operation1 to set
     */
    public void setOperation1(Button operation1) {
        this.operation1 = operation1;
    }

    /**
     * @return the operation2
     */
    public Button getOperation2() {
        return operation2;
    }

    /**
     * @param operation2 the operation2 to set
     */
    public void setOperation2(Button operation2) {
        this.operation2 = operation2;
    }
}
