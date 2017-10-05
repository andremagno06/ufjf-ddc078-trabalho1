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
        String descricao = request.getParameter("textNome");
        String tipo = request.getParameter("textTipo");
        
        if (descricao.equals("") || tipo.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            Quarto quarto = new Quarto(descricao,"disponivel", Integer.parseInt(tipo));
            try {
                QuartoDAO.getInstance().gravar(quarto);
                response.sendRedirect("quartoSalvoSucesso.jsp");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InserirQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("quartoErro.jsp");
            } catch (SQLException ex) {
                Logger.getLogger(InserirQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("quartoErro.jsp");
            }
            response.sendRedirect("quartoErro.jsp");
            
        }
    }

}
