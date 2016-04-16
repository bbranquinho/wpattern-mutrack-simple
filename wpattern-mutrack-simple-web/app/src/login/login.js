'use strict';

angular.module('mutrack')
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

            ngNotify.set('The email or password that you have entered do not match our records.', {
              type: 'failure',
              duration: 5000
            });
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
  });
