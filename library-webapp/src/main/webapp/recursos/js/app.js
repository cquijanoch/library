var app= angular.module("demoApp",[
	'ngRoute','treeControl', 'ngTable', 'ngAnimate','ui.bootstrap','chart.js','ngMaterial'
]);



app.config(function($routeProvider){
	$routeProvider
	 .when('/startMenu', {
   	  	  controller: 'UserController',
 		  templateUrl: 'views/startMenu.html',
     })
     .when("/startSubMenu", {
        templateUrl : "startSubMenu.html"
     })
     .when('/rental', {
    	 controller: 'RentalController',
         templateUrl : 'views/rental.html'
     })
     .when('/library', {
    	 controller: 'LibraryController',
         templateUrl : 'views/library.html'
     })
     .otherwise( {
         redirectTo: '/'
      } );
});


app.run(['$rootScope','$location',function($rootScope,$location) {
    
    if( window.innerWidth < 479 ){
        $rootScope.movil = true;
    }
        
    $rootScope.usuMaster = {user:"",rol:"",organization:""};
    $rootScope.menuPrincipal = [];
    $rootScope.rol="";
    
    $rootScope.noticias = [{hora:"0:0",titulo:"noticia nueva",descripcion:"descripcion"},{hora:"0:0",titulo:"noticia nueva",descripcion:"descripcion"}];
    $rootScope.notificaciones = [];//[{tipo:"alert-info",nombre:"notificacino de alerta"},{tipo:"alert-danger",nombre:"notificacino de peligro"},{tipo:"alert-warning",nombre:"notificacino de exito"}];
    $rootScope.mensajes = [];//[{nombre:"profesor",hora:"10:00",contenido:"hola como estas"},{nombre:"profesor",hora:"10:00",contenido:"hola como estas"}];
    
    
    $rootScope.menu = [
    	{nombre:"Library",id:"1"},
    	{nombre:"Rental",id:"2"}
    	];
    $rootScope.modNom = "";
    $rootScope.subModNom = "";
    $rootScope.visNom = "";    
    
    $rootScope.inicio = function(){
        $rootScope.menu = [];
        $rootScope.modNom = "";
        $rootScope.subModNom = "";
        $rootScope.visNom = "";
        $location.path("startMenu");
    };
        
    $rootScope.elegirMenu = function(menu){        
        $rootScope.menu = menu.subModulos;
        $rootScope.modNom = $rootScope.movil? menu.codigo: menu.nombre;
        localStorage.setItem('menu', JSON.stringify($rootScope.menu));
        localStorage.setItem('modNom', $rootScope.modNom);
        $rootScope.subModNom = "";
        $rootScope.visNom = "";
        $rootScope.color = menu.color;
        $location.path("startSubMenu");
    };
    $rootScope.menuToggle = function(e,subModulo){
        if(subModulo.funciones){
            if($rootScope.subModNom == ($rootScope.movil? subModulo.codigo: subModulo.nombre)){
                $rootScope.subModNom = "";
                localStorage.setItem('subModNom', "");
                $location.path("subMenuInicio");
            }
            else{                
                $rootScope.subModNom = $rootScope.movil? subModulo.codigo: subModulo.nombre;
                localStorage.setItem('subModNom', $rootScope.subModNom);
            }
            $rootScope.visNom = "";            
        }
    };
    $rootScope.elegirVista = function(vista,subModulo){
        $rootScope.visNom = vista.nombre;
        localStorage.setItem('visNom', JSON.stringify($rootScope.visNom));
        if(subModulo){
            $rootScope.subModNom = $rootScope.movil? subModulo.codigo: subModulo.nombre;;
            localStorage.setItem('subModNom', $rootScope.subModNom);
        }
        else{
            if(window.innerWidth < 981){
                $('#sidebar').toggleClass('hide-left-bar');
                $('#main-content').toggleClass('merge-left');
            }
        }
        $location.path(vista.clave);
    };
    $rootScope.ocultarMenu = function(){
        $('#sidebar').toggleClass('hide-left-bar');
        $('#main-content').toggleClass('merge-left');
    };
    $rootScope.mostrarMenuDerecha = function(){
        $('.right-sidebar').toggleClass('hide-right-bar');
        $('#main-content').toggleClass('merge-right');
    };
    $rootScope.verAyuda = function(){
        
        var o = buscarObjeto($rootScope.menu,'nombre',$rootScope.subModNom);
        if(o){
            $rootScope.imgAyuda = o.codigo.trim()+'.png';
            $('#modalAyuda').modal('show');
        }
    };
   
    /*
    $rootScope.menu = $rootScope.menuPrincipal[0].subModulos;
    $rootScope.modNom = $rootScope.menuPrincipal[0].nombre;*/
 
    /*
    $rootScope.$on('$routeChangeStart', function(event, next, current) {
        alert("next: "+next.templateUrl+"   current: "+current);
        
        if ( localStorage.getItem('jwt') == null ) {
            $window.location.href = $window.location.href + "/";
        }
        else {
            //var user = localStorage.getItem('user');
            if( next.templateUrl == 'app/login.html' )
                $window.location.href = $window.location.href + "/";
        }
    });*/
    
}]);