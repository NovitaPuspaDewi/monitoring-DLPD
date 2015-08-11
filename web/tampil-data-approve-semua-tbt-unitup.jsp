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
        String unitup = session.getAttribute("unitup").toString();
        int count_sudah = LihatData_TBT.hitungtbt_sudahapprove_unitup(unitup);
        int count_belum = LihatData_TBT.hitungtbt_belumapprove_unitup(unitup);
        String status = null;

        List<LihatData_TBT> kendaraanList = LihatData_TBT.getDataListTBT_Unitup(unitup);

        if (request.getParameter("commit") != null) {
            String link = "tampil-data-approve-semua-tbt-unitup.jsp";
            session.setAttribute("link", link);
            session.setAttribute("id_blth", request.getParameter("commit"));
            response.sendRedirect("approve-tbt.jsp");
        }

        if (request.getParameter("commit1") != null) {
            String link = "tampil-data-approve-semua-tbt-unitup.jsp";
            session.setAttribute("link", link);
            session.setAttribute("id_blth", request.getParameter("commit1"));
            response.sendRedirect("detail-approve-copy-status-tbt.jsp");
        }

        if (request.getParameter("commit2") != null) {
            session.setAttribute("id_blth", request.getParameter("commit2"));
            session.setAttribute("link", "tampil-data-approve-semua-tbt-unitup.jsp");
            response.sendRedirect("detail-approve-TBT.jsp");
        }

        if (request.getParameter("cari2") != null) {
            unitup = request.getParameter("unitup");
            session.setAttribute("unitup", unitup);
            response.sendRedirect("tampil-data-approve-semua-tbt-unitup.jsp");
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
        <%@include file="menubar-admin.jsp" %>
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
                        <b><%=count_belum%></b> data pelanggan kwh 0 yang belum di-Approve,
                        <b><%=count_sudah%></b> sudah di-Approve UNITUP ${unitup}
                        <br>
                    <div class="ui fluid form segment">
                        <form id="search_unitup">
                            <div class=" four fields">
                                <div class="field">
                                    <label> Masukkan UNITUP</label>
                                    <div class="ui selection dropdown">
                                        <input type="hidden" name="unitup">
                                        <div class="default text">...</div>
                                        <i class="dropdown icon"></i>
                                        <div class="menu">
                                            <div class="item" data-value="22500">KAPUAS</div>
                                            <div class="item" data-value="22510">PULANG PISAU</div>
                                            <div class="item" data-value="22520">BUNTOK</div>
                                            <div class="item" data-value="22530">TAMIANG LAYANG</div>
                                            <div class="item" data-value="22540">MUARA TEWEH</div>
                                            <div class="item" data-value="22550">PURUK CAHU</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="field">
                                    <label> Klik untuk mulai pencarian</label>
                                    <input class="ui tiny red button" type="submit" value="CARI" name="cari2">
                                </div>
                            </div>
                        </form>
                    </div>
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
                                DATA PELANGGAN TBT UNITUP ${unitup}
                            </h4>
                            <table class="ui padded table segment attached" id="filmTable">
                                <thead>
                                    <tr>
                                        <th>BLTH</th>
                                        <th>IDPEL</th>
                                        <th>NO METER</th>
                                        <th>NAMA</th>
                                        <th>ALAMAT</th>
                                        <th>TARIF/DAYA</th>
                                        <th>UNITUP</th>
                                        <th>BULAN</th>
                                        <th>VERIFIKASI</th>
                                        <th>STATUS MONITORING</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        for (int i = 0; i < kendaraanList.size(); i++) {
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
                                        status = "Belum monitoring, klik untuk copy status bulan terakhir";%>
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