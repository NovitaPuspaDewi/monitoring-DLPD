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
        List<LihatData_TBT> kendaraanList = LihatData_TBT.getDataListTBT_kurang6_sudah_cek(kode);
        int count = kendaraanList.size();
        String status = null;

        if (request.getParameter("commit") != null) {
            session.setAttribute("id_blth", request.getParameter("commit"));
            session.setAttribute("link", "tbt-sudah-cek-kurang6-rayon_1.jsp");
            response.sendRedirect("tbt-sudah-cek-rayon_1.jsp");
        }

        if (request.getParameter("lebih6") != null) {
            response.sendRedirect("tbt-sudah-cek-lebih6-rayon_1.jsp");
        }

        if (request.getParameter("kurang6") != null) {
            response.sendRedirect("tbt-sudah-cek-kurang6-rayon_1.jsp");
        }

    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Pelanggan TBT Sudah Cek</title>
        <link href="semantic/packaged/css/semantic.css" rel="stylesheet" type="text/css">
        <link rel="shortcut icon" href="img/logo_PLN.jpg" type="image/jpg">
    </head>
    <body style="background-color:#CD5C5C">
        <!--Menu bar-->
        <%@include file="menubar-operator-00.jsp" %>
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
                        <b><%=count%></b> data pelanggan TBT kurang dari 6 bulan yang sudah dimonitoring UNITUP ${username}<br><br>
                    <div class="ui fluid form segment">
                        <form id="search_unitup">
                            <div class=" four fields">
                                <div class="field">
                                    <label>Lihat Pelanggan tidak beli token : </label>
                                    <input class="ui tiny blue button" type="submit" value="3-4 bulan" name="kurang6"> <b>ATAU</b> <input class="ui tiny blue button" type="submit" value="lebih 6 bulan" name="lebih6">
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
                                DATA PELANGGAN TBT < 6 bulan SUDAH CEK <br>UNITUP ${username}
                            </h4>
                            <table class="ui padded table segment attached" id="filmTable">
                                <thead>
                                    <tr>
                                        <th>BLTH</th>
                                        <th>UNITUP</th>
                                        <th>ID PELANGGAN</th>
                                        <th>NO METER</th>
                                        <th>NAMA</th>
                                        <th>ALAMAT</th>
                                        <th>TARIF/DAYA</th> 
                                        <th>BULAN</th>
                                        <th>TGL MONITOR</th>
                                        <th>LIHAT DETAIL</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        for (int i = 0; i < kendaraanList.size(); i++) {
                                    %>

                                    <tr>
                                        <td><%= kendaraanList.get(i).getmBlth()%></td>
                                        <td><%= kendaraanList.get(i).getmUnitup()%></td>
                                        <td><%= kendaraanList.get(i).getmIdpel()%></td>
                                        <td><%= kendaraanList.get(i).getmNoMeter()%></td>
                                        <td><%= kendaraanList.get(i).getmNama()%></td>
                                        <td><%= kendaraanList.get(i).getmAlamat()%></td>
                                        <td><%=kendaraanList.get(i).getmDaya()%>/<%= kendaraanList.get(i).getmDaya()%></td>
                                        <td><%= kendaraanList.get(i).getmBulan()%></td>
                                        <td><%= kendaraanList.get(i).getmTgl_Monitor()%></td>
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
                        identifier: '--',
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