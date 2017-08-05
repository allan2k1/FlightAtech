'use strict';

angular.module('myApp').factory('FlightService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/FlightMonitorAtech/flight/';

    var factory = {
        fetchAllFlights: fetchAllFlights,
        createFlight: createFlight,
        updateFlight:updateFlight,
        deleteFlight:deleteFlight
    };

    return factory;

    function fetchAllFlights() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Flights');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createFlight(flight) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, flight)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Flight');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateFlight(flight, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, flight)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Flight');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteFlight(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Flight');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
