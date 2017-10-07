package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.Modelo.Quarto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Exibe todos os quartos cadastrados
 *
 * @author Ana Carolina Fidelis Gonçalves
 */
public class ExibirQuartosAction implements Action {
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Quarto> quartos = QuartoDAO.getInstance().lerTodos();
            request.setAttribute("quartos", quartos);
            RequestDispatcher view = request.getRequestDispatcher("listaQuartos.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            response.sendRedirect("MensagemErro.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(ExibirQuartosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
