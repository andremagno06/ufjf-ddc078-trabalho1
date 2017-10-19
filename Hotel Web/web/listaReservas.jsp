<%-- 
    Document   : Lista das reservas cadastradas
    Created on : 04/10/2017, 15:37:47
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
                <h2>RESERVAS</h2>   
            </div>
        </div>            
        <hr/>
        <div class="row">
            <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
                <a href="FrontController?action=InserirReservaCombo" class="btn btn-primary"><i class="fa fa-plus" aria-hidden="true"></i> Adicionar</a>
            </div>
        </div>
        <hr/>

        <table class="table table-striped table-bordered table-hover">
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
                <c:forEach var="reservas" items="${reservas}">
                    <tr>
                        <td class="text-center"><c:out value="${reservas.id}"/></td>
                        <td><c:out value="${reservas.data_reserva}"/></td>
                        <td><c:out value="${reservas.cliente.nome}"/></td>
                        <td><c:out value="${reservas.quarto.descricao}"/></td>
                        <td><c:out value="${reservas.data_checkin}"/></td>
                        <td><c:out value="${reservas.data_checkout}"/></td>
                        <td>
                            <a href="javascript:fazerCheckin('${reservas.data_checkin}', 'FrontController?action=CheckinReserva&id=${reservas.id}');"><i class="fa fa-check-square fa-lg" aria-hidden="true"></i></a> &nbsp;
                            <a href="javascript:fazerCheckout('${reservas.data_checkin}','${reservas.data_checkout}', 'FrontController?action=CheckoutReserva&id=${reservas.id}');"><i class="fa  fa-sign-out fa-lg" style="color:#a94442;" aria-hidden="true"></i></a>
                            <a href="FrontController?action=DesfazerCheckin&id=${reservas.id}"><i class="fa  fa-sign-out fa-lg" style="color:#a94442;" aria-hidden="true"></i></a>
                        </td>
                    </tr>
                </c:forEach>    
            </tbody>
        </table>
    </div>
</div>