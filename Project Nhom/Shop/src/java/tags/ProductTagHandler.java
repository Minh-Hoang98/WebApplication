package tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import model.Product;

public class ProductTagHandler extends SimpleTagSupport {

    private int pid;

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        if(pid>0){
            try {
                Product p=new Product(pid);
                out.print("<LI>"+pid);
                out.print("<LI>"+p.getProductName());
                out.print("<LI>"+p.getPrice());
            } catch (IOException ex) {
                Logger.getLogger(ProductTagHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
                ArrayList<Product> list=new Product().getAll();
            try {
                out.print("<LI>There are total "+list.size()+" products.");
            } catch (IOException ex) {
                Logger.getLogger(ProductTagHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
        
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
    
}
