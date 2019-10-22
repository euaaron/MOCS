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
        Prato prato = new Prato(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("descricao"),
                rs.getString("dataCriacao"),
                rs.getInt("idFuncionario"),
                rs.getInt("idEstabelecimento")
        );
        return prato;
    }
    
    public static void gravar(Prato prato) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into prato (id, nome, descricao, dataCriacao, funcionario_id, estabelecimento_id)"
            + "values (?,?,?,?,?,?)");
            comando.setInt(1, prato.getId());
            comando.setString(2, prato.getNome());
            comando.setString(3, prato.getDescricao());
            comando.setString(4, prato.getDataCriacao());
            comando.setInt(5, prato.getIdFuncionario());
            comando.setInt(6, prato.getIdEstabelecimento());
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
            stringSQL = "delete from prato where id = "
                    + prato.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}
