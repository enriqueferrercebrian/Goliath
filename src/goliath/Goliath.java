/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goliath;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
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
        String iban = "", nomTitular, remitente = "", concepto = "", stringConcepto = "Concepto: ", stringRemitente = "Remitente: ", tipoMovimiento, cantidadRetirada = "Cantidad retirada: ", cantidadIngresada = "Cantidad ingresada: ";
        int cantidad = 0;
        boolean ibancorrecto = false;
        Date fecha;

        Scanner sc = new Scanner(System.in);
        int respuestaUsuario = 0;
        while (ibancorrecto == false) {
            System.out.println("Indiqueme su IBAN (ES+22 dígitos) ");

            iban = sc.nextLine();
            iban = iban.toUpperCase();
            if (iban.length() == 24 && iban.substring(0, 2).equalsIgnoreCase("ES")) {
                ibancorrecto = true;
            } else {
                System.out.println("Formato de IBAN no sorportado.");
            }
        }

        System.out.println(
                "Introduce el nombre del titular");
        nomTitular = sc.nextLine();

        System.out.println(
                "Bienvenido/a a GNB");
        System.out.println(
                "It's gonna be legen...dary!");
        boolean seguir = true;

        //revisar iban que este correcto
        CompteBancari nuevaCuenta = new CompteBancari(iban, nomTitular);

        //Movimiento nuevoIngreso = new Movimiento("ingreso" ,100, "asdf", "sdf", Calendar.getInstance().getTime());
        // nuevaCuenta.ingreso(nuevoIngreso);
        while (seguir
                == true) {
            System.out.println("");
            System.out.println("Selecciona una opción.");

            System.out.println("1. Muestrane mis datos bancarios.");
            System.out.println("2. Muestrame mi IBAN.");
            System.out.println("3. Muestrame el titular de la cuenta.");
            System.out.println("4. Muestrane el saldo de la cuenta.");
            System.out.println("5. Hacer un ingreso.");
            System.out.println("6. Hacer una retirada.");
            System.out.println("7. Muestrame todos los movimientos.");
            System.out.println("8. Salir.");
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
                    System.out.println("Cantidad ingresada (sin decimales): ");
                    cantidad = Integer.parseInt(sc.nextLine());

                    System.out.println("Remitente: ");
                    remitente = sc.nextLine();

                    System.out.println("Concepto: ");
                    concepto = sc.nextLine();

                    fecha = Calendar.getInstance().getTime();
                    tipoMovimiento = "Ingreso ";

                    Movimiento nuevoIngreso2 = new Movimiento(tipoMovimiento, cantidad, remitente, concepto, fecha);

                    nuevaCuenta.ingreso(nuevoIngreso2);
                    System.out.println("*Ingreso realizado con éxito*");
                    System.out.println("");

                    System.out.println("Saldo: " + nuevaCuenta.getSaldo());
                    System.out.println("");

                    break;

                case 6:

                    System.out.println("Cantidad retirada (sin decimales): ");
                    cantidad = Integer.parseInt(sc.nextLine());

                    System.out.println("Remitente: ");
                    remitente = sc.nextLine();

                    System.out.println("Concepto: ");
                    concepto = sc.nextLine();

                    fecha = Calendar.getInstance().getTime();
                    tipoMovimiento = "Retirada";

                    Movimiento nuevaRetirada = new Movimiento(tipoMovimiento, cantidad, remitente, concepto, fecha);

                    nuevaCuenta.retirada(nuevaRetirada);
                    System.out.println("*Retirada realizada con éxito*");
                    System.out.println("");

                    System.out.println("Saldo: " + nuevaCuenta.getSaldo());
                    System.out.println("");

                    break;

                case 7:
                    System.out.println("                             Historico de movimientos");
                    List<Movimiento> lista = nuevaCuenta.getHistoricoMovimientos();
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.println(lista.get(i).getTipoMovimiento() + " | " + cantidadRetirada + lista.get(i).getCantidad() + " | " + stringRemitente + lista.get(i).getRemitente() + " | " + stringConcepto + lista.get(i).getConcepto() + " ---> " + lista.get(i).getFecha() + " "
                        );
                    }
                    break;

                case 8:
                    seguir = false;
            }

        }
    }
}
