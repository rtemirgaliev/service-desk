'use strict';

angular.module('sdApp')
    .factory('Account', function Account($resource) {
        return $resource('api/account', {}, {
            'get': { method: 'GET', params: {}, isArray: false,
                interceptor: {
                    response: function(response) {
                        console.log('log from Account.get');
                        return response;
                    }
                }
            }
       });
    });
