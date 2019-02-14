var app = angular.module("margoWeb", []);
app.controller("MainCtrl", function ($scope, $http) {
    $scope.messageTitle = "Welcome JS Application";
    $scope.people = [];
    $scope.notifications = [];

    $scope.deleteSelectedPerson = function (person) {
        $http({
            method: 'POST',
            url: '/api/delete',
            data: person.id
        }).then(function (response) {
            $scope.people = response.data
        });
    };

    $scope.postNotification = function () {
        $http({
            method: "POST",
            url: '/api/notifications/postNotification',
            data: $scope.notification
        }).then(function (response) {
            $scope.notifications = response.data;
        });
    }
});
app.controller("TransactionCtrl", function ($scope, $http) {
    $scope.transactions = [];
    $scope.sum = [];
    $http({
        method: 'GET',
        url: 'api/transactions/getAll'
    }).then(function (response) {
        $scope.transactions = response.data;

    });
    $scope.postTransaction = function () {
        $http({
            method: "POST",
            url: '/api/transactions/postTransactions',
            data: $scope.transaction
        }).then(function (response) {
            $scope.transactions = response.data;
        });
    }
});