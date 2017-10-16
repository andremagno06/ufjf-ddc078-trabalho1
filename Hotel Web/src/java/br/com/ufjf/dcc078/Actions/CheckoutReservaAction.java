package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.ReservaDAO;
import br.com.ufjf.dcc078.Modelo.Reserva;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckoutReservaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");

        if (id.equals("")) {
            response.sendRedirect("MensagemCamposObrigatorios.jsp");
        } else {
            try {
                Reserva reserva = ReservaDAO.getInstance().ler(Integer.parseInt(id));
                request.setAttribute("reserva", reserva);

                RequestDispatcher view = request.getRequestDispatcher("reservaCheckout.jsp");
                view.forward(request, response);

            } catch (ServletException | ClassNotFoundException | SQLException e) {
                response.sendRedirect("MensagemErro.jsp");
            }
        }
    }

}
