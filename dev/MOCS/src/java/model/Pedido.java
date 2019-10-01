/**
 * @title Projeto MOCS
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.ComandaDAO;
import dao.PedidoDAO;
import dao.PratoDAO;
import java.sql.SQLException;
import java.util.List;

public class Pedido {

    private int id;
    private int idComanda;
    private int idPrato;
    private int quantidade;
    private Prato prato;  
    private Comanda comanda = null;    

    public Pedido(int id, int idComanda, int idPrato, int quantidade) {
        this.id = id;
        this.idPrato = idPrato;
        this.quantidade = quantidade;
        this.idComanda = idComanda;
    }

//Métodos de inserção (Modificação)
    public void setId(int idPedido) { this.id = idPedido;   }
    public void setPrato(Prato prato) { this.prato = prato; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public void setIdComanda(int idComanda) { this.idComanda = idComanda; }
    public void setIdPrato(int idPrato) { this.idPrato = idPrato; }
    public void setComanda(int idComanda) { this.comanda = obterComanda(int idComanda); }

// Métodos de Recuperação (Leitura)
    public int getId() { return id; }
    public int getIdPrato() { return idPrato; }
    public int getIdComanda() { return idComanda; }    
    public Prato getPrato() { return prato; }
    public int getQuantidade() { return quantidade; }
    public Comanda getComanda() throws ClassNotFoundException, SQLException {
        if ((this.idComanda != 0) && (this.comanda == null)) {
            this.comanda = Comanda.obterComanda(this.idComanda);
        }
        return this.comanda;
    }

// Métodos de comunicação com a camada DAO (Banco de dados)
    public static Pedido obterPedido (int id) 
    throws ClassNotFoundException, SQLException  
    {
        return PedidoDAO.obterPedido(id);
    }
    
    public static List<Pedido> obterPedidos() throws ClassNotFoundException, SQLException 
    {
        return PedidoDAO.obterPedidos();
    }
    
    public static List<Pedido> obterPedidosComanda(int idComanda) throws ClassNotFoundException, SQLException 
    {
        return PedidoDAO.obterPedidosComanda(idComanda);
    }
    
    public Prato obterPrato(int idPrato) throws ClassNotFoundException, SQLException  
    {
        return PratoDAO.obterPrato(idPrato);
    }
    
    public Comanda obterComanda(int idComanda) throws ClassNotFoundException, SQLException  
    {
        return ComandaDAO.obterComanda(idComanda);
    }
}