package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.DadosAeroporto;
import classes.Destino;
import classes.ListaAeroportos;
import classes.ListaVoos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroDeAeroporto extends JFrame {

	private JPanel contentPane;
	private JTextField txtCidade;
	private JTextField txtCodigo;
	private JTextField txtCidade2;
	private JTextField txtCodigo2;
	private DadosAeroporto dadosAtual;
	private ListaAeroportos listaAeroportos;
	private JButton btnProxAero;
	private JButton btnAnteAero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDeAeroporto frame = new CadastroDeAeroporto();
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
	public CadastroDeAeroporto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Aeroporto");
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 11));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Cidade");
		label.setFont(new Font("Georgia", Font.PLAIN, 11));
		label.setBounds(22, 71, 78, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("C\u00F3digo do Aeroporto");
		label_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		label_1.setBounds(22, 96, 145, 14);
		panel_1.add(label_1);
		
		txtCidade = new JTextField();
		txtCidade.setHorizontalAlignment(SwingConstants.CENTER);
		txtCidade.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtCidade.setColumns(10);
		txtCidade.setBounds(177, 68, 86, 20);
		panel_1.add(txtCidade);
		
		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(177, 93, 86, 20);
		panel_1.add(txtCodigo);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					DadosAeroporto dados = new DadosAeroporto (txtCodigo.getText(), txtCidade.getText());
					listaAeroportos.insiraNoFim(dados, null);
					JOptionPane.showMessageDialog(null, "Aeroporto cadastrado com sucesso!");
				}
				catch (Exception error)
				{}
			}
		});
		btnCadastrar.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnCadastrar.setBounds(22, 131, 241, 23);
		panel_1.add(btnCadastrar);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(22, 35, 241, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblAeroportosDisponveis = new JLabel("Aeroportos Dispon\u00EDveis");
		lblAeroportosDisponveis.setHorizontalAlignment(SwingConstants.CENTER);
		lblAeroportosDisponveis.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblAeroportosDisponveis.setBounds(334, 35, 241, 14);
		panel_1.add(lblAeroportosDisponveis);
		
		JLabel label_3 = new JLabel("Cidade");
		label_3.setFont(new Font("Georgia", Font.PLAIN, 11));
		label_3.setBounds(334, 71, 78, 14);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("C\u00F3digo do Aeroporto");
		label_4.setFont(new Font("Georgia", Font.PLAIN, 11));
		label_4.setBounds(334, 96, 145, 14);
		panel_1.add(label_4);
		
		txtCidade2 = new JTextField();
		txtCidade2.setHorizontalAlignment(SwingConstants.CENTER);
		txtCidade2.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtCidade2.setColumns(10);
		txtCidade2.setBounds(489, 68, 86, 20);
		panel_1.add(txtCidade2);
		
		txtCodigo2 = new JTextField();
		txtCodigo2.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo2.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtCodigo2.setColumns(10);
		txtCodigo2.setBounds(489, 93, 86, 20);
		panel_1.add(txtCodigo2);
		
		btnProxAero = new JButton("Pr\u00F3ximo Aeroporto");
		btnProxAero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					dadosAtual = listaAeroportos.getProxDados(dadosAtual);
					showFlight();
					if (listaAeroportos.getProxDados(dadosAtual) == null)
						btnProxAero.setEnabled(false);
				}
				catch (Exception error)
				{}
			}
		});
		btnProxAero.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnProxAero.setBounds(334, 131, 241, 23);
		panel_1.add(btnProxAero);
		
		btnAnteAero = new JButton("Aeroporto Anterior");
		btnAnteAero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					if (dadosAtual.equals(listaAeroportos.getDadosDoFim()))
					{
						dadosAtual = listaAeroportos.getAnteDados(dadosAtual);
						showFlight();
						btnProxAero.setEnabled(true);
					}
					else
					{
						dadosAtual = listaAeroportos.getAnteDados(dadosAtual);
						showFlight();
					}
				}
				catch (Exception error)
				{}
			}
		});
		btnAnteAero.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAnteAero.setBounds(334, 165, 241, 23);
		panel_1.add(btnAnteAero);
	}

	
	protected void initialize() throws Exception
	{
		try
		{
			listaAeroportos = new ListaAeroportos();
			DadosAeroporto dadosBsd = new DadosAeroporto("Brasilia", "BSD");
			DadosAeroporto dadosCnf = new DadosAeroporto("Belo Horizonte", "CNF");
			DadosAeroporto dadosGig = new DadosAeroporto("Rio de Janeiro", "GIG");
			DadosAeroporto dadosGru = new DadosAeroporto("Sao Paulo", "GRU");
			DadosAeroporto dadosSsa = new DadosAeroporto("Salvador", "SSA");
			Destino destinoBsd = new Destino(5, 107);
			Destino destinoCnf = new Destino(5, 214);
			Destino destinoCnf2 = new Destino(3, 555);
			Destino destinoCnf3 = new Destino(4, 101);
			Destino destinoGig = new Destino(2, 554);
			Destino destinoGig2 = new Destino(5, 90);
			Destino destinoGru = new Destino(1, 50);
			Destino destinoGru2 = new Destino(3, 89);
			Destino destinoGru3 = new Destino(2, 102);
			Destino destinoSsa = new Destino(2, 215);
			ListaVoos listaVoosBsd = new ListaVoos();
			ListaVoos listaVoosCnf = new ListaVoos();
			ListaVoos listaVoosGig = new ListaVoos();
			ListaVoos listaVoosGru = new ListaVoos();
			ListaVoos listaVoosSsa = new ListaVoos();
			listaVoosBsd.insiraNoFim(destinoBsd);
			listaVoosCnf.insiraNoFim(destinoCnf);
			listaVoosCnf.insiraNoFim(destinoCnf2);
			listaVoosCnf.insiraNoFim(destinoCnf3);
			listaVoosGig.insiraNoFim(destinoGig);
			listaVoosGig.insiraNoFim(destinoGig2);
			listaVoosGru.insiraNoFim(destinoGru);
			listaVoosGru.insiraNoFim(destinoGru2);
			listaVoosGru.insiraNoFim(destinoGru3);
			listaVoosSsa.insiraNoFim(destinoSsa);
			
			listaAeroportos.insiraNoFim(dadosBsd, listaVoosBsd);
			listaAeroportos.insiraNoFim(dadosCnf, listaVoosCnf);
			listaAeroportos.insiraNoFim(dadosGig, listaVoosGig);
			listaAeroportos.insiraNoFim(dadosGru, listaVoosGru);
			listaAeroportos.insiraNoFim(dadosSsa, listaVoosSsa);
			
			dadosAtual = listaAeroportos.getDadosDoInicio();
			showFlight();
		}
		catch (Exception e)
		{
			System.out.print(e.getMessage());
		}	
	}
		
	protected void showFlight() throws Exception
	{
		try
		{
			btnProxAero.setEnabled(true);
			btnAnteAero.setEnabled(true);
			txtCidade2.setText(dadosAtual.getNome());
			txtCodigo2.setText(dadosAtual.getCodigo());
			
			if (dadosAtual.equals(listaAeroportos.getDadosDoFim()))
				btnProxAero.setEnabled(false);
			
			if (dadosAtual.equals(listaAeroportos.getDadosDoInicio()))
			{
				btnAnteAero.setEnabled(false);
			}
		}
		catch (Exception e)
		{
			System.out.print(e.getMessage());
		}	
	}
}
