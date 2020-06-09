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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingConstants;
import java.awt.Font;

public class CadastroDeVoo extends JFrame {

	private JPanel contentPane;
	private DadosAeroporto dadosAeroporto;
	private Destino destino;
	private ListaVoos listaVoos;
	private DadosAeroporto dadosAtual;
	private Destino destinoAtual;
	private ListaAeroportos listaAeroportos;
	private JTextField txtCodAero;
	private JTextField txtNumeroVoo;
	private JTextField txtIndiceCidade;
	
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Cadastro de V\u00F4o");
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 11));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Aeroporto de origem :");
		label.setFont(new Font("Georgia", Font.PLAIN, 11));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 89, 129, 14);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(10, 114, 129, 78);
		panel_1.add(panel_2);
		
		JLabel label_1 = new JLabel("C\u00F3digo :");
		label_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 6, 109, 14);
		panel_2.add(label_1);
		
		txtCodAero = new JTextField();
		txtCodAero.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtCodAero.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodAero.setColumns(10);
		txtCodAero.setBounds(10, 31, 109, 20);
		panel_2.add(txtCodAero);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Pattern p = Pattern.compile( "[0-9]" );
				    Matcher m = p.matcher(txtCodAero.getText());
					if (m.find() || txtCodAero.getText().toUpperCase().length() != 3 || txtCodAero.getText().toUpperCase().equals("") || 
							!txtNumeroVoo.getText().matches("[0-9]+") || Integer.parseInt(txtNumeroVoo.getText()) < 0 || 
							txtNumeroVoo.getText().equals("") || !txtIndiceCidade.getText().matches("[0-9]+") || Integer.parseInt(txtIndiceCidade.getText()) < 0 || 
							txtIndiceCidade.equals(""))
					{
						JOptionPane.showMessageDialog(null, "Dado fornecido é inválido!");
					}
					else
					{
						if (!existsCode(txtCodAero.getText().toUpperCase()))
						{
							JOptionPane.showMessageDialog(null, "Código de aeroporto inexistente!");
						}
						else
						{
							if (listaAeroportos.temVoo(txtCodAero.getText().toUpperCase(),Integer.parseInt(txtNumeroVoo.getText())))
							{
								JOptionPane.showMessageDialog(null, "Número de vôo existente!");
							}
							else
							{
								Destino destino = new Destino (Integer.parseInt(txtIndiceCidade.getText()), Integer.parseInt(txtNumeroVoo.getText()));
								listaAeroportos.inserirVoo(txtCodAero.getText().toUpperCase(), destino);
								System.out.println(listaAeroportos.getLista(txtCodAero.getText().toUpperCase()));
								JOptionPane.showMessageDialog(null, "O Vôo " + destino.getNumeroVoo() + " foi inserido com sucesso!");
							}
						}
					}
				}
				catch (Exception error)
				{}
			}
		});
		btnCadastrar.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnCadastrar.setBounds(149, 169, 206, 23);
		panel_1.add(btnCadastrar);
		
		JLabel lblNmeroDoVo = new JLabel("N\u00FAmero do V\u00F4o : ");
		lblNmeroDoVo.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblNmeroDoVo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNmeroDoVo.setBounds(169, 27, 166, 14);
		panel_1.add(lblNmeroDoVo);
		
		txtNumeroVoo = new JTextField();
		txtNumeroVoo.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtNumeroVoo.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroVoo.setColumns(10);
		txtNumeroVoo.setBounds(169, 52, 166, 20);
		panel_1.add(txtNumeroVoo);
		
		JLabel label_3 = new JLabel("Aeroporto de Destino :");
		label_3.setFont(new Font("Georgia", Font.PLAIN, 11));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(365, 89, 129, 14);
		panel_1.add(label_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.setBounds(365, 114, 129, 78);
		panel_1.add(panel_3);
		
		txtIndiceCidade = new JTextField();
		txtIndiceCidade.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtIndiceCidade.setHorizontalAlignment(SwingConstants.CENTER);
		txtIndiceCidade.setColumns(10);
		txtIndiceCidade.setBounds(10, 36, 109, 20);
		panel_3.add(txtIndiceCidade);
		
		JLabel lblndiceDaCidade = new JLabel("\u00CDndice da Cidade :");
		lblndiceDaCidade.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblndiceDaCidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblndiceDaCidade.setBounds(10, 11, 109, 14);
		panel_3.add(lblndiceDaCidade);
		
		
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
}
