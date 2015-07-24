package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menubar_002doperator_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"Semantic-UI-1.0.0/dist/semantic.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"img/logo_PLN.jpg\" type=\"image/jpg\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"ui fixed top menu\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"ui menu\">\n");
      out.write("                    <a class=\"browse item\">\n");
      out.write("                        Browse\n");
      out.write("                        <i class=\"dropdown icon\"></i>\n");
      out.write("                    </a>\n");
      out.write("                    <div class=\"ui fluid popup bottom left transition\" style=\"top: 554px; left: 1px; bottom: auto; right: auto; width: 671px;\">\n");
      out.write("                        <div class=\"ui four column relaxed divided grid\">\n");
      out.write("                            <div class=\"column\">\n");
      out.write("                                <h4 class=\"ui header\">Fabrics</h4>\n");
      out.write("                                <div class=\"ui link list\">\n");
      out.write("                                    <a class=\"item\">Cashmere</a>\n");
      out.write("                                    <a class=\"item\">Linen</a>\n");
      out.write("                                    <a class=\"item\">Cotton</a>\n");
      out.write("                                    <a class=\"item\">Viscose</a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"column\">\n");
      out.write("                                <h4 class=\"ui header\">Size</h4>\n");
      out.write("                                <div class=\"ui link list\">\n");
      out.write("                                    <a class=\"item\">Small</a>\n");
      out.write("                                    <a class=\"item\">Medium</a>\n");
      out.write("                                    <a class=\"item\">Large</a>\n");
      out.write("                                    <a class=\"item\">Plus Sizes</a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"column\">\n");
      out.write("                                <h4 class=\"ui header\">Colors</h4>\n");
      out.write("                                <div class=\"ui link list\">\n");
      out.write("                                    <a class=\"item\">Neutrals</a>\n");
      out.write("                                    <a class=\"item\">Brights</a>\n");
      out.write("                                    <a class=\"item\">Pastels</a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"column\">\n");
      out.write("                                <h4 class=\"ui header\">Types</h4>\n");
      out.write("                                <div class=\"ui link list\">\n");
      out.write("                                    <a class=\"item\">Knitwear</a>\n");
      out.write("                                    <a class=\"item\">Outerwear</a>\n");
      out.write("                                    <a class=\"item\">Pants</a>\n");
      out.write("                                    <a class=\"item\">Shoes</a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <a class=\"item\">\n");
      out.write("                        <i class=\"cart icon\"></i>\n");
      out.write("                        Checkout\n");
      out.write("                    </a>\n");
      out.write("                    <div class=\"right menu\">\n");
      out.write("                        <form method=\"POST\">\n");
      out.write("                            <div class=\"ui floating dropdown link item\">\n");
      out.write("                                <i class=\"desktop icon\"></i> OPERATOR <i class=\"dropdown icon\"></i>\n");
      out.write("                                <div class=\"menu\">\n");
      out.write("                                    <div class=\"header\">\n");
      out.write("                                        Logged as\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"divider\"></div>\n");
      out.write("                                    <div class=\"item\">\n");
      out.write("                                        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"item\">\n");
      out.write("                                        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <a class=\"item\" href=\"Login.jsp?logout=yes\"><i class=\"sign out icon\"></i>Logout</a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"Semantic-UI-1.0.0/dist/jquery-2.1.1.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"Semantic-UI-1.0.0/dist/semantic.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function() {\n");
      out.write("                $('.ui.dropdown').dropdown({on: 'hover'});\n");
      out.write("                                          \n");
      out.write("                $('#hybrid select')\n");
      out.write("                .dropdown({\n");
      out.write("                    on: 'hover'\n");
      out.write("                })\n");
      out.write("                ;\n");
      out.write("                \n");
      out.write("                $('#hybrid1 select')\n");
      out.write("                .dropdown({\n");
      out.write("                    on: 'hover'\n");
      out.write("                })\n");
      out.write("                ;\n");
      out.write("                \n");
      out.write("                $('#hybrid2 select')\n");
      out.write("                .dropdown({\n");
      out.write("                    on: 'hover'\n");
      out.write("                })\n");
      out.write("                ;\n");
      out.write("                \n");
      out.write("                $('#hybrid3 select')\n");
      out.write("                .dropdown({\n");
      out.write("                    on: 'hover'\n");
      out.write("                })\n");
      out.write("                ;\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            $('.example .menu .browse')\n");
      out.write("            .popup({\n");
      out.write("                inline   : true,\n");
      out.write("                hoverable: true,\n");
      out.write("                position : 'bottom left',\n");
      out.write("                delay: {\n");
      out.write("                    show: 300,\n");
      out.write("                    hide: 800\n");
      out.write("                }\n");
      out.write("            })\n");
      out.write("            ;\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
