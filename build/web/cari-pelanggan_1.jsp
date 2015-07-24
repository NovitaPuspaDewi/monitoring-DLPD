<%-- 
    Document   : data-kwh-0
    Created on : Jun 29, 2015, 1:42:41 PM
    Author     : NOVITA
--%>

<%@page import="Model.DetailPelanggan_All"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String status = null;
                
        if (null != request.getParameter("cari")) {
            String idpel = request.getParameter("idpel");
            session.setAttribute("idpel", idpel);
            response.sendRedirect("detail-pelanggan_1.jsp");
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
                                    <label>Masukan ID PELANGGAN</label>
                                    <input placeholder="contoh:22500987866" name="idpel" type="text">
                                </div>
                                <div class="field">
                                    <label> Klik untuk mulai pencarian</label>
                                    <input class="ui tiny red button" type="submit" value="CARI" name="cari">
                                </div>
                            </div>
                            <a href="cari-pelanggan-TBT_1.jsp">klik untuk cari Pelanggan Tidak Beli Token</a>

                        </div>
                    </form>
                    </p>
                </div>
                <br><br>

            </div>
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