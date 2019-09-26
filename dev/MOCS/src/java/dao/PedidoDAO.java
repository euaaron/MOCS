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
import model.Pedido;

public class PedidoDAO {
    public static Pedido obterPedido(int codPedido) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Pedido pedido = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                "select * from pedido where id = " + codPedido);
                rs.first();
                pedido = instanciarCliente(rs);
            } finally {
                fecharConexao(conexao, comando);
            }
            return pedido;
    }
    
    public static List<Pedido> obterClientes()
    throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Pedido> pedidos = new ArrayList<>();
        Pedido pedido = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from cliente");
            while (rs.next()) {
                pedido = instanciarCliente(rs);
                pedidos.add(pedido);                
            }
        }finally{
        fecharConexao(conexao, comando);
        }
        return pedidos;
    }
    public static Pedido instanciarCliente(ResultSet rs) throws SQLException {
        Pedido pedido = new Pedido(null,
                rs.getInt("qnt")
        );
        pedido.setId(rs.getInt("id"));
        return pedido;
    }
}