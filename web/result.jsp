<%-- 
    Document   : newjsp1
    Created on : Jul 31, 2015, 3:20:43 PM
    Author     : NOVITA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.*"%>
<!DOCTYPE html>
<html>   
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Berhasil</title>
        <link rel="shortcut icon" href="img/logo_PLN.jpg" type="image/jpg">
    </head>

    <body> 
        <form>
            <div id="result">
                <h3>${requestScope["message"]}</h3>
                <h3>Foto ${id_blth} berhasil disimpan sebagai ${requestScope["fileName"]}</h3>
            </div>
        </form>
    </body>
</html>
