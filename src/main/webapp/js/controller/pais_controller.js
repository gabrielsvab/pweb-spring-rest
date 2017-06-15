'use strict';

angular.module('myApp').controller('PaisController', ['$scope', 'PaisService', function($scope, PaisService) {
    var self = this;
    self.pais={idPais:null,nomePais:''};
    self.paises=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    fetchAllPaises();

    function fetchAllPaises()
    {
        PaisService.fetchAllPaises()
            .then(
            function(d) 
            {
                self.paises = d;
            },
            function(errResponse)
            {
                console.error('Error while fetching paises');
            }
        );
    }

    function createPais(pais)
    {
        PaisService.createPais(pais)
            .then(
            fetchAllPaises,
            function(errResponse)
            {
                console.error('Error while creating pais');
            }
        );
    }

    function updatePais(pais, idPais)
    {
        PaisService.updatePais(pais,idPais)
            .then(
            fetchAllPaises,
            function(errResponse)
            {
                console.error('Error while updating pais');
            }
        );
    }

    function deletePais(idPais)
    {
        PaisService.deletePais(idPais)
            .then(
            fetchAllPaises,
            function(errResponse)
            {
                console.error('Error while deleting pais');
            }
        );
    }

    function submit() 
    {
        if(self.pais.idPais===null)
        {
            console.log('Saving New Pais', self.pais);
            createPais(self.pais);
        }
        else
        {
            updatePais(self.pais, self.pais.idPais);
            console.log('Pais updated with id ', self.pais.idPais);
        }
        reset();
    }

    function edit(idPais)
    {
        console.log('id to be edited', idPais);
        for(var i = 0; i < self.paises.length; i++)
        {
            if(self.paises[i].idPais === idPais) 
            {
                self.pais = angular.copy(self.paises[i]);
                break;
            }
        }
    }

    function remove(idPais)
    {
        console.log('id to be deleted', idPais);
        if(self.pais.idPais === idPais) 
        {
            reset();
        }
        deletePais(idPais);
    }


    function reset()
    {
        self.pais={idPais:null,nomePais:''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
