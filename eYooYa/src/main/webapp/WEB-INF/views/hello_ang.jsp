<!DOCTYPE html>
<html>

<head>
	<script data-require="angular.js@1.2.25" data-semver="1.2.25"
		src="https://code.angularjs.org/1.2.25/angular.js"></script>
	
	<link rel="stylesheet"
		href="resources/css/angucomplete/angucomplete.css" />
	<script src="resources/js/angucomplete/angucomplete.js"></script>
	<script src="resources/js/angucomplete/script.js"></script>
	<link href="resources/css/main.css" rel="stylesheet">
	
	<link href="resources/css/bootstrap/bootstrap.min.css" rel="stylesheet">
	<!-- Include roboto.css to use the Roboto web font, material.css to include the theme and ripples.css to style the ripple effect -->
	<link href="resources/css/roboto.min.css" rel="stylesheet">
	<link href="resources/css/material.min.css" rel="stylesheet">
	<link href="resources/css/ripples.min.css" rel="stylesheet">
</head>

<body ng-app="app">
	<div class="container move-down">

		<form class="form-horizontal " role="form" name="AddShareForm"
			novalidate ng-controller="AddArticleShareCtrl"
			ng-submit="AddShareForm.$valid && submit()">
			<div class="form-group">
				<label for="members" class="col-xs-2 col-xl-2 control-label"></label>
				<div class="col-xs-10 col-xl-10">

					<angucomplete id="members" placeholder="Search Members" pause="100"
						minlength=2 selectedobject="nick" url="api/i/v1/serach/ac?token="
						datafield="results" titlefield="name,nickName"
						descriptionfield="description" imagefield="pic"
						inputclass="form-control form-control-small input-lg" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-xs-2 col-xl-2">
					<label for="create-employee"
						class="col-xs-2 col-xl-2 control-label"></label>
				</div>
				<div class="col-xs-8 col-xl-8">
					<input type="text" placeholder="Enter Employee"
						class="form-control form-control-small input-lg"
						value="{key:value}" />
				</div>
				<div class="col-xs-2 col-xl-2">
					<button type="submit" class="btn btn-lg btn-default">Employee</button>
				</div>

			</div>
		</form>

		<h3>Connect to Facebook</h3>

		<form action="connect/facebook" method="POST">
			<input type="hidden" name="scope" value="read_stream" />
			<div class="formInfo">
				<p>You aren't connected to Facebook yet. Click the button to
					connect this application with your Facebook account.</p>
			</div>
			<p>
				<button type="submit">Connect to Facebook</button>
			</p>
		</form>


		<form id="fb_signin" action="signin/facebook" method="POST">

			<button class="btn btn-material-blue btn-lg" type="submit">SignIn
				using Facebook</button>
			<%-- 				<img
					src="<c:url value="/resources/social/twitter/sign-in-with-twitter-d.png"/>" /> --%>

		</form>
	</div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="resources/js/bootstrap/bootstrap.min.js"></script>

	<script src="resources/js/ripples.min.js"></script>
	<script src="resources/js/material.min.js"></script>
	<script>
		$(document).ready(function() {
			// This command is used to initialize some elements and make them work properly
			$.material.init();
		});
	</script>
</body>

</html>
