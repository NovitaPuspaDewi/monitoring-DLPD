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
        String kode = session.getAttribute("username").toString();

        int count_sudah = LihatData_TBT.hitungtbt_sudahapprove_unitup(kode);
        int count_belum = LihatData_TBT.hitungtbt_belumapprove_unitup(kode);
        String status = null;
        List<LihatData_TBT> kendaraanList = LihatData_TBT.getDataListTBT_Unitup(kode);

        if (request.getParameter("commit") != null) {
            String link = "data-approve-semua-tbt-rayon.jsp";
            session.setAttribute("link", link);
            session.setAttribute("id_blth", request.getParameter("commit"));
            response.sendRedirect("approve-tbt-rayon.jsp");
        }

        if (request.getParameter("commit1") != null) {
            String link = "data-approve-semua-tbt-rayon.jsp";
            session.setAttribute("link", link);
            session.setAttribute("id_blth", request.getParameter("commit1"));
            response.sendRedirect("detail-approve-copy-status-tbt-rayon.jsp");
        }

        if (request.getParameter("commit2") != null) {
            session.setAttribute("id_blth", request.getParameter("commit2"));
            session.setAttribute("link", "data-approve-semua-tbt-rayon.jsp");
            response.sendRedirect("detail-approve-TBT-rayon.jsp");
        }

        if (request.getParameter("tampil") != null) {
            response.sendRedirect("tampil-data-yang-sama-tbt-rayon.jsp");
        }

    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Approve Pelanggan TBT</title>
        <link href="semantic/packaged/css/semantic.css" rel="stylesheet" type="text/css">
        <link rel="shortcut icon" href="img/logo_PLN.jpg" type="image/jpg">
    </head>
    <body style="background-color:#CD5C5C">
        <!--Menu bar-->
        <%@include file="menubar-admin-00.jsp" %>
        <br>
        <br>
        <br>
        <!--End of Menu bar-->
        <div class="ui one column page grid">
            <div class="column">
                <div class="ui info message">
                    <div class="header">
                        Info!
                    </div>
                    <p>
                        <b><%=count_belum%></b> data pelanggan TBT UNITUP ${username} yang belum di-Approve,
                        <b><%=count_sudah%></b> sudah di-Approve
                        <br><br>
                    <form>
                        <input class="ui tiny red button" type="submit" value="Tampilkan Data yang Sama" name="tampil">
                    </form>
                    </p>
                </div>
            </div>
        </div>
        <br><br>
        <div class="column">
            <form>
                <div class="ui fluid form segment">
                    <div class="row">
                        <div class="ten wide column">
                            <h4 class="ui top attached center aligned inverted red block header">
                                DATA PELANGGAN TBT UNITUP ${username}
                            </h4>
                            <table class="ui padded table segment attached" id="filmTable">
                                <thead>
                                    <tr>
                                        <th>BLTH</th>
                                        <th>ID PELANGGAN</th>
                                        <th>NO METER</th>
                                        <th>NAMA</th>
                                        <th>ALAMAT</th>
                                        <th>TARIF/DAYA</th>
                                        <th>UNITUP</th>
                                        <th>BULAN</th>
                                        <th>VERIFFIKASI</th>
                                        <th>STATUS MONITORING</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%             for (int i = 0; i < kendaraanList.size(); i++) {
                                    %>

                                    <tr>
                                        <td><%= kendaraanList.get(i).getmBlth()%></td>
                                        <td><%= kendaraanList.get(i).getmIdpel()%></td>
                                        <td><%= kendaraanList.get(i).getmNoMeter()%></td>
                                        <td><%= kendaraanList.get(i).getmNama()%></td>
                                        <td><%= kendaraanList.get(i).getmAlamat()%></td>
                                        <td><%= kendaraanList.get(i).getmTarif()%>/<%= kendaraanList.get(i).getmDaya()%></td>
                                        <td><%= kendaraanList.get(i).getmUnitup()%></td>
                                        <td><%= kendaraanList.get(i).getmBulan()%></td>
                                        <td>dimonitor tgl <%=kendaraanList.get(i).getmTgl_Monitor()%><br>
                                            <%=kendaraanList.get(i).getmVerifikasi()%></td>

                                        <% String id = kendaraanList.get(i).getmIdpel();
                                            String blth = kendaraanList.get(i).getmBlth();
                                            String id_blth = blth + id;
                                            String cek = kendaraanList.get(i).getmStatus_Monitoring();
                                            status = kendaraanList.get(i).getmApprove();
                                            if ((status == null) && (cek != null)) {
                                                status = "Belum Approve, klik untuk Approve";%>
                                        <td><center><%=status%><br>
                                    <input class="ui tiny blue button" type="submit" value="<%=id_blth%>" name="commit"></center></td>
                                    <% } else if ((status == null) && (cek == null)) {
                                        status = "Belum monitoring, klik copy status bulan terakhir";%>
                                <td><center><%=status%><br>
                                    <input class="ui tiny red button" type="submit" value="<%=id_blth%>" name="commit1"></center></td>
                                    <%} else {
                                        status = "Sudah Approve, klik untuk lihat detail";%>
                                <td><center><%=status%><br>
                                    <input class="ui tiny green button" type="submit" value="<%=id_blth%>" name="commit2"></center></td>
                                    <%}%>
                                </tr>                                                                   
                                <% }%>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>
            </form>
        </div>

        <!--Script-->
        <script src="Semantic-UI-1.0.0/dist/jquery-2.1.1.js" type="text/javascript"></script>
        <script src="Semantic-UI-1.0.0/dist/semantic.js" type="text/javascript"></script>
        <script src="date/jquery.plugin.js" type="text/javascript"></script>
        <script src="date/jquery.datepick.js" type="text/javascript"></script>
        <!--Local Script-->

    </body>
</html>