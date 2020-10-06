package model;

/**
 *
 * @author aaron
 */
public enum FuncaoEnum {
    Diretor(0), Coordenar(1), Atendimento(2), Cozinha(3), Entrega(4);
    protected int nivel;
    
    FuncaoEnum(int nivel) {
        this.nivel = nivel;
    }
    
    public int getNivelPermissao() {
        return nivel;
    }
    
    public String getNome() {
        return this.name();
    }
    
}
