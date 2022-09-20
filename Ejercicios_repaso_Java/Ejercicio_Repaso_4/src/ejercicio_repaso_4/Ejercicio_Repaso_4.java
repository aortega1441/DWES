/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_repaso_4;

import ejercicio_repaso_4.DVD_Cine;
import java.util.Scanner;

/**
 *
 * @author vecto
 */
public class Ejercicio_Repaso_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner leer = new Scanner(System.in);

        /*System.out.println("Nombre: ");
        String nombre = leer.next();
        System.out.println("Actor principal: ");
        String actor_principal = leer.next();
        System.out.println("Director: ");
        String director = leer.next();
        System.out.println("Categoria: ");
        String categoria = leer.next();
        System.out.println("Duracion (en minutos): ");
        double duracion = leer.nextDouble();
        System.out.println("Resumen: ");
        String resumen = leer.next();*/
        String nombre = "Un final en Hollywood";
        String actor_principal = "Woody Allen y George Hamilton";
        String director = "Woody Allen";
        String categoria = "Comedia";
        double duracion = 114.0;
        String resumen = "Resumen";

        DVD_Cine dvd = new DVD_Cine(nombre, actor_principal, director, categoria, duracion, resumen);
        System.out.println(dvd);

        System.out.println("...");

        String resultado = dvd.muestraDVDCine(nombre, director, nombre, categoria, duracion, resumen);
        System.out.println(resultado);

        System.out.println("...");

        String tieneResumen;
        if (dvd.tieneResumen(resumen) == 1) {
            tieneResumen = "La ficha tiene un resumen";
        } else {
            tieneResumen = "La ficha no tiene resumen";
        }

        String esThriller;
        if (dvd.esThriller(categoria) == 1) {
            esThriller = "Es Thriller";
        } else {
            esThriller = "No es Thriller";
        }

        System.out.println(esThriller + "\n" + tieneResumen);

    }

}
