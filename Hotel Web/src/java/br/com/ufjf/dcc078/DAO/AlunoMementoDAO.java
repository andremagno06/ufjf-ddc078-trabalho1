/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.dcc078.DAO;

import br.com.ufjf.dcc078.Modelo.Pessoa;
import br.com.ufjf.dcc078.Modelo.PessoaFuncionario;
import br.com.ufjf.dcc078.Modelo.QuartoMemento;
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
public class AlunoMementoDAO {
     private static AlunoMementoDAO instance;

    public static AlunoMementoDAO getInstance() {
        if (instance == null) {
            instance = new AlunoMementoDAO();
        }
        return instance;
    }

    public AlunoMementoDAO() {

    }

    
      public void gravar(QuartoMemento quarto) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            if (quarto instanceof QuartoMemento) {
                st.execute("insert into memento (estado)"
                        + " values ('" + quarto.getEstadoSalvo().getNome() + "'");
            }
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


public List<QuartoMemento> lerTodosQuartoMemento() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs;

        ArrayList<QuartoMemento> quartos = new ArrayList();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT * FROM memento ");
            rs = st.executeQuery();

            while (rs.next()) {
                QuartoMemento quarto = new QuartoMemento();
                quarto.getEstadoSalvo(rs.getString("estado"));
                quartos.add(quarto );
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);

        }
        return funcionarios;

    }

}