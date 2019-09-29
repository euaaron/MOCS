/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioDAO {
    
    public static Usuario obterUsuario(int idUsuario) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Usuario usuario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                "select * from usuario where id = " + idUsuario);
                rs.first();
                usuario = instanciarUsuario(rs);
            } finally {
                fecharConexao(conexao, comando);
            }
            return usuario;
    }
    
    public static List<Usuario> obterUsuarios()
    throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from usuario");
            while (rs.next()) {
                usuario = instanciarUsuario(rs);
                usuarios.add(usuario);                
            }
        }finally{
        fecharConexao(conexao, comando);
        }
        return usuarios;
    }
    public static Usuario instanciarUsuario(ResultSet rs) 
    throws SQLException 
    {
        Usuario usuario = new Usuario(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("sobrenome"),
                rs.getString("nascimento"),
                rs.getString("email"),
                rs.getString("telefone"),
                rs.getString("senha")
        );
        EnderecoDAO.instanciarEnderecoUsuario(
            rs.getInt("id"),
            rs.getString("cep"), 
            rs.getString("uf"),
            rs.getString("cidade"),
            rs.getString("logradouro"), 
            rs.getString("numEdificio"), 
            rs.getString("numComplemento")
        );
        
        return usuario;
    }
}
