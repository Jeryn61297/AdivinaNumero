# AdivinaNumero

Aplicación interactiva de consola desarrollada en Java. El objetivo es adivinar un número secreto generado aleatoriamente por el sistema, entre **1 y 10**, con un máximo de **3 intentos válidos**.

## Requisitos

- Tener instalado un JDK compatible con Java 17 o superior. El código utiliza `Random.nextInt(origin, bound)`, disponible desde Java 17.
- Contar con una terminal (CMD, PowerShell o terminal de un IDE).
- Guardar el código en un archivo llamado `AdivinaNumero.java`.

## ¿Cómo funciona el programa?

### 1. Importación de clases

```java
import java.util.Random;
import java.util.Scanner;
```

- `Random` permite generar el número secreto de forma aleatoria.
- `Scanner` permite leer la información que escribe el usuario en la consola.

### 2. Declaración de la clase y del método principal

```java
public class AdivinaNumero {
    public static void main(String[] args) {
        // ...
    }
}
```

`AdivinaNumero` es la clase principal. El método `main` es el punto de entrada desde el que comienza la ejecución del programa.

### 3. Creación de objetos

```java
Scanner sc = new Scanner(System.in);
Random random = new Random();
```

- `sc` lee las entradas del usuario desde la consola.
- `random` se utiliza para generar el número secreto.

### 4. Definición de constantes y variables

```java
final int NUMERO_MINIMO = 1;
final int NUMERO_MAXIMO = 10;
final int MAX_INTENTOS = 3;
```

Las constantes establecen el rango permitido y el número máximo de intentos. La palabra `final` impide que sus valores se reasignen después de inicializarlos.

Las variables principales son:

- `nombreUsuario`: almacena el nombre ingresado.
- `numeroUsuario`: guarda el número que intenta adivinar el jugador.
- `numeroSecreto`: contiene el número generado por el sistema.
- `intentos`: se declara, aunque en esta versión no se utiliza posteriormente.
- `intentosRestantes`: se declara, pero el programa calcula los intentos restantes directamente; esta variable puede eliminarse.
- `adivinado`: indica si el jugador acertó. Empieza en `false` y cambia a `true` cuando adivina.

### 5. Presentación del juego y captura del nombre

El programa imprime el título y solicita el nombre del jugador:

```java
nombreUsuario = sc.nextLine();
```

`nextLine()` lee una línea de texto completa.

### 6. Generación del número secreto

```java
numeroSecreto = random.nextInt(
    NUMERO_MINIMO, NUMERO_MAXIMO + 1
);
```

El límite inferior es inclusivo y el superior es exclusivo. Por eso se suma `1` al máximo para generar un número entre **1 y 10**, incluidos ambos extremos.

### 7. Control de los intentos con `for`

```java
for (int intento = 1; intento <= MAX_INTENTOS; intento++) {
    // ...
}
```

El ciclo comienza en el intento 1 y termina después de un máximo de 3 intentos válidos. La variable `intento` aumenta automáticamente al final de cada iteración, salvo que se use `continue` o `break`.

### 8. Validación de la entrada

```java
if (!sc.hasNextInt()) {
    System.out.println(
        "Entrada invalida. Debes ingresar un numero entero."
    );
    sc.nextLine();
    intento--;
    continue;
}
```

- `hasNextInt()` comprueba si la siguiente entrada puede interpretarse como un entero.
- `!` invierte el resultado para detectar entradas inválidas.
- `nextLine()` consume el resto de la línea inválida para que no se vuelva a leer.
- `intento--` compensa el incremento del ciclo `for`, de modo que una entrada inválida no consuma un intento.
- `continue` inicia la siguiente iteración del ciclo.

Esta validación rechaza texto, símbolos y números que no puedan interpretarse como enteros. No acepta decimales como `3.5`. Sin embargo, sí acepta enteros fuera del rango, que se rechazan en el siguiente paso.

### 9. Validación del rango permitido

