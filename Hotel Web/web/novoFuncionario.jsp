<%-- 
    Document   : Formulário de novo funcionário
    Created on : 04/10/2017, 15:24:14
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
                <h2>FUNCIONÁRIOS >> NOVO</h2>   
            </div>
        </div>            
        <hr/>

        <%--FORMULÁRIO PARA INCLUIR NOVO FUNCIONÁRIO--%>

         <form action="FrontController?action=InserirFuncionario" method="post">
            <div class="row">
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Nome</label>
                        <input type="text" name="textNome" class="form-control" />
                    </div>
                </div>
                
                 <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>CPF</label>
                        <input type="text" name="textCPF" class="form-control" />
                    </div>
                </div>
                
                 <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Endereço</label>
                        <input type="text" name="textEndereco" class="form-control" />
                    </div>
                </div>
        
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Email</label>
                        <input type="text" name="textEmail" class="form-control" />
                    </div>
                </div>
            </div>
              <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Quarto</label>
                        <select id="txtQuarto" name="txtQuarto" class="form-control">  
                            <option value="">Selecione</option>
                            <c:forEach var="quartos" items="${quartos}">
                                <option value="${quartos.id}">${quartos.descricao}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            <hr/>
            <button class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i> Salvar</button>
        </form>
    </div>
</div>