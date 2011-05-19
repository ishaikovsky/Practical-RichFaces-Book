package org.richfaces.book.examples.model;

import javax.faces.context.FacesContext;

public class Product {

    private static final String IMAGES_EXT = ".jpg";
    private static final String IMAGES_DIR = "/images/";
    private String title;
    private String description;
    private String img;

    public Product(String title, String description, String img) {
        super();
        this.title = title;
        this.description = description;
        this.img = img;
    }

    public String getIconURI() {
        return IMAGES_DIR + this.img
            + IMAGES_EXT;
    }

    public String getTitle() {
        return title;
    } 

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
