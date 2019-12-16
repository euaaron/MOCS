/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marco
 */
public class TratamentoExcecao extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Exception excecao = (Exception) request.getAttribute("javax.servlet.error.exception");
        Integer codigoStatus = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String nomeServlet = (String) request.getAttribute("javax.servlet.error.servlet_name");
        String uriRequisicao = (String) request.getAttribute("javax.servlet.error.request_uri");
        String uriAnterior = "/MOCS/";
        if(excecao != null){
            request.setAttribute("excecao", excecao);
        }
        if(nomeServlet != null){
            request.setAttribute("nomeServlet", nomeServlet);
        }
        if(codigoStatus != null){
            request.setAttribute("codigoStatus", codigoStatus);
        }
        if(uriRequisicao != null){
            switch (uriRequisicao) {
                case "/MOCS/ManterUsuarioController":
                    uriAnterior = "/MOCS/PesquisarUsuarioController";
                    break;
                case "/MOCS/ManterFuncionarioController":
                    uriAnterior = "/MOCS/PesquisarFuncionarioController";
                    break;
                case "/MOCS/ManterComandaController":
                    uriAnterior = "/MOCS/PesquisaComandaController";
                    break;
                case "/MOCS/ManterPratoController":
                    uriAnterior = "/MOCS/PesquisarPratoController";
                    break;
                case "/MOCS/ManterEstabelecimentoController":
                    uriAnterior = "/MOCS/PesquisarEstabelecimentoController";
                    break;
                case "/MOCS/ManterPedidoController":
                    uriAnterior = "/MOCS/PesquisarPedidoController";
                break;
                case "/MOCS/ManterFuncaoController":
                    uriAnterior = "/MOCS/PesquisarFuncaoController";
                break;
                default:
                    uriAnterior = "/MOCS/";
            }          

            request.setAttribute("uriRequisicao", uriRequisicao);
        }

        request.setAttribute("uriAnterior", uriAnterior);
        
        RequestDispatcher view = request.getRequestDispatcher("error.jsp");
        view.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
