/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author vecto
 */
public class Usuario {

    private String nombre;
    private String apellidos;
    private String dwes;
    private String dwec;
    private String diw;
    private String daw;
    private String fct;
    private String proyecto;
    private String id;

    public Usuario(String nombre, String apellidos, String dwes, String dwec, String diw, String daw, String fct, String proyecto, String id) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dwes = dwes;
        this.dwec = dwec;
        this.diw = diw;
        this.daw = daw;
        this.fct = fct;
        this.proyecto = proyecto;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDwes() {
        return dwes;
    }

    public String getDwec() {
        return dwec;
    }

    public String getDiw() {
        return diw;
    }

    public String getDaw() {
        return daw;
    }

    public String getFct() {
        return fct;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDwes(String dwes) {
        this.dwes = dwes;
    }

    public void setDwec(String dwec) {
        this.dwec = dwec;
    }

    public void setDiw(String diw) {
        this.diw = diw;
    }

    public void setDaw(String daw) {
        this.daw = daw;
    }

    public void setFct(String fct) {
        this.fct = fct;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", dwes=" + dwes + ", dwec=" + dwec + ", diw=" + diw + ", daw=" + daw + ", fct=" + fct + ", proyecto=" + proyecto + ", id=" + id + '}';
    }

}
