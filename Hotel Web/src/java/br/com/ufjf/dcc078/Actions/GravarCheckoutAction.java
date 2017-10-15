package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.DAO.ReservaDAO;
import br.com.ufjf.dcc078.Modelo.PessoaFuncionario;
import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.Modelo.QuartoEstado;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoDisponivel;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoLimpeza;
import br.com.ufjf.dcc078.Modelo.QuartoEstadoOcupado;
import br.com.ufjf.dcc078.Modelo.Reserva;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GravarCheckoutAction implements Action {

    private List<String> mensagem;
    
    
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
               quarto.MudarEstadoCheckout(quartoEstado);
       //    quarto.setMudarEstadoCheckout(quartoEstado);             
               QuartoDAO.getInstance().alterar(quarto);
               
               
                PessoaFuncionario p= new PessoaFuncionario();
                mensagem =p.Mensagemup();
               request.setAttribute("mensagem", mensagem);
               RequestDispatcher view = request.getRequestDispatcher("ObserverMensagem.jsp");
               view.forward(request, response);
         

            } catch (ClassNotFoundException | SQLException ex) {
                response.sendRedirect("MensagemErro.jsp");
            } catch (ServletException ex) {
                Logger.getLogger(GravarCheckoutAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }



}
