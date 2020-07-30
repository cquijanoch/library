app.service("UserService",function(SendRequest){
	
	this.getAll = function(url,request){
		return SendRequest.noAuthenticatedRequest('GET',url,null);
	};
	
	this.add = function(url,request){
		return SendRequest.noAuthenticatedRequest('POST',url,request);
	}
	
	this.update = function(url,request){
		return SendRequest.noAuthenticatedRequest('PUT',url,request)
	}
	
});

function iniciarPosiciones(miArray){
    miArray.forEach(function(item,index){
        item.i = index;
    });
};

function insertarElemento(miArray, elemento){
    elemento.i = miArray.length;
    miArray.push(elemento);
};

function eliminarElemento(miArray, posElemento){
    miArray.splice( posElemento ,1);
    for (var i = posElemento,l = miArray.length; i < l; i++)
        miArray[i].i = i;
};


