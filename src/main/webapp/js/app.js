'use strict';

var app = angular.module('myApp', ["ngRoute"]);

app.config(function ($routeProvider) {
    $routeProvider
        .when("/atleta", {
            templateUrl: "views/atleta.html"
        })
        .when("/modalidade", {
            templateUrl: "views/modalidade.html"
        })
        .when("/pais", {
            templateUrl: "views/pais.html"
        });
});

