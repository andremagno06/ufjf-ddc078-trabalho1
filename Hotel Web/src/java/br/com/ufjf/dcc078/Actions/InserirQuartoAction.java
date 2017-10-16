package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.Modelo.QuartoCasal;
import br.com.ufjf.dcc078.Modelo.QuartoDuplo;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoDisponivel;
import br.com.ufjf.dcc078.Modelo.QuartoFamilia;
import br.com.ufjf.dcc078.Modelo.QuartoSolteiro;
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

            Quarto quarto = null;

            switch (Integer.parseInt(tipo)) {
                case 1:
                    quarto = new QuartoCasal(descricao, new QuartoEstadoDisponivel(), Integer.parseInt(tipo));
                    break;
                case 2:
                    quarto = new QuartoSolteiro(descricao, new QuartoEstadoDisponivel(), Integer.parseInt(tipo));
                    break;
                case 3:
                    quarto = new QuartoDuplo(descricao, new QuartoEstadoDisponivel(), Integer.parseInt(tipo));
                    break;
                case 4:
                    quarto = new QuartoFamilia(descricao, new QuartoEstadoDisponivel(), Integer.parseInt(tipo));
                    break;
            }
            try {
                QuartoDAO.getInstance().gravar(quarto);
                response.sendRedirect("MensagemSucesso.jsp");
            } catch (ClassNotFoundException | SQLException ex) {
                response.sendRedirect("MensagemErro.jsp");
            }

        }
    }

}
