import java.util.Random;
import java.util.Scanner;

/*
 * Aplicacion de consola interactiva.
 * El usuario debe adivinar el numero secreto generado por el sistema.
 * El usuario solo tiene 3 intentos.
 */

public class AdivinaNumero {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();

		final int NUMERO_MINIMO = 1;
		final int NUMERO_MAXIMO = 10;
		final int MAX_INTENTOS = 3;

		String nombreUsuario;
		int numeroUsuario;
		int numeroSecreto;
		int intentos = 0;
		int intentosRestantes;
		boolean adivinado = false;

		System.out.println("---------------------");
		System.out.println("| ADIVINA EL NUMERO |");
		System.out.println("---------------------");

		System.out.println("Ingresa tu nombre: ");
		nombreUsuario = sc.nextLine();

		System.out.println("\n" + nombreUsuario + "... ADIVINA EL NUMERO SECRETO");
		System.out.println("Solo tienes 3 intentos.");

		// GENERA UN NUMERO ALEATORIO
		numeroSecreto = random.nextInt(NUMERO_MINIMO, NUMERO_MAXIMO + 1);

		// CICLO FOR 
		for (int intento = 1; intento <= MAX_INTENTOS; intento++) {
			System.out.print("\nIntento " + intento + " de " + MAX_INTENTOS + ". Ingresa un numero: ");

			// VALIDA QUE INGRESEN UN NUMERO
			if (!sc.hasNextInt()) {
				System.out.println("Entrada invalida. Debes ingresar un numero entero.");
				sc.nextLine();
				intento--;
				continue;
			}

			numeroUsuario = sc.nextInt();

			// VALIDA QUE EL NUMERO ESTE DENTRO DEL RANGO
			if (numeroUsuario < NUMERO_MINIMO || numeroUsuario > NUMERO_MAXIMO) {
				System.out.println("El numero debe estar entre " + NUMERO_MINIMO + " y " + NUMERO_MAXIMO + ".");
				intento--;
				continue;
			}

			if (numeroUsuario == numeroSecreto) {
				System.out.println("FELICIDADES... Adivinaste el numero secreto.");
				System.out.println("Lo lograste en " + intento + " intento(s).");
				adivinado = true;
				break;
			} else if (numeroUsuario < numeroSecreto) {
				System.out.println("Pista... el numero secreto es MAYOR.");
			} else {
				System.out.println("Pista... el numero secreto es MENOR.");
			}

			// INTENTOS RESTANTES
			if (intento < MAX_INTENTOS) {
				System.out.println("Intentos restantes: " + (MAX_INTENTOS - intento));
			}
		}

		if (!adivinado) {
			System.out.println("\nSe agotaron tus tres intentos.");
			System.out.println("El numero secreto era: " + numeroSecreto);
			System.out.println("SUERTE A LA PROXIMA");
		}

		System.out.println("\nGRACIAS POR JUGAR.");

		sc.close();
	}
}