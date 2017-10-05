<%-- 
    Document   : Lista das reservas cadastradas
    Created on : 04/10/2017, 15:37:47
    Author     : Ana Carolina Fidelis Gonçalves
                 André Magno
                 Davi de Almeida
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="page-wrapper" >
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>RESERVAS</h2>   
            </div>
        </div>            
        <hr/>
        <div class="row">
            <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
                <a href="novaReserva.jsp" class="btn btn-primary"><i class="fa fa-plus" aria-hidden="true"></i> Adicionar reserva</a>
            </div>
        </div>
        <hr/>
        
        <table class="table">
            <thead>
                <tr>
                    <th class="text-center">#</th>
                    <th>Data reserva</th>
                    <th>Cliente</th>
                    <th>Quarto</th>
                    <th>Check-in</th>
                    <th>Check-out</th>
                    <th>Operações</th>
                </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
</div>