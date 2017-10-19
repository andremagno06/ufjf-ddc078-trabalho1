/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.dcc078.DAO;

import br.com.ufjf.dcc078.Modelo.HistoricoMemento;
import br.com.ufjf.dcc078.Modelo.Pessoa;
import br.com.ufjf.dcc078.Modelo.PessoaFuncionario;
import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.Modelo.QuartoMemento;
import br.com.ufjf.dcc078.persistencia.DatabaseLocator;
import static br.com.ufjf.dcc078.persistencia.DatabaseLocator.instance;
import com.sun.xml.xsom.impl.scd.Iterators;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Desenvolvedor
 */
public class HistoricoMementoDAO {

    private static HistoricoMementoDAO instance;
    private static ArrayList<HistoricoMemento> historicos = new ArrayList<>();

    public static HistoricoMementoDAO getInstance() {
        if (instance == null) {
            instance = new HistoricoMementoDAO();
        }
        return instance;
    }

    public HistoricoMementoDAO() {
    }

    //dado um quarto e um estado esta função adiciona o estado em  quarto
    /**
     *
     * @param quarto
     * @param quarto
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void gravar(Quarto quarto, QuartoMemento estado, int i) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        conn = DatabaseLocator.getInstance().getConnection();
        st = conn.createStatement();

        st.execute("insert into historico_memento (quarto,estado,ordem)"
                + " values ('" + quarto.getId() + "', '" + estado.getEstadoSalvo().getNome() + "', '"
                + String.valueOf(i) + "')");
    }

    public void addMemento(Quarto quarto, QuartoMemento estado) throws ClassNotFoundException, SQLException {
        if (historicos == null) {
            HistoricoMemento historicoMemento = new HistoricoMemento();
            historicoMemento.setQuarto(quarto);
            ArrayList<QuartoMemento> quartoMemento = new ArrayList<>();
            quartoMemento.add(estado);
            historicoMemento.setQuartoMemento(quartoMemento);

            historicos.add(historicoMemento);
        } else {
            for (int i = 0; i < historicos.size(); i++) {
                if (historicos.get(i).getQuarto().equals(quarto)) {
                    historicos.get(i).getQuartoMemento().add(estado);

                    System.out.println("MEMENTO_-------------------------------------------------------------------------------------------");
                    for (int x = 0; x < historicos.size(); x++) {
                        for (int j = 0; j < historicos.size(); j++) {
                            System.out.println("HistoricoSALVO=" + historicos.get(x).getQuarto().getDescricao() + "====" + historicos.get(x).getQuartoMemento().get(j).getEstadoSalvo().getNome());
                        }
                    }
                }
            }
        }
       
 }
//retorna o ultimo estado do quarto 
    

    public QuartoMemento getMomentoAnterio(Quarto quarto) {
        for (int i = 0; i < historicos.size(); i++) {
            if (historicos.get(i).getQuarto().equals(quarto)) {

                QuartoMemento auxQuartoMemento = new QuartoMemento();

                auxQuartoMemento = historicos.get(i).getQuartoMemento().get(historicos.get(i).getQuartoMemento().size());
                historicos.get(i).getQuartoMemento().remove(historicos.get(i).getQuartoMemento().size());
                return auxQuartoMemento;
            }

        }
        return null;
    }

    public ArrayList<HistoricoMemento> getHistorico() {
        return historicos;
    }

    public void setHistorico(ArrayList<HistoricoMemento> historico) {
        this.historicos = historico;
    }

}
