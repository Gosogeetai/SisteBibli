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
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ConsultaUsuario extends BancoDeDados{

	private JFrame frmConsultarUmUsurio;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaUsuario window = new ConsultaUsuario();
					window.frmConsultarUmUsurio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsultaUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultarUmUsurio = new JFrame();
		frmConsultarUmUsurio.getContentPane().setBackground(new Color(0, 153, 153));
		frmConsultarUmUsurio.setTitle("Consultar um usu\u00E1rio");
		frmConsultarUmUsurio.setBounds(100, 100, 800, 300);
		frmConsultarUmUsurio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsultarUmUsurio.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 61, 784, 200);
		frmConsultarUmUsurio.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frmConsultarUmUsurio.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(8, 30, 161, 20);
		frmConsultarUmUsurio.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int login = Integer.parseInt(textField.getText());
					Statement st = conexao.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
					String string ;
					while(rs.next()) {
						if(rs.getInt(1)==login) {
							string = "LOGIN: " + rs.getInt(1) + " SENHA: " + rs.getInt(2) + " MULTA: " + rs.getInt(3) +"\n"+"\n";
							textArea.append(string);
						}
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Falha ao consultar um usuário, verifique se o login está correto");
					frmConsultarUmUsurio.dispose();
				}
			}
		});
		btnNewButton.setBounds(208, 27, 106, 23);
		frmConsultarUmUsurio.getContentPane().add(btnNewButton);
	}
	public void setVisible(boolean visible){
		frmConsultarUmUsurio.setVisible(visible);
	}
}
