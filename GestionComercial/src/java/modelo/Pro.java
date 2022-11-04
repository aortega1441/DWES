/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author vecto
 */
public class Pro {

    private String referencia;
    private String nombre;
    private String descripcion;
    private String precio;
    private String descuento;

    public Pro(String referencia, String nombre, String descripcion, String precio, String descuento) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.descuento = descuento;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Pro{" + "referencia=" + referencia + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", descuento=" + descuento + '}';
    }

}
