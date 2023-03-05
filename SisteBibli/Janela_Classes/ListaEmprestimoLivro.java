package Janela_Classes;
import SQL_Classes.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListaEmprestimoLivro extends BancoDeDados{

	private JFrame frmListaDeEmprstimos;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaEmprestimoLivro window = new ListaEmprestimoLivro();
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
	public ListaEmprestimoLivro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListaDeEmprstimos = new JFrame();
		frmListaDeEmprstimos.getContentPane().setBackground(new Color(0, 153, 153));
		frmListaDeEmprstimos.setTitle("Lista de empr\u00E9stimos de um livro");
		frmListaDeEmprstimos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmListaDeEmprstimos.setBounds(100, 100, 1200, 469);
		frmListaDeEmprstimos.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 62, 1184, 368);
		frmListaDeEmprstimos.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel = new JLabel("ID do livro");
		lblNewLabel.setBounds(17, 11, 86, 14);
		frmListaDeEmprstimos.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(17, 24, 131, 20);
		frmListaDeEmprstimos.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int livroID = Integer.parseInt(textField.getText());
					Statement st = conexao.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM emprestimos");
					String string ;
					while(rs.next()) {
						if(rs.getInt(4)==livroID) {
							string = "DIA: " + rs.getInt(1) + " MES: " + rs.getInt(2) + " ANO: " + rs.getInt(3) + " ID DO LIVRO: " + rs.getInt(4) +  " LOGIN DO USUARIO: " + rs.getInt(5) +"\n"+"\n";
							textArea.append(string);
						}
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Falha ao listar empréstimos de um livro");
					frmListaDeEmprstimos.dispose();
				}
			}
		});
		btnNewButton.setBounds(226, 23, 121, 23);
		frmListaDeEmprstimos.getContentPane().add(btnNewButton);
	}
	public void setVisible(boolean visible){
		frmListaDeEmprstimos.setVisible(visible);
	}
}
