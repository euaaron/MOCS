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
import model.Estabelecimento;
//import model.Proprietario;
import model.Usuario;

/**
 *
 * @author Débora Lessa & Aaron Stiebler
 */
public class ManterEstabelecimentoController extends HttpServlet {

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
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        }else{
            if (acao.equals("prepararOperacao")) {
                prepararOperacao(request, response);
            }
        }
    }
    
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("proprietario", Usuario.obterUsuarios());
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarEstabelecimento.jsp");
            view.forward(request, response);
        } catch (ServletException e){
            throw e;
        } catch (IOException e){
            throw new ServletException(e);
        }
    }
    
   public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) 
           throws ClassNotFoundException, SQLException, ServletException {
       
       String operacao = request.getParameter("operacao");
       
       int id = Integer.parseInt(request.getParameter("txtIdEstabelecimento"));
       int idProprietario = Integer.parseInt(request.getParameter("txtIdProprietario"));
       String cnpj = request.getParameter("txtCnpj");
       String nomeFantasia = request.getParameter("txtNomeFantasia");
       String inscEstadual = request.getParameter("txtInscEstadual");
       String telefone = request.getParameter("txtTelefone");
       
       try {
           Usuario proprietario = null;
           if (idProprietario != 0) {
               proprietario = Usuario.obterUsuario(idProprietario);
           }
           Estabelecimento e = new Estabelecimento(id,idProprietario, cnpj,nomeFantasia,
           inscEstadual, telefone);
           if (operacao.equals("Incluir")) {
               e.gravar();
           }
           RequestDispatcher view = request.getRequestDispatcher("PesquisarEstabelecimentoController");
           view.forward(request, response);
       } catch (IOException e) {
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
            Logger.getLogger(ManterEstabelecimentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterEstabelecimentoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterEstabelecimentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterEstabelecimentoController.class.getName()).log(Level.SEVERE, null, ex);
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
