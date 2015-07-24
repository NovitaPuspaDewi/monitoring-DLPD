package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.List;

public final class data_002dtidak_002dbeli_002dtoken_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/menubar-admin.jsp");
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("   <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Data PPTBT > 3 Bulan</title>\n");
      out.write("        <link href=\"semantic/packaged/css/semantic.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"img/logo_PLN.jpg\" type=\"image/jpg\">\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color:#CD5C5C\">\n");
      out.write("        <!--Menu bar-->\n");
      out.write("        ");
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
      out.write("                <a class=\"item\" id=\"tambah-user\" href=\"tambah-user.jsp\">\n");
      out.write("                    <i class=\"user icon\"></i>TAMBAH USER\n");
      out.write("                </a>\n");
      out.write("                <div class=\"ui pointing dropdown link item\">\n");
      out.write("                    <i class=\"search icon\"></i> LIHAT DATA <i class=\"dropdown icon\"></i>\n");
      out.write("                    <div class=\"menu\">\n");
      out.write("                        <a class=\"item\" id=\"kwh0\" href=\"data-kwh-0.jsp\"><i class=\"archive icon\"></i>Pelanggan Kwh 0</a>\n");
      out.write("                        <a class=\"item\" id=\"kwhmaks\" href=\"data-kwh-maks.jsp\"><i class=\"archive icon\"></i>Pelanggan Kwh Maks</a>\n");
      out.write("                        <a class=\"item\" id=\"tidak-beli-token\" href=\"data-tidak-beli-token.jsp\"><i class=\"archive icon\"></i>Tidak Beli Token > 3 bulan</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <a class=\"ui dropdown item\" id=\"hybrid\">\n");
      out.write("                    <i class=\"add icon\"></i> MONITORING <i class=\"dropdown icon\"></i>\n");
      out.write("                    <div class=\"menu\">\n");
      out.write("                        <div class=\"item\">\n");
      out.write("                            <i class=\"dropdown icon\" id=\"hybrid1\"></i>\n");
      out.write("                            <span class=\"text\">Kwh 0</span>\n");
      out.write("                            <div class=\"menu\">\n");
      out.write("                                <div class=\"item\">Sudah Cek</div>\n");
      out.write("                                <div class=\"item\">Belum Cek</div>\n");
      out.write("                                <div class=\"item\">Cek Berdasarkan Waktu</div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"item\">\n");
      out.write("                            <i class=\"dropdown icon\" id=\"hybrid2\"></i>\n");
      out.write("                            <span class=\"text\">Kwh Maks</span>\n");
      out.write("                            <div class=\"menu\">\n");
      out.write("                                <div class=\"item\">Sudah Cek</div>\n");
      out.write("                                <div class=\"item\">Belum Cek</div>\n");
      out.write("                                <div class=\"item\">Cek Berdasarkan Waktu</div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"item\">\n");
      out.write("                            <i class=\"dropdown icon\" id=\"hybrid3\"></i>\n");
      out.write("                            <span class=\"text\">Tidak Beli Token</span>\n");
      out.write("                            <div class=\"menu\">\n");
      out.write("                                <div class=\"item\">Sudah Cek</div>\n");
      out.write("                                <div class=\"item\">Belum Cek</div>\n");
      out.write("                                <div class=\"item\">Cek Berdasarkan Waktu</div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </a>\n");
      out.write("                <a class=\"item\" id=\"cari-pelanggan\" href=\"cari-pelanggan.jsp\">\n");
      out.write("                    <i class=\"search icon\"></i>LIHAT DETAIL PELANGGAN\n");
      out.write("                </a>\n");
      out.write("                <div class=\"right menu\">\n");
      out.write("                    <form method=\"POST\">\n");
      out.write("                        <div class=\"ui floating dropdown link item\">\n");
      out.write("                            <i class=\"desktop icon\"></i> ADMIN <i class=\"dropdown icon\"></i>\n");
      out.write("                            <div class=\"menu\">\n");
      out.write("                                <div class=\"header\">\n");
      out.write("                                    Logged as\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"divider\"></div>\n");
      out.write("                                <div class=\"item\">\n");
      out.write("                                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"item\">\n");
      out.write("                                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <a class=\"item\" href=\"Login.jsp?logout=yes\"><i class=\"sign out icon\"></i>Logout</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
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
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <!--End of Menu bar-->\n");
      out.write("       \n");
      out.write("            <div class=\"column\">\n");
      out.write("                <div class=\"ui fluid form segment\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"ten wide column\">\n");
      out.write("                            <h4 class=\"ui top attached center aligned inverted red block header\">\n");
      out.write("                                DATA PPTBT > 3 BULAN\n");
      out.write("                            </h4>\n");
      out.write("                            <table class=\"ui padded table segment attached\" id=\"filmTable\">\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th>BLTH</th>\n");
      out.write("                                        <th>ID PELANGGAN</th>\n");
      out.write("                                        <th>NAMA</th>\n");
      out.write("                                        <th>ALAMAT</th>\n");
      out.write("                                        <th>TARIF</th>\n");
      out.write("                                        <th>DAYA</th> \n");
      out.write("                                        <th>KWH MAKS</th>\n");
      out.write("                                        <th>TOTAL KWH</th>\n");
      out.write("                                        <th>STATUS MONITORING</th>\n");
      out.write("                                        <th>LIHAT DETAIL</th>\n");
      out.write("                                    </tr>\n");
      out.write("                                </thead>\n");
      out.write("                                <tbody>\n");
      out.write("                                    ");
                                        
                                        for (int i = 0; i < 10; i++) {
                                    
      out.write("\n");
      out.write("                                    \n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>201501</td>\n");
      out.write("                                        <td>22500234590</td>\n");
      out.write("                                        <td>JUNADI</td>\n");
      out.write("                                        <td>JL.PATIH RUMBIH 20</td>\n");
      out.write("                                        <td>R1T</td>\n");
      out.write("                                        <td>900</td>\n");
      out.write("                                        <td>");
      out.print(200);
      out.write("</td>\n");
      out.write("                                        <td>780</td>\n");
      out.write("                                        <td>BELUM MONITOR</td>\n");
      out.write("                                        <td><center><input class=\"ui tiny red button\" type=\"submit\" value=\"DETAIL\" name=\"commit\"></center></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>201501</td>\n");
      out.write("                                        <td>22500234596</td>\n");
      out.write("                                        <td>AMINUDIN</td>\n");
      out.write("                                        <td>JL.KASTURI GG.4</td>\n");
      out.write("                                        <td>R1T</td>\n");
      out.write("                                        <td>450</td>\n");
      out.write("                                        <td>");
      out.print(440);
      out.write("</td>\n");
      out.write("                                        <td>570</td>\n");
      out.write("                                        <td>SUDAH MONITOR</td>\n");
      out.write("                                        <td><center><input class=\"ui tiny red button\" type=\"submit\" value=\"DETAIL\" name=\"commit\"></center></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    ");
 }
      out.write("\n");
      out.write("\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("               \n");
      out.write("        <!--Script-->\n");
      out.write("        <script src=\"Semantic-UI-1.0.0/dist/jquery-2.1.1.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"Semantic-UI-1.0.0/dist/semantic.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"date/jquery.plugin.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"date/jquery.datepick.js\" type=\"text/javascript\"></script>\n");
      out.write("        <!--Local Script-->\n");
      out.write("       \n");
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
