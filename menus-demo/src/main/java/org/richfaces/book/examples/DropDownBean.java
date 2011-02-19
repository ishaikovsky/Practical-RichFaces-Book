package org.richfaces.book.examples;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@RequestScoped
public class DropDownBean {

    private String menuSelected;

    public String getMenuSelected() {
        return menuSelected;
    }

    public DropDownBean() {
    }

    public void listenerNew(ActionEvent event) {
        menuSelected = "New";
    }

    public void listenerOpenFile(ActionEvent event) {
        menuSelected = "Open File...";
    }

    public void listenerClose(ActionEvent event) {
        menuSelected = "Close";
    }

    public void listenerCloseAll(ActionEvent event) {
        menuSelected = "Close All";
    }

    public void listenerUndo(ActionEvent event) {
        menuSelected = "Undo";
    }
}
