'use strict';

var myApp = angular.module('myApp');

myApp.factory('AppService', ['$http', '$q', function($http, $q) {

    var REST_SERVICE_URI = 'http://localhost:8080/pwebrest/';

    var factory =
        {
            fetchAllAtletas: fetchAllAtletas,
            createAtleta: createAtleta,
            updateAtleta: updateAtleta,
            deleteAtleta: deleteAtleta,
            fetchAllModalidades: fetchAllModalidades,
            createModalidade: createModalidade,
            updateModalidade: updateModalidade,
            deleteModalidade: deleteModalidade,
            fetchAllPais: fetchAllPais,
            createPais: createPais,
            updatePais: updatePais,
            deletePais: deletePais
        };

    return factory;

    /* ----------------------------------------- ATLETAS ------------------------------------*/

    function fetchAllAtletas() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + '/atleta/')
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                console.error('Erro ao carregar todos os Atletas');
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;
    }

    function createAtleta(atleta) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI + '/atleta/', user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                console.error('Erro ao adicionar um novo Atleta');
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;
    }


    function updateAtleta(atleta, idAtleta) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI + '/atleta/' + idAtleta, atleta)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                console.error('Erro ao editar Atleta');
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;
    }

    function deleteAtleta(idAtleta) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI + '/atleta/' + idAtleta)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                console.error('Erro ao excluir Atleta');
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;
    }

    /* ----------------------------------------- MODALIDADE ------------------------------------*/

    function fetchAllModalidades() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + '/modalidade/')
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                console.error('Erro ao carregar todos as Modalidades');
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;
    }

    function createModalidade(modalidade) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI + '/modalidade/', modalidade)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                console.error('Erro ao adicionar um novo Atleta');
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;
    }

    function updateModalidade(modalidade, idModalidade) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI + '/modalidade/' + idModalidade, modalidade)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                console.error('Erro ao editar Modalidade');
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;
    }

    function deleteModalidade(idModalidade) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI + '/modalidade/' + idModalidade)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                console.error('Erro ao excluir Modalidade');
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;
    }

    /* ----------------------------------------- PAIS ------------------------------------*/


    function fetchAllPais() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + '/pais/')
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                console.error('Erro ao carregar todos os pais');
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;
    }

    function createPais(pais) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI + '/pais/', pais)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                console.error('Erro ao adicionar um novo Pais');
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;
    }

    function updatePais(pais, idPais) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI + '/pais/' + idPais, pais)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                console.error('Erro ao editar Pais');
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;
    }

    function deletePais(idPais) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI + '/pais/' + idPais)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function (errResponse) {
                console.error('Erro ao excluir pais');
                deferred.reject(errResponse);
            }
            );
        return deferred.promise;
    }

}]);