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
import model.Prato;

public class PratoDAO {
    public static Prato obterPrato(int idPrato) 
        throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        Prato prato = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from prato where id = " + idPrato);
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
        ResultSet rs = comando.executeQuery("select * from prato ORDER BY id asc");
            while (rs.next()) {
                prato = instanciarPrato(rs);
                pratos.add(prato);                
            }
        }finally{
        fecharConexao(conexao, comando);
        }
        return pratos;
    }
    
    public static Prato instanciarPrato(ResultSet rs) 
        throws SQLException, ClassNotFoundException {
        Prato prato = new Prato(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("descricao"),
                rs.getFloat("preco"),
                rs.getString("imagemUrl"),
                rs.getString("dataCriacao"),
                rs.getInt("idFuncionario"),
                rs.getInt("idEstabelecimento"),
                rs.getInt("exibir")
        );
        return prato;
    }
    
    public static void gravar(Prato prato) 
        throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
              "insert into prato (id, nome, descricao, preco, imagemUrl, "
            + "dataCriacao, idFuncionario, idEstabelecimento, exibir) "
            + "values (?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, prato.getId());
            comando.setString(2, prato.getNome());
            comando.setString(3, prato.getDescricao());
            comando.setFloat(4, prato.getPreco());
            comando.setString(5, prato.getImagemUrl());
            comando.setString(6, prato.getDataCriacao());
            comando.setInt(7, prato.getIdFuncionario());
            comando.setInt(8, prato.getIdEstabelecimento());
            comando.setInt(9, prato.getExibir());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void editar(Prato prato) 
        throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
              "update prato set nome = ?, descricao = ?, "
            + "preco = ?, imagemUrl = ?, dataCriacao = ?, "
            + "idFuncionario = ?, idEstabelecimento = ?, exibir = ? "
            + "WHERE id = ?");
            
            comando.setString(1, prato.getNome());
            comando.setString(2, prato.getDescricao());
            comando.setFloat(3, prato.getPreco());
            comando.setString(4, prato.getImagemUrl());
            comando.setString(5, prato.getDataCriacao());
            comando.setInt(6, prato.getIdFuncionario());
            comando.setInt(7, prato.getIdEstabelecimento());
            comando.setInt(8, prato.getExibir());
            comando.setInt(9, prato.getId());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void excluir(Prato prato) 
        throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "DELETE FROM prato WHERE id = "
                    + prato.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}
