package SQL_Classes;
import java.sql.*;
import Bib_Object_Classes.*;
public class UsuarioDAO extends BancoDeDados{ // Data Object Access do usuario
	//lista todos os usuarios cadastrados
	public void listarUsuarios() {
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
			while(rs.next()) {
				System.out.println("Login: " + rs.getInt(1) + " Senha: " + rs.getInt(2) + " Multa: " + rs.getInt(3) );
				
			}
		}
		catch(SQLException e) {
			System.out.println("Ocorreu um erro no MYSQL ao listar os usuarios");
		}
	}
	//cadastra um usuario novo
	public boolean addUsuario(Usuario usuario) {
		try {
			if(usuario.getSenha()<0) {
				return false;//senha tem que ser maior que 0
			}
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO  usuarios VALUES (" + usuario.getLogin() +"," + usuario.getSenha() +"," + usuario.getMulta()+ ")";
			st.executeUpdate(sql);
			return true;
		}
		catch(SQLException e) {
			System.out.println("Ocorreu um erro no MYSQL ao adicionar um usuario, verifique se o usuario digitou a matrícula correta.");
			return false; 
		}
	}
	//busca um usuario e retorna ele
	public Usuario getUsuario(int login) {
		try {
			Statement st = conexao.createStatement();
			String sql = "SELECT * FROM usuarios WHERE login = " + login ;
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				return new Usuario(rs.getInt(1),rs.getInt(2),rs.getInt(3));
			}
			else return null;
		}
		catch( SQLException e){
			System.out.println("Ocorreu um erro no MYSQL ao pegar um usuario");
			return null;
		}
	}
	//remove um usuario cadastrado
	public boolean removeUsuario(int login) {
		try {
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM usuarios WHERE login = " +login;
			st.executeUpdate(sql);
			return true;
		}
		catch(SQLException e) {
			System.out.println("Ocorreu um erro no MYSQL ao remover um usuario, certifique-se que esse usuário não possua nenhum emprestimo pendente!");
			return false;
		}
	}
	//modifica a senha do usuario, o login dele nao pode ser modificado
	public boolean modificaUsuarioSenha(int login,int senhaNova) {
		try {
			if(senhaNova<0) {
				return false;//senha tem que ser maior que 0
			}
			Statement st = conexao.createStatement();
			String sql = "UPDATE usuarios SET senha =" + senhaNova +" WHERE login = " + login;
			st.executeUpdate(sql);
			return true;
		}
		catch(SQLException e) {
			System.out.println("Ocorreu um erro no MYSQL ao modificar uma senha");
			return false;
		}
	}
	//adiciona multa pra um usuario no banco
	public boolean addMulta(int login,int multa) {
		Usuario usuario = this.getUsuario(login);
		int multaAtual = usuario.getMulta();
		int multaNova = multa+multaAtual;
		if(multa<0 || multaAtual<0) {
			return false;
		}
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE usuarios SET multa =" + multaNova +" WHERE login = " + login;
			st.executeUpdate(sql);
			return true;
		}
		catch(SQLException e) {
			System.out.println("Ocorreu um erro no MYSQL ao adicionar uma multa");
			return false;
		}
	}
	//remove a multa de um usuario no banco
	public boolean resetaMulta(int login) {
		try {
			Usuario usuario = this.getUsuario(login);
			if(usuario==null) {
				return false;
			}
			Statement st = conexao.createStatement();
			String sql = "UPDATE usuarios SET multa = 0 WHERE login = " + login;
			st.executeUpdate(sql);
			return true;
		}
		catch(SQLException e) {
			System.out.println("Ocorreu um erro no MYSQL ao resetar uma multa");
			return false;
		}
	}
}
