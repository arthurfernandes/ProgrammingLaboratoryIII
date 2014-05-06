/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.cinemark;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arthurfernandes
 */
@WebServlet(name = "ControllerServlet", urlPatterns = {"/index"})
public class ControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        this.armazenaDocumentoXML("http://cinemark.com.br/mobile/xml/films","DocumentoXMLFilmes");
        this.armazenaDocumentoXML("http://cinemark.com.br/mobile/xml","DocumentoXMLCinemas");
        this.armazenaDocumentoXML("http://cinemark.com.br/mobile/xml/upcoming","DocumentoXMLEstreias");
        
        //Implementacao do Front Controller
        
        String nomeDaClasse = request.getParameter("logica");
        Controller logica = ControllerFactory.getControllerPorNomeDaClasse(nomeDaClasse);
        
        if(logica!=null){
            logica.executa(request, response);
        }
        else{
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        
        
    }
    
    private void armazenaDocumentoXML(String url,String alias){
        ServletContext context = this.getServletContext();
        
        if(context.getAttribute(alias)==null){
            DocumentoXML documentoXML = null;
            try{
                DocumentoXMLFactory documentoXMLFactory = DocumentoXMLFactory.newInstance(new URL(url));
                documentoXML = documentoXMLFactory.geraDocumentoXML();
            }
            catch(MalformedURLException e){
                e.printStackTrace();
            }
            context.setAttribute(alias, documentoXML);
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
