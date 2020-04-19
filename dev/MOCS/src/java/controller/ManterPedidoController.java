/**
 *
 * @author Débora Lessa & Aaron Stiebler
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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            String idComanda = request.getParameter("icm");
            request.setAttribute("operacao", operacao);
            request.setAttribute("pratos", Prato.obterPratos());
            request.setAttribute("comandas", Comanda.obterComandas());
            if (!operacao.equals("Incluir")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Pedido obj = Pedido.obterPedido(id);
                request.setAttribute("pedido", obj);
            }
            if (idComanda != null && !idComanda.equals("")) {
                Comanda comanda = Comanda.obterComanda(Integer.parseInt(idComanda));
                request.setAttribute("comanda", comanda);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarPedido.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ClassNotFoundException, ServletException {

        String operacao = request.getParameter("operacao");
        int idPedido = Integer.parseInt(request.getParameter("txtId"));
        int idComanda;
        if (request.getParameter("icm") == null) {
            idComanda = Integer.parseInt(request.getParameter("txtIdComanda"));    
        } else {
            idComanda = Integer.parseInt(request.getParameter("icm"));
        }
        int idPrato = Integer.parseInt(request.getParameter("txtIdPrato"));
        int quantidade = Integer.parseInt(request.getParameter("txtQuantidade"));

        try {
            Comanda comanda = null;
            if (idComanda != 0) {
                comanda = Comanda.obterComanda(idComanda);
            }
            Prato prato = null;
            if (idPrato != 0) {
                prato = Prato.obterPrato(idPrato);
            }
            Pedido pedido = new Pedido(idPedido, idPrato, quantidade, idComanda);
            if (operacao.equals("Incluir")) {
                pedido.gravar();
            } else if (operacao.equals("Excluir")) {
                pedido.excluir();
            } else if (operacao.equals("Editar")) {
                pedido.editar();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarPedidoController");
            view.forward(request, response);
        } catch (IOException | SQLException | ClassNotFoundException e) {
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
