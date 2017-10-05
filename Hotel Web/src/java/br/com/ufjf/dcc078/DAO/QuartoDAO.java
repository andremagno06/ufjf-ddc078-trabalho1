/*
 * To change this license header, choose License Headers in Project Properties.
 * To  change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.dcc078.DAO;

import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.persistencia.DatabaseLocator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Desenvolvedor
 */
public class QuartoDAO {
    
    private static QuartoDAO instance;
    


    public static QuartoDAO getInstance() {
        return instance;
    }

    public static void setInstance(QuartoDAO instance) {
        QuartoDAO.instance = instance;
    }

    public void gravar(Quarto quarto) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into quarto (descricao, estado, tipo_quarto_id)" +
                    " values ('" + quarto.getDescricao() + "', '" + quarto.getEstado() + "','" + quarto.getDescricao() + "')");
        } catch(SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
   
    
    public void excluir(int id) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("DELETE FROM quarto WHERE id = ?");
            st.setInt(1, id);
            st.execute();
        } catch(SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public Quarto ler(int id) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT * FROM quarto WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            
            if(rs.next()){
                return new Quarto(
                            rs.getString("descricao"), 
                            rs.getString("estado"), 
                            rs.getInt("tipo_quarto_id")
                       );
            }
        } catch(SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return null;
    }

    private void closeResources(Connection conn, Statement st) {
        try {
            if(st!=null) st.close();
            if(conn!=null) conn.close();

        } catch(SQLException e) {

        }
    }
    

    
    
    
    
}