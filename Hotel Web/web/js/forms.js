$(document).ready(function (e) {
    $("#txtNotificacao").click(function (e) {
        if ($(this).is(':checked'))
            $('#textEmail').removeAttr('disabled');
        else
            $('#textEmail').attr('disabled', 'disabled');
    });
});

function excluirRegistro(url) {
    if (confirm("Deseja realmente excluir registro?")) {
        window.location = url;
    }
}

function fazerCheckin(data, url) {
    if (data == '') {
        window.location = url;
    } else {
        alert("Checkin já foi realizado.");
    }
}

function fazerCheckout(checkin, checkout, url) {
    if (checkin == '') {
        alert('Realizar primeiro o checkin.');
    } else if (checkout != '') {
        alert("Checkout já foi realizado.");
    } else {
        window.location = url;

    }

}