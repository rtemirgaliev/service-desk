'use strict';

angular.module('sdApp')
    .factory('notificationInterceptor', function ($q, AlertService) {
       return {
           response: function(response) {
               var alertKey = response.headers('X-sdApp-alert');
               if (angular.isString(alertKey)) {
                   AlertService.success(alertKey, { param: response.headers('X-sdApp-params')});
               }
               return response;
           }
       };
    });