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
import model.Comanda;

/**
 *
 * @author Débora
 */
public class ComandaDAO {
    
    public static List<Comanda> obterPedido()
    throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Comanda> comandas = new ArrayList<Comanda>();
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
        Comanda comanda = new Comanda(rs.getInt("idComanda"),
        rs.getDate("data"),
        rs.getTime("hora"),
        null);
        return comanda;
    }
}
