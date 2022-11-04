/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author vecto
 */
public class Comercial {
    
    private String codigo;
    private String nombre;
    private String salario;
    private String hijos;

    public Comercial(String codigo, String nombre, String salario, String hijos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salario = salario;
        this.hijos = hijos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSalario() {
        return salario;
    }

    public String getHijos() {
        return hijos;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public void setHijos(String hijos) {
        this.hijos = hijos;
    }
    
    
    
}
