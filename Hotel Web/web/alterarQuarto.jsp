<%-- 
    Document   : Formulário de quartos
    Created on : 04/10/2017, 15:17:24
    Author     : Ana Carolina Fidelis Gonçalves
                 André Magno
                 Davi de Almeida
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="page-wrapper" >
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>QUARTOS >> ALTERAR >> Nº ${quarto.id}</h2>   
            </div>
        </div>            
        <hr/>
        <form action="FrontController?action=AlterarQuarto" method="post" onsubmit="return alterarQuarto();">
            <input type="hidden" name="txtId" value="${quarto.id}"/>
            <div class="row">
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Descrição</label>
                        <input type="text" id="txtDescricao" name="txtDescricao" class="form-control" value="${quarto.descricao}" />
                    </div>
                </div>
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Tipo de Quarto</label>
                        <select id="txtTipo" name="txtTipo" class="form-control">
                            <option value="">Selecionar</option>
                            <option ${quarto.tipo_quarto_id == 1 ? "selected" :""} value="1">Casal</option>
                            <option ${quarto.tipo_quarto_id == 2 ? "selected" :""} value="2">Solteiro</option>
                            <option ${quarto.tipo_quarto_id == 3 ? "selected" :""} value="3">Dulpo</option>
                            <option ${quarto.tipo_quarto_id == 4 ? "selected" :""} value="4">Família</option>
                        </select>

                    </div>
                </div>
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Estado</label>
                        <select  id="txtEstado" name="txtEstado" class="form-control">
                            <option value="">Selecionar</option>
                            <option ${quarto.estado.sigla == "D" ? "selected" :""} value="D">Disponível</option>
                            <option ${quarto.estado.sigla == "O" ? "selected" :""} value="O">Ocupado</option>
                            <option ${quarto.estado.sigla == "L" ? "selected" :""} value="L">Limpeza</option>
                            <option ${quarto.estado.sigla == "M" ? "selected" :""} value="M">Manutenção</option>
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