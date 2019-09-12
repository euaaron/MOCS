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
    private int id;
    private ArrayList<Prato> listaPedidos = new ArrayList<Prato>();
    private Date data;
    private Time hora;
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
