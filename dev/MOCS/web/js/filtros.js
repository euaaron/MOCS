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

function valida(tipo, id) {
    var campo = id;
    tipo = tipo.toLowerCase();
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
        if(tipo==='cep') cep.style.border="solid 1px red"; 
        if(tipo==='cpf') cpf.style.border="solid 1px red";
        return 0;
    } else {
        if(tipo==='cep') cep.style.border="solid 1px lightgreen";
        if(tipo==='cpf') cpf.style.border="solid 1px lightgreen";
        return 1;
    }    
}

function formataCPF(filtrado) {
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
        var tipo = cpf;
        valida('cpf', tipo);
    }
    if(cpf.value.length < 14) {
        cpf.style.border = "solid 1px gray";
    }
    cpf.value = formatado;
}

function filtraCPF() {
    var tipo = cpf;
    if (valida('cpf', tipo) === 1) {
        return;
    }
    var filtrado = "";
    var filtrar = String(cpf.value);

    for (i = 0; i <= cpf.value.length; i++) {
        if (
            filtrar.substr(i,1).charCodeAt(0) >= 48 &&
            filtrar.substr(i,1).charCodeAt(0) <= 57
        )
        {
            filtrado += filtrar.substr(i,1);
        }
    }
    formataCPF(filtrado);
}

function formataCPF(filtrado) {
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
        validaCPF();
    }
    if(cpf.value.length < 14) {
        cpf.style.border = "solid 1px gray";
        aviso.innerHTML = "";
    }
    cpf.value = formatado;
}

function formataCEP(filtrado) {
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

function filtraCEP() {
    if (valida('cep', cep) === 1) {
        return;
    }
    var filtrado = "";
    var filtrar = String(cep.value);

    for (i = 0; i <= cep.value.length; i++) {
        if (
            filtrar.substr(i,1) === "0" ||
            filtrar.substr(i,1) === "1" ||
            filtrar.substr(i,1) === "2" ||
            filtrar.substr(i,1) === "3" ||
            filtrar.substr(i,1) === "4" ||
            filtrar.substr(i,1) === "5" ||
            filtrar.substr(i,1) === "6" ||
            filtrar.substr(i,1) === "7" ||
            filtrar.substr(i,1) === "8" ||
            filtrar.substr(i,1) === "9"
        )
        {
            filtrado += filtrar.substr(i,1);
        }
    }
    formataCEP(filtrado);
}

function filtraCPF() {
    if (validaCPF() === 1) {
        return;
    }
    var filtrado = "";
    var filtrar = String(cpf.value);

    for (i = 0; i <= cpf.value.length; i++) {
        if (
            filtrar.substr(i,1).charCodeAt(0) >= 48 &&
            filtrar.substr(i,1).charCodeAt(0) <= 57
        )
        {
            filtrado += filtrar.substr(i,1);
        }
    }
    formataCPF(filtrado);
}
