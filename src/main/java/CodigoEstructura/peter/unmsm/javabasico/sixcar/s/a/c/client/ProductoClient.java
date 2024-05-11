/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.client;

import java.util.Comparator;
import java.util.Scanner;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Producto;
import peter.unmsm.javabasico.sixcar.s.a.c.main.Main;
import peter.unmsm.javabasico.sixcar.s.a.c.service.*;
import peter.unmsm.javabasico.sixcar.s.a.c.service.orders.*;
import peter.unmsm.javabasico.sixcar.s.a.c.util.StringsUtil;

/**
 *
 * @author Timothy
 */
public class ProductoClient {

    static ProductoService productoService = new ProductoService();
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
                case 5 ->
                    continuar = mostrarSubMenuOrden();
                case 6 ->
                    eliminar();
                case 7 ->
                    salir();
                case 8 ->
                    salirMain();
                default ->
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

            if (continuar) {
                System.out.print("Ingrese (1) para regresar al menú principal \n(0) para salir del programa \n o cualquier otro numero para regresar al principal: ");
                int respuesta = lector.nextInt();
                if (respuesta == 0) {
                    salir();
                    break;
                } else if (respuesta == 1) {
                    salirMain();
                    break;
                }
            }
        }
    }

    public static void salirMain() {
        Main.main(new String[]{});
    }

    public static void mostrarMenu() {
        System.out.println("===========================================");
        System.out.println("Bienvenido al Mantenimiento de Artículos");
        System.out.println("===========================================");
        System.out.println("Operaciones Disponibles: ");
        System.out.println("1. Adicionar");
        System.out.println("2. Modificar");
        System.out.println("3. Consultar Todos");
        System.out.println("4. Consultar por Id");
        System.out.println("5. Consultar Todos por Orden");
        System.out.println("6. Eliminar");
        System.out.println("7. Salir");
        System.out.println("8. Regresar al principal");
        System.out.print("Ingrese la opción: ");
    }

    public static boolean mostrarSubMenuOrden() {
        System.out.println("5. Consultar Todos por Orden");
        System.out.println("   5.1. Ordenar por Id Producto Orden ('ascendente')");
        System.out.println("   5.2. Ordenar por Id Producto Orden ('descendente')");
        System.out.println("   5.3. Ordenar por Nombre ('alfabeticamente')");
        System.out.println("   5.4. Ordenar por tipo de producto ('alfabeticamente')");
        System.out.println("   5.5. Ordenar por precio de venta por menor ('ascendente')");
        System.out.println("   5.6. Ordenar por precio de venta por menor ('descendente')");
        System.out.println("   5.7. Ordenar por precio de venta por mayor ('ascendente')");
        System.out.println("   5.8. Ordenar por precio de venta por mayor ('descendente')");
        System.out.println("   5.9. Ordenar por precio de venta por instalado ('ascendente')");
        System.out.println("   5.10. Ordenar por precio de venta por instalado ('descendente')");
        System.out.println("   5.11. Ordenar por stock ('ascendente')");
        System.out.println("   5.12. Ordenar por stock ('descendente')");
        System.out.println("   5.13. Ordenar por Marca ('alfabeticamente')");
        System.out.println("   5.14. Regresar al menú anterior");
        System.out.print("Ingrese la subopción: ");

        int subopcion = lector.nextInt();
        lector.nextLine();  // Vacía el buffer

        switch (subopcion) {
            case 1 -> {
                consultarTodosPorCriterioOrden(new ProductoIdProductoAscendenteOrder());
                return true;
            }
            case 2 -> {
                consultarTodosPorCriterioOrden(new ProductoIdProductoDescendenteOrder());
                return true;
            }
            case 3 -> {
                consultarTodosPorCriterioOrden(new ProductoNombreOrder());
                return true;
            }
            case 4 -> {
                consultarTodosPorCriterioOrden(new ProductoTipoProductoOrder());
                return true;
            }
            case 5 -> {
                consultarTodosPorCriterioOrden(new ProductoPrecioVentaMenorAscendenteOrder());
                return true;
            }
            case 6 -> {
                consultarTodosPorCriterioOrden(new ProductoPrecioVentaMenorDescendenteOrder());
                return true;
            }
            case 7 -> {
                consultarTodosPorCriterioOrden(new ProductoPrecioVentaInstaladoAscendenteOrder());
                return true;
            }
            case 8 -> {
                consultarTodosPorCriterioOrden(new ProductoPrecioVentaInstaladoDescendenteOrder());
                return true;
            }
            case 9 -> {
                consultarTodosPorCriterioOrden(new ProductoPrecioVentaMayorAscendenteOrder());
                return true;
            }
            case 10 -> {
                consultarTodosPorCriterioOrden(new ProductoPrecioVentaMayorAscendenteOrder());
                return true;
            }
            case 11 -> {
                consultarTodosPorCriterioOrden(new ProductoStockAscendenteOrder());
                return true;
            }
            case 12 -> {
                consultarTodosPorCriterioOrden(new ProductoStockDescendenteOrder());
                return true;
            }
            case 13 -> {
                consultarTodosPorCriterioOrden(new ProductoMarcaOrder());
                return true;
            }
            case 14 -> {
                return false;
            }
            default -> {
                System.out.println("Subopción no válida. Intente nuevamente.");
                return true;
            }
        }

    }

    public static void adicionar() {
        Producto nuevoProducto = new Producto();

        System.out.println("\nAdición de Artículos");
        System.out.println("======================");

        System.out.print("Ingrese el tipo del producto: ");
        String tipoProducto = lector.nextLine();
        nuevoProducto.setTipoProducto(tipoProducto);

        System.out.print("Ingrese el codigo del producto: ");
        String codigo = lector.nextLine();
        nuevoProducto.setCodigo(codigo);

        System.out.print("Ingrese el nombre: ");
        String nombre = lector.nextLine();
        nuevoProducto.setNombre(nombre);

        System.out.println("¿El producto tiene tipo de boca(BA-BC)? SI(1) - NO(cualquier número): ");
        byte respuesta = lector.nextByte();
        lector.nextLine();
        if (respuesta == 1) {
            System.out.print("Ingrese el tipo de boca (BA o BC): ");
            String tipoBoca = lector.nextLine();
            nuevoProducto.setTipoBoca(tipoBoca);
        } else {
            nuevoProducto.setTipoBoca(null);

        }

        System.out.println("¿El producto tiene tipo de manguera(azul o negro)? SI(1) - NO(cualquier número): ");
        byte respuesta1 = lector.nextByte();
        lector.nextLine();
        if (respuesta1 == 1) {

            System.out.print("Ingrese el tipo de manguera (azul o negro): ");
            String tipoManguera = lector.nextLine();
            nuevoProducto.setTipoManguera(tipoManguera);
        } else {
            nuevoProducto.setTipoManguera(null);
        }

        System.out.println("¿El producto tiene tipo de radiador(AT - MT)? SI(1) - NO(cualquier número): ");
        byte respuesta2 = lector.nextByte();
        lector.nextLine();

        if (respuesta2 == 1) {

            System.out.print("Ingrese el tipo de radiador (AT o MT ): ");
            String tipoRadiador = lector.nextLine();
            nuevoProducto.setTipo(tipoRadiador);
        } else {
            nuevoProducto.setTipo(null);
        }

        System.out.println("¿El producto tiene presión de tapa(0,9 - 1,1)? SI(1) - NO(cualquier número): ");
        byte respuesta3 = lector.nextByte();
        lector.nextLine();

        if (respuesta3 == 1) {
        
        System.out.print("Ingrese la presión de la tapa (0,9 - 1,1): ");
        double tamaño = lector.nextDouble();
        lector.nextLine();
        nuevoProducto.setTamaño(tamaño);
        }else{
            nuevoProducto.setTamaño(0);
        }

        System.out.print("Ingrese el precio por menor: ");
        float precioMenor = lector.nextFloat();
        lector.nextLine();
        nuevoProducto.setPrecioMenor(precioMenor);

        System.out.print("Ingrese el precio instalado: ");
        float precioInstalado = lector.nextFloat();
        lector.nextLine();
        nuevoProducto.setPrecioInstalado(precioInstalado);

        System.out.print("Ingrese ingrese el precio mayor: ");
        float precioMayor = lector.nextFloat();
        lector.nextLine();
        nuevoProducto.setPrecioMayor(precioMayor);

        System.out.println("¿El producto tiene año de radiador? SI(1) - NO(cualquier número): ");
        byte respuesta4 = lector.nextByte();
        lector.nextLine();

        if (respuesta4 == 1) {
        
        System.out.print("Ingrese el año del radiador: ");
        String anio = lector.nextLine();
        nuevoProducto.setAnio(anio);
        }else{
            nuevoProducto.setAnio(null);
        }

        System.out.print("Ingrese ingrese el Stock: ");
        int stock = lector.nextInt();
        lector.nextLine();
        nuevoProducto.setStock(stock);

        System.out.print("Ingrese ingrese la marca: ");
        String marca = lector.nextLine();
        nuevoProducto.setMarca(marca);

        if (productoService.adicionar(nuevoProducto)) {
            System.out.println("Producto añadido con éxito.");
        } else {
            System.out.println("No se pudo añadir el artículo. Verifique los datos e intente nuevamente.");
        }
    }

    public static void modificar() {

        System.out.println("\nModificación de Artículos");
        System.out.println("===========================");

        System.out.print("Ingrese el codigo del producto: ");
        String idModificar = lector.nextLine();

        Producto producto = productoService.consultarPorId(idModificar);

        Producto productoModificado = new Producto();

        int idModificarint = producto.getIdProducto();
        productoModificado.setIdProducto(idModificarint);

        System.out.print("Ingrese el tipo del producto: ");
        String tipoProducto = lector.nextLine();
        productoModificado.setTipoProducto(tipoProducto);

        System.out.print("Ingrese el codigo del producto: ");
        String codigo = lector.nextLine();
        productoModificado.setCodigo(codigo);

        System.out.print("Ingrese el nombre: ");
        String nombre = lector.nextLine();
        productoModificado.setNombre(nombre);

        System.out.print("Ingrese el tipo de boca (BA o BC): ");
        String tipoBoca = lector.nextLine();
        productoModificado.setTipoBoca(tipoBoca);

        System.out.print("Ingrese el tipo de manguera (azul o negro): ");
        String tipoManguera = lector.nextLine();
        productoModificado.setTipoManguera(tipoManguera);

        System.out.print("Ingrese el tipo de radiador (AT o MT ): ");
        String tipoRadiador = lector.nextLine();
        productoModificado.setTipo(tipoRadiador);

        System.out.print("Ingrese la presión de la tapa (0.9 o 1.1): ");
        double tamaño = lector.nextDouble();
        lector.nextLine();
        productoModificado.setTamaño(tamaño);

        System.out.print("Ingrese el precio por menor: ");
        float precioMenor = lector.nextFloat();
        lector.nextLine();
        productoModificado.setPrecioMenor(precioMenor);

        System.out.print("Ingrese el precio instalado: ");
        float precioInstalado = lector.nextFloat();
        lector.nextLine();
        productoModificado.setPrecioInstalado(precioInstalado);

        System.out.print("Ingrese ingrese el precio mayor: ");
        float precioMayor = lector.nextFloat();
        lector.nextLine();
        productoModificado.setPrecioMayor(precioMayor);

        System.out.print("Ingrese el año del radiador: ");
        String anio = lector.nextLine();
        productoModificado.setAnio(anio);

        System.out.print("Ingrese ingrese el Stock: ");
        int stock = lector.nextInt();
        lector.nextLine();
        productoModificado.setStock(stock);

        System.out.print("Ingrese ingrese la marca: ");
        String marca = lector.nextLine();
        productoModificado.setMarca(marca);

        if (productoService.modificar(idModificar, productoModificado)) {
            System.out.println("Producto modificado con éxito.");
        } else {
            System.out.println("No se pudo modificar el artículo. Verifique los datos e intente nuevamente.");
        }
    }

    public static void consultarTodos() {

        System.out.println("\nConsulta Total de Artículos");
        System.out.println("=============================");

        Producto[] productos = productoService.consultar();

        System.out.printf("%-20s   %-20s   %-50s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s\n", "Id Producto", "Codigo", "Nombre", "Tipo Producto", "Tipo Boca", "Tipo Manguera", "Tipo Radiador", "Tamaño Tapa", "Precio Menor", "Precio Instalado", "Precio Mayor", "Año", "Stock", "Marca");

        for (Producto producto : productos) {
            String idConRelleno = String.format("%08d", producto.getIdProducto());  // Relleno de ceros
            System.out.printf("%-20s   %-20s   %-50s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s\n",
                    idConRelleno,
                    StringsUtil.truncateString(producto.getCodigo(), 20),
                    StringsUtil.truncateString(producto.getNombre(), 40),
                    StringsUtil.truncateString(producto.getTipoProducto(), 25),
                    producto.getTipoBoca(),
                    producto.getTipoManguera(),
                    producto.getTipo(),
                    producto.getTamaño(),
                    producto.getPrecioMenor(),
                    producto.getPrecioInstalado(),
                    producto.getPrecioMayor(),
                    producto.getAnio(),
                    producto.getStock(),
                    StringsUtil.truncateString(producto.getMarca(), 25));
        }

    }

    private static void consultarPorId() {

        System.out.println("\nConsulta de Artículo por Id");
        System.out.println("===============================");

        System.out.print("Ingrese el identificador del artículo a consultar: ");
        String idConsultar = lector.nextLine();

        Producto producto = productoService.consultarPorId(idConsultar);
        if (producto != null) {
            String idConRelleno = String.format("%08d", producto.getIdProducto());  // Relleno de ceros
            System.out.printf("%-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s\n", "Id Producto", "Codigo", "Nombre", "Tipo Producto", "Tipo Boca", "Tipo Manguera", "Tipo Radiador", "Tamaño Tapa", "Precio Menor", "Precio Instalado", "Precio Mayor", "Año", "Stock", "Marca");
            System.out.printf("%-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s\n",
                    idConRelleno,
                    StringsUtil.truncateString(producto.getCodigo(), 20),
                    StringsUtil.truncateString(producto.getNombre(), 40),
                    StringsUtil.truncateString(producto.getTipoProducto(), 25),
                    StringsUtil.truncateString(producto.getTipoBoca(), 10),
                    StringsUtil.truncateString(producto.getTipoManguera(), 15),
                    StringsUtil.truncateString(producto.getTipo(), 10),
                    producto.getTamaño(),
                    producto.getPrecioMenor(),
                    producto.getPrecioInstalado(),
                    producto.getPrecioMayor(),
                    StringsUtil.truncateString(producto.getAnio(), 20),
                    producto.getStock(),
                    StringsUtil.truncateString(producto.getMarca(), 25));
        } else {
            System.out.println("No se encontró el artículo con el ID especificado.");
        }
    }

    private static void eliminar() {

        System.out.println("\nEliminación de Artículo por Id");
        System.out.println("===============================");

        System.out.print("Ingrese el codigo del artículo a eliminar: ");
        String idEliminar = lector.nextLine();

        if (productoService.eliminar(idEliminar)) {
            System.out.println("Producto eliminado con éxito.");
        } else {
            System.out.println("No se pudo eliminar el artículo. Verifique el codigo e intente nuevamente.");
        }
    }

    public static void salir() {
        System.exit(0);
    }

    private static void consultarTodosPorCriterioOrden(Comparator<Producto> comparador) {
        System.out.println("\nConsulta Total de Artículos por Criterio de Orden");
        System.out.println("==================================================");

        //crear arreglo con los productos en orden
        Producto[] productos = productoService.consultaPorCriterioOrden(comparador);

        //imprimir productos
        System.out.printf("%-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s  %-20s\n", "Id Producto", "Codigo", "Nombre", "Tipo Producto", "Tipo Boca", "Tipo Manguera", "Tipo Radiador", "Tamaño Tapa", "Precio Menor", "Precio Instalado", "Precio Mayor", "Año", "Stock", "Marca");

        for (Producto producto : productos) {
            String idConRelleno = String.format("%08d", producto.getIdProducto());   // Relleno de ceros
            System.out.printf("%-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s   %-20s\n",
                    idConRelleno,
                    StringsUtil.truncateString(producto.getCodigo(), 20),
                    StringsUtil.truncateString(producto.getNombre(), 20),
                    StringsUtil.truncateString(producto.getTipoProducto(), 20),
                    StringsUtil.truncateString(producto.getTipoBoca(), 20),
                    StringsUtil.truncateString(producto.getTipoManguera(), 20),
                    StringsUtil.truncateString(producto.getTipo(), 20),
                    producto.getTamaño(),
                    producto.getPrecioMenor(),
                    producto.getPrecioInstalado(),
                    producto.getPrecioMayor(),
                    StringsUtil.truncateString(producto.getAnio(), 20),
                    producto.getStock(),
                    StringsUtil.truncateString(producto.getMarca(), 20));
        }

    }
}
