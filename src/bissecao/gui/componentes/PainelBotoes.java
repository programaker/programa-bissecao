package bissecao.gui.componentes;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;

public class PainelBotoes extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton jbtnNovosDados, jbtnLimparTudo, jbtnCalcularRaiz;

	public PainelBotoes() {
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(new Dimension(600, 50));

		ImageIcon iconeNovo, iconeLimpar, iconeCalcular;

		iconeNovo = new ImageIcon("Novo 32x32.PNG");
		iconeLimpar = new ImageIcon("Limpar 32x32.GIF");
		iconeCalcular = new ImageIcon("Calcular 32x32.PNG");

		GridBagConstraints cnstrtNovosDados = new GridBagConstraints();
		GridBagConstraints cnstrtLimparTudo = new GridBagConstraints();
		GridBagConstraints cnstrtCalcularRaiz = new GridBagConstraints();

		final int padx = 60, pady = 1, espacoIconeTexto = 10;
		Insets insets = new Insets(3, 15, 3, 15);
		Insets margemBotao = new Insets(5, 10, 5, 10);
		Dimension tamanhoBotoes = new Dimension(125, 37);

		this.jbtnNovosDados = new JButton("Novos dados", iconeNovo);
		this.jbtnNovosDados.setMnemonic('N');
		this.jbtnNovosDados.setPreferredSize(tamanhoBotoes);
		this.jbtnNovosDados.setIconTextGap(espacoIconeTexto);
		this.jbtnNovosDados.setMargin(margemBotao);
		cnstrtNovosDados.gridx = 0;
		cnstrtNovosDados.gridy = 0;
		cnstrtNovosDados.ipadx = padx;
		cnstrtNovosDados.ipady = pady;
		cnstrtNovosDados.insets = insets;

		this.jbtnLimparTudo = new JButton("Limpar tudo", iconeLimpar);
		this.jbtnLimparTudo.setMnemonic('L');
		this.jbtnLimparTudo.setPreferredSize(tamanhoBotoes);
		this.jbtnLimparTudo.setIconTextGap(espacoIconeTexto);
		this.jbtnLimparTudo.setMargin(margemBotao);
		cnstrtLimparTudo.gridx = 1;
		cnstrtLimparTudo.gridy = 0;
		cnstrtLimparTudo.ipadx = padx;
		cnstrtLimparTudo.ipady = pady;
		cnstrtLimparTudo.insets = insets;

		this.jbtnCalcularRaiz = new JButton("Calcular raíz", iconeCalcular);
		this.jbtnCalcularRaiz.setMnemonic('C');
		this.jbtnCalcularRaiz.setPreferredSize(tamanhoBotoes);
		this.jbtnCalcularRaiz.setIconTextGap(espacoIconeTexto);
		this.jbtnCalcularRaiz.setMargin(margemBotao);
		cnstrtCalcularRaiz.gridx = 2;
		cnstrtCalcularRaiz.gridy = 0;
		cnstrtCalcularRaiz.ipadx = padx;
		cnstrtCalcularRaiz.ipady = pady;
		cnstrtCalcularRaiz.insets = insets;

		this.add(this.jbtnNovosDados, cnstrtNovosDados);
		this.add(this.jbtnLimparTudo, cnstrtLimparTudo);
		this.add(this.jbtnCalcularRaiz, cnstrtCalcularRaiz);
	}

	public void setNovosDadosEvent(ActionListener evento) {
		this.jbtnNovosDados.addActionListener(evento);
	}

	public void setLimparTudoEvent(ActionListener evento) {
		this.jbtnLimparTudo.addActionListener(evento);
	}

	public void setCalcularRaizEvent(ActionListener evento) {
		this.jbtnCalcularRaiz.addActionListener(evento);
	}
}
