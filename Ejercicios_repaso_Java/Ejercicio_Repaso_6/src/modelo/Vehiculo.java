/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author vecto
 */
public class Vehiculo {

    private String modelo;
    private double potencia;
    private boolean cRuedas;

    public Vehiculo(String modelo) {
        this.modelo = modelo;
    }

    public Vehiculo() {

    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public void setcRuedas(boolean cRuedas) {
        this.cRuedas = cRuedas;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPotencia() {
        return potencia;
    }

    public boolean iscRuedas() {
        return cRuedas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "modelo=" + modelo + ", potencia=" + potencia + ", cRuedas=" + cRuedas + '}';
    }

}
