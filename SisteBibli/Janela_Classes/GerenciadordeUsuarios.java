package Janela_Classes;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GerenciadordeUsuarios {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciadordeUsuarios window = new GerenciadordeUsuarios();
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
	public GerenciadordeUsuarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 153, 153));
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Gerenciar usuários");
		JLabel lblNewLabel = new JLabel("Gerenciamento de usu\u00E1rios");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(196, 11, 288, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cadastrar usu\u00E1rio");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionaUsuario adduser = new AdicionaUsuario();
				adduser.setVisible(true);
			}
		});
		btnNewButton.setBounds(36, 147, 199, 38);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnModificarSenhaDe = new JButton("Modificar senha de usu\u00E1rio");
		btnModificarSenhaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modificasenha modificasenha = new Modificasenha();
				modificasenha.setVisible(true);
			}
		});
		btnModificarSenhaDe.setBounds(36, 243, 199, 38);
		frame.getContentPane().add(btnModificarSenhaDe);
		
		JButton btnRemoverUmUsurio = new JButton("Remover  usu\u00E1rio");
		btnRemoverUmUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveUsuario removeusuario = new RemoveUsuario();
				removeusuario.setVisible(true);
			}
		});
		btnRemoverUmUsurio.setBounds(36, 336, 199, 38);
		frame.getContentPane().add(btnRemoverUmUsurio);
		
		JButton btnAdicionarMultaManualmente = new JButton("Adicionar multa manual");
		btnAdicionarMultaManualmente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MultaManual multamanual = new MultaManual();
				multamanual.setVisible(true);
			}
		});
		btnAdicionarMultaManualmente.setBounds(447, 147, 199, 38);
		frame.getContentPane().add(btnAdicionarMultaManualmente);
		
		JButton btnRemoverMultaDe = new JButton("Remover multa de usu\u00E1rio");
		btnRemoverMultaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveMulta removemulta = new RemoveMulta();
				removemulta.setVisible(true);
			}
		});
		btnRemoverMultaDe.setBounds(447, 243, 199, 38);
		frame.getContentPane().add(btnRemoverMultaDe);
		
		JButton btnListarTodosOs = new JButton("Listar todos os usu\u00E1rios");
		btnListarTodosOs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaUsuarios lista = new ListaUsuarios();
				lista.setVisible(true);
			}
		});
		btnListarTodosOs.setBounds(447, 336, 199, 38);
		frame.getContentPane().add(btnListarTodosOs);
		
		JButton btnNewButton_1 = new JButton("Consultar usu\u00E1rio");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaUsuario consultausuario = new ConsultaUsuario();
				consultausuario.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(254, 401, 178, 38);
		frame.getContentPane().add(btnNewButton_1);
	}
	public void setVisible(boolean visible){
	    frame.setVisible(visible);
	}
}
