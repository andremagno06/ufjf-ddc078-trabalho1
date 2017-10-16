package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.Modelo.Quarto;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LerQuartoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");

        if (id.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                Quarto quarto = QuartoDAO.getInstance().ler(Integer.parseInt(id));
                request.setAttribute("quarto", quarto);

                RequestDispatcher view = request.getRequestDispatcher("alterarQuarto.jsp");
                view.forward(request, response);

            } catch (SQLException | ClassNotFoundException | ServletException e) {
                response.sendRedirect("MensagemErro.jsp");
            }
        }
    }

}
