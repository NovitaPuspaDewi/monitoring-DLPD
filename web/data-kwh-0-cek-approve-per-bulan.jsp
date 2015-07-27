<%-- 
    Document   : data-kwh-0
    Created on : Jun 29, 2015, 1:42:41 PM
    Author     : NOVITA
--%>

<%@page import="Model.LihatData"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String bulantahun = session.getAttribute("blth").toString();
        String status = null;
        List<LihatData> kendaraanList = LihatData.getDataListKwh0(bulantahun);
        int count = LihatData.hitungKwh0(bulantahun);
        int count_belum = LihatData.hitungKwh0_belumApprove(bulantahun);
        int count_sudah = LihatData.hitungKwh0_sudahApprove(bulantahun);

        //session.removeAttribute("blth");

        if (request.getParameter("cari") != null) {
            String bulan = request.getParameter("bulan");
            String tahun = request.getParameter("tahun").substring(0, 4);
            String blth = tahun + bulan;
            session.setAttribute("blth", blth);
            response.sendRedirect("data-kwh-0-cek-approve-per-bulan.jsp");
        }

        if (request.getParameter("commit") != null) {
            session.setAttribute("id_blth", request.getParameter("commit"));
            response.sendRedirect("approve-kwh-0.jsp");
        }

        if (request.getParameter("commit1") != null) {
            session.setAttribute("id_blth", request.getParameter("commit1"));
            response.sendRedirect("kwh0-belum-cek.jsp");
        }

        if (request.getParameter("commit2") != null) {
            session.setAttribute("id_blth", request.getParameter("commit2"));
            response.sendRedirect("detail-approve-kwh-0.jsp");
        }
    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cek Monitoring Kwh 0 per-Bulan</title>
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
                        Terdapat <b><%=count%></b> pelanggan dengan pemakaian listrik 0 kwh.<br>
                        <b><%=count_sudah%></b> sudah di-approve dan <b><%=count_belum%></b> belum di-approve <br><br>

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
                                DATA PELANGGAN KWH 0 BULAN <%=bulantahun.substring(4)%> TAHUN <%=bulantahun.substring(0, 4)%>
                            </h4>
                            <table class="ui padded table segment attached" id="filmTable">
                                <thead>
                                    <tr>
                                        <th>BLTH</th>
                                        <th>ID PELANGGAN</th>
                                        <th>NAMA</th>
                                        <th>ALAMAT</th>
                                        <th>TARIF</th>
                                        <th>DAYA</th> 
                                        <th>UNITUP</th>
                                        <th>KWH MAKS</th>
                                        <th>TOTAL KWH</th>
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
                                        <td><%= kendaraanList.get(i).getmNama()%></td>
                                        <td><%= kendaraanList.get(i).getmAlamat()%></td>
                                        <td><%= kendaraanList.get(i).getmTarif()%></td>
                                        <td><%= kendaraanList.get(i).getmDaya()%></td>
                                        <td><%= kendaraanList.get(i).getmUnitup()%></td>
                                        <td><%= kendaraanList.get(i).getmKwhMaks()%></td>
                                        <td><%= kendaraanList.get(i).getmKwhTot()%></td>
                                        <% String id = kendaraanList.get(i).getmIdpel();
                                            String blth = kendaraanList.get(i).getmBlth();
                                            String id_blth = blth + id;
                                            String cek = kendaraanList.get(i).getmStatus();
                                            status = kendaraanList.get(i).getmApprove();
                                            if ((status == null) && (cek != null)) {
                                                status = "Belum Approve, klik untuk Approve";%>
                                        <td><center><%=status%><br>
                                    <input class="ui tiny blue button" type="submit" value="<%=id_blth%>" name="commit"></center></td>
                                    <% } else if ((status == null) && (cek == null)) {
                                        status = "Belum monitoring, klik untuk isi monitoring";%>
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
        <script type="text/javascript">
            $(document).ready(function() {
                                            
                //Show dropdown on hover 
                $('.ui.dropdown').dropdown({on: 'hover'});
                
                //Save form error prompt 
                $("#saveMember").form({
                    password:
                        {
                        identifier: 'tahun',
                        rules:
                            [
                            {type: 'empty', prompt: 'Masukkan tahun'}
                               
                        ]
                    },
                    gender:
                        {
                        identifier: 'bulan',
                        rules:
                            [
                            {type: 'empty', prompt: 'Pilih bulan'}
                        ]
                    }
                },
                {
                    on: 'submit',
                    inline: 'true'
                });
            });
        </script>

    </body>
</html>