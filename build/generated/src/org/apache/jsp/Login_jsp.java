package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.DataPegawai;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/menubar-home.jsp");
  }

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
      out.write("    ");


        if (null != request.getParameter("commit")) {
            session = request.getSession(true);
            session.setMaxInactiveInterval(60 * 60 * 24);
                        
            int login = DataPegawai.validateLoginCredential(request.getParameter("username"), request.getParameter("password"),request.getParameter("commit"));
            switch (login) {
                case 0:
                    out.print("<script type=\"text/javascript\">");
                    out.print("alert(\"Unregistered username\");");
                    out.print("</script>");
                    break;
                case 1:
                    out.print("<script type=\"text/javascript\">");
                    out.print("alert(\"Username or Password or Role was incorrect\");");
                    out.print("</script>");
                    break;
                case 2:
                    session.setAttribute("role", "Operator");
                    session.setAttribute("name", request.getParameter("username"));
                    session.setAttribute("username", request.getParameter("username"));
                    response.sendRedirect("menubar-operator.jsp");
                    break;
                case 3:
                    session.setAttribute("role", "Admin");
                    session.setAttribute("name", request.getParameter("username"));
                    session.setAttribute("username", request.getParameter("username"));
                    response.sendRedirect("menubar-admin.jsp");
                    break;
                default:
                    System.err.println("ENTER DEFAULT");
                    break;
            }
        }
    
      out.write("\n");
      out.write("   \n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>LOGIN ADMINISTRATOR</title>\n");
      out.write("        <link rel=\"shortcut icon\" href=\"img/logo_PLN.jpg\" type=\"image/jpg\">\n");
      out.write("        <link href=\"Semantic-UI-1.0.0/dist/semantic.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--Menu bar-->\n");
      out.write("        <div class=\"ui fixed top red inverted menu\">\n");
      out.write("            ");
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
      out.write("        <div class=\"container\">\n");
      out.write("            <a class=\"item\" id=\"home\" href=\"home.jsp\">\n");
      out.write("                <i class=\"home icon\"></i> HOME\n");
      out.write("            </a>\n");
      out.write("            <a class=\"item\" id=\"np\" href=\"login-operator.jsp\">\n");
      out.write("                <i class=\"user icon\"></i> OPERATOR\n");
      out.write("            </a>\n");
      out.write("            <a class=\"item\" id=\"signin\" href=\"Login.jsp\">\n");
      out.write("                <i class=\"user icon\"></i> ADMIN\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"Semantic-UI-1.0.0/dist/jquery-2.1.1.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"Semantic-UI-1.0.0/dist/semantic.js\" type=\"text/javascript\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!--End of Menu bar-->\n");
      out.write("\n");
      out.write("        <div class=\"ui one column page grid\">\n");
      out.write("            <div class=\"column\">\n");
      out.write("                <div class=\"ui info message\">\n");
      out.write("                    <div class=\"header\">\n");
      out.write("                        You have to sign in\n");
      out.write("                    </div>\n");
      out.write("                    <p>\n");
      out.write("                        Isi form dengan User ID dan Password anda jika anda sudah terdaftar sebagai user\n");
      out.write("                        kemudian tekan tombol ADMIN. <br>\n");
      out.write("                        Untuk informasi lebih lanjut, jika tidak terdaftar Anda dapat menghubungi administrator kami, terimakasih.\n");
      out.write("\n");
      out.write("                    </p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"ui three column page grid\">\n");
      out.write("            <div class=\"column\"></div>\n");
      out.write("            <div class=\"column\">\n");
      out.write("                <h4 class=\"ui top center aligned attached inverted red block header\">\n");
      out.write("                    LOGIN\n");
      out.write("                </h4>\n");
      out.write("                <form class=\"ui form segment attached\" method=\"POST\" id=\"mtixSignin\">\n");
      out.write("                    <div class=\"field\">\n");
      out.write("                        <div class=\"ui left icon input\">\n");
      out.write("                            <input name=\"username\" type=\"text\" placeholder=\"Username\">\n");
      out.write("                            <i class=\"user icon\"></i>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"field\">\n");
      out.write("                        <div class=\"ui left icon input\">\n");
      out.write("                            <input name=\"password\" type=\"password\" placeholder=\"Password\">\n");
      out.write("                            <i class=\"lock icon\"></i>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"field\">\n");
      out.write("                        <center><input class=\"ui tiny red button\" type=\"submit\" value=\"ADMIN\" name=\"commit\"></center>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"column\"></div>\n");
      out.write("        </div>\n");
      out.write("        <!--Script-->\n");
      out.write("        <script src=\"Semantic-UI-1.0.0/dist/jquery-2.1.1.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"Semantic-UI-1.0.0/dist/semantic.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            //Reset login sidebar value when reload\n");
      out.write("//            var originalState = $('#mtixSignin').clone();\n");
      out.write("//            $('#mtixSignin').replaceWith(originalState);\n");
      out.write("\n");
      out.write("            $(document).ready(function() {\n");
      out.write("                $(document.getElementById(\"signin\")).addClass(\"active\");\n");
      out.write("                $(document.getElementById(\"right\")).remove();\n");
      out.write("                $(\"#mtixSignin\").form({\n");
      out.write("                    username: {\n");
      out.write("                        identifier: 'username',\n");
      out.write("                        rules: [\n");
      out.write("                            {\n");
      out.write("                                type: 'empty',\n");
      out.write("                                prompt: 'Masukkan username'\n");
      out.write("                            }\n");
      out.write("                        ]\n");
      out.write("                    },\n");
      out.write("                    password: {\n");
      out.write("                        identifier: 'password',\n");
      out.write("                        rules: [\n");
      out.write("                            {\n");
      out.write("                                type: 'empty',\n");
      out.write("                                prompt: 'Masukkan password'\n");
      out.write("                            }\n");
      out.write("                        ]\n");
      out.write("                    }\n");
      out.write("                }, {\n");
      out.write("                    on: 'submit',\n");
      out.write("                    inline: 'true'\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
