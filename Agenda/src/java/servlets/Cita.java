package servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vecto
 */
public class Cita implements Comparable<Cita> {

    private String persona;
    private String dni;
    private String fecha;
    private String telefono;
    private String email;
    private String asunto;
    private String prioridad;

    public Cita(String persona, String dni, String fecha, String telefono, String email, String asunto, String prioridad) {
        this.persona = persona;
        this.dni = dni;
        this.fecha = fecha;
        this.telefono = telefono;
        this.email = email;
        this.asunto = asunto;
        this.prioridad = prioridad;
    }

    public String getPersona() {
        return persona;
    }

    public String getDni() {
        return dni;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Cita{" + "persona=" + persona + ", dni=" + dni + ", fecha=" + fecha + ", telefono=" + telefono + ", email=" + email + ", asunto=" + asunto + ", prioridad=" + prioridad + '}';
    }

    @Override
    public int compareTo(Cita o) {
        return this.fecha.compareTo(o.getFecha());
    }

}
