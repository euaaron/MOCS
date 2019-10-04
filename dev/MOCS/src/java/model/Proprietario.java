/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package model;

import dao.ProprietarioDAO;
import java.sql.SQLException;
import java.util.List;
 
public class Proprietario extends Usuario {

    public Proprietario(int id, String nome, String sobrenome, String dataNascimento, String email, String telefone, String senha, String cpf) {
        super(id, nome, sobrenome, dataNascimento, email, telefone, senha, cpf);
    }
    
    public static Proprietario obterProprietario(int idUsuario) throws ClassNotFoundException, SQLException {
        return ProprietarioDAO.obterProprietario(idUsuario);
    }
    
    public static List<Proprietario> obterProprietarios() throws ClassNotFoundException, SQLException {
        return ProprietarioDAO.obterProprietarios();
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        ProprietarioDAO.gravar(this);
    }
}
