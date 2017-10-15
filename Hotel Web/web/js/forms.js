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

    if (estado == '') {
        alert('Informe o estado do quarto.');
        return false;
    }

    return true;
}

function novaReserva() {
    var cliente = $('#txtCliente').val();
    var quarto = $('#txtQuarto').val();
    var data = $('#txtDataReserva').val();
    if (cliente == '') {
        alert('Informe o cliente.');
        return false;
    }

    if (quarto == '') {
        alert('Informe o quarto.');
        return false;
    }

    if (data == '') {
        alert('Informe a data.');
        return false;
    }
    return true;
}

function excluirRegistro(url) {
    if (confirm("Deseja realmente excluir registro?")) {
        window.location = url;
    }
}

function fazerCheckin(data, url) {
    if (data == '') {
        window.location = url;
    }else{
        alert("Checkin já foi realizado.");
    }
}

function fazerCheckout(data, url) {
    if (data == '') {
        window.location = url;
    }else{
        alert("Checkout já foi realizado.");
    }
}

function alterarReservaCheckin() {
    var data = $('#txtDataCheckin').val();
    if (data == '') {
        alert('Informe a data.');
        return false;
    }
    return true;
}
