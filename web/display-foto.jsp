<%-- 
    Document   : data-kwh-0
    Created on : Jun 29, 2015, 1:42:41 PM
    Author     : NOVITA
--%>

<%@page import="Model.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String link = session.getAttribute("link1").toString();
        String id1 = session.getAttribute("id_blth").toString();
        String id2 = session.getAttribute("id_blth").toString();

        String blth = id1.substring(0, 6);
        String idpel = id2.substring(6);
        String foto = null;

        List<Display_Foto> kendaraanList = Display_Foto.getFoto_Dpm(blth, idpel);
        for (int i = 0; i < kendaraanList.size(); i++) {
            foto = kendaraanList.get(i).getmFoto();
        }

        if (null != request.getParameter("kembali")) {
            response.sendRedirect(link);
        }
    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Foto</title>
        <link href="semantic/packaged/css/semantic.css" rel="stylesheet" type="text/css">
        <link rel="shortcut icon" href="img/logo_PLN.jpg" type="image/jpg">
    </head>
    <body style="background-color:#CD5C5C">
        <div class="ui one column page grid">
            <div class="field">
                <form>
                    <center>
                        <h3>Idpel : <i><%=idpel%></i> Blth : <i><%=blth%></i> </h3>
                        <img class="ui fluid image" src="<%=foto%>">
                        <br><br>
                        <input class="ui tiny blue button" type="submit" value="KEMBALI" name="kembali">
                    </center>
                </form>
            </div>                      
        </div>
        <!--Script-->
        <script src="Semantic-UI-1.0.0/dist/jquery-2.1.1.js" type="text/javascript"></script>
        <script src="Semantic-UI-1.0.0/dist/semantic.js" type="text/javascript"></script>
        <script src="date/jquery.plugin.js" type="text/javascript"></script>
        <script src="date/jquery.datepick.js" type="text/javascript"></script>
        <!--Local Script-->

    </body>
</html>