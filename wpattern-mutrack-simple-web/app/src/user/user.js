'use strict';

angular.module('mutrack')
  .controller('UserCtrl', function($scope, RestSrv, SERVICE_PATH) {
    $scope.user = {};
    $scope.users = [];
    $scope.permissions = [];
    $scope.showAddEditUser = false;

    // Show the form used to edit or add users.
    $scope.show = function() {
      $scope.showAddEditUser = true;
    };

    // Hide the form used to edit or add users.
    $scope.hide = function() {
      $scope.showAddEditUser = false;
      $scope.user = {};
    };

    // Manage CRUD operations.
    var userUrl = SERVICE_PATH.PRIVATE_PATH + '/user';

    $scope.editUser = function(user) {
      $scope.user = angular.copy(user);
      $scope.show();
    };

    $scope.deleteUser = function(user) {
      RestSrv.delete(userUrl, user, function() {
        $scope.users.splice($scope.users.indexOf(user), 1);
      });
    };

    $scope.saveUser = function(user) {
      if (user.id) {
        RestSrv.edit(userUrl, user, function() {
          for (var i = 0; i < $scope.users.length; i++) {
            if ($scope.users[i].id === user.id) {
              $scope.users[i] = user;
            }
          }

          delete user.password;
          $scope.hide();
        });
      } else {
        RestSrv.add(userUrl, user, function(newUser) {
          $scope.users.push(newUser);
          $scope.hide();
        });
      }
    };

    // Request all data (permission and user).
    var permissionUrl = SERVICE_PATH.PRIVATE_PATH + '/permission';

    RestSrv.find(permissionUrl, function(data) {
      $scope.permissions = data;

      RestSrv.find(userUrl, function(data) {
        $scope.users = data;
      });
    });

  });
