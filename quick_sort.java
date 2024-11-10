import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class quick_sort {

    public static void quickSort(int[] datos, int inicio, int fin, String tipoPivote) {
        if (inicio < fin) {
            int indiceParticion = particion(datos, inicio, fin, tipoPivote);
            imprimirArreglo(datos); // este es el que me va a ir imprimiendo el arreglo en cada partición
            quickSort(datos, inicio, indiceParticion - 1, tipoPivote); // este es el que va a ir ordenando a la izquierda
            quickSort(datos, indiceParticion + 1, fin, tipoPivote); // y este a la derecha
        }
    }

    public static int particion(int[] datos, int inicio, int fin, String tipoPivote) {
        int pivote = seleccionarPivote(datos, inicio, fin, tipoPivote);
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (datos[j] <= pivote) {
                i++;
                // este es el que va a ir intercambiando los numeros o datos
                int auxiliar = datos[i];
                datos[i] = datos[j];
                datos[j] = auxiliar;
            }
        }

        int auxiliar = datos[i + 1];
        datos[i + 1] = datos[fin];
        datos[fin] = auxiliar;

        return i + 1;
    }

    public static int seleccionarPivote(int[] datos, int inicio, int fin, String tipoPivote) {
        int pivote;
        if (tipoPivote.equals("inicio")) {
            pivote = datos[inicio];
            intercambiar(datos, inicio, fin);
        } else if (tipoPivote.equals("medio")) {
            int medio = inicio + (fin - inicio) / 2;
            pivote = datos[medio];
            intercambiar(datos, medio, fin);
        } else {
            pivote = datos[fin];
        }

        return pivote;
    }

    public static void intercambiar(int[] datos, int i, int j) {
        int auxiliar = datos[i];
        datos[i] = datos[j];
        datos[j] = auxiliar;
    }

    public static void imprimirArreglo(int[] datos) {
        System.out.println("-------------------------------------");
        System.out.println("Reordenamiento: ");
        for (int i = 0; i < datos.length; i++)
            System.out.println("i: " + i + " datos[i]: " + datos[i]);
    }

    public static int[] leerArreglo(int[] datos) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        for (int i = 0; i < datos.length; i++) {
            System.out.println("Escriba el valor [" + i + "]: ");
            entrada = bufer.readLine();
            datos[i] = Integer.parseInt(entrada);
        }
        return datos;
    }

    public static void main(String[] args) throws IOException {
        int n;
        int[] datos;
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String entrada;

        System.out.println("---------------Quick Sort------------");
        System.out.println("Escribe el tamaño del arreglo: ");
        entrada = bufer.readLine();
        n = Integer.parseInt(entrada);

        datos = new int[n];
        datos = leerArreglo(datos);

        System.out.println("Escriba la posición del número pivote (inicio, medio, final): ");
        String tipoPivote = bufer.readLine();

        quickSort(datos, 0, datos.length - 1, tipoPivote);
        imprimirArreglo(datos);
    }
}
