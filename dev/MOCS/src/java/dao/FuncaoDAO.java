package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Funcao;

public class FuncaoDAO {

    public static Funcao obterFuncao(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Funcao funcao = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                "select * from funcao where id = " + id);
                rs.first();
                funcao = instanciarFuncao(rs);
            } finally {
                fecharConexao(conexao, comando);
            }
            return funcao;
    }
    
    public static Funcao instanciarFuncao(ResultSet rs) 
    throws SQLException 
    {
        Funcao funcao = new Funcao(
                rs.getInt("id"),
                rs.getInt("idEstabelecimento"),
                rs.getString("nome"),
                rs.getString("descricao"),
                rs.getInt("nivelPermissao")
        );        
        return funcao;
    }

    public static List<Funcao> obterFuncoes() throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Funcao> lista = new ArrayList<>();
        Funcao obj = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from funcao");
            while (rs.next()) {
                obj = instanciarFuncao(rs);
                lista.add(obj);                
            }
        }finally{
        fecharConexao(conexao, comando);
        }
        return lista;
    }
    
    public static List<Funcao> obterFuncoesEstabelecimento(int idEstabelecimento) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Funcao> lista = new ArrayList<>();
        Funcao obj = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from funcao where idEstabelecimento = " + idEstabelecimento);
            while (rs.next()) {
                obj = instanciarFuncao(rs);
                lista.add(obj);                
            }
        }finally{
        fecharConexao(conexao, comando);
        }
        return lista;
    }

    public static void gravar(Funcao obj) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
            "insert into funcao (id, nome, descricao, nivelPermissao, idEstabelecimento)"
            + "values(?,?,?,?,?)");
            comando.setInt(1, obj.getId());
            comando.setString(2, obj.getNome());
            comando.setString(3, obj.getDescricao());
            comando.setInt(4, obj.getNivelPermissao());
            comando.setInt(5, obj.getIdEstabelecimento());
            comando.executeUpdate();
        }finally{
            fecharConexao(conexao, comando);
        }
    }

    public static void editar(Funcao obj) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
            "update table funcao (nome, descricao, nivelPermissao)"
            + "values(?,?,?,?,?,?) where id =? and idEstabelecimento=?");
            
            comando.setInt(1, obj.getId());
            comando.setString(2, obj.getNome());
            comando.setString(3, obj.getDescricao());
            comando.setInt(4, obj.getNivelPermissao());
            comando.setInt(5, obj.getIdEstabelecimento());
            comando.executeUpdate();
            
            DAO.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            throw e;
        }       
    }

    public static void excluir(Funcao obj) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from funcao where id = "
                    + obj.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
}
