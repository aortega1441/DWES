/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_repaso_5;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author vecto
 */
public class Ejercicio_repaso_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner leer = new Scanner(System.in);

        String nombre = "";
        int nMatricula = 0;
        double pNota = 0;
        double sNota = 0;

        do {
            System.out.println("Introduce el nombre: ");

            nombre = leer.next();

            for (int x = 0; x < nombre.length(); x++) {

                boolean num = Character.isDigit(nombre.charAt(x));
                if (num == true) {
                    nombre = "";
                    break;
                }

            }

        } while (nombre == "");

        do {
            System.out.println("Introduce el nº del alumno: ");
            try {
                nMatricula = leer.nextInt();
            } catch (InputMismatchException e) {
                nMatricula = 0;
                leer.next();
            }

        } while (nMatricula <= 0);

        do {
            System.out.println("Introduce la primera nota: ");
            try {

                pNota = leer.nextDouble();
            } catch (InputMismatchException e) {
                pNota = -1;
                leer.next();
            }
        } while (pNota < 0 || pNota > 10);

        do {
            System.out.println("Introduce la segunda nota: ");
            try {

                sNota = leer.nextDouble();
            } catch (InputMismatchException e) {
                sNota = -1;
                leer.next();
            }
        } while (sNota < 0 || sNota > 10);

        Alumno alumno = new Alumno(nombre, 0);

        String resultado = alumno.muestraAlumno(nombre, nMatricula, pNota, sNota);
        System.err.println(resultado);

    }

}
