/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercvicio_repaso_2;

/**
 *
 * @author vecto
 */
public class Ejercvicio_Repaso_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("Numeros primos menores de 15");

        int num_primo = 1;
        int contador = 0;

        while (num_primo < 15) {
            for (int x = 1; x <= num_primo; x++) {
                int num = num_primo % x;
                if (num == 0) {
                    contador++;
                }
            }

            if (contador == 2 || num_primo == 1) {
                System.out.println(num_primo + ", ");
            }

            contador = 0;
            num_primo++;
        }

    }

}
