/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.dcc078.DAO;

import br.com.ufjf.dcc078.Modelo.Pessoa;
import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.persistencia.DatabaseLocator;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desenvolvedor
 */
public class PessoaClienteDAO {
    
  
    public List<Pessoa> lerTodosClientes() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs;
        
        ArrayList<Pessoa> pessoas = new ArrayList();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT * FROM pessoa WHERE tipo_pessoa='C' ");
            rs = st.executeQuery();
            
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setEndereco(rs.getString("endereco"));
               System.out.println(rs.getString("tipo_pessoa").charAt(0));
                pessoa.setTipo_pessoa(rs.getString("tipo_pessoa"));
                pessoa.setEmail(rs.getString("email"));
                pessoas.add(pessoa);
            }
          
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
            
        }
        return pessoas;
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
