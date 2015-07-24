

import Model.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.websocket.Session;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.jdbc.core.JdbcTemplate;

public class Tambah_KwhMaks1 extends HttpServlet {

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
}
