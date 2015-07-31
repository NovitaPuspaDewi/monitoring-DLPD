<%-- 
    Document   : newjsp
    Created on : Jun 26, 2015, 11:19:38 AM
    Author     : NOVITA
--%>

<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.net.ftp.FTPReply"%>
<%@page import="org.apache.commons.net.ftp.FTP"%>
<%@page import="java.io.InputStream"%>
<%@page import="org.apache.commons.net.ftp.FTPClient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%
        if (request.getParameter("commit") != null) {

            String hostName = "127.0.0.1";
            String username = "operator";
            String password = "14147";
            String location = "C:\\Users\\NOVITA\\Pictures\\harga2.JPG";

            String path = request.getParameter("file");
            session.setAttribute("path", path);

            FTPClient ftp = null;

            InputStream in = null;

            try {
                ftp = new FTPClient();
                ftp.connect(hostName);
                ftp.login(username, password);

                ftp.setFileType(FTP.BINARY_FILE_TYPE);

                //ftp.changeWorkingDirectory("D:/baru minta fi");

                int reply = ftp.getReplyCode();
                System.out.println("Received Reply from FTP Connection:" + reply);

                if (FTPReply.isPositiveCompletion(reply)) {
                    System.out.println("Connected Success");
                }

                File f1 = new File(location);
                in = new FileInputStream(f1);

                ftp.storeFile(request.getParameter("file").replace('r', 'a'), in);

                System.out.println("SUCCESS");

                ftp.logout();
                ftp.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    %>
    <head>
        <title>File Uploading Form</title>
    </head>
    <body>
        <h3>File Upload:</h3>
        Select a file to upload: <br />
        <form>
            <input type="file" name="file" size="50" id="file" />
            path : ${path}
            <br />
            <input type="submit" value="Upload File" name="commit" />
            <img src="ftp://user:admin14147@127.0.0.1/harga2.jpg">

            <br><br> kui lho dijajal sek !!
            <input type="file" id="i_file" value=""> 
            <input type="button" id="i_submit" value="Submit">
            <br>
            <img src="" width="200" style="display:none;" />
            <br>
            <div id="disp_tmp_path"></div>
        </form>

        <script type="text/javascript">
            $('#i_file').change( function(event) {
                var tmppath = URL.createObjectURL(event.target.files[0]);
                $("img").fadeIn("fast").attr('src',URL.createObjectURL(event.target.files[0]));

                $("#disp_tmp_path").html("Temporary Path(Copy it and try pasting it in browser address bar) --> <strong>["+tmppath+"]</strong>");
            });
        </script>
    </body>
</html>
