/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.dcc078.Action;



import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.Modelo.Quarto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Desenvolvedor
 */
public class InserirQuartoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("textNome");
        String email = request.getParameter("textEmail");

        if (nome.equals("") || email.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                Quarto contato = new Quarto(44,"quarto 5","disponivel",1);
                QuartoDAO.getInstance().save(contato);
                response.sendRedirect("QuartoSalvoSucesso.jsp");
            } catch (SQLException ex) {
                response.sendRedirect("ErroQuartonãoSalvo.jsp");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InserirQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
