package bissecao.gui.componentes;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GridRaizes extends JScrollPane {
	private static final long serialVersionUID = 1L;
	private JTable jtblRaizes;
	private DefaultTableModel tableModel;
	private String titulosColunas[] = { "Raízes", "Iterações" };
	private Object dadosTabela[][] = {};

	public GridRaizes() {
		this.tableModel = new DefaultTableModel(this.dadosTabela,
				this.titulosColunas);

		this.jtblRaizes = new JTable(this.tableModel);
		this.jtblRaizes.setShowGrid(true);
		this.jtblRaizes.setRowHeight(18);

		this.setPreferredSize(new Dimension(250, 200));
		this.setViewportView(this.jtblRaizes);
	}

	public void setCorTitulo(Color cor) {
		this.jtblRaizes.getTableHeader().setForeground(cor);
	}

	public void limparGrid() {
		for (int i = 0; i < this.tableModel.getRowCount(); i++) {
			this.tableModel.removeRow(i);
		}
	}

	public void setResultado(double raiz, int iteracoesUsadas) {
		this.tableModel.addRow(new Object[] { new Double(raiz),
				new Integer(iteracoesUsadas) });
	}
}
