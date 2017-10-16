package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.PessoaDAO;
import br.com.ufjf.dcc078.Modelo.PessoaCliente;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InserirClienteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("textNome");
        String cpf = request.getParameter("textCPF");
        String endereco = request.getParameter("textEndereco");

        if (nome.equals("")) {
            response.sendRedirect("MensagemCamposObrigatorios.jsp");
        } else {
            PessoaCliente pessoa = new PessoaCliente(nome, cpf, endereco);
            try {
                PessoaDAO.getInstance().gravar(pessoa);
                response.sendRedirect("MensagemSucesso.jsp");
            } catch (ClassNotFoundException | SQLException ex) {
                response.sendRedirect("MensagemErro.jsp");
            }
        }
    }

}
