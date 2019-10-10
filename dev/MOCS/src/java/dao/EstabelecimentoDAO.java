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
import model.Estabelecimento;

public class EstabelecimentoDAO {
    
    public static Estabelecimento obterEstabelecimento(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Estabelecimento estabelecimento = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                "select * from estabelecimento where id = " + id);
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
        List<Estabelecimento> estabelecimentos = new ArrayList<>();
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
            rs.getString("nomeFantasia"),
            rs.getString("inscEstadual"),
            rs.getString("fone")                
        );
        return estabelecimento;
    }
    public static void gravar(Estabelecimento estabelecimento) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement (
            "insert into estabelecimento (id, usuario_id, cnpj, nomeFantasia, inscEstadual, telefone)"
                    + "values (?,?,?,?,?,?)"
            );
            comando.setInt(1, estabelecimento.getId());
            comando.setInt(2, estabelecimento.getIdProprietario());
            comando.setString(3, estabelecimento.getCnpj());
            comando.setString(4, estabelecimento.getNomeFantasia());
            comando.setString(5, estabelecimento.getInscEstadual());
            comando.setString(6, estabelecimento.getTelefone());
            comando.executeUpdate();
        }finally{
            fecharConexao(conexao, comando);
        }
    }
}
