<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Flight Monitor</title>  

     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="FlightController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Flight Registration Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.flight.id" />
                                            
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Origin</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.flight.origin" name="porigin" class="origin form-control input-sm" required ng-minlength="2"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.porigin.$error.required">This is a required field</span>
                                      <span ng-show="myForm.porigin.$error.minlength">Minimum length required is 2</span>
                                      <span ng-show="myForm.porigin.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Destination</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.flight.destination" name="pdestination" class="destination form-control input-sm" required ng-minlength="2"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.pdestination.$error.required">This is a required field</span>
                                      <span ng-show="myForm.pdestination.$error.minlength">Minimum length required is 2</span>
                                      <span ng-show="myForm.pdestination.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Depart Date</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.flight.departDate" name="pdepartDate" class="departDate form-control input-sm" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.pdepartDate.$error.required">This is a required field</span>
                                      <span ng-show="myForm.pdepartDate.$error.minlength">Minimum length required is 2</span>
                                      <span ng-show="myForm.pdepartDate.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Return Date</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.flight.returnDate" name="preturnDate" class="returnDate form-control input-sm" required ng-minlength="2"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.returnDate.$error.required">This is a required field</span>
                                      <span ng-show="myForm.returnDate.$error.minlength">Minimum length required is 2</span>
                                      <span ng-show="myForm.returnDate.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Pilot</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.flight.pilot" name="ppilot" class="pilot form-control input-sm" required ng-minlength="2"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.ppilot.$error.required">This is a required field</span>
                                      <span ng-show="myForm.ppilot.$error.minlength">Minimum length required is 2</span>
                                      <span ng-show="myForm.ppilot.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Airplane</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.flight.airplane" name="pairplane" class="airplane form-control input-sm" required ng-minlength="2"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.pairplane.$error.required">This is a required field</span>
                                      <span ng-show="myForm.pairplane.$error.minlength">Minimum length required is 2</span>
                                      <span ng-show="myForm.pairplane.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Status</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.flight.status" name="pstatus" class="status form-control input-sm" required ng-minlength="2"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.pstatus.$error.required">This is a required field</span>
                                      <span ng-show="myForm.pstatus.$error.minlength">Minimum length required is 2</span>
                                      <span ng-show="myForm.pstatus.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                                            
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.flight.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          
          <div class="row">
              <div class="form-group col-md-12">
                  <label class="col-md-2 control-lable" for="file">Filter by Pilot</label>
                  <div class="col-md-7">
                      <input type="text" ng-model="f.pilot"/>
                  </div>
              </div>
          </div>
          
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Flights </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Origin</th>
                              <th>Destination</th>
                              <th>Depart Date</th>
                              <th>Return Date</th>
                              <th>Pilot</th>
                              <th>Airplane</th>
                              <th>Status</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="f in ctrl.flights | filter:f:strict">
                              <td><span ng-bind="f.id"></span></td>
                              <td><span ng-bind="f.origin"></span></td>
                              <td><span ng-bind="f.destination"></span></td>
                              <td><span ng-bind="f.departDate"></span></td>
                              <td><span ng-bind="f.returnDate"></span></td>
                              <td><span ng-bind="f.pilot"></span></td>
                              <td><span ng-bind="f.airplane"></span></td>
                              <td><span ng-bind="f.status"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(f.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(f.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/flight_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/flight_controller.js' />"></script>
  </body>
</html>