package Janela_Classes;
import SQL_Classes.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ConsultaLivro extends BancoDeDados{

	private JFrame frmConsultarUmLivro;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaLivro window = new ConsultaLivro();
					window.frmConsultarUmLivro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsultaLivro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultarUmLivro = new JFrame();
		frmConsultarUmLivro.getContentPane().setBackground(new Color(0, 153, 153));
		frmConsultarUmLivro.setTitle("Consultar um livro");
		frmConsultarUmLivro.setBounds(100, 100, 1165, 300);
		frmConsultarUmLivro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsultarUmLivro.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 66, 1149, 195);
		frmConsultarUmLivro.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel = new JLabel("ID do livro");
		lblNewLabel.setBounds(10, 11, 125, 14);
		frmConsultarUmLivro.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 28, 125, 20);
		frmConsultarUmLivro.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				int ID = Integer.parseInt(textField.getText());
				Statement st = conexao.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM livros");
				String string ;
				while(rs.next()) {
					if(rs.getInt(1) == ID) {
						string = "ID: " + rs.getInt(1) + " TITULO: "+ rs.getString(2) + " EDITORA: " + rs.getString(3) + " AUTOR: " + rs.getString(4) + " ANO DE PUBLICAÇÃO: "  + rs.getInt(5) + " DESCRIÇÃO: " + rs.getString(6) + " NÚMERO DE EXEMPLARES DISPONÍVEIS: " + rs.getInt(7) + " TIPO: "+ rs.getString(8)+ "\n"+"\n";
						textArea.append(string);
					}
				}
				
			}
			
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Falha ao consultar um livro, verifique se o ID está correto e que o livro existe");
				frmConsultarUmLivro.dispose();
			}
			}
		});
		btnNewButton.setBounds(193, 27, 110, 23);
		frmConsultarUmLivro.getContentPane().add(btnNewButton);
	}
	public void setVisible(boolean visible){
	    frmConsultarUmLivro.setVisible(visible);
	}
}
