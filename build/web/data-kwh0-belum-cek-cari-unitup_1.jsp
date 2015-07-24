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
        String unitup1 = session.getAttribute("unitup").toString();
        List<LihatData> kendaraanList = LihatData.getDataList_kwh0_belum_cek(unitup1);
        int count = kendaraanList.size();
        String status = null;

        if (request.getParameter("commit") != null) {
            session.setAttribute("id_blth", request.getParameter("commit"));
            response.sendRedirect("kwh0-belum-cek_1.jsp");
        }

        if (request.getParameter("cari2") != null) {
            String unitup = request.getParameter("unitup");
            session.setAttribute("unitup", unitup);
            response.sendRedirect("data-kwh0-belum-cek-cari-unitup_1.jsp");
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Pelanggan Kwh 0 Belum Cek</title>
        <link href="semantic/packaged/css/semantic.css" rel="stylesheet" type="text/css">
        <link rel="shortcut icon" href="img/logo_PLN.jpg" type="image/jpg">
    </head>
    <body style="background-color:#CD5C5C">
        <!--Menu bar-->
        <%@include file="menubar-operator.jsp" %>
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
                        <b><%=count%></b> data pelanggan kwh 0 yang belum dimonitoring UNITUP ${unitup}<br><br>
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
                                DATA PELANGGAN KWH 0 BELUM CEK UNITUP ${unitup}
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
                                        <th>KWH MAKS</th>
                                        <th>TOTAL KWH</th>
                                        <th>UPLOAD FOTO DAN KOORDINAT</th>
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
                                        <td><%= kendaraanList.get(i).getmKwhMaks()%></td>
                                        <td><%= kendaraanList.get(i).getmKwhTot()%></td>
                                        <%String id = kendaraanList.get(i).getmIdpel();
                                            String blth = kendaraanList.get(i).getmBlth();
                                            String id_blth = blth + id;%>
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