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

public class DesfazerAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
 
         HttpSession sessao = request.getSession();
        ArrayList<QuartoMemento> historicos = (ArrayList<QuartoMemento>) sessao.getAttribute("historico");
        
        String id = request.getParameter("id");
        

        if (id.equals("")) {
            response.sendRedirect("MensagemCamposObrigatorios.jsp");
        } else {
            try {
                Reserva reserva = ReservaDAO.getInstance().ler(Integer.parseInt(id));

                //alterar o estado do quarto
                Quarto quarto = reserva.getQuarto();
                quarto.setEstado(historicos.add());
                estado=HistoricoMementoDAO.getInstance().getMomentoAnterio(quarto).getEstadoSalvo();
                
                //Memento
                quarto.setEstado(estado);

                //fazer o checkin
                reserva.setData_checkin("");
                ReservaDAO.getInstance().gravarCheckin(reserva);
                QuartoDAO.getInstance().alterar(quarto); //gravar o estado do quarto alterado

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
