package Janela_Classes;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import SQL_Classes.*;
import Bib_Object_Classes.*;
import javax.swing.JLabel;
public class addLivro2{

	private JFrame frame;
	private JTextField txtTtulo;
	private JTextField txtE;
	private JTextField txtAutor;
	private JTextField txtAnoDePublicao;
	private JTextField txtDescrio;
	private JTextField txtNmeroDeExemplares;
	private JTextField txtTipo;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addLivro2 window = new addLivro2();
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
	public addLivro2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 153, 153));
		frame.getContentPane().setLayout(null);
		frame.setTitle("Adicionar um livro");
		txtTtulo = new JTextField();
		txtTtulo.setText("T\u00EDtulo");
		txtTtulo.setBounds(10, 36, 124, 20);
		frame.getContentPane().add(txtTtulo);
		txtTtulo.setColumns(10);
		
		txtE = new JTextField();
		txtE.setText("Editora");
		txtE.setBounds(10, 90, 124, 20);
		frame.getContentPane().add(txtE);
		txtE.setColumns(10);
		
		txtAutor = new JTextField();
		txtAutor.setText("Autor");
		txtAutor.setColumns(10);
		txtAutor.setBounds(10, 144, 124, 20);
		frame.getContentPane().add(txtAutor);
		
		txtAnoDePublicao = new JTextField();
		txtAnoDePublicao.setText("Ano de Publica\u00E7\u00E3o");
		txtAnoDePublicao.setColumns(10);
		txtAnoDePublicao.setBounds(10, 193, 124, 20);
		frame.getContentPane().add(txtAnoDePublicao);
		
		txtDescrio = new JTextField();
		txtDescrio.setHorizontalAlignment(SwingConstants.LEFT);
		txtDescrio.setText("Descri\u00E7\u00E3o");
		txtDescrio.setColumns(10);
		txtDescrio.setBounds(194, 36, 210, 62);
		frame.getContentPane().add(txtDescrio);
		
		txtNmeroDeExemplares = new JTextField();
		txtNmeroDeExemplares.setText("N\u00FAmero de exemplares");
		txtNmeroDeExemplares.setColumns(10);
		txtNmeroDeExemplares.setBounds(195, 128, 210, 20);
		frame.getContentPane().add(txtNmeroDeExemplares);
		
		txtTipo = new JTextField();
		txtTipo.setText("Tipo");
		txtTipo.setColumns(10);
		txtTipo.setBounds(196, 173, 86, 20);
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
				int ano = Integer.parseInt(txtAnoDePublicao.getText());
				int numExemplares = Integer.parseInt(txtNmeroDeExemplares.getText());
				Livro livro = new Livro(-1,titulo,editora,autor,ano,descricao,numExemplares,tipo);
				boolean valida = false;
				boolean a = false;
				if(numExemplares>=0) {
					valida = true;
				}
				if(valida==true) {
				LivroDAO l = new LivroDAO();
				
				a=l.addLivro(livro);
				if(a==true) {
					JOptionPane.showMessageDialog(null, "Livro adicionado com sucesso");
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Falha ao adicionar o livro, verifique se os dados estão corretos");
					frame.dispose();
				}
				}
				else {
					JOptionPane.showMessageDialog(null, "Falha ao adicionar o livro, verifique se os dados estão corretos");
					frame.dispose();
				}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Falha ao adicionar o livro, verifique se os dados estão corretos");
					frame.dispose();
				}
			}
		});
		btnNewButton.setBounds(301, 227, 103, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("Tipo");
		lblNewLabel.setBounds(193, 154, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("N\u00FAmero de exemplares");
		lblNewLabel_1.setBounds(194, 109, 210, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_2.setBounds(193, 17, 211, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("T\u00EDtulo");
		lblNewLabel_3.setBounds(10, 18, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Editora");
		lblNewLabel_4.setBounds(11, 70, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Autor");
		lblNewLabel_5.setBounds(9, 126, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Ano de publica\u00E7\u00E3o");
		lblNewLabel_6.setBounds(9, 173, 125, 14);
		frame.getContentPane().add(lblNewLabel_6);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void setVisible(boolean visible){
	    frame.setVisible(visible);
	}
}