```java
if (numeroUsuario < NUMERO_MINIMO
        || numeroUsuario > NUMERO_MAXIMO) {
    System.out.println(
        "El numero debe estar entre "
        + NUMERO_MINIMO + " y " + NUMERO_MAXIMO + "."
    );
    intento--;
    continue;
}
```

El operador `||` significa “o”. Si el número es menor que 1 o mayor que 10, se muestra un mensaje y no se consume un intento.

### 10. Comparación con el número secreto

El programa compara el número ingresado con el número secreto:

- **Acierto:** muestra un mensaje de felicitación, indica en cuántos intentos se logró y cambia `adivinado` a `true`.
- **Número menor:** indica que el número secreto es mayor.
- **Número mayor:** indica que el número secreto es menor.

Cuando el jugador acierta, `break` termina inmediatamente el ciclo `for`.

### 11. Cálculo de intentos restantes

```java
if (intento < MAX_INTENTOS) {
    System.out.println(
        "Intentos restantes: " + (MAX_INTENTOS - intento)
    );
}
```

Si todavía quedan intentos, el programa muestra cuántos restan. Esta operación se realiza después de una respuesta numérica válida dentro del rango que no haya acertado.

### 12. Resultado final

Después del ciclo, el programa comprueba:

```java
if (!adivinado) {
    // ...
}
```

Si `adivinado` sigue siendo `false`, significa que se agotaron los intentos. Se muestra el número secreto y un mensaje de despedida. Si el jugador acertó, se omite ese bloque.

### 13. Cierre del `Scanner`

```java
sc.close();
```

Cierra el objeto `Scanner` al terminar el juego y libera el recurso asociado a la entrada.

## Cómo compilar y ejecutar

Abre una terminal en la carpeta donde guardaste `AdivinaNumero.java`.

### Windows (CMD o PowerShell)

1. Comprueba que Java y el compilador estén disponibles:

   ```bash
   java -version
   javac -version
   ```

2. Compila el programa:

   ```bash
   javac AdivinaNumero.java
   ```

3. Ejecuta la aplicación:

   ```bash
   java AdivinaNumero
   ```

Si la compilación termina correctamente, se generará `AdivinaNumero.class`.

## Cómo generar un JAR ejecutable

Después de compilar el código, ejecuta:

```bash
jar --create --file AdivinaNumero.jar --main-class AdivinaNumero AdivinaNumero.class
```

Luego ejecuta el JAR con:

```bash
java -jar AdivinaNumero.jar
```

Necesitas tener un JDK instalado para compilar y generar el JAR. Para ejecutar el JAR, la computadora debe contar con una versión compatible de Java.

## Ejemplo de uso

```text
---------------------
| ADIVINA EL NUMERO |
---------------------
Ingresa tu nombre:
Ana

Ana... ADIVINA EL NUMERO SECRETO
Solo tienes 3 intentos.

Intento 1 de 3. Ingresa un numero: hola
Entrada invalida. Debes ingresar un numero entero.

Intento 1 de 3. Ingresa un numero: 15
El numero debe estar entre 1 y 10.

Intento 1 de 3. Ingresa un numero: 4
Pista... el numero secreto es MAYOR.
Intentos restantes: 2
```

*El ejemplo es ilustrativo; el número secreto cambia en cada ejecución.*

## Conceptos de Java que se practican

- Importación de clases y creación de objetos.
- Método `main`.
- Variables y constantes con `final`.
- Entrada y salida por consola.
- Generación de números aleatorios.
- Ciclo `for`, condicionales `if / else if / else`.
- Validación de entradas con `Scanner`.
- Operadores lógicos y relacionales.
- Uso de `continue` y `break`.
- Variables booleanas para controlar el estado del juego.

## Posibles mejoras

- Reemplazar las variables declaradas que no se utilizan (`intentos` e `intentosRestantes`) para mantener el código limpio.
- Separar la validación, la lógica del juego y los mensajes en métodos independientes.
- Preguntar si el jugador quiere volver a jugar.
- Añadir pruebas para las entradas inválidas y los límites del rango.

---

Proyecto de práctica para aprender fundamentos de Java.
