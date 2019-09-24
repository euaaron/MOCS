/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.ClienteDAO;
import dao.ComandaDAO;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Comanda {
    private int id;
    private ArrayList<Pedido> listaPedidos;
    private String dataComanda;
    private String horaComanda;
    private Usuario cliente = null;
    private int idCliente;
    
    public Comanda(String dataComanda, String horaComanda, Cliente cliente){
        this.dataComanda = dataComanda;       // O Marco pediu para não trabalharmos com
        this.horaComanda = horaComanda;       // data e hora no momento... apenas com
        this.listaPedidos = new ArrayList<>();// atributos básicos, como int, string e float.
        this.idCliente = cliente.getId();
    } 

// Métodos de inserção (Modificação)
    public void setId(int id) { this.id = id; }
    public void setPedidos(ArrayList<Pedido> listaPedidos) { this.listaPedidos = listaPedidos; }
    public void setDataComanda(String dataComanda) { this.dataComanda = dataComanda; }
    public void setHoraComanda(String horaComanda) { this.horaComanda = horaComanda; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    
//Manipulação de pedidos
    public void addPedido(Pedido pedido) {
        listaPedidos.add(pedido);
    }
    public void removePedido(Pedido pedido) {
        listaPedidos.remove(pedido);
    }
    
// Métodos de Recuperação (Leitura)    
    public int getId() { return id; }
    public ArrayList<Pedido> getPedidos() { return listaPedidos; }
    public String getDataComanda() { return dataComanda; }
    public String getHoraComanda() { return horaComanda; }
    public int getIdCliente() { return idCliente; }
    public Usuario getCliente() throws ClassNotFoundException, SQLException {
        if ((this.idCliente != 0) && (this.cliente == null)) {
            this.cliente = Cliente.obterUsuario(this.idCliente);
        }
        return this.cliente;
    }
    // Métodos de comunicação com a camada DAO (Banco de dados)
    public static Comanda obterComanda (int idComanda) 
    throws ClassNotFoundException, SQLException  
    {
        return ComandaDAO.obterComanda(idComanda);
    }
    
    public static List<Comanda> obterComandas() throws ClassNotFoundException, SQLException {
        return ComandaDAO.obterComandas();
    }
    
// Métodos de comunicação com a camada DAO (Banco de dados)
    public Usuario obterCliente() throws ClassNotFoundException, SQLException {
        return ClienteDAO.obterCliente(idCliente);
    }
}
