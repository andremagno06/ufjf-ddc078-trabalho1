package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.DAO.ReservaDAO;
import br.com.ufjf.dcc078.Memento.QuartoCareTaker;
import br.com.ufjf.dcc078.Memento.QuartoMemento;
import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.Modelo.QuartoEstado;
import br.com.ufjf.dcc078.Modelo.Reserva;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GravarCheckinAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
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
                
                reserva.setData_checkin(checkin);
                ReservaDAO.getInstance().gravarCheckin(reserva);
                QuartoDAO.getInstance().alterar(quarto); //gravar o estado do quarto alterado
                
               //salvar estados do banco para desfazer
                QuartoMemento memento = new QuartoMemento(quarto.getId());
                memento.addEstado(quarto.getEstado());
                QuartoCareTaker.getInstance().adicionarMemento(memento);
                
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
