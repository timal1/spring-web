angular.module('market-front').controller('storeController', function ($scope, $http, $location, $localStorage) {
    const contextPath = 'http://localhost:5555/';

    $scope.loadProducts = function (pageIndex = 1) {
        $http({
            url: contextPath + 'core/api/v1/products',
            method: 'GET',
            params: {
                number_page: pageIndex,
                category_part: $scope.filter ? $scope.filter.category_part : null,
                title_part: $scope.filter ? $scope.filter.title_part : null,
                min_price: $scope.filter ? $scope.filter.min_price : null,
                max_price: $scope.filter ? $scope.filter.max_price : null
            }
        }).then(function (response) {
            $scope.ProductsPage = response.data;
            $scope.paginationArray = $scope.generatePagesIndexes(1, $scope.ProductsPage.totalPages);
        });
    };

    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.addToCart = function (productId) {
        $http.get(contextPath + 'cart/api/v1/cart/' + $localStorage.springWebGuestCartId + '/add/' + productId)
            .then(function successCallback(response) {
            }, function errorCallback(response) {
                alert("statusCode: " + response.data.statusCode + "/ Message: " + response.data.message);
            });
    }
    $scope.loadProducts();
});