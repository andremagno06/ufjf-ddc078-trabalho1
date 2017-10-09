function novoQuarto() {
    var descricao = $('#txtDescricao').val();
    var tipo = $('#txtTipo').val();
    if (descricao == '') {
        alert("Informe a descrição do quarto.");
        return false;
    }

    if (tipo == '') {
        alert('Informe o tipo do quarto.');
        return false;
    }

    return true;
}

function alterarQuarto() {
    var descricao = $('#txtDescricao').val();
    var tipo = $('#txtTipo').val();
    var estado = $('#txtEstado').val();
    if (descricao == '') {
        alert("Informe a descrição do quarto.");
        return false;
    }

    if (tipo == '') {
        alert('Informe o tipo do quarto.');
        return false;
    }
    
    if(estado == ''){
        alert('Informe o estado do quarto.');
        return false;
    }

    return true;
}

function excluirRegistro(url) {
    if (confirm("Deseja realmente excluir registro?")) {
        window.location = url;
    }
}
