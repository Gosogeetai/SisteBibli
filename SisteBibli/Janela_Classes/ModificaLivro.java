package Janela_Classes;
import Bib_Object_Classes.*;
import SQL_Classes.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class ModificaLivro {


	private JFrame frame;
	private JTextField txtTtulo;
	private JTextField txtE;
	private JTextField txtAutor;
	private JTextField txtAnoDePublicao;
	private JTextField txtDescrio;
	private JTextField txtNmeroDeExemplares;
	private JTextField txtTipo;
	private JTextField txtIdDoLivro;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificaLivro window = new ModificaLivro();
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
	public ModificaLivro() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 153, 153));
		frame.getContentPane().setLayout(null);
		frame.setTitle("Modificar um livro");
		txtTtulo = new JTextField();
		txtTtulo.setText("T\u00EDtulo");
		txtTtulo.setBounds(10, 86, 124, 20);
		frame.getContentPane().add(txtTtulo);
		txtTtulo.setColumns(10);
		
		txtE = new JTextField();
		txtE.setText("Editora ");
		txtE.setBounds(10, 131, 124, 20);
		frame.getContentPane().add(txtE);
		txtE.setColumns(10);
		
		txtAutor = new JTextField();
		txtAutor.setText("Autor");
		txtAutor.setColumns(10);
		txtAutor.setBounds(10, 193, 124, 20);
		frame.getContentPane().add(txtAutor);
		
		txtAnoDePublicao = new JTextField();
		txtAnoDePublicao.setText("Ano de Publica\u00E7\u00E3o");
		txtAnoDePublicao.setColumns(10);
		txtAnoDePublicao.setBounds(194, 36, 124, 20);
		frame.getContentPane().add(txtAnoDePublicao);
		
		txtDescrio = new JTextField();
		txtDescrio.setHorizontalAlignment(SwingConstants.LEFT);
		txtDescrio.setText("Descri\u00E7\u00E3o");
		txtDescrio.setColumns(10);
		txtDescrio.setBounds(193, 72, 210, 62);
		frame.getContentPane().add(txtDescrio);
		
		txtNmeroDeExemplares = new JTextField();
		txtNmeroDeExemplares.setText("N\u00FAmero de exemplares");
		txtNmeroDeExemplares.setColumns(10);
		txtNmeroDeExemplares.setBounds(196, 159, 210, 20);
		frame.getContentPane().add(txtNmeroDeExemplares);
		
		txtTipo = new JTextField();
		txtTipo.setText("Tipo");
		txtTipo.setColumns(10);
		txtTipo.setBounds(195, 199, 86, 20);
		frame.getContentPane().add(txtTipo);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String titulo = txtTtulo.getText();
				String editora = txtE.getText();
				String descricao  = txtDescrio.getText();
				String autor = txtAutor.getText();
				String tipo = txtTipo.getText();
				int ID = Integer.parseInt(txtIdDoLivro.getText());
				int ano = Integer.parseInt(txtAnoDePublicao.getText());
				int numExemplares = Integer.parseInt(txtNmeroDeExemplares.getText());
				LivroDAO l = new LivroDAO();
				boolean a= false;
				boolean valida = false;
				Livro livro = l.getLivro(ID);
				if(numExemplares>=0 && livro!=null) {
					valida = true;
				}
				if(valida==true) {
					a=l.modificaLivro(ID, titulo, editora, autor, ano, descricao, numExemplares, tipo);
					if(a==true) {
						JOptionPane.showMessageDialog(null, "Livro modificado com sucesso");
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Falha ao modificar o livro, verifique se o ID está correto");
						frame.dispose();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Falha ao modificar o livro, verifique se o ID está correto");
					frame.dispose();
				}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Falha ao modificar o livro, verifique se o ID está correto");
					frame.dispose();
				}
			}
		});
		btnNewButton.setBounds(301, 227, 103, 23);
		frame.getContentPane().add(btnNewButton);
		
		txtIdDoLivro = new JTextField();
		txtIdDoLivro.setText("ID do livro");
		txtIdDoLivro.setBounds(10, 36, 146, 20);
		frame.getContentPane().add(txtIdDoLivro);
		txtIdDoLivro.setColumns(10);
		
		lblNewLabel = new JLabel("ID do livro a ser modificado");
		lblNewLabel.setBounds(11, 19, 172, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.setBounds(11, 68, 123, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Editora");
		lblNewLabel_2.setBounds(11, 113, 123, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Autor");
		lblNewLabel_3.setBounds(12, 176, 122, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Ano de publica\u00E7\u00E3o");
		lblNewLabel_4.setBounds(193, 22, 125, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Descri\u00E7\u00E3o curta");
		lblNewLabel_5.setBounds(194, 58, 124, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("N\u00FAmero de exemplares ");
		lblNewLabel_6.setBounds(195, 142, 208, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Tipo");
		lblNewLabel_7.setBounds(196, 182, 207, 14);
		frame.getContentPane().add(lblNewLabel_7);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void setVisible(boolean visible){
	    frame.setVisible(visible);
	}
}
