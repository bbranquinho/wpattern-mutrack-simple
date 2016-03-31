'use strict';

var BASE_URL = 'http://localhost:8080/api';

angular.module('mutrack', ['ngRoute'])
  .constant('SERVICE_PATH', {
    'ROOT_PATH': BASE_URL,
    'PUBLIC_PATH': BASE_URL + '/public',
    'PRIVATE_PATH': BASE_URL + '/private'
  })
  .config(function($routeProvider) {
    $routeProvider.
      when('/', {
        templateUrl: 'src/home/home.html',
        controller: 'HomeCtrl'
      }).
      when('/package', {
        templateUrl: 'src/package/package.html',
        controller: 'PackageCtrl'
      }).
      when('/user', {
        templateUrl: 'src/user/user.html',
        controller: 'UserCtrl'
      }).
      otherwise({
        redirectTo: '/'
      });
  });
