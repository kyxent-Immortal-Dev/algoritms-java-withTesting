# 🏛️ El Cáliz de los Códigos Perdidos

**Proyecto Java: Algoritmos de Ordenamiento, Búsqueda y Análisis de Complejidad**

---

## 📖 Descripción del Proyecto

"El Cáliz de los Códigos Perdidos" es un proyecto educativo que combina algoritmos fundamentales de ciencias de la computación con una narrativa envolvente. Los estudiantes implementan algoritmos de ordenamiento y búsqueda para descifrar el mensaje secreto de un antiguo oráculo.

### 🎯 Objetivos Académicos

- **Implementar** algoritmos de ordenamiento eficientes (QuickSort y MergeSort)
- **Aplicar** búsqueda binaria sobre datos ordenados  
- **Analizar** la complejidad algorítmica Big O
- **Comparar** el rendimiento de diferentes algoritmos
- **Documentar** código con estándares profesionales

---

## 🏗️ Arquitectura del Proyecto

```
TheCalizCodeLost/
├── src/
│   ├── Main.java                    # Clase principal del juego
│   ├── TestMainApp.java               # Pruebas unitarias
│   └── ComplejidadAlgoritmica.java # Análisis de complejidad
├── README.md                       # Este archivo
├── .gitignore                      # Archivos ignorados por Git
└── TheCalizCodeLost.iml           # Configuración de IntelliJ IDEA
```

---

## 🔧 Tecnologías Utilizadas

- **Java 20+** - Lenguaje de programación principal
- **JUnit 5** - Framework para pruebas unitarias
- **IntelliJ IDEA** - IDE recomendado
- **Git** - Control de versiones

---

## 🚀 Instrucciones de Instalación y Ejecución

### Prerrequisitos

- Java Development Kit (JDK) 20 o superior
- IDE Java (IntelliJ IDEA, Eclipse, NetBeans)
- JUnit 5 para ejecutar las pruebas

### Pasos de Instalación

1. **Clonar o descargar el proyecto**
   ```bash
   git clone https://github.com/kyxent-Immortal-Dev/algoritms-java-withTesting

   cd algoritms-java-withTesting

   ```

2. **Abrir en tu IDE preferido**
   - Para IntelliJ IDEA: Abrir el directorio del proyecto
   - Para Eclipse: Importar como proyecto Java existente
   - Para NetBeans: Abrir proyecto

3. **Configurar JDK**
   - Asegúrate de que el proyecto use JDK 20+
   - Configura el path de compilación si es necesario

### Ejecución del Programa Principal

1. **Compilar el proyecto**
   ```bash
   javac -cp src src/Main.java
   ```

2. **Ejecutar el juego**
   ```bash
   java -cp src Main
   ```

### Ejecutar Pruebas Unitarias

Si tienes JUnit configurado en tu IDE:
1. Clic derecho en `TestMainApp.java`
2. Seleccionar "Run Tests" o "Ejecutar Pruebas"

---

## 🎮 Cómo Jugar

### Flujo del Juego

1. **Inicialización**: El programa genera 1000 números únicos entre 1000-9999
2. **Selección de Clave**: Se elige aleatoriamente un número como "clave mágica"
3. **Ordenamiento**: Los números se ordenan usando algoritmos eficientes
4. **Desafío**: El usuario tiene 5 intentos para encontrar la clave mágica
5. **Búsqueda**: Se utiliza búsqueda binaria para localizar el número ingresado
6. **Revelación**: Si acierta, se revela el mensaje secreto del oráculo

### Ejemplo de Ejecución

