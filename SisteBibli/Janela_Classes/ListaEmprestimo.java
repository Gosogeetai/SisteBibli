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

public class ListaEmprestimo extends BancoDeDados{

	private JFrame frmListaDeEmprstimos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaEmprestimo window = new ListaEmprestimo();
					window.frmListaDeEmprstimos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListaEmprestimo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListaDeEmprstimos = new JFrame();
		frmListaDeEmprstimos.setTitle("Lista de empr\u00E9stimos");
		frmListaDeEmprstimos.setBounds(100, 100, 1200, 469);
		frmListaDeEmprstimos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmListaDeEmprstimos.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1184, 430);
		frmListaDeEmprstimos.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		scrollPane.setViewportView(textArea);
		try {
			Statement st = conexao.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM emprestimos");
			String string;
			while(rs.next()) {
				string = "DIA: " + rs.getInt(1) + " MES: " + rs.getInt(2) + " ANO: " + rs.getInt(3) + " ID DO LIVRO: " + rs.getInt(4) +  " LOGIN DO USUARIO: " + rs.getInt(5)+"\n"+"\n";
				textArea.append(string);
				
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Falha ao listar empréstimos");
			frmListaDeEmprstimos.dispose();
		}
	}
	public void setVisible(boolean visible){
		frmListaDeEmprstimos.setVisible(visible);
	}
}
