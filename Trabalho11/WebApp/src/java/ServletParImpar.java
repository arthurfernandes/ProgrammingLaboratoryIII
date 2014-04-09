/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arthurfernandes
 */
@WebServlet(urlPatterns = {"/ServletParImpar"})
public class ServletParImpar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    private String previousJogador1 = "";
    private String previousJogador2 = "";
    private String jogador1 = "";
    private String jogador2 = "";
    private int input1;
    private int input2;
    private String vencedor = "";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String rJogador = request.getParameter("jogador");
        String rValue = request.getParameter("value");
        String typeOfRequest = request.getParameter("type");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            if(typeOfRequest.equals("play")){
            
                if(jogador1.equals("") && !rJogador.equals("")){
                    if(!rValue.equals("")){
                        try{
                            input1 = Integer.parseInt(rValue);
                        }
                        catch(Exception e){
                            out.print("Bad Request.");
                        }

                        jogador1 = rJogador;
                        out.print("Esperando Jogador 2 - Voce e: Par");
                    }
                    out.close();
                    return;
                }
            
                if(rJogador.equals(jogador1)){
                    out.print("Voce acabou de jogar, espere outro jogador!!");
                    out.close();
                    return;
                }
                
                if(!jogador1.equals("") && !rJogador.equals("")){
                    if(!rValue.equals("")){
                        try{
                            input2 = Integer.parseInt(rValue);
                        }
                        catch(Exception e){
                            out.print("Bad Request.");
                        }

                        jogador2 = rJogador;
                        if(((input1+input2)%2)==0){
                            vencedor = jogador1;
                        }
                        else
                            vencedor = jogador2;
                        
                        out.print("Voce e Impar. Voce ");
                        if(jogador2.equals(vencedor))
                            out.print("venceu");
                        else
                            out.print("perdeu.");
                        
                        previousJogador1 = jogador1;
                        previousJogador2 = jogador2;
                        jogador1 = "";
                        jogador2 = "";
                        
                        
                    }
                }
                out.close();
                return;
            }
            else if(typeOfRequest.equals("consult")){
                if(rJogador.equals(previousJogador1) || rJogador.equals(previousJogador2)){
                    if(rJogador.equals(vencedor)){
                        out.print("Voce venceu!");
                        
                    }
                }
                else{
                    out.print("Voce nao jogou o ultimo jogo ou seu jogo ainda esta em andamento");
                    
                }
            }
           
            out.close();
            return;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
