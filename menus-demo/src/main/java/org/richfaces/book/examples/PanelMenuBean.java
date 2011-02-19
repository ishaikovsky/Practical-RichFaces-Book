package org.richfaces.book.examples;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@RequestScoped
public class PanelMenuBean {

    private String menuSelected;

    public String getMenuSelected() {
        return menuSelected;
    }

    public PanelMenuBean() {
    }

    public void listenerNew(ActionEvent event) {
        menuSelected = "New";
    }

    public void listenerOpenFile(ActionEvent event) {
        menuSelected = "Open File...";
    }

    public void listenerSave(ActionEvent event) {
        menuSelected = "Save";
    }

    public void listenerSaveAll(ActionEvent event) {
        menuSelected = "Save All";
    }

    public void listenerFileGroup() {
        menuSelected = "File Group";
    }
}
 