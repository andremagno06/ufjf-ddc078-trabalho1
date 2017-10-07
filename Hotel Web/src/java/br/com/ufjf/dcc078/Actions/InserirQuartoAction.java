package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoDisponivel;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Desenvolvedor
 */
public class InserirQuartoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String descricao = request.getParameter("textDescricao");
        String tipo = request.getParameter("textTipo");

        if (descricao.equals("") || tipo.equals("")) {
            response.sendRedirect("index.jsp");
        } else {

            Quarto quarto = new Quarto(descricao, new QuartoEstadoDisponivel(), Integer.parseInt(tipo));
            try {
                QuartoDAO.getInstance().gravar(quarto);
                response.sendRedirect("MensagemSucesso.jsp");
            } catch (ClassNotFoundException | SQLException ex) {
                response.sendRedirect("MensagemErro.jsp");
            }

        }
    }

}
