package org.richfaces.book.examples.popuppanel;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class Bean {
    private String currentPage;
    public String getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }
    public void serviceAction(){
        //Business code
        FacesMessage message = new FacesMessage("Services Error. ","Sorry, you caught us doing maintance..");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
