/**
 *
 * @author Débora and Aaron
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
import model.Usuario;

public class ManterUsuarioController extends HttpServlet {

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
        } else {
            if (acao.equals("prepararOperacao")) {
                prepararOperacao(request, response);
            }
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            if (!operacao.equals("Incluir")) {
                int idUsuario = Integer.parseInt(request.getParameter("id"));
                Usuario usuario = Usuario.obterUsuario(idUsuario);
                request.setAttribute("usuario", usuario);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarUsuario.jsp");
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

        String errorMsg;

        int idUsuario;
        String nome = null;
        String cpf = null;
        String dataNascimento = null;
        String email = null;
        String telefone = null;
        String senha = null;

        if (operacao.equals("Incluir")) {
            idUsuario = Integer.parseInt(request.getParameter("txtIdUsuario"));
            nome = request.getParameter("txtNome");
            cpf = request.getParameter("txtCpf");
            dataNascimento = request.getParameter("txtDataNascimento");
            email = request.getParameter("txtEmail");
            telefone = request.getParameter("txtTelefone");
            senha = request.getParameter("txtSenha");
        } else {
            idUsuario = Integer.parseInt(request.getParameter("txtIdUsuario"));
        }

        try {

            if (operacao.equals("Incluir")) { //-------------------CADASTRAR USUARIO
                Usuario usuario = Usuario.obterUsuario(idUsuario);
                if (usuario != null) {
                    errorMsg = "O usuário já existe ou o ID " + idUsuario + " já foi utilizado.";
                    request.setAttribute("errorMsg", errorMsg);
                    RequestDispatcher view = request
                            .getRequestDispatcher("ManterUsuarioController?acao=prepararOperacao&operacao=Incluir");
                    view.forward(request, response);
                } else {
                    usuario = new Usuario(idUsuario, nome, dataNascimento,
                            email, telefone, senha, cpf);
                    usuario.gravar();
                }

            } else {
                Usuario usuario = Usuario.obterUsuario(idUsuario);
                if (usuario == null) {
                    errorMsg = "O usuário não existe ou foi excluído.";
                    request.setAttribute("errorMsg", errorMsg);
                    RequestDispatcher view = request
                            .getRequestDispatcher("ManterUsuarioController?acao=prepararOperacao&operacao=Incluir");
                    view.forward(request, response);
                }
                switch (operacao) {
                    case "Editar":
                        //-------------------EDITAR USUARIO
                        usuario.editar();
                        break;
                    case "Excluir":
                        //-------------------EXCLUIR USUARIO
                        usuario.excluir();
                        break;
                    default:
                        String errorCode = "400";
                        errorMsg = "Bad Request.";
                        request.setAttribute("errorMsg", errorMsg);
                        request.setAttribute("errorCode", errorCode);
                        RequestDispatcher view = request.getRequestDispatcher("TratamentoExcecao");
                        view.forward(request, response);
                }
            }

            RequestDispatcher view = request.getRequestDispatcher("PesquisarUsuarioController");
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
        } catch (SQLException ex) {
            Logger.getLogger(ManterUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
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
