package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.DAO.ReservaDAO;
import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoDisponivel;
import br.com.ufjf.dcc078.Modelo.Reserva;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GravarCheckinAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("txtId");
        String checkin = request.getParameter("txtDataCheckin");

        if (id.equals("") || checkin.equals("")) {
            response.sendRedirect("index.php"); //Registro não encontrado
        } else {
            try {
                Reserva reserva = ReservaDAO.getInstance().ler(Integer.parseInt(id));
                reserva.setData_checkin(checkin);
                ReservaDAO.getInstance().gravarCheckin(reserva);

                //alterar o estado do quarto
                Quarto quarto = reserva.getQuarto();
                QuartoEstadoDisponivel disponivel = (QuartoEstadoDisponivel) quarto.getEstado();
                disponivel.ocupar(quarto);
                QuartoDAO.getInstance().alterar(quarto);
                response.sendRedirect("MensagemSucesso.jsp");

            } catch (ClassNotFoundException | SQLException ex) {
                response.sendRedirect("MensagemErro.jsp");
            }
        }
    }

}
