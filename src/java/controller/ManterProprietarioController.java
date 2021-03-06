/*package controller;

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
import model.Proprietario;

/**
 *
 * @author Débora
 */
/*
public class ManterProprietarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
/*
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
    
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) 
           throws SQLException, ClassNotFoundException, ServletException {
        
        String operacao = request.getParameter("operacao");
        
        int idProprietario = Integer.parseInt(request.getParameter("txtId"));
        String nome = request.getParameter("txtNome");
        String cpf = request.getParameter("txtCpf");
        String dataNascimento = request.getParameter("txtDataNascimento");
        String email = request.getParameter("txtEmail");
        String telefone = request.getParameter("txtTelefone");
        String senha = request.getParameter("txtSenha");
        
        try {
            Proprietario proprietario = new Proprietario(idProprietario, nome, dataNascimento, email, 
                    telefone, senha, cpf);
            if (operacao.equals("Incluir")){
                proprietario.gravar();
            } else if (operacao.equals("Excluir")) {
               proprietario.excluir();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarProprietarioController");
                    view.forward(request, response);
        } catch (IOException e){
            throw new ServletException(e);
        }
    }
    
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            if (!operacao.equals("Incluir")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Proprietario obj = Proprietario.obterProprietario(id);
                request.setAttribute("proprietario", obj);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarProprietario.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
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
/*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
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
/*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterProprietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
/*
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
*/