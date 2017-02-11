<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <link href="http://getbootstrap.com/examples/theme/theme.css" rel="stylesheet">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <style>
       #map {
        height: 400px;
        width: 100%;
       }
    </style>
  </head>
  <body>
  <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Bootstrap powered</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
   <div class="container theme-showcase" role="main">
	   <div class="jumbotron">
	        <h1>IP Lookup</h1>
	   </div>
	   <div id="map">
		   <script>
			    /*<![CDATA[*/
			      function initMap() {
			        var map = new google.maps.Map(document.getElementById('map'), {
			          zoom: 6,
			          center: new google.maps.LatLng("${latitude}", "${longtitude}"),
			        });
			        var marker = new google.maps.Marker({
			          position: new google.maps.LatLng("${latitude}", "${longtitude}"),
			          map: map
			        });
			      }
			      /*]]>*/
		    </script>
	   </div>
	   <div class="page-header">
        <h1>Gotcha !</h1>
      </div>
      <div class="row">
        <div class="col-md-6">
          <table class="table">
            <thead>
              <tr>
                <th>Ip Adress</th>
                <th>Country Name</th>
                <th>City</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>${ipadress}</td>
                <td>${countryName}, ${countryCode}</td>
                <td>${city}</td>
              </tr>
            </tbody>
          </table>
        </div>
	   
	   
	   
  </div>
    </div>

    
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=${api_key}&callback=initMap">
    </script>
    
    
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
       <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
</html>