<%-- 
    Document   : data-kwh-0
    Created on : Jun 29, 2015, 1:42:41 PM
    Author     : NOVITA
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Pelanggan Kwh 0</title>
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
                    DATA PELANGGAN KWH 0
                </h4>
                <form action="" id="saveMember">
                    <div class="ui fluid form segment">
                        <div class="two fields">
                            <div class="field">
                                <label>ID PELANGGAN</label>
                                <input placeholder="Username" name="idpel" type="text" value="22500909899">
                            </div>
                            <div class="field">
                                <label>Nama</label>
                                <input placeholder="Password" name="nama" type="text" value="JUNADI">
                            </div>
                        </div>
                        <div class="two fields">
                            <div class="field">
                                <label>Alamat</label>
                                <input placeholder="Password" name="alamat" type="text" value="JL.KASTURI GG.4">
                            </div>
                            <div class="field">
                                <label>Tarif</label>
                                <input placeholder="Username" name="tarif" type="text" value="R1T">
                            </div>
                        </div>
                        <div class="two fields">
                            <div class="field">
                                <label>Daya</label>
                                <input placeholder="Password" name="daya" type="text" value="450">
                            </div>
                            <div class="field">
                                <label>Kwh Maks</label>
                                <input placeholder="Password" name="maks" type="text" value="324">
                            </div>
                        </div>
                        <div class="two fields">
                            <div class="field">
                                <label>Pemakaian bulan ini</label>
                                <input placeholder="Username" name="kwhtot" type="text" value="0">
                            </div>
                            <div class="field">
                                <label>Tanggal Monitoring</label>
                                <div class="field">
                                    <input type="text" id="popupDatepicker" placeholder="Tanggal Monitoring" name="Tanggal" value="09/11/2014">
                                </div>
                            </div>
                        </div>
                        <div class="two fields">
                            <div class="field">
                                <label>Koordinat</label>
                                <input placeholder="Koordinat lokasi" name="koordinat" type="text" value="-190.87767,140.87988">
                            </div>
                            <div class="field">
                                <label>Verifikasi</label>
                                <input placeholder="Masukan verifikasi hasil monitoring" name="verifikasi" type="text" value="Rumah Kosong">
                            </div>
                        </div>

                        <div class="two field">
                            <div class="field">
                                <li><img src="img/kwh_1.jpg"></li>
                            </div>
                        </div>


                        <div class="field">
                            <center><input class="ui tiny red button" type="submit" value="APPROVE" name="commit"></center>
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
                var fileExtentionRange = '.jpg';
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
                
                $('#popupDatepicker').datepick({dateFormat:'dd-M-yy'});
                $('#popupDatepicker1').datepick({dateFormat:'dd-M-yy'});

                //Add film sidebar error prompt
                $("#addSidebar").form({
                    idfilm: {
                        identifier: 'idfilm',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Masukkan ID Film'
                            }
                        ]
                    },
                    judul: {
                        identifier: 'judul',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Masukkan Judul Film'
                            }
                        ]
                    },
                    durasi: {
                        identifier: 'durasi',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Masukkan Durasi Film'
                            }
                        ]
                    },
                    genre: {
                        identifier: 'genre',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Masukkan Genre Film'
                            }]
                    },
                    kategori: {
                        identifier: 'kategori',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Pilih Kategori Film'
                            }
                        ]
                    },
                    gambar: {
                        identifier: 'attachmentName',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Pilih Gambar Film'
                            }]
                    }
                }, {
                    on: 'submit',
                    inline: 'true'
                });
            });
        </script>
        <!--End of Local script-->

    </body>
</html>