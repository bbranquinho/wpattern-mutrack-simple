'user strict';

angular.module('mutrack').
  controller('headerSrv', function($scope, $rootScope, $location) {

    $scope.hasAnyPermission = function(authorities) {
      var hasPermission = false;

      $rootScope.authDetails.permissions.forEach(function(permission) {
        authorities.forEach(function(authority) {
          if (permission.authority === authority) {
            hasPermission = true;
          }
        });
      });

      return hasPermission;
    };

    $scope.logout = function() {
      $rootScope.authDetails = {
        authenticated: false,
        permissions: []
      };
    };

  });
