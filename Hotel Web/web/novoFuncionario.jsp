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
        <form action="FrontController?action=InserirFuncionario" method="post">
            <div class="row">
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Nome</label>
                        <input type="text" name="textNome" class="form-control" required="" />
                    </div>
                </div>

                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>CPF</label>
                        <input type="text" name="textCPF" class="form-control"/>
                    </div>
                </div>

                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Endereço</label>
                        <input type="text" name="textEndereco" class="form-control" />
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 col-md-12">
                    <div class="checkbox">
                        <label><input type="checkbox" id="txtNotificacao" name="txtNotificacao" value="S">Receber notificações de reserva no e-mail.</label>
                    </div>
                </div>
                <div class="col-lg-5 col-md-5">
                    <div class="form-group">
                        <label>Email</label>
                        <input type="text" id="textEmail" name="textEmail" class="form-control" disabled required="" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"/>
                    </div>
                </div>
            </div>
            <hr/>
            <button class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i> Salvar</button>
        </form>
    </div>
</div>