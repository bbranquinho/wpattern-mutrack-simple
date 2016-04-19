'use strict';

angular.module('mutrack')
  .controller('LoginCtrl', function($scope, $rootScope, $http, ngNotify, RestSrv, SERVICE_PATH) {
    var url = SERVICE_PATH.PUBLIC_PATH + '/auth';

    ngNotify.config({
      theme: 'pastel'
    });

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
        function successCallback(response) {
          var data = response.data;

          $rootScope.auth = {
            authenticated: true
          };

        },
        function errorCallback(response) {
          ngNotify.set('Error: ' + response.statusText + '.', 'error');
        });
    };

  });
