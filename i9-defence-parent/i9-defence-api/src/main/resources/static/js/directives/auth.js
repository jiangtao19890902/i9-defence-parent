angular.module('app')
.directive('controlledRescode', ['$http', 'removeElement','$cookieStore', function ($http, removeElement,$cookieStore) {
    return{
    	scope: {
    		callBack: '&'
        },
        restrict: 'A',
        link: function (scope, element, attributes) {
        	var noAllowedAuthList = $cookieStore.get('noAllowedAuthList');
			if(noAllowedAuthList != null){
	            for (i = 0; i < noAllowedAuthList.length; i++) {
	                var element = angular.element("."+noAllowedAuthList[i]);
	                removeElement(element);
	            }
			}
            /*$http.get('./security/noAllowedAuth').then(function (resp) {
            	$cookieStore.put('name','lanveer');
            	console.log($cookieStore.get('name'));
            	var noAllowedAuthList = resp.data.data.data;
				//如果有回调函数，调用回调函数
				if(attributes.callBack != null){
					scope.callBack({data:noAllowedAuthList});
					return ;
				}
				//如果没有回调函数，按默认方式处理
				if(noAllowedAuthList != null){
		            for (i = 0; i < noAllowedAuthList.length; i++) {
		                var element = angular.element("."+noAllowedAuthList[i]);
		                removeElement(element);
		            }
				}
				
			});*/
            
        },
        controller: function ($scope, $element, $attrs, $transclude) { 
            // var opts = $($element).datagrid('options');
            // console.info(opts);
            
            //console.info($scope.element.datagrid('options'));
            //var callback = $scope.init();
            //callback($scope.element);
        }
    }
}]).constant('removeElement', function(element){
    element && element.remove && element.remove();
});
