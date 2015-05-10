<!DOCTYPE html>
<html ng-app="Test">
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css"href="style.css">
    
    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?libraries=places&sensor=false"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.js"></script>
    <script src="resources/js/script.js"></script>
    <script src="ngAutocomplete.js"></script>
  
  
</head>

<body>

<div ng-controller="TestCtrl">

<form id="form" role="form">

    <div class="form-group move-down">
        <label for="Autocomplete">Generic Autocomplete</label>
        <input type="text" id="Autocomplete" class="form-control" ng-autocomplete="result1" details="details1" options="options1"/>
    </div>
    <div>result: {{result}}</div>

    <div class="form-group move-down">
        <label for="Autocomplete">Autocomplete - Cities in Canada</label>
        <input type="text" id="Autocomplete" class="form-control" ng-autocomplete="result2" details="details2" options="options2"/>
    </div>
    <div>result: {{result}}</div>
    
    <div class="form-group move-down">
        <label for="Autocomplete">Autocomplete - Establishments in the UK</label>
        <input type="text" id="Autocomplete" class="form-control" ng-autocomplete="result3" details="details3" options="options3"/>
    </div> 
     <div>result: {{result}}</div>
</form>
</div>


</body>
</html>