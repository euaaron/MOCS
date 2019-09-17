/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Débora
 */
public class Comanda {
    private int idComanda;
    private ArrayList<Prato> listaPedidos = new ArrayList<Prato>();
    private Date data;
    private Time hora;
    
    Comanda(Date data, Time hora){
        this.data = data;
        this.hora = hora;
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
     * @return the listaPedidos
     */
    public ArrayList<Prato> getListaPedidos() {
        return listaPedidos;
    }

    /**
     * @param listaPedidos the listaPedidos to set
     */
    public void setListaPedidos(ArrayList<Prato> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
    
}
