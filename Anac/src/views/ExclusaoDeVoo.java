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
	 * Launch the application.
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
	 * Create the frame.
	 */
	public ExclusaoDeVoo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		btnProxVoo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					destinoAtual = listaAeroportos.getProxDestino(codAero, destinoAtual);
					/*if (listaAeroportos.getProxDestino(codAero, destinoAtual) == null)
						btnProxVoo.setEnabled(false);*/
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
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Você deseja excluir? O vôo será excluído",
						"Exclusão de Aluno", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_NO_OPTION) {
					try {
						System.out.println(txtNumero.getText());
						listaAeroportos.remova(codAero, Integer.parseInt(txtNumeroVoo.getText()));
						destinoAtual = listaAeroportos.getDestinoDoInicio(codAero);
						txtNumero.setText("");
						showFlight();
						JOptionPane.showMessageDialog(null, "O Vôo foi excluído com sucesso!");
					} catch (Exception error) {
					}
				} else
					JOptionPane.showMessageDialog(null, "Exclusão cancelada!");
			}
		});
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton.setBounds(32, 113, 237, 23);
		panel_1.add(btnNewButton);
	}

	protected void initialize(String codigoAeroporto) throws Exception
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
			
			//dadosAtual = listaAeroportos.getDadosDoInicio();
			codAero = codigoAeroporto;
			destinoAtual = listaAeroportos.getDestinoDoInicio(codAero);
			
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
		{
			System.out.print(e.getMessage());
		}	
	}
	
}
