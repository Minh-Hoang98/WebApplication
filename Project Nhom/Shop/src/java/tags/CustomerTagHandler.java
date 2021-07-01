package tags;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import model.Customer;

public class CustomerTagHandler extends SimpleTagSupport {

    private int custNo;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        try {
            JspWriter out = getJspContext().getOut();
            Customer c= new Customer(custNo);
            out.print("<LI>"+custNo);
            out.print("<LI>"+c.getCustFName()+" "+c.getCustLName());
        } catch (IOException ex) {
            Logger.getLogger(CustomerTagHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

    public void setCustNo(int custNo) {
        this.custNo = custNo;
    }
    
}
