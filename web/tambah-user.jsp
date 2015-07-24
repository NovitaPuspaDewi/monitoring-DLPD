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
        List<DataPegawai> memberList = DataPegawai.getDataList();

        if (null != request.getParameter("cancel")) {
            //RequestDispatcher rd = request.getRequestDispatcher("tambah-user.jsp");
            //rd.forward(request, response);
            response.sendRedirect("tambah-user.jsp");

        }
        if (null != request.getParameter("commit")) {

            DataPegawai pegawai = new DataPegawai();
            pegawai.setmPaswordPegawai(request.getParameter("password"));
            pegawai.setmUsernamePegawai(request.getParameter("username"));
            pegawai.setmRolePegawai(request.getParameter("priviledge"));
            pegawai.setmTingkat(request.getParameter("tingkat"));
            pegawai.setmKode(request.getParameter("kode"));

            DataPegawai.simpanData(pegawai);

            response.sendRedirect("user-login.jsp");
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah User</title>
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

        <div class="ui three column grid">
            <div class="column"> </div>
            <div class="wide column">
                <form action="" id="saveMember">
                    <div class="ui fluid form segment">

                        <div class="field">
                            <label>Username</label>
                            <input placeholder="Username" name="username" type="text">
                        </div>
                        <div class="field">
                            <label>Password</label>
                            <input placeholder="Password" name="password" type="password">
                        </div>
                        <div class="field">
                            <label>Confirm Password</label>
                            <input placeholder="Password" name="confirm" type="password">
                        </div>
                        <div class="field">
                            <label>Kode Unit</label>
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
                            <label>Priviledge</label>
                            <div class="ui selection dropdown">
                                <input type="hidden" name="priviledge">
                                <div class="default text">Jenis Role</div>
                                <i class="dropdown icon"></i>
                                <div class="menu">
                                    <div class="item" data-value="ADMIN">Administrator</div>
                                    <div class="item" data-value="OPERATOR">Operator</div>
                                </div>
                            </div>
                        </div>
                        <div class="field">
                            <label>Tingkat</label>
                            <div class="ui selection dropdown">
                                <input type="hidden" name="tingkat">
                                <div class="default text">Tingkat</div>
                                <i class="dropdown icon"></i>
                                <div class="menu">
                                    <div class="item" data-value="RAYON">RAYON</div>
                                    <div class="item" data-value="AREA">AREA</div>
                                </div>
                            </div>
                        </div>
                        <div class="field">
                            <center><input class="ui tiny red button" type="submit" value="OK" name="commit"><input class="ui tiny blue button" type="submit" value="cancel" name="cancel"></center>
                        </div>
                    </div>
                </form>
            </div> 
            <div class="column"> </div>
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
                    username:
                        {
                        identifier: 'username',
                        rules:
                            [
                            {type: 'empty', prompt: 'Masukkan Username'},
            <%
                for (int i = 0; i < memberList.size(); i++) {
            %>
                                {type: 'not[<%=memberList.get(i).getmUsernamePegawai()%>]', prompt: 'Username telah digunakan'},
            <%
                }
            %>
                            ]
                        },
                        password:
                            {
                            identifier: 'password',
                            rules:
                                [
                                {type: 'empty', prompt: 'Masukkan Password'},
                                {type: 'length[5]', prompt: 'Password harus lebih dari 5 karakter'}
                            ]
                        },
                        confirm:
                            {
                            identifier: 'confirm',
                            rules:
                                [
                                {type: 'empty', prompt: 'Masukkan Konfirmasi Password'},
                                {type: 'match[password]', prompt: 'Password yang Anda masukkan tidak sesuai'}
                            ]
                        },
                        gender:
                            {
                            identifier: 'priviledge',
                            rules:
                                [
                                {type: 'empty', prompt: 'Pilih Jenis Role'}
                            ]
                        },
                        tingkat:
                            {
                            identifier: 'tingkat',
                            rules:
                                [
                                {type: 'empty', prompt: 'Pilih Tingkat'}
                            ]
                        } ,
                        kode:
                            {
                            identifier: 'kode',
                            rules:
                                [
                                {type: 'empty', prompt: 'Pilih Jenis Kode'}
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