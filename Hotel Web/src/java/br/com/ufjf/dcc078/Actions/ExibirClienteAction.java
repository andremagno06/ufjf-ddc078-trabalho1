package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.PessoaDAO;
import br.com.ufjf.dcc078.Modelo.PessoaCliente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Exibe todos os quartos cadastrados
 *
 * @author Ana Carolina Fidelis Gonçalves
 */
public class ExibirClienteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<PessoaCliente> pessoas = PessoaDAO.getInstance().lerTodosClientes();
            request.setAttribute("pessoas", pessoas);
            RequestDispatcher view = request.getRequestDispatcher("listaClientes.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ExibirClienteAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            response.sendRedirect("MensagemErro.jsp");

        }
    }

}
