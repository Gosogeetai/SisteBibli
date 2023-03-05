package Janela_Classes;
import SQL_Classes.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveMulta {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveMulta window = new RemoveMulta();
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
	public RemoveMulta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 153, 153));
		frame.getContentPane().setForeground(new Color(0, 153, 153));
		frame.getContentPane().setLayout(null);
		frame.setTitle("Remover uma multa");
		JLabel lblNewLabel = new JLabel("Login(apenas n\u00FAmeros)");
		lblNewLabel.setBounds(10, 41, 158, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 66, 120, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int login = Integer.parseInt(textField.getText());
				UsuarioDAO u = new UsuarioDAO();
				boolean a=false;
				a = u.resetaMulta(login);
				if(a==true) {
					JOptionPane.showMessageDialog(null,  "Multa resetada com sucesso");
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null,  "Falha ao resetar uma multa, verifique se o login está correto e que o usuário exista");
					frame.dispose();
				}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,  "Falha ao resetar uma multa, verifique se o login está correto e que o usuário exista");
					frame.dispose();
				}
			}
		});
		btnNewButton.setBounds(310, 227, 114, 23);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void setVisible(boolean visible){
	    frame.setVisible(visible);
	}
}
