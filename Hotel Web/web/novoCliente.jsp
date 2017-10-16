<%-- 
    Document   : Formulário para cadastro de novos clientes
    Created on : 04/10/2017, 15:34:36
    Author     : Ana Carolina Fidelis Gonçalves
                 André Magno
                 Davi de Almeida
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="page-wrapper" >
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Cliente >> NOVO</h2>   
            </div>
        </div>            
        <hr/>
        <form action="FrontController?action=InserirCliente" method="post">
            <div class="row">
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Nome</label>
                        <input type="text" id="textNome" name="textNome" class="form-control" required="" />
                    </div>
                </div>

                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>CPF</label>
                        <input type="text" id="textCPF" name="textCPF" class="form-control" />
                    </div>
                </div>
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Endereço</label>
                        <input type="text" id="textEndereco" name="textEndereco" class="form-control" />
                    </div>
                </div>
            </div>
            <hr/>
            <button class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i> Salvar</button>
        </form>
    </div>
</div>