/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Endereco;

public class EnderecoDAO {
        
// Tratamento Global de Enderecos
    public static Endereco obterEndereco(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Endereco endereco = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                "select * from estabelecimento where id = " + id);
                rs.first();
                endereco = instanciarEndereco(rs);
            } finally {
                fecharConexao(conexao, comando);
            }
            return endereco;
    }
    
    public static List<Endereco> obterEnderecos()
    throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Endereco> enderecos = new ArrayList<>();
        Endereco endereco = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from endereco");
            while (rs.next()) {
                endereco = instanciarEndereco(rs);
                enderecos.add(endereco);                
            }
        }finally{
        fecharConexao(conexao, comando);
        }
        return enderecos;
    }

    private static Endereco instanciarEndereco(ResultSet rs) throws SQLException {
        Endereco endereco = new Endereco(
            rs.getInt("id"),
            rs.getString("cep"),
            rs.getString("bairro"),
            rs.getString("uf"),
            rs.getString("cidade"),
            rs.getString("logradouro"), 
            rs.getString("numEdificio"), 
            rs.getString("numComplemento"),
            rs.getInt("idResidencia"),
            rs.getBoolean("tipo")
        );
        return endereco;
    }
    
/**
*   Tratamento de Enderecos de
*   USUARIO
*/
    public static Endereco obterEnderecoUsuario(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Endereco endereco = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                "select * from estabelecimento where cnpj = " + id);
                rs.first();
                endereco = instanciarEndereco(rs);
            } finally {
                fecharConexao(conexao, comando);
            }
            return endereco;
    }
    
    public static List<Endereco> obterEnderecosUsuario(int idUsuario)
    throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Endereco> enderecos = new ArrayList<>();
        Endereco endereco = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from endereco where idUsuario = " + idUsuario);
            while (rs.next()) {
                endereco = instanciarEndereco(rs);
                enderecos.add(endereco);                
            }
        }finally{
        fecharConexao(conexao, comando);
        }
        return enderecos;
    }

    private static Endereco instanciarEnderecoUsuario(ResultSet rs) throws SQLException {
        Endereco endereco = new Endereco(
            rs.getInt("id"),
            rs.getString("cep"),
            rs.getString("bairro"),
            rs.getString("uf"),
            rs.getString("cidade"),
            rs.getString("logradouro"), 
            rs.getString("numEdificio"), 
            rs.getString("numComplemento"),
            rs.getInt("idResidencia"),
            rs.getBoolean("tipo")                
        );
        return endereco;
    }
    
    public static void gravar(Endereco endereco) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into endereco (id, cep, uf, cidade, logradouro, numResidencia, numComplemento)"
                    + " values (?,?,?,?)"
            );
            comando.setInt(1, endereco.getId());
            comando.setString(2, endereco.getCep());
            comando.setString(3, endereco.getUf());
            comando.setString(4, endereco.getCidade());
            comando.setString(5, endereco.getLogradouro());
            comando.setString(6, endereco.getResidencia());
            comando.setString(7, endereco.getCidade());
            comando.executeUpdate();
        } finally {
        fecharConexao(conexao, comando);
        }
    }
    
    
}
