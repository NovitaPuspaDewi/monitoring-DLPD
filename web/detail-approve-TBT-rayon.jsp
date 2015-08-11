<%-- 
    Document   : data-kwh-0
    Created on : Jun 29, 2015, 1:42:41 PM
    Author     : NOVITA
--%>
<%@page import="java.util.Date"%>
<%@page import="Model.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String id1 = session.getAttribute("id_blth").toString();
        String id2 = session.getAttribute("id_blth").toString();
        String link = session.getAttribute("link").toString();

        String blth = id1.substring(0, 6);
        String idpel = id2.substring(6);
        String nama = null, alamat = null, tarif = null, koordinat = null, tgl_upload = null,
                verifikasi = null, petugas_upload = null, tgl_bayar = null, bulan = null, no_meter = null, unitup = null,
                petugas_app = null, tgl_app = null;

        int daya = 0;

        List<LihatData_TBT> kendaraanList = LihatData_TBT.getDataListTBT(blth, idpel);
        for (int i = 0; i < kendaraanList.size(); i++) {
            nama = kendaraanList.get(i).getmNama();
            alamat = kendaraanList.get(i).getmAlamat();
            tarif = kendaraanList.get(i).getmTarif();
            daya = kendaraanList.get(i).getmDaya();
            unitup = kendaraanList.get(i).getmUnitup();
            tgl_bayar = kendaraanList.get(i).getmTgl_Bayar();
            koordinat = kendaraanList.get(i).getmKoordinat();
            tgl_upload = kendaraanList.get(i).getmTgl_Monitor();
            verifikasi = kendaraanList.get(i).getmVerifikasi();
            petugas_upload = kendaraanList.get(i).getmPetugas_Upload();
            bulan = kendaraanList.get(i).getmBulan();
            no_meter = kendaraanList.get(i).getmNoMeter();
            petugas_app = kendaraanList.get(i).getmPetugas_Verifikasi();
            tgl_app = kendaraanList.get(i).getmTgl_Approve();
        }

        if (request.getParameter("commit") != null) {

            String date = new Date().toString();
            String alasan = request.getParameter("alasan");
            String user = session.getAttribute("name").toString();
            String pembatalan = "dibatalkan oleh " + user + " (" + date + ") " + alasan;

            Approve app = new Approve();
            app.setmVerifikasi(pembatalan);
            app.setmIdpel(idpel);
            app.setmBlth(blth);
            Approve.Batal_Approve_TBT(app);

            out.print("<script type=\"text/javascript\">");
            out.print("alert(\"Approve dibatalkan! \");");
            out.print("window.location = '" + link + "';");
            out.print("</script>");
        }

        if (request.getParameter("foto") != null) {
            session.setAttribute("link1", "detail-approve-TBT-rayon.jsp");
            response.sendRedirect("display-foto-tbt.jsp");
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Pelanggan TBT</title>
        <link href="semantic/packaged/css/semantic.css" rel="stylesheet" type="text/css">
        <link rel="shortcut icon" href="img/logo_PLN.jpg" type="image/jpg">
        <link href="date/redmond.datepick.css" rel="stylesheet" type="text/css">
    </head>
    <body style="background-color:#CD5C5C">
        <!--Menu bar-->
        <%@include file="menubar-admin-00.jsp" %>
        <br>
        <br>
        <br>
        <!--End of Menu bar-->
        <div class="ui one column page grid">
            <div class="column">
                <h4 class="ui top attached center aligned inverted red block header">
                    DATA PELANGGAN TBT
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
                                <label>No Meter
                                    <input name="maks" type="text" value="<%=no_meter%>" disabled="disabled"></label>
                            </div>
                        </div>
                        <div class="two fields">
                            <div class="field">
                                <label>Tgl Bayar
                                    <input name="kwhtot" type="text" value="<%=tgl_bayar%>" disabled="disabled"></label>
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
                                <label>Tanggal Approve
                                    <input name="tgl_approve" type="text" value="<%=tgl_app%>" disabled="disabled"></label>
                            </div>
                            <div class="field">
                                <div class="field">
                                    <label>Petugas Approve
                                        <input name="petugas_approve" type="text" value="<%=petugas_app%>" disabled="disabled"></label>
                                </div>
                            </div>
                        </div>
                        <div class="two fields">
                            <div class="field">
                                <div class="field">
                                    <label>Tidak Beli Token
                                        <input name="petugas_monitor" type="text" value="<%=bulan%> bulan" disabled="disabled"></label>
                                </div>
                            </div>
                            <div class="field">
                                <label>Klik untuk lihat Foto
                                    <input class="ui tiny red button" type="submit" value="LIHAT FOTO" name="foto"></label>
                            </div>
                        </div>

                    </div>
                </form>
                <div class="ui fluid form segment">
                    <div class="field">
                        <div class="ui action input">
                            <form id="Batal">
                                <label><b>PEMBATALAN STATUS APPROVE</b></label>
                                <div>
                                    <h3> Isi alasan pembatalan </h3>
                                    <div class="field">
                                        <input name="alasan" id="alasan" type="text" placeholder="masukan alasan pembatalan">
                                    </div>
                                    <div class="field">
                                        <button class="ui tiny blue button" type="submit" value="BATALKAN" name="commit">BATALKAN</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
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
                
                $("#Batal").form({
                    alasan: {
                        identifier: 'alasan',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Masukkan alasan pembatalan'
                            }
                        ]
                    }
                },{
                    on: 'submit',
                    inline: 'true'
                });

                
                $('#popupDatepicker').datepick({dateFormat:'dd-M-yyyy'});
                $('#popupDatepicker1').datepick({dateFormat:'dd-M-yyyy'});

            });
        </script>
        <!--End of Local script-->
    </body>
</html>