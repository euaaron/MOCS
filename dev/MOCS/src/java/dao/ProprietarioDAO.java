/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import model.Proprietario;

/**
 *
 * @author Débora
 */
public class ProprietarioDAO {
    public static Proprietario obterProprietario(int idUsuario) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Proprietario proprietario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                "select * from proprietario where id = " + idUsuario);
                rs.first();
                proprietario = instanciarProprietario(rs);
            } finally {
                fecharConexao(conexao, comando);
            }
            return proprietario;
    }
    
    public static List<Proprietario> obterProprietarios()
    throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Proprietario> proprietarios = new ArrayList<>();
        Proprietario proprietario = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from proprietario");
            while (rs.next()) {
                proprietario = instanciarProprietario(rs);
                proprietarios.add(proprietario);                
            }
        }finally{
        fecharConexao(conexao, comando);
        }
        return proprietarios;
    }
    
    public static Proprietario instanciarProprietario(ResultSet rs) 
    throws SQLException 
    {
        Proprietario proprietario = new Proprietario(
            rs.getInt("idUsuario"),
            rs.getString("nome"),
            rs.getString("sobrenome"), 
            rs.getString("dataNascimento"),
            rs.getString("email"),
            rs.getString("telefone"),
            rs.getString("senha")
        );
        return proprietario;
    }
    
    public static void gravar(Proprietario proprietario) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
            "insert into usuario (id, nome, sobrenome, nascimento, email, telefone, senha)"
            + "values(?,?,?,?,?,?,?)");
            comando.setInt(1, proprietario.getId());
            comando.setString(2, proprietario.getNome());
            comando.setString(3, proprietario.getSobrenome());
            comando.setString(4, proprietario.getDataNascimento());
            comando.setString(5, proprietario.getEmail());
            comando.setString(6, proprietario.getTelefone());
            comando.setString(7, proprietario.getSenha());
            comando.executeUpdate();
        }finally{
            fecharConexao(conexao, comando);
        }
    }
    
}