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
	        ("jdbc:mysql://sq65ur5a5bj7flas.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/j1yu29pb4v70bbwl", "sd1bz3exwd3x8dm6", "x6762w08vt0e5jwl");
	        return conexao;
	}
}