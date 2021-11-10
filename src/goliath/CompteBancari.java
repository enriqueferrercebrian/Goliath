/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goliath;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Enrique
 */
public class CompteBancari {

    Scanner sc = new Scanner(System.in);
    private String iban, nomTitular;
    private int saldo;
    private List <Movimiento> historicoMovimientos;

    //contructor 
    public CompteBancari(String iban, String nomTitular) {
        this.iban = iban;
        this.nomTitular = nomTitular;
        saldo = 0;
        historicoMovimientos = new ArrayList<>();
    }

    public String getIban() {
        return iban;
    }

    public String getNomTitular() {
        return nomTitular;
    }

    public int getSaldo() {
        return saldo;
    }

    public List<Movimiento> getHistoricoMovimientos() {
        return historicoMovimientos;
    }

    public void ingreso(Movimiento nuevoMovimiento) {
        int cantidad = nuevoMovimiento.getCantidad();
        saldo = saldo + cantidad;
        if (cantidad >= 3000) {
            System.out.println("Avis, notificacion a hacienda");
        }
        historicoMovimientos.add(nuevoMovimiento);

    }

}
