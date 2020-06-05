package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import classes.DadosAeroporto;
import classes.Destino;
import classes.ListaAeroportos;
import classes.ListaVoos;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CadastroDeVoo extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroVoo;
	private JTextField txtCodOrigem;
	private JTextField txtCodDestino;
	private JTextField txtCidadeOrigem;
	private JTextField txtCidadeDestino;
	private ListaAeroportos listaAeroportos;
	private DadosAeroporto dadosAeroporto;
	private Destino destino;
	private ListaVoos listaVoos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDeVoo frame = new CadastroDeVoo();
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
	public CadastroDeVoo() {
		setTitle("Cadastro de Voos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeVoos = new JLabel("Cadastro de Voos");
		lblCadastroDeVoos.setBounds(179, 11, 115, 14);
		contentPane.add(lblCadastroDeVoos);
		
		JLabel lblNmeroDoVoo = new JLabel("N\u00FAmero do Voo : ");
		lblNmeroDoVoo.setBounds(190, 61, 85, 14);
		contentPane.add(lblNmeroDoVoo);
		
		txtNumeroVoo = new JTextField();
		txtNumeroVoo.setBounds(179, 86, 96, 20);
		contentPane.add(txtNumeroVoo);
		txtNumeroVoo.setColumns(10);
		
		JLabel lblAeroportoDeOrigem = new JLabel("Aeroporto de origem :");
		lblAeroportoDeOrigem.setBounds(34, 118, 121, 14);
		contentPane.add(lblAeroportoDeOrigem);
		
		JLabel lblAeroportoDeDestino = new JLabel("Aeroporto de Destino :");
		lblAeroportoDeDestino.setBounds(306, 118, 121, 14);
		contentPane.add(lblAeroportoDeDestino);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(26, 143, 129, 115);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo :");
		lblCodigo.setBounds(47, 6, 72, 14);
		panel.add(lblCodigo);
		
		txtCodOrigem = new JTextField();
		
		txtCodOrigem.setColumns(10);
		txtCodOrigem.setBounds(10, 31, 109, 20);
		panel.add(txtCodOrigem);
		
		JLabel lblNome = new JLabel("Cidade : ");
		lblNome.setBounds(47, 62, 48, 14);
		panel.add(lblNome);
		
		txtCidadeOrigem = new JTextField();
		txtCidadeOrigem.setEnabled(false);
		txtCidadeOrigem.setColumns(10);
		txtCidadeOrigem.setBounds(10, 84, 109, 20);
		panel.add(txtCidadeOrigem);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(298, 143, 129, 114);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("C\u00F3digo :");
		label.setBounds(47, 11, 72, 14);
		panel_1.add(label);
		
		txtCodDestino = new JTextField();
		
		txtCodDestino.setColumns(10);
		txtCodDestino.setBounds(10, 36, 109, 20);
		panel_1.add(txtCodDestino);
		
		txtCidadeDestino = new JTextField();
		txtCidadeDestino.setEnabled(false);
		txtCidadeDestino.setColumns(10);
		txtCidadeDestino.setBounds(10, 83, 109, 20);
		panel_1.add(txtCidadeDestino);
		
		JLabel lblCidade = new JLabel("Cidade : ");
		lblCidade.setBounds(47, 61, 48, 14);
		panel_1.add(lblCidade);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int numVoo;
				String codOrigem, codDestino; 
				
				try
				{
					numVoo = Integer.parseInt(txtNumeroVoo.getText());
					codOrigem = txtCodOrigem.getText();
					codDestino = txtCodDestino.getText();
					
					destino = new Destino(5, numVoo);
					listaVoos.insiraNoFim(destino);
				}
				catch(Exception err)
				{
					JOptionPane.showMessageDialog(null, "Número de vôo inválido!");
				}
			}
		});
		btnCadastrar.setBounds(186, 235, 89, 23);
		contentPane.add(btnCadastrar);
		
		
	}
}
