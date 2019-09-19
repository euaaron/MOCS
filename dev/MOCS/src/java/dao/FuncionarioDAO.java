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
import model.Funcionario;

/**
 *
 * @author Aaron
 */
public class FuncionarioDAO {
    
    public static Funcionario obterFuncionario(int idFuncionario) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Funcionario funcionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                "select * from funcionario where id = " + idFuncionario);
                rs.first();
                funcionario = instanciarFuncionario(rs);
            } finally {
                fecharConexao(conexao, comando);
            }
            return funcionario;
    }
    
    public static List<Funcionario> obterFuncionarios()
    throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario funcionario = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from funcionario");
            while (rs.next()) {
                funcionario = instanciarFuncionario(rs);
                funcionarios.add(funcionario);                
            }
        }finally{
        fecharConexao(conexao, comando);
        }
        return funcionarios;
    }
    
    public static Funcionario instanciarFuncionario (ResultSet rs) throws SQLException {
        Funcionario funcionario = new Funcionario(rs.getInt("id"),
        rs.getString("nome"),
        rs.getString("sobrenome"), 
        rs.getString("dataNascimento"),
        rs.getString("email"),
        rs.getString("telefone"),
        null
        );
        return funcionario;
    }
}
