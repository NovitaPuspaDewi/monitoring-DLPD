<%-- 
    Document   : menubar-admin
    Created on : Dec 12, 2014, 10:30:58 PM
    Author     : Lorencius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Semantic-UI-1.0.0/dist/semantic.css" rel="stylesheet" type="text/css">
        <link rel="shortcut icon" href="img/logo_PLN.jpg" type="image/jpg">
    </head>
    <body>
        <div class="ui fixed top menu">
            <div class="container">
                <div class="ui pointing dropdown link item">
                    <i class="search icon"></i> LIHAT DATA <i class="dropdown icon"></i>
                    <div class="menu">
                        <a class="item" id="kwh0" href="data-kwh-0-rayon.jsp"><i class="archive icon"></i>Pelanggan Kwh 0</a>
                        <a class="item" id="kwhmaks" href="data-kwh-maks-rayon.jsp"><i class="archive icon"></i>Pelanggan Kwh Maks</a>
                        <a class="item" id="tidak-beli-token" href="data-TBT-rayon.jsp"><i class="archive icon"></i>Tidak Beli Token > 3 bulan</a>
                    </div>
                </div>
                <div class="ui floating dropdown link item">
                    <i class="edit icon"></i> MONITORING <i class="dropdown icon"></i>
                    <div class="menu">
                        <div class="ui three columns relaxed divided grid">
                            <div class="column">
                                <h4 class="ui header">Kwh 0</h4>
                                <div class="ui link list">
                                    <a class="item">Sudah Cek</a>
                                    <a class="item" href="data-kwh0-belum-cek-rayon.jsp" >Belum Cek</a>
                                    <a class="item" href="kwh-0-cek-per-bulan-rayon.jsp">Cek per-bulan</a>
                                </div>
                            </div>
                            <div class="column">
                                <h4 class="ui header">Kwh Maks</h4>
                                <div class="ui link list">
                                    <a class="item">Sudah Cek</a>
                                    <a class="item" href="data-kwh-maks-belum-cek-rayon.jsp">Belum Cek</a>
                                    <a class="item" href="kwh-maks-cek-per-bulan-rayon.jsp">Cek per-bulan</a>
                                </div>
                            </div>
                            <div class="column">
                                <h4 class="ui header">PPTBT>3Bln</h4>
                                <div class="ui link list">
                                    <a class="item">Sudah Cek</a>
                                    <a class="item">Belum Cek</a>
                                    <a class="item">Cek per-bulan</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="ui floating dropdown link item">
                    <i class="edit icon"></i> APPROVE <i class="dropdown icon"></i>
                    <div class="menu">
                        <div class="ui three columns relaxed divided grid">
                            <div class="column">
                                <h4 class="ui header">Kwh 0</h4>
                                <div class="ui link list">
                                    <a class="item" href="data-sudah-approve-kwh-0-rayon.jsp">Sudah Approve</a>
                                    <a class="item" href="data-belum-approve-kwh-0-rayon.jsp" >Belum Aprrove</a>
                                    <a class="item" href="data-approve-semua-kwh-0-rayon.jsp">Cek Semua</a>
                                </div>
                            </div>
                            <div class="column">
                                <h4 class="ui header">Kwh Maks</h4>
                                <div class="ui link list">
                                    <a class="item" href="data-sudah-approve-kwh-maks-rayon.jsp">Sudah Approve</a>
                                    <a class="item" href="data-belum-approve-kwh-maks-rayon.jsp">Belum Approve</a>
                                    <a class="item" href="data-approve-semua-kwh-maks-rayon.jsp">Cek Semua</a>
                                </div>
                            </div>
                            <div class="column">
                                <h4 class="ui header">PPTBT>3Bln</h4>
                                <div class="ui link list">
                                    <a class="item">Sudah Approve</a>
                                    <a class="item">Belum Approve</a>
                                    <a class="item">Cek Semua</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <a class="item" id="cari-pelanggan" href="cari-pelanggan-rayon.jsp">
                    <i class="search icon"></i>LIHAT DETAIL PELANGGAN
                </a>
                <div class="right menu">
                    <form method="POST">
                        <div class="ui floating dropdown link item">
                            <i class="desktop icon"></i> ADMIN <i class="dropdown icon"></i>
                            <div class="menu">
                                <div class="header">
                                    Logged as
                                </div>
                                <div class="divider"></div>
                                <div class="item">
                                    ${name}
                                </div>
                                <div class="item">
                                    ${username}
                                </div>
                                <a class="item" href="Login.jsp?logout=yes"><i class="sign out icon"></i>Logout</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="Semantic-UI-1.0.0/dist/jquery-2.1.1.js" type="text/javascript"></script>
        <script src="Semantic-UI-1.0.0/dist/semantic.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('.ui.dropdown').dropdown({on: 'hover'});
                                          
                $('#hybrid select')
                .dropdown({
                    on: 'hover'
                })
                ;
                
                $('#hybrid1 select')
                .dropdown({
                    on: 'hover'
                })
                ;
                
                $('#hybrid2 select')
                .dropdown({
                    on: 'hover'
                })
                ;
                
                $('#hybrid3 select')
                .dropdown({
                    on: 'hover'
                })
                ;
            });
            
            
        </script>
    </body>
</html>
