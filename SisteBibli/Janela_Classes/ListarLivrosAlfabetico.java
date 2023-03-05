package Janela_Classes;
import SQL_Classes.*;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class ListarLivrosAlfabetico extends BancoDeDados {

	private JFrame frmListaDeLivros;
	private final JScrollPane scrollPane = new JScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarLivrosAlfabetico window = new ListarLivrosAlfabetico();
					window.frmListaDeLivros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListarLivrosAlfabetico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListaDeLivros = new JFrame();
		frmListaDeLivros.setTitle("Lista de livros em ordem alfab\u00E9tica");
		frmListaDeLivros.setBounds(100, 100, 1200, 469);
		frmListaDeLivros.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmListaDeLivros.getContentPane().setLayout(null);
		scrollPane.setBounds(0, 0, 1184, 430);
		frmListaDeLivros.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		scrollPane.setViewportView(textArea);
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM livros ORDER by titulo");
			String string ;
			while(rs.next()) {
				string = "ID: " + rs.getInt(1) + " TITULO: "+ rs.getString(2) + " EDITORA: " + rs.getString(3) + " AUTOR: " + rs.getString(4) + " ANO DE PUBLICAÇÃO: "  + rs.getInt(5) + " DESCRIÇÃO: " + rs.getString(6) + " NÚMERO DE EXEMPLARES DISPONÍVEIS: " + rs.getInt(7) + " TIPO: "+ rs.getString(8)+ "\n"+"\n";
				textArea.append(string);
				
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Falha ao listar livros");
			frmListaDeLivros.dispose();
		}
	}
	public void setVisible(boolean visible){
		frmListaDeLivros.setVisible(visible);
	}
}
