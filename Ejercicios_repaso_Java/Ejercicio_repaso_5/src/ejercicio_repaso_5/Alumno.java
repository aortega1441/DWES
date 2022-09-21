/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_repaso_5;

/**
 *
 * @author vecto
 */
public class Alumno {

    String nombre;
    int nMatricula;

    public Alumno(String nombre, int nMatricula) {
        this.nombre = nombre;
        this.nMatricula = nMatricula;
    }

    public double dameMedia(double pNota, double sNota) {

        return (pNota + sNota) / 2;

    }

    public String muestraAlumno(String nombre, int nMatricula, double pNota, double sNota) {

        double media = dameMedia(pNota, sNota);
        return nMatricula + " " + nombre + " nota media: " + media;
    }

    public String getNombre() {
        return nombre;
    }

    public int getnMatricula() {
        return nMatricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setnMatricula(int nMatricula) {
        this.nMatricula = nMatricula;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", nMatricula=" + nMatricula + '}';
    }

}
