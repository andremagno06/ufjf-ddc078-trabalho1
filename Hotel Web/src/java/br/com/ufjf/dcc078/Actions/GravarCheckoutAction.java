package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.DAO.ReservaDAO;
import br.com.ufjf.dcc078.Memento.QuartoCareTaker;
import br.com.ufjf.dcc078.Modelo.PessoaFuncionario;
import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.Modelo.QuartoEstado;
import br.com.ufjf.dcc078.Memento.QuartoMemento;
import br.com.ufjf.dcc078.Modelo.Reserva;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
            response.sendRedirect("MensagemCamposObrigatorios.jsp");
        } else {
            try {
                Reserva reserva = ReservaDAO.getInstance().ler(Integer.parseInt(id));
                reserva.setData_checkout(checkout);
                //alterar o estado do quarto
                Quarto quarto = reserva.getQuarto();
                QuartoEstado estado = quarto.getEstado();
                estado.limpar(quarto);

                //gravar as alterações no banco
                ReservaDAO.getInstance().gravarCheckout(reserva);
                QuartoDAO.getInstance().alterar(quarto);
                
                //salvar estados do banco para desfazer
                QuartoMemento memento = new QuartoMemento(quarto.getId());
                memento.addEstado(quarto.getEstado());
                //QuartoCareTaker.getInstance().adicionarMemento(memento);
                
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
