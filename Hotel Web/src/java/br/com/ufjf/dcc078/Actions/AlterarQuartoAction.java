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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
            response.sendRedirect("MensagemCamposObrigatorios.jsp");
        } else {
            try {
                Quarto quarto;

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
                    default:
                        quarto = new QuartoCasal(descricao, new QuartoEstadoDisponivel(), Integer.parseInt(tipo));
                        break;
                }
                quarto.setDescricao(descricao);
                switch (estado) {
                    case "O":
                        quarto.getEstado().ocupar(quarto);
                        break;
                    case "M":
                        quarto.getEstado().manutencao(quarto);
                        break;
                    case "L":
                        quarto.getEstado().limpar(quarto);
                        break;
                    case "R":
                        quarto.getEstado().reservar(quarto);
                    default:
                        quarto.getEstado().disponibilizar(quarto);
                        break;
                }

                QuartoDAO.getInstance().alterar(quarto);
                response.sendRedirect("MensagemSucesso.jsp");
            } catch (ClassNotFoundException | SQLException ex) {
                response.sendRedirect("MensagemErro.jsp");
            } catch (UnsupportedOperationException e) {
                try {
                    request.setAttribute("mensagem", e.getMessage());
                    RequestDispatcher view = request.getRequestDispatcher("MensagemErroEstadoQuarto.jsp");
                    view.forward(request, response);
                } catch (ServletException ex) {
                    response.sendRedirect("MensagemErro.jsp");
                }
            }

        }

    }

}
