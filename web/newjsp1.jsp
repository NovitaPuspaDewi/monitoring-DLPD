<%-- 
    Document   : newjsp1
    Created on : Jul 31, 2015, 3:20:43 PM
    Author     : NOVITA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pilih Foto</title>
        <link rel="shortcut icon" href="img/logo_PLN.jpg" type="image/jpg">
    </head>

    <body> 
        <div>
            <h3> Pilih foto yang akan diupload </h3>
            <form action="uploadHandler" method="post" enctype="multipart/form-data">
                <input type="file" name="file" />
                <input type="submit" value="upload" />
            </form>          
        </div>

    </body>
</html>