package Janela_Classes;
import SQL_Classes.*;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ListarLivros extends BancoDeDados {

	private JFrame frmListaDeLivros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarLivros window = new ListarLivros();
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
	public ListarLivros() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListaDeLivros = new JFrame();
		frmListaDeLivros.setTitle("Lista de livros");
		frmListaDeLivros.getContentPane().setBackground(new Color(0, 153, 153));
		frmListaDeLivros.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1184, 430);
		frmListaDeLivros.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		scrollPane.setViewportView(textArea);
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM livros");
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
		frmListaDeLivros.setBounds(100, 100, 1200, 469);
		frmListaDeLivros.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void setVisible(boolean visible){
	    frmListaDeLivros.setVisible(visible);
	}
}
