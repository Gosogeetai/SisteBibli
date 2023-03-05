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

public class GerenciadorEmprestimo {

	private JFrame frmGerenci;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciadorEmprestimo window = new GerenciadorEmprestimo();
					window.frmGerenci.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GerenciadorEmprestimo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGerenci = new JFrame();
		frmGerenci.setTitle("Gerenciar empr\u00E9stimos");
		frmGerenci.getContentPane().setBackground(new Color(0, 153, 153));
		frmGerenci.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gerenciamento de empr\u00E9stimos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblNewLabel.setBounds(196, 11, 288, 50);
		frmGerenci.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Adicionar empr\u00E9stimo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionarEmprestimo adiciona = new AdicionarEmprestimo();
				adiciona.setVisible(true);
			}
		});
		btnNewButton.setBounds(49, 144, 217, 40);
		frmGerenci.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remover empr\u00E9stimo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveEmprestimo remove = new RemoveEmprestimo();
				remove.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(49, 241, 217, 40);
		frmGerenci.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Listar todos os empr\u00E9stimos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEmprestimo listaemprestimos = new ListaEmprestimo();
				listaemprestimos.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(49, 336, 217, 40);
		frmGerenci.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Listar empr\u00E9stimos de um usu\u00E1rio");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEmprestimoUsuario emprestimousuario = new ListaEmprestimoUsuario();
				emprestimousuario.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(403, 144, 231, 40);
		frmGerenci.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Listar empr\u00E9stimos de um livro");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEmprestimoLivro emprestimolivro = new ListaEmprestimoLivro();
				emprestimolivro.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(403, 241, 231, 40);
		frmGerenci.getContentPane().add(btnNewButton_4);
		frmGerenci.setBounds(100, 100, 700, 500);
		frmGerenci.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void setVisible(boolean visible){
		frmGerenci.setVisible(visible);
	}
}
