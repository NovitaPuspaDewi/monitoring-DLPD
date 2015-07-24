<%-- 
    Document   : home
    Created on : Nov 9, 2014, 12:35:02 PM
    Author     : Lorencius
--%>


<!DOCTYPE html>
<html>
    <head>
        <title>SIMON MANOLTOK</title>
        <link rel="shortcut icon" href="img/logo_PLN.jpg" type="image/jpg">
        <link href="Semantic-UI-1.0.0/dist/semantic.css" rel="stylesheet" type="text/css">
        <link href="bxslider/jquery.bxslider.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="pusher">
            <!--Menu bar-->
            <div class="ui fixed top red inverted menu">
                <%@include file="menubar-home.jsp" %>
            </div>
            <!--End of Menu bar-->

            <!--Main body-->
            <div class="ui grid">
                <div class="three wide column">

                </div>

                <div class="ten wide column">
                    <h2 class="ui top center aligned attached inverted red block header">
                        <center>SIMON MANOLTOK<br><h4>SIstem MONitoring kwh MAks, kwh NOL, dan Pelanggan Prabayar Tidak Beli TOKen > 3 Bulan</h4></center>
                    </h2>
                    <div class="ui segment attached">
                        <ul id="slider1">
                            <li><img src="img/pln_tampak_depan.jpg" alt="slide1" title="PLN Area Kuala Kapuas"></li>
                            <li><img src="img/pemeriksaan_gardu.jpg" alt="slide2" title="PLN Area Kuala Kapuas"></li>
                            <li><img src="img/pembangkit.jpg" alt="slide2" title="PLN Area Kuala Kapuas"></li>
                        </ul>
                    </div>   
                    <h4 class="ui top center aligned attached inverted red block header">
                        PLN Area Kuala Kapuas
                    </h4>
                    <div class="ui segment attached">
                        <ul id="slider2">
                            <li><img src="img/logo_PLN.jpg" alt="slide1"></li>
                            <li><img src="img/no_suap.jpg" alt="slide2" ></li>
                            <li><img src="img/listrik_pintar.jpg" alt="slide2" ></li>
                        </ul>
                    </div>
                </div>
                <div class="three wide column">
                    <div>

                    </div>
                </div>
            </div>
            <!--End of Main body-->

            <!--Script-->
            <script src="Semantic-UI-1.0.0/dist/jquery-2.1.1.js" type="text/javascript"></script>
            <script src="bxslider/jquery.bxslider.js" type="text/javascript"></script>
            <script src="Semantic-UI-1.0.0/dist/semantic.js" type="text/javascript"></script>
            <script type="text/javascript">
                $(document).ready(function() {
                    //Slideshow 1
                    $('#slider1').bxSlider({
                        speed: 1000, //transition speed
                        mode: 'horizontal', //transition mode
                        controls: false, //control prev, next
                        captions: true, //captions based on its title
                        auto: true, //auto slide
                        autoStart: true, //auto start when the page load
                        autoControls: false,
                        adaptiveHeight: true
                    });

                    //Slideshow 2
                    $('#slider2').bxSlider({
                        speed: 1000,
                        auto: true,
                        controls: false,
                        autoStart: true,
                        autoControls: false,
                        captions: true,
                        slideWidth: 200,
                        minSlides: 4,
                        maxSlides: 4,
                        moveSlides: 1
                    });

                });
            </script>
    </body>
</html>

