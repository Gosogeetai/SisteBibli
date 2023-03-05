package Janela_Classes;
import SQL_Classes.*;
import Bib_Object_Classes.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class RemoveLivro {

	private JFrame frame;
	private JTextField txtIdDoLivro;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveLivro window = new RemoveLivro();
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
	public RemoveLivro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 153, 153));
		frame.getContentPane().setLayout(null);
		frame.setTitle("Remover um livro");
		txtIdDoLivro = new JTextField();
		txtIdDoLivro.setBounds(10, 55, 205, 20);
		frame.getContentPane().add(txtIdDoLivro);
		txtIdDoLivro.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ID = Integer.parseInt(txtIdDoLivro.getText());
					LivroDAO l = new LivroDAO();
					Livro livro = l.getLivro(ID);
					boolean a = l.removeLivro(ID);
					if(livro==null) {
						a=false;
					}
					if(a==true) {
						JOptionPane.showMessageDialog(null, "Livro removido com sucesso");
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Falha ao remover o livro, verifique se o ID está correto ou que o livro exista");
						frame.dispose();
					}
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Falha ao remover o livro, verifique se o ID está correto ou que o livro exista");
						frame.dispose();
					}
			
				}
			});
		
		btnNewButton.setBounds(315, 227, 109, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("ID do livro");
		lblNewLabel.setBounds(10, 34, 97, 14);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void setVisible(boolean visible){
	    frame.setVisible(visible);
	}
}
