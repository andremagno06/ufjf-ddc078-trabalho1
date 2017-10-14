package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.DAO.ReservaDAO;
import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.Modelo.QuartoEstado;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoDisponivel;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoLimpeza;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoOcupado;
import br.com.ufjf.dcc078.Modelo.Reserva;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GravarCheckoutAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("txtId");
        String checkout = request.getParameter("txtDataCheckout");

        if (id.equals("") || checkout.equals("")) {
            response.sendRedirect("index.php"); //Registro não encontrado
        } else {
            try {
                Reserva reserva = ReservaDAO.getInstance().ler(Integer.parseInt(id));
                reserva.setData_checkout(checkout);
                ReservaDAO.getInstance().gravarCheckout(reserva);

              
               Quarto quarto = reserva.getQuarto();
               QuartoEstado quartoEstado =  new QuartoEstadoLimpeza();
       //        quarto.setMudarEstadoCheckout(quartoEstado);                observer Roblema não esta conseguindo pegar os 
               QuartoDAO.getInstance().alterar(quarto);
               
               
              
                response.sendRedirect("MensagemSucesso.jsp");

            } catch (ClassNotFoundException | SQLException ex) {
                response.sendRedirect("MensagemErro.jsp");
            }
        }
    }

}
