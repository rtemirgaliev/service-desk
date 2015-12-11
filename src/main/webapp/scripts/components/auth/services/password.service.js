'use strict';

angular.module('sdApp')
    .factory('Password', function($resource) {
       return $resource('api/account/change_password', {}, {});
    });

angular.module('sdApp')
    .factory('PasswordResetInit', function($resource) {
        return $resource('api/account/reset_password/init', {}, {});
    });

angular.module('sdApp')
    .factory('PasswordResetFinish', function($resource) {
        return $resource('api/account/reset_password/finish', {}, {});
    });
