
package model;

import java.io.Serializable;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Order extends ShopCart implements Serializable, DatabaseInfo{
    private int maDH, maKH;
    private Date ngayDH;
    private String payment;
    public Order(ShopCart c, int mkh, String pm){
        super(c);
        maKH=mkh;
        payment=pm;
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void saveDB(){
        int n[]=null;
        try(Connection con= DriverManager.getConnection(dbURL, userName, password)) {
            con.setAutoCommit(false);
            PreparedStatement stmt=con.prepareStatement("Insert into Orders(MaKH,TongTien,Status) output inserted.MaDH values(?,?,?)");
            stmt.setInt(1, maKH);
            stmt.setDouble(2, this.getTotal());
            stmt.setString(3,payment);
            ResultSet identities =   stmt.executeQuery();  
              identities.next();  
              maDH = identities.getInt(1); 
              stmt.close();
              stmt=con.prepareStatement("Insert into OrderDetail(madh,mahh,soluong,dongia,thanhtien) values(?,?,?,?,?)");
              for(ProductLine item:this.getCart()){
                  stmt.setInt(1, maDH);
                  stmt.setInt(2,item.getProductID());
                  stmt.setInt(3, item.getQuantity());
                  stmt.setDouble(4, item.getPrice());
                  stmt.setDouble(5, item.getTotal());
                  stmt.addBatch();
              }
              n=stmt.executeBatch();
              if(n.length==getCart().size()) con.commit();
              else con.rollback();
            
        } catch (Exception ex) {
            Logger.getLogger(ShopCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getMaDH() {
        return maDH;
    }

    public void setMaDH(int maDH) {
        this.maDH = maDH;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public Date getNgayDH() {
        return ngayDH;
    }

    public void setNgayDH(Date ngayDH) {
        this.ngayDH = ngayDH;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
    
}
