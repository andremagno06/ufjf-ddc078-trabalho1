package br.com.ufjf.dcc078.DAO;

import br.com.ufjf.dcc078.Modelo.Pessoa;
import br.com.ufjf.dcc078.Modelo.PessoaCliente;
import br.com.ufjf.dcc078.Modelo.PessoaFuncionario;
import br.com.ufjf.dcc078.persistencia.DatabaseLocator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    public List<PessoaCliente> lerTodosClientes() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs;

        ArrayList<PessoaCliente> clientes = new ArrayList();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT * FROM pessoa WHERE tipo_pessoa='C' ");
            rs = st.executeQuery();

            while (rs.next()) {
                PessoaCliente cliente = new PessoaCliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
        return clientes;
    }

    public List<PessoaFuncionario> lerTodosFuncionarios() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs;

        ArrayList<PessoaFuncionario> funcionarios = new ArrayList();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT * FROM pessoa WHERE tipo_pessoa='F' ");
            rs = st.executeQuery();

            while (rs.next()) {
                PessoaFuncionario funcionario = new PessoaFuncionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setRecebeNotificacao(rs.getString("recebeNotificacao"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
        return funcionarios;

    }

    public void gravar(Pessoa pessoa) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            if (pessoa instanceof PessoaFuncionario) {
                st.execute("insert into pessoa (nome,cpf, endereco, tipo_pessoa, email, recebeNotificacao)"
                        + " values ('" + pessoa.getNome() + "', '" + pessoa.getCpf() + "', '"
                        + pessoa.getEndereco() + "', '" + pessoa.getTipo() + "','"
                        + pessoa.getEmail() + "','" + pessoa.getRecebeNotificacao() + "')");
            } else {
                st.execute("insert into pessoa (nome,cpf, endereco, tipo_pessoa, email)"
                        + " values ('" + pessoa.getNome() + "', '" + pessoa.getCpf() + "', '"
                        + pessoa.getEndereco() + "', '" + pessoa.getTipo() + "','"
                        + pessoa.getEmail() + "')");
            }

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

    public Pessoa ler(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs;
        Pessoa pessoa = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT * FROM pessoa WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                if (rs.getString("tipo_pessoa").equals("F")) {
                    pessoa = new PessoaFuncionario(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("endereco"), rs.getString("email"));
                    pessoa.setRecebeNotificacao(rs.getString("recebeNotificacao"));
                } else {
                    pessoa = new PessoaCliente(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("endereco"));
                }
            }
            return pessoa;
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
