'use strict';

angular.module('mutrack')
<<<<<<< HEAD
  .controller('LoginCtrl', function($scope, $http, $rootScope, $location, ngNotify, SERVICE_PATH) {
    var url = SERVICE_PATH.PUBLIC_PATH + '/auth';

    $scope.login = function(email, password) {
      var requestParams = {
        method: 'POST',
        url: url,
        headers: { 'Content-Type': 'application/json' },
        data: {
          'email': email,
          'password': password
        }
      };

      $http(requestParams).then(
        function success(response) {
          var data = response.data;

          if (data.name) {
            $rootScope.authDetails = {
              name: data.name,
              authenticated: true,
              permissions: data.permissions
            };

            $location.path('/');
            ngNotify.set('Welcome ' + data.name + '.', 'success');
          } else {
            $rootScope.authDetails = {
              name: '',
              authenticated: false,
              permissions: []
            };

            ngNotify.set('The email or password that you have entered do not match our records.', 'failure');
          }
        },
        function failure(response) {
          $rootScope.authDetails = {
            name: '',
            authenticated: false,
            permissions: []
          };
        }
      );
    };
=======
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

>>>>>>> af5b68a6356c4f1c476a7f5e42995834030c0425
  });
