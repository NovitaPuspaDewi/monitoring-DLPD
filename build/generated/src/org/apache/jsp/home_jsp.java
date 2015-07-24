package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("        <title>SIMON MANOLTOK</title>\n");
      out.write("        <link rel=\"shortcut icon\" href=\"img/logo_PLN.jpg\" type=\"image/jpg\">\n");
      out.write("        <link href=\"Semantic-UI-1.0.0/dist/semantic.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <link href=\"bxslider/jquery.bxslider.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"pusher\">\n");
      out.write("            <!--Menu bar-->\n");
      out.write("            <div class=\"ui fixed top red inverted menu\">\n");
      out.write("                ");
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
      out.write("            <a class=\"item\" id=\"signin\" href=\"dashboard.jsp\">\n");
      out.write("                <i class=\"edit icon\"></i> DASHBOARD\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"Semantic-UI-1.0.0/dist/jquery-2.1.1.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"Semantic-UI-1.0.0/dist/semantic.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function() {\n");
      out.write("                $('.ui.dropdown').dropdown({on: 'hover'});\n");
      out.write("                $('.example .menu .browse')\n");
      out.write("                .popup({\n");
      out.write("                    inline   : true,\n");
      out.write("                    hoverable: true,\n");
      out.write("                    position : 'bottom left',\n");
      out.write("                    delay: {\n");
      out.write("                        show: 300,\n");
      out.write("                        hide: 800\n");
      out.write("                    }\n");
      out.write("                })\n");
      out.write("                ;\n");
      out.write("                $('.activating.element')\n");
      out.write("                .popup()\n");
      out.write("                ;\n");
      out.write("                                         \n");
      out.write("                \n");
      out.write("            });\n");
      out.write("            \n");
      out.write("           \n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!--End of Menu bar-->\n");
      out.write("\n");
      out.write("            <!--Main body-->\n");
      out.write("            <div class=\"ui grid\">\n");
      out.write("                <div class=\"three wide column\">\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"ten wide column\">\n");
      out.write("                    <h2 class=\"ui top center aligned attached inverted red block header\">\n");
      out.write("                        <center>SIMON MANOLTOK<br><h4>SIstem MONitoring kwh MAks, kwh NOL, dan Pelanggan Prabayar Tidak Beli TOKen > 3 Bulan</h4></center>\n");
      out.write("                    </h2>\n");
      out.write("                    <div class=\"ui segment attached\">\n");
      out.write("                        <ul id=\"slider1\">\n");
      out.write("                            <li><img src=\"img/pln_tampak_depan.jpg\" alt=\"slide1\" title=\"PLN Area Kuala Kapuas\"></li>\n");
      out.write("                            <li><img src=\"img/pemeriksaan_gardu.jpg\" alt=\"slide2\" title=\"PLN Area Kuala Kapuas\"></li>\n");
      out.write("                            <li><img src=\"img/pembangkit.jpg\" alt=\"slide2\" title=\"PLN Area Kuala Kapuas\"></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>   \n");
      out.write("                    <h4 class=\"ui top center aligned attached inverted red block header\">\n");
      out.write("                        PLN Area Kuala Kapuas\n");
      out.write("                    </h4>\n");
      out.write("                    <div class=\"ui segment attached\">\n");
      out.write("                        <ul id=\"slider2\">\n");
      out.write("                            <li><img src=\"img/logo_PLN.jpg\" alt=\"slide1\"></li>\n");
      out.write("                            <li><img src=\"img/no_suap.jpg\" alt=\"slide2\" ></li>\n");
      out.write("                            <li><img src=\"img/listrik_pintar.jpg\" alt=\"slide2\" ></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"three wide column\">\n");
      out.write("                    <div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!--End of Main body-->\n");
      out.write("\n");
      out.write("            <!--Script-->\n");
      out.write("            <script src=\"Semantic-UI-1.0.0/dist/jquery-2.1.1.js\" type=\"text/javascript\"></script>\n");
      out.write("            <script src=\"bxslider/jquery.bxslider.js\" type=\"text/javascript\"></script>\n");
      out.write("            <script src=\"Semantic-UI-1.0.0/dist/semantic.js\" type=\"text/javascript\"></script>\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                $(document).ready(function() {\n");
      out.write("                    //Slideshow 1\n");
      out.write("                    $('#slider1').bxSlider({\n");
      out.write("                        speed: 1000, //transition speed\n");
      out.write("                        mode: 'horizontal', //transition mode\n");
      out.write("                        controls: false, //control prev, next\n");
      out.write("                        captions: true, //captions based on its title\n");
      out.write("                        auto: true, //auto slide\n");
      out.write("                        autoStart: true, //auto start when the page load\n");
      out.write("                        autoControls: false,\n");
      out.write("                        adaptiveHeight: true\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                    //Slideshow 2\n");
      out.write("                    $('#slider2').bxSlider({\n");
      out.write("                        speed: 1000,\n");
      out.write("                        auto: true,\n");
      out.write("                        controls: false,\n");
      out.write("                        autoStart: true,\n");
      out.write("                        autoControls: false,\n");
      out.write("                        captions: true,\n");
      out.write("                        slideWidth: 200,\n");
      out.write("                        minSlides: 4,\n");
      out.write("                        maxSlides: 4,\n");
      out.write("                        moveSlides: 1\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                });\n");
      out.write("            </script>\n");
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
