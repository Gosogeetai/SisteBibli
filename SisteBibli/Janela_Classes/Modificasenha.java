package Janela_Classes;
import SQL_Classes.*;
import Bib_Object_Classes.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Modificasenha {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modificasenha window = new Modificasenha();
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
	public Modificasenha() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 153, 153));
		frame.getContentPane().setLayout(null);
		frame.setTitle("Modificar senha");
		textField = new JTextField();
		textField.setBounds(10, 53, 150, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Login(apenas n\u00FAmeros)");
		lblNewLabel.setBounds(10, 37, 150, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha atual(apenas n\u00FAmeros)");
		lblNewLabel_1.setBounds(10, 96, 205, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha nova(apenas n\u00FAmeros)");
		lblNewLabel_2.setBounds(10, 152, 254, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 121, 150, 20);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(10, 177, 150, 20);
		frame.getContentPane().add(passwordField_1);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int login = Integer.parseInt(textField.getText());
					int senhaatual = Integer.parseInt(passwordField.getText());
					int senhanova = Integer.parseInt(passwordField_1.getText());
					String login2 = textField.getText();
					String senha = passwordField_1.getText();
					boolean valida = false;
					if(senhanova>0 && login2.charAt(0)!='0' && senha.charAt(0) !='0') {
						valida = true;
					}
					if(valida == true) {
						UsuarioDAO u = new UsuarioDAO();
						Usuario usuario = u.getUsuario(login);
						boolean a = false;
						if(usuario.getSenha()==senhaatual) {
							a = u.modificaUsuarioSenha(login, senhanova);
						}
						if(a==true) {
							JOptionPane.showMessageDialog(null, "Senha modificada com sucesso");
							frame.dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Falha ao modificar senha do usuário, verifique se o login e senhas  estão corretos");
							frame.dispose();
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Falha ao modificar senha do usuário, verifique se o login e senhas  estão corretos, a senha não pode começar com 0");
						frame.dispose();
					}
				}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null,  "Falha ao modificar senha do usuário, verifique se o login e senhas  estão corretos");
						frame.dispose();
					}
				
			}
		});
		btnNewButton.setBounds(326, 227, 98, 23);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void setVisible(boolean visible){
	    frame.setVisible(visible);
	}
}
