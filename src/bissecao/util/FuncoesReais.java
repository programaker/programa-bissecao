package bissecao.util;

import static java.lang.Math.E;
import static java.lang.Math.log;
import static java.lang.Math.pow;

import java.util.ArrayList;
import java.util.List;

import bissecao.calculo.FuncaoRealX;

public class FuncoesReais {
	private List<FuncaoRealX> funcoes;

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
			return "f(x) = 3x² - e^x";
		}
	}

	private class Funcao4 implements FuncaoRealX {
		public double getValor(double x) {
			return 2 * pow(E, x) - 5 * pow(x, 2);
		}

		public String toString() {
			return "f(x) = 2e^x - 5x²";
		}
	}

	public FuncoesReais() {
		funcoes = new ArrayList<FuncaoRealX>();
		funcoes.add(new Funcao1());
		funcoes.add(new Funcao2());
		funcoes.add(new Funcao3());
		funcoes.add(new Funcao4());
	}

	public Object[] getFuncoes() {
		return funcoes.toArray();
	}
}
