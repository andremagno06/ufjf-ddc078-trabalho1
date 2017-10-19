package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.HistoricoMementoDAO;
import br.com.ufjf.dcc078.DAO.PessoaDAO;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.DAO.ReservaDAO;
import br.com.ufjf.dcc078.Modelo.HistoricoMemento;
import br.com.ufjf.dcc078.Modelo.Pessoa;
import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoDisponivel;
import br.com.ufjf.dcc078.Modelo.QuartoMemento;
import br.com.ufjf.dcc078.Modelo.Reserva;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InserirReservaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession sessao = request.getSession();
        ArrayList<QuartoMemento> historicos = (ArrayList<QuartoMemento>) sessao.getAttribute("historico");

        String idCliente = request.getParameter("txtCliente");
        String idQuarto = request.getParameter("txtQuarto");
        String data = request.getParameter("txtDataReserva");

        if (idCliente.equals("") || idQuarto.equals("") || data.equals("")) {
            response.sendRedirect("MensagemCamposObrigatorios.jsp");
        } else {
            try {
                Pessoa cliente = PessoaDAO.getInstance().ler(Integer.parseInt(idCliente));
                Quarto quarto = QuartoDAO.getInstance().ler(Integer.parseInt(idQuarto));
                Reserva reserva = new Reserva(cliente, quarto, data);
                ReservaDAO.getInstance().gravar(reserva);

                //alterar o estado do quarto
                QuartoEstadoDisponivel disponivel = (QuartoEstadoDisponivel) quarto.getEstado();
                disponivel.reservar(quarto);
 
              

                QuartoDAO.getInstance().alterar(quarto);
//memento
                historicos.add(new QuartoMemento(quarto.getEstado()));
                response.sendRedirect("MensagemSucesso.jsp");
            } catch (ClassNotFoundException | SQLException ex) {
                response.sendRedirect("MensagemErro.jsp");
            }

        }
    }

}
