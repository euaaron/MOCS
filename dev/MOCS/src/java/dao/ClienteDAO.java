/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
/*
package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class ClienteDAO {
    
    public static Usuario obterCliente(int codCliente) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Usuario usuario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                "select * from cliente where id = " + codCliente);
                rs.first();
                usuario = instanciarCliente(rs);
            } finally {
                fecharConexao(conexao, comando);
            }
            return usuario;
    }
    
    public static List<Usuario> obterClientes()
    throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Usuario> clientes = new ArrayList<>();
        Usuario cliente = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from usuario ORDER BY id ASC");
            while (rs.next()) {
                cliente = instanciarCliente(rs);
                clientes.add(cliente);                
            }
        }finally{
        fecharConexao(conexao, comando);
        }
        return clientes;
    }
    public static Usuario instanciarCliente(ResultSet rs) throws SQLException {
        Usuario cliente = new Usuario(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("nascimento"),
                rs.getString("email"),
                rs.getString("telefone"),
                rs.getString("senha")
        );
        return cliente;
    }
}
*/