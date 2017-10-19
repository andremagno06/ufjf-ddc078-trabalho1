package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.DAO.ReservaDAO;
import br.com.ufjf.dcc078.Memento.QuartoCareTaker;
import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.Modelo.QuartoEstado;
import br.com.ufjf.dcc078.Modelo.Reserva;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DesafazerCheckinAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");

        if (id.equals("")) {
            response.sendRedirect("MensagemCamposObrigatorios.jsp");
        } else {
            try {
                Reserva reserva = ReservaDAO.getInstance().ler(Integer.parseInt(id));
                reserva.setData_checkin("");
                reserva.setData_checkout("");
                ReservaDAO.getInstance().gravarCheckin(reserva);
                ReservaDAO.getInstance().gravarCheckout(reserva);
                
                Quarto quarto = reserva.getQuarto();
                QuartoEstado estado  = QuartoCareTaker.getInstance().getUltimoEstadoSalvo(quarto.getId());
                quarto.setEstado(estado);
                QuartoDAO.getInstance().alterar(quarto);
                
            } catch (ClassNotFoundException | SQLException ex) {
                response.sendRedirect("MensagemErro.jsp");
            }
           
        }
    }

}
