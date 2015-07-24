<%-- 
    Document   : tambah-user
    Created on : Nov 9, 2014, 6:23:30 PM
    Author     : NOVITA
--%>

<%@page import="Model.DataPegawai"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%
        String idpel = session.getAttribute("id").toString();
        String blth = session.getAttribute("blth").toString();
        String id_blth = blth + idpel;

        if (request.getParameter("submit") != null) {
            session.setAttribute("id_blth", id_blth);
            response.sendRedirect("kwh-maks-belum-cek.jsp");
        }

        if (request.getParameter("commit") != null) {
            session.removeAttribute("id");
            session.removeAttribute("blth");
            response.sendRedirect("data-approve-semua-kwh-maks.jsp");
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gagal Approve</title>
        <link href="semantic/packaged/css/semantic.css" rel="stylesheet" type="text/css">
        <link rel="shortcut icon" href="img/logo_PLN.jpg" type="image/jpg">
    </head>
    <body>
        <!--Menu bar-->
        <%@include file="menubar-admin.jsp" %>
        <br>
        <br>
        <br>
        <!--End of Menu bar-->

        <div class="ui form error">
            <div class="ui error message">
                <div class="header">Gagal Approve</div>
                <p>Approve gagal karena tidak ada history approve dari idpel <b> <%=idpel%> </b>.
                    <br>Silakan klik <b>OK</b> untuk isi data monitoring terlebih dahulu atau klik <b>BACK</b> untuk kembali ke halaman sebelumnya.
                    <br> Terima Kasih.
                </p>
            </div>
            <form> <input class="ui submit button" type="submit" value="OK" name="submit"><input class="ui submit button" type="submit" value="BACK" name="commit"></form>
        </div>

        <!--Script-->
        <script src="Semantic-UI-1.0.0/dist/jquery-2.1.1.js" type="text/javascript"></script>
        <script src="Semantic-UI-1.0.0/dist/semantic.js" type="text/javascript"></script>
        <script src="date/jquery.plugin.js" type="text/javascript"></script>
        <script src="date/jquery.datepick.js" type="text/javascript"></script>
        <!--Local Script-->

        <!--End of Local Script-->

    </body>
</html>