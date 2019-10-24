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
import model.Funcao;

/**
 *
 * @author euaar
 */
public class ManterFuncaoController extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
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
            throws ServletException, IOException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            if (!operacao.equals("Incluir")) {
                int idFuncao = Integer.parseInt(request.getParameter("id"));
                Funcao funcao = Funcao.obterFuncao(idFuncao);
                request.setAttribute("funcao", funcao);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarFuncao.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
    
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) 
           throws SQLException, ClassNotFoundException, ServletException {
        
        String operacao = request.getParameter("operacao");
        
        int idFuncao = Integer.parseInt(request.getParameter("txtIdFuncao"));
        int idEstabelecimento = Integer.parseInt(request.getParameter("txtIdEstabelecimento"));
        String nome = request.getParameter("txtNome");
        String descricao = request.getParameter("txtDescricao");
        int nivelPermissao = Integer.parseInt(request.getParameter("txtNivelPermissao"));
        
        try {
            Funcao funcao = new Funcao(idFuncao, idEstabelecimento, nome, descricao, nivelPermissao);
            if (operacao.equals("Incluir")){
                funcao.gravar();
            } else if (operacao.equals("Editar")) {
                funcao.editar();
            } else if (operacao.equals("Excluir")) {
                funcao.excluir();
            }
            
            RequestDispatcher view = request.getRequestDispatcher("PesquisarFuncaoController");
                    view.forward(request, response);
        } catch (IOException e){
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
        } catch (SQLException ex) {
            Logger.getLogger(ManterFuncaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterFuncaoController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(ManterFuncaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterFuncaoController.class.getName()).log(Level.SEVERE, null, ex);
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
