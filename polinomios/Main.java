package co.edu.unac.polinomios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));

		int salir = 1;
		do {
			System.out.println("\n1. SUMA DE POLINOMIOS");
			System.out.println("2. DERIVADA DEL POLINOMIO");
			System.out.println("3. PRODUCTO DE DOS POLINOMIOS");
			System.out.println("4. Salir");
			System.out.print("Ingrese opcion: ");
			int opcion = Integer.parseInt(dato.readLine());
			switch (opcion) {
			case 1:
				Lista poli1 = new Lista();
				Lista poli2 = new Lista();
				System.out.print("Incialmente ingrese cuantos terminos posee el 1 primer Polinomio: ");
				int cantidad = Integer.parseInt(dato.readLine());
				for (int i = 1; i <= cantidad; i++) {
					System.out.print("Termino: " + i + "\n");
					System.out.print("Ingrese coeficiente: ");
					int coeficiente = Integer.parseInt(dato.readLine());
					System.out.print("Ingrese exponente: ");
					int exponente = Integer.parseInt(dato.readLine());
					if (exponente == 0)
						exponente = -1;
					Polinomio poli = new Polinomio(coeficiente, exponente);
					poli1.insertarAlFrente(poli);
				}
				System.out.print("Incialmente ingrese cuantos terminos posee el 2 segundo Polinomio: ");
				int cantidad2 = Integer.parseInt(dato.readLine());
				for (int i = 1; i <= cantidad2; i++) {
					System.out.print("Termino: " + i + "\n");
					System.out.print("Ingrese coeficiente: ");
					int coeficiente = Integer.parseInt(dato.readLine());
					System.out.print("Ingrese exponente: ");
					int exponente = Integer.parseInt(dato.readLine());
					if (exponente == 0)
						exponente = -1;
					Polinomio poli = new Polinomio(coeficiente, exponente);
					poli2.insertarAlFrente(poli);
				}
				System.out.println();
				System.out.print("resultado de la SUMA:  ");
				sumaPolinomios(poli1.cabeza, poli2.cabeza, cantidad, cantidad2);
				System.out.println();
				break;
			case 2:
				Lista derivada = new Lista();
				System.out.print("Incialmente ingrese cuantos terminos posee el 1 primer Polinomio: ");
				cantidad = Integer.parseInt(dato.readLine());
				for (int i = 1; i <= cantidad; i++) {
					System.out.print("Termino: " + i + "\n");
					System.out.print("Ingrese coeficiente: ");
					int coeficiente = Integer.parseInt(dato.readLine());
					System.out.print("Ingrese exponente: ");
					int exponente = Integer.parseInt(dato.readLine());
					Polinomio poli = new Polinomio(coeficiente, exponente);
					derivada.insertarAlFrente(poli);
				}
				System.out.println();
				System.out.print("resultado de la DERIVACION:  ");
				derivadaPolinomios(derivada.cabeza);
				System.out.println();
				break;
			case 3:
				poli1 = new Lista();
				poli2 = new Lista();
				System.out.print("Incialmente ingrese cuantos terminos posee el 1 primer Polinomio: ");
				cantidad = Integer.parseInt(dato.readLine());
				for (int i = 1; i <= cantidad; i++) {
					System.out.print("Termino: " + i + "\n");
					System.out.print("Ingrese coeficiente: ");
					int coeficiente = Integer.parseInt(dato.readLine());
					System.out.print("Ingrese exponente: ");
					int exponente = Integer.parseInt(dato.readLine());
					Polinomio poli = new Polinomio(coeficiente, exponente);
					poli1.insertarAlFrente(poli);
				}
				System.out.print("Incialmente ingrese cuantos terminos posee el 2 segundo Polinomio: ");
				cantidad2 = Integer.parseInt(dato.readLine());
				for (int i = 1; i <= cantidad2; i++) {
					System.out.print("Termino: " + i + "\n");
					System.out.print("Ingrese coeficiente: ");
					int coeficiente = Integer.parseInt(dato.readLine());
					System.out.print("Ingrese exponente: ");
					int exponente = Integer.parseInt(dato.readLine());
					Polinomio poli = new Polinomio(coeficiente, exponente);
					poli2.insertarAlFrente(poli);
				}
				System.out.println();
				System.out.print("resultado del PRODUCTO:  ");
				producto(poli1.cabeza, poli2.cabeza, cantidad, cantidad2);
				System.out.println();
				break;
			case 4:
				salir = 0;
				break;
			}
		} while (salir != 0);

	}

	public static void sumaPolinomios(Nodo poli1, Nodo poli2, int cantidad, int cantidad2) {
		int[] numerosl1 = new int[cantidad];
		int[] numerosl2 = new int[cantidad2];
		// PRIMER POLINOMIO
		int acomp = 0;
		Nodo p = poli1;
		while (p != null) {
			numerosl1[acomp] = p.polnm.getExponente();
			acomp++;
			
			p = p.sig;
			
		}
		// SEGUNDO POLINOMIO
		int acomp2 = 0;
		Nodo q = poli2;
		while (q != null) {
			numerosl2[acomp2] = q.polnm.getExponente();
			acomp2++;
			
			q = q.sig;
			
		}
		
		int[] polinomiosave = new int[100];
		int aux = 0;
		int vueltas = cantidad + cantidad2;
		int cambios1 = 0, cambios2 = 0;
		
		for (int j = 0; j < cantidad; j++) {
			polinomiosave[j] = numerosl1[j];
			
		}
		for (int j = 0; j < cantidad2; j++) {
			polinomiosave[cantidad++] = numerosl2[j];
		}
		
		// HEMOS ELIMINADO LOS REPETIDOS
		int ver2 = 0;
		for (int i = 0; i < vueltas; i++) {
			for (int j = 0; j < vueltas; j++) {
				if (polinomiosave[i] == polinomiosave[j])
					ver2++;
				
				if (ver2 == 2) {
					polinomiosave[j] = 0;
					ver2--;
				}
				
			}
			ver2 = 0;
			
		}
		
		int ccero = 0;
		for (int i = 0; i < vueltas; i++) {
			if (polinomiosave[i] == 0) {
				ccero++;
			}
		}
		int actual = vueltas - ccero;
		int[] vpolinomio = new int[actual];
		int cvpoli = 0;
		for (int i = 0; i < vueltas; i++) {
			if (polinomiosave[i] != 0) {
				vpolinomio[cvpoli] = polinomiosave[i];
				cvpoli++;
			}
		}
		
		Orden(vpolinomio, cvpoli);
		
		int d = 0;
		acomp = vpolinomio.length;
		while (acomp != 0) {
			int acum = 0;
			Nodo a = poli1;
			Nodo b = poli2;
			
			int ver = 0;
			boolean pass = false;
			boolean pass2 = false;
			
			while (ver < 2) {
				if (!pass) {
					if (a != null) {
						if (vpolinomio[d] == a.polnm.getExponente()) {
							acum += a.polnm.getCoeficiente();
						}
						a = a.sig;
					} else {
						ver++;
						pass = true;
					}
				}
				
				if (!pass2) {
					if (b != null) {
						if (vpolinomio[d] == b.polnm.getExponente()) {
							acum += b.polnm.getCoeficiente();
						}
						b = b.sig;
					} else {
						ver++;
						pass2 = true;
					}
					
				}
				
			}
			
			if (acomp != 0) {
				if (d == 0) {
					if (vpolinomio[d] != -1 && acum > 0) {
						System.out.print(acum + " x^ " + vpolinomio[d] + "    ");
					} else if (acum < 0 && vpolinomio[d] != -1) {
						System.out.print(acum + " x^ " + vpolinomio[d] + "    ");
					}
					if (vpolinomio[d] == -1)
						System.out.print(acum + "    ");
				} else if (d > 0) {
					if (vpolinomio[d] != -1 && acum > 0)
						System.out.print(" + " + acum + " x^ " + vpolinomio[d] + "    ");
					else if (acum < 0 && vpolinomio[d] != -1)
						System.out.print(acum + " x^ " + vpolinomio[d] + "    ");
					if (vpolinomio[d] == -1 && acum > 0)
						System.out.print(" + " + acum + "    ");
					else if (vpolinomio[d] == -1 && acum < 0)
						System.out.print(acum + "    ");
				}
			}
			
			d++;
			acomp--;
		}
		
	}

	public static void derivadaPolinomios(Nodo derivada) {
		Nodo p = derivada;
		double acum = 0;
		int r = 0;
		int cont = 0;
		while (p != null) {
			acum = p.polnm.getCoeficiente() * p.polnm.getExponente();
			r = p.polnm.getExponente();
			r--;
			if (cont == 0) {
				if (r > 0 && acum > 0)
					System.out.print(acum + " X ^  " + r + "   ");

				if (r > 0 && acum < 0)
					System.out.print(acum + " X ^  " + r + "   ");

				if (r == 0)
					System.out.print(acum + "  ");

				if (r < 0)
					System.out.print(" 0 ");
			}

			if (cont > 0) {
				if (r > 0 && acum > 0)
					System.out.print(" + " + acum + " X ^  " + r + "   ");

				if (r > 0 && acum < 0)
					System.out.print(acum + " X ^  " + r + "   ");

				if (r == 0 && acum > 0)
					System.out.print(" + " + acum + "  ");
				if (r == 0 && acum < 0)
					System.out.print(acum + "  ");

				if (r < 0)
					System.out.print(" +0 ");

			}

			cont++;
			acum = 0;
			r = 0;
			p = p.sig;
		}

	}
	public static void producto(Nodo poli1, Nodo poli2, int cantidad, int cantidad2) {
		
		Lista guardap1 = new Lista();
		Nodo a;
		Nodo b;
		
		if (cantidad > cantidad2) {
			
			a = poli1;
			b = poli2;
		} else {
			
			a = poli2;
			b = poli1;
		}
		
		int cont = 0;
		
		while (a != null) {
			
			while (b != null) {
				double coeficiente = a.polnm.getCoeficiente() * b.polnm.getCoeficiente();
				int exponente = a.polnm.getExponente() + b.polnm.getExponente();
				Polinomio poli = new Polinomio(coeficiente, exponente);
				guardap1.insertarAlFrente(poli);
				b = b.sig;
				cont++;
			}
			
			if (cantidad > cantidad2) {
				b = poli2;
			} else {
				b = poli1;
			}
			a = a.sig;
		}
		Lista vacio = new Lista();
		
		Nodo ver = guardap1.cabeza;
		
		while (ver != null) {
			
			if (ver.polnm.getExponente() == 0) {
				ver.polnm.setExponente(-1);
			}
			
			ver = ver.sig;
		}
		
		sumaPolinomios(guardap1.cabeza, vacio.cabeza, cont, 0);
		
	}
	

	static void Orden(int a[], int n) {
		boolean interruptor = true;
		for (int pasada = 0; pasada < n - 1 && interruptor; pasada++) {
			interruptor = false;
			for (int j = 0; j < n - pasada - 1; j++)
				if (a[j] < a[j + 1]) {
					int aux;
					interruptor = true;
					aux = a[j];
					a[j] = a[j + 1];
					a[j + 1] = aux;
				}

		}
	}

}
