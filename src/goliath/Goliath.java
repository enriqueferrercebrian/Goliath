/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goliath;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

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
        boolean seguir = true;

        //revisar iban que este correcto
        CompteBancari nuevaCuenta = new CompteBancari(iban, nomTitular);
        while (seguir == true) {
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
                    break;

                case 2:

                    System.out.println(nuevaCuenta.getIban());
                    break;

                case 3:

                    System.out.println(nuevaCuenta.getNomTitular());
                    break;

                case 4:

                    System.out.println(nuevaCuenta.getSaldo());
                    break;

                case 5:
                    System.out.println("Cuanto?");
                    cantidad = Integer.parseInt(sc.nextLine());

                    System.out.println("quien?");
                    remitente = sc.nextLine();

                    System.out.println("Concepto?");
                    concepto = sc.nextLine();

                    fecha = Calendar.getInstance().getTime();

                    Movimiento nuevoIngreso = new Movimiento(cantidad, remitente, concepto, fecha);

                    nuevaCuenta.ingreso(nuevoIngreso);

                    break;

                case 6:

                    System.out.println("Cuanto?");
                    cantidad = Integer.parseInt(sc.nextLine());

                    System.out.println("quien?");
                    remitente = sc.nextLine();

                    System.out.println("Concepto?");
                    concepto = sc.nextLine();

                    fecha = Calendar.getInstance().getTime();

                    Movimiento nuevaRetirada = new Movimiento(cantidad, remitente, concepto, fecha);

                    nuevaCuenta.retirada(nuevaRetirada);

                    break;

                case 7:
                    
                    List<Movimiento> lista = nuevaCuenta.getHistoricoMovimientos();
                    
                    
                        System.out.println(lista.toString());

                    
                case 8:
                    seguir = false;
            }

        }
    }
}
