package Servlets;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vecto
 */
public class ActividadExtraescolar implements Comparable<ActividadExtraescolar> {

    private String nombre;
    private String lugar;
    private String fecha;
    private Date fechaComp;
    private String hora;
    private String destino;
    private String[] tipo;
    private String curso;
    private String profesor;
    private String observaciones;
    private String dpto;

    public ActividadExtraescolar(String nombre, String lugar, String fecha, String hora, String destino, String[] tipo, String curso, String profesor, String observaciones, String dpto) throws ParseException {
        this.setNombre(nombre);
        this.setLugar(lugar);
        this.fecha = fecha;
        this.setFechaComp(fecha);
        this.setHora(hora);
        this.setDestino(destino);
        this.setTipo(tipo);
        this.setCurso(curso);
        this.setProfesor(profesor);
        this.setObservaciones(observaciones);
        this.dpto = dpto;
    }

    public Date getFechaComp() {
        return fechaComp;
    }

    public void setFechaComp(String fecha) throws ParseException {
        
        SimpleDateFormat formateo = new SimpleDateFormat("dd/MM/yyyy");
        formateo.setLenient(false);
        Date fechaUtil = formateo.parse(fecha);
        this.fechaComp = fechaUtil;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getDpto() {
        return dpto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getDestino() {
        return destino;
    }

    public String getTipo() {
        String cadena = "";

        for (int i = 0; i < tipo.length; i++) {

            cadena += tipo[i] + "-";

        }

        return cadena;
    }

    public String getCurso() {
        return curso;
    }

    public String getProfesor() {
        return profesor;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setTipo(String[] tipo) {
        this.tipo = tipo;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int compareTo(ActividadExtraescolar o) {
        return this.fechaComp.compareTo(o.getFechaComp());
    }

    @Override
    public String toString() {
        return "ActividadExtraescolar{" + "nombre=" + nombre + ", lugar=" + lugar + ", fecha=" + fecha + ", fechaComp=" + fechaComp + ", hora=" + hora + ", destino=" + destino + ", tipo=" + tipo + ", curso=" + curso + ", profesor=" + profesor + ", observaciones=" + observaciones + ", dpto=" + dpto + '}';
    }

}
