/**
 * Project MOCS
 * @version 0.19.7a
 * @authors Débora Lessa & Aaron Stiebler
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {
	public static Connection getConexao()
	    throws ClassNotFoundException, SQLException {
	        Connection conexao = null;
	        Class.forName("com.mysql.jdbc.Driver");
	        conexao = DriverManager.getConnection
	        ("jdbc:mysql://us-cdbr-east-02.cleardb.com:3306/heroku_7a4577ab47d8311", "bca155c03404d0", "e9df31ce");
	        return conexao;
	}
        
        public static void fecharConexao
            (Connection conexao, Statement comando)
                    throws SQLException{
                if(comando != null){
                comando.close();
                }
                if(conexao != null){
                conexao.close();
                }
            }
}
