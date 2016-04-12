'use strict';

angular.module('mutrack')
  .controller('LoginCtrl', function($scope, $rootScope, $http, ngNotify, RestSrv, SERVICE_PATH) {
    var url = SERVICE_PATH.PUBLIC_PATH + '/auth';

    ngNotify.config({
      theme: 'pastel'
    });

    $scope.login = function(email, password) {
      var headers = {
        authorization : "Basic " + btoa(email + ":" + password)
      };

  		$http.get('http://localhost:8080/user', {
  			headers : headers
  		}).success(function(data) {
        $rootScope.auth = {
          authenticated: data.name || false,
          permissions: data.permissions
        };
  		}).error(function(error) {
  			$rootScope.authenticated = false;
  		});
    };

  });
