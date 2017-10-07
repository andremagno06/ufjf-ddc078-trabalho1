<%-- 
    Document   : Formulário para criação de uma nova reserva no hotel
    Created on : 04/10/2017, 15:36:21
    Author     : Ana Carolina Fidelis Gonçalves
                 André Magno
                 Davi de Almeida
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="page-wrapper" >
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>RESERVAS >> NOVA</h2>   
            </div>
        </div>            
        <hr/>
          <form action="FrontController?action=InserirReserva" method="post">
            <div class="row">
                
                
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Quarto</label>
                        <select name="textPessoa" class="form-control">  <!-- //tem que pegar do banco de dados todas as pessoas e colocar neste combobox-->
<!--                            <option value="">Selecionar</option>
                            <option value="1">Casal</option>
                            <option value="2">Solteiro</option>
                            <option value="3">Dulpo</option>
                            <option value="4">Família</option>-->
                        </select>

                    </div>
                </div>
                
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Quarto</label>
                        <select name="textQuarto" class="form-control">  <!-- //tem que pegar do banco de dados todas as quarto e colocar neste combobox-->
<!--                            <option value="">Selecionar</option>
                            <option value="1">Casal</option>
                            <option value="2">Solteiro</option>
                            <option value="3">Dulpo</option>
                            <option value="4">Família</option>-->
                        </select>

                    </div>
                </div>
                
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Data de Checkin</label>
                        <input type="text" name="textDataCheckin" class="form-control" />
                    </div>
                </div>
                
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Data de Checkout</label>
                        <input type="text" name="textDataCheckout" class="form-control" />
                    </div>
                </div>
                
                <div class="col-lg-4 col-md-4">
                    <div class="form-group">
                        <label>Data da Reserva</label>
                        <input type="text" name="textDataReserva" class="form-control" />
                    </div>
                </div>
           
                
            </div>
            <hr/>
            <button class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i> Salvar</button>
        </form>

        <%--FORMULÁRIO PARA INCLUIR NOVA RESERVA--%>

    </div>
</div>
