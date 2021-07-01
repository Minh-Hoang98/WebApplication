package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.Customer;

public class LoginAction extends ActionSupport{

    private int custNo;
    private String password;
    
    public LoginAction() {
    }
    
    public String execute() throws Exception {
        if(password==null || password.equals("")) return "login";
        if(Customer.login(custNo, password)!=null){
            Customer c=new Customer(custNo);
            ActionContext.getContext().getSession().put("CUST", c);
            return SUCCESS;
        }
        return LOGIN;
    }

    public int getCustNo() {
        return custNo;
    }

    public void setCustNo(int custNo) {
        this.custNo = custNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getMessage(){
        return "Login success. Welcome "+custNo;
    }

    @Override
    public void validate() {
        if(password==null || password.equals("")) this.addFieldError("password","Password must be not empty..");
    }
    
}
