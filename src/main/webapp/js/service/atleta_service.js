'use strict';
 
angular.module('myApp').factory('AtletaService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI = 'http://localhost:8080/pwebrest/atleta/';
 
    var factory = 
    {
        fetchAllAtletas: fetchAllAtletas,
        createAtleta: createAtleta,
        updateAtleta:updateAtleta,
        deleteAtleta:deleteAtleta
    };
 
    return factory;
 
    function fetchAllAtletas() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Erro ao carregar todos os Atletas');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createAtleta(atleta) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Erro ao adicionar um novo Atleta');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateAtleta(atleta, idAtleta) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+idAtleta, atleta)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Erro ao editar Atleta');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteAtleta(idAtleta) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+idAtleta)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Erro ao excluir Atleta');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);