'use strict';

angular.module('sdApp')
    .config(function($stateProvider){
       $stateProvider
           .state('admin', {
               abstract: true,
               parent: 'site'
           });
    });