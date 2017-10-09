package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.ReservaDAO;
import br.com.ufjf.dcc078.Modelo.Reserva;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Exibe todos os quartos cadastrados
 *
 * @author Ana Carolina Fidelis Gonçalves
 */
public class ExibirReservasAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
       try {
            List<Reserva> reservas = ReservaDAO.getInstance().lerTodos();
            request.setAttribute("reservas", reservas);
            RequestDispatcher view = request.getRequestDispatcher("listaReservas.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException | SQLException | ServletException ex) {
            response.sendRedirect("MensagemErro.jsp");
        }
    }

}
