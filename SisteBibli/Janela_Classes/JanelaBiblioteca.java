package Janela_Classes;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class JanelaBiblioteca {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaBiblioteca window = new JanelaBiblioteca();
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
	public JanelaBiblioteca() {
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
		frame.setTitle("Gerenciar biblioteca");
		JLabel lblNewLabel = new JLabel("Sistema de gerenciamento de biblioteca");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBackground(new Color(0, 153, 153));
		lblNewLabel.setBounds(506, 52, 269, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SISTEBIBLI");
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(496, 11, 282, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Livros");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerWindowBib livros = new ManagerWindowBib();
				livros.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(506, 131, 269, 44);
		frame.getContentPane().add(btnNewButton);
		JButton btnUsuarios = new JButton("Usu\u00E1rios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciadordeUsuarios usuarios = new GerenciadordeUsuarios();
				usuarios.setVisible(true);
			}
		});
		btnUsuarios.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUsuarios.setBounds(506, 222, 269, 44);
		frame.getContentPane().add(btnUsuarios);
		
		JButton btnEmprest = new JButton("Empr\u00E9stimos");
		btnEmprest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciadorEmprestimo gerenciaEmprestimo = new GerenciadorEmprestimo();
				gerenciaEmprestimo.setVisible(true);
			}
		});
		btnEmprest.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEmprest.setBounds(506, 311, 269, 44);
		frame.getContentPane().add(btnEmprest);
		
		JButton btnNewButton_1 = new JButton("Vis\u00E3o geral");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisãoGeral visaogeral = new VisãoGeral();
				visaogeral.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(506, 395, 269, 39);
		frame.getContentPane().add(btnNewButton_1);
		frame.setBounds(100, 100, 1300, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void setVisible(boolean visible){
	    frame.setVisible(visible);
	}
}
