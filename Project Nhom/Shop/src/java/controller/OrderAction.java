package controller;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import model.Customer;
import model.Order;
import model.ShopCart;

public class OrderAction {
    
    private String payment;
    
    public OrderAction() {
    }
    
    public String execute() throws Exception {
        Map<String,Object> session=ActionContext.getContext().getSession();
        Customer c=(Customer)session.get("CUST");
        if(c==null) return "login";
        ShopCart cart=(ShopCart)session.get("cart");
        if(cart==null || cart.getCount()==0) return "shopping";
        Order order= new Order(cart,c.getCustNo(),payment);
        session.put("orders",order);
        order.saveDB(); session.remove("cart");
        return "success";
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
    
}
