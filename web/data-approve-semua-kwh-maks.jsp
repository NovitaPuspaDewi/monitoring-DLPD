<%-- 
    Document   : data-kwh-0
    Created on : Jun 29, 2015, 1:42:41 PM
    Author     : NOVITA
--%>

<%@page import="Model.Approve"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        int count_sudah = Approve.hitungApprove_sudahcek_maks();
        int count_belum = Approve.hitungApprove_belumcek_maks();
        String status = null;

        if (request.getParameter("commit") != null) {

            String id = request.getParameter("commit");
            String link = "data-approve-semua-kwh-maks.jsp";

            session.setAttribute("id_blth", id);
            session.setAttribute("link", link);

            response.sendRedirect("detail-copy-status-kwh-maks.jsp");
        }

        if (request.getParameter("commit1") != null) {
            String id = request.getParameter("commit1");
            String link = "data-approve-semua-kwh-maks.jsp";

            session.setAttribute("id_blth", id);
            session.setAttribute("link", link);

            response.sendRedirect("detail-kwh-maks-sudah-cek.jsp");
        }
        
        if (request.getParameter("tampil") != null) {
            response.sendRedirect("tampil-data-yang-sama-kwh-maks.jsp");
        }

        if (request.getParameter("unitup") != null) {
            response.sendRedirect("data-approve-semua-kwh-maks-unitup.jsp");
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Approve Pelanggan Kwh Maks</title>
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
                        <b><%=count_belum%></b> data pelanggan kwh Maks yang belum di-Approve,
                        <b><%=count_sudah%></b> sudah di-Approve
                        <br><br>
                    <form>
                        <input class="ui tiny red button" type="submit" value="Tampilkan Data yang Sama" name="tampil"><b>---  ATAU  ---</b><input class="ui tiny red button" type="submit" value="Tampilkan per-UNITUP" name="unitup">
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
                                DATA PELANGGAN KWH MAKS
                            </h4>
                            <table class="ui padded table segment attached" id="filmTable">
                                <thead>
                                    <tr>
                                        <th>BLTH</th>
                                        <th>ID PELANGGAN</th>
                                        <th>ALAMAT</th>
                                        <th>UNITUP</th>
                                        <th>TARIF</th>
                                        <th>DAYA</th> 
                                        <th>KWH MAKS</th>
                                        <th>TOTAL KWH</th>
                                        <th>STATUS MONITORING</th>
                                        <th>TGL MONITOR</th>
                                        <th>VERIFIKASI</th>
                                        <th>PETUGAS UPLOAD</th>
                                        <th>STATUS APPROVE</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        List<Approve> kendaraanList = Approve.getDataListCekSemua_KwhMaks();
                                        for (int i = 0; i < kendaraanList.size(); i++) {
                                    %>
                                    <tr>
                                        <td><%= kendaraanList.get(i).getmBlth()%></td>
                                        <td><%= kendaraanList.get(i).getmIdpel()%></td>
                                        <td><%= kendaraanList.get(i).getmAlamat()%></td>
                                        <td><%= kendaraanList.get(i).getmUnitup()%></td>
                                        <td><%= kendaraanList.get(i).getmTarif()%></td>
                                        <td><%= kendaraanList.get(i).getmDaya()%></td>
                                        <td><%= kendaraanList.get(i).getmKwhMaks()%></td>
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
                                            String id = kendaraanList.get(i).getmIdpel();
                                            String blth = kendaraanList.get(i).getmBlth();
                                            String id_blth = blth + id;

                                            if ((kendaraanList.get(i).getmStatusApprove() != null) && (kendaraanList.get(i).getmStatus() != null)) {%>
                                        <td>  <i class="checkmark icon"></i></td>  
                                        <%} else if ((kendaraanList.get(i).getmStatus() != null) && (kendaraanList.get(i).getmStatusApprove() == null)) {%>
                                        <td><center><i>Sudah dimonitor, klik untuk approve</i><br><input class="ui tiny blue button" type="submit" value="<%=id_blth%>" name="commit1"></center></td>
                                        <%} else {%>
                                <td><center><i>Belum monitor, copy status bulan terakhir</i><br> <input class="ui tiny red button" type="submit" value="<%=id_blth%>" name="commit"></center></td>
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
                $("#loginSidebar")
                .sidebar('setting', {
                    overlay: true
                }).sidebar('toggle');
            });
        </script>
    </body>
</html>