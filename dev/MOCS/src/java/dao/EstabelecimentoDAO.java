/**
 * Project MOCS
 *
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package dao;

import static dao.BD.getConexao;
import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
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
            ResultSet rs = comando.executeQuery("select * from estabelecimento where id = " + id);
            rs.first();
            estabelecimento = instanciarEstabelecimento(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return estabelecimento;
    }

    public static List<Estabelecimento> obterEstabelecimentos()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();
        Estabelecimento estabelecimento = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery(
                    "select * from estabelecimento ORDER BY id ASC"
            );
            while (rs.next()) {
                estabelecimento = instanciarEstabelecimento(rs);
                estabelecimentos.add(estabelecimento);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return estabelecimentos;
    }
    /*
     public static List<Estabelecimento> obterEstabelecimentosProprietario(int idProprietario)
     throws ClassNotFoundException, SQLException {
     Connection conexao = null;
     Statement comando = null;
     List<Estabelecimento> estabelecimentos = new ArrayList<>();
     Estabelecimento estabelecimento = null;
     try {
     conexao = BD.getConexao();
     comando = conexao.createStatement();
     ResultSet rs = comando.executeQuery(
     "select * from estabelecimento where 'idProprietario' = "
     + idProprietario
     );
     while (rs.next()) {
     estabelecimento = instanciarEstabelecimento(rs);
     estabelecimentos.add(estabelecimento);
     }
     } finally {
     fecharConexao(conexao, comando);
     }
     return estabelecimentos;
     }
     */

    private static Estabelecimento instanciarEstabelecimento(ResultSet rs)
            throws SQLException, ClassNotFoundException {
        Estabelecimento estabelecimento = new Estabelecimento(
                rs.getInt("id"),
                rs.getString("cnpj"),
                rs.getString("nomeFantasia"),
                rs.getString("inscEstadual"),
                rs.getString("telefone"),
                null,
                null);
        estabelecimento.setIdProprietario(rs.getInt("idProprietario"));
        estabelecimento.setIdEndereco(rs.getInt("idEndereco"));
        return estabelecimento;
    }

    public static void gravar(Estabelecimento estabelecimento)
            throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into estabelecimento (id, idProprietario, cnpj, nomeFantasia, inscEstadual, telefone, idEndereco)"
                    + "values (?,?,?,?,?,?,?)"
            );
            comando.setInt(1, estabelecimento.getId());
            if (estabelecimento.getProprietario() == null) {
                comando.setNull(2, Types.INTEGER);
            } else {
                comando.setInt(2, estabelecimento.getProprietario().getId());
            }
            comando.setString(3, estabelecimento.getCnpj());
            comando.setString(4, estabelecimento.getNomeFantasia());
            comando.setString(5, estabelecimento.getInscEstadual());
            comando.setString(6, estabelecimento.getTelefone());
            if (estabelecimento.getEndereco() == null) {
                comando.setNull(7, Types.INTEGER);
            } else {
                comando.setInt(7, estabelecimento.getEndereco().getId());
            }
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void editar(Estabelecimento obj) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update estabelecimento set "
                    + "cnpj = '" + obj.getCnpj() + "', "
                    + "nomeFantasia = '" + obj.getNomeFantasia() + "', "
                    + "inscEstadual = '" + obj.getInscEstadual() + "', "
                    + "telefone = '" + obj.getTelefone() + "', "
                    + "idProprietario = ";
            if (obj.getProprietario() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + obj.getProprietario().getId();
            }
            
//            stringSQL = stringSQL + " idEndereco = ";
//            
//            if (obj.getEndereco() == null) {
//                stringSQL = stringSQL + null;
//            } else {
//                stringSQL = stringSQL + obj.getEndereco().getId();
//            }
            stringSQL = stringSQL + " where id = " + obj.getId();
            comando.execute(stringSQL);
            } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Estabelecimento e)
            throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from estabelecimento where id = "
                    + e.getId();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}
