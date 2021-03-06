var channelDataNgModule=angular.module('channelDataNgModule',['ngAnimate','ui.bootstrap','app']);
var channelDataService = channelDataNgModule.factory('channelDataService',
		['$resource', function($resource){
			//指定url格式:../模块名/服务名/方法名?参数
			var path = '../rest/:moduleName/:serviceName/:methodName?rnd=:random';
			//service忠的方法
			var resource = $resource(path, {}, {
				save : {
					method : 'POST',
					params : {
						moduleName : 'proj',
						serviceName : 'info',
						methodName : 'save',
						//role : '@role',
						//rp : '@rp',
						random : Math.random()
					}
				},
			});
			return resource;
	}]);
var channelDataNgControl=channelDataNgModule.controller('channelDataNgControl',function($rootScope, $scope,$stateParams,  $log, $http, $window, $state,$modal, toaster,channelDataService,httpService){
	//分页条件
	$scope.pageSize = 10;
	$scope.currentPage = 1;
	//初始化
	$scope.initTable = function (){
		var pageParam = {
				pageSize:$scope.pageSize,
				currentPage:$scope.currentPage,
				//state:$scope.selectState,
				//username : $scope.searchText
			};
		
		httpService.post({url:'./channel/pageChannel',data:pageParam,showSuccessMsg:false}).then(function(data) {  
			$scope.channelDatas = data.data.data.pageList;
			for(var i=0;i<$scope.channelDatas.length;i++){
				var type = $scope.channelDatas[i].type;
				var value = $scope.channelDatas[i].value;
				var warningMin = $scope.channelDatas[i].warningMin;
				var warningMax = $scope.channelDatas[i].warningMax;
				var hiddenMax = $scope.channelDatas[i].hiddenMax;
				var hiddenMin = $scope.channelDatas[i].hiddenMin;
				if (type == 0) {
					$scope.channelDatas[i].errorName =  "故障";
				}else if (type == 5) {
					if (value >= warningMax || value <= warningMin) {
						$scope.channelDatas[i].errorName = "报警";
					}else if ((value < hiddenMin && value > warningMin) || (value > hiddenMax && value < warningMax)){
						$scope.channelDatas[i].errorName = "隐患";
					}else{
						$scope.channelDatas[i].errorName = "正常";
					}
				}
				
			}
			$scope.hasPrevious = data.data.data.hasPrevious;
			$scope.currentPage = data.data.data.currentPage;
			$scope.hasNext = data.data.data.hasNext;
			$scope.total = data.data.data.totalSize;
			$scope.start = data.data.data.offset+1;
			$scope.end = data.data.data.offset+$scope.channelDatas.length;
			$scope.pages = data.data.data.loopPageNum;
			$scope.currentPage = pageParam.currentPage;
		})
	};
	$scope.initTable();
	
	//修改分页大小
	$scope.changePageSize = function(){
		$scope.currentPage = 1;
		$scope.initTable();
	}
	//上一页
	$scope.lastPage = function(){
		if ($scope.hasPrevious){
			$scope.currentPage -=1;
			$scope.initTable();
		}
	}
	//下一页
	$scope.nextPage = function (){
		if ($scope.hasNext){
			$scope.currentPage +=1;
			$scope.initTable();
		}
	}
	//跳转
	$scope.pageTo = function(page){
		$scope.currentPage = page;
		$scope.initTable();
	}
	$scope.search = function(){
		$scope.initTable();
	}
	
	/*$scope.add = function () {  
        var modalInstance = $modal.open({  
            templateUrl: 'proj/hiddendanger/add.html',  
            controller: 'hiddendangerEditCtrl', 
            backdrop:"static",//但点击模态窗口之外时，模态窗口不关闭
            resolve: {  
            	deps : ['$ocLazyLoad',function($ocLazyLoad) {
        			return $ocLazyLoad.load({
        				name : 'hiddendangerEditNgModule',
        				insertBefore : '#ng_load_plugins_before',
        				files : [
        				         'proj/hiddendanger/add.js',
        				]
        			});
        		}],
        		hiddendanger: function () {  
                    return {};  
                },
            }  
        }); 
        modalInstance.result.then(function(data){//$modalInstance.close()正常关闭后执行的函数
            $scope.selected = data;
        },function(){//$modalInstance.dismiss('cancel')后执行的函数，取消或退出执行的函数
        	$scope.initTable();
        });
         
    }; */
    
   /* $scope.del = function(){
    	$scope.delArray = [];
    	angular.forEach(angular.element.find(".o-checks"), function(dom){
    		if(angular.element(dom).prop("checked") == true){
    			$scope.delArray.push(angular.element(dom).attr("data-id"))
    		}
		});
    	confirm("确定删除吗?", "", function (isConfirm) {
            if (isConfirm) {
            	httpService.post({url:'./apply/delApply',data:$scope.delArray,showSuccessMsg:true}).then(function(data) {  
            		$scope.initTable();
            	})
            } else {
            }
        }, {confirmButtonText: '确定', cancelButtonText: '取消', width: 400});
    }*/
 
})
