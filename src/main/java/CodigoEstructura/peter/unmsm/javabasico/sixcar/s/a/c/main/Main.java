/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.main;

import java.util.Scanner;
import peter.unmsm.javabasico.sixcar.s.a.c.client.ComprobanteClient;
import peter.unmsm.javabasico.sixcar.s.a.c.client.LocalClient;
import peter.unmsm.javabasico.sixcar.s.a.c.client.ProductoClient;

/**
 *
 * @author JESSY
 */
public class Main {

    static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            mostrarMenu();
            int opcion = lector.nextInt();
            lector.nextLine();  // Vacía el buffer

            switch (opcion) {
                case 1 ->
                    ComprobanteClient.main(new String[]{});
                case 2 ->
                    LocalClient.main(new String[]{});
                case 3 ->
                    ProductoClient.main(new String[]{});
                case 4 ->
                    salir();
                default ->
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        }

    }

    public static void salir() {
        System.exit(0);
    }

    public static void mostrarMenu() {
        System.out.println("===========================================");
        System.out.println("Bienvenido al sistema SIXCAR");
        System.out.println("===========================================");
        System.out.println("Operaciones Disponibles: ");
        System.out.println("1. Trabajar con Comprobantes");
        System.out.println("2. Trabajar con Local");
        System.out.println("3. Trabajar con Productos");
        System.out.println("4. Salir del sistema");
        System.out.print("Ingrese la opción: ");
    }

}
