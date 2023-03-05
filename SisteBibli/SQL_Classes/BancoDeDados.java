package SQL_Classes;
import java.sql.*;
public class BancoDeDados {//classe pra conexao do mysql
	private static String url = "jdbc:mysql://localhost:3306/BibliotecaBD";
	private static String user = "biblioteca_admin";
	private static String pass = "trabalho1";
	protected static Connection conexao = null;
	public BancoDeDados() {
		if(conexao==null) conecta();
	}
	private static boolean conecta() {
		try {
			conexao = DriverManager.getConnection(url,user,pass);
			return true;
		}	
		catch(SQLException e) {
			System.out.println("Ocorreu um erro no MYSQL");
			return false;
		}
	}
	public static boolean desconecta() {
		try {
			conexao.close();
			return true;
		}
		catch(SQLException e) {
			System.out.println("Ocorreu um erro com o MYSQL");
			return false;
		}
	}
	
}
