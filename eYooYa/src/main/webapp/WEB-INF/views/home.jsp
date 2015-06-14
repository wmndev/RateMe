<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>RateMe</title>
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="resources/css/bootstrap/bootstrap.min.css" rel="stylesheet">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
<link href="resources/css/main.css" rel="stylesheet">

<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>

<link rel="stylesheet"
	href="resources/css/angucomplete/angucomplete.css" />
<script src="resources/js/angucomplete/angucomplete.js"></script>
<script src="resources/js/angucomplete/script.js"></script>
</head>
<body ng-app="app">
	<nav class="navbar navbar-trans navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-collapsible">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">RateMe</a>
			</div>
			<div class="navbar-collapse collapse" id="navbar-collapsible">

				<form class="navbar-form navbar-left">

					<div class="form-group">
						<angucomplete id="members"
							placeholder="Search employees, businesses and more" pause="100"
							ng-model="searchStr1" minlength=2 selectedobject="nick"
							dataBind="location" url="api/i/v1/serach/ac?token="
							datafield="results" updateParent="updateParentModel()"
							titlefield="name,nickName" descriptionfield="description"
							imagefield="pic" inputclass="form-control input-md" />

					</div>

					<div class="form-group">
						<angucomplete id="locations" placeholder="Location" pause="100"
							ng-model="location" minlength=1 selectedobject="nick"
							url="api/i/v1/serach/loc?token=" datafield="results"
							titlefield="name,nickName" descriptionfield="description"
							imagefield="pic" inputclass="form-control control-right input-md" />
					</div>
				</form>


				<div class="nav navbar-nav navbar-right ">
					<a href="#">Sign In</a>
					</p>
				</div>
			</div>
		</div>
	</nav>


	<section class="container">
		<div class="row" style="margin: 50px;"></div>
		<div class="col-sm-7">
			<div class="row">
				<header>
					<h1>Good things happen when your stuff lives here</h1>
					<h3>Dropbox keeps your files safe, synced, and easy to share.</h3>
				</header>
				<!--/row-->
			</div>
			<!--/container-->
		</div>

		<div class="col-sm-3 col-sm-offset-2">
			<form id="fb_signin" action="signin/facebook" method="POST"
				class="form-horizontal">


				<div class="form-group">
					<label for="submit" class="sr-only"></label>
					<button type="submit" class="form-control btn btn-primary">Sign
						Up using Facebook</button>
				</div>

				<fieldset>
					<legend align="center">OR</legend>
				</fieldset>
				<%-- 

				<button class="btn btn-default" type="submit">SignIn
					using Facebook</button>
								<img
					src="<c:url value="/resources/social/twitter/sign-in-with-twitter-d.png"/>" /> --%>

			</form>

			<form:form modelAttribute="userSecurity" name="signup_form" id="signup_form"
				class="form-horizontal" action="registration" method="post">
				<div id="form-names" class="form-group">
					<div class="col-sm-6 clear-input-padding">
						<label for="firstName" class="sr-only"></label>
						<form:input id="firstName" path="firstName"
							class="form-control form-control-names input-group-lg"
							type="text" name="firstName" title="First name"
							placeholder="First name" />
					</div>
					<div class="col-sm-6 clear-input-padding">
						<label for="lastName" class="sr-only"></label>
						<form:input id="lastName" path="lastName"
							class="form-control form-control-names input-group-lg"
							type="text" name="lastName" title="Last name"
							placeholder="Last name" />
					</div>
				</div>

				<div class="form-group">
					<label for="email" class="sr-only"></label>
					<form:input id="email" path="email"
						class="form-control input-group-lg" type="email" name="email"
						title="Email" placeholder="Email" />
				</div>

				<div class="form-group">
					<label for="password" class="sr-only"></label>
					<form:input id="password" path="password"
						class="form-control input-group-lg" type="password"
						name="password" title="Password" placeholder="Password" />
				</div>

				<div class="form-group">
					<div class="checkbox">
						<label><input type="checkbox">I agree to <a
							href="#">RateMe tems</a> </label>
					</div>
				</div>

				<div class="form-group">
					<label for="submit" class="sr-only"></label>
					<button type="submit" class="form-control btn btn-primary">Sign
						up for free</button>
				</div>
			</form:form>

		</div>
	</section>


	<section class="container" id="section7">
		<h1 class="text-center">Social Media Fascination</h1>
		<div class="row">
			<!--fontawesome icons-->
			<div class="col-sm-1 col-sm-offset-2 col-xs-4 text-center">
				<i class="fa fa-github fa-4x"></i>
			</div>
			<div class="col-sm-1 col-xs-4 text-center">
				<i class="fa fa-foursquare fa-4x"></i>
			</div>
			<div class="col-sm-1 col-xs-4 text-center">
				<i class="fa fa-facebook fa-4x"></i>
			</div>
			<div class="col-sm-1 col-xs-4 text-center">
				<i class="fa fa-pinterest fa-4x"></i>
			</div>
			<div class="col-sm-1 col-xs-4 text-center">
				<i class="fa fa-google-plus fa-4x"></i>
			</div>
			<div class="col-sm-1 col-xs-4 text-center">
				<i class="fa fa-twitter fa-4x"></i>
			</div>
			<div class="col-sm-1 col-xs-4 text-center">
				<i class="fa fa-dribbble fa-4x"></i>
			</div>
			<div class="col-sm-1 col-xs-4 text-center">
				<i class="fa fa-instagram fa-4x"></i>
			</div>
		</div>
		<!--/row-->
		<div class="row">
			<div class="col-md-12 text-center">
				<br> <br>
				<p>
					<a
						href="http://www.bootstrapzero.com/bootstrap-template/sectionalize">Get
						the code for this template.</a>
				</p>
			</div>
		</div>
	</section>

	<footer id="footer">
		<div class="container">
			<div class="row">
				<div class="col-xs-6 col-sm-6 col-md-3 column">
					<h4>Information</h4>
					<ul class="nav">
						<li><a href="about-us.html">Products</a></li>
						<li><a href="about-us.html">Services</a></li>
						<li><a href="about-us.html">Benefits</a></li>
						<li><a href="elements.html">Developers</a></li>
					</ul>
				</div>
				<div class="col-xs-6 col-md-3 column">
					<h4>Follow Us</h4>
					<ul class="nav">
						<li><a href="#">Twitter</a></li>
						<li><a href="#">Facebook</a></li>
						<li><a href="#">Google+</a></li>
						<li><a href="#">Pinterest</a></li>
					</ul>
				</div>
				<div class="col-xs-6 col-md-3 column">
					<h4>Contact Us</h4>
					<ul class="nav">
						<li><a href="#">Email</a></li>
						<li><a href="#">Headquarters</a></li>
						<li><a href="#">Management</a></li>
						<li><a href="#">Support</a></li>
					</ul>
				</div>
				<div class="col-xs-6 col-md-3 column">
					<h4>Customer Service</h4>
					<ul class="nav">
						<li><a href="#">About Us</a></li>
						<li><a href="#">Delivery Information</a></li>
						<li><a href="#">Privacy Policy</a></li>
						<li><a href="#">Terms &amp; Conditions</a></li>
					</ul>
				</div>
			</div>
			<!--/row-->
		</div>
	</footer>

	<!-- script references -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script src="resources/js/bootstrap/bootstrap.min.js"></script>

</body>
</html>