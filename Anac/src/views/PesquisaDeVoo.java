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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PesquisaDeVoo extends JFrame {

	private JPanel contentPane;
	private JTextField txtCidade;
	private JTextField txtCodigo;
	private JTextField txtNumero;
	private JTextField txtIndice;
	private ListaAeroportos listaAeroportos;
	private DadosAeroporto dadosAtual;
	private Destino destinoAtual;
	private ListaVoos listaVoosAtual;
	private JButton btnProxVoo;
	private JButton btnAnteVoo;

	/**
	 * Executa a aplica��o.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaDeVoo frame = new PesquisaDeVoo();
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
	public PesquisaDeVoo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 578, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Pesquisa de V\u00F4o");
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 11));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblAeroporto = new JLabel("Aeroporto");
		lblAeroporto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAeroporto.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblAeroporto.setBounds(23, 48, 237, 14);
		panel_1.add(lblAeroporto);
		
		JLabel label_1 = new JLabel("Cidade");
		label_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		label_1.setBounds(23, 97, 78, 14);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("C\u00F3digo do Aeroporto");
		label_2.setFont(new Font("Georgia", Font.PLAIN, 11));
		label_2.setBounds(21, 122, 145, 14);
		panel_1.add(label_2);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtCidade.setHorizontalAlignment(SwingConstants.CENTER);
		txtCidade.setColumns(10);
		txtCidade.setBounds(176, 94, 86, 20);
		panel_1.add(txtCidade);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(176, 119, 86, 20);
		panel_1.add(txtCodigo);
		
		JLabel lblCdigoDoAeroporto = new JLabel("C\u00F3digo do Aeroporto");
		lblCdigoDoAeroporto.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblCdigoDoAeroporto.setBounds(309, 97, 119, 14);
		panel_1.add(lblCdigoDoAeroporto);
		
		JLabel label_4 = new JLabel("N\u00FAmero do V\u00F4o");
		label_4.setFont(new Font("Georgia", Font.PLAIN, 11));
		label_4.setBounds(309, 122, 119, 14);
		panel_1.add(label_4);
		
		btnProxVoo = new JButton("Pr\u00F3ximo V\u00F4o");
		
		/**
		 * Muda para o pr�ximo voo da lista.
		 * */
		btnProxVoo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try
				{
					destinoAtual = listaAeroportos.getProxDestino(dadosAtual.getCodigo(), destinoAtual);
					/*if (listaAeroportos.getProxDestino(dadosAtual.getCodigo(),destinoAtual) == null)
						btnProxVoo.setEnabled(false);*/
					showFlight();
				}
				catch (Exception error)
				{}
			}
		});
		btnProxVoo.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnProxVoo.setBounds(309, 147, 223, 23);
		panel_1.add(btnProxVoo);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtNumero.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumero.setColumns(10);
		txtNumero.setBounds(446, 119, 86, 20);
		panel_1.add(txtNumero);
		
		txtIndice = new JTextField();
		txtIndice.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtIndice.setHorizontalAlignment(SwingConstants.CENTER);
		txtIndice.setColumns(10);
		txtIndice.setBounds(446, 94, 86, 20);
		panel_1.add(txtIndice);
		
		JLabel label_5 = new JLabel("V\u00F4os");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Georgia", Font.PLAIN, 11));
		label_5.setBounds(309, 48, 204, 14);
		panel_1.add(label_5);
		
		btnAnteVoo = new JButton("V\u00F4o Anterior");
		
		/**
		 *  Muda para o voo anterior na lista
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
		btnAnteVoo.setBounds(309, 181, 223, 23);
		panel_1.add(btnAnteVoo);
	}
	
	
	 /**
     * Adiciona objetos Destino e ListaVoos ao objeto ListaAeroportos.
     *  */
	public void initialize(String codigo) throws Exception
	{
		try
		{
			listaAeroportos = new ListaAeroportos();
			DadosAeroporto dadosBsd = new DadosAeroporto("Bras�lia", "BSD");
			DadosAeroporto dadosCnf = new DadosAeroporto("Belo Horizonte", "CNF");
			DadosAeroporto dadosGig = new DadosAeroporto("Rio de Janeiro", "GIG");
			DadosAeroporto dadosGru = new DadosAeroporto("S�o Paulo", "GRU");
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
		}
		catch (Exception e)
		{
			System.out.print(e.getMessage());
		}	
	}
	
	protected boolean existsCode(String codigo) throws Exception
	{
		boolean ret = false;
		try
		{
			initialize(codigo);
			if (listaAeroportos.temAeroporto(codigo))
			{
				ret = true;
			}
			else
			{
				ret = false;;
			}
		}
		catch (Exception e)
		{}
		
		return ret;
	}
	
	
	 /**
     * Altera o texto dos componentes do formul�rio e desabilita bot�es de anterior e pr�ximo caso o objeto dadosAtual seja o primeiro ou �ltimo da lista de aeroportos.
     *  */
	protected void showFlight() throws Exception
	{
		try
		{
			btnAnteVoo.setEnabled(true);
			btnProxVoo.setEnabled(true);
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
		}
		catch (Exception e)
		{
			System.out.print(e.getMessage());
		}	
	}
	
	 /**
     * Altera o texto dos componentes do formul�rio e desabilita bot�es de anterior e pr�ximo caso o objeto dadosAtual seja o primeiro ou �ltimo da lista de aeroportos 
     * de acordo com o c�digo passado.
     * @param codigo string contendo o c�digo do aeroporto desejado.
     *  */
	protected void showFlight(String codigo) throws Exception
	{
		try
		{
			dadosAtual = listaAeroportos.getAeroporto(codigo);
			listaVoosAtual = listaAeroportos.getListaDeVoos(codigo);
			destinoAtual = listaAeroportos.getDestinoDoInicio(codigo);
			txtCidade.setText(dadosAtual.getNome());
			txtCodigo.setText(dadosAtual.getCodigo());
			txtIndice.setText("" + destinoAtual.getAeroportoDestino().getDados().getCodigo());
			txtNumero.setText("" + destinoAtual.getNumeroVoo());
			btnAnteVoo.setEnabled(false);
			
			if (destinoAtual.equals(listaAeroportos.getDestinoDoFim(dadosAtual.getCodigo())))
				btnProxVoo.setEnabled(false);
		}
		catch (Exception e)
		{
			System.out.print(e.getMessage());
		}	
	}
}
