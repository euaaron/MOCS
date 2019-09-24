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
import model.Comanda;
import model.Usuario;

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
        ResultSet rs = comando.executeQuery("select * from comanda");
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
        ResultSet rs = comando.executeQuery("select * from comanda where idComanda = " + idComanda);
        rs.first();
        comanda = instanciarComanda(rs);
        }finally{
        fecharConexao(conexao, comando);
        }
        return comanda;
    }
    
    public static Comanda instanciarComanda(ResultSet rs) throws SQLException {
        Comanda comanda = new Comanda(
            rs.getString("dataComanda"),
            rs.getString("horaComanda"),
            null);
        comanda.setId(rs.getInt("id"));
        comanda.setId(rs.getInt("idCliente"));
        return comanda;
    }
}
