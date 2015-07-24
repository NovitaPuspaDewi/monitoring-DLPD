<%-- 
    Document   : data-kwh-0
    Created on : Jun 29, 2015, 1:42:41 PM
    Author     : NOVITA
--%>

<%@page import="Model.Approve_Rayon"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String status = null;
        String id = session.getAttribute("blth").toString();
        String thn = id.substring(0, 4);
        String bln = id.substring(4);
        String pBlth = bln + "-" + thn;
        String kode=session.getAttribute("username").toString();

        List<Approve_Rayon> kendaraanList = Approve_Rayon.getDataListCekApprove_blth_kwhMaks(pBlth,kode);
        int count = Approve_Rayon.hitungApprove_sudahcek_maks(pBlth,kode);

        //session.removeAttribute("blth");

        if (request.getParameter("cari") != null) {
            String bulan = request.getParameter("bulan");
            String tahun = request.getParameter("tahun").substring(0, 4);
            String blth = tahun + bulan;
            session.setAttribute("blth", blth);
            response.sendRedirect("data-sudah-approve-kwh-maks-cek-bulan-rayon.jsp");
        }

        if (request.getParameter("commit") != null) {
            session.setAttribute("id_blth", request.getParameter("commit"));
            response.sendRedirect("detail-approve-kwh-maks-rayon.jsp");
        }

    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Kwh Maks Sudah Approve Bulan ${blth}</title>
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
                        Terdapat <b><%=count%></b> pelanggan UNITUP ${username} dengan pemakaian listrik melebihi kwh maks yang sudah di-Approve.<br>
                    <h4>Bulan <b><%=bln%></b> Tahun <b><%=thn%></b> </h4>
                    <br>
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
                                DATA PELANGGAN KWH 0 SUDAH APPROVE UNITUP ${username}
                            </h4>
                            <table class="ui padded table segment attached" id="filmTable">
                                <thead>
                                    <tr>
                                        <th>BLTH</th>
                                        <th>ID PELANGGAN</th>
                                        <th>NAMA</th>
                                        <th>TARIF</th>
                                        <th>DAYA</th> 
                                        <th>TOTAL KWH</th>
                                        <th>STATUS MONITORING</th>
                                        <th>TGL MONITOR</th>
                                        <th>VERIFIKASI</th>
                                        <th>PETUGAS UPLOAD</th>
                                        <th>STATUS APPROVE</th>
                                        <th>TGL APPROVE</th>
                                        <th>LIHAT DETAIL</th>
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
                                        <td><%= kendaraanList.get(i).getmTarif()%></td>
                                        <td><%= kendaraanList.get(i).getmDaya()%></td>
                                        <td><%= kendaraanList.get(i).getmKwhTot()%></td>
                                        <% status = kendaraanList.get(i).getmStatus();
                                            if (status == null) {%>
                                        <td> <i class="remove icon"></i></td>
                                        <% } else {%>
                                        <td>  <i class="checkmark icon"></i></td>
                                        <%  }%>
                                        <td><%= kendaraanList.get(i).getmTgl_Monitoring()%></td>
                                        <td><%= kendaraanList.get(i).getmVerifikasi()%></td>
                                        <td><%= kendaraanList.get(i).getmPetugas_Upload()%></td>
                                        <%
                                            String id2 = kendaraanList.get(i).getmIdpel();
                                            String blth = kendaraanList.get(i).getmBlth();
                                            String id_blth = blth + id2;

                                            if ((kendaraanList.get(i).getmStatusApprove() != null) && (kendaraanList.get(i).getmStatus() != null)) {%>
                                        <td>  <i class="checkmark icon"></i></td>  
                                        <%}%>
                                        <td><%= kendaraanList.get(i).getmTgl_Approve()%></td>
                                        <td><center><input class="ui tiny red button" type="submit" value="<%=id_blth%>" name="commit"></center></td>
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