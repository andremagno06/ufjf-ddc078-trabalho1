package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.DAO.ReservaDAO;
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

public class FazerCheckInAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("textNome");
      
       
        
            try {
            List<Reserva> reservas = ReservaDAO.getInstance().lerTodos();
            reservas.get(Integer.parseInt(id)).setData_checkin("09/10/2017");
            request.setAttribute("nome", reservas);
            
            
            RequestDispatcher view = request.getRequestDispatcher("listaReservas.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            response.sendRedirect("MensagemErro.jsp");
        } catch (ServletException ex) {
            Logger.getLogger(ExibirReservasAction.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
    }
    
        
        
        
        
        
    }


