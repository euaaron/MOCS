/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Débora
 */
public class Comanda {
    private int idComanda;
    private ArrayList<Pedido> listaPedidos;
    private Date dataComanda;
    private Time horaComanda;
    private Cliente cliente;
    
    Comanda(int idComanda, Date dataComanda, Time horaComanda, ArrayList<Pedido> listaPedidos, Cliente cliente){
        this.dataComanda = dataComanda;
        this.horaComanda = horaComanda;
        this.idComanda = idComanda;
        listaPedidos = new ArrayList<Pedido>();
        this.listaPedidos = listaPedidos;
        this.cliente = cliente;
    }
    
    /**
     * @return the id
     */
    public int getIdComanda() {
        return idComanda;
    }

    /**
     * @param id the id to set
     */
    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() throws ClassNotFoundException, SQLException {
        if((this.))
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
