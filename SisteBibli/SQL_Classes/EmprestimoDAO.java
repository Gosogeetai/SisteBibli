package SQL_Classes;
import java.sql.*;
import Bib_Object_Classes.*;
public class EmprestimoDAO extends BancoDeDados{ //Data Objec Access pro emprestimo
	//lista os emprestimos existentes
	public void listarEmprestimos() { 
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM emprestimos");
			while(rs.next()) {
				System.out.println("DIA: " + rs.getInt(1) + " MES: " + rs.getInt(2) + " ANO: " + rs.getInt(3) + " ID DO LIVRO: " + rs.getInt(4) +  " LOGIN DO USUARIO: " + rs.getInt(5) );
			}
		}
		catch(SQLException e) {
			System.out.println("Ocorreu um erro no MYSQL ao listar os emprestimos");
		}
	}
	//lista os emprestimos de um determinado usuario
	public void listarUsuarioEmprestimos(int login) { 
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM emprestimos");
			while(rs.next()) {
				if(rs.getInt(5)==login) {
				System.out.println("DIA: " + rs.getInt(1) + " MES: " + rs.getInt(2) + " ANO: " + rs.getInt(3) + " ID DO LIVRO: " + rs.getInt(4) +  " LOGIN DO USUARIO: " + rs.getInt(5) );
				}
			}
		}
		catch(SQLException e) {
			System.out.println("Ocorreu um erro no MYSQL ao listar os emprestimos de um usuario");
		}
	}
	//lista os emprestimos de um determinado livro
	public void listarLivroEmprestimos(int livroID) {
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM emprestimos");
			//LivroDAO lDAO = new LivroDAO();
			while(rs.next()) {
				if(rs.getInt(4)==livroID) {
				System.out.println("DIA: " + rs.getInt(1) + " MES: " + rs.getInt(2) + " ANO: " + rs.getInt(3) + " ID DO LIVRO: " + rs.getInt(4) +  " LOGIN DO USUARIO: " + rs.getInt(5) );
				}
			}
		}
		catch(SQLException e) {
			System.out.println("Ocorreu um erro no MYSQL ao listar os emprestimos de um usuario");
		}
	}
	//adiciona um emprestimo ao banco 
	public boolean addEmprestimo(Emprestimo emprestimo,int senha) {
		try {
			int dia = emprestimo.getDia();
			int mes = emprestimo.getMes();
			if(mes<0||mes>12) {
				return false;
			}
			if(dia<0 || dia>31) {
				return false;
			}
			if((mes==4||mes==6||mes==9||mes==11) && dia>30) {
				return false;
			}
			if(mes==2 && dia>28) {
				return false;
			}
			if(emprestimo.getAno()<2000) {
				return false;
			}
			if(emprestimo.getAno()>100000) {
				return false;
			}
			Statement st = conexao.createStatement();
			LivroDAO lDAO = new LivroDAO();
			Livro livro = lDAO.getLivro(emprestimo.getLivroID());
			Emprestimo buscador = this.getEmprestimo(emprestimo.getLogin(), emprestimo.getLivroID());
			UsuarioDAO uDAO = new UsuarioDAO();
			Usuario usuario = uDAO.getUsuario(emprestimo.getLogin());
			if(livro!=null && livro.getNumExemplares()>0 && usuario.getSenha() == senha && buscador ==null && usuario.getMulta()==0) {
				int i = livro.getNumExemplares();
				i--;
				lDAO.modificaLivro(emprestimo.getLivroID(), livro.getTitulo(), livro.getEditora(), livro.getAutor(), livro.getAno(), livro.getDescricao(),i, livro.getTipo());
				String sql = "INSERT INTO  emprestimos VALUES (" + emprestimo.getDia() +"," + emprestimo.getMes()+ "," + emprestimo.getAno() + "," + emprestimo.getLivroID() +"," + emprestimo.getLogin() +")";
				st.executeUpdate(sql);
				return true;
			}
			return false;
		}
		catch(SQLException e) {
			System.out.println("Ocorreu um erro no MYSQL ao adicionar um emprestimo");
			return false; 
		}
	}
	//remove um emprestimo do banco
	public boolean removeEmprestimo(int login,int livroID,int diaAtual,int mesAtual,int anoAtual) {
		try {
			if(mesAtual<0||mesAtual>12) {
				return false;
			}
			if(diaAtual<0 || diaAtual>31) {
				return false;
			}
			if((mesAtual==4||mesAtual==6||mesAtual==9||mesAtual==11) && diaAtual>30) {
				return false;
			}
			if(mesAtual==2 && diaAtual>28) {
				return false;
			}
			if(anoAtual<2000) {
				return false;
			}
			if(anoAtual>100000) {
				return false;
			}
			EmprestimoDAO eDAO = new EmprestimoDAO();
			Emprestimo emprestimo = eDAO.getEmprestimo(login, livroID);
			LivroDAO lDAO = new LivroDAO();
			if(emprestimo!=null) {
				Livro livro = lDAO.getLivro(emprestimo.getLivroID());
				if(livro==null) {
					Statement st = conexao.createStatement();
					String sql = "DELETE FROM emprestimos WHERE login = " +login+" AND idLivro=" +livroID;
					st.executeUpdate(sql);
					return true; //se o livro ja foi removido da biblioteca isso assegura que ele pode ser removido da minha lista de emprestimos seguramente
				}
				int dia = emprestimo.getDia();
				int mes = emprestimo.getMes();
				int ano = emprestimo.getAno();
				int dias = emprestimo.DiferencaDataEmDias(dia, mes, ano, diaAtual, mesAtual, anoAtual);
				if(dias>6) {
					int multa = Math.abs((dias-6)*2);
					UsuarioDAO uDAO  = new UsuarioDAO();
					if(dias>96) {
						multa = 180;//tem um limite maximo pra multa, não quero que o cara fique com milhares de reais de multa porque esqueceu de um livro no primeiro periodo
					}
					uDAO.addMulta(login,multa );
				}
				if(dias<0) {
					return false;
				}
				int i  = livro.getNumExemplares();
				i++;
				lDAO.modificaLivro(emprestimo.getLivroID(), livro.getTitulo(), livro.getEditora(), livro.getAutor(), livro.getAno(), livro.getDescricao(), i, livro.getTipo());
				Statement st = conexao.createStatement();
				String sql = "DELETE FROM emprestimos WHERE login = " +login+" AND idLivro=" +livroID;
				st.executeUpdate(sql);
				return true;
			}
			return false;
		}
		catch(SQLException e) {
			System.out.println("Ocorreu um erro no MYSQL ao remover um emprestimo");
			return false;
		}
	}
	//busca um emprestimo do banco e retorna ele
	public Emprestimo getEmprestimo(int login,int livroID) {
		try {
			Statement st = conexao.createStatement();
			String sql = "SELECT * FROM emprestimos WHERE login = " + login +" AND idLivro=" + livroID;
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				return new Emprestimo(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
			}
			else return null;
		}
		catch( SQLException e){
			System.out.println("Ocorreu um erro no MYSQL ao pegar um emprestimo");
			return null;
		}
	}
}
