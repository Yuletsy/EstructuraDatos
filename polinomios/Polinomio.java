package co.edu.unac.polinomios;

import java.util.ArrayList;
import java.util.List;

public class Polinomio {
	private Nodo cabeza;

	public Polinomio() {
		cabeza = null;
	}

	public Nodo getCabeza() {
		return cabeza;
	}

	public Polinomio sumar(Polinomio polinomio1, Polinomio polinomio2) {
		Polinomio suma = new Polinomio();

		Nodo iterador = polinomio1.getCabeza();
		while (null != iterador) {
			Nodo termino = polinomio2.obtenerTerminoPorExponente(iterador);
			if (null != termino) {
				Nodo sumando = new Nodo(iterador.getCoeficiente() + termino.getCoeficiente(), termino.getExponente());
				suma.agregarTermino(sumando);
			} else {
				suma.agregarTermino(new Nodo(iterador.getCoeficiente(), iterador.getExponente()));
			}
			iterador = iterador.getSiguiente();
		}
		iterador = polinomio2.getCabeza();
		while (null != iterador) {
			if (!polinomio1.existeTerminoConExponente(iterador)) {

				suma.agregarTermino(new Nodo(iterador.getCoeficiente(), iterador.getExponente()));

			}
			iterador = iterador.getSiguiente();
		}
		return suma;

	}

	public boolean existeTerminoConExponente(Nodo termino) {
		Nodo iterador = cabeza;
		while (null != iterador) {
			if (iterador.getExponente() == termino.getExponente()) {
				return true;
			}
			iterador = iterador.getSiguiente();

		}
		return false;

	}

	public Nodo obtenerTerminoPorExponente(Nodo termino) {
		Nodo iterador = this.cabeza;
		while (null != iterador) {
			if (iterador.getExponente() == termino.getExponente()) {
				return iterador;
			}
			iterador = iterador.getSiguiente();
		}
		return null;

	}

	private Nodo obtenerUltimoTermino() {
		Nodo iterador = cabeza;
		while (null != iterador && null != iterador.getSiguiente()) {
			iterador = iterador.getSiguiente();

		}
		return iterador;
	}

	public void agregarTermino(Nodo termino) {
		Nodo ultimoTermino = obtenerUltimoTermino();
		if (null == ultimoTermino) {
			cabeza = termino;
		} else {
			ultimoTermino.setSiguiente(termino);
		}

	}

	public void visualizar() {
		Nodo iterador = cabeza;
		List<Nodo> terminos = new ArrayList<Nodo>();
		while (null != iterador) {
			terminos.add(iterador);
			iterador = iterador.getSiguiente();
		}
		for (Nodo termino : terminos) {
			System.out.print(termino.toString() + " " );
		}

	}
}
