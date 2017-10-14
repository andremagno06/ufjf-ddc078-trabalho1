package br.com.ufjf.dcc078.DAO;

import br.com.ufjf.dcc078.Modelo.PessoaCliente;
import br.com.ufjf.dcc078.Modelo.Reserva;
import br.com.ufjf.dcc078.persistencia.DatabaseLocator;
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
public class ReservaDAO {

    private static ReservaDAO instance;

    private ReservaDAO() {

    }

    public static ReservaDAO getInstance() {
        if (instance == null) {
            instance = new ReservaDAO();
        }
        return instance;
    }

    public void gravar(Reserva reserva) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "INSERT INTO reserva (pessoa_id,quarto_id, data_reserva)"
                    + " VALUES (" + reserva.getCliente().getId() + ", " + reserva.getQuarto().getId() + ", '" + reserva.getData_reserva() + "')";
            st.execute(sql);
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
            st = conn.prepareStatement("DELETE FROM reserva WHERE id = ?");
            st.setInt(1, id);
            st.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public List<Reserva> lerTodos() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs;
        ArrayList<Reserva> reservas = new ArrayList();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT * FROM reserva");
            rs = st.executeQuery();

            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("id"));
                PessoaCliente cliente = (PessoaCliente) PessoaDAO.getInstance().ler(rs.getInt("pessoa_id"));
                reserva.setCliente(cliente);
                reserva.setQuarto(QuartoDAO.getInstance().ler(rs.getInt("quarto_id")));
                reserva.setData_checkin(rs.getString("data_checkin"));
                reserva.setData_checkout(rs.getString("data_checkout"));
                reserva.setData_reserva(rs.getString("data_reserva"));
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return reservas;
    }

    public void gravarCheckin(Reserva reserva) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE reserva "
                    + " SET data_checkin = '" + reserva.getData_checkin() + "' "
                    + "WHERE id = " + reserva.getId());
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

    public Reserva ler(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs;
        Reserva reserva = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT * FROM reserva WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                reserva = new Reserva();
                reserva.setId(rs.getInt("id"));
                PessoaCliente cliente = (PessoaCliente) PessoaDAO.getInstance().ler(rs.getInt("pessoa_id"));
                reserva.setCliente(cliente);
                reserva.setQuarto(QuartoDAO.getInstance().ler(rs.getInt("quarto_id")));
                reserva.setData_checkin(rs.getString("data_checkin"));
                reserva.setData_checkout(rs.getString("data_checkout"));
                reserva.setData_reserva(rs.getString("data_reserva"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return reserva;
    }
}
