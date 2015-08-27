<!DOCTYPE html>


<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>RateMe</title>
<meta name="generator" content="rateMe" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="resources/bootstrap/style/bootstrap.min.css"
	rel="stylesheet" />

<link href="resources/css/main.css" rel="stylesheet">
<!-- <link href="resources/bootflat/css/bootflat.min.css" rel="stylesheet" /> -->


<!-- script references -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/plugins/typeahead/bootstrap3-typeahead.js"></script>
<script src="resources/plugins/hogan/hogan-3.0.1.js"></script>
<script>
	$(document).ready(function() {
		
                                                            		
		var templ =  Hogan.compile(['<div><img width=\"10%\"class=\"img-thumbnail\" src=\"{{pic}}\"/>',
		                                '<strong>{{name}}</strong> - {{title}}</div>'
		                           ].join(''));
		

 		$('#name-search .typeahead').typeahead({
			minLength : 1,
			hint : true
		}, {
			limit : 7,
			source : function(query, syncresults, process) {

				if (typeof searching != 'undefined') {
					clearTimeout(searching);
					//process([]);
				}
				searching = setTimeout(function() {
					return $.getJSON('api/i/v1/serach/ac?loc=nyc', {
						token : query
					}, function(data) {

						// only search if stop typing for 300ms aka fast typers
						return process(data.results); 
					});
				}, 300); // 300 ms
			},
			display: 'name',
			 templates: {
			    suggestion: function (data) {
			    	return templ.render(data);			    
			    }
			}			 
		});;
		
	});


</script>

<style type="text/css">
.bs-example {
	font-family: sans-serif;
	position: relative;
	margin: 100px;
}
/* .typeahead, .tt-query, .tt-hint {
	border: 2px solid #CCCCCC;
	border-radius: 8px;
	font-size: 24px;
	height: 30px;
	line-height: 30px;
	outline: medium none;
	padding: 8px 12px;
	width: 396px;
} */
.typeahead {
	background-color: #FFFFFF;
}

.typeahead:focus {
	border: 2px solid #0097CF;
}

.tt-query {
	box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
}

.tt-hint {
	color: #999999;
}

.tt-dataset {
	background-color: #FFFFFF;
	border: 1px solid rgba(0, 0, 0, 0.2);
	border-radius: 8px;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
	margin-top: 12px;
	padding: 8px 0;
	width: 422px;
}

.tt-suggestion {
	font-size: 14px;
	line-height: 14px;
	padding: 3px 20px;
}

.tt-suggestion.tt-cursor {
	background-color: #0097CF;
	color: #FFFFFF;
}

.tt-suggestion p {
	margin: 0;
}


</style>
</head>

<body>

	<nav class="navbar navbar-trans navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-collapsible">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!-- <a class="navbar-brand" href="#">RateMe</a> -->
			</div>
			<div class="navbar-collapse collapse" id="navbar-collapsible">

				<form class="navbar-form navbar-left">

<!-- 					<div id="category-search" class="form-group">
						<input class="typeahead form-control control-left input-sm"
							type="text" placeholder="All">
					</div>  -->

					<div id="name-search" class="form-group">
						<input class="typeahead form-control input-sm" type="text"
							placeholder="Search employees, businesses and more">

					</div>


					<div id="location-search" class="form-group">
						<input class="typeahead form-control control-right input-sm"
							type="text" placeholder="Location">
					</div>
				</form>


				<!-- 				<div class="nav navbar-nav navbar-right ">
					<a href="#">Sign In</a>
				</div> -->
			</div>
		</div>
	</nav>






</body>

</html>