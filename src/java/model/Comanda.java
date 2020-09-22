/**
 * 
 * @project Project MOCS
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.ComandaDAO;
import dao.PedidoDAO;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Comanda {
    private int id;
    private String data;
    private String hora;
    private Usuario cliente = null;
    private int idCliente;
    
    public Comanda(int id, String dataComanda, String horaComanda, int idCliente)
    {
        this.data = dataComanda;       // O Marco pediu para não trabalharmos com
        this.hora = horaComanda;       // data e hora no momento... apenas com
        this.idCliente = idCliente;           // atributos básicos, como int, string e float.
        this.id = id;
    } 

// Métodos de inserção (Modificação)
    public void setId(int id) { this.id = id; }
    public void setData(String dataComanda) { this.data = dataComanda; }
    public void setHora(String horaComanda) { this.hora = horaComanda; }
    public void setCliente(Usuario cliente) { this.cliente = cliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    
// Métodos de Recuperação (Leitura)    
    public int getId() { return id; }
    public String getData() { return data; }
    public String getHora() { return hora; }
    public int getIdCliente() { return idCliente; }
    public Usuario getCliente() 
    throws ClassNotFoundException, SQLException 
    {
        if ((idCliente != 0) && (cliente == null)) 
        { cliente = Usuario.obterUsuario(idCliente); }
        return cliente;
    }
    
// Métodos de comunicação com a camada DAO (Banco de dados)
    public static Comanda obterComanda (int idComanda) 
    throws ClassNotFoundException, SQLException  
    { return ComandaDAO.obterComanda(idComanda); }
    
    public float obterTotal() throws ClassNotFoundException, SQLException {
        List<Pedido> pedidos = Pedido.obterPedidos();
        float total = 0;
        for(int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            if(pedido.getIdComanda() == this.id) {
                total += pedido.getQuantidade() * Prato.obterPrato(pedido.getIdPrato()).getPreco();
            }
        }
        return total;
    }
    
    public int numPedidos() throws ClassNotFoundException, SQLException {
        List<Pedido> pedidos = Pedido.obterPedidos();
        int cont = 0;
        for(int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            if(pedido.getIdComanda() == this.id) {
                cont++;
            }
        }
        return cont;
    }
    
    public static List<Comanda> obterComandas()
    throws ClassNotFoundException, SQLException 
    { return ComandaDAO.obterComandas(); }
    
// Métodos de comunicação com a camada DAO (Banco de dados)
    public Usuario obterCliente() 
    throws ClassNotFoundException, SQLException 
    { return Usuario.obterUsuario(idCliente); }
    
    public void gravar() 
    throws SQLException, ClassNotFoundException 
    { ComandaDAO.gravar(this); }
    
    public void editar() 
    throws SQLException, ClassNotFoundException 
    { ComandaDAO.editar(this); }
    
    public void excluir() 
    throws ClassNotFoundException, SQLException 
    { ComandaDAO.excluir(this); }
}
