

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

public class tambahFilm extends HttpServlet {

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
           
            FileItem id = (FileItem) items.get(0);
            String id_pel = id.getString();

            FileItem tgl = (FileItem) items.get(1);
            String tanggal = tgl.getString();

            // get uploaded file
            FileItem file = (FileItem) items.get(2);

            // Connect to Oracle
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mhs125314109", "mhs125314109");
            con.setAutoCommit(false);

            String sql = "UPDATE DPM SET foto=? WHERE IDPEL='" + id_pel + "' AND BLTH='" + tanggal + "'";

            PreparedStatement ps = con.prepareStatement(sql);
            // size must be converted to int otherwise it results in error
            ps.setBinaryStream(1, file.getInputStream(), (int) file.getSize());
          
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
