package org.richfaces.book;

import java.io.Serializable;

public class RichBean implements Serializable {

    private static final long serialVersionUID = -2403138958014741653L;
    private String name;

    public RichBean() {
        System.out.println("post construct: initialize");
        name = "John";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
