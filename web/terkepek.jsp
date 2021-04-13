<%-- 
    Document   : terkepek
    Created on : 2021.04.12., 14:27:30
    Author     : Nami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="lekerdez" class="lekerdez.LekerdezOrszagokAdataiBean"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Térképek kontinensenként</title>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            google.charts.load('current', {
                'packages': ['geochart'],
                'mapsApiKey': 'AIzaSyAWMf5oMxinOr48PBWSnjm_6zA6QQWg9KA'
            });
            google.charts.setOnLoadCallback(drawRegionsMap);
            function drawRegionsMap() {
                var data = google.visualization.arrayToDataTable([
                    ['Ország', 'Városok száma'],
            <%=lekerdez.europaTerkep()%>
                ]);

                var options = {};
                var chart = new google.visualization.GeoChart(document.getElementById('regions_div'));
                chart.draw(data, options);
            }
        </script>
        <script type="text/javascript">
            google.charts.load('current', {
                'packages': ['geochart'],
                'mapsApiKey': 'AIzaSyAWMf5oMxinOr48PBWSnjm_6zA6QQWg9KA'
            });
            google.charts.setOnLoadCallback(drawRegionsMap);
            function drawRegionsMap() {
                var data = google.visualization.arrayToDataTable([
                    ['Ország', 'Városok száma'],
            <%=lekerdez.amerikaTerkep()%>
                ]);

                var options = {};
                var chart = new google.visualization.GeoChart(document.getElementById('regions_div'));
                chart.draw(data, options);
            }
        </script>
    </head>
    <body>
        <h1>Térképek</h1>

        <p><a href="loginOK.jsp">Privát lap</a></p>
    </body>
</html>
