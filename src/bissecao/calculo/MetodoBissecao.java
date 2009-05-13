/*
 * Created on 31/12/2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package bissecao.calculo;

public class MetodoBissecao {
	private FuncaoRealX funcao;
	private double a0, b0, epsilon;
	private int iteracaoMaxima, iteracoesUsadas = 1;

	public MetodoBissecao() {
		this.funcao = null;
		this.a0 = 0;
		this.b0 = 0;
		this.epsilon = 0;
		this.iteracaoMaxima = 1;
	}

	public MetodoBissecao(FuncaoRealX funcao) {
		this.funcao = funcao;
		this.a0 = 0;
		this.b0 = 0;
		this.epsilon = 0;
		this.iteracaoMaxima = 1;
	}

	public MetodoBissecao(FuncaoRealX funcao, double a0, double b0,
			double epsilon, int iteracaoMaxima) throws IllegalArgumentException {
		this.funcao = funcao;
		this.epsilon = epsilon;
		this.iteracaoMaxima = iteracaoMaxima;
		this.setIntervalo(a0, b0);
	}

	public void setFuncao(FuncaoRealX funcao) {
		this.funcao = funcao;
	}

	public void setIntervalo(double a0, double b0)
			throws IllegalArgumentException {
		if (a0 < b0) {
			this.a0 = a0;
			this.b0 = b0;
		} else
			throw new IllegalArgumentException("A0 deve ser maior que B0");
	}

	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}

	public void setIteracaoMaxima(int iteracaoMaxima) {
		this.iteracaoMaxima = iteracaoMaxima;
	}

	public int getIteracoesUsadas() {
		return this.iteracoesUsadas;
	}

	private void verificarIntervalo() throws IllegalArgumentException {
		if (this.funcao.getValor(a0) * this.funcao.getValor(b0) < 0)
			throw new IllegalArgumentException(
					"N�o h� ra�z entre A0 e B0 fornecidos. Tente outro intervalo");
	}

	public double calcularRaiz() throws Exception, IllegalArgumentException {
		double x0 = 0, x1 = 0;

		this.verificarIntervalo();

		// itera at� o n� m�ximo "iteracaoMaxima"
		for (int i = 1; i <= this.iteracaoMaxima; i++) {
			this.iteracoesUsadas = i;
			x1 = (a0 + b0) / 2;

			// crit�rio de parada: sai da itera��o para retornar a ra�z ou
			// continua
			if (Math.abs(x0 - x1) <= this.epsilon)
				break;

			if (this.funcao.getValor(x1) > 0)
				this.a0 = x1;
			else
				this.b0 = x1;

			x0 = x1;
		}

		return x1;
	}
}
