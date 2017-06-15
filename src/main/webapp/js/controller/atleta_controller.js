'use strict';

angular.module('myApp').controller('AtletaController', ['$scope', 'AtletaService', 'ModalidadeService', 'PaisService',
    function ($scope, AtletaService, ModalidadeService, PaisService) {
        var self = this;
        self.atleta = { idAtleta: null, nomeAtleta: '', nascAtleta: '', modalidadeAtleta: null, paisAtleta: null };
        self.atletas = [];
        self.modalidades = [];
        self.paises = [];
        self.submit = submit;
        self.edit = edit;
        self.remove = remove;
        self.reset = reset;



        fetchAllModalidades();
        fetchAllPaises();
        fetchAllAtletas();

        function fetchAllPaises() {
            PaisService.fetchAllPaises()
                .then(
                function (d) {
                    self.paises = d;
                },
                function (errResponse) {
                    console.error('Error while fetching atletas');
                }
                );
        }

        function fetchAllModalidades() {
            ModalidadeService.fetchAllModalidades()
                .then(
                function (d) {
                    self.modalidades = d;
                },
                function (errResponse) {
                    console.error('Error while fetching atletas');
                }
                );
        }

        function fetchAllAtletas() {
            AtletaService.fetchAllAtletas()
                .then(
                function (d) {
                    self.atletas = d;
                    for (var i = 0; i < self.atletas.length; i++) {
                        for (var j = 0; j < self.modalidades.length; j++) {
                            if (self.atletas[i].modalidadeAtleta === self.modalidades[j].idModalidade) {
                                self.atletas[i].modalidadeAtleta = self.modalidades[j].nomeModalidade;
                            }
                        }
                        for (var k = 0; k < self.paises.length; k++) {
                            if (self.atletas[i].paisAtleta === self.paises[k].idPais) {
                                self.atletas[i].paisAtleta = self.paises[k].nomePais;
                            }
                        }
                    }
                },
                function (errResponse) {
                    console.error('Error while fetching atletas');
                }
                );
        }

        function createAtleta(atleta) {
            AtletaService.createAtleta(atleta)
                .then(
                fetchAllAtletas,
                function (errResponse) {
                    console.error('Error while creating atleta');
                }
                );
        }

        function updateAtleta(atleta, idAtleta) {
            AtletaService.updateAtleta(atleta, idAtleta)
                .then(
                fetchAllAtletas,
                function (errResponse) {
                    console.error('Error while updating atleta');
                }
                );
        }

        function deleteAtleta(idAtleta) {
            AtletaService.deleteAtleta(idAtleta)
                .then(
                fetchAllAtletas,
                function (errResponse) {
                    console.error('Error while deleting atleta');
                }
                );
        }

        function submit() {
            if (self.atleta.idAtleta === null) {
                console.log('Saving New Atleta', self.atleta);
                createAtleta(self.atleta);
            }
            else {
                updateAtleta(self.atleta, self.atleta.idAtleta);
                console.log('Atleta updated with id ', self.atleta.idAtleta);
            }
            reset();
        }

        function edit(idAtleta) {
            console.log('id to be edited', idAtleta);
            for (var i = 0; i < self.atletas.length; i++) {
                if (self.atletas[i].idAtleta === idAtleta) {
                    self.atleta = angular.copy(self.atletas[i]);
                    break;
                }
            }
        }

        function remove(idAtleta) {
            console.log('id to be deleted', idAtleta);
            if (self.atleta.idAtleta === idAtleta) {
                reset();
            }
            deleteAtleta(idAtleta);
        }


        function reset() {
            self.atleta = { idAtleta: null, nomeAtleta: '', nascAtleta: '', modalidadeAtleta: null, paisAtleta: null };
            $scope.myForm.$setPristine(); //reset Form
        }

    }]);
