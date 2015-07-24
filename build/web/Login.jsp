<%-- 
    Document   : index
    Created on : Nov 6, 2014, 5:10:04 PM
    Author     : NOVITA
--%>
<%@page import="Model.DataPegawai"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <%
        if (null != request.getParameter("commit")) {
            session = request.getSession(true);
            session.setMaxInactiveInterval(60 * 60 * 24);

            int login = DataPegawai.validateLoginCredential(request.getParameter("username"), request.getParameter("password"), request.getParameter("commit"), request.getParameter("kode"));
            switch (login) {
                case 0:
                    out.print("<script type=\"text/javascript\">");
                    out.print("alert(\"Unregistered username\");");
                    out.print("</script>");
                    break;
                case 1:
                    out.print("<script type=\"text/javascript\">");
                    out.print("alert(\"Username or Password or Role or Kode was incorrect\");");
                    out.print("</script>");
                    break;
                case 2:
                    session.setAttribute("role", "Operator");
                    session.setAttribute("name", request.getParameter("username"));
                    session.setAttribute("username", request.getParameter("kode"));
                    response.sendRedirect("menubar-operator.jsp");
                    break;
                case 3:
                    session.setAttribute("role", "Admin");
                    session.setAttribute("name", request.getParameter("username"));
                    session.setAttribute("username", request.getParameter("kode"));
                    response.sendRedirect("menubar-admin.jsp");
                    break;
                case 20:
                    session.setAttribute("role", "Admin");
                    session.setAttribute("name", request.getParameter("username"));
                    session.setAttribute("username", request.getParameter("kode"));
                    response.sendRedirect("menubar-admin-00.jsp");
                    break;
                case 30:
                    session.setAttribute("role", "Operator");
                    session.setAttribute("name", request.getParameter("username"));
                    session.setAttribute("username", request.getParameter("kode"));
                    response.sendRedirect("menubar-operator-00.jsp");
                    break;
                case 21:
                    session.setAttribute("role", "Admin");
                    session.setAttribute("name", request.getParameter("username"));
                    session.setAttribute("username", request.getParameter("kode"));
                    response.sendRedirect("menubar-admin-00.jsp");
                    break;
                case 31:
                    session.setAttribute("role", "Operator");
                    session.setAttribute("name", request.getParameter("username"));
                    session.setAttribute("username", request.getParameter("kode"));
                    response.sendRedirect("menubar-operator-00.jsp");
                    break;
                case 22:
                    session.setAttribute("role", "Admin");
                    session.setAttribute("name", request.getParameter("username"));
                    session.setAttribute("username", request.getParameter("kode"));
                    response.sendRedirect("menubar-admin-00.jsp");
                    break;
                case 32:
                    session.setAttribute("role", "Operator");
                    session.setAttribute("name", request.getParameter("username"));
                    session.setAttribute("username", request.getParameter("kode"));
                    response.sendRedirect("menubar-operator-00.jsp");
                    break;
                case 23:
                    session.setAttribute("role", "Admin");
                    session.setAttribute("name", request.getParameter("username"));
                    session.setAttribute("username", request.getParameter("kode"));
                    response.sendRedirect("menubar-admin-00.jsp");
                    break;
                case 33:
                    session.setAttribute("role", "Operator");
                    session.setAttribute("name", request.getParameter("username"));
                    session.setAttribute("username", request.getParameter("kode"));
                    response.sendRedirect("menubar-operator-00.jsp");
                    break;
                case 24:
                    session.setAttribute("role", "Admin");
                    session.setAttribute("name", request.getParameter("username"));
                    session.setAttribute("username", request.getParameter("kode"));
                    response.sendRedirect("menubar-admin-00.jsp");
                    break;
                case 34:
                    session.setAttribute("role", "Operator");
                    session.setAttribute("name", request.getParameter("username"));
                    session.setAttribute("username", request.getParameter("kode"));
                    response.sendRedirect("menubar-operator-00.jsp");
                    break;
                case 25:
                    session.setAttribute("role", "Admin");
                    session.setAttribute("name", request.getParameter("username"));
                    session.setAttribute("username", request.getParameter("kode"));
                    response.sendRedirect("menubar-admin-00.jsp");
                    break;
                case 35:
                    session.setAttribute("role", "Operator");
                    session.setAttribute("name", request.getParameter("username"));
                    session.setAttribute("username", request.getParameter("kode"));
                    response.sendRedirect("menubar-operator-00.jsp");
                    break;
                default:
                    System.err.println("ENTER DEFAULT");
                    break;
            }
        }
    %>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN ADMINISTRATOR</title>
        <link rel="shortcut icon" href="img/logo_PLN.jpg" type="image/jpg">
        <link href="Semantic-UI-1.0.0/dist/semantic.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <!--Menu bar-->
        <div class="ui fixed top red inverted menu">
            <%@include file="menubar-home.jsp" %>
        </div>
        <!--End of Menu bar-->

        <div class="ui one column page grid">
            <div class="column">
                <div class="ui info message">
                    <div class="header">
                        You have to sign in
                    </div>
                    <p>
                        Isi form dengan User ID dan Password anda jika anda sudah terdaftar sebagai user
                        kemudian tekan tombol ADMIN. <br>
                        Untuk informasi lebih lanjut, jika tidak terdaftar Anda dapat menghubungi administrator kami, terimakasih.

                    </p>
                </div>
            </div>
        </div>
        <div class="ui three column page grid">
            <div class="column"></div>
            <div class="column">
                <h4 class="ui top center aligned attached inverted red block header">
                    LOGIN
                </h4>
                <form class="ui form segment attached" method="POST" id="mtixSignin">
                    <div class="field">
                        <div class="ui left icon input">
                            <input name="username" type="text" placeholder="Username">
                            <i class="user icon"></i>
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui left icon input">
                            <input name="password" type="password" placeholder="Password">
                            <i class="lock icon"></i>
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui selection dropdown">
                            <input type="hidden" name="kode">
                            <div class="default text">Kode Unit</div>
                            <i class="dropdown icon"></i>
                            <div class="menu">
                                <div class="item" data-value="22">AREA</div>
                                <div class="item" data-value="22500">RAYON KAPUAS</div>
                                <div class="item" data-value="22510">RAYON PULANG PISAU</div>
                                <div class="item" data-value="22520">RAYON BUNTOK</div>
                                <div class="item" data-value="22530">RAYON TAMIANG LAYANG</div>
                                <div class="item" data-value="22540">RAYON MUARA TEWEH</div>
                                <div class="item" data-value="22550">RAYON PURUK CAHU</div>
                            </div>
                        </div>
                    </div>
                    <div class="field">
                        <center><input class="ui tiny red button" type="submit" value="ADMIN" name="commit"></center>
                    </div>
                </form>
            </div>
            <div class="column"></div>
        </div>
        <!--Script-->
        <script src="Semantic-UI-1.0.0/dist/jquery-2.1.1.js" type="text/javascript"></script>
        <script src="Semantic-UI-1.0.0/dist/semantic.js" type="text/javascript"></script>
        <script type="text/javascript">
            //Reset login sidebar value when reload
            //            var originalState = $('#mtixSignin').clone();
            //            $('#mtixSignin').replaceWith(originalState);
             $('.ui.dropdown').dropdown({on: 'hover'});

            $(document).ready(function() {
                $(document.getElementById("signin")).addClass("active");
                $(document.getElementById("right")).remove();
                $("#mtixSignin").form({
                    username: {
                        identifier: 'username',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Masukkan username'
                            }
                        ]
                    },
                    password: {
                        identifier: 'password',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Masukkan password'
                            }
                        ]
                    }
                    ,
                    kode: {
                        identifier: 'kode',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Masukkan Kode Unit'
                            }
                        ]
                    }
                },{
                    on: 'submit',
                    inline: 'true'
                });
            });
        </script>
    </body>
</html>