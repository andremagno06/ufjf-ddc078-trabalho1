package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
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
 * Action para alterar os dados do quarto
 *
 * @author Ana Carolina Fidelis Gonçalves
 */
public class AlterarQuartoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        /*String descricao = request.getParameter("txtDescricao");
        String tipo = request.getParameter("txtTipo");
        String estado = request.getParameter("txtEstado");*/

        if (id.equals("")) {
            response.sendRedirect("index.php"); //Registro não encontrado
        } else {
            try {
                //recuperar o quarto e carregar
                Quarto quarto = QuartoDAO.getInstance().ler(Integer.parseInt(id));
                request.setAttribute("quarto", quarto);
                RequestDispatcher view = request.getRequestDispatcher("alterarQuarto.jsp");
                view.forward(request, response);
            } catch (ClassNotFoundException | SQLException | ServletException ex) {
                response.sendRedirect("MensagemErro.jsp");
            }
        }

    }

}
