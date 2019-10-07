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
        Funcionario funcionario = new Funcionario(
            rs.getInt("idUsuario"),
            rs.getString("nome"), 
            rs.getString("dataNascimento"),
            rs.getString("email"),
            rs.getString("telefone"),
            rs.getString("senha"),
            null,
            rs.getString("cpf")
        );
        return funcionario;
    }
    public static void gravar(Funcionario funcionario) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into funcionario (id, nome, dataNascimento, email, telefone, senha, cpf, statusConta, idEstabelecimento, idFuncao)"
            + "values (?,?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, funcionario.getId());
            comando.setString(2, funcionario.getNome());
            comando.setString(3, funcionario.getDataNascimento());
            comando.setString(4, funcionario.getEmail());
            comando.setString(5, funcionario.getTelefone());
            comando.setString(6, funcionario.getSenha());
            comando.setString(7, funcionario.getCpf());
            comando.setBoolean(8, funcionario.getStatusConta());
            comando.setInt(9, funcionario.getIdEstabelecimento());
            comando.setInt(10, funcionario.getIdFuncao());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}
