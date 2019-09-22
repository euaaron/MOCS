/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

class Pedido {
    private int idPedido;
    private Prato prato;
    private int quantidade;
    
    Pedido(Prato prato, int quantidade){
    this.prato = prato;
    this.quantidade = quantidade;
    }
    /**
     * @return the idPedido
     */
    public int getIdPedido() {
        return idPedido;
    }

    /**
     * @param idPedido the idPedido to set
     */
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * @return the prato
     */
    public Prato getPrato() {
        return prato;
    }

    /**
     * @param prato the prato to set
     */
    public void setPrato(Prato prato) {
        this.prato = prato;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
