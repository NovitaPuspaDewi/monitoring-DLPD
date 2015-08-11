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
        String id1 = session.getAttribute("id_blth").toString();
        String id2 = session.getAttribute("id_blth").toString();

        String blth = id1.substring(0, 6);
        String idpel = id2.substring(6);
        String nama = null, alamat = null, tarif = null, koordinat = null, tgl_upload = null,
                verifikasi = null, petugas_upload = null;
        int daya = 0, kwh_maks = 0, totkwh = 0;

        List<Approve> kendaraanList = Approve.getDetailApprove_Maks(blth, idpel);
        for (int i = 0; i < kendaraanList.size(); i++) {
            nama = kendaraanList.get(i).getmNama();
            alamat = kendaraanList.get(i).getmAlamat();
            tarif = kendaraanList.get(i).getmTarif();
            daya = kendaraanList.get(i).getmDaya();
            kwh_maks = kendaraanList.get(i).getmKwhMaks();
            totkwh = kendaraanList.get(i).getmKwhTot();
            koordinat = kendaraanList.get(i).getmKoordinat();
            tgl_upload = kendaraanList.get(i).getmTgl_Monitoring();
            verifikasi = kendaraanList.get(i).getmVerifikasi();
            petugas_upload = kendaraanList.get(i).getmPetugas_Upload();
        }

        if (request.getParameter("commit") != null) {

            String id = request.getParameter("commit");

            Approve_Rayon app = new Approve_Rayon();
            app.setmPetugas_Approve(session.getAttribute("name").toString());
            app.setmIdpel(idpel);
            app.setmBlth(blth);
            Approve_Rayon.Approve_Biasa(app);

            out.print("<script type=\"text/javascript\">");
            out.print("alert(\"Data monitoring telah di-approve\");");
            out.print("window.location = 'data-belum-approve-kwh-maks.jsp';");
            out.print("</script>");
        }

        if (request.getParameter("foto") != null) {
            session.setAttribute("link1", "kwh-maks-detail-approve.jsp");
            response.sendRedirect("display-foto.jsp");
        }

    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Pelanggan Kwh Maks</title>
        <link href="semantic/packaged/css/semantic.css" rel="stylesheet" type="text/css">
        <link rel="shortcut icon" href="img/logo_PLN.jpg" type="image/jpg">
        <link href="date/redmond.datepick.css" rel="stylesheet" type="text/css">
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
                <h4 class="ui top attached center aligned inverted red block header">
                    DATA PELANGGAN KWH Maks
                </h4>
                <form id="saveMember" enctype="multipart/form-data">
                    <div class="ui fluid form segment">
                        <div class="two fields">
                            <div class="field">
                                <label>ID PELANGGAN
                                    <input name="idpel" type="text" value="<%=idpel%>" disabled="disabled"></label>
                            </div>
                            <div class="field">
                                <label>Nama
                                    <input name="nama" type="text" value="<%=nama%>" disabled="disabled"></label>
                            </div>
                        </div>
                        <div class="two fields">
                            <div class="field">
                                <label>Alamat
                                    <input name="alamat" type="text" value="<%=alamat%>" disabled="disabled"></label>
                            </div>
                            <div class="field">
                                <label>Tarif
                                    <input name="tarif" type="text" value="<%=tarif%>" disabled="disabled"></label>
                            </div>
                        </div>
                        <div class="two fields">
                            <div class="field">
                                <label>Daya
                                    <input name="daya" type="text" value="<%=daya%>" disabled="disabled"></label>
                            </div>
                            <div class="field">
                                <label>Kwh Maks
                                    <input name="maks" type="text" value="<%=kwh_maks%>" disabled="disabled"></label>
                            </div>
                        </div>
                        <div class="two fields">
                            <div class="field">
                                <label>Pemakaian bulan ini
                                    <input name="kwhtot" type="text" value="<%=totkwh%>" disabled="disabled"></label>
                            </div>
                            <div class="field">
                                <label>Bulan Tahun
                                    <input name="blth" type="text" value="<%=blth%>" disabled="disabled"></label>
                            </div>
                        </div>
                        <div class="two fields">
                            <div class="field">
                                <label>Koordinat
                                    <input name="koordinat" type="text" value="<%=koordinat%>" disabled="disabled"></label>
                            </div>
                            <div class="field">
                                <label>Verifikasi
                                    <input name="verif" type="text" value="<%=verifikasi%>" disabled="disabled"></label>
                            </div>
                        </div>
                        <div class="two fields">
                            <div class="field">
                                <label>Tanggal Monitoring
                                    <input name="tgl_monitor" type="text" value="<%=tgl_upload%>" disabled="disabled"></label>
                            </div>
                            <div class="field">
                                <div class="field">
                                    <label>Petugas Monitoring
                                        <input name="petugas_monitor" type="text" value="<%=petugas_upload%>" disabled="disabled"></label>
                                </div>
                            </div>
                        </div>
                        <div class="two fields">
                            <div class="field">
                                <label>Klik untuk lihat Foto
                                    <input class="ui tiny blue button" type="submit" value="LIHAT FOTO" name="foto"></label>
                            </div>
                            <div class="field">

                            </div>
                        </div>
                        <div class="field">
                            <center><input class="ui tiny red button" type="submit" value="klik untuk APPROVE" name="commit"></center>
                        </div>

                    </div>
                </form>
            </div>
        </div>

        <!--Script-->
        <script src="Semantic-UI-1.0.0/dist/jquery-2.1.1.js" type="text/javascript"></script>
        <script src="Semantic-UI-1.0.0/dist/semantic.js" type="text/javascript"></script>
        <script src="date/jquery.plugin.js" type="text/javascript"></script>
        <script src="date/jquery.datepick.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                var fileExtentionRange = '.jpg,.png, .bmp';
                var MAX_SIZE = 4; // MB

                $(document).on('change', '.btn-file :file', function() {
                    var input = $(this);

                    if (navigator.appVersion.indexOf("MSIE") != -1) { // IE
                        var label = input.val();

                        input.trigger('fileselect', [1, label, 0]);
                    } else {
                        var label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
                        var numFiles = input.get(0).files ? input.get(0).files.length : 1;
                        var size = input.get(0).files[0].size;

                        input.trigger('fileselect', [numFiles, label, size]);
                    }
                });

                $('.btn-file :file').on('fileselect', function(event, numFiles, label, size) {
                    $('#attachmentName').attr('name', 'attachmentName'); // allow upload.

                    var postfix = label.substr(label.lastIndexOf('.'));
                    if (fileExtentionRange.indexOf(postfix.toLowerCase()) > -1) {
                        if (size > 1024 * 1024 * MAX_SIZE) {
                            alert('max size：<strong>' + MAX_SIZE + '</strong> MB.');

                            $('#attachmentName').removeAttr('name'); // cancel upload file.
                        } else {
                            $('#_attachmentName').val(label);
                        }
                    } else {
                        alert('file type：<br/> <strong>' + fileExtentionRange + '</strong>');

                        $('#attachmentName').removeAttr('name'); // cancel upload file.
                    }
                });
                //                $(document.getElementById("add")).addClass("active");
                //                $('.dropper').dropper();

                //Show dropdown on hover
                $('.ui.dropdown').dropdown({on: 'hover'});

                //Tambah film button handler
                $("#tambah").click(function() {
                    $("#addSidebar")
                    .sidebar('setting', {overlay: true})
                    .sidebar('toggle');
                });
                
                $('#popupDatepicker').datepick({dateFormat:'dd-M-yyyy'});
                $('#popupDatepicker1').datepick({dateFormat:'dd-M-yyyy'});

            });
        </script>
        <!--End of Local script-->
    </body>
</html>