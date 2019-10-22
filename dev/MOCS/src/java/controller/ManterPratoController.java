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
import model.Funcionario;
import model.Prato;

/**
 *
 * @author Débora Lessa & Aaron Stiebler
 */
public class ManterPratoController extends HttpServlet {

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
    
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) 
           throws SQLException, ClassNotFoundException, ServletException {
        
        String operacao = request.getParameter("operacao");
        
        int idPrato = Integer.parseInt(request.getParameter("txtIdPrato"));
        int idFuncionario = Integer.parseInt(request.getParameter("txtIdFuncionario"));
        int idEstabelecimento = Integer.parseInt(request.getParameter("txtIdEstabelecimento"));
        String nome = request.getParameter("txtNome");
        String descricao = request.getParameter("txtDescricao");
        String dataCriacao = request.getParameter("txtDataCriacao");
        
        try {
            Estabelecimento estabelecimento = null;
            if(idEstabelecimento != 0){
                estabelecimento = Estabelecimento.obterEstabelecimento(idEstabelecimento);
            }
            Funcionario funcionario = null;
            if(idFuncionario != 0){
                funcionario = Funcionario.obterFuncionario(idFuncionario);
            }
            Prato comanda = new Prato(idPrato, nome, descricao, dataCriacao, idFuncionario, idEstabelecimento);
            if (operacao.equals("Incluir")){
                comanda.gravar();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarPratoController");
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
        request.setAttribute("funcionario", Funcionario.obterFuncionarios());
        RequestDispatcher view = request.getRequestDispatcher("/cadastrarPrato.jsp");
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
            Logger.getLogger(ManterPratoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterPratoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterPratoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterPratoController.class.getName()).log(Level.SEVERE, null, ex);
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
