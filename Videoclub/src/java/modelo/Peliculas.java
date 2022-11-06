/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author vecto
 */
public class Peliculas {
    
    private String titulo;
    private String director;
    private String fechaEstreno;

    public Peliculas(String titulo, String director, String fechaEstreno) {
        this.titulo = titulo;
        this.director = director;
        this.fechaEstreno = fechaEstreno;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }
    
    
    
}
