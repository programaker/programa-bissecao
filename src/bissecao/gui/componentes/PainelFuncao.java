package bissecao.gui.componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import bissecao.calculo.FuncaoRealX;

public class PainelFuncao extends JPanel {
	private static final long serialVersionUID = 1L;
	private final String FUNCAO_INDEFINIDA = "F(X) = ???";
	private JLabel jlblFuncao;

	public PainelFuncao() {
		super(new BorderLayout());
		
		Border bordaBaixa = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
		Border bordaAlta = BorderFactory.createBevelBorder(BevelBorder.RAISED);
		Border bordaComposta = BorderFactory.createCompoundBorder(bordaAlta, bordaBaixa);
		this.setBorder(bordaComposta);

		this.jlblFuncao = new JLabel(this.FUNCAO_INDEFINIDA);
		this.jlblFuncao.setHorizontalTextPosition(SwingConstants.CENTER);
		this.jlblFuncao.setHorizontalAlignment(SwingConstants.CENTER);
		this.jlblFuncao.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 36));
		this.jlblFuncao.setPreferredSize(new Dimension(215, 50));

		this.add(this.jlblFuncao, BorderLayout.CENTER);
	}

	public void setFuncao(FuncaoRealX funcao) {
		if (funcao == null) {
			this.jlblFuncao.setText(this.FUNCAO_INDEFINIDA);
		} else {
			this.jlblFuncao.setText(funcao.toString());
		}
	}

	public void setCorFuncao(Color cor) {
		this.jlblFuncao.setForeground(cor);
	}
}
