<%-- 
    Document   : Mensagem de sucesso
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
                <h2>Mensagens enviadas para os Funcionarios</h2>   
            </div>
        </div>            
        <hr />   
        <div class="alert alert-success">
            <strong>Mensagem : </strong>:                 Salvo com sucesso!
          
        </div>
         <table class="table table-striped table-bordered table-hover">
          <tbody>
                <c:forEach var="mensagem" items="${mensagem}">
                    <tr>
                        <td><c:out value="${mensagem}"/></td> 
                        <td class="text-center"></td>
                    </tr>
                </c:forEach> 
            </tbody>
</table>
    </div>
</div>

