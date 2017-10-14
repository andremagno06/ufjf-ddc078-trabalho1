/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.PessoaDAO;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.Modelo.Pessoa;
import br.com.ufjf.dcc078.Modelo.PessoaFuncionario;
import br.com.ufjf.dcc078.Modelo.Quarto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Desenvolvedor
 */
public class InserirFuncionarioAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("textNome");
        String cpf = request.getParameter("textCPF");
        String endereco = request.getParameter("textEndereco");
        String email = request.getParameter("textEmail");
        String idQuarto = request.getParameter("txtQuarto");

        if (nome.equals("") || cpf.equals("")) {
            response.sendRedirect("Index.jsp");   //???????????
        } else {
        
     
            try {
                
                Quarto quarto = QuartoDAO.getInstance().ler(Integer.parseInt(idQuarto));
      
                
                Pessoa pessoa;
                pessoa= new PessoaFuncionario(nome,cpf,endereco,"F",email,quarto);
                PessoaDAO.getInstance().gravar(pessoa);
          
              
               
              
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(InserirFuncionarioAction.class.getName()).log(Level.SEVERE, null, ex);
            }
                response.sendRedirect("MensagemSucesso.jsp");
          
               

        }
    }

}
