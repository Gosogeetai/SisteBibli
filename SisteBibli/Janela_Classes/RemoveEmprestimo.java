package Janela_Classes;
import SQL_Classes.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveEmprestimo {

	private JFrame frmRemoverEmprstimo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveEmprestimo window = new RemoveEmprestimo();
					window.frmRemoverEmprstimo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RemoveEmprestimo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRemoverEmprstimo = new JFrame();
		frmRemoverEmprstimo.getContentPane().setBackground(new Color(0, 153, 153));
		frmRemoverEmprstimo.setTitle("Remover empr\u00E9stimo");
		frmRemoverEmprstimo.setBounds(100, 100, 450, 300);
		frmRemoverEmprstimo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRemoverEmprstimo.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dia atual");
		lblNewLabel.setBounds(10, 50, 120, 14);
		frmRemoverEmprstimo.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00EAs atual");
		lblNewLabel_1.setBounds(10, 124, 120, 14);
		frmRemoverEmprstimo.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ano atual");
		lblNewLabel_2.setBounds(10, 198, 120, 14);
		frmRemoverEmprstimo.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID do livro");
		lblNewLabel_3.setBounds(230, 50, 86, 14);
		frmRemoverEmprstimo.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Login");
		lblNewLabel_4.setBounds(230, 124, 46, 14);
		frmRemoverEmprstimo.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(10, 75, 120, 20);
		frmRemoverEmprstimo.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 149, 120, 20);
		frmRemoverEmprstimo.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 223, 120, 20);
		frmRemoverEmprstimo.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(230, 75, 120, 20);
		frmRemoverEmprstimo.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(230, 149, 120, 20);
		frmRemoverEmprstimo.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int dia = Integer.parseInt(textField.getText());
					int mes = Integer.parseInt(textField_1.getText());
					int ano = Integer.parseInt(textField_2.getText());
					int id = Integer.parseInt(textField_3.getText());
					int login = Integer.parseInt(textField_4.getText());
					EmprestimoDAO eDAO = new EmprestimoDAO();
					boolean a = false;
					a = eDAO.removeEmprestimo(login, id, dia, mes, ano);
					if(a==true) {
						JOptionPane.showMessageDialog(null, "Empréstimo removido com sucesso");
						frmRemoverEmprstimo.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Falha ao remover o empréstimo, verifique se as informações estão corretas");
						frmRemoverEmprstimo.dispose();
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Falha ao remover o empréstimo, verifique se as informações estão corretas");
					frmRemoverEmprstimo.dispose();
				}
			}
		});
		btnNewButton.setBounds(304, 222, 120, 23);
		frmRemoverEmprstimo.getContentPane().add(btnNewButton);
	}
	public void setVisible(boolean visible){
	    frmRemoverEmprstimo.setVisible(visible);
	}
}
