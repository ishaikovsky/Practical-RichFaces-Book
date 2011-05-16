package org.richfaces.book.examples;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.richfaces.event.DropEvent;

@ManagedBean
@SessionScoped
public class ShoppingCartBean {
    public List<String> items;
    public List<String> cartItems;
    
    public void processDrop(DropEvent event){
        String dragValue = (String)event.getDragValue();
        cartItems.add(dragValue);
        items.remove(dragValue);
        System.out.println("ShoppingCartBean.processDrop()" + items.size());
        System.out.println("ShoppingCartBean.processDrop()" + cartItems.size());
    }
    
    public String getProductsCount(){
        return cartItems.size() + " products in cart";
    }
    
    public ShoppingCartBean() {
        items = new ArrayList<String>();
        cartItems = new ArrayList<String>();
        items.add("item 1");
        items.add("item 2");
        items.add("item 3");
        items.add("item 4");
        items.add("item 5");
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
    
    public List<String> getCartItems() {
        return cartItems;
    }
    
    public void setCartItems(List<String> cartItems) {
        this.cartItems = cartItems;
    }

}
