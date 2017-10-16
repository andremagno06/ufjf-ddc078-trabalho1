package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.PessoaDAO;
import br.com.ufjf.dcc078.Modelo.PessoaFuncionario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InserirFuncionarioAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("textNome");
        String cpf = request.getParameter("textCPF");
        String endereco = request.getParameter("textEndereco");
       
        String notificacao = null;
        if (request.getParameter("txtNotificacao") != null) {
            notificacao = "S";
        } else {
            notificacao = "N";
        }
        String email = "";
        if (notificacao.equals("S")) {
            email = request.getParameter("textEmail");
        }

        if (nome.equals("")) {
            response.sendRedirect("MensagemCamposObrigatorios.jsp");
        } else {

            try {
                //Quarto quarto = QuartoDAO.getInstance().ler(Integer.parseInt(idQuarto));

                PessoaFuncionario pessoa = new PessoaFuncionario(nome, cpf, endereco, email);
                if (notificacao.equals("S")) {
                    pessoa.setRecebeNotificacao("S");
                } else {
                    pessoa.setRecebeNotificacao("N");
                }

                //quarto.addEnvolvido((Observer) pessoa);
                PessoaDAO.getInstance().gravar(pessoa);

                response.sendRedirect("MensagemSucesso.jsp");

            } catch (ClassNotFoundException | SQLException ex) {
                response.sendRedirect("MensagemErro.jsp");
            }

        }
    }

}
