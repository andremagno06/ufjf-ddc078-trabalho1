/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.dcc078.Actions;

import br.com.ufjf.dcc078.Controller.Action;
import br.com.ufjf.dcc078.Modelo.Quarto;
import br.com.ufjf.dcc078.Modelo.QuartoCasal;
import br.com.ufjf.dcc078.Modelo.QuartoDuplo;
import br.com.ufjf.dcc078.Modelo.QuartoFamilia;
import br.com.ufjf.dcc078.Modelo.QuartoSolteiro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Davi
 */
public class ExibirPromocoesAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Quarto> quartos = new ArrayList<>();
            Quarto q1 = new QuartoCasal();
            quartos.add(q1);
            Quarto q2 = new QuartoSolteiro();
            quartos.add(q2);
            Quarto q3 = new QuartoDuplo();
            quartos.add(q3);
            Quarto q4 = new QuartoFamilia();
            quartos.add(q4);
           
            List<String> promocoes = new ArrayList<>();
            
            for(Quarto q : quartos){
                promocoes.add("O quarto "+ q.getTipoQuarto() + " está na "
                        + q.getPromocao().obterPromocao() + " com desconto de "
                        + String.valueOf(q.getPromocao().obterDesconto()) + "%"); 
                
		}
            
            
            request.setAttribute("promocoes", promocoes);
            RequestDispatcher view = request.getRequestDispatcher("listaPromocoes.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            response.sendRedirect("MensagemErro.jsp");
        } 
    }
    
}
