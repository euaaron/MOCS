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
import model.Prato;
/**
 * curso
 * @author Débora
 */
public class PratoDAO {
    public static Prato obterPrato(int idPrato) throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        Prato prato = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from prato where idPrato = " + idPrato);
        rs.first();
        prato = instanciarPrato(rs);
        }finally{
        fecharConexao(conexao, comando);
        }
        return prato;
    }
    public static List<Prato> obterPratos()
    throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Prato> pratos = new ArrayList<Prato>();
        Prato prato = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from prato");
            while (rs.next()) {
                prato = instanciarPrato(rs);
                pratos.add(prato);                
            }
        }finally{
        fecharConexao(conexao, comando);
        }
        return pratos;
    }
    
    public static Prato instanciarPrato(ResultSet rs) throws SQLException {
    Prato prato = new Prato(rs.getInt("idPrato"))
    }
}
