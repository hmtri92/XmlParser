"use strict";

angular.module('myApp', []).controller("ideaCtrl", ['$scope', '$http', function($scope, $http) {
	$scope.list = [];
	$scope.path = 'D:\workspace_spring\XMLReader\runtest';
	$scope.convert = function() {
		var formData = {
				"path" : $scope.path
		};
		
		$scope.list.push(this.path);
		
		var response = $http.post('convert', formData).then(successCallback, errorCallback);
		
		function successCallback(success) {
			$scope.list.push("Success");
		};
		
		function errorCallback (error) {
			$scope.list.push("Fail");
		};
		
	  };
}]);
