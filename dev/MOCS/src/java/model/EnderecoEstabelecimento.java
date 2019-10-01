/**
 * Project MOCS
 * @version 0.19.8a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.EstabelecimentoDAO;
import java.sql.SQLException;

public class EnderecoEstabelecimento {
    
    private Estabelecimento estabelecimento;
    private int idUsuario;
    
    public void setEstabelecimento(Estabelecimento e){ this.estabelecimento = e;}
    
    public static Estabelecimento getEstabelecimento(int idEstabelecimento) 
    throws ClassNotFoundException, SQLException  
    {
        return EstabelecimentoDAO.obterEstabelecimento(idEstabelecimento);        
    }
}
