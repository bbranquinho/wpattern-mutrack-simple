'use strict';

function executeRequest(http, url, method, data, callback) {
  var requestParams = {
    method: method,
    url: url,
    headers: { 'Content-Type': 'application/json' },
    data: data
  };

  http(requestParams).then(
    function successCallback(response) {
      callback && callback(response.data);
    },
    function errorCallback(response) {
    });
};

angular.module('mutrack')
  .service('UserSrv', function($http, SERVICE_PATH) {
    var userFactory = {};
    var url = SERVICE_PATH.PRIVATE_PATH + '/user';

    // Find all users.
    userFactory.find = function(callback) {
      executeRequest($http, url, 'GET', {}, callback);
    };

    // Save (add a new) the data of an user.
    userFactory.add = function(user, callback) {
      executeRequest($http, url, 'POST', user, callback);
    };

    // Save (edit) the data of an user.
    userFactory.edit = function(user, callback) {
      executeRequest($http, url, 'PUT', user, callback);
    };

    // Delete an user.
    userFactory.delete = function(user, callback) {
      executeRequest($http, url, 'DELETE', user, callback);
    };

    return userFactory;
  });
