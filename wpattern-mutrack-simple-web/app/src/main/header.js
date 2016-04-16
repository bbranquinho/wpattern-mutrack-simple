'user strict';

angular.module('mutrack').
  controller('headerSrv', function($scope, $rootScope, $location) {

    $scope.hasAnyPermission = function(authorities) {
      var hasPermission = false;

      $rootScope.authDetails.permissions.forEach(function(permission) {
        authorities.forEach(function(role) {
          if (permission.role === role) {
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
