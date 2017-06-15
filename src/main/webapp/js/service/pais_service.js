'use strict';

angular.module('myApp').factory('PaisService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://67.205.182.13:8080/pwebrest/pais/';

    var factory = {
        fetchAllPaises: fetchAllPaises,
        createPais: createPais,
        updatePais:updatePais,
        deletePais:deletePais
    };

    return factory;

    function fetchAllPaises() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Paises');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createPais(pais) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, pais)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Pais');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updatePais(pais, idPais) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+idPais, pais)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Pais');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deletePais(idPais) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+idPais)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Pais');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
