//se genera el modulo de la vista index.html
var app = angular.module('reservas', ["ngResource"]);

//se asiga el controlador a la vista.
app.controller('ControladorReservas', [ '$scope', '$http',
                                     
	function($scope, $http) {	

		/**
		 * Metodo que consume el web services que obtiene los tipos de solicitudes que hay
		 * en la base de datos.
		 */
		$scope.getDocumentosID=function() {
			$http.get('documentosIdentificacion/obtenerDocumentosIdentidad').success(function(data) {
				$scope.tiposDIS=data;					
			}).error(function(data) {
				$scope.msgBusUP = 'ERROR';
			});
		}	
	
		/**
		 * Metodo que envia al web services los datos de una solicitud para que sean 
		 * almacenados en la base de datos.
		 */
		$scope.buscarReservas = function() {
			$http({
				method : 'POST',
				url : 'reservas/obtenerReserva', 
				params : {
					numeroDI : $scope.numeroDI,
					tipoDI : $scope.tipoDI.id										
				}
			}).success(function(data) {				
				$scope.reservas=data;						
			}).error(function(data) {
				$scope.msgBusUP = 'ERROR';
			});			
		}
		
} ]);

