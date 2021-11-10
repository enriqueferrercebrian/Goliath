/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goliath;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Enrique
 */
public class Goliath {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String iban, nomTitular, remitente, concepto;
        int cantidad;

        Date fecha;

        Scanner sc = new Scanner(System.in);
        int respuestaUsuario = 0;
        System.out.println("dime iban");
        iban = sc.nextLine();
        System.out.println("dime nombre");
        nomTitular = sc.nextLine();

        //revisar iban que este correcto
        CompteBancari nuevaCuenta = new CompteBancari(iban, nomTitular);

        System.out.println("Que quieres hacer?");
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        respuestaUsuario = Integer.parseInt(sc.nextLine());

        switch (respuestaUsuario) {

            case 1:

                System.out.println(nuevaCuenta.getIban() + " "
                        + nuevaCuenta.getNomTitular() + " "
                        + " " + nuevaCuenta.getSaldo());

            case 2:

                System.out.println(nuevaCuenta.getIban());

            case 3:

                System.out.println(nuevaCuenta.getNomTitular());

            case 4:

                System.out.println(nuevaCuenta.getSaldo());

            case 5:
                System.out.println("Cuanto?");
                cantidad = Integer.parseInt(sc.nextLine());
                
                System.out.println("quien?");
                remitente = sc.nextLine();
                
                System.out.println("Concepto?");
                concepto = sc.nextLine();
                
                fecha = Calendar.getInstance().getTime();

                Movimiento nuevoMovimiento = new Movimiento(cantidad, remitente, concepto, fecha);
                
                nuevaCuenta.ingreso(cantidad);
                
               nuevaCuenta.getHistoricoMovimientos()
                
            case 6:

            case 7:

            case 8:

        }

    }

}
