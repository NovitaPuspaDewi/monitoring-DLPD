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
        String unit = session.getAttribute("unitup").toString();
        
        int count_sudah = Approve.hitungApprove_sudahcek_maks_unitup(unit);
        int count_belum = Approve.hitungApprove_belumcek_maks_unitup(unit);
        String status = null;

        if (request.getParameter("commit") != null) {

            String id = request.getParameter("commit");
            String idpel = id.substring(6);
            String blth = id.substring(0, 6);
            String tgl = null;
            String verifikasi = null;
            String petugas_upload = null;
            String koordinat = null;

            List<Approve> data = Approve.getDataListCekPelanggan_kwhMaks(idpel);
            for (int i = 0; i < data.size(); i++) {
                if (i == data.size() - 1) {
                    tgl = data.get(i).getmTgl_Monitoring();
                    verifikasi = data.get(i).getmVerifikasi();
                    petugas_upload = data.get(i).getmPetugas_Upload();
                    koordinat = data.get(i).getmKoordinat();
                }
            }

            if (data.size() != 0) {
                Approve app = new Approve();
                app.setmPetugas_Approve(session.getAttribute("name").toString());
                app.setmIdpel(idpel);
                app.setmBlth(blth);
                app.setmTgl_Monitoring(tgl);
                app.setmVerifikasi(verifikasi);
                app.setmPetugas_Upload(petugas_upload);
                app.setmKoordinat(koordinat);

                Approve.Approve_Langsung(app);
                response.sendRedirect("tampil-data-approve-semua-kwh-maks-unitup.jsp");
            } else {
                session.setAttribute("id", idpel);
                session.setAttribute("blth", blth);
                response.sendRedirect("gagal-approve-kwh-maks.jsp");
            }
        }

        if (request.getParameter("commit1") != null) {
            String id = request.getParameter("commit1");
            String idpel = id.substring(6);
            String blth = id.substring(0, 6);

            Approve app = new Approve();
            app.setmPetugas_Approve(session.getAttribute("name").toString());
            app.setmIdpel(idpel);
            app.setmBlth(blth);
            Approve.Approve_Biasa(app);
            response.sendRedirect("tampil-data-approve-semua-kwh-maks-unitup.jsp");
        }

        if (request.getParameter("cari2") != null) {
            String unitup = request.getParameter("unitup");
            session.setAttribute("unitup", unitup);
            response.sendRedirect("tampil-data-approve-semua-kwh-maks-unitup.jsp");
        }
    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Approve Pelanggan Kwh Maks UNITUP ${unitup}</title>
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
                                DATA PELANGGAN KWH MAKS UNITUP ${unitup}
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
                                        List<Approve> kendaraanList = Approve.getDataListCekSemua_KwhMaks(unit);
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
                                        <td><center><i>Silakan klik untuk Approve</i><br><input class="ui tiny blue button" type="submit" value="<%=id_blth%>" name="commit1"></center></td>
                                        <%} else {%>
                                <td><center><i>Klik untuk Approve<i><br><input class="ui tiny red button" type="submit" value="<%=id_blth%>" name="commit"></center></td>
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