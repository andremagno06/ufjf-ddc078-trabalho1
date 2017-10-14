
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<div id="page-wrapper" >
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>PROMOÇÕES</h2>   
            </div>
        </div>            
        
        <%-- MOSTRAR TODOS OS QUARTOS --%>
        <table class="table table-striped table-bordered table-hover">
            <thead>
                <tr>
                    
                    <th>Descrição</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="promocoes" items="${promocoes}">
                    <tr>
                          <td><c:out value="${promocoes}"/></td>
                                 
                    </tr>
                </c:forEach>  
                   
            </tbody>
        </table>
    </div>
</div>
