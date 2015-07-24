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
        String bulan_tahun_terakhir = null;

        List<Dashboard> list = Model.Dashboard.cari_bulan_terakhir();
        for (int i = 0; i < list.size(); i++) {
            bulan_tahun_terakhir = list.get(i).getpBlth();
        }

        String month = bulan_tahun_terakhir.substring(4);
        String year = bulan_tahun_terakhir.substring(0, 4);

        if (request.getParameter("cari") != null) {
            String bulan = request.getParameter("bulan");
            String tahun = request.getParameter("tahun").substring(0, 4);
            String blth = tahun + bulan;
            session.setAttribute("blth", blth);
            response.sendRedirect("dashboard-cari-blth.jsp");
        }

    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Pelanggan Kwh 0</title>
        <link href="semantic/packaged/css/semantic.css" rel="stylesheet" type="text/css">
        <link rel="shortcut icon" href="img/logo_PLN.jpg" type="image/jpg">
    </head>
    <body>
        <!--Menu bar-->
        <div class="ui fixed top red inverted menu">
            <%@include file="menubar-home.jsp" %>
        </div>
        <br>
        <br>
        <br>
        <!--End of Menu bar-->
        <div class="ui one column page grid">
            <div class="column">
                <div class="ui info message">
                    <div class="header">
                        Cari Berdasarkan Bulan Tahun 
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
                <br>
            </div>
        </div>

        <div class="ui one column page grid">
            <div class="column">
                <div class="row">
                    <div class="ten wide column">
                        <h4 class="ui top attached center aligned inverted red block header">
                            <center>REKAP TBT > 3 BULAN <br>BULAN <%=month%> TAHUN <%=year%></center>
                        </h4>
                        <table class="ui padded table segment attached" id="filmTable">
                            <thead>
                                <tr>
                                    <th>NO</th>
                                    <th>UNITUP</th>
                                    <th>JUMLAH</th>
                                    <th>SUDAH MONITOR</th>
                                    <th>BELUM MONITOR</th>
                                    <th>SUDAH APPROVE</th> 
                                    <th>BELUM APPROVE</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    int sudahcek=0, belumcek=0, sudahapp=0, belumapp=0, jumlah=0;
                                    String unitup = null;

                                    List<Unitup> list2 = Model.Unitup.getDataList_Unitup_tbt();
                                    for (int i = 0; i < list2.size(); i++) {
                                        unitup = list2.get(i).getpUnitup();
                                %>
                                <tr>
                                    <td><%=i + 1%></td>
                                    <td><%=unitup%></td>
                                    <% jumlah = Dashboard.hitungtbt(bulan_tahun_terakhir, unitup);%>
                                    <td><%=jumlah%></td>
                                    <% sudahcek = Dashboard.hitungtbt_sudahcek(bulan_tahun_terakhir, unitup);%>
                                    <td><%=sudahcek%></td>
                                    <% belumcek = Dashboard.hitungtbt_belumcek(bulan_tahun_terakhir, unitup);%>
                                    <td><%=belumcek%></td>
                                    <% sudahapp = Dashboard.hitungtbt_sudahapprove(bulan_tahun_terakhir, unitup);%>
                                    <td><%=sudahapp%></td>
                                    <% belumapp = Dashboard.hitungtbt_belumapprove(bulan_tahun_terakhir, unitup);%>
                                    <td><%=belumapp%></td>
                                </tr>
                                <% }%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
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
                
                $("#search_unitup").form({
                    password:
                        {
                        identifier: 'unitup',
                        rules:
                            [
                            {type: 'empty', prompt: 'Masukkan unitup'}
                               
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