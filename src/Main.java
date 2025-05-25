import java.util.*;

/**
 * El Cáliz de los Códigos Perdidos
 * Proyecto Java que implementa algoritmos de ordenamiento y búsqueda
 * para descifrar el mensaje secreto del oráculo.
 *
 * @author Ezequiel Campos
 * @version 1.0
 */
public class Main {
    private static final String[] MENSAJES_SECRETOS = {
            "El portal al reino sumergido se abrirá cuando el sol cruce la cima del monte hueco.",
            "Bajo la tercera luna de piedra, encontrarás la biblioteca olvidada del conocimiento prohibido.",
            "El mapa del tesoro está oculto en la última página del códice rojo, sellado por el sabio Alerion.",
            "La llave dorada del tiempo se encuentra donde los tres ríos convergen en uno solo.",
            "El último guardián duerme en la cámara de cristal, esperando al elegido que porte la marca ancestral."
    };

    private int[] numeros;
    private int claveMagica;
    private String mensajeSecreto;
    private Random random;

    public Main() {
        this.random = new Random();
        inicializarDatos();
    }

    /**
     * Inicializa el array de números aleatorios y selecciona la clave mágica
     * Complejidad: O(n) donde n = 1000
     */
    private void inicializarDatos() {
        // Generar array de 1000 números aleatorios entre 1000 y 9999
        numeros = new int[1000];
        Set<Integer> numerosUnicos = new HashSet<>();

        // Asegurar que todos los números sean únicos
        while (numerosUnicos.size() < 1000) {
            numerosUnicos.add(random.nextInt(9000) + 1000); // 1000-9999
        }

        int index = 0;
        for (int numero : numerosUnicos) {
            numeros[index++] = numero;
        }

        // Seleccionar clave mágica aleatoria
        claveMagica = numeros[random.nextInt(numeros.length)];
        mensajeSecreto = MENSAJES_SECRETOS[random.nextInt(MENSAJES_SECRETOS.length)];

        System.out.println("🧙 El Cáliz de los Códigos Perdidos ha sido inicializado...");
        System.out.println("Array de " + numeros.length + " números mágicos generado.");
        System.out.println("Una clave secreta ha sido elegida por el oráculo...\n");
    }

    /**
     * Algoritmo QuickSort para ordenar el array
     * Complejidad promedio: O(n log n)
     * Complejidad peor caso: O(n²)
     * Complejidad espacio: O(log n) por la recursión
     */
    public void quickSort(int[] arr, int bajo, int alto) {
        if (bajo < alto) {
            // Particionar y obtener el índice del pivote
            int indicePivote = particion(arr, bajo, alto);

            // Ordenar recursivamente los elementos antes y después del pivote
            quickSort(arr, bajo, indicePivote - 1);
            quickSort(arr, indicePivote + 1, alto);
        }
    }

    /**
     * Función auxiliar para particionar en QuickSort
     * Utiliza el último elemento como pivote
     */
    private int particion(int[] arr, int bajo, int alto) {
        int pivote = arr[alto]; // Último elemento como pivote
        int i = (bajo - 1); // Índice del elemento más pequeño

        for (int j = bajo; j < alto; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (arr[j] <= pivote) {
                i++;
                intercambiar(arr, i, j);
            }
        }

        intercambiar(arr, i + 1, alto);
        return i + 1;
    }

    /**
     * Función auxiliar para intercambiar elementos
     */
    private void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Algoritmo MergeSort para ordenar el array
     * Complejidad: O(n log n) en todos los casos
     * Complejidad espacio: O(n) para el array auxiliar
     */
    public void mergeSort(int[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            // Ordenar primera y segunda mitad
            mergeSort(arr, izquierda, medio);
            mergeSort(arr, medio + 1, derecha);

            // Fusionar las mitades ordenadas
            merge(arr, izquierda, medio, derecha);
        }
    }

    /**
     * Función auxiliar para fusionar dos subarrays ordenados
     */
    private void merge(int[] arr, int izquierda, int medio, int derecha) {
        // Tamaños de los subarrays a fusionar
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        // Arrays temporales
        int[] izq = new int[n1];
        int[] der = new int[n2];

        // Copiar datos a arrays temporales
        for (int i = 0; i < n1; ++i)
            izq[i] = arr[izquierda + i];
        for (int j = 0; j < n2; ++j)
            der[j] = arr[medio + 1 + j];

        // Fusionar los arrays temporales
        int i = 0, j = 0;
        int k = izquierda;

        while (i < n1 && j < n2) {
            if (izq[i] <= der[j]) {
                arr[k] = izq[i];
                i++;
            } else {
                arr[k] = der[j];
                j++;
            }
            k++;
        }

        // Copiar elementos restantes
        while (i < n1) {
            arr[k] = izq[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = der[j];
            j++;
            k++;
        }
    }

    /**
     * Búsqueda binaria para encontrar un elemento en el array ordenado
     * Complejidad: O(log n)
     * Complejidad espacio: O(1)
     *
     * @param arr Array ordenado donde buscar
     * @param objetivo Número a buscar
     * @return Índice del elemento si se encuentra, -1 si no existe
     */
    public int busquedaBinaria(int[] arr, int objetivo) {
        int izquierda = 0;
        int derecha = arr.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            // Si encontramos el elemento
            if (arr[medio] == objetivo) {
                return medio;
            }

            // Si el objetivo es mayor, ignorar la mitad izquierda
            if (arr[medio] < objetivo) {
                izquierda = medio + 1;
            }
            // Si el objetivo es menor, ignorar la mitad derecha
            else {
                derecha = medio - 1;
            }
        }

        return -1; // Elemento no encontrado
    }

