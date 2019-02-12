var app = angular.module("margoWeb", []);
app.controller("MainCtrl", function ($scope, $http) {
    $scope.messageTitle = "Welcome JS Application";
    $scope.people = [];
    $scope.notifications = [];

    $http({
        method: 'GET',
        url: 'api/person/getAll'
    }).then(function (response) {
        $scope.people = response.data;
    });

    $http({
        method: "GET",
        url: 'api/notifications/getAll'
    }).then(function (response) {
        $scope.notifications = response.data;
    });

    //
    // $scope.deleteItem = function (people) {
    //     $scope.people.splice($scope.people.indexOf(people), 1);
    //     $http({
    //         method: 'GET',
    //         url: 'api/delete/person/' + people.id
    //     });
    // }

    $scope.registerNewPerson = function () {
        $http({
            method: 'POST',
            url: '/api/person/postPerson',
            data: $scope.person
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