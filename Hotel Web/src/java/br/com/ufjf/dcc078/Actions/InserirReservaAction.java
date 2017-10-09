package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.PessoaDAO;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.DAO.ReservaDAO;
import br.com.ufjf.dcc078.Modelo.Pessoa;
import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoDisponivel;
import br.com.ufjf.dcc078.Modelo.Reserva;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InserirReservaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idCliente = request.getParameter("txtCliente");
        String idQuarto = request.getParameter("txtQuarto");
        String data = request.getParameter("txtDataReserva");
 
        
        try {
            Pessoa cliente = PessoaDAO.getInstance().ler(Integer.parseInt(idCliente));
            Quarto quarto = QuartoDAO.getInstance().ler(Integer.parseInt(idQuarto));
            Reserva reserva = new Reserva(cliente, quarto, data);
            ReservaDAO.getInstance().gravar(reserva);
            
            //alterar o estado do quarto
           /* QuartoEstadoDisponivel disponivel = (QuartoEstadoDisponivel) quarto.getEstado();
            disponivel.ocupar(quarto);
            QuartoDAO.getInstance().alterar(quarto);*/
            
            response.sendRedirect("MensagemSucesso.jsp");
        } catch (ClassNotFoundException | SQLException ex) {
            response.sendRedirect("MensagemErro.jsp");
        }
    }

}
