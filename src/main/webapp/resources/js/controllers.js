"use strict";

angular.module("myApp.controllers", []).controller("ideaCtrl", function($scope, $http) {
	$scope.convert = function() {
		var response = $https.post('convert', {path : $scope.itabis.path})
		
		response.success(function (data, status, headers, config) {
			
		});
		
		response.error( function (data, status, headers, config) {
			
		});
	  };
});
