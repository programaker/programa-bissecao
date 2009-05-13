package bissecao.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import bissecao.calculo.MetodoBissecao;
import bissecao.gui.componentes.PainelFuncao;
import bissecao.gui.componentes.PainelCampos;
import bissecao.gui.componentes.PainelBotoes;
import bissecao.gui.componentes.GridRaizes;

public class FrameBissecao extends JFrame {
	private static final long serialVersionUID = 1L;
	private Container contentPane;
	private JPanel painelPrincipal;
	private PainelFuncao painelFuncao;
	private PainelBotoes painelBotoes;
	private GridRaizes gridRaizes;
	private PainelCampos painelCampos;

	private class SelecionarFuncaoEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			painelFuncao.setFuncao(painelCampos.getFuncaoSelecionada());
		}
	}

	private class NovosDadosEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			painelCampos.limparCampos(false);
		}
	}

	private class LimparTudoEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			painelCampos.limparCampos(true);
			gridRaizes.limparGrid();
		}
	}

	private class CalcularRaizEvent implements ActionListener {
		private MetodoBissecao bissecao;

		public CalcularRaizEvent() {
			bissecao = new MetodoBissecao();
		}

		private void exibirResultados() throws Exception {
			gridRaizes.setResultado(this.bissecao.calcularRaiz(), this.bissecao.getIteracoesUsadas());
		}

		public void actionPerformed(ActionEvent event) {
			try {
				this.bissecao.setFuncao(painelCampos.getFuncaoSelecionada());
				this.bissecao.setIntervalo(painelCampos.getA0(), painelCampos.getB0());
				this.bissecao.setEpsilon(painelCampos.getEpsilon());
				this.bissecao.setIteracaoMaxima(painelCampos.getNumeroMaximoIteracoes());
				this.exibirResultados();
			} 
			catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e, "Valores inválidos", JOptionPane.INFORMATION_MESSAGE);
				painelCampos.limparCampos(false);
			} 
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro. \nTente novamente com outros valores.", "Erro", JOptionPane.ERROR_MESSAGE);
				painelCampos.limparCampos(false);
			}
		}
	}

	public FrameBissecao() {
		super("Método da bisseção");

		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (Exception e) {
			// ignora e segue em frente com o l.a.f. padrão
		}

		this.criarComponentes();
		this.configurarComponentes();
		this.adicionarComponentes();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(680, 420);
		this.setLocationRelativeTo(null);
		this.pack();
	}

	private void criarComponentes() {
		this.contentPane = this.getContentPane();
		this.painelPrincipal = new JPanel();
		this.painelFuncao = new PainelFuncao();
		this.painelBotoes = new PainelBotoes();
		this.gridRaizes = new GridRaizes();
		this.painelCampos = new PainelCampos();
	}

	private void configurarComponentes() {
		Color cor = new Color(0, 128, 192);

		this.contentPane.setLayout(new BorderLayout(10, 10));
		this.painelPrincipal.setLayout(new GridBagLayout());

		this.painelCampos.setCorFonteCampos(cor);
		this.painelCampos.setSelecionarFuncaoEvent(new SelecionarFuncaoEvent());

		this.gridRaizes.setCorTitulo(cor);
		this.painelFuncao.setCorFuncao(cor);

		this.painelBotoes.setNovosDadosEvent(new NovosDadosEvent());
		this.painelBotoes.setLimparTudoEvent(new LimparTudoEvent());
		this.painelBotoes.setCalcularRaizEvent(new CalcularRaizEvent());
	}

	private void adicionarComponentes() {
		this.contentPane.add(this.painelFuncao, BorderLayout.NORTH);
		this.contentPane.add(this.painelBotoes, BorderLayout.SOUTH);

		int pady = 5;
		Insets insets = new Insets(10, 10, 10, 10);

		GridBagConstraints cnstrtPainelCampos = new GridBagConstraints();
		cnstrtPainelCampos.gridx = 0;
		cnstrtPainelCampos.gridy = 0;
		cnstrtPainelCampos.ipadx = 5;
		cnstrtPainelCampos.ipady = pady;
		cnstrtPainelCampos.insets = insets;
		this.painelPrincipal.add(this.painelCampos, cnstrtPainelCampos);

		GridBagConstraints cnstrtGridRaizes = new GridBagConstraints();
		cnstrtGridRaizes.gridx = 1;
		cnstrtGridRaizes.gridy = 0;
		cnstrtGridRaizes.ipadx = 5;
		cnstrtGridRaizes.ipady = pady;
		cnstrtGridRaizes.insets = insets;
		this.painelPrincipal.add(this.gridRaizes, cnstrtGridRaizes);

		this.contentPane.add(this.painelPrincipal, BorderLayout.CENTER);
	}
}