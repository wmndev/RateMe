// Code goes here

app = angular.module('app', ['angucomplete']);

app.controller('AddArticleShareCtrl', function($scope) {
  $scope.submit = function() {
    alert('About to submit [' + $scope.content + '] as ' + $scope.nick.title);
  };

  $scope.users = [
  {"id":1,"nick":"Paula"},
{"id":2,"nick":"Amanda"},
{"id":3,"nick":"Lisa"},
{"id":4,"nick":"Bonnie"},
{"id":5,"nick":"Tammy"},
{"id":6,"nick":"Annie"},
{"id":7,"nick":"Jeremy"},
{"id":8,"nick":"Virginia"},
{"id":9,"nick":"Nicholas"},
{"id":10,"nick":"Stephen"},
{"id":11,"nick":"Pamela"},
{"id":12,"nick":"Irene"},
{"id":13,"nick":"Karen"},
{"id":14,"nick":"Diane"},
{"id":15,"nick":"Donald"},
{"id":16,"nick":"Frances"},
{"id":17,"nick":"Lawrence"},
{"id":18,"nick":"Fred"},
{"id":19,"nick":"Victor"},
{"id":20,"nick":"Joyce"},
{"id":21,"nick":"Raymond"},
{"id":22,"nick":"Carolyn"},
{"id":23,"nick":"Patricia"},
{"id":24,"nick":"Philip"},
{"id":25,"nick":"Joan"},
{"id":26,"nick":"Jesse"},
{"id":27,"nick":"Earl"},
{"id":28,"nick":"Jack"},
{"id":29,"nick":"Jeremy"},
{"id":30,"nick":"Johnny"},
{"id":31,"nick":"Lillian"},
{"id":32,"nick":"Raymond"},
{"id":33,"nick":"Philip"},
{"id":34,"nick":"Shawn"},
{"id":35,"nick":"Harry"},
{"id":36,"nick":"Jean"},
{"id":37,"nick":"Ralph"},
{"id":38,"nick":"Phyllis"},
{"id":39,"nick":"Judy"},
{"id":40,"nick":"Nicole"},
{"id":41,"nick":"Eugene"},
{"id":42,"nick":"Michelle"},
{"id":43,"nick":"Diana"},
{"id":44,"nick":"Victor"},
{"id":45,"nick":"Philip"},
{"id":46,"nick":"Katherine"},
{"id":47,"nick":"Christina"},
{"id":48,"nick":"Barbara"},
{"id":49,"nick":"Gregory"},
{"id":50,"nick":"Linda"}
    ];
})