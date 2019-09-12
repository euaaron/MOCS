/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author euaar
 */
public class Cliente extends Usuario {
    private ArrayList<Comanda> historicoPedidos = new ArrayList<Comanda>();

    /**
     * @return the historicoPedidos
     */
    public ArrayList<Comanda> getHistoricoPedidos() {
        return historicoPedidos;
    }

    /**
     * @param historicoPedidos the historicoPedidos to set
     */
    public void setHistoricoPedidos(ArrayList<Comanda> historicoPedidos) {
        this.historicoPedidos = historicoPedidos;
    }
    
}
