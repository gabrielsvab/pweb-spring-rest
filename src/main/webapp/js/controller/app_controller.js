'use strict';

var myApp = angular.module('myApp', []);
 
myApp.controller('AppController', ['$scope', 'AppService', function($scope, AppService) {
    var self = this;
    self.atleta={idAtleta:null,nomeAtleta:'',nascAtleta:'',modalidadeAtleta:'',paisAtleta:''};
    self.atletas=[];
 
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
 
 
    AppService.fetchAllAtletas();

    /* ------------------------------- Atleta -------------------------------------- */
    function fetchAllAtletas(){
        AppService.fetchAllAtletas()
            .then(
            function(d) {
                self.atletas = d;
            },
            function(errResponse){
                console.error('Erro ao carregar todos os Atletas');
            }
        );
    }
 
    function createAtleta(atleta){
        AppService.createAtleta(atleta)
            .then(
            fetchAllAtletas,
            function(errResponse){
                console.error('Erro ao adicionar um novo Atleta');
            }
        );
    }
 
    function updateAtleta(atleta, idAtleta){
        AppService.updateAtleta(atleta, idAtleta)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Erro ao editar Atleta');
            }
        );
    }
 
    function deleteAtleta(idAtleta){
        AppService.deleteAtleta(idAtleta)
            .then(
            fetchAllAtletas,
            function(errResponse){
                console.error('Erro ao excluir Atleta');
            }
        );
    }
 
    /* ------------------------------- Modalidade -------------------------------------- */
 
    function fetchAllModalidade(){
        AppService.fetchAllModalidade()
            .then(
            function(d) {
                self.modalidades = d;
            },
            function(errResponse){
                console.error('Erro ao carregar todas as Modalidades');
            }
        );
    }
 
    function createModalidade(modalidade){
        AppService.createModalidade(modalidade)
            .then(
            fetchAllModalidade,
            function(errResponse){
                console.error('Erro ao adicionar uma nova Modalidade');
            }
        );
    }
 
    function updateModalidade(modalidade, idModalidade){
        AppService.updateModalidade(modalidade, idModalidade)
            .then(
            fetchAllModalidade,
            function(errResponse){
                console.error('Erro ao editar Modalidade');
            }
        );
    }
 
    function deleteModalidade(idModalidade){
        AppService.deleteModalidade(idModalidade)
            .then(
            fetchAllModalidade,
            function(errResponse){
                console.error('Erro ao excluir Modalidade');
            }
        );
    }
    
    /* ------------------------------- Atleta -------------------------------------- */
    function fetchAllAtletas(){
        AppService.fetchAllAtletas()
            .then(
            function(d) {
                self.atletas = d;
            },
            function(errResponse){
                console.error('Erro ao carregar todos os Atletas');
            }
        );
    }
 
    function createAtleta(atleta){
        AppService.createAtleta(atleta)
            .then(
            fetchAllAtletas,
            function(errResponse){
                console.error('Erro ao adicionar um novo Atleta');
            }
        );
    }
 
    function updateAtleta(atleta, idAtleta){
        AppService.updateAtleta(atleta, idAtleta)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Erro ao editar Atleta');
            }
        );
    }
 
    function deleteAtleta(idAtleta){
        AppService.deleteAtleta(idAtleta)
            .then(
            fetchAllAtletas,
            function(errResponse){
                console.error('Erro ao excluir Atleta');
            }
        );
    }
 
    /* ------------------------------- Pais -------------------------------------- */
 
    function fetchAllPaises(){
        AppService.fetchAllPaises()
            .then(
            function(d) {
                self.Paises = d;
            },
            function(errResponse){
                console.error('Erro ao carregar todos os Paises');
            }
        );
    }
 
    function createPais(Pais){
        AppService.createPais(Pais)
            .then(
            fetchAllPaises,
            function(errResponse){
                console.error('Erro ao adicionar um novo Pais');
            }
        );
    }
 
    function updatePais(pais, idPais){
        AppService.updatePais(pais, idPais)
            .then(
            fetchAllPaises,
            function(errResponse){
                console.error('Erro ao editar Pais');
            }
        );
    }
 
    function deletePais(idPais){
        AppService.deletePais(idPais)
            .then(
            fetchAllPaises,
            function(errResponse){
                console.error('Erro ao excluir Pais');
            }
        );
    }

    function submit() {
        if(self.atleta.idAtleta===null){
            console.log('Criando novo Atleta', self.atleta);
            createAtleta(self.atleta);
        }else{
            updateAtleta(self.atleta, self.atleta.idAtleta);
            console.log('Atleta atualizado com o ID ', self.atleta.idAtleta);
        }
        reset();
    }
 
    function edit(idAtleta){
        console.log('Id para ser Editado', idAtleta);
        for(var i = 0; i < self.atleta.length; i++){
            if(self.modalidade[i].idAtleta === idAtleta) {
                self.atleta = angular.copy(self.modalidade[i]);
                break;
            }
        }
    }
 
    function remove(idAtleta){
        console.log('Id para ser Editado', idAtleta);
        if(self.atleta.idAtleta === idAtleta) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteAtleta(idAtleta);
    }
 
 
    function reset(){
        self.atleta={idAtleta:null,nomeAtleta:'',nascAtleta:'',modalidadeAtleta:'',paisAtleta:''};
        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);