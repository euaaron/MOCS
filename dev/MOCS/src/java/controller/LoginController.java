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

/**
 *
 * @author euaaron
 */
public class LoginController extends HttpServlet {

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
        String acao = request.getParameter("acao");
        if (acao == null || acao.equals("confirmarOperacao")) {
            try {
                confirmarOperacao(request, response);
            } catch (SQLException e) {
                throw new ServletException(e);
            } catch (ClassNotFoundException e) {
                throw new ServletException(e);
            }
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, ClassNotFoundException, ServletException {
        String erro = "Dados incorretos.";
        String operacao = request.getParameter("operacao");
        try {
            if(operacao == null || operacao.equals("validar") || operacao.equals("")) {
                RequestDispatcher view = request.getRequestDispatcher("inicio.jsp");
                view.forward(request, response);
            }
            
            int agente = Integer.parseInt(request.getParameter("agente"));
            if (getAgente(agente).equals("convidado")) {
                RequestDispatcher view = request.getRequestDispatcher("inicio.jsp");
                view.forward(request, response);
            }

            String email = request.getParameter("txtEmail");
            String senha = request.getParameter("txtSenha");

            if (senha == null || email == null || senha.equals("") || email.equals("")) {
                request.setAttribute("erro", erro);
                RequestDispatcher view = request.getRequestDispatcher("inicio.jsp");
                view.forward(request, response);
            }

            Usuario user;

            if (request.getParameter("idUser") != null && Integer.parseInt(request.getParameter("idUser")) != 0) {
                int id = Integer.parseInt(request.getParameter("idUser"));
                user = Usuario.obterUsuario(id);

            } else {
                user = Usuario.obterUsuarioEmail(email);
            }

            if (!senha.equals(user.getSenha())) {
                request.setAttribute("erro", erro);
                RequestDispatcher view = request.getRequestDispatcher("inicio.jsp");
                view.forward(request, response);
            } else {
                RequestDispatcher view = request.getRequestDispatcher("inicio.jsp");
                view.forward(request, response);
            }

        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public String getAgente(int agente) {
        switch (agente) {
            case 1:
                return "usuario";
            case 99:
                return "super";
            default:
                return "convidado";
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
