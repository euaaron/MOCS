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
import model.Estabelecimento;
import model.Funcionario;
import model.Prato;

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
        String errorMsg;
        
        int id = 0;
        int idFuncionario = 0;
        int idEstabelecimento = 0;
        String nome = "";
        String descricao = "";
        float preco = 0;
        String imagemUrl = "";
        String dataCriacao = "";
        int exibir = 0; 
        
        if (!operacao.equals("Excluir")) {
            id = Integer.parseInt(request.getParameter("txtId"));
            idFuncionario = Integer.parseInt(request.getParameter("txtIdFuncionario"));
            idEstabelecimento = Integer.parseInt(request.getParameter("txtIdEstabelecimento"));
            nome = request.getParameter("txtNome");
            descricao = request.getParameter("txtDescricao");
            preco = Float.parseFloat(request.getParameter("txtPreco"));
            imagemUrl = request.getParameter("txtImagemUrl");
            dataCriacao = (String) request.getParameter("txtDataCriacao");
            exibir = Integer.parseInt(request.getParameter("txtExibir"));                    
        } else {
            id = Integer.parseInt(request.getParameter("txtId"));
        }
        
        if (imagemUrl.equals("")) {
                imagemUrl = "https://via.placeholder.com/160x90";
            }
        
        try {
            if (operacao.equals("Excluir")) {
                Prato obj = Prato.obterPrato(id);
                obj.excluir();
            } else {
            
                Estabelecimento estabelecimento = null;
                if(idEstabelecimento != 0){
                    estabelecimento = Estabelecimento.obterEstabelecimento(idEstabelecimento);
                }
                Funcionario funcionario = null;
                if(idFuncionario != 0){
                    funcionario = Funcionario.obterFuncionario(idFuncionario);
                }
                Prato obj = new Prato(id, nome, descricao, preco, imagemUrl, dataCriacao, idFuncionario, idEstabelecimento, exibir);
                if (operacao.equals("Incluir")){
                    obj.gravar();
                } else if (operacao.equals("Editar")) {
                    obj.editar();
                }
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
        request.setAttribute("funcionarios", Funcionario.obterFuncionarios());
        request.setAttribute("estabelecimentos", Estabelecimento.obterEstabelecimentos());
        if (!operacao.equals("Incluir")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Prato obj = Prato.obterPrato(id);
                request.setAttribute("prato", obj);
            }
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
            throw new ServletException(ex);
        } catch (SQLException ex) {
            throw new ServletException(ex);
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
