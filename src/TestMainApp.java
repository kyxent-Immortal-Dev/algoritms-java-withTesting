import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class TestMainApp {

    private Main juego;
    private int[] arrayPrueba;
    private int[] arrayOrdenadoEsperado;

    @BeforeEach
    void setUp() {
        juego = new Main();
        // Array de prueba pequeño para validaciones
        arrayPrueba = new int[]{64, 34, 25, 12, 22, 11, 90, 5, 77, 30};
        arrayOrdenadoEsperado = new int[]{5, 11, 12, 22, 25, 30, 34, 64, 77, 90};
    }

    @Test
    @DisplayName("Inicialización correcta del juego")
    void testInicializacion() {
        assertNotNull(juego.getNumeros(), "El array de números no debe ser null");
        assertEquals(1000, juego.getNumeros().length, "El array debe tener 1000 elementos");
        assertTrue(juego.getClaveMagica() >= 1000 && juego.getClaveMagica() <= 9999,
                "La clave mágica debe estar entre 1000 y 9999");
        assertNotNull(juego.getMensajeSecreto(), "El mensaje secreto no debe ser null");
        assertFalse(juego.getMensajeSecreto().isEmpty(), "El mensaje secreto no debe estar vacío");
    }

    @Test
    @DisplayName("Validar rango de números generados")
    void testRangoNumeros() {
        int[] numeros = juego.getNumeros();
        for (int numero : numeros) {
            assertTrue(numero >= 1000 && numero <= 9999,
                    "Todos los números deben estar entre 1000 y 9999, encontrado: " + numero);
        }
    }

    @Test
    @DisplayName("Verificar números únicos en el array")
    void testNumerosUnicos() {
        int[] numeros = juego.getNumeros();
        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                assertNotEquals(numeros[i], numeros[j],
                        "No debe haber números duplicados en posiciones " + i + " y " + j);
            }
        }
    }

    @Test
    @DisplayName("QuickSort ordena correctamente")
    void testQuickSort() {
        int[] arrayTest = Arrays.copyOf(arrayPrueba, arrayPrueba.length);
        juego.quickSort(arrayTest, 0, arrayTest.length - 1);

        assertArrayEquals(arrayOrdenadoEsperado, arrayTest,
                "QuickSort debe ordenar el array correctamente");
        assertTrue(estaOrdenado(arrayTest), "El array debe estar ordenado ascendentemente");
    }

    @Test
    @DisplayName("MergeSort ordena correctamente")
    void testMergeSort() {
        int[] arrayTest = Arrays.copyOf(arrayPrueba, arrayPrueba.length);
        juego.mergeSort(arrayTest, 0, arrayTest.length - 1);

        assertArrayEquals(arrayOrdenadoEsperado, arrayTest,
                "MergeSort debe ordenar el array correctamente");
        assertTrue(estaOrdenado(arrayTest), "El array debe estar ordenado ascendentemente");
    }

    @Test
    @DisplayName("QuickSort con array vacío")
    void testQuickSortArrayVacio() {
        int[] arrayVacio = new int[0];
        assertDoesNotThrow(() -> juego.quickSort(arrayVacio, 0, -1),
                "QuickSort debe manejar arrays vacíos sin errores");
    }

    @Test
    @DisplayName("MergeSort con array vacío")
    void testMergeSortArrayVacio() {
        int[] arrayVacio = new int[0];
        assertDoesNotThrow(() -> juego.mergeSort(arrayVacio, 0, -1),
                "MergeSort debe manejar arrays vacíos sin errores");
    }

    @Test
    @DisplayName("QuickSort con un solo elemento")
    void testQuickSortUnElemento() {
        int[] arrayUno = {42};
        juego.quickSort(arrayUno, 0, 0);
        assertEquals(42, arrayUno[0], "Array de un elemento debe permanecer igual");
    }

    @Test
    @DisplayName("MergeSort con un solo elemento")
    void testMergeSortUnElemento() {
        int[] arrayUno = {42};
        juego.mergeSort(arrayUno, 0, 0);
        assertEquals(42, arrayUno[0], "Array de un elemento debe permanecer igual");
    }

    @Test
    @DisplayName("Búsqueda binaria encuentra elemento existente")
    void testBusquedaBinariaElementoExiste() {
        int[] arrayOrdenado = Arrays.copyOf(arrayOrdenadoEsperado, arrayOrdenadoEsperado.length);

        // Buscar cada elemento del array
        for (int i = 0; i < arrayOrdenado.length; i++) {
            int indice = juego.busquedaBinaria(arrayOrdenado, arrayOrdenado[i]);
            assertTrue(indice >= 0, "Debe encontrar el elemento " + arrayOrdenado[i]);
            assertEquals(arrayOrdenado[i], arrayOrdenado[indice],
                    "El elemento encontrado debe coincidir con el buscado");
        }
    }

    @Test
    @DisplayName("Búsqueda binaria no encuentra elemento inexistente")
    void testBusquedaBinariaElementoNoExiste() {
        int[] arrayOrdenado = Arrays.copyOf(arrayOrdenadoEsperado, arrayOrdenadoEsperado.length);

        // Buscar elementos que no existen
        int[] elementosInexistentes = {1, 3, 13, 99, 150};
        for (int elemento : elementosInexistentes) {
            int indice = juego.busquedaBinaria(arrayOrdenado, elemento);
            assertEquals(-1, indice, "No debe encontrar el elemento inexistente " + elemento);
        }
    }

    @Test
    @DisplayName("Búsqueda binaria en array vacío")
    void testBusquedaBinariaArrayVacio() {
        int[] arrayVacio = new int[0];
        int resultado = juego.busquedaBinaria(arrayVacio, 42);
        assertEquals(-1, resultado, "Búsqueda en array vacío debe retornar -1");
    }

    @Test
    @DisplayName("Búsqueda binaria encuentra primer elemento")
    void testBusquedaBinariaPrimerElemento() {
        int[] arrayOrdenado = Arrays.copyOf(arrayOrdenadoEsperado, arrayOrdenadoEsperado.length);
        int indice = juego.busquedaBinaria(arrayOrdenado, arrayOrdenado[0]);
        assertEquals(0, indice, "Debe encontrar el primer elemento en índice 0");
    }

    @Test
    @DisplayName("Búsqueda binaria encuentra último elemento")
    void testBusquedaBinariaUltimoElemento() {
        int[] arrayOrdenado = Arrays.copyOf(arrayOrdenadoEsperado, arrayOrdenadoEsperado.length);
        int ultimoElemento = arrayOrdenado[arrayOrdenado.length - 1];
        int indice = juego.busquedaBinaria(arrayOrdenado, ultimoElemento);
        assertEquals(arrayOrdenado.length - 1, indice,
                "Debe encontrar el último elemento en el último índice");
    }

    @Test
    @DisplayName("La clave mágica existe en el array original")
    void testClaveMagicaExisteEnArray() {
        int[] numeros = juego.getNumeros();
        int claveMagica = juego.getClaveMagica();

        boolean encontrada = false;
        for (int numero : numeros) {
            if (numero == claveMagica) {
                encontrada = true;
                break;
            }
        }
        assertTrue(encontrada, "La clave mágica debe existir en el array de números");
    }

    @Test
    @DisplayName("Búsqueda binaria encuentra la clave mágica en array ordenado")
    void testBusquedaClaveMagicaEnArrayOrdenado() {
        // Ordenar el array del juego
        int[] numerosOrdenados = Arrays.copyOf(juego.getNumeros(), juego.getNumeros().length);
        juego.quickSort(numerosOrdenados, 0, numerosOrdenados.length - 1);

        int claveMagica = juego.getClaveMagica();
        int indice = juego.busquedaBinaria(numerosOrdenados, claveMagica);

        assertTrue(indice >= 0, "La búsqueda binaria debe encontrar la clave mágica");
        assertEquals(claveMagica, numerosOrdenados[indice],
                "El elemento encontrado debe ser la clave mágica");
    }

    @Test
    @DisplayName("Rendimiento: QuickSort vs MergeSort")
    void testRendimientoAlgoritmos() {
        // Crear arrays grandes para medir rendimiento
        int[] arrayGrande = new int[10000];
        for (int i = 0; i < arrayGrande.length; i++) {
            arrayGrande[i] = (int) (Math.random() * 100000);
        }

        int[] arrayQuick = Arrays.copyOf(arrayGrande, arrayGrande.length);
        int[] arrayMerge = Arrays.copyOf(arrayGrande, arrayGrande.length);

        // Medir QuickSort
        long inicioQuick = System.nanoTime();
        juego.quickSort(arrayQuick, 0, arrayQuick.length - 1);
        long tiempoQuick = System.nanoTime() - inicioQuick;

        // Medir MergeSort
        long inicioMerge = System.nanoTime();
        juego.mergeSort(arrayMerge, 0, arrayMerge.length - 1);
        long tiempoMerge = System.nanoTime() - inicioMerge;

        // Verificar que ambos algoritmos ordenaron correctamente
        assertTrue(estaOrdenado(arrayQuick), "QuickSort debe ordenar correctamente");
        assertTrue(estaOrdenado(arrayMerge), "MergeSort debe ordenar correctamente");

        // Los tiempos deben ser razonables (menos de 1 segundo)
        assertTrue(tiempoQuick < 1_000_000_000L, "QuickSort debe completarse en menos de 1 segundo");
        assertTrue(tiempoMerge < 1_000_000_000L, "MergeSort debe completarse en menos de 1 segundo");

        System.out.println("Rendimiento en array de 10,000 elementos:");
        System.out.println("QuickSort: " + (tiempoQuick / 1_000_000.0) + " ms");
        System.out.println("MergeSort: " + (tiempoMerge / 1_000_000.0) + " ms");
    }

    @Test
    @DisplayName("Complejidad búsqueda binaria vs búsqueda lineal")
    void testComplejidadBusqueda() {
        // Crear array ordenado grande
        int[] arrayGrande = new int[100000];
        for (int i = 0; i < arrayGrande.length; i++) {
            arrayGrande[i] = i * 2; // Array ordenado: 0, 2, 4, 6, ...
        }

        int elementoBuscado = arrayGrande[arrayGrande.length - 1]; // Último elemento

        // Búsqueda binaria
        long inicioBinaria = System.nanoTime();
        int indiceBinario = juego.busquedaBinaria(arrayGrande, elementoBuscado);
        long tiempoBinaria = System.nanoTime() - inicioBinaria;

        // Búsqueda lineal para comparar
        long inicioLineal = System.nanoTime();
        int indiceLineal = busquedaLineal(arrayGrande, elementoBuscado);
        long tiempoLineal = System.nanoTime() - inicioLineal;

        // Ambas búsquedas deben encontrar el elemento
        assertEquals(indiceLineal, indiceBinario, "Ambas búsquedas deben encontrar el mismo índice");

        // La búsqueda binaria debe ser significativamente más rápida
        assertTrue(tiempoBinaria < tiempoLineal,
                "La búsqueda binaria debe ser más rápida que la lineal");

        System.out.println("Búsqueda en array de 100,000 elementos:");
        System.out.println("Búsqueda binaria: " + (tiempoBinaria / 1000.0) + " microsegundos");
        System.out.println("Búsqueda lineal: " + (tiempoLineal / 1000.0) + " microsegundos");
        System.out.println("Mejora de rendimiento: " + (tiempoLineal / (double) tiempoBinaria) + "x");
    }

    /**
     * Método auxiliar para búsqueda lineal (para comparación de rendimiento)
     */
    private int busquedaLineal(int[] array, int objetivo) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == objetivo) {
                return i;
            }
        }
        return -1;
    }

    @Test
    @DisplayName("Estabilidad de MergeSort")
    void testEstabilidadMergeSort() {
        // MergeSort debe ser estable (mantener orden relativo de elementos iguales)
        // Para arrays de enteros simples, verificamos que ordene correctamente
        int[] arrayConDuplicados = {5, 2, 8, 2, 9, 1, 2};
        int[] arrayEsperado = {1, 2, 2, 2, 5, 8, 9};

        juego.mergeSort(arrayConDuplicados, 0, arrayConDuplicados.length - 1);
        assertArrayEquals(arrayEsperado, arrayConDuplicados,
                "MergeSort debe ordenar correctamente arrays con duplicados");
    }

    @Test
    @DisplayName("Casos extremos - Array ya ordenado")
    void testArrayYaOrdenado() {
        int[] arrayOrdenado = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arrayOriginal = Arrays.copyOf(arrayOrdenado, arrayOrdenado.length);

        // QuickSort
        int[] arrayQuick = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
        juego.quickSort(arrayQuick, 0, arrayQuick.length - 1);
        assertArrayEquals(arrayOriginal, arrayQuick,
                "QuickSort debe manejar correctamente array ya ordenado");

        // MergeSort
        int[] arrayMerge = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
        juego.mergeSort(arrayMerge, 0, arrayMerge.length - 1);
        assertArrayEquals(arrayOriginal, arrayMerge,
                "MergeSort debe manejar correctamente array ya ordenado");
    }

    @Test
    @DisplayName("Casos extremos - Array en orden inverso")
    void testArrayOrdenInverso() {
        int[] arrayInverso = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] arrayEsperado = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // QuickSort
        int[] arrayQuick = Arrays.copyOf(arrayInverso, arrayInverso.length);
        juego.quickSort(arrayQuick, 0, arrayQuick.length - 1);
        assertArrayEquals(arrayEsperado, arrayQuick,
                "QuickSort debe manejar correctamente array en orden inverso");

        // MergeSort
        int[] arrayMerge = Arrays.copyOf(arrayInverso, arrayInverso.length);
        juego.mergeSort(arrayMerge, 0, arrayMerge.length - 1);
        assertArrayEquals(arrayEsperado, arrayMerge,
                "MergeSort debe manejar correctamente array en orden inverso");
    }

    @Test
    @DisplayName("Validar que no hay desbordamiento de índices")
    void testNoDesbordamientoIndices() {
        int[] arrayPequeno = {3, 1, 2};

        assertDoesNotThrow(() -> {
            juego.quickSort(arrayPequeno, 0, arrayPequeno.length - 1);
        }, "QuickSort no debe causar desbordamiento de índices");

        int[] arrayPequeno2 = {3, 1, 2};
        assertDoesNotThrow(() -> {
            juego.mergeSort(arrayPequeno2, 0, arrayPequeno2.length - 1);
        }, "MergeSort no debe causar desbordamiento de índices");
    }

    @Test
    @DisplayName("Consistencia entre múltiples ejecuciones")
    void testConsistenciaMultiplesEjecuciones() {
        int[] arrayBase = {64, 34, 25, 12, 22, 11, 90, 5, 77, 30};

        // Ejecutar QuickSort múltiples veces
        int[] resultado1 = Arrays.copyOf(arrayBase, arrayBase.length);
        int[] resultado2 = Arrays.copyOf(arrayBase, arrayBase.length);

        juego.quickSort(resultado1, 0, resultado1.length - 1);
        juego.quickSort(resultado2, 0, resultado2.length - 1);

        assertArrayEquals(resultado1, resultado2,
                "QuickSort debe dar resultados consistentes");

        // Ejecutar MergeSort múltiples veces
        int[] resultado3 = Arrays.copyOf(arrayBase, arrayBase.length);
        int[] resultado4 = Arrays.copyOf(arrayBase, arrayBase.length);

        juego.mergeSort(resultado3, 0, resultado3.length - 1);
        juego.mergeSort(resultado4, 0, resultado4.length - 1);

        assertArrayEquals(resultado3, resultado4,
                "MergeSort debe dar resultados consistentes");
    }

    private boolean estaOrdenado(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }}
