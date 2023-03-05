package Bib_Object_Classes;
import java.util.*;
public class Usuario {
	private int Login;//login do usuario
	private int senha;//senha do usuario
	private int multa;//multa ativa do usuario,começa em 0 sempre
	public Usuario(int login,int senha) {
		this.Login = login;
		this.senha = senha;
		this.multa = 0;
	}
	public Usuario(int login,int senha,int multa){
		this.Login = login;
		this.senha = senha;
		this.multa = multa;
	}//verificar se login é valido
	//getters
	public int getLogin() {
		return this.Login;
	}
	public int getSenha() {
		return this.senha;
	}
	public int getMulta() {
		return this.multa;
	}
	//setters
	//reseta a multa de um usuario pra 0
	public Usuario removeMulta(Usuario usuario) {
		usuario.multa = 0;
		return usuario;
	}
	//modifica a senha do usuario
	public Usuario modificaUsuario(Usuario usuario,int login,int senha) {
		usuario.senha = senha;
		usuario.Login = login;
		return usuario;
	}
	
	}
