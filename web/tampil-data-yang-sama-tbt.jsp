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
        List<LihatData_TBT> kendaraanList = LihatData_TBT.getDataListCekData_Yang_Sama();
        int count_belum = kendaraanList.size();
        
        String status = null;

        if (request.getParameter("commit") != null) {

            String id = request.getParameter("commit");
            String link = "tampil-data-yang-sama-tbt.jsp";

            session.setAttribute("id_blth", id);
            session.setAttribute("link", link);

            response.sendRedirect("detail-approve-copy-status-tbt.jsp");

        }

        if (request.getParameter("commit1") != null) {
            String id = request.getParameter("commit1");
            String link = "tampil-data-yang-sama-tbt.jsp";

            session.setAttribute("id_blth", id);
            session.setAttribute("link", link);

            response.sendRedirect("approve-tbt.jsp");
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Pelanggan TBT Belum Approve</title>
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
                        <b><%=count_belum%></b> data pelanggan TBT yang belum di-Approve,silakan klik tombol di kolom
                        <b>'COPY STATUS BULAN TERAKHIR'</b> untuk approve langsung.
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
                                DATA PELANGGAN TBT YANG SAMA
                            </h4>
                            <table class="ui padded table segment attached" id="filmTable">
                                <thead>
                                    <tr>
                                        <th>BLTH</th>
                                        <th>IDPEL</th>
                                        <th>NO METER</th>
                                        <th>NAMA</th>
                                        <th>ALAMAT</th>
                                        <th>UNITUP</th>
                                        <th>TARIF</th>
                                        <th>DAYA</th> 
                                        <th>BULAN</th>
                                        <th>STATUS MONITORING</th>
                                        <th>TGL MONITOR</th>
                                        <th>VERIFIKASI</th>
                                        <th>PETUGAS UPLOAD</th>
                                        <th>COPY STATUS BULAN TERAKHIR</th>
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
                                        <td><%= kendaraanList.get(i).getmUnitup()%></td>
                                        <td><%= kendaraanList.get(i).getmTarif()%></td>
                                        <td><%= kendaraanList.get(i).getmDaya()%></td>
                                        <td><%= kendaraanList.get(i).getmBulan()%></td>
                                        <% status = kendaraanList.get(i).getmStatus_Monitoring();
                                            if (status == null) {%>
                                        <td> <i class="remove icon"></i></td>
                                        <% } else {%>
                                        <td>  <i class="checkmark icon"></i></td>
                                        <%  }%>
                                        <td><%= kendaraanList.get(i).getmTgl_Monitor()%></td>
                                        <td><%= kendaraanList.get(i).getmVerifikasi()%></td>
                                        <td><%= kendaraanList.get(i).getmPetugas_Upload()%></td>
                                        <%
                                            String id = kendaraanList.get(i).getmIdpel();
                                            String blth = kendaraanList.get(i).getmBlth();
                                            String id_blth = blth + id;

                                            if ((kendaraanList.get(i).getmApprove() != null) && (kendaraanList.get(i).getmStatus_Monitoring() != null)) {%>
                                        <td>  <i class="checkmark icon"></i></td>  
                                        <%} else if ((kendaraanList.get(i).getmApprove() != null) && (kendaraanList.get(i).getmStatus_Monitoring() == null)) {%>
                                        <td><center><input class="ui tiny blue button" type="submit" value="<%=id_blth%>" name="commit1"></center></td>
                                        <%} else {%>
                                <td><center><input class="ui tiny red button" type="submit" value="<%=id_blth%>" name="commit"></center></td>
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