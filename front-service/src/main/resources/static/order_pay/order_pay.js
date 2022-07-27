angular.module('market-front').controller('orderPayController', function ($scope, $http, $location, $localStorage, $routeParams) {
    const contextPath = 'http://localhost:5555/core/';

    $scope.loadOrder = function () {
        $http({
            url: contextPath + 'api/v1/orders/' + $routeParams.orderId,
            method: 'GET'
        }).then(function (response) {
                    $scope.order = response.data;
                    $scope.renderPaymentButtons();
        });
    }

    $scope.renderPaymentButtons = function () {
        paypal.Buttons({
            createOrder: function (data, actions) {
                return fetch(contextPath + 'api/v1/paypal/create/' + $scope.order.id, {
                    method: 'POST',
                    headers: {
                        'content-type': 'application/json'
                    }
                }).then(function (response) {
                   return response.text();
                });
            },

            onApprove: function (data, actions) {
                return fetch(contextPath +'api/v1/paypal/capture/' + data.orderId, {
                    method: 'POST',
                    headers: {
                        'content-type': 'application/json'
                    }
                }).then(function (response) {
                    return response.text().then(msg => alert(msg));
                });
            },

            onCancel: function (data) {
                console.log("Order canceled: " + data);
            },

            onError: function (err) {
                console.log(err);
            }
        }).render('#paypal-buttons');
    }

    $scope.loadOrder();
});