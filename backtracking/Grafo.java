package co.edu.unac.backtracking;

public class Grafo {

    static int x, y;
    static int[][] M = {{0,1,0,1,0}, {1,0,1,1,1}, {0,1,0,0,1}, {1,1,0,0,1}, {0,1,1,1,0}};
    static int n = M.length;
    static boolean[] visitado= new boolean[n];
    static int[] desde= new int[n];
    static int minimo=200;
    static int[]optimo= new int[n];

    public void camino(int a, int z, int distancia) {

        visitado[a] = true;
        if (a != z) {
            for (int i = 0; i < n; i++) {
                if (M[a][i] > 0 && !visitado[i]) {
                    desde[i] = a;
                    camino(i, z, distancia+M[a][i]);
                    desde[i]=0;
                }

            }

        }else {
            if(distancia<minimo) {
                minimo=distancia;
                System.arraycopy(desde, 0, optimo, 0, n);
            }
        }

    }

    public void visualizar(int a, int z) {

        if(a!=z) {
            visualizar(a,optimo[z]);
        }
        System.out.println(z);

    }

    public static void main(String[]args) {

        x=0;
        y=4;
        Grafo grafo = new Grafo();

        grafo.camino(x,y,0);
        System.out.println("distancia: " + minimo);
        grafo.visualizar(x,y);
    }
}