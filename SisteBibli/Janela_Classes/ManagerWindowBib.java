package Janela_Classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerWindowBib {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerWindowBib window = new ManagerWindowBib();
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
	public ManagerWindowBib() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 153, 153));
		frame.getContentPane().setLayout(null);
		frame.setTitle("Gerenciar livros");
		JLabel lblNewLabel = new JLabel("Gerenciamento e pesquisa de Livros");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblNewLabel.setBounds(196, 11, 288, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Remover livro");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveLivro removelivro = new RemoveLivro();
				removelivro.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(54, 363, 192, 38);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnModificarLivro = new JButton("Modificar livro");
		btnModificarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificaLivro modifica = new ModificaLivro();
				modifica.setVisible(true);
			}
		});
		btnModificarLivro.setBounds(54, 259, 192, 38);
		frame.getContentPane().add(btnModificarLivro);
		
		JButton btnAdicionarLivro = new JButton("Adicionar livro");
		btnAdicionarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLivro2 addlivro = new addLivro2();
				addlivro.setVisible(true);
			}
		});
		btnAdicionarLivro.setBounds(54, 164, 192, 38);
		frame.getContentPane().add(btnAdicionarLivro);
		
		JButton btnListarTodosOs = new JButton("Listar todos os livros");
		btnListarTodosOs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarLivros listarlivros = new ListarLivros();
				listarlivros.setVisible(true);
			}
		});
		btnListarTodosOs.setBounds(425, 164, 209, 38);
		frame.getContentPane().add(btnListarTodosOs);
		
		JButton btnListarEmOrdem = new JButton("Listar em ordem alfab\u00E9tica");
		btnListarEmOrdem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarLivrosAlfabetico alfabetico = new ListarLivrosAlfabetico();
				alfabetico.setVisible(true);
			}
		});
		btnListarEmOrdem.setBounds(425, 259, 209, 38);
		frame.getContentPane().add(btnListarEmOrdem);
		
		JButton btnNewButton = new JButton("Consulta individual");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaLivro consultalivro = new ConsultaLivro();
				consultalivro.setVisible(true);
			}
		});
		btnNewButton.setBounds(425, 363, 209, 38);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void setVisible(boolean visible){
	    frame.setVisible(visible);
	}
}
