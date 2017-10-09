package br.com.ufjf.dcc078.DAO;

import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoDisponivel;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoLimpeza;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoManutencao;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoOcupado;
import br.com.ufjf.dcc078.persistencia.DatabaseLocator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuartoDAO {

    private static QuartoDAO instance;

    private QuartoDAO() {

    }

    public static QuartoDAO getInstance() {
        if (instance == null) {
            instance = new QuartoDAO();
        }
        return instance;
    }

    public void gravar(Quarto quarto) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into quarto (descricao,estado,tipo_quarto_id)"
                    + " values ('" + quarto.getDescricao() + "', '" + quarto.getEstado().getNome() + "', '" + quarto.getTipo_quarto_id() + "')");
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
            st = conn.prepareStatement("DELETE FROM quarto WHERE id = ?");
            st.setInt(1, id);
            st.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void alterar(Quarto quarto) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE quarto "
                    + " SET descricao = '" + quarto.getDescricao()+ "', tipo_quarto_id =" + quarto.getTipo_quarto_id() + ", estado = '" + quarto.getEstado().getNome() + "' "
                    + "WHERE id = " + quarto.getId());
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Quarto ler(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT * FROM quarto WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Quarto quarto = new Quarto();
                quarto.setId(rs.getInt("id"));
                quarto.setDescricao(rs.getString("descricao"));
                //tratando os estados do quarto 
                switch (rs.getString("estado")) {
                    case "Ocupado":
                        quarto.setEstado(new QuartoEstadoOcupado());
                        break;
                    case "Manutenção":
                        quarto.setEstado(new QuartoEstadoManutencao());
                        break;
                    case "Limpeza":
                        quarto.setEstado(new QuartoEstadoLimpeza());
                        break;
                    default:
                        quarto.setEstado(new QuartoEstadoDisponivel());
                        break;
                }
                quarto.setTipo_quarto_id(rs.getInt("tipo_quarto_id"));
                return quarto;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return null;
    }

    public List<Quarto> lerTodos() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs;
        ArrayList<Quarto> quartos = new ArrayList();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT * FROM quarto");
            rs = st.executeQuery();

            while (rs.next()) {
                Quarto quarto = new Quarto() {
                    @Override
                    String getTipoQuarto() {
                        
                    }
                };
                quarto.setId(rs.getInt("id"));
                quarto.setDescricao(rs.getString("descricao"));
                switch (rs.getString("estado")) {
                    case "Ocupado":
                        quarto.setEstado(new QuartoEstadoOcupado());
                        break;
                    case "Manutenção":
                        quarto.setEstado(new QuartoEstadoManutencao());
                        break;
                    case "Limpeza":
                        quarto.setEstado(new QuartoEstadoLimpeza());
                        break;
                    default:
                        quarto.setEstado(new QuartoEstadoDisponivel());
                        break;
                }
                quarto.setTipo_quarto_id(rs.getInt("tipo_quarto_id"));
                quartos.add(quarto);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
        return quartos;
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
