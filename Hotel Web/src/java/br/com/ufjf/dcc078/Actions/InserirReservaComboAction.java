/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.PessoaDAO;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.DAO.ReservaDAO;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.Modelo.Pessoa;
import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.Modelo.Reserva;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Desenvolvedor
 */
public class InserirReservaComboAction implements Action {

    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
    try{
                  List<Pessoa> pessoas = PessoaDAO.getInstance().lerTodosClientes();
                  List<Quarto> quartos = QuartoDAO.getInstance().lerTodos();
                   request.setAttribute("quartos", quartos);
                   request.setAttribute("pessoas", pessoas);
                   RequestDispatcher view = request.getRequestDispatcher("novaReserva.jsp");  /erro aqui não sei porque??????????????????????????
                   view.forward(request, response);
                   
        } catch (ClassNotFoundException | SQLException |ServletException ex) {
            response.sendRedirect("MensagemErro.jsp");
        } 
                

    }

}
