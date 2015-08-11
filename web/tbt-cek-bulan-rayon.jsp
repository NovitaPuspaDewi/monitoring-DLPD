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
        String bulantahun = session.getAttribute("blth").toString();
        String kode=session.getAttribute("username").toString();
        int count_sudah = LihatData_TBT.hitungtbt_sudahcek(bulantahun,kode);
        int count_belum = LihatData_TBT.hitungtbt_belumcek(bulantahun,kode);
        String status = null;
        List<LihatData_TBT> kendaraanList = LihatData_TBT.getDataListTBT_blth(bulantahun,kode);

        if (request.getParameter("commit") != null) {
            String link = "tbt-cek-bulan-rayon.jsp";
            session.setAttribute("link", link);
            session.setAttribute("id_blth", request.getParameter("commit"));
            response.sendRedirect("tbt-sudah-cek-rayon.jsp");
        }

        if (request.getParameter("commit1") != null) {
            String link = "tbt-cek-bulan-rayon.jsp";
            session.setAttribute("link", link);
            session.setAttribute("id_blth", request.getParameter("commit1"));
            response.sendRedirect("tbt-belum-cek-rayon.jsp");
        }

        if (request.getParameter("cari") != null) {
            String bulan = request.getParameter("bulan");
            String tahun = request.getParameter("tahun").substring(0, 4);
            String blth = tahun + bulan;
            session.setAttribute("blth", blth);
            response.sendRedirect("tbt-cek-bulan-rayon.jsp");
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Pelanggan TBT</title>
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
                        <b><%=count_belum%></b> data pelanggan TBT yang belum dimonitoring,
                        <b><%=count_sudah%></b> sudah dimonitoring di UNITUP ${username}.
                    </p>
                </div>
            </div>
        </div>
        <br>
        <div class="ui one column page grid">
            <div class="column">
                <div class="ui info message">
                    <div class="header">
                        Cek Monitoring TBT per-bulan
                    </div>
                    <p>                       
                    <form action="" id="saveMember">
                        <div class="ui fluid form segment">
                            <div class=" four fields">
                                <div class="field">
                                    <label>Masukan Bulan </label>
                                    <div class="ui selection dropdown">
                                        <input type="hidden" name="bulan">
                                        <div class="default text">...</div>
                                        <i class="dropdown icon"></i>
                                        <div class="menu">
                                            <div class="item" data-value="01">Januari</div>
                                            <div class="item" data-value="02">Februari</div>
                                            <div class="item" data-value="03">Maret</div>
                                            <div class="item" data-value="04">April</div>
                                            <div class="item" data-value="05">Mei</div>
                                            <div class="item" data-value="06">Juni</div>
                                            <div class="item" data-value="07">Juli</div>
                                            <div class="item" data-value="08">Agustus</div>
                                            <div class="item" data-value="09">September</div>
                                            <div class="item" data-value="10">Oktober</div>
                                            <div class="item" data-value="11">Nopember</div>
                                            <div class="item" data-value="12">Desember</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="field">
                                    <label>Masukan Tahun</label>
                                    <input placeholder="contoh:2014" name="tahun" type="text">
                                </div>
                                <div class="field">
                                    <label> Klik untuk mulai pencarian</label>
                                    <input class="ui tiny red button" type="submit" value="CARI" name="cari">
                                </div>
                            </div>

                        </div>
                    </form>
                    </p>
                </div>
                <br><br>

            </div>
        </div>
        <div class="column">
            <form>
                <div class="ui fluid form segment">
                    <div class="row">
                        <div class="ten wide column">
                            <h4 class="ui top attached center aligned inverted red block header">
                                DATA PELANGGAN TBT ${blth} UNITUP ${username}
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
                                                status = kendaraanList.get(i).getmStatus_Monitoring();
                                                if (status == null) {
                                                    status = "Belum Monitor, klik untuk isi monitoring";%>
                                        <td><center><i><%=status%></i><br>
                                    <input class="ui tiny red button" type="submit" value="<%=id_blth%>" name="commit1"></center></td>
                                    <% } else if (status != null) {
                                        status = "Sudah monitoring,klik untuk ubah data";%>
                                <td><center><i><%=status%></i><br>
                                    <input class="ui tiny blue button" type="submit" value="<%=id_blth%>" name="commit"></center></td>
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