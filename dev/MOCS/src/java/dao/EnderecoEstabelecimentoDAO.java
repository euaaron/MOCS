/**
 * Project MOCS
 * @version 0.19.8a
 * @authors Débora Lessa & Aaron Stiebler
 */
package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.EnderecoEstabelecimento;

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

    public static void gravar(EnderecoEstabelecimento comanda) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into endestabelecimento (id, data, hora, usuario_id)"
                    + " values (?,?,?,?)"
            );
            comando.setInt(1, comanda.getId());
            comando.setString(2, comanda.getDataComanda());
            comando.setString(3, comanda.getHoraComanda());
            comando.setInt(4, comanda.getIdCliente());
            comando.executeUpdate();
        } finally {
        fecharConexao(conexao, comando);
        }
    }
    
    
}
