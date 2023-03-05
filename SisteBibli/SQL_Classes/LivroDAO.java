package SQL_Classes;
import java.sql.*;
import Bib_Object_Classes.*;
public class LivroDAO extends BancoDeDados{ //Data Object Access do livro
	//lista todos os livros cadastrados
	public void listarLivros() {
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM livros");
			while(rs.next()) {
				System.out.println("ID: " + rs.getInt(1) + " TITULO: "+ rs.getString(2) + " EDITORA: " + rs.getString(3) + " AUTOR: " + rs.getString(4) + " ANO DE PUBLICAÇÃO: "  + rs.getInt(5) + " DESCRIÇÃO: " + rs.getString(6) + " NÚMERO DE EXEMPLARES: " + rs.getInt(7) + " TIPO: "+ rs.getString(8));
				
			}
		}
		catch(SQLException e) {
			System.out.println("Ocorreu um erro no MYSQL ao listar os livros");
		}
	}
	//lista os livros cadastrados em ordem alfabetica
	public void listarLivrosAlfabetica() {
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM livros ORDER by titulo");
			while(rs.next()) {
				System.out.println("ID: " + rs.getInt(1) + " TITULO: "+ rs.getString(2) + " EDITORA: " + rs.getString(3) + " AUTOR: " + rs.getString(4) + " ANO DE PUBLICAÇÃO: "  + rs.getInt(5) + " NÚMERO DE EXEMPLARES: " + rs.getInt(7) + " TIPO: "+ rs.getString(8));
				
			}
		}
		catch(SQLException e) {
			System.out.println("Ocorreu um erro no MYSQL ao listar os livros");
		}
	}
	//adiciona um livro ao banco
	public boolean addLivro(Livro livro) {
		try {
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO  livros VALUES (NULL,'" + livro.getTitulo() +"','" + livro.getEditora() +"','" + livro.getAutor()+"'," + livro.getAno() + ",'" + livro.getDescricao() +"'," + livro.getNumExemplares() +",'" + livro.getTipo() + "')";
			st.executeUpdate(sql);
			return true;
		}
		catch(SQLException e) {
			System.out.println("Ocorreu um erro no MYSQL ao adicionar um livro");
			return false; 
		}
	}
	//busca um livro e retorna ele
	public Livro getLivro(int ID) {
		try {
			Statement st = conexao.createStatement();
			String sql = "SELECT * FROM livros WHERE id = " + ID ;
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				return new Livro(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8));
			}
			else return null;
		}
		catch( SQLException e){
			System.out.println("Ocorreu um erro no MYSQL ao pegar um livro");
			return null;
		}
	}
	//remove um livro do banco
	public boolean removeLivro(int ID) {
		try {
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM livros WHERE id = " +ID;
			st.executeUpdate(sql);
			return true;
		}
		catch(SQLException e) {
			System.out.println("Ocorreu um erro no MYSQL ao remover um livro");
			return false;
		}
	}
	//muda atributos do livro no banco de dados, o id dele não pode ser modificado
	public boolean modificaLivro(int id,String titulo,String editora,String autor,int anoPublicacao,String descricao,int numExemplares,String tipo) {
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE livros SET titulo ='" + titulo + "',editora='" + editora + "',autor='" + autor +"',anoPublicacao =" + anoPublicacao +",descricao='" +descricao+"',numExemplares="+numExemplares+",tipo='"+tipo+"' WHERE id = " + id;
			st.executeUpdate(sql);
			return true;
		}
		catch(SQLException e) {
			System.out.println("Ocorreu um erro no MYSQL ao modificar um livro");
			return false;
		}
		
	}
}
