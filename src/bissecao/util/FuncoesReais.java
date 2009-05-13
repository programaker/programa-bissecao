package bissecao.util;

import bissecao.calculo.FuncaoRealX;
import java.util.ArrayList;
import static java.lang.Math.*;

public class FuncoesReais {
	private ArrayList<FuncaoRealX> funcoes;

	private class Funcao1 implements FuncaoRealX {
		public double getValor(double x) {
			return 1 - x * log(x);
		}

		public String toString() {
			return "f(x) = 1 - xln(x)";
		}
	}

	private class Funcao2 implements FuncaoRealX {
		public double getValor(double x) {
			return log(x) - 2 * x + 3;
		}

		public String toString() {
			return "f(x) = ln(x) - 2x + 3";
		}
	}

	private class Funcao3 implements FuncaoRealX {
		public double getValor(double x) {
			return 3 * pow(x, 2) - pow(E, x);
		}

		public String toString() {
			return "f(x) = 3x� - e^x";
		}
	}

	private class Funcao4 implements FuncaoRealX {
		public double getValor(double x) {
			return 2 * pow(E, x) - 5 * pow(x, 2);
		}

		public String toString() {
			return "f(x) = 2e^x - 5x�";
		}
	}

	public FuncoesReais() {
		this.funcoes = new ArrayList<FuncaoRealX>();
		funcoes.add(new Funcao1());
		funcoes.add(new Funcao2());
		funcoes.add(new Funcao3());
		funcoes.add(new Funcao4());
	}

	public Object[] getFuncoes() {
		return funcoes.toArray();
	}
}
