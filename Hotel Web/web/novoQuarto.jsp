<%-- 
    Document   : Formulário de quartos
    Created on : 04/10/2017, 15:17:24
    Author     : Ana Carolina Fidelis Gonçalves
                 André Magno
                 Davi de Almeida
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="page-wrapper" >
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>QUARTOS >> NOVO</h2>   
            </div>
        </div>            
        <hr/>
        <form action="FrontController?action=InserirQuarto" method="post" onsubmit="return novoQuarto();">
            <div class="row">
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Descrição</label>
                        <input type="text" id="txtDescricao" name="textDescricao" class="form-control" />
                    </div>
                </div>
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Tipo de Quarto</label>
                        <select id="txtTipo" name="textTipo" class="form-control">
                            <option value="">Selecionar</option>
                            <option value="1">Casal</option>
                            <option value="2">Solteiro</option>
                            <option value="3">Dulpo</option>
                            <option value="4">Família</option>
                        </select>

                    </div>
                </div>
            </div>
            <hr/>
            <button class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i> Salvar</button>
            <a href="FrontController?action=ExibirQuartos" class="btn btn-primary"><i class="fa fa-table" aria-hidden="true"></i> Voltar para listagem</a>
        </form>
    </div>
</div>