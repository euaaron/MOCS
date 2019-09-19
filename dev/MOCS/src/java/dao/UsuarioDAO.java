/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
/**
 *
 * @author Débora e Aaron
 */
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
        List<Usuario> usuarios = new ArrayList<Usuario>();
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
    public static Usuario instanciarUsuario (ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario(rs.getInt("id"),
        rs.getString("nome"),
        rs.getString("sobrenome"), 
        rs.getString("dataNascimento"),
        rs.getString("email"),
        rs.getString("telefone")
        );
        return usuario;
    }
}
