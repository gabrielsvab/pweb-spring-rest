'use strict';

angular.module('myApp').controller('ModalidadeController', ['$scope', 'ModalidadeService', function($scope, ModalidadeService) {
    var self = this;
    self.modalidade={idModalidade:null,nomeModalidade:''};
    self.modalidades=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    fetchAllModalidades();

    function fetchAllModalidades()
    {
        ModalidadeService.fetchAllModalidades()
            .then(
            function(d) 
            {
                self.modalidades = d;
            },
            function(errResponse)
            {
                console.error('Error while fetching modalidades');
            }
        );
    }

    function createModalidade(modalidade)
    {
        ModalidadeService.createModalidade(modalidade)
            .then(
            fetchAllModalidades,
            function(errResponse)
            {
                console.error('Error while creating modalidade');
            }
        );
    }

    function updateModalidade(modalidade, idModalidade)
    {
        ModalidadeService.updateModalidade(modalidade,idModalidade)
            .then(
            fetchAllModalidades,
            function(errResponse)
            {
                console.error('Error while updating modalidade');
            }
        );
    }

    function deleteModalidade(idModalidade)
    {
        ModalidadeService.deleteModalidade(idModalidade)
            .then(
            fetchAllModalidades,
            function(errResponse)
            {
                console.error('Error while deleting modalidade');
            }
        );
    }

    function submit() 
    {
        if(self.modalidade.idModalidade===null)
        {
            console.log('Saving New Modalidade', self.modalidade);
            createModalidade(self.modalidade);
        }
        else
        {
            updateModalidade(self.modalidade, self.modalidade.idModalidade);
            console.log('Modalidade updated with id ', self.modalidade.idModalidade);
        }
        reset();
    }

    function edit(idModalidade)
    {
        console.log('id to be edited', idModalidade);
        for(var i = 0; i < self.modalidades.length; i++)
        {
            if(self.modalidades[i].idModalidade === idModalidade) 
            {
                self.modalidade = angular.copy(self.modalidades[i]);
                break;
            }
        }
    }

    function remove(idModalidade)
    {
        console.log('id to be deleted', idModalidade);
        if(self.modalidade.idModalidade === idModalidade) 
        {
            reset();
        }
        deleteModalidade(idModalidade);
    }


    function reset()
    {
        self.modalidade={idModalidade:null,nomeModalidade:''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
