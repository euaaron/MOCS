/**
 * Project MOCS
 * @version 0.19.8a
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
import model.EnderecoEstabelecimento;

public class EnderecoEstabelecimentoDAO {

    public static List<EnderecoEstabelecimento> obterEnderecos()
        throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<EnderecoEstabelecimento> enderecos = new ArrayList<>();
        EnderecoEstabelecimento endereco = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from endereco");
            while (rs.next()) {
                endereco = instanciarEnderecoEstabelecimento(rs);
                enderecos.add(endereco);                
            }
        }finally{
        fecharConexao(conexao, comando);
        }
        return enderecos;
    }

    public static EnderecoEstabelecimento obterEndereco(int idEndereco) 
        throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        EnderecoEstabelecimento obj = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                "SELECT * FROM endestabelecimento WHERE id = " + idEndereco);
                rs.first();
                obj = instanciarEnderecoEstabelecimento(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return obj;
    }
    
    public static EnderecoEstabelecimento obterEnderecoEstabelecimento(int idEstabelecimento) 
        throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        EnderecoEstabelecimento obj = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                "SELECT id, cep, uf, cidade, bairro, logradouro, numEdificio, numComplemento" + 
                " FROM endestabelecimento en" +
                " JOIN estabelecimento es ON en.id = " + idEstabelecimento +
                " AND es.id = " + idEstabelecimento);
                rs.first();
                obj = instanciarEnderecoEstabelecimento(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return obj;
    }
    
    private static EnderecoEstabelecimento instanciarEnderecoEstabelecimento(ResultSet rs) 
        throws SQLException {
        EnderecoEstabelecimento endereco = new EnderecoEstabelecimento(
            rs.getInt("id"),
            rs.getString("cep"),
            rs.getString("uf"),
            rs.getString("cidade"),
            rs.getString("logradouro"),
            rs.getString("bairro"),
            rs.getString("numEdificio"), 
            rs.getString("numComplemento")
        );
        return endereco;
    }

    public static void gravar(EnderecoEstabelecimento endestabelecimento) 
        throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                  "insert into endestabelecimento (id, cep, uf, cidade,"
                + " logradouro, bairro, numEdificio, numComplemento)"
                + " values (?,?,?,?,?,?,?,?,?)"
            );
            comando.setInt(1, endestabelecimento.getId());
            comando.setString(2, endestabelecimento.getCep());
            comando.setString(3, endestabelecimento.getUf());
            comando.setString(4, endestabelecimento.getCidade());
            comando.setString(5, endestabelecimento.getLogradouro());
            comando.setString(6, endestabelecimento.getBairro());
            comando.setString(7, endestabelecimento.getNumEdificio());
            comando.setString(8, endestabelecimento.getNumComplemento());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void editar(EnderecoEstabelecimento endestabelecimento) 
        throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                "UPDATE endestabelecimento set cep = ?, uf = ?, cidade = ?,"
                + " logradouro = ?, bairro = ?, numEdificio = ?, numComplemento = ? WHERE id = ?"
            );
            comando.setString(1, endestabelecimento.getCep());
            comando.setString(2, endestabelecimento.getUf());
            comando.setString(3, endestabelecimento.getCidade());
            comando.setString(4, endestabelecimento.getLogradouro());
            comando.setString(5, endestabelecimento.getBairro());
            comando.setString(6, endestabelecimento.getNumEdificio());
            comando.setString(7, endestabelecimento.getNumComplemento());
            comando.setInt(8, endestabelecimento.getId());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void excluir(EnderecoEstabelecimento e) 
        throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from endestabelecimento where id = "
                    + e.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    
}
