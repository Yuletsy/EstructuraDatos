package co.edu.unac.polinomios;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Polinomio polinomio = new Polinomio();
        Nodo termino = new Nodo(3,2);
        polinomio.agregarTermino(termino);
        termino = new Nodo(-4,1);
        polinomio.agregarTermino(termino);
        polinomio.visualizar();
        System.out.println();
        Polinomio polinomio2 = new Polinomio();
        termino = new Nodo(23.5,3);
        polinomio2.agregarTermino(termino);
        termino = new Nodo(-1,2);
        polinomio2.agregarTermino(termino);      
        termino = new Nodo(-1,0);
        polinomio2.agregarTermino(termino);
        polinomio2.visualizar();
        System.out.println();
        Polinomio operaciones = new Polinomio();
        Polinomio suma = operaciones.sumar(polinomio, polinomio2);
        suma.visualizar();
        System.out.println();
    
	}

}
