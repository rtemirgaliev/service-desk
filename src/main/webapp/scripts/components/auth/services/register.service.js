'use strict';

angular.module('sdApp')
    .factory('Register', function($resource) {
        return $resource('api/register', {}, {});
    });