package co.edu.unac.polinomios;


public class Nodo {
    
	Polinomio polnm;
	Nodo sig;
	public Nodo (Polinomio x)
	{
		this.polnm=x;
		sig = null;
	}

	public Nodo( Polinomio x, Nodo nuevoelemento){

		this.polnm=x;
		sig=nuevoelemento;

	}

	Polinomio getPolinomio()
	{
		return this.polnm;
	}

	Nodo getsiguientet()
	{
		return sig;
	}

    
}
