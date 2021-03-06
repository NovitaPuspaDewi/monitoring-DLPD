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
        <title>Data PPTBT > 3 Bulan</title>
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
       
            <div class="column">
                <div class="ui fluid form segment">
                    <div class="row">
                        <div class="ten wide column">
                            <h4 class="ui top attached center aligned inverted red block header">
                                DATA PPTBT > 3 BULAN
                            </h4>
                            <table class="ui padded table segment attached" id="filmTable">
                                <thead>
                                    <tr>
                                        <th>BLTH</th>
                                        <th>ID PELANGGAN</th>
                                        <th>NAMA</th>
                                        <th>ALAMAT</th>
                                        <th>TARIF</th>
                                        <th>DAYA</th> 
                                        <th>KWH MAKS</th>
                                        <th>TOTAL KWH</th>
                                        <th>STATUS MONITORING</th>
                                        <th>LIHAT DETAIL</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%                                        
                                        for (int i = 0; i < 10; i++) {
                                    %>
                                    
                                    <tr>
                                        <td>201501</td>
                                        <td>22500234590</td>
                                        <td>JUNADI</td>
                                        <td>JL.PATIH RUMBIH 20</td>
                                        <td>R1T</td>
                                        <td>900</td>
                                        <td><%=200%></td>
                                        <td>780</td>
                                        <td>BELUM MONITOR</td>
                                        <td><center><input class="ui tiny red button" type="submit" value="DETAIL" name="commit"></center></td>
                                    </tr>
                                    <tr>
                                        <td>201501</td>
                                        <td>22500234596</td>
                                        <td>AMINUDIN</td>
                                        <td>JL.KASTURI GG.4</td>
                                        <td>R1T</td>
                                        <td>450</td>
                                        <td><%=440%></td>
                                        <td>570</td>
                                        <td>SUDAH MONITOR</td>
                                        <td><center><input class="ui tiny red button" type="submit" value="DETAIL" name="commit"></center></td>
                                    </tr>
                                    <% }%>

                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>
            </div>
               
        <!--Script-->
        <script src="Semantic-UI-1.0.0/dist/jquery-2.1.1.js" type="text/javascript"></script>
        <script src="Semantic-UI-1.0.0/dist/semantic.js" type="text/javascript"></script>
        <script src="date/jquery.plugin.js" type="text/javascript"></script>
        <script src="date/jquery.datepick.js" type="text/javascript"></script>
        <!--Local Script-->
       
    </body>
</html>