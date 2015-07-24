<%-- 
    Document   : tambah-user
    Created on : Nov 9, 2014, 6:23:30 PM
    Author     : NOVITA
--%>

<%@page import="Model.DataPegawai"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%
        if (request.getParameter("cari2") != null) {
            String unitup = request.getParameter("unitup");
            session.setAttribute("unitup", unitup);
            response.sendRedirect("tampil-data-approve-semua-kwh-maks-unitup.jsp");
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Approve Kwh Maks per-Unitup</title>
        <link href="semantic/packaged/css/semantic.css" rel="stylesheet" type="text/css">
        <link rel="shortcut icon" href="img/logo_PLN.jpg" type="image/jpg">
    </head>
    <body>
        <!--Menu bar-->
        <%@include file="menubar-admin.jsp" %>
        <br>
        <br>
        <br>
        <!--End of Menu bar-->
        
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
            });
        </script>

        <!--End of Local Script-->

    </body>
</html>