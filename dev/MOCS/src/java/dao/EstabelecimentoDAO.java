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
    
    public static Estabelecimento obterEstabelecimento(int cnpj) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Estabelecimento estabelecimento = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                "select * from estabelecimento where cnpj = " + cnpj);
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

    private static Estabelecimento instanciarEstabelecimento(ResultSet rs) throws SQLException {
        Estabelecimento estabelecimento = new Estabelecimento(
            null,
            rs.getString("cnpj"),
            rs.getString("razaoSocial"),
            rs.getString("nomeFantasia"),
            rs.getString("inscEstadual"),
            rs.getString("contato"),
            rs.getString("logradouro"),
            rs.getString("numEd"),
            rs.getString("bairro"),
            rs.getString("estado"),
            rs.getString("cidade"),
            rs.getString("cep"),
            rs.getString("fone"),
            rs.getString("fax"),
            rs.getString("email")        
        );
        return estabelecimento;
    }
}
