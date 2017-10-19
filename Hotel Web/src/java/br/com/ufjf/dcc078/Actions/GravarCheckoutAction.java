package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.HistoricoMementoDAO;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.DAO.ReservaDAO;
import br.com.ufjf.dcc078.Modelo.PessoaFuncionario;
import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.Modelo.QuartoEstado;
import br.com.ufjf.dcc078.Modelo.QuartoMemento;
import br.com.ufjf.dcc078.Modelo.Reserva;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GravarCheckoutAction implements Action {

    private List<String> mensagem;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession sessao = request.getSession();
        ArrayList<QuartoMemento> historicos = (ArrayList<QuartoMemento>) sessao.getAttribute("historico");

        String id = request.getParameter("txtId");
        String checkout = request.getParameter("txtDataCheckout");

        if (id.equals("") || checkout.equals("")) {
            response.sendRedirect("MensagemCamposObrigatorios.jsp");
        } else {
            try {
                Reserva reserva = ReservaDAO.getInstance().ler(Integer.parseInt(id));
                reserva.setData_checkout(checkout);
                //alterar o estado do quarto
                Quarto quarto = reserva.getQuarto();
                QuartoEstado estado = quarto.getEstado();
                estado.limpar(quarto);

               
                // HistoricoMementoDAO.getInstance().addMemento(quarto, quarto.saveToMemento());

                //gravar as alterações no banco
                ReservaDAO.getInstance().gravarCheckout(reserva);
                QuartoDAO.getInstance().alterar(quarto);

                    
                 //Memento
                historicos.add(new QuartoMemento(quarto.getEstado()));
                
                
                //mensagem para os funcionários
                PessoaFuncionario p = new PessoaFuncionario();

                mensagem = p.Mensagemup();
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher view = request.getRequestDispatcher("ObserverMensagem.jsp");
                view.forward(request, response);

            } catch (ClassNotFoundException | ServletException | SQLException ex) {
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
