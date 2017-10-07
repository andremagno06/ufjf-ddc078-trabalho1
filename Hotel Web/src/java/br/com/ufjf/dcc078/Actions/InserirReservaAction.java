/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.DAO.QuartoDAO;
import br.com.ufjf.dcc078.DAO.ReservaDAO;
import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.Modelo.Reserva;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Desenvolvedor
 */
public class InserirReservaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pessoa_id = request.getParameter("textPessoa_id");
        String quarto_id = request.getParameter("textquarto_id");
        String data_checkin = request.getParameter("textData_checkin");
        String data_checkout = request.getParameter("textData_checkout");
        String data_reserva = request.getParameter("textData_reserva");

        if (pessoa_id.equals("") || quarto_id.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                Reserva reserva = new Reserva(Integer.parseInt(pessoa_id), Integer.parseInt(quarto_id), data_checkin, data_checkout, data_reserva);
                ReservaDAO.getInstance().gravar(reserva);
                response.sendRedirect("MensagemSucesso.jsp");

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(InserirReservaAction.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("MensagemErro.jsp");
            }

        }
    }

}
