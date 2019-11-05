/**
 * 
 * @project Project MOCS
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.ComandaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Comanda {
    private int id;
    private String dataComanda;
    private String horaComanda;
    private Usuario cliente = null;
    private int idCliente;
    
    public Comanda(int id, String dataComanda, String horaComanda, int idCliente)
    {
        this.dataComanda = dataComanda;       // O Marco pediu para não trabalharmos com
        this.horaComanda = horaComanda;       // data e hora no momento... apenas com
        this.idCliente = idCliente;           // atributos básicos, como int, string e float.
        this.id = id;
    } 

// Métodos de inserção (Modificação)
    public void setId(int id) { this.id = id; }
    public void setDataComanda(String dataComanda) { this.dataComanda = dataComanda; }
    public void setHoraComanda(String horaComanda) { this.horaComanda = horaComanda; }
    public void setCliente(Usuario cliente) { this.cliente = cliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    
// Métodos de Recuperação (Leitura)    
    public int getId() { return id; }
    public String getDataComanda() { return dataComanda; }
    public String getHoraComanda() { return horaComanda; }
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
