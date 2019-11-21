
function campoNumerico(valor)
{
    var caracteresValidos = "0123456789";
    var ehNumero = true;
    var umCaracter;
    for (i = 0; i < valor.length && ehNumero == true; i++)
    {
        umCaracter = valor.charAt(i);
        if (caracteresValidos.indexOf(umCaracter) == -1)
        {
            ehNumero = false;
        }
    }
    return ehNumero;
}

function validarFormulario(form) {
    var mensagem;
    mensagem = "";
    if (form.txtCodCurso.value == "") {
        mensagem = mensagem + "Informe o Código do Curso\n";
    }
    if (form.txtNomeCurso.value == "") {
        mensagem = mensagem + "Informe o Nome do Curso\n";
    }
    if (form.txtTotalPeriodos.value == "") {
        mensagem = mensagem + "Informe o Total de Períodos\n";
    }
    if (form.txtCargaHoraria.value == "") {
        mensagem = mensagem + "Informe a Carga Horária\n";
    }
    if (!campoNumerico(form.txtCodCurso.value)) {
        mensagem = mensagem + "Código do Curso deve ser numérico\n";
    }
    if (!campoNumerico(form.txtTotalPeriodos.value)) {
        mensagem = mensagem + "Total de Períodos deve ser numérico\n";
    }
    if (!campoNumerico(form.txtCargaHoraria.value)) {
        mensagem = mensagem + "Carga Horária deve ser numérica\n";
    }
    if (mensagem == "") {
        return true;
    } else {
        alert(mensagem);
        return false;
    }
}