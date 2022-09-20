/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_repaso_3;

/**
 *
 * @author vecto
 */
public class Ejercicio_Repaso_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int suma = 0;

        System.out.println("Divisibles entre 3 y 7:");
        for (int x = 100; x <= 150; x++) {

            if (x % 3 == 0 && x % 7 == 0) {
                System.out.println(x);
                suma = suma + x;
            }

        }

        System.out.println("Suma total: " + suma);

    }

}
