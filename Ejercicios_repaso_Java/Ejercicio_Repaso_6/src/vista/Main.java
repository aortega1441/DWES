/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.util.Scanner;
import modelo.Vehiculo;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *
 * @author vecto
 */
public class Main {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        Vehiculo vehiculo = new Vehiculo();
        Controlador controlador = new Controlador();
        ArrayList<Vehiculo> lista = controlador.getListaVehiculos();

        String modelo = "";
        double potencia = 0;
        boolean cRuedas = false;
        String traccion = "";
        boolean salir = false;
        boolean repetir = false;

        do {
            salir = false;
            repetir = false;
            System.out.println("Introduce el modelo del vehículo (fin para salir): ");
            modelo = leer.next();
            vehiculo = new Vehiculo(modelo);

            modelo.toLowerCase();

            if (modelo.equals("fin")) {
                salir = true;
            } else {
                do {

                    repetir = false;
                    try {

                        System.out.println("Introduce la potencia del vehículo: ");
                        potencia = leer.nextDouble();
                        vehiculo.setPotencia(potencia);

                    } catch (InputMismatchException e) {
                        leer.next();
                        repetir = true;
                    }

                } while (repetir);

                System.out.println("Tracción a 4 ruedas (si/no): ");
                traccion = leer.next();
                vehiculo.setcRuedas(cRuedas);

                if (traccion.equals("siS")) {
                    cRuedas = true;
                } else {
                    cRuedas = false;
                }

                controlador.agregarVehiculo(vehiculo);
            }

        } while (!salir);

        for (int x = 0; x < lista.size(); x++) {
            System.out.println(lista.get(x).toString());
        }

    }

}
