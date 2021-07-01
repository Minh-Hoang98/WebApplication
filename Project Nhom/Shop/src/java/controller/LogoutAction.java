/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.Customer;
import org.apache.struts2.dispatcher.SessionMap;

/**
 *
 * @author Asus
 */
public class LogoutAction extends ActionSupport {
    private String fName;
    public LogoutAction() {
    }
    
    public String execute() throws Exception {
        SessionMap ss=((SessionMap)ActionContext.getContext().getSession());
        Customer c=((Customer)ss.get("CUST"));
        if(c==null) return "login";
        fName=c.getCustFName()+" "+c.getCustLName();
        ss.invalidate();
      return "success";
    }
    
    public String getMessage(){
        return "Bye bye "+fName+"..";
    }

}