```
🏛️ Bienvenido al Cáliz de los Códigos Perdidos
==================================================

🧙 El Cáliz de los Códigos Perdidos ha sido inicializado...
Array de 1000 números mágicos generado.
Una clave secreta ha sido elegida por el oráculo...

📊 ANÁLISIS DE RENDIMIENTO DE ALGORITMOS

⚡ QuickSort:
   Tiempo: 2.45 ms
   Complejidad promedio: O(n log n)
   Complejidad peor caso: O(n²)

⚡ MergeSort:
   Tiempo: 3.21 ms
   Complejidad: O(n log n) garantizada

🎯 Array ordenado exitosamente usando QuickSort (más rápido en esta ejecución)

📈 ESTADÍSTICAS DEL CÁLIZ
Tamaño del array: 1000
Número menor: 1003
Número mayor: 9997
Clave mágica: 5847
Posición de la clave en array ordenado: 537

🔮 EL DESAFÍO DEL ORÁCULO
El oráculo ha ocultado un mensaje entre los números mágicos.
Debes encontrar la clave correcta para revelarlo.

💡 Pistas - Algunos números del cáliz:
1003 1089 1156 1203 1278 1345 1423 1498 1567 1634 ...

🔍 Ingresa el número mágico (intento 1/5): 5847
⏱️ Búsqueda completada en 245.3 microsegundos

🎉 ¡FELICITACIONES! Has encontrado la clave mágica: 5847
✨ El oráculo revela su mensaje:
📜 "El portal al reino sumergido se abrirá cuando el sol cruce la cima del monte hueco."

🏆 ¡Has completado exitosamente el desafío!
```

---

## 🧠 Algoritmos Implementados

### 1. QuickSort
- **Complejidad promedio**: O(n log n)
- **Complejidad peor caso**: O(n²)  
- **Complejidad espacial**: O(log n)
- **Características**: In-place, no estable, cache-friendly

### 2. MergeSort
- **Complejidad temporal**: O(n log n) garantizada
- **Complejidad espacial**: O(n)
- **Características**: Estable, predecible, paralelizable

### 3. Búsqueda Binaria
- **Complejidad temporal**: O(log n)
- **Complejidad espacial**: O(1)
- **Prerequisito**: Array previamente ordenado

---

## 🧪 Pruebas Unitarias

El proyecto incluye 20+ pruebas unitarias que validan:

### Pruebas de Inicialización
- ✅ Generación correcta de 1000 números únicos
- ✅ Validación del rango de números (1000-9999)
- ✅ Existencia de clave mágica en el array

### Pruebas de Ordenamiento
- ✅ Correctitud de QuickSort y MergeSort
- ✅ Manejo de casos extremos (arrays vacíos, un elemento)
- ✅ Arrays ya ordenados y en orden inverso
- ✅ Consistencia entre múltiples ejecuciones

### Pruebas de Búsqueda
- ✅ Búsqueda binaria encuentra elementos existentes
- ✅ Retorna -1 para elementos inexistentes
- ✅ Manejo de casos extremos (primer/último elemento)
- ✅ Comparación de rendimiento vs búsqueda lineal

### Pruebas de Rendimiento
- ✅ Medición de tiempos de ejecución
- ✅ Validación de complejidad algorítmica
- ✅ Comparación QuickSort vs MergeSort

---

## 📊 Análisis de Complejidad

### Comparación de Algoritmos

| Algoritmo | Mejor Caso | Caso Promedio | Peor Caso | Espacio |
|-----------|------------|---------------|-----------|---------|
| QuickSort | O(n log n) | O(n log n)    | O(n²)     | O(log n)|
| MergeSort | O(n log n) | O(n log n)    | O(n log n)| O(n)    |
| Búsqueda Binaria | O(1) | O(log n) | O(log n) | O(1) |

### Recomendaciones de Uso

**QuickSort**: Ideal cuando la memoria es limitada y los datos tienen distribución aleatoria.

**MergeSort**: Preferible cuando se requiere rendimiento garantizado y estabilidad.

**Búsqueda Binaria**: Siempre usar en datos ordenados para búsquedas eficientes.

---

## 📁 Estructura del Código

### Clase Main.java

