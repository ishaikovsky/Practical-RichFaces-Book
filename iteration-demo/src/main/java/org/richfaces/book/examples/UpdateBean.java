package org.richfaces.book.examples;

import java.util.HashSet;
import java.util.Set;

import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;

public class UpdateBean {

    HtmlInputText priceRef;
    private Set<Integer> keys = null;
    
    /**
     * @return the keys
     */
    public Set getKeys() {
        return keys;
    }

    /**
     * @param keys the keys to set
     */
    public void setKeys(Set keys) {
        this.keys = keys;
    }

    public HtmlInputText getPriceRef() {
        return priceRef;
    }

    public void setPriceRef(HtmlInputText priceRef) {
        this.priceRef = priceRef;
    }
    
    public String change(){
        
        HashSet keys = new HashSet<Integer>();
        int rowKey =0
        //= getRepeater().getRowIndex()
        ;
        keys.add(rowKey);
        setKeys(keys);
        priceRef.processValidators(FacesContext.getCurrentInstance());
        priceRef.processUpdates(FacesContext.getCurrentInstance());
        return null;
    }
}