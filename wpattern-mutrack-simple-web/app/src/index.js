'use strict';

var BASE_URL = 'http://localhost:8080/api';

angular.module('mutrack', ['checklist-model', 'ngNotify', 'ngRoute'])
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
      })
      .when('/login', {
        templateUrl: 'src/login/login.html',
        controller: 'LoginCtrl'
      })
      .when('/packagee', {
        templateUrl: 'src/packagee/packagee.html',
        controller: 'PackageeCtrl'
      })
      .when('/user', {
        templateUrl: 'src/user/user.html',
        controller: 'UserCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  }).
  run(function($rootScope) {
    $rootScope.authDetails = {
      name: '',
      authenticated: false,
      permissions: []
    }
  });
