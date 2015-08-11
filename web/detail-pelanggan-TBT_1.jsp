<%-- 
    Document   : data-kwh-0
    Created on : Jun 29, 2015, 1:42:41 PM
    Author     : NOVITA
--%>

<%@page import="Model.LihatData_TBT"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String status = null,id=null;
        String idpel = session.getAttribute("idpel").toString();
        List<LihatData_TBT> kendaraanList = LihatData_TBT.getDetailPelanggan(idpel);

        if (null != request.getParameter("cari")) {
            session.setAttribute("idpel", request.getParameter("idpel"));
            response.sendRedirect("detail-pelanggan-TBT_1.jsp");
        }
        if (request.getParameter("tbt-approve") != null) {
            String link = "detail-pelanggan-TBT_1.jsp";
            session.setAttribute("link", link);
            session.setAttribute("id_blth", request.getParameter("tbt-approve"));
            response.sendRedirect("tbt-sudah-cek_1.jsp");
        }

        if (request.getParameter("tbt-belum") != null) {
            String link = "detail-pelanggan-TBT_1.jsp";
            session.setAttribute("link", link);
            session.setAttribute("id_blth", request.getParameter("tbt-belum"));
            response.sendRedirect("tbt-belum-cek_1.jsp");
        }

    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lihat Info Pelanggan</title>
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
                        Lihat Info Pelanggan!
                    </div>
                    <p>
                        Untuk melihat history pemakaian listrik pelanggan, silakan masukan <b>ID PELANGGAN</b>
                        kemudian klik tombol cari.
                    <form action="" id="saveMember">
                        <div class="ui fluid form segment">
                            <div class=" four fields">
                                <div class="field">
                                    <label>Masukan IDPEL atau NO METER</label>
                                    <input placeholder="contoh:22500987866" name="idpel" type="text" value="<%=idpel%>">
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
        <form>
            <div class="column">
                <div class="ui fluid form segment">
                    <div class="row">
                        <div class="ten wide column">
                            <h4 class="ui top attached center aligned inverted red block header">
                                DATA PELANGGAN 
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
                                        <th>TANGGAL MONITORING</th>
                                        <th>MONITORING</th>
                                        <th>APPROVE</th>
                                        <th>DETAIL</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        for (int i = 0; i < kendaraanList.size(); i++) {
                                    %>

                                    <tr>
                                        <%String blth = kendaraanList.get(i).getmBlth();%>
                                        <td><%=blth%></td>
                                        <%id= kendaraanList.get(i).getmIdpel();%>
                                        <td><%=id%></td>
                                        <td><%= kendaraanList.get(i).getmNoMeter()%></td>
                                        <td><%= kendaraanList.get(i).getmNama()%></td>
                                        <td><%= kendaraanList.get(i).getmAlamat()%></td>
                                        <td><%= kendaraanList.get(i).getmTarif()%>/<%= kendaraanList.get(i).getmDaya()%></td>
                                        <td><%= kendaraanList.get(i).getmUnitup()%></td>
                                        <td><%= kendaraanList.get(i).getmBulan()%></td>
                                        <% status = kendaraanList.get(i).getmVerifikasi();
                                            if (status == null) {
                                                status = "-";
                                            }
                                        %>
                                        <td><%=status%></td>
                                        <% status = kendaraanList.get(i).getmTgl_Monitor();
                                            if (status == null) {
                                                status = "-";
                                            }
                                        %>
                                        <td><%=status%></td>
                                        <% status = kendaraanList.get(i).getmStatus_Monitoring();
                                        if (status == null) {%>
                                        <td> <i class="remove icon"></i></td>
                                        <% } else {%>
                                        <td>  <i class="checkmark icon"></i></td>
                                        <%  }

                                          String  approve = kendaraanList.get(i).getmApprove();
                                            if (status == null) {%>
                                        <td> <i class="remove icon"></i></td>
                                        <% } else {%>
                                        <td>  <i class="checkmark icon"></i></td>
                                        <%  }
                                            String kode = blth + id;
                                             approve = kendaraanList.get(i).getmApprove();

                                            if ((status != null) && (approve != null)) {%>
                                            <td><center><i class="checkmark icon"></i><br>sudah approve</center></td> 
                                        <% } else if ((status != null) && (approve == null)) {%>
                                <td><center><i>sudah monitoring, klik untuk ubah</i><br><input class="ui tiny blue button" type="submit" value="<%=kode%>" name="tbt-approve"></center></td> 
                                    <% } else if (status == null) {%>
                                <td><center><i>belum monitor, klik untuk copy status terakhir</i><br><input class="ui tiny red button" type="submit" value="<%=kode%>" name="tbt-belum"></center></td> 
                                    <% }%>
                                </tr>
                                <% }%>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>
            </div>
        </form>

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
                        identifier: 'idpel',
                        rules:
                            [
                            {type: 'empty', prompt: 'Masukkan id pelanggan'}
                               
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