    /**
     * Mide el tiempo de ejecución de los algoritmos de ordenamiento
     */
    public void compararAlgoritmos() {
        System.out.println("📊 ANÁLISIS DE RENDIMIENTO DE ALGORITMOS\n");

        // Crear copias del array para cada algoritmo
        int[] arrayQuick = Arrays.copyOf(numeros, numeros.length);
        int[] arrayMerge = Arrays.copyOf(numeros, numeros.length);

        // Medir QuickSort
        long inicioQuick = System.nanoTime();
        quickSort(arrayQuick, 0, arrayQuick.length - 1);
        long finQuick = System.nanoTime();
        long tiempoQuick = finQuick - inicioQuick;

        // Medir MergeSort
        long inicioMerge = System.nanoTime();
        mergeSort(arrayMerge, 0, arrayMerge.length - 1);
        long finMerge = System.nanoTime();
        long tiempoMerge = finMerge - inicioMerge;

        // Mostrar resultados
        System.out.println("⚡ QuickSort:");
        System.out.println("   Tiempo: " + (tiempoQuick / 1_000_000.0) + " ms");
        System.out.println("   Complejidad promedio: O(n log n)");
        System.out.println("   Complejidad peor caso: O(n²)");

        System.out.println("\n⚡ MergeSort:");
        System.out.println("   Tiempo: " + (tiempoMerge / 1_000_000.0) + " ms");
        System.out.println("   Complejidad: O(n log n) garantizada");

        // Usar el array ordenado por MergeSort para el resto del programa
        numeros = arrayMerge;

        System.out.println("\n🎯 Array ordenado exitosamente usando " +
                (tiempoMerge < tiempoQuick ? "MergeSort" : "QuickSort") +
                " (más rápido en esta ejecución)\n");
    }

    /**
     * Ejecuta el juego principal donde el usuario busca la clave mágica
     */
    public void ejecutarJuego() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🔮 EL DESAFÍO DEL ORÁCULO");
        System.out.println("El oráculo ha ocultado un mensaje entre los números mágicos.");
        System.out.println("Debes encontrar la clave correcta para revelarlo.\n");

        // Mostrar algunos números como pista
        System.out.println("💡 Pistas - Algunos números del cáliz:");
        for (int i = 0; i < Math.min(20, numeros.length); i += numeros.length / 20) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println("...\n");

        int intentos = 0;
        int maxIntentos = 5;

        while (intentos < maxIntentos) {
            System.out.print("🔍 Ingresa el número mágico (intento " + (intentos + 1) + "/" + maxIntentos + "): ");

            try {
                int numeroUsuario = scanner.nextInt();
                intentos++;

                // Medir tiempo de búsqueda binaria
                long inicioBusqueda = System.nanoTime();
                int indice = busquedaBinaria(numeros, numeroUsuario);
                long finBusqueda = System.nanoTime();

                System.out.println("⏱️  Búsqueda completada en " +
                        ((finBusqueda - inicioBusqueda) / 1000.0) + " microsegundos");

                if (numeroUsuario == claveMagica) {
                    System.out.println("\n🎉 ¡FELICITACIONES! Has encontrado la clave mágica: " + claveMagica);
                    System.out.println("✨ El oráculo revela su mensaje:");
                    System.out.println("📜 \"" + mensajeSecreto + "\"");
                    System.out.println("\n🏆 ¡Has completado exitosamente el desafío!");
                    break;
                } else if (indice != -1) {
                    System.out.println("❌ Número encontrado en el cáliz, pero no es la clave mágica.");
                } else {
                    System.out.println("❌ Ese número no existe en el cáliz de códigos.");
                }

                if (intentos < maxIntentos) {
                    // Dar pista de rango
                    if (numeroUsuario < claveMagica) {
                        System.out.println("💭 Pista: La clave mágica es mayor que " + numeroUsuario);
                    } else {
                        System.out.println("💭 Pista: La clave mágica es menor que " + numeroUsuario);
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("⚠️  Por favor, ingresa un número válido.");
                scanner.nextLine(); // Limpiar buffer
            }
        }

        if (intentos >= maxIntentos) {
            System.out.println("\n💀 Se agotaron los intentos. El misterio permanece sin resolver...");
            System.out.println("🔐 La clave mágica era: " + claveMagica);
            System.out.println("📜 El mensaje perdido: \"" + mensajeSecreto + "\"");
        }

        scanner.close();
    }

    /**
     * Muestra estadísticas del array y algoritmos
     */
    public void mostrarEstadisticas() {
        System.out.println("\n📈 ESTADÍSTICAS DEL CÁLIZ");
        System.out.println("Tamaño del array: " + numeros.length);
        System.out.println("Número menor: " + numeros[0]);
        System.out.println("Número mayor: " + numeros[numeros.length - 1]);
        System.out.println("Clave mágica: " + claveMagica);
        System.out.println("Posición de la clave en array ordenado: " +
                (busquedaBinaria(numeros, claveMagica) + 1));
    }

    public static void main(String[] args) {
        System.out.println("🏛️  Bienvenido al Cáliz de los Códigos Perdidos");
        System.out.println("=" .repeat(50) + "\n");

        Main juego = new Main();

        // Comparar algoritmos de ordenamiento
        juego.compararAlgoritmos();

        // Mostrar estadísticas
        juego.mostrarEstadisticas();

        // Ejecutar el juego principal
        juego.ejecutarJuego();

        System.out.println("\n🌟 Gracias por jugar 'El Cáliz de los Códigos Perdidos'");
    }

    // Getters para testing
    public int[] getNumeros() { return numeros; }
    public int getClaveMagica() { return claveMagica; }
    public String getMensajeSecreto() { return mensajeSecreto; }
}