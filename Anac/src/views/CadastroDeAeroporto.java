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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	 * Executa a aplicação.
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
	 * Cria a tela.
	 */
	public CadastroDeAeroporto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		/**
	     * Adiciona na lista de aeroportos o objeto DadosAeroporto contendo dados fornecidos pelo usuário.
	     *  */
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					if (stringContainsNumber(txtCodigo.getText()) || txtCodigo.getText().length() != 3 || 
							stringContainsNumber(txtCidade.getText()) || txtCidade.getText().length() > 50 
							|| txtCodigo.getText().equals("") || txtCidade.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Código de aeroporto ou cidade inválidos!");
					}
					else
					{
						if (existsCode(txtCodigo.getText().toUpperCase()))
							JOptionPane.showMessageDialog(null, "Código de aeroporto existente!");
						else
						{
							DadosAeroporto dados = new DadosAeroporto (txtCidade.getText(), txtCodigo.getText().toUpperCase());
							listaAeroportos.insiraAeroportoNoFim(dados);
							dadosAtual = listaAeroportos.getDadosDoInicio();
							showFlight();
							JOptionPane.showMessageDialog(null, "Aeroporto cadastrado com sucesso!");
						}
					}
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
		
		/**
	     * Altera o objeto DadosAeroporto atual para seu posterior.
	     *  */
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
		
		/**
	     * Altera o objeto DadosAeroporto atual para seu anterior.
	     *  */
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

	 /**
     * Adiciona objetos Destino,ListaVoos e DadosAeroporto ao objeto ListaAeroportos.
     *  */
	protected void initialize()
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
			showFlight();
		}
		catch (Exception e)
		{}	
	}
		
	 /**
     * Altera o texto dos componentes do formulário e desabilita botões de anterior e próximo caso o objeto dadosAtual seja o primeiro ou último da lista de aeroportos.
     *  */
	protected void showFlight()
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
		{}
	}
	
	/**
     * Verifica se código de aeroporto existe na lista de aeroportos.
     * @param codigo String contedo o código do aeroporto.
     * @return Retorna true se código existe ou false caso não exista na lista de aeroportos.
     *  */
	protected boolean existsCode(String codigo)
	{
		boolean ret = false;
		try
		{
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
     * Verifica se a string fornecida contém ou não valor númerico.
     * @param s String contedo o texto fornecido.
     * @return Retorna true se a string contém o valor númerico ou false caso a string não contenha valor numérico.
     *  */
	protected boolean stringContainsNumber (String s)
	{
	    Pattern p = Pattern.compile( "[0-9]" );
	    Matcher m = p.matcher( s );

	    return m.find();
	}
}
