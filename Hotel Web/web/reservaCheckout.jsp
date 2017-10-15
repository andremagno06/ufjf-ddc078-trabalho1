<%-- 
    Document   : Formulário para criação de uma nova reserva no hotel
    Created on : 04/10/2017, 15:36:21
    Author     : Ana Carolina Fidelis Gonçalves
                 André Magno
                 Davi de Almeida
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<div id="page-wrapper" >
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>RESERVAS >> CHECKOUT >> RESERVA Nº${reserva.id} </h2>   
            </div>
        </div>            
        <hr/>
        <form action="FrontController?action=GravarCheckout" method="post" onsubmit="return alterarReservaCheckin()">
            <input type="hidden" name="txtId" value="${reserva.id}"/>
            <div class="row">
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Cliente</label>
                        <input type="text" id="txtCliente" name="txtCliente" class="form-control" value="${reserva.cliente.nome}" disabled />
                    </div>
                </div>
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Quarto</label>
                        <input type="text" id="txtQuarto" name="txtQuarto" class="form-control" value="${reserva.quarto.descricao}" disabled />
                    </div>
                </div>
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Data da Reserva</label>
                        <input type="text" id="txtDataReserva" name="txtDataReserva" class="form-control" disabled value="${reserva.data_reserva}" />
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Data da Checkin</label>
                        <input type="text" id="txtCheckin" name="txtDataReserva" class="form-control" disabled value="${reserva.data_checkin}" />
                    </div>
                </div>
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Data de Checkout</label>
                        <input type="text" id="txtDataCheckout" name="txtDataCheckout" class="form-control" />
                    </div>
                </div>
            </div>
            <hr/>
            <button class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i> Salvar</button>
        </form>
    </div>
</div>