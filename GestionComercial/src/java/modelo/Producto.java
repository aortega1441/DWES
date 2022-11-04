/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author vecto
 */
public class Producto {

    private String fecha;
    private String comercial;
    private String cantidad;
    private String precio;
    private String total;
    private String descuento;
    private String totalConDescuento;
    

    public Producto(String fecha, String comercial, String cantidad, String precio, String total, String descuento, String totalConDescuento) {
        this.fecha = fecha;
        this.comercial = comercial;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.descuento = descuento;
        this.setTotalConDescuento(totalConDescuento);
    }
    
    public Producto(){
        
    }

    public String getFecha() {
        return fecha;
    }

    public String getComercial() {
        return comercial;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public String getTotal() {

        double cantidad = Double.parseDouble(getCantidad());
        double precio = Double.parseDouble(getPrecio());
        double resultado = cantidad * precio;
        resultado = Math.round(resultado * 100.0) / 100.0;

        return Double.toString(resultado);
    }

    public String getDescuento() {
        return descuento;
    }

    public String getTotalConDescuento() {

        double cant = Double.parseDouble(getTotal());
        double desc = Double.parseDouble(getDescuento());
        double tot = (desc / 100) * cant;
        tot = Math.round(tot * 100.0) / 100.0;

        return Double.toString(tot);
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setComercial(String comercial) {
        this.comercial = comercial;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setTotal(String total) {

        this.total = total;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public void setTotalConDescuento(String totalConDescuento) {

        this.totalConDescuento = totalConDescuento;
    }

    @Override
    public String toString() {
        return "Producto{" + "fecha=" + fecha + ", comercial=" + comercial + ", cantidad=" + cantidad + ", precio=" + precio + ", total=" + total + ", descuento=" + descuento + ", totalConDescuento=" + totalConDescuento + '}';
    }

}
