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
import model.Funcao;
import model.Funcionario;

/**
 *
 * @author Débora Lessa & Aaron Stiebler
 */
public class ManterFuncionarioController extends HttpServlet {

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
           throws ClassNotFoundException, SQLException, ServletException {
        
        String operacao = request.getParameter("operacao");
        
        int idEstabelecimento = Integer.parseInt(request.getParameter("txtIdEstabelecimento"));
        int idFuncionario = Integer.parseInt(request.getParameter("txtIdFuncionario"));
        String nome = request.getParameter("txtNome");
        String cpf = request.getParameter("txtCpf");
        String dataNascimento = request.getParameter("txtDataNascimento");
        String email = request.getParameter("txtEmail");
        String telefone = request.getParameter("txtTelefone");
        String senha = request.getParameter("txtSenha");
        int statusConta = Integer.parseInt(request.getParameter("txtStatusConta"));
        int idFuncao = Integer.parseInt(request.getParameter("txtIdFuncao"));
       
        try {
            Estabelecimento estabelecimento = null;
            if (idEstabelecimento != 0) {
                estabelecimento = Estabelecimento.obterEstabelecimento(idEstabelecimento);
            }
            Funcionario funcionario = new Funcionario(idFuncionario, nome,dataNascimento,
                    email, telefone, senha, cpf, statusConta,idEstabelecimento, idFuncao);
            if (operacao.equals("Incluir")) {
                funcionario.gravar();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarFuncionarioController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        }
   }
    
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
    try {
        String operacao = request.getParameter("operacao");
        request.setAttribute("operacao", operacao);
        request.setAttribute("estabelecimentos", Estabelecimento.obterEstabelecimentos());
        RequestDispatcher view = request.getRequestDispatcher("/manterFuncionario.jsp");
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
            Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
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
