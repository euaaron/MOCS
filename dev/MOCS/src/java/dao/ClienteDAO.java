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
import model.Cliente;

public class ClienteDAO {
    
    public static Cliente obterCliente(int codCliente) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Cliente cliente = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                "select * from cliente where id = " + codCliente);
                rs.first();
                cliente = instanciarCliente(rs);
            } finally {
                fecharConexao(conexao, comando);
            }
            return cliente;
    }
    
    public static List<Cliente> obterClientes()
    throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from cliente");
            while (rs.next()) {
                cliente = instanciarCliente(rs);
                clientes.add(cliente);                
            }
        }finally{
        fecharConexao(conexao, comando);
        }
        return clientes;
    }
    public static Cliente instanciarCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("sobrenome"),
                rs.getString("nascimento"),
                rs.getString("email"),
                rs.getString("telefone"),
                rs.getString("senha")
        );
        return cliente;
    }
}
