var monitoringChartEditNgModule = angular.module('monitoringChartEditNgModule', [ 'ngResource',
		'ngCookies', 'ui.bootstrap', 'toaster', 'app' ]);

app.filter('propsFilter', function() {
    return function(items, props) {
        var out = [];

        if (angular.isArray(items)) {
          items.forEach(function(item) {
            var itemMatches = false;

            var keys = Object.keys(props);
            for (var i = 0; i < keys.length; i++) {
              var prop = keys[i];
              var text = props[prop].toLowerCase();
              if (item[prop].toString().toLowerCase().indexOf(text) !== -1) {
                itemMatches = true;
                break;
              }
            }

            if (itemMatches) {
              out.push(item);
            }
          });
        } else {
          // Let the output be the input untouched
          out = items;
        }

        return out;
    };
})
var monitoringChartEditCtrl = monitoringChartEditNgModule.controller('monitoringChartEditCtrl', function($scope,
		$rootScope, $modalInstance, $cookieStore, $http, $window, toaster,
		monitoringChart,clientList,httpService,$timeout) {
	
	$scope.monitoringChart = monitoringChart;
	$scope.clientList = clientList;
	$scope.closeBtn = function() {
		$modalInstance.dismiss('cancel');
	}
	// 确认添加
	$scope.confirmAdd = function() {
		if ($scope.monitoringChart.passagewayName ==null ||$scope.monitoringChart.passagewayName ==0) {
			$.toaster({
				title : "Error",
				priority : "danger",
				message : "项目名不能为空!"
			});
			return false;
		}
		httpService.post({url:'./monitoringChart/addMonitoringChart',data:$scope.monitoringChart,showSuccessMsg:true}).then(function(data) {  
			$modalInstance.dismiss('cancel')
		})
	};
});