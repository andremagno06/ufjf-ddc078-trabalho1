package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.Modelo.Quarto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FuncionarioExibirInserirAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            List<Quarto> quartos = QuartoDAO.getInstance().lerTodos();
            request.setAttribute("quartos", quartos);

            RequestDispatcher view = request.getRequestDispatcher("novoFuncionario.jsp");
            view.forward(request, response);

        } catch (ServletException | ClassNotFoundException | SQLException e) {
            response.sendRedirect("MensagemErro.jsp");
        }

    }

}
