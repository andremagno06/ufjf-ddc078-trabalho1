<%-- 
    Document   : Lista de Quartos cadastrados
    Created on : 04/10/2017, 15:14:22
    Author     : Ana Carolina
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="page-wrapper" >
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>QUARTOS</h2>   
                <table border = '1'> 
                    <a href="FrontController?action=LerQuarto&codigo=1">
                     Ler o primeiro contato
                    </a>
                    
                    
                    <thead>
                        <tr>
                            <th>descrição</th>
                            <th>Estado</th>
                            <th>Tipo</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${descricao}</td>
                            <td>${estado}</td>
                            <td>${tipo}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>            
        <hr/>

        <%--MOSTRAR TODOS OS QUARTOS EXISTENTES--%>

    </div>
</div>
