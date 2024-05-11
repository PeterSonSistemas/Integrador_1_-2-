/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.client;

import java.util.Comparator;
import java.util.Scanner;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Local;
import peter.unmsm.javabasico.sixcar.s.a.c.main.Main;
import peter.unmsm.javabasico.sixcar.s.a.c.service.*;
import peter.unmsm.javabasico.sixcar.s.a.c.util.StringsUtil;

/**
 *
 * @author Timothy
 */
public class LocalClient {

    static LocalService localService = new LocalService();
    static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            mostrarMenu();
            boolean continuar = true;
            int opcion = lector.nextInt();
            lector.nextLine();  // Vacía el buffer

            switch (opcion) {
                case 1 ->
                    adicionar();
                case 2 ->
                    modificar();
                case 3 ->
                    consultarTodos();
                case 4 ->
                    consultarPorId();
//                case 5 ->
//                    continuar = mostrarSubMenuOrden();
                case 5 ->
                    eliminar();
                case 6 ->
                    salir();
                case 7 ->
                    salirMain();
                default ->
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

            if (continuar) {
                System.out.print("Ingrese (1) para regresar al menú principal \n(0) para salir del programa \n o cualquier otro numero para seguir trabajando con los locales: ");
                int respuesta = lector.nextInt();
                if (respuesta == 0) {
                    salir();
                    break;
                }else if(respuesta == 1){
                    salirMain();
                    break;
                }
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("===========================================");
        System.out.println("Bienvenido al Mantenimiento de los Locales");
        System.out.println("===========================================");
        System.out.println("Operaciones Disponibles: ");
        System.out.println("1. Adicionar");
        System.out.println("2. Modificar");
        System.out.println("3. Consultar Todos");
        System.out.println("4. Consultar por Id");
        System.out.println("5. Eliminar");
        System.out.println("6. Salir");
        System.out.println("7. Regresar al principal");
        System.out.print("Ingrese la opción: ");
    }

    //ordenar por orden
    {
//    public static boolean mostrarSubMenuOrden() {
//        System.out.println("5. Consultar Todos por Orden");
//        System.out.println("   5.1. Ordenar por Id Local Orden ('ascendente')");
//        System.out.println("   5.2. Ordenar por Id Local Orden ('descendente')");
//        System.out.println("   5.3. Ordenar por Nombre ('alfabeticamente')");
//        System.out.println("   5.4. Ordenar por tipo de local ('alfabeticamente')");
//        System.out.println("   5.5. Ordenar por precio de venta por menor ('ascendente')");
//        System.out.println("   5.6. Ordenar por precio de venta por menor ('descendente')");
//        System.out.println("   5.7. Ordenar por precio de venta por mayor ('ascendente')");
//        System.out.println("   5.8. Ordenar por precio de venta por mayor ('descendente')");
//        System.out.println("   5.9. Ordenar por precio de venta por instalado ('ascendente')");
//        System.out.println("   5.10. Ordenar por precio de venta por instalado ('descendente')");
//        System.out.println("   5.11. Ordenar por stock ('ascendente')");
//        System.out.println("   5.12. Ordenar por stock ('descendente')");
//        System.out.println("   5.13. Ordenar por Marca ('alfabeticamente')");
//        System.out.println("   5.14. Regresar al menú anterior");
//        System.out.print("Ingrese la subopción: ");
//
//        int subopcion = lector.nextInt();
//        lector.nextLine();  // Vacía el buffer
//
//        switch (subopcion) {
//            case 1 -> {
//                consultarTodosPorCriterioOrden(new LocalIdLocalAscendenteOrder());
//                return true;
//            }
//            case 2 -> {
//                consultarTodosPorCriterioOrden(new LocalIdLocalDescendenteOrder());
//                return true;
//            }
//            case 3 -> {
//                consultarTodosPorCriterioOrden(new LocalNombreOrder());
//                return true;
//            }
//            case 4 -> {
//                consultarTodosPorCriterioOrden(new LocalTipoLocalOrder());
//                return true;
//            }
//            case 5 -> {
//                consultarTodosPorCriterioOrden(new LocalPrecioVentaMenorAscendenteOrder());
//                return true;
//            }
//            case 6 -> {
//                consultarTodosPorCriterioOrden(new LocalPrecioVentaMenorDescendenteOrder());
//                return true;
//            }
//            case 7 -> {
//                consultarTodosPorCriterioOrden(new LocalPrecioVentaInstaladoAscendenteOrder());
//                return true;
//            }
//            case 8 -> {
//                consultarTodosPorCriterioOrden(new LocalPrecioVentaInstaladoDescendenteOrder());
//                return true;
//            }
//            case 9 -> {
//                consultarTodosPorCriterioOrden(new LocalPrecioVentaMayorAscendenteOrder());
//                return true;
//            }
//            case 10 -> {
//                consultarTodosPorCriterioOrden(new LocalPrecioVentaMayorAscendenteOrder());
//                return true;
//            }
//            case 11 -> {
//                consultarTodosPorCriterioOrden(new LocalStockAscendenteOrder());
//                return true;
//            }
//            case 12 -> {
//                consultarTodosPorCriterioOrden(new LocalStockDescendenteOrder());
//                return true;
//            }
//            case 13 -> {
//                consultarTodosPorCriterioOrden(new LocalMarcaOrder());
//                return true;
//            }
//            case 14 -> {
//                return false;
//            }
//            default -> {
//                System.out.println("Subopción no válida. Intente nuevamente.");
//                return true;
//            }
//        }
//
//    }
}
    //=======================
    
    public static void adicionar() {
        Local nuevoLocal = new Local();

        System.out.println("\nAdición de Local Nuevo");
        System.out.println("======================");

        System.out.print("Ingrese la dirección del local: ");
        String direccion = lector.nextLine();
        nuevoLocal.setDireccion(direccion);

        System.out.print("Ingrese el nombre del local: ");
        String nombre = lector.nextLine();
        nuevoLocal.setNombre(nombre);

        System.out.print("Ingrese el numero de contacto del local: ");
        int numero = lector.nextInt();
        lector.nextLine();
        nuevoLocal.setNumero(numero);

        if (localService.adicionar(nuevoLocal)) {
            System.out.println("Local añadido con éxito.");
        } else {
            System.out.println("No se pudo añadir el Local. Verifique los datos e intente nuevamente.");
        }
    }

    public static void modificar() {

        System.out.println("\nModificación del Local");
        System.out.println("===========================");

        System.out.print("Ingrese el Id del local: ");
        int idModificar = lector.nextInt();
        lector.nextLine();
        
        Local local = localService.consultarPorId(idModificar);
        
        Local localModificado = new Local();
        
//        int idModificarint = local.getIdLocal();
//        localModificado.setIdLocal(idModificarint);
        
        System.out.print("Ingrese la dirección del local: ");
        String direccion = lector.nextLine();
        localModificado.setDireccion(direccion);

        System.out.print("Ingrese el nombre del local: ");
        String nombre = lector.nextLine();
        localModificado.setNombre(nombre);

        System.out.print("Ingrese el numero de contacto del local: ");
        int numero = lector.nextInt();
        localModificado.setNumero(numero);

        if (localService.modificar(idModificar, localModificado)) {
            System.out.println("Local modificado con éxito.");
        } else {
            System.out.println("No se pudo modificar el Local. Verifique los datos e intente nuevamente.");
        }
    }

    public static void consultarTodos() {

        System.out.println("\nConsulta Total de Locales");
        System.out.println("=============================");

        Local[] locals = localService.consultar();

        System.out.printf("%-20s   %-20s   %-20s   %-50s\n", "Id Local", "Nombre", "Número de contacto", "Dirección");

        for (Local local : locals) {
            String idConRelleno = String.format("%08d", local.getIdLocal());  // Relleno de ceros
            System.out.printf("%-20s   %-20s   %-20s   %-50s\n",
                    idConRelleno,
                    StringsUtil.truncateString(local.getNombre(), 20),
                    local.getNumero(),
                    StringsUtil.truncateString(local.getDireccion(), 50));
        }
        
    }

    private static void consultarPorId() {

        System.out.println("\nConsulta de Local por Id");
        System.out.println("===============================");

        System.out.print("Ingrese el identificador del local a consultar: ");
        int idConsultar = lector.nextInt();
        lector.nextLine();

        Local local = localService.consultarPorId(idConsultar);
        if (local != null) {
            String idConRelleno = String.format("%08d", local.getIdLocal());  // Relleno de ceros
            System.out.printf("%-20s   %-20s   %-20s   %-50s\n", "Id Local", "Nombre", "Número de contacto", "Dirección");
            System.out.printf("%-20s   %-20s   %-20s   %-50s\n", 
                    idConRelleno,
                    StringsUtil.truncateString(local.getNombre(), 20),
                    local.getNumero(),
                    StringsUtil.truncateString(local.getDireccion(), 50));
        } else {
            System.out.println("No se encontró el local con el ID especificado.");
        }
    }

    private static void eliminar() {

        System.out.println("\nEliminación de local por Id");
        System.out.println("===============================");

        System.out.print("Ingrese el codigo del local a eliminar: ");
        int idEliminar = lector.nextInt();
        lector.nextLine();

        
        
        if (localService.eliminar(idEliminar)) {
            System.out.println("Local eliminado con éxito.");
        } else {
            System.out.println("No se pudo eliminar el local. Verifique el codigo e intente nuevamente.");
        }
    }

    public static void salir() {
        System.exit(0);
    }
    
    public static void salirMain() {
        Main.main(new String[]{});
    }
    
    //consultarTodosPorCriterioOrden
    {
//    private static void consultarTodosPorCriterioOrden(Comparator<Local> comparador) {
//        System.out.println("\nConsulta Total de Artículos por Criterio de Orden");
//        System.out.println("==================================================");
//
//        //crear arreglo con los locals en orden
//        Local[] locals = localService.consultaPorCriterioOrden(comparador);
//        
//        //imprimir locals
//            System.out.printf("%-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s  %-20s\n","Id Local" ,"Codigo", "Nombre", "Tipo Local", "Tipo Boca", "Tipo Manguera", "Tipo Radiador", "Tamaño Tapa", "Precio Menor", "Precio Instalado", "Precio Mayor", "Año", "Stock", "Marca");
//        for (Local local : locals) {
//            String idConRelleno = String.format("%08d", local.getIdLocal());   // Relleno de ceros
//            System.out.printf("%-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s\n", 
//                    idConRelleno, 
//                    StringsUtil.truncateString(local.getCodigo(), 20),
//                    StringsUtil.truncateString(local.getNombre(), 20),
//                    StringsUtil.truncateString(local.getTipoLocal(), 20),
//                    StringsUtil.truncateString(local.getTipoBoca(), 20),
//                    StringsUtil.truncateString(local.getTipoManguera(), 20),
//                    StringsUtil.truncateString(local.getTipo(), 20),
//                    local.getTamaño(),
//                    local.getPrecioMenor(),
//                    local.getPrecioInstalado(),
//                    local.getPrecioMayor(), 
//                    StringsUtil.truncateString(local.getAnio(), 20),
//                    local.getStock(),
//                    StringsUtil.truncateString(local.getMarca(), 20));
//        }
//
//    }
    }
    //=============================
}
