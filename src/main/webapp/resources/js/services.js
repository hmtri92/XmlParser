angular.module("myApp", [ "ngResource" ]).factory("Idea", function($resource) {
    return $resource("./ideas/:id", {
        id: '@id'
    }, {
        update: {
            method: "PUT"
        },
        remove: {
            method: "DELETE"
        }
    });
});