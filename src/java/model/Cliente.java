/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */

/*
package model;

import dao.ClienteDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente extends Usuario {

    private ArrayList<Comanda> historicoPedidos = new ArrayList<>();

    public Cliente(int id, String nome, String dataNascimento, String email, String telefone,String senha){
        super(id, nome, sobrenome, dataNascimento, email, telefone, senha);
    }
    
    public ArrayList<Comanda> getHistoricoPedidos() {
        return historicoPedidos;
    }

    public void setHistoricoPedidos(ArrayList<Comanda> historicoPedidos) {
        this.historicoPedidos = historicoPedidos;
    }
    
    // Métodos de comunicação com a camada DAO (Banco de dados)
    public static Cliente obterCliente (int idUsuario) 
    throws ClassNotFoundException, SQLException  
    {
        return ClienteDAO.obterCliente(idUsuario);
    }
    
    public static List<Cliente> obterClientes() throws ClassNotFoundException, SQLException {
        return ClienteDAO.obterClientes();
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        ClienteDAO.excluir(this);
    }
    
}
*/