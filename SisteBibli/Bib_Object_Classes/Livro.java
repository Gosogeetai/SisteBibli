package Bib_Object_Classes;

public class Livro {
	private int id;//identificacao unica do livro
	private String titulo;//titulo do livro
	private String editora;//editora do livro
	private String autor; //autor que escreveu o livro
	private int anoPublicacao;//ano de publicacao do livro
	private String descricao; //descricao curta do livro
	private int numExemplares;//numero de exemplares
	private String tipo;//tipo do livro, revista, dissertação, etc
	public Livro() {
		this.id = 0;
	}
	public Livro(int ID,String titulo,String editora,String autor,int anoPublicacao,String descricao, int numExemplares,String tipo) {
		this.id = ID;
		this.titulo = titulo;
		this.editora = editora;
		this.autor = autor;
		this.anoPublicacao = anoPublicacao;
		this.descricao = descricao;
		this.numExemplares = numExemplares;
		this.tipo = tipo;
	}
	//modifica um livro existente
	public Livro Modifica(Livro livro,String titulo,String editora,String autor,int anoPublicacao,String descricao, int numExemplares,String tipo) {//setter pra modificar um livro
		livro.titulo = titulo;
		livro.editora = editora;
		livro.autor = autor;
		livro.anoPublicacao = anoPublicacao;
		livro.descricao = descricao;
		livro.numExemplares = numExemplares;
		livro.tipo = tipo;
		return livro;
	}
	//getters
	public int getID() {
		return this.id;
	}
	public int getAno() {
		return this.anoPublicacao;
	}
	public int getNumExemplares() {
		return this.numExemplares;
	}
	public String getTitulo() {
		return this.titulo;
	}
	public String getEditora() {
		return this.editora;
	}
	public String getAutor() {
		return this.autor;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public String getTipo() {
		return this.tipo;
	}
	//setter pra incrementar  ou decrementar o numero de exemplares
	public void IncrementaExemplares() {
		this.numExemplares++;
	}
	public void DecrementaExemplares() {
		this.numExemplares--;
	}
}
