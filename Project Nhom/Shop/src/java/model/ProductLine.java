
package model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductLine extends Product {
    private int quantity;

    public ProductLine() {
    }
//-----------------------------------------------------------------------------
    public ProductLine(Product p){
        this(1,p.getProductID(),p.getProductName(),p.getPrice(),p.getPic());
    }
//-----------------------------------------------------------------------------    
    public ProductLine(int quantity, int productID, String productName, double price,String pic) {
        super(productID, productName, price, pic);
        this.quantity = quantity;
    }
//-----------------------------------------------------------------------------
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getTotal(){
        return quantity*getPrice();
    }
}
