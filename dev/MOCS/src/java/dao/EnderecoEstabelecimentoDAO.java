/**
 * Project MOCS
 * @version 0.19.8a
 * @authors Débora Lessa & Aaron Stiebler
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Endereco;
import model.EnderecoEstabelecimento;
import model.EnderecoUsuario;

public class EnderecoEstabelecimentoDAO {

    public static List<EnderecoEstabelecimento> obterEnderecos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static EnderecoEstabelecimento obterEndereco(int idEstabelecimento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static EnderecoEstabelecimento instanciarEnderecoEstabelecimento(ResultSet rs) throws SQLException {
        EnderecoEstabelecimento endereco = new EnderecoEstabelecimento(
            rs.getInt("id"),
            rs.getString("cep"),
            rs.getString("uf"),
            rs.getString("cidade"),
            rs.getString("logradouro"),
            rs.getString("bairro"),
            rs.getString("numEdificio"), 
            rs.getString("numComplemento"),
            rs.getInt("estabelecimento_id")             
        );
        return endereco;
    }

    
    
}
