package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.Product;
import model.ShopCart;

public class BuyProductAction extends ActionSupport {

    private int pid;
    
    public BuyProductAction() {
    }
    
    public String execute() throws Exception {
        ShopCart cart=(ShopCart)ActionContext.getContext().getSession().get("cart");
        cart.add(new Product(pid));
        return SUCCESS;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
    
}
