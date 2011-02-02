package org.richfaces.book.examples.tabpanel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped
public class CityTabBean {

    private String city = "sf";

    private String selectedTab = "sf";

    public void changeCity(ValueChangeEvent event) {

        selectedTab = (String)event.getNewValue();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSelectedTab() {
        return selectedTab;
    }

    public void setSelectedTab(String selectedTab) {
        this.selectedTab = selectedTab;
    }
}