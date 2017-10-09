package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoDisponivel;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoLimpeza;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoManutencao;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoOcupado;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action para alterar os dados do quarto
 *
 * @author Ana Carolina Fidelis Gonçalves
 */
public class AlterarQuartoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("txtId");
        String descricao = request.getParameter("txtDescricao");
        String tipo = request.getParameter("txtTipo");
        String estado = request.getParameter("txtEstado");

        if (id.equals("")) {
            response.sendRedirect("index.php"); //Registro não encontrado
        } else {
            try {
                Quarto quarto = new Quarto();
                quarto.setId(Integer.parseInt(id));
                quarto.setDescricao(descricao);
                quarto.setTipo_quarto_id(Integer.parseInt(tipo));
                switch (estado) {
                    case "O":
                        quarto.setEstado(new QuartoEstadoOcupado());
                        break;
                    case "M":
                        quarto.setEstado(new QuartoEstadoManutencao());
                        break;
                    case "L":
                        quarto.setEstado(new QuartoEstadoLimpeza());
                        break;
                    default:
                        quarto.setEstado(new QuartoEstadoDisponivel());
                        break;
                }

                QuartoDAO.getInstance().alterar(quarto);
                response.sendRedirect("MensagemSucesso.jsp");
            } catch (ClassNotFoundException | SQLException ex) {
                response.sendRedirect("MensagemErro.jsp");
            }

        }

    }

}
