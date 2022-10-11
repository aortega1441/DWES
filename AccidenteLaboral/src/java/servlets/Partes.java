/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlets;

import excepciones.campoIncorrectoException;
import excepciones.cccException;
import excepciones.cifException;
import excepciones.fechaException;
import excepciones.numeroSSException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author vecto
 */
public class Partes implements Comparable<Partes>{

    private String apellido1;
    private String apellido2;
    private String nombre;
    private String nss;
    private LocalDate fIngreso;
    private LocalDate fNacimiento;
    private String cif;
    private String nombreEmpresa;
    private String ccc;
    private String descripcion;

    public Partes(String apellido1, String apellido2, String nombre, String nss, String fIngreso, String fNacimiento, String cif, String nombreEmpresa, String ccc, String descripcion) throws cifException, numeroSSException, cccException, fechaException, campoIncorrectoException {
        this.setApellido1(apellido1);
        this.setApellido2(apellido2);
        this.setNombre(nombre);
        this.setNss(nss);
        this.setfIngreso(LocalDate.parse(fIngreso));
        this.setfNacimiento(LocalDate.parse(fNacimiento));

        Date fechaNacimiento = java.sql.Date.valueOf(fNacimiento);
        Date fechaIngreso1 = java.sql.Date.valueOf(fIngreso);

        Calendar fechaNacimiento18 = Calendar.getInstance();
        fechaNacimiento18.setTime(fechaNacimiento);
        fechaNacimiento18.add(Calendar.YEAR, 18);
        Calendar fechaIngreso = Calendar.getInstance();
        fechaIngreso.setTime(fechaIngreso1);

        if ((fechaNacimiento18.get(Calendar.YEAR) > fechaIngreso.get(Calendar.YEAR)) || (fechaIngreso1.before(fechaNacimiento))) {
            throw new fechaException();
        }

        this.setCif(cif);
        this.setNombreEmpresa(nombreEmpresa);
        this.setCcc(ccc);
        this.setDescripcion(descripcion);
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNss() {
        return nss;
    }

    public LocalDate getfIngreso() {
        return fIngreso;
    }

    public LocalDate getfNacimiento() {
        return fNacimiento;
    }

    public String getCif() {
        return cif;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getCcc() {
        return ccc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setApellido1(String apellido1) throws campoIncorrectoException {

        apellido1 = apellido1.replaceAll(" ", "");

        for (int x = 0; x < apellido1.length(); x++) {

            if (Character.isDigit(apellido1.charAt(x))) {
                throw new campoIncorrectoException();
            }

        }

        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) throws campoIncorrectoException {

        apellido2 = apellido2.replaceAll(" ", "");

        for (int x = 0; x < apellido2.length(); x++) {

            if (Character.isDigit(apellido2.charAt(x))) {
                throw new campoIncorrectoException();
            }

        }

        this.apellido2 = apellido2;
    }

    public void setNombre(String nombre) throws campoIncorrectoException {

        nombre = nombre.replaceAll(" ", "");

        for (int x = 0; x < nombre.length(); x++) {

            if (Character.isDigit(nombre.charAt(x))) {
                throw new campoIncorrectoException();
            }

        }

        this.nombre = nombre;
    }

    public void setNss(String nss) throws numeroSSException {

        nss = nss.replaceAll(" ", "");

        int tam = nss.length();

        if (tam == 12) {
            int numeroProvincia = Integer.parseInt(nss.substring(0, 2));
            int numeroSecuencial = Integer.parseInt(nss.substring(2, 10));
            String digitoControl = nss.substring(10, 12);

            long numeroUnion = Long.parseLong(nss.substring(0, 10));

            long resto = numeroUnion % 97;
            String restoCadena = String.valueOf(resto);

            if (resto < 10) {
                restoCadena = "0" + restoCadena;
                if (restoCadena.equals(digitoControl)) {
                    this.nss = nss;
                } else {
                    throw new numeroSSException();
                }
            } else {
                if (restoCadena.equals(digitoControl)) {
                    this.nss = nss;
                } else {
                    throw new numeroSSException();
                }
            }
        } else {
            throw new numeroSSException();
        }

        this.nss = nss;
    }

    public void setfIngreso(LocalDate fIngreso) {
        this.fIngreso = fIngreso;
    }

    public void setfNacimiento(LocalDate fNacimiento) {
        this.fIngreso = fNacimiento;
    }

    public void setCif(String cif) throws cifException {

        String numeroCif = cif.toUpperCase();

        String[] tipoOrganizacion = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "U", "V", "W"};
        String[] codigoProvincia = {"01", "02", "03", "53", "54", "04", "05", "06", "07", "57", "08", "58", "59", "60", "61", "62", "63", "64", "09",
            "10", "11", "72", "12", "13", "14", "56", "15", "70", "16", "17", "55", "18", "19", "20", "71", "21", "22", "23",
            "24", "25", "26", "27", "28", "78", "79", "80", "81", "82", "83", "84", "85", "29", "92", "93", "30", "73", "31",
            "32", "33", "74", "34", "35", "76", "36", "94", "37", "38", "75", "39", "40", "41", "91", "42", "43", "77", "44",
            "45", "46", "96", "97", "98", "47", "48", "95", "49", "50", "99", "51", "52"};

        String organizacion = String.valueOf(numeroCif.charAt(0));

        int tam = numeroCif.length();

        try {
            if (tam == 9) {

                String provincia = numeroCif.substring(1, 3);
                char letraControl = numeroCif.charAt(8);

                if (Arrays.asList(tipoOrganizacion).contains(organizacion)) {
                    if (Arrays.asList(codigoProvincia).contains(provincia)) {
                        if (organizacion.equals("K") || organizacion.equals("P") || organizacion.equals("Q") || organizacion.equals("S")) {
                            if (!Character.isLetter(letraControl)) {
                                throw new cifException();
                            }
                        } else if (organizacion.equals("A") || organizacion.equals("B") || organizacion.equals("E") || organizacion.equals("H")) {
                            if (!Character.isDigit(letraControl)) {
                                throw new cifException();
                            }
                        }
                    } else {
                        throw new cifException();
                    }
                } else {
                    throw new cifException();
                }
            } else {
                throw new cifException();
            }

        } catch (cifException e) {
            throw new cifException();
        }

        this.cif = numeroCif;

    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setCcc(String ccc) throws cccException {

        boolean digitos = true;

        for (int x = 0; x < ccc.length(); x++) {
            if (!Character.isDigit(ccc.charAt(x))) {
                digitos = false;
                break;
            }
        }

        if (digitos) {
            this.ccc = ccc;
        } else {
            throw new cccException();
        }

    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Partes{" + "apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", nombre=" + nombre + ", nss=" + nss + ", fIngreso=" + fIngreso + ", fNacimiento=" + fNacimiento + ", cif=" + cif + ", nombreEmpresa=" + nombreEmpresa + ", ccc=" + ccc + ", descripcion=" + descripcion + '}';
    }
    
    @Override
    public int compareTo(Partes o){
        
        return this.apellido1.compareTo(o.getApellido1());
        
    }

}
