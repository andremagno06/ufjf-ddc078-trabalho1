/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.dcc078.DAO;

import br.com.ufjf.dcc078.Modelo.Pessoa;
import br.com.ufjf.dcc078.persistencia.DatabaseLocator;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Desenvolvedor
 */
public class PessoaDAO {
    
    private static PessoaDAO instance;
    
    public static PessoaDAO getInstance() {
        if (instance == null) {
            instance = new PessoaDAO();
        }
        return instance;
    }
    
    public PessoaDAO() {
        
    }
    
    //padrão facade
    public List<Pessoa> lerTodosClientes() throws ClassNotFoundException, SQLException{
    PessoaClienteDAO p = new  PessoaClienteDAO();
    return p.lerTodosClientes();
    }
    
      public List<Pessoa> lerTodosFuncionarios() throws ClassNotFoundException, SQLException{
    PessoaFuncionarioDAO p = new  PessoaFuncionarioDAO();
    return p.lerTodosClientes();
    }
    
  
    
    public void gravar(Pessoa pessoa) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into pessoa (nome,cpf, endereco, tipo_pessoa, email)"
                    + " values ('" + pessoa.getNome() + "', '" + pessoa.getCpf() + "', '"
                    + pessoa.getEndereco() + "', '" + pessoa.getTipo_pessoa() + "','"
                    + pessoa.getEmail() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public void excluir(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("DELETE FROM pessoa WHERE id = ?");
            st.setInt(1, id);
            st.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    

    
    private void closeResources(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
            
        } catch (SQLException e) {
            
        }
    }
}
