/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Comanda;
import model.Pedido;
import model.Prato;

/**
 *
 * @author Débora Lessa & Aaron Stiebler
 */
public class ManterPedidoController extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
    try {
        String operacao = request.getParameter("operacao");
        request.setAttribute("operacao", operacao);
        request.setAttribute("prato", Prato.obterPratos());
        request.setAttribute("comanda", Comanda.obterComandas());
        RequestDispatcher view = request.getRequestDispatcher("/manterPedido.jsp");
        view.forward(request, response);
    }catch (ServletException e){
        throw e;
    }catch (IOException e){
        throw new ServletException(e);
    }
    } 
    
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) 
           throws SQLException, ClassNotFoundException, ServletException {
        
        String operacao = request.getParameter("operacao");
        
        int idPedido = Integer.parseInt(request.getParameter("txtIdPedido"));
        int idComanda = Integer.parseInt(request.getParameter("txtIdComanda"));
        int idPrato = Integer.parseInt(request.getParameter("txtIdPrato"));
        int quantidade = Integer.parseInt(request.getParameter("txtQuantidade"));
        
        try {
            Comanda comanda = null;
            if(idComanda != 0){
                comanda = Comanda.obterComanda(idComanda);
            }
            Prato prato = null;
            if(idPrato != 0){
                prato = Prato.obterPrato(idPrato);
            }
            Pedido pedido = new Pedido(idPedido, idComanda, idPrato, quantidade);
            if (operacao.equals("Incluir")){
                comanda.gravar();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarPedidoController");
                    view.forward(request, response);
        } catch (IOException e){
            throw new ServletException(e);
        }
    }
    
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
    try {
        String operacao = request.getParameter("operacao");
        request.setAttribute("operacao", operacao);
        request.setAttribute("pratos", Prato.obterPratos());
        RequestDispatcher view = request.getRequestDispatcher("/manterPedido.jsp");
        view.forward(request, response);
    }catch (ServletException e){
        throw e;
    }catch (IOException e){
        throw new ServletException(e);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
