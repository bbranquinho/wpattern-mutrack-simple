'use strict';

angular.module('mutrack')
  .controller('PackageeCtrl', function($scope, ngNotify, RestSrv, SERVICE_PATH) {
    $scope.packagee = {};
    $scope.packagees = [];
    $scope.showAddEditPackagee = false;

    ngNotify.config({
      theme: 'pastel'
    });

    // Show the form used to edit or add packagees.
    $scope.show = function() {
      $scope.showAddEditPackagee = true;
    };

    // Hide the form used to edit or add packagees.
    $scope.hide = function() {
      $scope.showAddEditPackagee = false;
      $scope.packagee = {};
    };

    // Manage CRUD operations.
    var packageeUrl = SERVICE_PATH.PRIVATE_PATH + '/packagee';

    $scope.editPackagee = function(packagee) {
      $scope.packagee = angular.copy(packagee);
      $scope.show();
    };

    $scope.deletePackagee = function(packagee) {
      RestSrv.delete(packageeUrl, packagee, function() {
        $scope.packagees.splice($scope.packagees.indexOf(packagee), 1);
        ngNotify.set('Package \'' + packagee.name + '\' deleted.', 'success');
      });
    };

    $scope.savePackagee = function(packagee) {
      if (packagee.id) {
        RestSrv.edit(packageeUrl, packagee, function() {
          for (var i = 0; i < $scope.packagees.length; i++) {
            if ($scope.packagees[i].id === packagee.id) {
              $scope.packagees[i] = packagee;
            }
          }

          $scope.hide();
          ngNotify.set('Package \'' + packagee.name + '\' updated.', 'success');
        });
      } else {
        RestSrv.add(packageeUrl, packagee, function(newPackagee) {
          $scope.packagees.push(newPackagee);
          $scope.hide();
          ngNotify.set('Package \'' + packagee.name + '\' added.', 'success');
        });
      }
    };

    // Request all data (packagees).
    RestSrv.find(packageeUrl, function(data) {
      $scope.packagees = data;
      ngNotify.set('Loaded packages with success.', 'success');
    });

  });
