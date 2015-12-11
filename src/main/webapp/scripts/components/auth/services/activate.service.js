'use strict';

angular.module('sdApp')
    .factory('Activate', function($resource) {
       return $resource('api/activate', {}, {
           get: {method: 'GET', params: {}, isArray: false}
       });
    });