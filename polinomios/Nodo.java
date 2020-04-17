package co.edu.unac.polinomios;


public class Nodo {
    
    private double coeficiente;
    private int exponente;
    private Nodo sig;

    public Nodo(double coeficiente) {
        this(coeficiente, 0);
    }

    public Nodo(double coeficiente, int exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
        this.sig = null;
    }
    public double getCoeficiente() {
        return coeficiente;
    }
    public void setCoeficiente(double coeficiente) {
        this.coeficiente = coeficiente;
    }
    public int getExponente() {
        return exponente;
    }
    public void setExponente(int exponente) {
        this.exponente = exponente;
    }
    public Nodo getSiguiente() {
        return sig;
    }
    public void setSiguiente(Nodo siguiente) {
        this.sig = siguiente;
    }
    public String toString() {

        StringBuilder sb = new StringBuilder();
        if (0d != coeficiente) {
            if (coeficiente > 0) {
                sb.append( " + " );
            }
            sb.append(coeficiente);
            switch (exponente) {
                case 0:
                    break;
                case 1:
                    sb.append(" x ");
                    break;
                default:
                    sb.append(" x^");
                    sb.append(exponente);
            }
        }
        return sb.toString();
    }
    public int compareTo(Nodo o) {
        if (o.getExponente() == this.exponente) {
            return 0;
        } else if (o.getExponente() > this.exponente) {
            return 1;
        } else {
            return -1;
        }
    }
}
