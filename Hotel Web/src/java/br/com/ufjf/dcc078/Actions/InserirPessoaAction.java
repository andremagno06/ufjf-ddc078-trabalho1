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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Desenvolvedor
 */
public class InserirPessoaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String descricao = request.getParameter("textDescricao");
        String tipo = request.getParameter("textTipo");

        if (descricao.equals("") || tipo.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
        
                Pessoa pessoa = new Pessoa(descricao, "disponivel", Integer.parseInt(tipo));
            try {
                PessoaDAO.getInstance().gravar(pessoa);
              
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InserirPessoaAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(InserirPessoaAction.class.getName()).log(Level.SEVERE, null, ex);
            }
                response.sendRedirect("MensagemSucesso.jsp");
          
               

        }
    }

}