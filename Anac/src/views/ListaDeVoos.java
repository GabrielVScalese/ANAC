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

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class ListaDeVoos extends JFrame {

	private JPanel contentPane;
	private JTextField txtCidade;
	private JTextField txtCodigo;
	private JTextField txtIndice;
	private JTextField txtNumero;
	private JButton btnProxVoo;
	private JButton btnAnteVoo;
	private JButton btnAnteAero;
	private DadosAeroporto dadosAtual;
	private Destino destinoAtual;
	private ListaAeroportos listaAeroportos;
	

	/**
	 * Executa a aplicação.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaDeVoos frame = new ListaDeVoos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria a tela.
	 */
	public ListaDeVoos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 608, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Exibi\u00E7\u00E3o de V\u00F4os");
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 11));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtCidade.setHorizontalAlignment(SwingConstants.CENTER);
		txtCidade.setBounds(196, 70, 86, 20);
		txtCidade.setColumns(10);
		panel_1.add(txtCidade);
		
		JLabel lblNewLabel_1 = new JLabel("Cidade");
		lblNewLabel_1.setBounds(41, 73, 78, 14);
		lblNewLabel_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		panel_1.add(lblNewLabel_1);
		
		JButton btnProxAero = new JButton("Pr\u00F3ximo Aeroporto");
		
		/**
		 * Muda o aeroporto selecionado para o próximo da lista.
		 * */
		btnProxAero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					dadosAtual = listaAeroportos.getProxDados(dadosAtual);
					destinoAtual = listaAeroportos.getDestinoDoInicio(dadosAtual.getCodigo());
					showFlight();
					if (listaAeroportos.getProxDados(dadosAtual) == null)
						btnProxAero.setEnabled(false);
				}
				catch (Exception error)
				{}
			}
		});
		btnProxAero.setBounds(41, 142, 250, 23);
		btnProxAero.setFont(new Font("Georgia", Font.PLAIN, 11));
		panel_1.add(btnProxAero);
		
		JLabel lblCdigoDoAeroporto = new JLabel("C\u00F3digo do Aeroporto");
		lblCdigoDoAeroporto.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblCdigoDoAeroporto.setBounds(41, 98, 145, 14);
		panel_1.add(lblCdigoDoAeroporto);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(196, 101, 86, 20);
		panel_1.add(txtCodigo);
		
		JLabel lblndiceDaCidade = new JLabel("C\u00F3digo do Aeroporto");
		lblndiceDaCidade.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblndiceDaCidade.setBounds(340, 73, 119, 14);
		panel_1.add(lblndiceDaCidade);
		
		txtIndice = new JTextField();
		txtIndice.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtIndice.setHorizontalAlignment(SwingConstants.CENTER);
		txtIndice.setColumns(10);
		txtIndice.setBounds(475, 70, 86, 20);
		panel_1.add(txtIndice);
		
		JLabel lblNmeroDoVo = new JLabel("N\u00FAmero do V\u00F4o");
		lblNmeroDoVo.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblNmeroDoVo.setBounds(340, 98, 119, 14);
		panel_1.add(lblNmeroDoVo);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtNumero.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumero.setColumns(10);
		txtNumero.setBounds(475, 95, 86, 20);
		panel_1.add(txtNumero);
		
		btnProxVoo = new JButton("Pr\u00F3ximo V\u00F4o");
		
		/**
		 * Muda o voo para o próximo da lista relacionado com o aeroporto selecionado.
		 * */
		btnProxVoo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					destinoAtual = listaAeroportos.getProxDestino(dadosAtual.getCodigo(), destinoAtual);
					if (listaAeroportos.getProxDestino(dadosAtual.getCodigo(), destinoAtual) == null)
						btnProxVoo.setEnabled(false);
					showFlight();
				}
				catch (Exception error)
				{}
			}
		});
		btnProxVoo.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnProxVoo.setBounds(340, 142, 221, 23);
		panel_1.add(btnProxVoo);
		
		JLabel lblNewLabel_2 = new JLabel("Aeroportos");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(41, 24, 241, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("V\u00F4os");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(340, 24, 204, 14);
		panel_1.add(lblNewLabel_3);
		
		btnAnteAero = new JButton("Aeroporto Anterior");
		
		/**
		 * Muda o aeroporto para o anterior da lista.
		 * */
		btnAnteAero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					if (dadosAtual.equals(listaAeroportos.getDadosDoFim()))
					{
						dadosAtual = listaAeroportos.getAnteDados(dadosAtual);
						destinoAtual = listaAeroportos.getDestinoDoInicio(dadosAtual.getCodigo());
						showFlight();
						btnProxAero.setEnabled(true);
					}
					else
					{
						dadosAtual = listaAeroportos.getAnteDados(dadosAtual);
						destinoAtual = listaAeroportos.getDestinoDoInicio(dadosAtual.getCodigo());
						showFlight();
					}
				}
				catch (Exception error)
				{}
			}
		});
		btnAnteAero.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAnteAero.setBounds(41, 176, 250, 23);
		panel_1.add(btnAnteAero);
		
		btnAnteVoo = new JButton("V\u00F4o Anterior");
		
		/**
		 * Muda o voo para o anterior na lista.
		 * */
		btnAnteVoo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					if (destinoAtual.equals(listaAeroportos.getDestinoDoFim(dadosAtual.getCodigo())))
					{
						destinoAtual = listaAeroportos.getAnteDestino(dadosAtual.getCodigo(), destinoAtual);
						showFlight();
						btnProxVoo.setEnabled(true);
					}
					else
					{
						destinoAtual = listaAeroportos.getAnteDestino(dadosAtual.getCodigo(), destinoAtual);
						showFlight();
					}
				}
				catch (Exception error)
				{}
			}
		});
		btnAnteVoo.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAnteVoo.setBounds(340, 176, 221, 23);
		panel_1.add(btnAnteVoo);
	}
	
	/**
     * Adiciona objetos Destino, ListaVoos e DadosAeroporto ao objeto ListaAeroportos.
     *  */
	protected void initialize() throws Exception
	{
		try
		{
			listaAeroportos = new ListaAeroportos();
			DadosAeroporto dadosBsd = new DadosAeroporto("Brasília", "BSD");
			DadosAeroporto dadosCnf = new DadosAeroporto("Belo Horizonte", "CNF");
			DadosAeroporto dadosGig = new DadosAeroporto("Rio de Janeiro", "GIG");
			DadosAeroporto dadosGru = new DadosAeroporto("São Paulo", "GRU");
			DadosAeroporto dadosSsa = new DadosAeroporto("Salvador", "SSA");
			
			listaAeroportos.insiraAeroportoNoFim(dadosBsd);
			listaAeroportos.insiraAeroportoNoFim(dadosCnf);
			listaAeroportos.insiraAeroportoNoFim(dadosGig);
			listaAeroportos.insiraAeroportoNoFim(dadosGru);
			listaAeroportos.insiraAeroportoNoFim(dadosSsa);
			
			Destino destinoBsd = new Destino(listaAeroportos.getAeroportoDestino("SSA"), 107);
			Destino destinoCnf = new Destino(listaAeroportos.getAeroportoDestino("SSA"), 214);
			Destino destinoCnf2 = new Destino(listaAeroportos.getAeroportoDestino("GIG"), 555);
			Destino destinoCnf3 = new Destino(listaAeroportos.getAeroportoDestino("GRU"), 101);
			Destino destinoGig = new Destino(listaAeroportos.getAeroportoDestino("CNF"), 554);
			Destino destinoGig2 = new Destino(listaAeroportos.getAeroportoDestino("GRU"), 90);
			Destino destinoGru = new Destino(listaAeroportos.getAeroportoDestino("BSD"), 50);
			Destino destinoGru2 = new Destino(listaAeroportos.getAeroportoDestino("GIG"), 89);
			Destino destinoGru3 = new Destino(listaAeroportos.getAeroportoDestino("CNF"), 102);
			Destino destinoSsa = new Destino(listaAeroportos.getAeroportoDestino("CNF"), 215);
			
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
			
			listaAeroportos.insiraListaVoos(dadosBsd.getCodigo(), listaVoosBsd);
			listaAeroportos.insiraListaVoos(dadosCnf.getCodigo(), listaVoosCnf);
			listaAeroportos.insiraListaVoos(dadosGig.getCodigo(), listaVoosGig);
			listaAeroportos.insiraListaVoos(dadosGru.getCodigo(), listaVoosGru);
			listaAeroportos.insiraListaVoos(dadosSsa.getCodigo(), listaVoosSsa);
			
			dadosAtual = listaAeroportos.getDadosDoInicio();
			destinoAtual = listaAeroportos.getDestinoDoInicio(dadosAtual.getCodigo());
			showFlight();
		}
		catch (Exception e)
		{
			System.out.print(e.getMessage());
		}	
	}
	
	
	/**
     * Altera o texto dos componentes do formulário e desabilita botões de anterior e próximo caso o objeto dadosAtual seja o primeiro ou último da lista de aeroportos.
     *  */
	protected void showFlight() throws Exception
	{
		try
		{
			btnAnteAero.setEnabled(true);
			btnProxVoo.setEnabled(true);
			btnAnteVoo.setEnabled(true);
			txtCidade.setText(dadosAtual.getNome());
			txtCodigo.setText(dadosAtual.getCodigo());
			txtIndice.setText("" + destinoAtual.getAeroportoDestino().getDados().getCodigo());
			txtNumero.setText("" + destinoAtual.getNumeroVoo());
			
			if (destinoAtual.equals(listaAeroportos.getDestinoDoFim(dadosAtual.getCodigo())))
				btnProxVoo.setEnabled(false);
			
			if (destinoAtual.equals(listaAeroportos.getDestinoDoInicio(dadosAtual.getCodigo())))
			{
				btnAnteVoo.setEnabled(false);
			}
			
			if (dadosAtual.equals(listaAeroportos.getDadosDoInicio()))
				btnAnteAero.setEnabled(false);
		}
		catch (Exception e)
		{
			System.out.print(e.getMessage());
		}	
	}
}
