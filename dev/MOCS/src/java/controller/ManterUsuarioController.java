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

        try {
            if (!operacao.equals("Excluir")) {
                int idUsuario = Integer.parseInt(request.getParameter("txtIdUsuario"));
                String nome = request.getParameter("txtNome");
                String cpf = request.getParameter("txtCpf");
                String dataNascimento = request.getParameter("txtDataNascimento");
                String email = request.getParameter("txtEmail");
                String telefone = request.getParameter("txtTelefone");
                String senha = request.getParameter("txtSenha");

                if (operacao.equals("Incluir")) {
                    if (Usuario.obterUsuario(idUsuario) != null) {
                        errorMsg = "O usuário já existe ou o ID " + idUsuario + " já foi utilizado.";
                        request.setAttribute("errorMsg", errorMsg);
                        RequestDispatcher view = request
                                .getRequestDispatcher("ManterUsuarioController?acao=prepararOperacao&operacao=Incluir");
                        view.forward(request, response);
                    } else {
                        Usuario usuario = new Usuario(idUsuario, nome, dataNascimento,
                                email, telefone, senha, cpf);
                        usuario.gravar(); //-------------------CADASTRAR USUARIO
                    }
                } else if (operacao.equals("Editar")) {
                    Usuario usuario = new Usuario(idUsuario, nome, dataNascimento,
                            email, telefone, senha, cpf);
                    usuario.editar(); //-------------------EDITAR USUARIO
                }

            } else {
                int idUsuario = Integer.parseInt(request.getParameter("txtIdUsuario"));

                Usuario usuario = Usuario.obterUsuario(idUsuario);
                if (operacao.equals("Excluir")) {
                    usuario.excluir(); //-------------------EXCLUIR USUARIO
                }
            }

            RequestDispatcher view = request.getRequestDispatcher("PesquisarUsuarioController");
            view.forward(request, response);
        }  catch (IOException | SQLException | ClassNotFoundException e) {
            if(e instanceof SQLException){
                String foo = e.getMessage();
                if(foo.contains("FOREIGN")) {
                    RequestDispatcher view = request.getRequestDispatcher("ManterUsuarioController?acao=prepararOperacao&operacao=Excluir&id=" + Integer.parseInt(request.getParameter("txtIdUsuario")));
                    try {
                        request.setAttribute("errorMsg", "Não é possível excluir uma conta vinculada à um estabelecimento. Por favor, exclua ou transfira seu(s) estabelecimentos antes de prosseguir com a operação.");
                        request.setAttribute("usuario", Usuario.obterUsuario(Integer.parseInt(request.getParameter("txtIdUsuario"))));
                        view.forward(request, response);
                    } catch (IOException ex) {
                        throw new ServletException(ex);
                    }
                    return;
                }                
            }
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
