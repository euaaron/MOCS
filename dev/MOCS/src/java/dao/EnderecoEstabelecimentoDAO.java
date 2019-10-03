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

    public static void gravar(EnderecoEstabelecimento endestabelecimento) 
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                "insert into endestabelecimento (id, cep, uf, cidade,"
                + " logradouro, bairro, numEdificio, numComplemento, estabelecimento_id)"
                + " values (?,?,?,?,?,?,?,?,?)"
            );
            comando.setInt(1, endestabelecimento.getId());
            comando.setString(2, endestabelecimento.getCep());
            comando.setString(3, endestabelecimento.getUf());
            comando.setString(4, endestabelecimento.getCidade());
            comando.setString(5, endestabelecimento.getLogradouro());
            comando.setString(6, endestabelecimento.getBairro());
            comando.setString(7, endestabelecimento.getNumEdificio());
            comando.setString(8, endestabelecimento.getNumComplemento());
            comando.setInt(9, endestabelecimento.getIdEstabelecimento());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    
}
