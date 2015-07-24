/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author NOVITA
 */
@WebServlet(name = "Tambah_KwhMaks", urlPatterns = {"/Tambah_KwhMaks"})
public class Tambah_KwhMaks extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            DataSource dataSource = DatabaseConnection.getmDataSource();
            Connection con = DatabaseConnection.getmConnection();
//            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            // Apache Commons-Fileupload library classes
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload sfu = new ServletFileUpload(factory);

            if (!ServletFileUpload.isMultipartContent(request)) {
                System.out.println("sorry. No file uploaded");
                return;
            }

            // parse request
            List items = sfu.parseRequest(request);
//            FileItem id = (FileItem) items.get(0);
//            String idfilm = id.getString();

            FileItem blth = (FileItem) items.get(7);
            String blth_1 = blth.getString();

            FileItem koordinat = (FileItem) items.get(8);
            String koordinat_1 = koordinat.getString();

            FileItem verifikasi = (FileItem) items.get(9);
            String verifikasi_1 = verifikasi.getString();

            FileItem tgl_monitor = (FileItem) items.get(10);
            String tgl = tgl_monitor.getString();

            FileItem idpel = (FileItem) items.get(0);
            String idpel_1 = idpel.getString();

            // get uploaded file
            FileItem file = (FileItem) items.get(11);

            // Connect to Oracle
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mhs125314109", "mhs125314109");
            con.setAutoCommit(false);

            String sql = "UPDATE DPM SET KOORDINAT=?, STATUS MONITORING='SUDAH MONITOR',"
                    + " VERIFIKASI=?, FOTO=?, TGL_MONITOR=? WHERE IDPEL='" + idpel_1 + "' AND BLTH='" + blth_1 + "'";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, koordinat_1);
            ps.setString(2, verifikasi_1);
            // size must be converted to int otherwise it results in error
            ps.setBinaryStream(3, file.getInputStream(), (int) file.getSize());
            ps.setString(4, tgl);

            // jdbcTemplate.update(sql, ps);
            ps.executeUpdate();
            con.commit();
            con.close();
//            out.println("Proto Added Successfully. <p> <a href='ListPhotosServlet'>List Photos </a>");
            out.print("<script>");
            out.print("alert(\"Data kwh maks berhasil ditambahkan\");");
            out.print("window.location = 'kwh-maks-belum-cek.jsp';");
            out.print("</script>");
        } catch (Exception ex) {
            out.println("Error --> " + ex.getMessage());
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
