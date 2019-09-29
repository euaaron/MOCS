/**
 * Project MOCS
 *
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

public class Pedido {

    private int id;
    private Prato prato;
    private int quantidade;

    public Pedido(Prato prato, int quantidade) {
        this.prato = prato;
        this.quantidade = quantidade;
    }

//Métodos de inserção (Modificação)
    public void setId(int idPedido) { this.id = idPedido;   }
    public void setPrato(Prato prato) { this.prato = prato; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

// Métodos de Recuperação (Leitura)

    public int getId() { return id; }
    public Prato getPrato() { return prato; }
    public int getQuantidade() { return quantidade; }

}
