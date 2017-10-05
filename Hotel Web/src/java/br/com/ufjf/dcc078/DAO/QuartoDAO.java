/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author 07228620674
 */
public class QuartoDAO {
   
    private static QuartoDAO instance;
    
    private QuartoDAO(){
        
    }
    
    public static QuartoDAO getInstance(){
        if(instance == null)
            instance = new QuartoDAO();
        return instance;
    }
    
    public void gravar(Quarto quarto) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            st.execute("insert into quarto (descricao, estado, tipo_quarto_id)" +
                    " values ('" + quarto.getDescricao() + "', '" + quarto.getEstado() +"'"+ quarto.getTipo_quarto_id()+"')");
        } catch(SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
   
    
    public void excluir(String nome) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("DELETE FROM quarto WHERE codigo = ?");
            st.setString(1, nome);
            st.execute();
        } catch(SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public Quarto ler(int codigo) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT * FROM quarto WHERE codigo = ?");
            st.setInt(1, codigo);
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
