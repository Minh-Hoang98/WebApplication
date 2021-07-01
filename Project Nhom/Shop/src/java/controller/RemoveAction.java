package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import model.ShopCart;

public class RemoveAction extends ActionSupport {

    private int pid;
    
    public RemoveAction() {
    }
    
    public String execute() throws Exception {
        Map<String,Object> session=ActionContext.getContext().getSession();
        ShopCart sc=(ShopCart)session.get("cart");
        sc.remove(pid);
        return SUCCESS;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
    
}
