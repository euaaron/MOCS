/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {
	public static Connection getConexao()
	    throws ClassNotFoundException, SQLException {
	        Connection conexao = null;
	        Class.forName("com.mysql.jdbc.Driver");
	        conexao = DriverManager.getConnection
	        ("jdbc:mysql://localhost:3306/mocs", "root", "");
	        return conexao;
	}
}