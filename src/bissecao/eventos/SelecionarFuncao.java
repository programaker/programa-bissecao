package bissecao.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class SelecionarFuncao implements ActionListener {
	private JComponent exibeFuncao;

	public SelecionarFuncao(JComponent exibeFuncao) {
		this.exibeFuncao = exibeFuncao;
	}

	public SelecionarFuncao() {
		this.exibeFuncao = null;
	}

	public void actionPerformed(ActionEvent e) {
		JComboBox combo = (JComboBox) e.getSource();

		if (combo.getSelectedIndex() == 0) {
			return;
		}

		JLabel label = (JLabel) this.exibeFuncao;
		label.setText(combo.getSelectedItem().toString());
	}

	public JComponent getExibeFuncao() {
		return exibeFuncao;
	}

	public void setExibeFuncao(JComponent exibeFuncao) {
		this.exibeFuncao = exibeFuncao;
	}
}
