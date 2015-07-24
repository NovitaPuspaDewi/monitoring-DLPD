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
            <div class="ui menu">
                <div class="ui floating dropdown link item">
                    <i class="edit icon"></i> MONITORING <i class="dropdown icon"></i>
                    <div class="menu">
                        <div class="ui three columns relaxed divided grid">
                            <div class="column">
                                <h4 class="ui header">Kwh 0</h4>
                                <div class="ui link list">
                                    <a class="item" >Sudah Cek</a>
                                    <a class="item" href="data-kwh0-belum-cek_1.jsp" >Belum Cek</a>
                                    <a class="item" href="kwh-0-cek-per-bulan_1.jsp">Cek per-bulan</a>
                                </div>
                            </div>
                            <div class="column">
                                <h4 class="ui header">Kwh Maks</h4>
                                <div class="ui link list">
                                    <a class="item">Sudah Cek</a>
                                    <a class="item" href="data-kwh-maks-belum-cek_1.jsp">Belum Cek</a>
                                    <a class="item" href="kwh-maks-cek-per-bulan_1.jsp">Cek per-bulan</a>
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

                <a class="item" id="cari-pelanggan" href="cari-pelanggan_1.jsp">
                    <i class="search icon"></i>LIHAT DETAIL PELANGGAN
                </a>
                <div class="right menu">
                    <form method="POST">
                        <div class="ui floating dropdown link item">
                            <i class="desktop icon"></i> OPERATOR <i class="dropdown icon"></i>
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
                $('.example .menu .browse')
                .popup({
                    inline   : true,
                    hoverable: true,
                    position : 'bottom left',
                    delay: {
                        show: 300,
                        hide: 800
                    }
                })
                ;
                $('.activating.element')
                .popup()
                ;
                                         
                
            });
            
           
            
            
        </script>
    </body>
</html>
