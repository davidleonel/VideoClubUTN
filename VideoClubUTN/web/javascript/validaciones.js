/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var isEmail = function(email){
    expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (expr.test(email)){
        return true;
    } else {
        return false;
    }
};
var estaVacio = function(campo){
    if (campo === undefined || campo==="")
        {
           return false; 
        }
    return true;        
};
var soloNumero = function(campo){
    expr = /^([0-9])*$/;
    if(expr.test(campo))
        return true;
    else{
        return false;
    }
};
var validaDuracion = function(campo){
    expr = /^([0-9])+([.,]([0-9]){2})?$/;
    if(expr.test(campo))
        return true;
    else{
        return false;
    }
};
var soloFloat = function(campo){
    expr = /^([0-9])*[.]?[0-9]*$/;
    if(expr.test(campo))
        return true;
    else{
        return false;
    }
};
var soloTexto = function(campo){
  expr = /^[A-Za-z\_\-\.\s\xF1\xD1]+$/;
    if (expr.test(campo)){
        return true;
    }else {
        return false;
    }
};
var isJpg = function(campo){
    expr = /\.jpg$/i;
    
    if (expr.test(campo)){
        return true;
    }else {
        return false;
    }        
};



