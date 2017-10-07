/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.dcc078.Actions;



import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.PessoaDAO;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.Modelo.Pessoa;
import br.com.ufjf.dcc078.Modelo.Quarto;
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
public class LerPessoaAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String codigo = request.getParameter("codigo");
        
        if(codigo.equals("")){
            response.sendRedirect("index.jsp");
        }
        else{
            try{
                int codInt = Integer.parseInt(codigo);
                PessoaDAO pd= new PessoaDAO();
                
                request.setAttribute("ListaPessoa", pd.lerTodos());//retorna uma lista, deve ser implementado no cliente
                
                RequestDispatcher view = request.getRequestDispatcher("listaCliente.jsp");
                view.forward(request, response);
                response.sendRedirect("MensagemSucesso.jsp");
                
            } catch (ServletException ex) {
                Logger.getLogger(LerPessoaAction.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("MensagemErro.jsp");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LerPessoaAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(LerPessoaAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
