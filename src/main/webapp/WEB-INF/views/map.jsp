<!DOCTYPE html>
<html>
  <head>
    <style>
       #map {
        height: 400px;
        width: 100%;
       }
    </style>
  </head>
  <body>
    <h3>Locator</h3>
    <div id="map"></div>
    <script>
    /*<![CDATA[*/
      function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 4,
          center: new google.maps.LatLng("${latitude}", "${longtitude}"),
        });
        var marker = new google.maps.Marker({
          position: new google.maps.LatLng("${latitude}", "${longtitude}"),
          map: map
        });
      }
      /*]]>*/
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=${api_key}&callback=initMap">
    </script>
  </body>
</html>