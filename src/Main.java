import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 3.- Realiza un programa en JAVA en el que le pidas al usuario su DNI y:
 * En caso de que el DNI sea correcto lo introducirás en un fichero llamado dni.txt.
 * En caso de que el DNI sea incorrecto avisarás al usuario del error y no lo introducirás en el fichero.
 * Cuando vuelvas a ejecutar el programa no se sobrescribirá el fichero, sino que se seguirán añadiendo
 * DNIs validos al final del fichero dni.txt.
 * Hay que calcular la letra del DNI usando el método matemático que corresponde.
 */
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("****************************************");
        System.out.println("**      Bienvenidos Al Programa       **");
        System.out.println("**      Por Favor Ingrese su DNI      **");
        System.out.println("****************************************");

        String DNI = entrada.nextLine().toUpperCase();

        int numero = Integer.parseInt(DNI.substring(0, 8));
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indice = numero % 23;
        char letra = letras.charAt(indice);
        char letraIngresada = DNI.charAt(8);


        if (letraIngresada == letra) {
            File archivo = new File("dni.txt");
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
                bw.write(DNI + "\n");
                bw.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("El Número de DNI Ingresado es Válido y se ha Guardado Correctamente!");
        } else {
            System.out.println("El Número de DNI Ingresado es Incorrecto y no se Guardará en la Base de Datos!");
        }


    }
}