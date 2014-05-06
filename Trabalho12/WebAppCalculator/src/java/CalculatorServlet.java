/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arthurfernandes
 */
@WebServlet(urlPatterns = {"/CalculatorServlet"})
public class CalculatorServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String operation = request.getParameter("operation");
            
            String op1s = request.getParameter("op1");
            String op2s = request.getParameter("op2");
            Double op1 = 0.0,op2 = 0.0;
            String result = "";
            try{
                op1 = Double.parseDouble(op1s);
                op2 = Double.parseDouble(op2s);
            }
            catch(Exception e){
                result = "Apenas entradas numéricas são aceitas!";
                operation ="";
                op1 = 0.0;
                op2 = 0.0;
            }
            
            if(operation.equals("soma")){
                result = String.valueOf(op1 + op2);
            }
            else if(operation.equals("subtracao")){
                result = String.valueOf(op1 - op2);
            }
            else if(operation.equals("multiplicacao")){
                result = String.valueOf(op1 * op2);
            }
            else if(operation.equals("divisao")){
                if(op2!=0)
                    result = String.valueOf(op1 / op2);
                else
                    result="Impossivel fazer divisao por zero.";
            }
            
            String output = ""
                    + "<html>\n" +
"    <head>\n" +
"        <title>ServletCalculator</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <div>\n" +
"            <form action=\"CalculatorServlet\" method=\"Post\">\n" +
"                <input type=\"text\" name=\"op1\" value=\"" + String.valueOf(op1) + "\"/>\n" +
"                \n" +
"                <select name=\"operation\">\n" +
"                    \n" +
"                    <option selected id=\"sum\">soma</option>\n" +
"                    <option id=\"sub\">subtracao</option>\n" +
"                    <option id=\"mult\">multiplicacao</option>\n" +
"                    <option id=\"div\">divisao</option>\n" +
"                    \n" +
"                </select>\n" +
"                \n" +
"                <input type=\"text\" name=\"op2\" value=\"" + String.valueOf(op2) + "\"/>\n" +
"               \n" +
"                <input type=\"submit\" value=\"Calculate!\"/>\n" +
"            \n" +
"                 <input type =\"text\" name=\"result\" value=\"" + result + "\" />\n " +
"            </form>\n" +
"            \n" +
"            \n" +
"        </div>\n" +
"    </body>\n" +
"</html>";
            
        out.print(output);
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
