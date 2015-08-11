
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import Model.Approve;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.catalina.Session;

@WebServlet("/uploadHandlerTBT")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class uploadHandlerTBT extends HttpServlet {

    /**
     * Name of the directory where uploaded files will be saved, relative to the
     * web application directory.
     */
    private static final String SAVE_DIR = "img";

    /**
     * handles file upload
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        // String savePath = appPath + File.separator + SAVE_DIR;

        String savePath = "D:\\novita\\bahan ajar kuliah\\MONITORING\\MONITORING - Copy\\web\\" + SAVE_DIR;

        String fileName = null;

        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        for (Part part : request.getParts()) {
            fileName = extractFileName(part);
            part.write(savePath + File.separator + fileName);
        }

        String id = request.getSession().getAttribute("id_blth").toString();
        String link = request.getSession().getAttribute("link").toString();
        
        String blth = id.substring(0, 6);
        String idpel = id.substring(6);

        Approve app = new Approve();
        app.setmFoto(SAVE_DIR + "/" + fileName);
        app.setmIdpel(idpel);
        app.setmBlth(blth);

        Approve.simpan_foto_tbt(app);

        request.setAttribute("message", "Upload has been done successfully!");
        request.setAttribute("fileName", SAVE_DIR + "/" + fileName);
//        getServletContext().getRequestDispatcher("/result.jsp").forward(
//                request, response);
        out.print("<script>");
        out.print("alert(\"Data monitoring berhasil diupload\");");
        out.print("window.location = '"+link+"';");
        out.print("</script>");
    }

    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}