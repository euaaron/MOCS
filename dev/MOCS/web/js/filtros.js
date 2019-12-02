/* 
* The MIT License
*
* Copyright 2019 @euaaron (euaaron.github.io)
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
*/

var filtra = function filtra(type) {
    var campo = document.getElementById(type);
    var tipo = type.toLowerCase();
    if (valida(tipo, id) === 1) {
        return;
    }
    var filtrado = "";
    var filtrar = String(campo.value);
    
    for (i = 0; i <= campo.value.length; i++) {
        if (
            filtrar.substr(i,1).charCodeAt(0) >= 48 &&
            filtrar.substr(i,1).charCodeAt(0) <= 57
            )
            {
                filtrado += filtrar.substr(i,1);
            }
        }
        if(tipo==='cep') {
            formataCEP(campo, filtrado);
        }
        if(tipo==='cpf') {
            formataCPF(campo, filtrado);
        }
        if(tipo==='cnpj') {
            formataCNPJ(campo, filtrado);
        }
    }
    
    function valida(tipo, campo) {
        var pattern;
        
        if(tipo==='cep') {
            pattern = /^\d{2}.\d{3}-\d{3}$/;
        }
        if(tipo==='cpf') {
            pattern = /^\d{3}.\d{3}.\d{3}-\d{2}$/;
        }
        if(tipo==='cnpj') {
            pattern = /^\d{3}.\d{3}.\d{3}-\d{2}$/;
        }
        
        if(!pattern.test(campo.value)) {
            campo.style.border="solid 1px red"; 
            return 0;
        } else {
            campo.style.border="solid 1px lightgreen";
            return 1;
        }    
    }
    
    /*
    * -------- CPF
    */
    
    function formataCPF(cpf, filtrado) {
        var formatado = "";
        var temp = filtrado;
        if (cpf.value.length <= 3)
        {
            formatado = temp;
        }
        if (cpf.value.length > 3 && temp.length <= 6)
        {
            formatado = temp.substr(0,3);
            formatado += ".";
            formatado += temp.substr(3,3);
        }
        if (cpf.value.length > 6 )
        {
            formatado = temp.substr(0,3);
            formatado += ".";
            formatado += temp.substr(3,3);
            formatado += ".";
            formatado += temp.substr(6,3);
        }
        if (cpf.value.length > 9 )
        {
            formatado = temp.substr(0,3);
            formatado += ".";
            formatado += temp.substr(3,3);
            formatado += ".";
            formatado += temp.substr(6,3);
            formatado += "-";
            formatado += temp.substr(9,2);
        }
        if(cpf.value.length >= 14) {
            valida('cpf', cpf);
        }
        if(cpf.value.length < 14) {
            cpf.style.border = "solid 1px gray";
        }
        cpf.value = formatado;
    }
    
    /*
    * -------- CEP
    */
    
    function formataCEP(cep, filtrado) {
        var formatado = "";
        var temp = String(filtrado);
        if (cep.value.length <= 2)
        {
            formatado = temp.substr(0,2);
        }
        if (cep.value.length > 2 && temp.length <= 5)
        {
            formatado = temp.substr(0,2);
            formatado += ".";
            formatado += temp.substr(2,3);
        }
        if (cep.value.length > 5 )
        {
            formatado = temp.substr(0,2);
            formatado += ".";
            formatado += temp.substr(2,3);
            formatado += "-";
            formatado += temp.substr(5,3);
        }
        if(cep.value.length >= 10) {
            valida('cep', cep);
        }
        if(cep.value.length < 10) {
            cep.style.border = "solid 1px gray";
        }
        cep.value = formatado;
    }
    
    /*
    * -------- CNPJ
    */
    
    function formataCNPJ(cnpj, filtrado) {
        var formatado = "";
        var temp = filtrado;
        if (cpf.value.length <= 3)
        {
            formatado = temp;
        }
        if (cpf.value.length > 3 && temp.length <= 6)
        {
            formatado = temp.substr(0,3);
            formatado += ".";
            formatado += temp.substr(3,3);
        }
        if (cpf.value.length > 6 )
        {
            formatado = temp.substr(0,3);
            formatado += ".";
            formatado += temp.substr(3,3);
            formatado += ".";
            formatado += temp.substr(6,3);
        }
        if (cpf.value.length > 9 )
        {
            formatado = temp.substr(0,3);
            formatado += ".";
            formatado += temp.substr(3,3);
            formatado += ".";
            formatado += temp.substr(6,3);
            formatado += "-";
            formatado += temp.substr(9,2);
        }
        if(cpf.value.length >= 14) {
            valida('cnpj', cnpj);
        }
        if(cpf.value.length < 14) {
            cpf.style.border = "solid 1px gray";
            aviso.innerHTML = "";
        }
        cpf.value = formatado;
    }
    
    
    /*
    * ------- DATA
    */
   
   function setDate(){
       var listaData = document.getElementsByClassName("data");            
    
        for(let i = 0; i < listaData.length; i++) {
            let date = new Date(listaData[i].innerHTML);
            listaData[i].innerHTML = formataData(date);
        }
   }
    
    function formataData(date) {
        let dia = date.getDay();
        let mes;
        let ano = date.getFullYear();
        switch(date.getMonth()){
            case 1:
            mes = 'JAN';
            break;
            case 2:
            mes = 'FEV';
            break;
            case 3:
            mes = 'MAR';
            break;
            case 4:
            mes = 'ABR';
            break;
            case 5:
            mes = 'MAIO';
            break;
            case 6:
            mes = 'JUN';
            break;
            case 7:
            mes = 'JUL';
            break;
            case 8:
            mes = 'AGO';
            break;
            case 9:
            mes = 'SET';
            break;
            case 10:
            mes = 'OUT';
            break;
            case 11:
            mes = 'NOV';
            break;
            case 12:
            mes = 'DEZ';
            break;
            default:
            mes = 'nulo';
            break;
        }
        return dia + " " + mes + " " + ano;
    }