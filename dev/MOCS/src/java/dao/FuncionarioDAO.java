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
import model.Funcionario;

public class FuncionarioDAO {
    
    public static Funcionario obterFuncionario(int idUsuario) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Funcionario funcionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                "select * from funcionario where id = " + idUsuario);
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
        List<Funcionario> funcionarios = new ArrayList<>();
        Funcionario funcionario = null;
        try{
        conexao = BD.getConexao();
        comando = conexao.createStatement();
        ResultSet rs = comando.executeQuery("select * from funcionario ORDER BY id ASC");
            while (rs.next()) {
                funcionario = instanciarFuncionario(rs);
                funcionarios.add(funcionario);                
            }
        }finally{
        fecharConexao(conexao, comando);
        }
        return funcionarios;
    }
    
    public static Funcionario instanciarFuncionario (ResultSet rs) throws SQLException, ClassNotFoundException {
        Funcionario funcionario = new Funcionario(
            rs.getInt("id"),
            rs.getString("nome"), 
            rs.getString("dataNascimento"),
            rs.getString("email"),
            rs.getString("telefone"),
            rs.getString("senha"),
            rs.getString("cpf"),
            rs.getInt("statusConta"),
            rs.getInt("idEstabelecimento"),
            rs.getInt("idFuncao")
            
        );
        return funcionario;
    }
    public static void gravar(Funcionario funcionario) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
              "insert into usuario (id, nome, dataNascimento, email, telefone, senha, cpf)"
            + " values (?,?,?,?,?,?,?)");
            comando.setInt(1, funcionario.getId());
            comando.setString(2, funcionario.getNome());
            comando.setString(3, funcionario.getDataNascimento());
            comando.setString(4, funcionario.getEmail());
            comando.setString(5, funcionario.getTelefone());
            comando.setString(6, funcionario.getSenha());
            comando.setString(7, funcionario.getCpf());
            comando.executeUpdate();
            }finally{
            fecharConexao(conexao, comando);
        }
        try {
            conexao = BD.getConexao();            
            comando = conexao.prepareStatement(
              "insert into funcionario (id, nome, dataNascimento, email, telefone,"
            + " senha, cpf, statusConta, idEstabelecimento, idFuncao)"
            + " values (?,?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, funcionario.getId());
            comando.setString(2, funcionario.getNome());
            comando.setString(3, funcionario.getDataNascimento());
            comando.setString(4, funcionario.getEmail());
            comando.setString(5, funcionario.getTelefone());
            comando.setString(6, funcionario.getSenha());
            comando.setString(7, funcionario.getCpf());
            comando.setInt(8, funcionario.getStatusConta());
            comando.setInt(9, funcionario.getIdEstabelecimento());
            comando.setInt(10, funcionario.getIdFuncao());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void editar(Funcionario obj) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            comando = conexao.prepareStatement(
              "update usuario set nome = ?, dataNascimento = ?, email = ?,"
            + " telefone = ?, senha = ?, cpf =? WHERE id = ?");
            
            comando.setString(1, obj.getNome());
            comando.setString(2, obj.getDataNascimento());
            comando.setString(3, obj.getEmail());
            comando.setString(4, obj.getTelefone());
            comando.setString(5, obj.getSenha());
            comando.setString(6, obj.getCpf());
            comando.setInt(7, obj.getId());            
            comando.executeUpdate();
            
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
              "update funcionario set nome = ?, dataNascimento = ?, email = ?, telefone = ?, "
            + "senha = ?, cpf = ?, statusConta = ?, idEstabelecimento = ?, idFuncao = ?"
            + " WHERE id = ?");
            
            comando.setString(1, obj.getNome());
            comando.setString(2, obj.getDataNascimento());
            comando.setString(3, obj.getEmail());
            comando.setString(4, obj.getTelefone());
            comando.setString(5, obj.getSenha());
            comando.setString(6, obj.getCpf());
            comando.setInt(7, obj.getStatusConta());
            comando.setInt(8, obj.getIdEstabelecimento());
            comando.setInt(9, obj.getIdFuncao());
            comando.setInt(10, obj.getId());            
            comando.executeUpdate();
            
            fecharConexao(conexao, comando);
        } catch (SQLException e) {
            throw e;
        }       
    }
    
    public static void excluir(Funcionario usuario) 
            throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from funcionario where id = "
                    + usuario.getId();
            comando.execute(stringSQL);
            stringSQL = "delete from usuario where id = "
                    + usuario.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}
