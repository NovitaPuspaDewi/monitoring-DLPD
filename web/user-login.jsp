<%-- 
    Document   : data-kwh-0
    Created on : Jun 29, 2015, 1:42:41 PM
    Author     : NOVITA
--%>

<%@page import="Model.DataPegawai"%>
<%@page import="Model.DetailPelanggan_All"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        List<DataPegawai> kendaraanList = DataPegawai.getDataList();

        if (request.getParameter("commit") != null) {
            response.sendRedirect("tambah-user.jsp");
        }

    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lihat Data User</title>
        <link href="semantic/packaged/css/semantic.css" rel="stylesheet" type="text/css">
        <link rel="shortcut icon" href="img/logo_PLN.jpg" type="image/jpg">
    </head>
    <body style="background-color:#CD5C5C">
        <!--Menu bar-->
        <%@include file="menubar-admin.jsp" %>
        <br>
        <br>
        <br>
        <!--End of Menu bar-->
        <div class="ui three column grid">
            <div class="column"></div>
            <div class="column">
                <form>
                    <div class="ui fluid form segment">
                        <div class="row">
                            <div class="ten wide column">
                                <h4 class="ui top attached center aligned inverted blue block header">
                                    DATA USER LOGIN
                                </h4>
                                <table class="ui padded table segment attached">
                                    <thead>
                                        <tr>
                                            <th>Username</th>
                                            <th>Password</th>
                                            <th>Role</th>
                                            <th>Kode Unit</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            for (int i = 0; i < kendaraanList.size(); i++) {
                                        %>
                                        <tr>
                                            <td><%= kendaraanList.get(i).getmUsernamePegawai()%></td>
                                            <td><%= kendaraanList.get(i).getmPaswordPegawai()%></td>
                                            <td><%= kendaraanList.get(i).getmRolePegawai()%></td>
                                            <td><%= kendaraanList.get(i).getmKode()%></td>
                                        </tr>
                                        <% }%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <br><br>
                        <right><input class="ui tiny red button" type="submit" value="TAMBAH USER" name="commit"></right>
                    </div>
                </form>
            </div>
            <div class="column"></div>
        </div>
        <!--Script-->
        <script src="Semantic-UI-1.0.0/dist/jquery-2.1.1.js" type="text/javascript"></script>
        <script src="Semantic-UI-1.0.0/dist/semantic.js" type="text/javascript"></script>
        <script src="date/jquery.plugin.js" type="text/javascript"></script>
        <script src="date/jquery.datepick.js" type="text/javascript"></script>
        <script type="text/javascript"></script>
    </body>
</html>