package co.edu.unac.polinomios;

public class Polinomio {
	private Nodo cabeza;

	public Nodo getCabeza() {
		return cabeza;
	}

	private double coef;
	private int exp;

	public Polinomio(double coeficiente, int exponente) {
		this.coef = 0;
		this.exp = 0;

	}

	public Polinomio(int co, int ex) {
		setPolinomio(co, ex);

	}


	public void setPolinomio(int coeficiente, int exponente) {
		this.coef = coeficiente;
		this.exp = exponente;
	}

	public int getExponente() {
		return this.exp;
	}

	public void setExponente(int ex) {
		this.exp = ex;
	}

	public double getCoeficiente() {
		return this.coef;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		if (0d != coef) {
			if (coef > 0) {
				sb.append(" + ");
			}
			sb.append(coef);
			switch (exp) {
			case 0:
				break;
			case 1:
				sb.append(" x ");
				break;
			default:
				sb.append(" x^ ");
				sb.append(exp);

			}

		}

		return sb.toString();
	}

	public int compareTo(Polinomio o) {
		if (o.getExponente() == this.exp) {
			return 0;
		} else if (o.getExponente() > this.exp) {
			return 1;
		} else {
			return -1;
		}
	}
}
