'use strict';

angular.module('myApp').controller('AtletaController', ['$scope', 'AtletaService', function($scope, AtletaService) {
    var self = this;
    self.atleta={idAtleta:null,nomeAtleta:'',nascAtleta:'',modalidadeAtleta:null,paisAtleta:null};
    self.atletas=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    fetchAllAtletas();

    function fetchAllAtletas()
    {
        AtletaService.fetchAllAtletas()
            .then(
            function(d) 
            {
                self.atletas = d;
            },
            function(errResponse)
            {
                console.error('Error while fetching atletas');
            }
        );
    }

    function createAtleta(atleta)
    {
        AtletaService.createAtleta(atleta)
            .then(
            fetchAllAtletas,
            function(errResponse)
            {
                console.error('Error while creating atleta');
            }
        );
    }

    function updateAtleta(atleta, idAtleta)
    {
        AtletaService.updateAtleta(atleta,idAtleta)
            .then(
            fetchAllAtletas,
            function(errResponse)
            {
                console.error('Error while updating atleta');
            }
        );
    }

    function deleteAtleta(idAtleta)
    {
        AtletaService.deleteAtleta(idAtleta)
            .then(
            fetchAllAtletas,
            function(errResponse)
            {
                console.error('Error while deleting atleta');
            }
        );
    }

    function submit() 
    {
        if(self.atleta.idAtleta===null)
        {
            console.log('Saving New Atleta', self.atleta);
            createAtleta(self.atleta);
        }
        else
        {
            updateAtleta(self.atleta, self.atleta.idAtleta);
            console.log('Atleta updated with id ', self.atleta.idAtleta);
        }
        reset();
    }

    function edit(idAtleta)
    {
        console.log('id to be edited', idAtleta);
        for(var i = 0; i < self.atletas.length; i++)
        {
            if(self.atletas[i].idAtleta === idAtleta) 
            {
                self.atleta = angular.copy(self.atletas[i]);
                break;
            }
        }
    }

    function remove(idAtleta)
    {
        console.log('id to be deleted', idAtleta);
        if(self.atleta.idAtleta === idAtleta) 
        {
            reset();
        }
        deleteAtleta(idAtleta);
    }


    function reset()
    {
        self.atleta={idAtleta:null,nomeAtleta:'',nascAtleta:'',modalidadeAtleta:null,paisAtleta:null};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
