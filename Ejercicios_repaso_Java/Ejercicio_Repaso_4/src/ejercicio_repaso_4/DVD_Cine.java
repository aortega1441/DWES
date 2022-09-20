/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_repaso_4;

/**
 *
 * @author vecto
 */
public class DVD_Cine {

    private String nombre;
    private String actor_principal;
    private String director;
    private String categoria;
    private Double duracion;
    private String resumen;

    public DVD_Cine(String nombre, String actor_principal, String director, String categoria, Double duracion, String resumen) {
        this.nombre = nombre;
        this.actor_principal = actor_principal;
        this.director = director;
        this.categoria = categoria;
        this.duracion = duracion;
        this.resumen = resumen;
    }

    public String muestraDVDCine(String nombre, String director, String actores, String categoria, double duracion, String resumen) {

        String titulo = nombre.toUpperCase();
        String res = resumen;
        if (tieneResumen(resumen) == 0) {
            res = "No hay resumen";
        }
        return titulo + "\n" + "De: " + director + "\n" + "Con: " + actores + "\n" + categoria + " - " + duracion + "min" + "\n" + "Resumen: " + res;

    }

    public int tieneResumen(String resumen) {

        if (!resumen.equals("")) {
            return 1;
        } else {
            return 0;
        }

    }

    public int esThriller(String categoria) {
        categoria = categoria.toLowerCase();
        if (categoria.equals("thriller")) {
            return 1;
        } else {
            return 0;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getActor_principal() {
        return actor_principal;
    }

    public String getDirector() {
        return director;
    }

    public String getCategoria() {
        return categoria;
    }

    public Double getDuracion() {
        return duracion;
    }

    public String getResumen() {
        return resumen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setActor_principal(String actor_principal) {
        this.actor_principal = actor_principal;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    @Override
    public String toString() {
        return "Título de la película: " + "\n" + nombre + "\n" + "Actor principal: " + actor_principal + "\n" + "Director: " + director + "\n" + "Género: " + categoria + "\n" + "Duración: " + duracion + "\n" + "Resumen: " + resumen;
    }
}
