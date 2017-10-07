<%-- 
    Document   : Lista de Quartos cadastrados
    Created on : 04/10/2017, 15:14:22
    Author     : Ana Carolina
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<div id="page-wrapper" >
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>QUARTOS</h2>   
            </div>
        </div>            
        <hr/>
        <div class="row">
            <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
                <a href="novoQuarto.jsp" class="btn btn-primary"><i class="fa fa-plus" aria-hidden="true"></i> Adicionar quarto</a>
            </div>
        </div>
        <hr/>

        <%-- MOSTRAR TODOS OS QUARTOS --%>
        <table class="table table-striped table-bordered table-hover">
            <thead>
                <tr>
                    <th class="text-center">#</th>
                    <th>Descrição</th>
                    <th>Tipo de Quarto</th>
                    <th>Estado</th>
                    <th>Operações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="quartos" items="${quartos}">
                    <tr>
                        <td class="text-center"><c:out value="${quartos.id}"/></td>
                        <td><c:out value="${quartos.descricao}"/></td>
                        <td><c:out value="${quartos.tipo_quarto_id}"/></td>
                        <td><c:out value="${quartos.estado}"/></td>
                        <td>
                            <a href="FrontController?action=ExibirQuartos&id=${quartos.id}"><i class="fa fa-pencil-square-o fa-lg" aria-hidden="true"></i></a> &nbsp;
                            <a href="FrontController?action=ExibirQuartos&id=${quartos.id}" onclick="confirm('Deseja realmente excluir?');"><i class="fa fa-trash fa-lg" style="color:#a94442;" aria-hidden="true"></i></a>
                        </td>
                    </tr>
                </c:forEach>    
            </tbody>
        </table>
    </div>
</div>
