'use strict';

angular.module('sdApp')
    .config(function ($stateProvider) {
       $stateProvider
           .state('login', {
               parent: 'account',
               url: '/login',
               data: {
                   authorities: [],
                   pageTitle: 'Sign In'
               },
               views: {
                   'content@': {
                       templateUrl: 'scripts/app/account/login/login.html',
                       controller: 'LoginController'
                   }
               },
               resolve: {}
           });
    });
