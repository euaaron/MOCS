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
import model.Comanda;

public class ComandaDAO {
    
    public static List<Comanda> obterComandas()
    throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Comanda> comandas = new ArrayList<>();
        Comanda comanda = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from comanda ORDER BY id ASC");
            while (rs.next()) {
                comanda = instanciarComanda(rs);
                comandas.add(comanda);                
            }
        }finally{
        fecharConexao(conexao, comando);
        }
        return comandas;
    }
    
    public static Comanda obterComanda(int idComanda) throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        Comanda comanda = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from comanda where id = " + idComanda);
        rs.first();
        comanda = instanciarComanda(rs);
        }finally{
        fecharConexao(conexao, comando);
        }
        return comanda;
    }
    
    public static Comanda instanciarComanda(ResultSet rs) throws SQLException {
        Comanda comanda = new Comanda(
            rs.getInt("id"),
            rs.getString("data"),
            rs.getString("hora"),
            rs.getInt("idCliente")
        );
        return comanda;
    }
    
    public static void gravar(Comanda comanda) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into comanda (id, data, hora, idCliente)"
                    + " values (?,?,?,?)"
            );
            comando.setInt(1, comanda.getId());
            comando.setString(2, comanda.getData());
            comando.setString(3, comanda.getHora());
            comando.setInt(4, comanda.getIdCliente());
            comando.executeUpdate();
        } finally {
        fecharConexao(conexao, comando);
        }
    }
    
    public static void editar(Comanda comanda) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "update comanda set data = ?, hora = ?, idCliente = ? where id = ?"
            );
            comando.setString(1, comanda.getData());
            comando.setString(2, comanda.getHora());
            comando.setInt(3, comanda.getIdCliente());
            comando.setInt(4, comanda.getId());
            comando.executeUpdate();
        } finally {
        fecharConexao(conexao, comando);
        }
    }
    
    public static void excluir(Comanda e) 
            throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from comanda where id = "
                    + e.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}