```java
// Métodos principales
- inicializarDatos()        // O(n) - Genera números aleatorios únicos
- quickSort()              // O(n log n) promedio - Algoritmo de ordenamiento  
- mergeSort()              // O(n log n) garantizado - Algoritmo estable
- busquedaBinaria()        // O(log n) - Búsqueda eficiente
- compararAlgoritmos()     // Análisis de rendimiento
- ejecutarJuego()          // Lógica principal del juego
```

### Características del Código

- **Documentación completa** con JavaDoc
- **Manejo de excepciones** para entrada de usuario
- **Medición de rendimiento** con System.nanoTime()
- **Interfaz de usuario intuitiva** con emojis y colores
- **Modularidad** y reutilización de código

---

## 🔍 Casos de Prueba Especiales

### Casos Extremos Validados

1. **Arrays vacíos**: Ambos algoritmos manejan correctamente arrays de tamaño 0
2. **Un elemento**: Verificación de casos base en recursión
3. **Arrays ordenados**: QuickSort mantiene eficiencia, MergeSort es consistente
4. **Orden inverso**: Validación del peor caso de QuickSort
5. **Elementos duplicados**: MergeSort mantiene estabilidad

### Validaciones de Robustez

- Prevención de desbordamiento de índices
- Manejo de entrada inválida del usuario
- Verificación de prerequisitos (array ordenado para búsqueda binaria)
- Pruebas de estrés con arrays grandes (10,000+ elementos)

---

## 📈 Resultados de Rendimiento

### Benchmarks Típicos (Hardware Moderno)

**Array de 1,000 elementos:**
- Generación: < 1ms
- QuickSort: 1-3ms
- MergeSort: 2-4ms  
- Búsqueda Binaria: < 0.001ms

**Array de 10,000 elementos:**
- QuickSort: 5-15ms
- MergeSort: 10-20ms
- Búsqueda Binaria: < 0.01ms

**Array de 100,000 elementos:**
- QuickSort: 50-500ms (variable)
- MergeSort: 100-200ms (consistente)

---

## 🎓 Valor Educativo

### Conceptos Aprendidos

1. **Algoritmos Fundamentales**: Implementación práctica de algoritmos clásicos
2. **Análisis de Complejidad**: Comprensión teórica y práctica de Big O
3. **Trade-offs**: Balance entre tiempo, espacio y estabilidad
4. **Pruebas de Software**: Desarrollo de pruebas unitarias comprehensivas
5. **Documentación**: Estándares profesionales de documentación de código

### Habilidades Desarrolladas

- Implementación de algoritmos recursivos
- Análisis de rendimiento y optimización
- Manejo de casos extremos y validación
- Diseño de interfaces de usuario intuitivas
- Testing automatizado y validación de correctitud

---

## 🛠️ Posibles Extensiones

### Funcionalidades Adicionales

1. **Más Algoritmos**: HeapSort, RadixSort, CountingSort
2. **Visualización**: Interfaz gráfica para ver el proceso de ordenamiento
3. **Multithreading**: Implementación paralela de MergeSort
4. **Persistencia**: Guardar estadísticas y puntajes
5. **Configuración**: Tamaños de array variables, rangos personalizados

### Optimizaciones Avanzadas

1. **Introsort**: Híbrido QuickSort/HeapSort para evitar peor caso
2. **TimSort**: Optimización para datos parcialmente ordenados
3. **Cache Optimization**: Mejoras en localidad de referencias
4. **Tail Recursion**: Optimización de recursión de cola

---

## 👥 Créditos y Reconocimientos

**Desarrollado para**: Java Developer 20JJA  
**Dev**: Ezequiel Campos  
**Proyecto**: Algoritmos de Ordenamiento y Búsqueda  
**Fecha**: Mayo 2025

### Inspiración

Este proyecto combina el aprendizaje de algoritmos fundamentales con una narrativa gamificada para hacer el aprendizaje más atractivo y memorable.

---
