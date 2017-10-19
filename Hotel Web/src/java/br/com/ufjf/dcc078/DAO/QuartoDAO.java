package br.com.ufjf.dcc078.DAO;

import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.Modelo.QuartoCasal;
import br.com.ufjf.dcc078.Modelo.QuartoDuplo;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoDisponivel;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoLimpeza;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoManutencao;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoOcupado;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoReservado;
import br.com.ufjf.dcc078.Modelo.QuartoFamilia;
import br.com.ufjf.dcc078.Modelo.QuartoSolteiro;
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
                    + " values ('" + quarto.getDescricao() + "', '" + quarto.getEstado().getSigla() + "', '" + quarto.getTipo_quarto_id() + "')");
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

            String x = "UPDATE `quarto` SET `descricao` = '" + quarto.getDescricao() + "', `estado` = '" + quarto.getEstado().getSigla() + "', `tipo_quarto_id` = '" + quarto.getTipo_quarto_id() + "' WHERE `quarto`.`id` = " + quarto.getId();
            st.execute(x);

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
        Quarto quarto = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT * FROM quarto WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {

                switch (rs.getInt("tipo_quarto_id")) {
                    case 1:
                        quarto = new QuartoCasal();
                        break;
                    case 2:
                        quarto = new QuartoSolteiro();
                        break;
                    case 3:
                        quarto = new QuartoDuplo();
                        break;
                    case 4:
                        quarto = new QuartoFamilia();
                        break;
                }
                quarto.setId(rs.getInt("id"));
                quarto.setDescricao(rs.getString("descricao"));
                //tratando os estados do quarto 
                switch (rs.getString("estado")) {
                    case "O":
                        quarto.setEstado(new QuartoEstadoOcupado());
                        break;
                    case "M":
                        quarto.setEstado(new QuartoEstadoManutencao());
                        break;
                    case "L":
                        quarto.setEstado(new QuartoEstadoLimpeza());
                        break;
                    case "R":
                        quarto.setEstado(new QuartoEstadoReservado());
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
        Quarto quarto = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT * FROM quarto");
            rs = st.executeQuery();

            while (rs.next()) {

                switch (rs.getInt("tipo_quarto_id")) {
                    case 1:
                        quarto = new QuartoCasal();
                        break;
                    case 2:
                        quarto = new QuartoSolteiro();
                        break;
                    case 3:
                        quarto = new QuartoDuplo();
                        break;
                    case 4:
                        quarto = new QuartoFamilia();
                        break;
                }
                quarto.setId(rs.getInt("id"));
                quarto.setDescricao(rs.getString("descricao"));
                switch (rs.getString("estado")) {
                    case "O":
                        quarto.setEstado(new QuartoEstadoOcupado());
                        break;
                    case "M":
                        quarto.setEstado(new QuartoEstadoManutencao());
                        break;
                    case "L":
                        quarto.setEstado(new QuartoEstadoLimpeza());
                        break;
                    case "R":
                        quarto.setEstado(new QuartoEstadoReservado());
                        break;
                    default:
                        quarto.setEstado(new QuartoEstadoDisponivel());
                        break;
                }
                quarto.setTipo_quarto_id(rs.getInt("tipo_quarto_id"));
                quarto.setTipoQuarto(quarto.tipoQuarto());
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
