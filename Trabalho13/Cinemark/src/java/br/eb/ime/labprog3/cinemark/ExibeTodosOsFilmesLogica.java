/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.cinemark;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author arthurfernandes
 */
public class ExibeTodosOsFilmesLogica implements Controller {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/lista-filmes.jsp");
        rd.forward(request, response);
    }
   
}
