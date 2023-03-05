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

public class MultaManual {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultaManual window = new MultaManual();
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
	public MultaManual() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 153, 153));
		frame.getContentPane().setLayout(null);
		frame.setTitle("Adicionar multa manualmente");
		JLabel lblNewLabel = new JLabel("Login(apenas n\u00FAmeros)");
		lblNewLabel.setBounds(10, 40, 139, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor a adicionar");
		lblNewLabel_1.setBounds(10, 108, 139, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 139, 139, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 71, 139, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int multa = Integer.parseInt(textField.getText());
					int login = Integer.parseInt(textField_1.getText());
					boolean a = false;
					UsuarioDAO u = new UsuarioDAO();
					a = u.addMulta(login, multa);
					if(a==true) {
						JOptionPane.showMessageDialog(null,  "Multa adicionada com sucesso");
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null,  "Falha ao adicionar multa à um usuário, verifique se o login e multas estão corretos");
						frame.dispose();
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,  "Falha ao adicionar multa à um usuário, verifique se o login e multas estão corretos");
					frame.dispose();
				}
			}
		});
		btnNewButton.setBounds(315, 227, 109, 23);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void setVisible(boolean visible){
	    frame.setVisible(visible);
	}
}
