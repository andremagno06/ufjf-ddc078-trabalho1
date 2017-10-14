<%-- 
    Document   : Lista de funcionários cadastrados
    Created on : 04/10/2017, 15:22:54
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
                <h2>FUNCIONARIO</h2>   
            </div>
        </div>            
        <hr/>
        <div class="row">
            <div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
                 <a href="FrontController?action=FuncionarioExibirInserir" class="btn btn-primary"><i class="fa fa-plus" aria-hidden="true"></i> Adicionar Funcionario</a>
            </div>
        </div>
        <hr/>

        <%-- MOSTRAR TODOS OS CLIENTES EXISTENTES --%>

        <table class="table table-striped table-bordered table-hover">
            <thead>
                <tr>
                    <th class="text-center">#</th>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Endereço</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="pessoas" items="${pessoas}">
                <tr>
                    <td class="text-center"><c:out value="${pessoas.id}"/></td>
                <td><c:out value="${pessoas.nome}"/></td>
                <td><c:out value="${pessoas.cpf}"/></td>
                <td><c:out value="${pessoas.endereco}"/></td>
                <td><c:out value="${pessoas.email}"/></td>
                <td class="text-center"></td>
            </c:forEach>    
            </tr>
            </tbody>
        </table>
    </div>
</div>
