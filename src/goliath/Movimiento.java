/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goliath;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Enrique
 */
public class Movimiento {

    //Atributos
    private int cantidad;
    private Date fecha;
    private String concepto, remitente;
      
    //constructor
    public Movimiento(int cantidad,String remitente, String concepto, Date fecha) {
        this.cantidad = cantidad;
        this.concepto = concepto;
        this.fecha = fecha;
        this.remitente  = remitente;

    }

    public int getCantidad() {
        return cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public String getRemitente() {
        return remitente;
    }
    
    
    
    
}
