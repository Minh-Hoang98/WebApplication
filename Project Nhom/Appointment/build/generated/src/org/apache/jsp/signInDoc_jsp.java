package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signInDoc_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/include/header.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <title>Manager Hospital</title>\n");
      out.write("    </head>\n");
      out.write("    ");
 request.setCharacterEncoding("UTF-8");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\"><img src=\"image/hd.jpg\"></a>\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\" >\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"homePage.jsp\">Home <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"service.jsp\">Service</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"contact.jsp\">Contact Us</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Sign in</a>\n");
      out.write("                        <div class=\"dropdown-menu\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"signInDoc.jsp\">Sign in Doctor</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"signInPat.jsp\">Sign in Patient</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                            Login\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"loginDoc.jsp\">Login Doctor</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"loginPat.jsp\">Login Patient</a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"loginAdm.jsp\">Login Administrator</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <form class=\"form-inline my-2 my-lg-0\">\n");
      out.write("                    <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\n");
      out.write("                    <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Sign In Doctor</title>\n");
      out.write("    </head>\n");
      out.write("    <style> \n");
      out.write("        body {\n");
      out.write("            background-image: url(\"image/vinmec-pq.jpg\");\n");
      out.write("            background-repeat: no-repeat, repeat;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <center>\n");
      out.write("                <strong><h1>SIGN IN DOCTOR</h1></strong>\n");
      out.write("                <div class=\"col-8\">\n");
      out.write("                    <form action=\"signInDoc\" method=\"POST\" enctype=\"multipart/form-data\">\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"example-search-input\" class=\"col-2 col-form-label\">Name</label>\n");
      out.write("                            <div class=\"col-10\">\n");
      out.write("                                <input class=\"form-control\" type=\"text\"  id=\"example-search-input\" name=\"name\" required>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"example-search-input\" class=\"col-2 col-form-label\">Email</label>\n");
      out.write("                            <div class=\"col-10\">\n");
      out.write("                                <input class=\"form-control\" type=\"text\"  id=\"example-search-input\" name=\"email\" required>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"example-password-input\" class=\"col-2 col-form-label\">Password</label>\n");
      out.write("                            <div class=\"col-10\"> \n");
      out.write("                                <input class=\"form-control\" type=\"password\"  id=\"example-password-input\" name=\"password\" required>\n");
      out.write("                            </div>              \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"example-password-input\" class=\"col-2 col-form-label\">Choose Avatar</label>\n");
      out.write("                            <div class=\"col-10\"> \n");
      out.write("                                <input type=\"file\" class=\"form-control-file\" id=\"exampleFormControlFile1\" name=\"file\">\n");
      out.write("                            </div>              \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"example-password-input\" class=\"col-2 col-form-label\">Gender</label>\n");
      out.write("                            <div class=\"col-10\">\n");
      out.write("                                <select class=\"custom-select\" name=\"gender\" required>\n");
      out.write("                                    <option selected>Male</option>\n");
      out.write("                                    <option>Female</option>\n");
      out.write("                                    <option>Other</option>\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"example-date-input\" class=\"col-2 col-form-label\">Date of Birth</label>\n");
      out.write("                            <div class=\"col-10\">\n");
      out.write("                                <input class=\"form-control\" type=\"date\" id=\"example-date-input\" name=\"dob\"  required>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"example-password-input\" class=\"col-2 col-form-label\">Degree</label>\n");
      out.write("                            <div class=\"col-10\">\n");
      out.write("                                <select class=\"custom-select\" name=\"degree\" required>\n");
      out.write("                                    <option selected>MBA</option>\n");
      out.write("                                    <option>HAO</option>\n");
      out.write("                                    <option>CBA</option>\n");
      out.write("                                    <option>ODA</option>\n");
      out.write("                                    <option>PHD</option>\n");
      out.write("                                    <option>DHA</option>\n");
      out.write("                                    <option>WHO</option>\n");
      out.write("                                    <option>Other</option>\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"example-password-input\" class=\"col-2 col-form-label\">Department</label>\n");
      out.write("                            <div class=\"col-10\">\n");
      out.write("                                <select class=\"custom-select\" name=\"department\" required>\n");
      out.write("                                    <option selected>General surgery</option>\n");
      out.write("                                    <option>Cardiology</option>\n");
      out.write("                                    <option>Breast screening</option>\n");
      out.write("                                    <option>Chaplaincy</option>\n");
      out.write("                                    <option>Critical care</option>                                  \n");
      out.write("                                    <option>Gynaecology</option>\n");
      out.write("                                    <option>Gastroenterology</option>\n");
      out.write("                                    <option>Microbiology</option>\n");
      out.write("                                    <option>Haematology</option>\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                     \n");
      out.write("\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"example-tel-input\" class=\"col-2 col-form-label\">Contact</label>\n");
      out.write("                            <div class=\"col-10\">\n");
      out.write("                                <input class=\"form-control\" type=\"tel\" id=\"example-tel-input\" name=\"contact\" required>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"example-search-input\" class=\"col-2 col-form-label\">Address</label>\n");
      out.write("                            <div class=\"col-10\">\n");
      out.write("                                <input class=\"form-control\" type=\"text\"  id=\"example-search-input\" name=\"address\" required>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <div class=\"offset-sm-2 col-sm-10\">\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-primary\">Sign in</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>   \n");
      out.write("                </div>\n");
      out.write("            </center>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
