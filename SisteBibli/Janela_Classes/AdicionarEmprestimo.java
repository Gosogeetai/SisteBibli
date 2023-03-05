package Janela_Classes;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import SQL_Classes.*;
import Bib_Object_Classes.*;
public class AdicionarEmprestimo {

	private JFrame frmAdicionarEmprstimo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarEmprestimo window = new AdicionarEmprestimo();
					window.frmAdicionarEmprstimo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdicionarEmprestimo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdicionarEmprstimo = new JFrame();
		frmAdicionarEmprstimo.setTitle("Adicionar empr\u00E9stimo");
		frmAdicionarEmprstimo.getContentPane().setBackground(new Color(0, 153, 153));
		frmAdicionarEmprstimo.setBounds(100, 100, 450, 300);
		frmAdicionarEmprstimo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAdicionarEmprstimo.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dia");
		lblNewLabel.setBounds(10, 39, 46, 14);
		frmAdicionarEmprstimo.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00EAs");
		lblNewLabel_1.setBounds(10, 103, 46, 14);
		frmAdicionarEmprstimo.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ano");
		lblNewLabel_2.setBounds(10, 177, 46, 14);
		frmAdicionarEmprstimo.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID do livro");
		lblNewLabel_3.setBounds(181, 39, 78, 14);
		frmAdicionarEmprstimo.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Login");
		lblNewLabel_4.setBounds(181, 103, 46, 14);
		frmAdicionarEmprstimo.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Senha");
		lblNewLabel_5.setBounds(181, 177, 46, 14);
		frmAdicionarEmprstimo.getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(10, 55, 86, 20);
		frmAdicionarEmprstimo.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 194, 86, 20);
		frmAdicionarEmprstimo.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 118, 86, 20);
		frmAdicionarEmprstimo.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(181, 55, 86, 20);
		frmAdicionarEmprstimo.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(181, 118, 86, 20);
		frmAdicionarEmprstimo.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(181, 194, 86, 20);
		frmAdicionarEmprstimo.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int dia = Integer.parseInt(textField.getText());
					int mes = Integer.parseInt(textField_2.getText());
					int ano = Integer.parseInt(textField_1.getText());
					int id = Integer.parseInt(textField_3.getText());
					int login = Integer.parseInt(textField_4.getText());
					int senha = Integer.parseInt(passwordField.getText());
					Emprestimo emprestimo = new Emprestimo(dia,mes,ano,id,login);
					EmprestimoDAO eDAO = new EmprestimoDAO();
					boolean a = false;
					a = eDAO.addEmprestimo(emprestimo, senha);
					if(a==true) {
						JOptionPane.showMessageDialog(null, "Empréstimo adicionado com sucesso");
						frmAdicionarEmprstimo.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Falha ao adicionar o empréstimo, verifique se as informações estão corretas, que tenha cópias o suficiente do livro e que o usuário não tenha multa pendente");
						frmAdicionarEmprstimo.dispose();
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Falha ao adicionar o empréstimo, verifique se as informações estão corretas,que tenha cópias o suficiente do livro e que o usuário não tenha multa pendente");
					frmAdicionarEmprstimo.dispose();
				}
			}
		});
		btnNewButton.setBounds(317, 227, 107, 23);
		frmAdicionarEmprstimo.getContentPane().add(btnNewButton);
	}
	public void setVisible(boolean visible){
		frmAdicionarEmprstimo.setVisible(visible);
	}
}
