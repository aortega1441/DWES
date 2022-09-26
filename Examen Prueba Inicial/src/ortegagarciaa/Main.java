/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortegagarciaa;

import java.util.InputMismatchException;
import java.util.Scanner;
import ortegagarciaa.Alimento;

/**
 *
 * @author vecto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String nombre = "";
        double lipidos = 0;
        double hidratos = 0;
        double proteinas = 0;
        String origen = "";
        String minerales = "X";
        String vitaminas = "X";

        Scanner leer = new Scanner(System.in);

        boolean Ncorrecto = false;
        do {
            System.out.println("Denominación de un alimento: ");
            try {
                nombre = leer.next();

                for (int x = 0; x < nombre.length(); x++) {
                    if (Character.isDigit(nombre.charAt(x))) {
                        Ncorrecto = false;
                        break;
                    } else {
                        Ncorrecto = true;
                    }
                }

            } catch (InputMismatchException e) {
                nombre = "";
                Ncorrecto = false;
                leer.next();
            }

        } while (!Ncorrecto || nombre.equals(""));

        double suma = 0;

        do {

            do {
                System.out.println("Contenido en % de proteínas: ");
                try {

                    proteinas = leer.nextDouble();

                } catch (InputMismatchException e) {
                    proteinas = 0;
                    leer.next();
                }

            } while (proteinas == 0);

            do {
                System.out.println("Contenido en % de lípidos: ");
                try {

                    lipidos = leer.nextDouble();

                } catch (InputMismatchException e) {
                    lipidos = 0;
                    leer.next();
                }

            } while (lipidos == 0);

            do {
                System.out.println("Contenido en % de hidratos: ");
                try {

                    hidratos = leer.nextDouble();

                } catch (InputMismatchException e) {
                    hidratos = 0;
                    leer.next();
                }

            } while (hidratos == 0);

            suma = proteinas + lipidos + hidratos;

        } while (suma > 100 || suma < 0);

        boolean Mcorrecto = false;
        do {
            System.out.println("Contenido en minerales: ");
            try {
                minerales = leer.next();
                minerales = minerales.toLowerCase();

                if (minerales.equals("a") || minerales.equals("m") || minerales.equals("b")) {
                    Mcorrecto = true;
                } else {
                    Mcorrecto = false;
                }
            } catch (InputMismatchException e) {
                minerales = "";
                leer.next();
            }

        } while (!Mcorrecto || minerales.equals(""));

        boolean Vcorrecto = false;
        do {
            System.out.println("Contenido en vitaminas: ");
            try {
                vitaminas = leer.next();
                vitaminas = vitaminas.toLowerCase();

                if (vitaminas.equals("a") || vitaminas.equals("m") || vitaminas.equals("b")) {
                    Vcorrecto = true;
                } else {
                    Vcorrecto = false;
                }
            } catch (InputMismatchException e) {
                vitaminas = "";
                leer.next();
            }

        } while (!Vcorrecto || vitaminas.equals(""));

        System.out.println("¿Es de origen animal? (S/N): ");
        origen = leer.next();
        origen = origen.toLowerCase();

        Alimento alimento = new Alimento(nombre, lipidos, hidratos, proteinas, origen, minerales, vitaminas);

        System.out.println(alimento.mostrarAlimento(nombre, proteinas, lipidos, hidratos, minerales, vitaminas));
        System.out.println(alimento.esDietetico(lipidos, vitaminas));
        System.out.println(alimento.recomendableParaDeportistas(proteinas, lipidos, hidratos));
        System.out.println(alimento.contenidoEnergetico(proteinas, lipidos, hidratos));

    }

}
