package bissecao.gui.componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bissecao.calculo.FuncaoRealX;
import bissecao.util.FuncoesReais;

public class PainelCampos extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel painelPrincipal;
	private JComboBox jcmbxSelecaoFuncoes;
	private JLabel jlblA0, jlblB0, jlblEpsilon, jlblNumeroMaximoIteracoes;
	private JTextField jtxtfldA0, jtxtfldB0, jtxtfldEpsilon, jtxtfldNumeroIteracoes;

	public PainelCampos() {
		super(new BorderLayout(0, 40));

		this.painelPrincipal = new JPanel(new GridLayout(4, 2, 2, 18));

		Object listaFuncoes[] = new FuncoesReais().getFuncoes();
		this.jcmbxSelecaoFuncoes = new JComboBox(listaFuncoes);
		this.jcmbxSelecaoFuncoes.setEditable(false);
		this.jcmbxSelecaoFuncoes.setSelectedItem(null);
		this.jcmbxSelecaoFuncoes.setToolTipText("Selecione uma função");
		this.jcmbxSelecaoFuncoes.setFont(new Font("Arial", Font.BOLD, 16));

		this.jlblA0 = new JLabel("A0.......................................................:");
		this.jlblB0 = new JLabel("B0.......................................................:");
		this.jlblEpsilon = new JLabel("Epsilon..............................................:");
		this.jlblNumeroMaximoIteracoes = new JLabel("N - número máximo de iterações:");

		this.jtxtfldA0 = new JTextField();
		this.jtxtfldA0.setToolTipText("Valor de A0");

		this.jtxtfldB0 = new JTextField();
		this.jtxtfldB0.setToolTipText("Valor de B0");

		this.jtxtfldEpsilon = new JTextField();
		this.jtxtfldEpsilon.setToolTipText("Valor de Epsilon");

		this.jtxtfldNumeroIteracoes = new JTextField();
		this.jtxtfldNumeroIteracoes.setToolTipText("Número máximo de iterações");

		this.limparCampos(true);

		this.painelPrincipal.add(this.jlblA0);
		this.painelPrincipal.add(this.jtxtfldA0);
		this.painelPrincipal.add(this.jlblB0);
		this.painelPrincipal.add(this.jtxtfldB0);
		this.painelPrincipal.add(this.jlblEpsilon);
		this.painelPrincipal.add(this.jtxtfldEpsilon);
		this.painelPrincipal.add(this.jlblNumeroMaximoIteracoes);
		this.painelPrincipal.add(this.jtxtfldNumeroIteracoes);

		this.add(this.jcmbxSelecaoFuncoes, BorderLayout.NORTH);
		this.add(this.painelPrincipal, BorderLayout.CENTER);
	}

	public void setCorFonteCampos(Color cor) {
		this.jcmbxSelecaoFuncoes.setForeground(cor);
		this.jtxtfldA0.setForeground(cor);
		this.jtxtfldB0.setForeground(cor);
		this.jtxtfldEpsilon.setForeground(cor);
		this.jtxtfldNumeroIteracoes.setForeground(cor);
	}

	public void setSelecionarFuncaoEvent(ActionListener evento) {
		this.jcmbxSelecaoFuncoes.addActionListener(evento);
	}

	public FuncaoRealX getFuncaoSelecionada() {
		return (FuncaoRealX) this.jcmbxSelecaoFuncoes.getSelectedItem();
	}

	public void limparCampos(boolean limparFuncao) {
		this.jtxtfldA0.setText("0");
		this.jtxtfldA0.requestFocusInWindow();
		this.jtxtfldB0.setText("0");
		this.jtxtfldEpsilon.setText("0");
		this.jtxtfldNumeroIteracoes.setText("1");

		if (limparFuncao) {
			this.jcmbxSelecaoFuncoes.setSelectedItem(null);
		}

		this.jcmbxSelecaoFuncoes.requestFocusInWindow();
	}

	public double getA0() {
		return Double.parseDouble(this.jtxtfldA0.getText());
	}

	public double getB0() {
		return Double.parseDouble(this.jtxtfldB0.getText());
	}

	public double getEpsilon() {
		return Double.parseDouble(this.jtxtfldEpsilon.getText());
	}

	public int getNumeroMaximoIteracoes() {
		return Integer.parseInt(this.jtxtfldNumeroIteracoes.getText());
	}
}
