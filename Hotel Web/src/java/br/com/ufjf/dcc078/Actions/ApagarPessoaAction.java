/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.dcc078.Actions;


import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 07228620674
 */
public class ApagarPessoaAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("textID");
        
        if(id.equals("")){
            response.sendRedirect("index.jsp");
        }
        else{
            try{
                
                PessoaDAO.getInstance().excluir(Integer.parseInt(id));
                
                request.setAttribute("nome", id);
                
                RequestDispatcher view = request.getRequestDispatcher("PessoaExcluir.jsp");//<<<<<modificar>>>>>
                view.forward(request, response);
                 response.sendRedirect("MensagemSucesso.jsp");
            } catch(SQLException e){
                response.sendRedirect("MensagemErro.jsp");
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InserirQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("MensagemErro.jsp");
            } catch (ServletException ex) {
                Logger.getLogger(LerQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("MensagemErro.jsp");
            }
        }
    }
    
}
