package Janela_Classes;
import SQL_Classes.*;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;

public class VisãoGeral extends BancoDeDados{

	private JFrame frmVisoGeral;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisãoGeral window = new VisãoGeral();
					window.frmVisoGeral.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VisãoGeral() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVisoGeral = new JFrame();
		frmVisoGeral.setTitle("Vis\u00E3o geral");
		frmVisoGeral.setBounds(100, 100, 737, 173);
		frmVisoGeral.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVisoGeral.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 721, 134);
		frmVisoGeral.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		scrollPane.setViewportView(textArea);
		try {
			Statement st = conexao.createStatement();
			int livros =0;
			int emprestimos = 0;
			int usuarios  = 0;
			ResultSet rs = st.executeQuery("SELECT * FROM emprestimos");
			while(rs.next()) {
				emprestimos++;
			}
			rs = st.executeQuery("SELECT * FROM usuarios");
			while(rs.next()) {
				usuarios++;
			}
			rs = st.executeQuery("SELECT * FROM livros");
			while(rs.next()) {
				livros++;
			}
			String string;
			string = "LIVROS CADASTRADOS: " + livros + "\n" + "\n";
			string +="USÚARIOS CADASTRADOS: " + usuarios + "\n" + "\n";
			string+= "EMPRÉSTIMOS: " + emprestimos  + "\n" + "\n";
			textArea.append(string);
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Falha ao mostrar a visão geral");
			frmVisoGeral.dispose();
		}
	}
	public void setVisible(boolean visible){
	    frmVisoGeral.setVisible(visible);
	}
}
