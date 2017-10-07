/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.dcc078.DAO;

import br.com.ufjf.dcc078.Modelo.Reserva;
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
            st.execute("insert into reserva (pessoa_id,quarto_id, data_checkin, data_checkout, data_reserva)"
                    + " values ('" + reserva.getPessoa_id() + "', '" + reserva.getQuarto_id() + "', '"
                    + reserva.getData_checkin() + "', '" + reserva.getData_checkout() + "','"
                    + reserva.getData_reserva() + "')");
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
        List<Reserva> reservas = new VirtualFlow.ArrayLinkedList<>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT * FROM reserva");
            rs = st.executeQuery();

            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("id"));
                reserva.setPessoa_id(rs.getInt("id_pessoa"));
                reserva.setQuarto_id(rs.getInt("id_quarto"));
                reserva.setData_checkin(rs.getDate("data_checkin"));
                reserva.setData_checkout(rs.getDate("data_checkout"));
                reserva.setData_reserva(rs.getDate("data_reserva"));
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
        return reservas;
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
