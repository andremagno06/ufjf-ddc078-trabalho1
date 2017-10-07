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

