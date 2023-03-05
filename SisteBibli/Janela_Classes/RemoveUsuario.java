package Janela_Classes;
import SQL_Classes.*;
import Bib_Object_Classes.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RemoveUsuario {

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
					RemoveUsuario window = new RemoveUsuario();
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
	public RemoveUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 153, 153));
		frame.getContentPane().setLayout(null);
		frame.setTitle("Remover usuário");
		JLabel lblNewLabel = new JLabel("Login(apenas n\u00FAmeros)");
		lblNewLabel.setBounds(10, 30, 163, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha(apenas n\u00FAmeros)");
		lblNewLabel_1.setBounds(10, 112, 163, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 50, 163, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int login = Integer.parseInt(textField.getText());
					int senha = Integer.parseInt(passwordField.getText());
					UsuarioDAO u = new UsuarioDAO();
					Usuario user = u.getUsuario(login);
					boolean a = false;
					if(senha==user.getSenha()) {
						a=u.removeUsuario(login);
					}
					if(a == true) {
						JOptionPane.showMessageDialog(null,  "Usuário removido com sucesso");
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null,  "Falha ao remover um usuário, verifique se o login e senhas  estão corretos e o usuário não tenha nenhum empréstimo pendente");
						frame.dispose();
					}
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,  "Falha ao remover um usuário, verifique se o login e senhas  estão corretos e o usuário não tenha nenhum empréstimo pendente");
					frame.dispose();
				}
			}
		});
		btnNewButton.setBounds(308, 227, 116, 23);
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 132, 163, 20);
		frame.getContentPane().add(passwordField);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void setVisible(boolean visible){
	    frame.setVisible(visible);
	}
}
