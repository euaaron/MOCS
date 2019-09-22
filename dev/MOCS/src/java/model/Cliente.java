/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author euaar
 */
public class Cliente extends Usuario {
    private ArrayList<Comanda> historicoPedidos = new ArrayList<>();

    public Cliente(String nome, String sobrenome, String dataNascimento, String email, String telefone,String senha){
        super(nome,sobrenome,dataNascimento,email,telefone,senha);
    }
    
    public ArrayList<Comanda> getHistoricoPedidos() {
        return historicoPedidos;
    }

    public void setHistoricoPedidos(ArrayList<Comanda> historicoPedidos) {
        this.historicoPedidos = historicoPedidos;
    }
    
}
