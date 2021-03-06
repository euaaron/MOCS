/**
 * Project MOCS
 * @version 0.19.8a
 * @authors Débora Lessa & Aaron Stiebler
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Endereco;
import model.EnderecoUsuario;

public class EnderecoUsuarioDAO {
    
/**
*   Tratamento de Enderecos de
*   USUARIO
*/
   
    public static EnderecoUsuario obterEnderecoPadrao(int idUsuario) 
    throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        EnderecoUsuario endereco = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                "select * from endusuario where usuario_id = " 
                        + idUsuario 
                        + " AND padrao = 1");
                rs.first();
                endereco = instanciarEnderecoUsuario(rs);
            } catch (SQLException ex) {
            throw new SQLException(ex);
        }  finally {
                BD.fecharConexao(conexao, comando);
            }
            return endereco;
    }
    
    public static EnderecoUsuario obterEnderecoUsuario(int idEndereco) 
    throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        EnderecoUsuario endereco = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                "select * from endusuario where id = " + idEndereco );
                rs.first();
                endereco = instanciarEnderecoUsuario(rs);
            } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
                BD.fecharConexao(conexao, comando);
            }
            return endereco;
    }
    
    public static List<EnderecoUsuario> obterEnderecosUsuario(int idUsuario)
    throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<EnderecoUsuario> enderecos = new ArrayList<>();
        EnderecoUsuario endereco = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from endereco where idUsuario = " + idUsuario);
            while (rs.next()) {
                endereco = instanciarEnderecoUsuario(rs);
                enderecos.add(endereco);                
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }  finally{
        BD.fecharConexao(conexao, comando);
        }
        return enderecos;
    }
    
    public static List<EnderecoUsuario> obterEnderecosUsuarios()
    throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<EnderecoUsuario> enderecos = new ArrayList<>();
        EnderecoUsuario endereco = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from endereco ORDER BY id ASC");
            while (rs.next()) {
                endereco = instanciarEnderecoUsuario(rs);
                enderecos.add(endereco);                
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally{
        BD.fecharConexao(conexao, comando);
        }
        return enderecos;
    }

    private static EnderecoUsuario instanciarEnderecoUsuario(ResultSet rs) 
    throws SQLException {
        EnderecoUsuario endereco = new EnderecoUsuario(
            rs.getInt("id"),
            rs.getString("cep"),
            rs.getString("bairro"),
            rs.getString("uf"),
            rs.getString("cidade"),
            rs.getString("logradouro"), 
            rs.getString("numEdificio"), 
            rs.getString("numComplemento"),
            rs.getInt("idUsuario"),
            rs.getBoolean("padrao")                
        );
        return endereco;
    }
    
    public static void gravar(Endereco endereco) 
    throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into endereco (id, cep, uf, cidade, logradouro, numEdificio, numComplemento)"
                    + " values (?,?,?,?)"
            );
            comando.setInt(1, endereco.getId());
            comando.setString(2, endereco.getCep());
            comando.setString(3, endereco.getUf());
            comando.setString(4, endereco.getCidade());
            comando.setString(5, endereco.getLogradouro());
            comando.setString(6, endereco.getEdificio());
            comando.setString(7, endereco.getCidade());
            comando.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
        BD.fecharConexao(conexao, comando);
        }
    }
    
    public static void editar(Endereco endereco) 
    throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "update endereco set cep = ?, uf = ?, cidade = ?, logradouro = ?, numEdificio = ?, numComplemento = ?"
            );
            
            comando.setString(1, endereco.getCep());
            comando.setString(2, endereco.getUf());
            comando.setString(3, endereco.getCidade());
            comando.setString(4, endereco.getLogradouro());
            comando.setString(5, endereco.getEdificio());
            comando.setString(6, endereco.getCidade());
            comando.setInt(7, endereco.getId());
            comando.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
        BD.fecharConexao(conexao, comando);
        }
    }
    
    public static void excluir(EnderecoUsuario e) 
    throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from endusuario where id = "
                    + e.getId();
            comando.execute(stringSQL);
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }
    
}
