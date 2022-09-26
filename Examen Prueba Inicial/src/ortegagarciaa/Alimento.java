/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortegagarciaa;

/**
 *
 * @author vecto
 */
public class Alimento {

    private String nombre;
    private double lipidos;
    private double hidratos;
    private double proteinas;
    private String origen;
    private String minerales;
    private String vitaminas;

    public Alimento(String nombre, double lipidos, double hidratos, double proteinas, String origen, String minerales, String vitaminas) {
        this.nombre = nombre;
        this.lipidos = lipidos;
        this.hidratos = hidratos;
        this.proteinas = proteinas;
        this.origen = origen;
        this.minerales = minerales;
        this.vitaminas = vitaminas;
    }

    public String esDietetico(double lipidos, String vitaminas) {

        if (lipidos < 20 && vitaminas.equals("B")) {

            return "Si es dietetico";

        } else {
            return "No es dietetico";
        }

    }

    public String recomendableParaDeportistas(double proteinas, double lipidos, double hidratos) {

        if (proteinas >= 10 && proteinas <= 15 && lipidos >= 30 && lipidos <= 35 && hidratos >= 55 && hidratos <= 65) {
            return "Es recomendable para deportistas";
        } else {
            return "No es recomendable para deportistas";
        }

    }

    public String contenidoEnergetico(double proteinas, double lipidos, double hidratos) {

        double resultado = 0;

        resultado = (proteinas * 5.3) + (lipidos * 9.4) + (hidratos * 4.1);

        return "Contenido energético: " + resultado + " Kcal/gr";

    }

    public String mostrarAlimento(String nombre, double proteinas, double lipidos, double hidratos, String minerales, String vitaminas) {

        String vit = "";
        String min = "";

        String animal = "";
        if (vitaminas.equals("a")) {
            vit = "alto";
        } else if (vitaminas.equals("m")) {
            vit = "medio";
        } else if (vitaminas.equals("b")) {
            vit = "bajo";
        }

        if (minerales.equals("a")) {
            min = "alto";
        } else if (minerales.equals("m")) {
            min = "medio";
        } else if (minerales.equals("b")) {
            min = "bajo";
        }

        if (origen.equals("s")) {
            animal = "Es de origen animal.";
        } else if (origen.equals("n")) {
            animal = "No es de origen animal.";
        }

        String resultado = "Nombre: " + nombre + "\n" + "Analisis: " + "\n" + "      Lipidos: " + lipidos + "%." + "\n" + "      Hidratos de Carbono: " + hidratos + "%." + "\n" + "     Proteinas: " + proteinas + "%." + "\n" + "Contenido en vitaminas: " + vit + "\n" + "Contenido en minerales: " + min + "\n" + animal;

        return resultado;
    }

    public String getNombre() {
        return nombre;
    }

    public double getLipidos() {
        return lipidos;
    }

    public double getHidratos() {
        return hidratos;
    }

    public double getProteinas() {
        return proteinas;
    }

    public String getOrigen() {
        return origen;
    }

    public String getMinerales() {
        return minerales;
    }

    public String getVitaminas() {
        return vitaminas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLipidos(double lipidos) {
        this.lipidos = lipidos;
    }

    public void setHidratos(double hidratos) {
        this.hidratos = hidratos;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setMinerales(String minerales) {
        this.minerales = minerales;
    }

    public void setVitaminas(String vitaminas) {
        this.vitaminas = vitaminas;
    }

    @Override
    public String toString() {
        return "Alimento{" + "nombre=" + nombre + ", lipidos=" + lipidos + ", hidratos=" + hidratos + ", proteinas=" + proteinas + ", origen=" + origen + ", minerales=" + minerales + ", vitaminas=" + vitaminas + '}';
    }

}
