package Janela_Classes;
import SQL_Classes.*;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListaEmprestimoUsuario extends BancoDeDados{

	private JFrame frmListarEmprstimosDe;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaEmprestimoUsuario window = new ListaEmprestimoUsuario();
					window.frmListarEmprstimosDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListaEmprestimoUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListarEmprstimosDe = new JFrame();
		frmListarEmprstimosDe.getContentPane().setBackground(new Color(0, 153, 153));
		frmListarEmprstimosDe.setTitle("Listar empr\u00E9stimos de um usu\u00E1rio");
		frmListarEmprstimosDe.setBounds(100, 100, 1200, 469);
		frmListarEmprstimosDe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmListarEmprstimosDe.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 63, 1184, 367);
		frmListarEmprstimosDe.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frmListarEmprstimosDe.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(8, 24, 119, 20);
		frmListarEmprstimosDe.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int login = Integer.parseInt(textField.getText());
					Statement st = conexao.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM emprestimos");
					String string;
					while(rs.next()) {
						if(rs.getInt(5)==login) {
						string = "DIA: " + rs.getInt(1) + " MES: " + rs.getInt(2) + " ANO: " + rs.getInt(3) + " ID DO LIVRO: " + rs.getInt(4) +  " LOGIN DO USUARIO: " + rs.getInt(5) +"\n"+"\n";
						textArea.append(string);
						}
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Falha ao listar empréstimos de um usuário");
					frmListarEmprstimosDe.dispose();
				}
			}
		});
		
		btnNewButton.setBounds(209, 23, 119, 23);
		frmListarEmprstimosDe.getContentPane().add(btnNewButton);
		
	}
	public void setVisible(boolean visible){
		frmListarEmprstimosDe.setVisible(visible);
	}
}
