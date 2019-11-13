/**
 * Project MOCS
 *
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
import model.Usuario;

public class UsuarioDAO {

    public static Usuario obterUsuario(int idUsuario)
            throws ClassNotFoundException, SQLException {
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
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM usuario ORDER BY id asc");
            while (rs.next()) {
                usuario = instanciarUsuario(rs);
                usuarios.add(usuario);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return usuarios;
    }

    public static Usuario instanciarUsuario(ResultSet rs)
            throws SQLException {
        Usuario usuario = new Usuario(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("dataNascimento"),
                rs.getString("email"),
                rs.getString("telefone"),
                rs.getString("senha"),
                rs.getString("cpf")
        );
        return usuario;
    }

    public static void gravar(Usuario usuario)
            throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into usuario (id, nome, cpf, dataNascimento, email, telefone, senha)"
                    + "values(?,?,?,?,?,?,?)");
            comando.setInt(1, usuario.getId());
            comando.setString(2, usuario.getNome());
            comando.setString(3, usuario.getCpf());
            comando.setString(4, usuario.getDataNascimento());
            comando.setString(5, usuario.getEmail());
            comando.setString(6, usuario.getTelefone());
            comando.setString(7, usuario.getSenha());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void editar(Usuario obj)
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "update usuario set nome = ?, dataNascimento = ?, email = ?, telefone = ?, senha = ?, cpf = ?"
                    + " where id = ?");

            comando.setString(1, obj.getNome());
            comando.setString(2, obj.getDataNascimento());
            comando.setString(3, obj.getEmail());
            comando.setString(4, obj.getTelefone());
            comando.setString(5, obj.getSenha());
            comando.setString(6, obj.getCpf());
            comando.setInt(7, obj.getId());

            comando.executeUpdate();
            fecharConexao(conexao, comando);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Usuario usuario)
            throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from usuario where id = "
                    + usuario.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

}
