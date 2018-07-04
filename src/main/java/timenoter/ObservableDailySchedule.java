/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timenoter;

import java.util.Date;
import javafx.scene.control.Button;

/**
 *
 * @author fitexmage
 */
public class ObservableDailySchedule {
    private String scheduleName;
    private Date createTime;
    private Button detailButton;
    private Button useButton;
    private Button deleteButton;
    
    public ObservableDailySchedule(String scheduleName, Date createTime, Button detailButton, Button useButton, Button deleteButton){
        this.scheduleName = scheduleName;
        this.createTime = createTime;
        this.detailButton = detailButton;
        this.useButton = useButton;
        this.deleteButton = deleteButton;
    }

    /**
     * @return the scheduleName
     */
    public String getScheduleName() {
        return scheduleName;
    }

    /**
     * @param scheduleName the scheduleName to set
     */
    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the detailButton
     */
    public Button getDetailButton() {
        return detailButton;
    }

    /**
     * @param detailButton the detailButton to set
     */
    public void setDetailButton(Button detailButton) {
        this.detailButton = detailButton;
    }

    /**
     * @return the useButton
     */
    public Button getUseButton() {
        return useButton;
    }

    /**
     * @param useButton the useButton to set
     */
    public void setUseButton(Button useButton) {
        this.useButton = useButton;
    }

    /**
     * @return the deleteButton
     */
    public Button getDeleteButton() {
        return deleteButton;
    }

    /**
     * @param deleteButton the deleteButton to set
     */
    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }
}
