package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.HistoricoMementoDAO;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.DAO.ReservaDAO;
import br.com.ufjf.dcc078.Modelo.HistoricoMemento;
import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.Modelo.QuartoEstado;
import br.com.ufjf.dcc078.Modelo.QuartoMemento;
import br.com.ufjf.dcc078.Modelo.Reserva;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GravarCheckinAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
     
        HttpSession sessao = request.getSession();
        ArrayList<QuartoMemento> historicos = (ArrayList<QuartoMemento>) sessao.getAttribute("historico");
        
        
        String id = request.getParameter("txtId");
        String checkin = request.getParameter("txtDataCheckin");

        if (id.equals("") || checkin.equals("")) {
            response.sendRedirect("MensagemCamposObrigatorios.jsp");
        } else {
            try {
                Reserva reserva = ReservaDAO.getInstance().ler(Integer.parseInt(id));

                //alterar o estado do quarto
                Quarto quarto = reserva.getQuarto();
                QuartoEstado estado = quarto.getEstado();
                estado.ocupar(quarto);
                
               
              //  HistoricoMementoDAO.getInstance().addMemento(quarto, quarto.saveToMemento());

                //fazer o checkin
                reserva.setData_checkin(checkin);
                ReservaDAO.getInstance().gravarCheckin(reserva);
                QuartoDAO.getInstance().alterar(quarto); //gravar o estado do quarto alterado
                
                 //Memento
                historicos.add(new QuartoMemento(quarto.getEstado()));
                response.sendRedirect("MensagemSucesso.jsp");

            } catch (ClassNotFoundException | SQLException ex) {
                response.sendRedirect("MensagemErro.jsp");
            } catch (UnsupportedOperationException e) {
                try {
                    request.setAttribute("mensagem", e.getMessage());
                    RequestDispatcher view = request.getRequestDispatcher("MensagemErroEstadoQuarto.jsp");
                    view.forward(request, response);
                } catch (ServletException ex) {
                    response.sendRedirect("MensagemErro.jsp");
                }
            }
        }
    }

}
