'use strict';

angular.module('mutrack')
  .service('LoginLogoutSrv', function($http, $cookies, $rootScope, $location, ngNotify, SERVICE_PATH) {
    var serviceFactory = {};
    var urlLogin  = SERVICE_PATH.PUBLIC_PATH + '/login';
    var urlLogout = SERVICE_PATH.PUBLIC_PATH + '/logout';

    serviceFactory.login = function(email, password) {
      var requestParams = {
        method: 'GET',
        url: urlLogin,
        headers: {
          'Content-Type': 'application/json',
          'authorization' : 'Basic ' + btoa(email + ':' + password)
        }
      };

      $http(requestParams).then(
        function success(response) {
          var data = response.data;

          if (data.name) {
            $rootScope.authDetails = { name: data.name, authenticated: data.authenticated, permissions: data.authorities };
            $location.path('/');
            ngNotify.set('Welcome ' + data.name + '.', 'success');
          } else {
            $rootScope.authDetails = { name: '', authenticated: false, permissions: [] };
            ngNotify.set('Email or password that you have entered do not match our records.', { type: 'failure', duration: 5000 });
          }
        },
        function failure(response) {
          $rootScope.authDetails = { name: '', authenticated: false, permissions: []};
          ngNotify.set('Email or password that you have entered do not match our records.', { type: 'failure', duration: 5000 });
        }
      );
    };

    serviceFactory.logout = function() {
      var requestParams = {
        method: 'POST',
        url: urlLogout,
        headers: {
          'Content-Type': 'application/json'
        }
      };

      $http(requestParams).finally(function success(response) {
          $rootScope.authDetails = { name: '', authenticated: false, permissions: [] };
          $location.path("/");
        });
    };

    return serviceFactory;
  });
