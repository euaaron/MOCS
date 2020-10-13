/**
 * Project MOCS
 * @version 0.19.7a
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
import model.Pedido;

public class PedidoDAO {
    public static Pedido obterPedido(int codPedido)
    throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Pedido pedido = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                "select * from pedido where id = " + codPedido);
                rs.first();
                pedido = instanciarPedido(rs);
            } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
                BD.fecharConexao(conexao, comando);
            }
            return pedido;
    }
    
    public static List<Pedido> obterPedidos()
    throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Pedido> pedidos = new ArrayList<>();
        Pedido pedido = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from pedido ORDER BY idComanda ASC");
            while (rs.next()) {
                pedido = instanciarPedido(rs);
                pedidos.add(pedido);                
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally{
        BD.fecharConexao(conexao, comando);
        }
        return pedidos;
    }
    
    public static List<Pedido> obterPedidosComanda(int idComanda)
    throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Pedido> pedidos = new ArrayList<>();
        Pedido pedido = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from pedido where idComanda = " + idComanda);
            while (rs.next()) {
                pedido = instanciarPedido(rs);
                pedidos.add(pedido);                
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally{
        BD.fecharConexao(conexao, comando);
        }
        return pedidos;
    }
    /*
    public static float valorPedidosComanda(int idComanda)
    throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        float total = 0;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery(
            "SELECT SUM(pe.quantidade * pa.preco) total FROM pedido pe JOIN comanda c ON pe.idComanda = c.id AND c.id = " + idComanda +" JOIN prato pa ON pa.id = pe.idPrato GROUP BY c.id");
        total = rs.getFloat("total");         
        }finally{
        fecharConexao(conexao, comando);
        }
        return total;
    }*/
    
    public static Pedido instanciarPedido(ResultSet rs) 
    throws SQLException {
        Pedido pedido = new Pedido(
                rs.getInt("id"),
                rs.getInt("idPrato"),
                rs.getInt("quantidade"),
                rs.getInt("idComanda")
        );
        return pedido;
    }
    
    public static void gravar(Pedido pedido) 
    throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into pedido (id, idPrato, quantidade, idComanda) "
            + "values(?,?,?,?)");
            comando.setInt(1, pedido.getId());
            comando.setInt(2, pedido.getIdPrato());
            comando.setInt(3, pedido.getQuantidade());
            comando.setInt(4, pedido.getIdComanda());
            comando.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }
    
    public static void editar(Pedido pedido) 
    throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                "update pedido set idPrato = ?, quantidade = ?, idComanda = ?"
              + " WHERE id = ?");
            
            comando.setInt(1, pedido.getIdPrato());
            comando.setInt(2, pedido.getQuantidade());
            comando.setInt(3, pedido.getIdComanda());
            comando.setInt(4, pedido.getId());
            comando.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }
    
    public static void excluir(Pedido pedido) 
    throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from pedido where id = "
                    + pedido.getId();
            comando.execute(stringSQL);
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }
}