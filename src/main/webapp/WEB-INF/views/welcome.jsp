<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <title>Converter</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
	<link href="css/myStyle.css" rel="stylesheet" />

    <!--     Fonts     -->
    <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">

</head>

<body ng-app="myApp">
<div class="container" ng-controller="ideaCtrl">
   	<form ng-submit="submit()">
   		<div class="row">
   			<div class="col-md-10 col-sm-10">
			    <input type="text" class="form-control" placeholder="Path..." ng-model="path">
   			</div>
   			<div class="col-md-2 col-sm-2">
			    <button type="submit" class="btn btn-primary">Proccess</button>
   			</div>
   		</div>
	</form>
	<div class="panel panel-default" style="margin-top: 20px;">
	  <div class="panel-body">
	    <div class="row" ng-repeat="idea in model.ideas | orderBy: 'votes' : true">
	    	<div class="description" ng-bind-html="idea.description | markdown"></div>
	    </div>
	  </div>
	</div>
</div>

</body>
   <script src="js/jquery-3.2.0.min.js" type="text/javascript"></script>
   <script src="js/bootstrap.min.js" type="text/javascript"></script>
   <script src="js/angular.min.js" type="text/javascript"></script>
   <script src="js/angular-resource.js" type="text/javascript"></script>
   <script src="js/sockjs.js" type="text/javascript"></script>
   <script src="js/stomp.min.js" type="text/javascript"></script>
   <script src="js/showdown.min.js" type="text/javascript"></script>
   <script src="js/app.js" type="text/javascript"></script>
   <script src="js/service.js" type="text/javascript"></script>
   <script src="js/filters.js" type="text/javascript"></script>
   <script src="js/controller.js" type="text/javascript"></script>

</html>
