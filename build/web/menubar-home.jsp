<%-- 
    Document   : menubar-home
    Created on : Dec 13, 2014, 1:16:22 AM
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
        <div class="container">
            <a class="item" id="home" href="home.jsp">
                <i class="home icon"></i> HOME
            </a>
            <a class="item" id="np" href="login-operator.jsp">
                <i class="user icon"></i> OPERATOR
            </a>
            <a class="item" id="signin" href="Login.jsp">
                <i class="user icon"></i> ADMIN
            </a>
            <div class="ui pointing dropdown link item">
                <i class="edit icon"></i> DASHBOARD <i class="dropdown icon"></i>
                <div class="menu">
                    <a class="item" id="kwh0" href="dashboard-0.jsp"><i class="archive icon"></i>Pelanggan Kwh 0</a>
                    <a class="item" id="kwhmaks" href="dashboard-maks.jsp"><i class="archive icon"></i>Pelanggan Kwh Maks</a>
                    <a class="item" id="tidak-beli-token" href="dashboard-TBT.jsp"><i class="archive icon"></i>Tidak Beli Token > 3 bulan</a>
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
