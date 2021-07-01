
package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.DatabaseInfo.dbURL;
import static model.DatabaseInfo.userName;

public class Product implements DatabaseInfo, Serializable{
    private int productID;
    private String productName, pic;
    private double price;
//-----------------------------------------------------------------------------------------------
    public Product() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//-----------------------------------------------------------------------------------------------
    public Product(int pid){
        this();
        try {
            Connection con=DriverManager.getConnection(dbURL, userName, password);
            PreparedStatement stmt=con.prepareStatement("Select productName,UnitPrice,productPicture from Product where proID=?");
            stmt.setInt(1,pid);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                productID=pid;
                productName=rs.getString(1);
                price=rs.getDouble(2);
                pic=rs.getString(3);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//-----------------------------------------------------------------------------------------------    
    public Product(int productID, String productName, double price, String img) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        pic=img;
    }
//-----------------------------------------------------------------------------------------------
    public ArrayList<Product> getAll(){
        ArrayList<Product> list= new ArrayList<Product>();
        try {
            Connection con=DriverManager.getConnection(dbURL, userName, password);
            PreparedStatement stmt=con.prepareStatement("Select proID, productName,UnitPrice,productpicture from Product");
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                productID=rs.getInt(1);
                productName=rs.getString(2);
                price=rs.getDouble(3);
                pic=rs.getString(4);
                list.add(new Product(productID,productName,price,pic));
            }
            con.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
//-----------------------------------------------------------------------------------------------
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
    
//-----------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Product{" + "productID=" + getProductID() + ", productName=" + productName + ", price=" + price + '}';
    }
    
}
