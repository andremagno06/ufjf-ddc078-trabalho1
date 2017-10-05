/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.dcc078.Action;

import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.Modelo.Quarto;
import java.io.IOException;
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
            Quarto contato = new Quarto(descricao,"disponivel", Integer.parseInt(tipo));
            QuartoDAO.getInstance().save(contato);
            response.sendRedirect("quartoSalvoSucesso.jsp");
        }
    }

}
