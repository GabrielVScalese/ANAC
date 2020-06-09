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
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExclusaoDeVoo extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroVoo;
	private JTextField txtIndice;
	private JTextField txtNumero;
	private Destino destinoAtual;
	private ListaAeroportos listaAeroportos;
	private DadosAeroporto dadosAtual;
	private String codAero;
	private JButton btnProxVoo;
	private JButton btnAnteVoo;

	/**
	 * Executa a aplicação.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExclusaoDeVoo frame = new ExclusaoDeVoo();
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
	public ExclusaoDeVoo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 588, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Exclus\u00E3o de V\u00F4o");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblExcluirVo = new JLabel("Excluir V\u00F4o");
		lblExcluirVo.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluirVo.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblExcluirVo.setBounds(32, 30, 237, 14);
		panel_1.add(lblExcluirVo);
		
		JLabel lblNmeroDoVo = new JLabel("N\u00FAmero do V\u00F4o");
		lblNmeroDoVo.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblNmeroDoVo.setBounds(32, 79, 119, 14);
		panel_1.add(lblNmeroDoVo);
		
		txtNumeroVoo = new JTextField();
		txtNumeroVoo.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroVoo.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtNumeroVoo.setColumns(10);
		txtNumeroVoo.setBounds(185, 76, 86, 20);
		panel_1.add(txtNumeroVoo);
		
		JLabel lblVosDi = new JLabel("V\u00F4os Dispon\u00EDveis");
		lblVosDi.setHorizontalAlignment(SwingConstants.CENTER);
		lblVosDi.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblVosDi.setBounds(332, 33, 204, 14);
		panel_1.add(lblVosDi);
		
		JLabel label_4 = new JLabel("\u00CDndice da Cidade");
		label_4.setFont(new Font("Georgia", Font.PLAIN, 11));
		label_4.setBounds(332, 82, 119, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("N\u00FAmero do V\u00F4o");
		label_5.setFont(new Font("Georgia", Font.PLAIN, 11));
		label_5.setBounds(332, 107, 119, 14);
		panel_1.add(label_5);
		
		txtIndice = new JTextField();
		txtIndice.setHorizontalAlignment(SwingConstants.CENTER);
		txtIndice.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtIndice.setColumns(10);
		txtIndice.setBounds(450, 79, 86, 20);
		panel_1.add(txtIndice);
		
		txtNumero = new JTextField();
		txtNumero.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumero.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtNumero.setColumns(10);
		txtNumero.setBounds(450, 104, 86, 20);
		panel_1.add(txtNumero);
		
		btnProxVoo = new JButton("Pr\u00F3ximo V\u00F4o");
		
		/**
	     * Altera o objeto Destino atual para seu posterior.
	     *  */
		btnProxVoo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					destinoAtual = listaAeroportos.getProxDestino(codAero, destinoAtual);
					showFlight();
				}
				catch (Exception error)
				{}
			}
		});
		btnProxVoo.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnProxVoo.setBounds(332, 138, 204, 23);
		panel_1.add(btnProxVoo);
		
		btnAnteVoo = new JButton("V\u00F4o Anterior");
		
		/**
	     * Altera o objeto Destino atual para seu anterior.
	     *  */
		btnAnteVoo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					if (destinoAtual.equals(listaAeroportos.getDestinoDoFim(codAero)))
					{
						destinoAtual = listaAeroportos.getAnteDestino(codAero, destinoAtual);
						showFlight();
						btnProxVoo.setEnabled(true);
					}
					else
					{
						destinoAtual = listaAeroportos.getAnteDestino(codAero, destinoAtual);
						showFlight();
					}
				}
				catch (Exception error)
				{}
			}
		});
		btnAnteVoo.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnAnteVoo.setBounds(332, 172, 204, 23);
		panel_1.add(btnAnteVoo);
		
		JButton btnNewButton = new JButton("Excluir");
		
		/**
	     * Exclui da lista de vôos o objeto Destino indicado pelo número do vôo e a partir do código do aeroporto.
	     *  */
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!txtNumeroVoo.getText().matches("[0-9]+") || txtNumeroVoo.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Número de vôo inválido!");
				}
				else
				{
					try
					{
						if (!existsNumberFlight(codAero, Integer.parseInt(txtNumeroVoo.getText())))
						{
							JOptionPane.showMessageDialog(null, "Número de vôo inexistente!");
						}
						else
						{
							int result = JOptionPane.showConfirmDialog(null, "Você deseja excluir? O vôo será excluído",
									"Exclusão de Voo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (result == JOptionPane.YES_NO_OPTION) 
							{
								try
								{
									
									listaAeroportos.removaVoo(codAero, Integer.parseInt(txtNumeroVoo.getText()));
									if (listaAeroportos.getListaDeVoos(codAero).getQtd() == 0)
									{
										txtIndice.setText("");
										txtNumero.setText("");
										JOptionPane.showMessageDialog(null, "O Vôo foi excluído com sucesso!");
									}
									else
									{
										destinoAtual = listaAeroportos.getDestinoDoInicio(codAero);
										txtNumero.setText("");
										showFlight();
										JOptionPane.showMessageDialog(null, "O Vôo foi excluído com sucesso!");
									}
								}
								catch (Exception error)
								{}
								
							} else
								JOptionPane.showMessageDialog(null, "Exclusão cancelada!");
						}
					}
					catch (Exception error)
					{}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton.setBounds(32, 113, 237, 23);
		panel_1.add(btnNewButton);
	}

	/**
     * Adiciona objetos Destino e ListaVoos ao objeto ListaAeroportos.
     *  */
	protected void initialize(String codigoAeroporto) throws Exception
	{
		try
		{
			listaAeroportos = new ListaAeroportos();
			DadosAeroporto dadosBsd = new DadosAeroporto("Brasília", "BSD");
			DadosAeroporto dadosCnf = new DadosAeroporto("Belo Horizonte", "CNF");
			DadosAeroporto dadosGig = new DadosAeroporto("Rio de Janeiro", "GIG");
			DadosAeroporto dadosGru = new DadosAeroporto("São Paulo", "GRU");
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
			
			codAero = codigoAeroporto;
			destinoAtual = listaAeroportos.getDestinoDoInicio(codAero);
		}
		catch (Exception e)
		{
			System.out.print(e.getMessage());
		}	
	}
	
	/**
     * Verifica se o número de vôo existe na lista de vôos a partir do código do aeroporto.
     * @param codigo String contedo o código do aeroporto.
     * @param numeroVoo Integer contedo o número do vôo.
     * @return Retorna true se número de vôo existe ou false caso não exista na lista de vôos.
     *  */
	protected boolean existsNumberFlight (String codigo, int numeroVoo) throws Exception
	{
		boolean ret = false;
		try
		{
			if (listaAeroportos.temVoo(codigo, numeroVoo))
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
     * Verifica se código de aeroporto existe na lista de aeroportos.
     * @param codigo String contedo o código do aeroporto.
     * @return Retorna true se código existe ou false caso não exista na lista de aeroportos.
     *  */
	protected boolean existsCode(String codigo)
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
     * Altera o texto dos componentes do formulário e desabilita botões de anterior e próximo caso o objeto destinoAtual seja o primeiro ou último da lista de vôos.
     *  */
	protected void showFlight()
	{
		try
		{
			btnProxVoo.setEnabled(true);
			btnAnteVoo.setEnabled(true);
			txtIndice.setText("" + destinoAtual.getIndice());
			txtNumero.setText("" + destinoAtual.getNumeroVoo());
			
			if (listaAeroportos.getProxDestino(codAero, destinoAtual) == null)
				btnProxVoo.setEnabled(false);
			
			if (destinoAtual.equals(listaAeroportos.getDestinoDoInicio(codAero)))
			{
				btnAnteVoo.setEnabled(false);
			}
		}
		catch (Exception e)
		{}	
	}
	
}
