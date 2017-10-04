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

        <form>
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="form-group">
                        <label>Descrição</label>
                        <input class="form-control" name="descricao"/>
                    </div>
                </div>
            </div>
            <hr/>
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <button type="submit" class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i> Salvar</button>
                </div>
            </div>
        </form>
    </div>
</div>