package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField txtCodVoo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("ANAC - Ag\u00EAncia Nacional de Avia\u00E7\u00E3o Civil");
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 11));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("COTUCA - 2020");
		lblNewLabel_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("Exibir V\u00F4os");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					ListaDeVoos frame = new ListaDeVoos();
					frame.setVisible(true);
					frame.initialize();
				}
				catch (Exception error)
				{}
			}
		});
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton.setBounds(10, 126, 141, 23);
		panel_2.add(btnNewButton);
		
		JButton btnCadastrarAeroporto = new JButton("Cadastrar Aeroporto");
		btnCadastrarAeroporto.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnCadastrarAeroporto.setBounds(161, 126, 179, 23);
		panel_2.add(btnCadastrarAeroporto);
		
		JButton btnBuscarVoo = new JButton("Buscar V\u00F4o");
		btnBuscarVoo.setEnabled(false);
		btnBuscarVoo.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnBuscarVoo.setBounds(350, 126, 141, 23);
		panel_2.add(btnBuscarVoo);
		
		txtCodVoo = new JTextField();
		txtCodVoo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				btnBuscarVoo.setEnabled(true);
			}
		});
		txtCodVoo.setBounds(161, 81, 179, 20);
		panel_2.add(txtCodVoo);
		txtCodVoo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("C\u00F3digo do V\u00F4o");
		lblNewLabel_2.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(161, 56, 179, 14);
		panel_2.add(lblNewLabel_2);
	}
}
