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
import model.Estabelecimento;
/**
 *
 * @author Aaron
 */
public class EstabelecimentoDAO {
    
    public static Estabelecimento obterEstabelecimento(int codEstabelecimento) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Estabelecimento estabelecimento = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                "select * from cliente where codEstabelecimento = " + codEstabelecimento;
                rs.first();
                estabelecimento = instanciarEstabelecimento(rs);
            } finally {
                fecharConexao(conexao, comando);
            }
            return estabelecimento;
    }
    
    public static List<Estabelecimento> obterEstabelecimentos()
    throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();
        Estabelecimento estabelecimento = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from estabelecimento");
            while (rs.next()) {
                estabelecimento = instanciarEstabelecimento(rs);
                estabelecimentos.add(estabelecimento);                
            }
        }finally{
        fecharConexao(conexao, comando);
        }
        return estabelecimentos;
    }
}