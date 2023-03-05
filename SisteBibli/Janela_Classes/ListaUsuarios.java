package Janela_Classes;
import SQL_Classes.*;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Color;

public class ListaUsuarios extends BancoDeDados{

	private JFrame frmListaDeLivros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaUsuarios window = new ListaUsuarios();
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
	public ListaUsuarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListaDeLivros = new JFrame();
		frmListaDeLivros.setTitle("Lista de usu\u00E1rios cadastrados");
		frmListaDeLivros.setBounds(100, 100, 1200, 469);
		frmListaDeLivros.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		frmListaDeLivros.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		scrollPane.setViewportView(textArea);
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
			String string;
			while(rs.next()) {
				string = "LOGIN: " + rs.getInt(1) + " SENHA: " + rs.getInt(2) + " MULTA: " + rs.getInt(3) +"\n"+"\n";
				textArea.append(string);
			}
			
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Falha ao listar usuários");
			frmListaDeLivros.dispose();
		}
	}
	public void setVisible(boolean visible){
	    frmListaDeLivros.setVisible(visible);
	}
}
