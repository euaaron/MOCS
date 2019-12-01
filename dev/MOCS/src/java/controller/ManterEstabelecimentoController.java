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
import model.EnderecoEstabelecimento;
import model.Estabelecimento;
//import model.Proprietario;
import model.Usuario;

public class ManterEstabelecimentoController extends HttpServlet {

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
    
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("proprietarios", Usuario.obterUsuarios());
            if (!operacao.equals("Incluir")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Estabelecimento est = Estabelecimento.obterEstabelecimento(id);
                request.setAttribute("estabelecimento", est);
                
                int idProprietario = Integer.parseInt(request.getParameter("id"));
                Usuario proprietario = Usuario.obterUsuario(est.getProprietario().getId());
                request.setAttribute("proprietario", proprietario);
                
                int idEndereco = Integer.parseInt(request.getParameter("id"));
                EnderecoEstabelecimento end = EnderecoEstabelecimento.obterEndereco(est.getIdEndereco());
                request.setAttribute("endestabelecimento", end);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastrarEstabelecimento.jsp");
            view.forward(request, response);
        } catch (ServletException e){
            throw e;
        } catch (IOException e){
            throw new ServletException(e);
        }
    }
    
   public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) 
           throws ClassNotFoundException, SQLException, ServletException {
       
       String operacao = request.getParameter("operacao");
       //Dados de Estabelecimento
       int id = Integer.parseInt(request.getParameter("txtIdEstabelecimento"));
       int idProprietario = Integer.parseInt(request.getParameter("txtIdProprietario"));//Chave estrangeira
       String cnpj = request.getParameter("txtCnpj");
       String nomeFantasia = request.getParameter("txtNomeFantasia");
       String inscEstadual = request.getParameter("txtInscEstadual");
       String telefone = request.getParameter("txtTelefone");
       
       //Dados de Endereco
       int idEndereco = id;
       String cep = request.getParameter("txtCEP");
       String uf = request.getParameter("txtUF");
       String cidade = request.getParameter("txtCidade");
       String logradouro = request.getParameter("txtLogradouro");
       String bairro = request.getParameter("txtBairro");
       String numEdificio = request.getParameter("txtEdificio");
       String numComplemento = request.getParameter("txtComplemento");
       
       try {
           Usuario proprietario = null;
           if (idProprietario != 0) 
           { 
               proprietario = Usuario.obterUsuario(idProprietario); 
           }
           
           EnderecoEstabelecimento end = null;
           if (idEndereco != 0) 
           {                
                //end = EnderecoEstabelecimento.obterEndereco(idEndereco);
               
                end = new EnderecoEstabelecimento(idEndereco, cep, uf, cidade, 
                     logradouro, bairro, numEdificio, numComplemento);
           } 
           
           Estabelecimento e = new Estabelecimento(id, cnpj, nomeFantasia, inscEstadual,
            telefone, idProprietario, idEndereco);
           
           if (operacao.equals("Incluir")) {
               end.gravar();
               e.gravar();
           } else if (operacao.equals("Excluir")) {
               e.excluir();
               end.excluir();
            } else if (operacao.equals("Editar")) {
               e.editar();
               end.editar();
           }
           RequestDispatcher view = request.getRequestDispatcher("PesquisarEstabelecimentoController");
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterEstabelecimentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterEstabelecimentoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterEstabelecimentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterEstabelecimentoController.class.getName()).log(Level.SEVERE, null, ex);
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
