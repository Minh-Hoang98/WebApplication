
package model;

import java.io.Serializable;
import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Customer implements DatabaseInfo, Serializable {
    private String custFName, custLName, pass;
    private int custNo;
    

    public Customer() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Customer(int cno){
        this();
        try {
            Connection con=DriverManager.getConnection(dbURL, userName, password);
            PreparedStatement stmt=con.prepareStatement("Select custFname,custLname,password from Customer where custNo=?");
            stmt.setInt(1,cno);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                custNo=cno;
                custFName=rs.getString(1);
                custLName=rs.getString(2);
                pass=rs.getString(3);
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Customer login(int cno, String pass){
        Customer c= new Customer(cno);
        if(c.pass.equals(pass)) return c;
        return null;
    }
    
    public Customer(int custNo, String custFName, String custLName, String password) {
        this.custNo = custNo;
        this.custFName = custFName;
        this.custLName = custLName;
        this.pass = password;
    }

    
    public int getCustNo() {
        return custNo;
    }

    public void setCustNo(int custNo) {
        this.custNo = custNo;
    }

    public String getCustFName() {
        return custFName;
    }

    public void setCustFName(String custFName) {
        this.custFName = custFName;
    }

    public String getCustLName() {
        return custLName;
    }

    public void setCustLName(String custLName) {
        this.custLName = custLName;
    }

    public String getPassword() {
        return pass;
    }

    public void setPassword(String password) {
        this.pass = password;
    }
    
    
    @Override
    public String toString() {
        return custNo + " : " + custFName+" "+custLName;
    }
    public static void main(String[] a){
        System.out.println(new Customer(32));
    } 
}
