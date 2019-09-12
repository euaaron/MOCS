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
}
