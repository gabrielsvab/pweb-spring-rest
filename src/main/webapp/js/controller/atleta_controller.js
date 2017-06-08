'use strict';
 
angular.module('myApp').controller('AtletaController', ['$scope', 'AtletaService', function($scope, AtletaService) {
    var self = this;
    self.atleta={idAtleta:null,nomeAtleta:'',nascAtleta:'',modalidadeAtleta:'',paisAtleta:''};
    self.atletas=[];
 
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
 
 
    fetchAllAtletas();
 
    function fetchAllAtletas(){
        AtletaService.fetchAllAtletas()
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
        AtletaService.createAtleta(atleta)
            .then(
            fetchAllAtletas,
            function(errResponse){
                console.error('Erro ao adicionar um novo Atleta');
            }
        );
    }
 
    function updateAtleta(atleta, idAtleta){
        AtletaService.updateAtleta(atleta, idAtleta)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Erro ao editar Atleta');
            }
        );
    }
 
    function deleteAtleta(idAtleta){
        AtletaService.deleteAtleta(idAtleta)
            .then(
            fetchAllAtletas,
            function(errResponse){
                console.error('Erro ao excluir Atleta');
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
            if(self.atletas[i].idAtleta === idAtleta) {
                self.atleta = angular.copy(self.atletas[i]);
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