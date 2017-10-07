package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApagarQuartoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");

        if (id.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                QuartoDAO.getInstance().excluir(Integer.parseInt(id));
                request.setAttribute("id", id);
                RequestDispatcher view = request.getRequestDispatcher("MensagemExcluirRegistro.jsp");
                view.forward(request, response);
                response.sendRedirect("MensagemSucesso.jsp");
            } catch (SQLException | ClassNotFoundException | ServletException e) {
                response.sendRedirect("MensagemErro.jsp");
            }
        }
    }

}
