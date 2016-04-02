'use strict';

angular.module('mutrack')
  .controller('UserCtrl', function($scope, UserSrv) {
    $scope.user = {};
    $scope.users = [];
    $scope.showAddEditUser = false;

    $scope.permissions = [
      {id: 1, role: 'ROLE_ADMIN'},
      {id: 2, role: 'ROLE_USER'}
    ];

    $scope.show = function() {
      $scope.showAddEditUser = true;
    };

    $scope.hide = function() {
      $scope.showAddEditUser = false;
      $scope.user = {};
    };

    $scope.editUser = function(user) {
      $scope.user = {
        id: user.id,
        name: user.name,
        email: user.email,
        permissions: user.permissions
      };
      $scope.show();
    };

    $scope.deleteUser = function(user) {
      UserSrv.delete(user, function() {
        $scope.users.splice($scope.users.indexOf(user), 1);
      });
    };

    $scope.saveUser = function(user) {
      if (user.id) {
        UserSrv.edit(user, function() {
          for (var i = 0; i < $scope.users.length; i++) {
            if ($scope.users[i].id === user.id) {
              $scope.users[i] = user;
            }
          }
          $scope.hide();
        });
      } else {
        UserSrv.save(user, function(newUser) {
          $scope.users.push(newUser);
          $scope.hide();
        });
      }
    };

    UserSrv.find(function(data) {
      $scope.users = data;
    });

  });
