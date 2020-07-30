app.controller("UserController",function($scope,$rootScope,UserService,modal,$location){
	
	$scope.roles = [{id:2,user:'User'},
					{id:1,prouser:'Provider book'}
					];

	$scope.sel="";
	$scope.ingresar=function(){
		$rootScope.rol=$scope.sel;
		
		if($rootScope.rol===2)
			$location.path("planillas");
		if($rootScope.rol===1)
			$location.path("personal");
		
		
	};
	
});
	