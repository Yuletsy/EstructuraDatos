package co.edu.unac.polinomios;

public class Lista {
	public Nodo cabeza;
	public Nodo cola;

	public Lista()
	{
		cabeza=cola=null;
	}

	public void insertarAlFrente(Polinomio x)
	{
		if(estaVacia()) 
			cabeza=cola=new Nodo(x);
		else
			cabeza=new Nodo(x, cabeza);
	}


	public boolean estaVacia()
	{
		return cabeza==null;
	}

	public void insertarAlFinal(Polinomio est)
	{
		if(estaVacia()) 
			cabeza=cola=new Nodo(est);
		else
			cola=cola.sig =new Nodo(est);

	}

}
