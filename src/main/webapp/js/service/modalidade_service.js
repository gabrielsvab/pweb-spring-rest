'use strict';

angular.module('myApp').factory('ModalidadeService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://67.205.182.13:8080/pwebrest/modalidade/';

    var factory = {
        fetchAllModalidades: fetchAllModalidades,
        createModalidade: createModalidade,
        updateModalidade:updateModalidade,
        deleteModalidade:deleteModalidade
    };

    return factory;

    function fetchAllModalidades() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Modalidades');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createModalidade(modalidade) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, modalidade)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Modalidade');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateModalidade(modalidade, idModalidade) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+idModalidade, modalidade)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Modalidade');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteModalidade(idModalidade) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+idModalidade)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Modalidade');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
