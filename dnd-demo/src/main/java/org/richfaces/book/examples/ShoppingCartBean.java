package org.richfaces.book.examples;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.richfaces.book.examples.model.Product;
import org.richfaces.event.DropEvent;

@ManagedBean
@SessionScoped
public class ShoppingCartBean {
    public List<Product> items;
    public List<Product> cartItems;

    public void processDrop(DropEvent event) {
        Product dragValue = (Product)event.getDragValue();
        cartItems.add(dragValue);
        items.remove(dragValue);
    }
    public void processRemove(DropEvent event) {
        Product dragValue = (Product)event.getDragValue();
        cartItems.remove(dragValue);
        items.add(dragValue);
    }    

    public String getProductsCountString() {
        return cartItems.size() + " products in cart";
    }

    public ShoppingCartBean() {
        items = new ArrayList<Product>();
        cartItems = new ArrayList<Product>();
        items.add(new Product("Nikon D3100",
            "14.2MP Digital SLR Camera with 18-55mm f/3.5-5.6 AF-S DX VR Nikkor Zoom Lens", "nikon-d3100"));
        items.add(new Product("Canon Rebel XS",
            "10.1MP Digital SLR Camera with EF-S 18-55mm f/3.5-5.6 IS Lens (Black)", "canon-xs"));
        items.add(new Product("Nikon D7000", "16.2MP DX-Format CMOS Digital SLR with 3.0-Inch LCD (Body Only)",
            "nikon-d7000"));
        items.add(new Product("Canon EOS Rebel T3i",
            "18 MP CMOS Digital SLR Camera and DIGIC 4 Imaging with EF-S 18-55mm f/3.5-5.6 IS Lens", "canon-ti3"));
        items.add(new Product("Nikon D5100",
            "16.2MP CMOS Digital SLR Camera with 18-55mm f/3.5-5.6 AF-S DX VR Nikkor Zoom Lens", "nikon-d5100"));
        items.add(new Product("Sony a55", "DSLR Camera with 18-55mm zoom lens", "sony-a55"));
        items
            .add(new Product(
                "Panasonic LUMIX DMC-G3",
                "16 MP Micro Four-Thirds Interchangeable Lens Camera with 3-Inch Free-Angle Touch-Screen LCD and 14-42mm Lumix G VARIO f/3.5-5.6 Lens",
                "lumix-dmc-g3"));
        items
            .add(new Product("Pentax K-5", "16.3 MP Digital SLR with 18-55mm Lens and 3-Inch LCD (Black)", "pentax-k5"));
        items.add(new Product("Nikon D90",
            "12.3MP DX-Format CMOS Digital SLR Camera with 18-105mm f/3.5-5.6G ED AF-S VR DX Nikkor Zoom Lens",
            "nikon-d90"));
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Product> cartItems) {
        this.cartItems = cartItems;
    }

}
