/**
 *
 * @author Débora Lessa & Aaron Stiebler
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.TemporalType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Comanda;
import model.Pedido;
import model.Usuario;

public class ManterComandaController extends HttpServlet {

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
        } 
        else {
                if (acao.equals("prepararOperacao")) {
                    prepararOperacao(request, response);
            }
        }
    }
    
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) 
           throws SQLException, ClassNotFoundException, ServletException {
        
        String operacao = request.getParameter("operacao");
        
        int idComanda = Integer.parseInt(request.getParameter("txtId"));
        String dataComanda = request.getParameter("txtDataComanda");
        String horaComanda = request.getParameter("txtHoraComanda");
        int idCliente = Integer.parseInt(request.getParameter("txtIdCliente"));
        
        try {
            Usuario cliente = null;
            if(idCliente != 0){
                cliente = Usuario.obterUsuario(idCliente);
            }
            Comanda comanda = new Comanda(idComanda, dataComanda, horaComanda, cliente.getId());
            if (operacao.equals("Incluir")){
                comanda.gravar();
            } else if (operacao.equals("Editar")) {
                comanda.editar();
            } else if (operacao.equals("Excluir")) {
                comanda.excluir();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarComandaController");
            view.forward(request, response);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        } 
    }
    
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
    try {
        String operacao = request.getParameter("operacao");
        request.setAttribute("operacao", operacao);
        request.setAttribute("clientes", Usuario.obterUsuarios());
        if (!operacao.equals("Incluir")) {
                int idComanda = Integer.parseInt(request.getParameter("id"));
                Comanda comanda = Comanda.obterComanda(idComanda);
                request.setAttribute("comanda", comanda);
            }
        RequestDispatcher view = request.getRequestDispatcher("/cadastrarComanda.jsp");
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
            throw new ServletException(ex);
        } catch (SQLException ex) {
            throw new ServletException(ex);
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
            Logger.getLogger(ManterComandaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterComandaController.class.getName()).log(Level.SEVERE, null, ex);
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
