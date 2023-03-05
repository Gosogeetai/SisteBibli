package Bib_Object_Classes;
import java.time.*;
import java.lang.*;
import java.util.*;
import java.time.temporal.ChronoUnit;
public class Emprestimo {//classe que define um emprestimo ativo
	private int login;//login do usuario que emprestou o livro
	private int dia;//data que ocorreu o emprestimo
	private int mes;
	private int ano;
	private int livroID;//identificacao do livro que foi emprestado
	public Emprestimo(int dia,int mes, int ano,int livro,int login) {
		this.login = login;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.livroID = livro;
	}
	//getters
	public int getLivroID() {
		return this.livroID;
	}
	public int getLogin() {
		return this.login;
	}
	public int getDia() {
		return this.dia;
	}
	public int getMes() {
		return this.mes;
	}
	public int getAno() {
		return this.ano;
	}
	//metodo que pega duas datas e retorna a diferença em dias entre elas
	public int DiferencaDataEmDias(int dia,int mes,int ano,int diaAtual,int mesAtual,int anoAtual) {
		LocalDate dataantes = LocalDate.of(ano, mes, dia);
		LocalDate datadepois = LocalDate.of(anoAtual, mesAtual, diaAtual);
		long dias = (int)ChronoUnit.DAYS.between(dataantes, datadepois);
		int diasInt = Math.toIntExact(dias);
		return diasInt;
	}
}
