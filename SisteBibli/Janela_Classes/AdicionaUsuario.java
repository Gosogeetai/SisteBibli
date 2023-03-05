package Janela_Classes;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import SQL_Classes.*;
import Bib_Object_Classes.*;
public class AdicionaUsuario {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionaUsuario window = new AdicionaUsuario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdicionaUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 153, 153));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Cadastrar Usuário");
		textField = new JTextField();
		textField.setBounds(10, 50, 158, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 134, 158, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Login(apenas n\u00FAmeros)");
		lblNewLabel.setBounds(10, 31, 158, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha(apenas n\u00FAmeros)");
		lblNewLabel_1.setBounds(10, 118, 158, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int log = Integer.parseInt(textField.getText());
				String login = textField.getText();
				String senha = passwordField.getText();
				int sen = Integer.parseInt(passwordField.getText());
				Usuario usuario = new Usuario(log,sen);
				UsuarioDAO u = new UsuarioDAO();
				boolean valida = false;
				boolean a = false;
				if(log>=0 && sen>=0 && login.charAt(0)!='0' && senha.charAt(0) !='0') {
					valida = true;
					
				}
				if(valida==true) {
					a = u.addUsuario(usuario);
					if(a==true) {
						JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Falha ao cadastrar usuário, verifique se o login e senha estão corretos");
						frame.dispose();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar usuário, verifique se o login e senha estão corretos, a senha não pode começar com 0");
					frame.dispose();
				}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,  "Falha ao cadastrar usuário, verifique se o login está correto");
					frame.dispose();
				}
			}
		});
		btnNewButton.setBounds(313, 227, 111, 23);
		frame.getContentPane().add(btnNewButton);
	}
	public void setVisible(boolean visible){
	    frame.setVisible(visible);
	}
}
