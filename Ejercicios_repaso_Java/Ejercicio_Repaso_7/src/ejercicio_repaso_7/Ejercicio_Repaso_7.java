/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_repaso_7;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author vecto
 */
public class Ejercicio_Repaso_7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner leer = new Scanner(System.in);

        //NUMERO
        int num = 0;
        boolean correcto = false;
        do {
            System.out.println("Teclea un número mayor de 10 y menor que 30:");

            try {
                num = leer.nextInt();
                if (num <= 10 || num >= 30) {
                    correcto = false;
                } else {
                    correcto = true;
                }
            } catch (InputMismatchException e) {
                correcto = false;
                leer.next();

            }
        } while (!correcto);

        //DIVISIBLE POR 5
        if (num % 5 == 0) {
            System.out.println("El número " + num + " es divisible por 5.");
        } else {
            System.out.println("El número " + num + " no es divisible por 5.");
        }

        //NOMBRE
        String nombre = "";

        do {
            System.out.println("Introduce el nombre: ");

            nombre = leer.next();

            for (int x = 0; x < nombre.length(); x++) {

                boolean numero = Character.isDigit(nombre.charAt(x));
                if (numero == true) {
                    nombre = "";
                    break;
                }

            }

        } while (nombre == "");

        System.out.println("Tu nombre tiene " + nombre.length() + " caracteres.");

        String arrayNombre[] = nombre.split("");
        System.out.println("Tu nombre empieza por la letra: " + arrayNombre[0]);

        System.out.println("Tu nombre termina por la letra: " + arrayNombre[arrayNombre.length - 1]);

        nombre = nombre.toUpperCase();
        System.out.println("Tu nombre en mayúsculas es: " + nombre);

        nombre = nombre.toLowerCase();
        System.out.println("Tu nombre en minúsculas es: " + nombre);

        boolean letraP = false;
        for (int x = 0; x < arrayNombre.length; x++) {

            if (arrayNombre[x].equals("p")) {
                letraP = true;
                break;
            }

        }

        if (letraP) {
            System.out.println("Tu nombre tiene la letra 'p'.");
        } else {
            System.out.println("Tu nombre no tiene la letra 'p'.");
        }

    }

}
