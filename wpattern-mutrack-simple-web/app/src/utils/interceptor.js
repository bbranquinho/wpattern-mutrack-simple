'use strict';

angular.module('mutrack')
  .service('httpRequestInterceptor', function ($q, $cookies) {
  return {
    request: function (config) {
      config.headers['X-XSRF-TOKEN'] = $cookies.get('XSRF-TOKEN');

      return config;
    },

    responseError: function(rejection) {
      //if (canRecover(rejection)) {
      //  return responseOrNewPromise
      //}
      var asd = ';';

      if (rejection.status === 401) {
        console.log('a');
      }

      return $q.reject(rejection);
    }
  };
});
