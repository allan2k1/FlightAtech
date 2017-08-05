'use strict';

angular.module('myApp').controller('FlightController', ['$scope', 'FlightService', function($scope, FlightService) {
    var self = this;
    self.flight={id:null,origin:'',destination:'',departDate:'',returnDate:'',pilot:'',airplane:'',status:''};
    self.flights=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    fetchAllFlights();

    function fetchAllFlights(){
    	FlightService.fetchAllFlights()
            .then(
            function(d) {
                self.flights = d;
            },
            function(errResponse){
                console.error('Error while fetching Flights');
            }
        );
    }

    function createFlight(flight){
    	FlightService.createFlight(flight)
            .then(
            fetchAllFlights,
            function(errResponse){
                console.error('Error while creating Flight');
            }
        );
    }

    function updateFlight(flight, id){
    	FlightService.updateFlight(flight, id)
            .then(
            fetchAllFlights,
            function(errResponse){
                console.error('Error while updating Flight');
            }
        );
    }

    function deleteFlight(id){
    	FlightService.deleteFlight(id)
            .then(
            fetchAllFlights,
            function(errResponse){
                console.error('Error while deleting Flight');
            }
        );
    }

    function submit() {
        if(self.flight.id===null){
            console.log('Saving New Flight', self.flight);
            createFlight(self.flight);
        }else{
            updateFlight(self.flight, self.flight.id);
            console.log('Flight updated with id ', self.flight.id);
        }
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.flights.length; i++){
            if(self.flights[i].id === id) {
                self.flight = angular.copy(self.flights[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.flight.id === id) {//clean form if the flight to be deleted is shown there.
            reset();
        }
        deleteFlight(id);
    }


    function reset(){
        self.flight={id:null,origin:'',destination:'',departDate:'',returnDate:'',pilot:'',airplane:'',status:''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
