package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.PessoaDAO;
import br.com.ufjf.dcc078.Modelo.Pessoa;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Desenvolvedor
 */
public class InserirClienteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("textNome");
        String cpf = request.getParameter("textCPF");
        String endereco = request.getParameter("textEndereco");
        String email = request.getParameter("textEmail");

        if (nome.equals("") || cpf.equals("")) {
            response.sendRedirect("index.jsp");  //????????
        } else {

            Pessoa pessoa = new Pessoa(nome, cpf, endereco, "C", email);

            try {
                PessoaDAO.getInstance().gravar(pessoa);
                response.sendRedirect("MensagemSucesso.jsp");
            } catch (ClassNotFoundException | SQLException ex) {
                response.sendRedirect("MensagemErro.jsp");
            }
        }
    }

}
