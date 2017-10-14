<%-- 
    Document   : Formulário para criação de uma nova reserva no hotel
    Created on : 04/10/2017, 15:36:21
    Author     : Ana Carolina Fidelis Gonçalves
                 André Magno
                 Davi de Almeida
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="page-wrapper" >
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>RESERVAS >> CHECKIN >> RESERVA Nº${reserva.id} </h2>   
            </div>
        </div>            
        <hr/>
        <form action="FrontController?action=GravarCheckin" method="post" onsubmit="return alterarReservaCheckin()">
            <input type="hidden" name="id" value="${reserva.id}"/>
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
                        <label>Data de Checkin</label>
                        <input type="text" id="txtDataCheckin" name="txtDataCheckin" class="form-control" />
                    </div>
                </div>
            </div>
            <hr/>
            <button class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i> Salvar</button>
        </form>
    </div>
</div>