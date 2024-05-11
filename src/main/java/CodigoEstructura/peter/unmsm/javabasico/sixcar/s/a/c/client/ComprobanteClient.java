/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peter.unmsm.javabasico.sixcar.s.a.c.client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.DrbgParameters;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Carro;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Cliente;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.Comprobante;
import peter.unmsm.javabasico.sixcar.s.a.c.domain.DetalleComprobante;
import peter.unmsm.javabasico.sixcar.s.a.c.main.Main;
import peter.unmsm.javabasico.sixcar.s.a.c.service.*;
import peter.unmsm.javabasico.sixcar.s.a.c.service.ClienteService;
import peter.unmsm.javabasico.sixcar.s.a.c.service.DetalleComprobanteService;
import peter.unmsm.javabasico.sixcar.s.a.c.service.orders.*;
import peter.unmsm.javabasico.sixcar.s.a.c.util.FormatoDate;
import peter.unmsm.javabasico.sixcar.s.a.c.util.StringsUtil;

/**
 *
 * @author Timothy
 */
public class ComprobanteClient {

    //variable de paquetes
    FormatoDate fd = new FormatoDate();

    private static final String RUTA_ARCHIVO = "detalleComprobantes.txt";

    static ComprobanteService comprobanteService = new ComprobanteService();
    static ClienteService clienteService = new ClienteService();
    static CarroService carroService = new CarroService();
    static DetalleComprobanteService detalleComprobanteService = new DetalleComprobanteService();
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
                    eliminar();
                case 6 ->
                    salir();
                case 7 ->
                    salirMain();
                default ->
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

            if (continuar) {
                System.out.print("Ingrese (1) para regresar al menú principal \n(0) para salir del programa \n o cualquier otro numero para seguir trabajando con comprobantes: ");
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

    public static void mostrarMenu() {
        System.out.println("===========================================");
        System.out.println("Bienvenido al Mantenimiento de los Comprobantes de venta");
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

    public static void adicionar() {
        Comprobante nuevoComprobante = new Comprobante();

        System.out.println("\nAdición de Comprobante Nuevo");
        System.out.println("======================");

        System.out.print("Ingrese el tipo de comprobante a registrar: ");
        String tipoComprobamte = lector.nextLine();
        nuevoComprobante.setTipoComprobante(tipoComprobamte);

        String ruc = "111111111111";
        nuevoComprobante.setRUCempresa(ruc);

        String numero = "999999999";
        nuevoComprobante.setNumeroTelefono(numero);

        System.out.print("Ingrese la fecha de creacion del comprobante: ");
        String fecha = lector.nextLine();
        nuevoComprobante.setFecha(FormatoDate.FechaParse(fecha)); //convierte String a DATE

        if (comprobanteService.adicionar(nuevoComprobante)) {
            System.out.println("Comprobante añadido con éxito.");
        } else {
            System.out.println("No se pudo añadir el Comprobante. Verifique los datos e intente nuevamente.");
        }

        
        
        /*cliente*/
        
        System.out.println("¿Cuenta con información del cliente? SI(1) - NO(cualquier número)");
        byte respu = lector.nextByte();
        lector.nextLine();
        Cliente nuevoCliente = new Cliente();

        if (respu == 1) {
            /*agregar cliente*/

            System.out.println("\nAdición de información del cliente");
            System.out.println("======================");

            int numeroBoletaCliente = nuevoComprobante.getNumeroBoleta();
            nuevoCliente.setNumeroBoletaCliente(numeroBoletaCliente);

            System.out.print("¿Sabe el tipo de documento del cliente? SI(1) - NO(cualquier número)");
            byte re = lector.nextByte();
            lector.nextLine();

            if (re == 1) {
                System.out.print("Ingrese el tipo de documento (identificacion del cliente): ");
                String tipoDocumento = lector.nextLine();
                nuevoCliente.setTipoDocumento(tipoDocumento);
            } else {
                nuevoCliente.setTipoDocumento(null);
            }

            System.out.print("¿Sabe el número de documento del cliente? SI(1) - NO(cualquier número)");
            byte ret = lector.nextByte();
            lector.nextLine();
            if (ret == 1) {
                System.out.print("Ingrese el número del documento: ");
                String numeroDocumento = lector.nextLine();
                nuevoCliente.setNumeroDocumento(numeroDocumento);
            } else {
                nuevoCliente.setNumeroDocumento(null);
            }

            System.out.print("¿Sabe el número de telefono del cliente? SI(1) - NO(cualquier número)");
            byte retu = lector.nextByte();
            lector.nextLine();

            if (retu == 1) {
                System.out.print("Ingrese el telefono del cliente: ");
                String telefono = lector.nextLine();
                nuevoCliente.setTelefono(telefono);
            } else {
                nuevoCliente.setTelefono(null);
            }

            System.out.print("¿El cliente cuenta con RUC? SI(1) - NO(cualquier número)");
            byte retutu = lector.nextByte();
            lector.nextLine();

            if (retutu == 1) {
                System.out.print("Ingrese el RUC del cliente: ");
                String rucCliente = lector.nextLine();
                nuevoCliente.setRUC(rucCliente);
            } else {
                nuevoCliente.setRUC(null);
            }

            if (clienteService.adicionar(nuevoCliente)) {
                System.out.println("Cliente añadido con exito");
            } else {
                System.out.println("No se pudo añadir al cliente. Verifique los datos e intente nuevamente.");
            }

        } else {
            int numeroBoletaCliente = nuevoComprobante.getNumeroBoleta();
            nuevoCliente.setNumeroBoletaCliente(numeroBoletaCliente);
            nuevoCliente.setTipoDocumento(null);
            nuevoCliente.setNumeroDocumento(null);
            nuevoCliente.setTelefono(null);
            nuevoCliente.setRUC(null);

            
            if (clienteService.adicionar(nuevoCliente)) {
                System.out.println("Cliente añadido con exito");
            } else {
                System.out.println("No se pudo añadir al cliente. Verifique los datos e intente nuevamente.");
            }
            
        }

        
        
        
        
        /*crear carro*/
        
        
        System.out.println("¿Tiene información acerca del carro del cliente? SI(1) - NO(cualquier numero)");
        byte res = lector.nextByte();
        lector.nextLine();
        Carro nuevoCarro = new Carro();
        
        int numeroBoletaCarro = nuevoComprobante.getNumeroBoleta();
        nuevoCarro.setNumeroBoletaCarro(numeroBoletaCarro);
        
        if (res == 1) {
            /*agregar el tipo de carro del cliente*/

            System.out.println("\nAdición de información del carro del cliente");
            System.out.println("======================");            

            System.out.println("¿Sabe la placa del carro del cliente? SI(1) - NO (cualquier número)");
            byte te1 = lector.nextByte();
            lector.nextLine();
            if (te1 == 1) {
                System.out.print("Ingrese la placa del carro: ");
                String placa = lector.nextLine();
                nuevoCarro.setPlaca(placa);
            } else {
                nuevoCarro.setPlaca(null);
            }

            System.out.println("¿Sabe la Marca del carro del cliente? SI(1) - NO (cualquier número)");
            byte te2 = lector.nextByte();
            lector.nextLine();
            if (te2 == 1) {
                System.out.print("Ingrese la Marca del carro: ");
                String marca = lector.nextLine();
                nuevoCarro.setMarca(marca);
            } else {
                nuevoCarro.setMarca(null);
            }

            System.out.println("¿Sabe el año del carro del cliente? SI(1) - NO (cualquier número)");
            byte te3 = lector.nextByte();
            lector.nextLine();
            if (te3 == 1) {
                System.out.print("Ingrese el año del carro: ");
                short anio = lector.nextShort();
                lector.nextLine();
                nuevoCarro.setAnio(anio);

            } else {
                nuevoCarro.setAnio((short) 0);
            }

            if (carroService.adicionar(nuevoCarro)) {
                System.out.println("Carro añadido con exito");
            } else {
                System.out.println("No se pudo añadir al cliente. Verifique los datos e intente nuevamente.");
            }
        } else {

            nuevoCarro.setPlaca(null);
            nuevoCarro.setMarca(null);
            nuevoCarro.setAnio((short) 0);
            
            if (carroService.adicionar(nuevoCarro)) {
                System.out.println("Carro añadido con exito");
            } else {
                System.out.println("No se pudo añadir al cliente. Verifique los datos e intente nuevamente.");
            }
        }

        /*agregar detalles de la compra*/
        System.out.println("\nAdición de los detalles de compra");
        System.out.println("======================");

        System.out.print("Ingrese la cantidad de productos que tendrá el detalle de comprobante: ");
        int cantidadProductosDC = lector.nextInt();
        lector.nextLine();

        if (cantidadProductosDC > 0) {

            BigDecimal acomuladorBD = BigDecimal.ZERO;

            for (int i = 1; i <= cantidadProductosDC; i++) {

                System.out.println("\nIngrese el detalle del producto número " + i);
                System.out.println("======================");

                DetalleComprobante nuevoDC = new DetalleComprobante();

                byte CPR = (byte) cantidadProductosDC;
                nuevoDC.setCantidadProductoRegistrar(CPR);

                int numeroBoletaDC = nuevoComprobante.getNumeroBoleta();
                nuevoDC.setNumeroBoletaDetalleComprobante(numeroBoletaDC);

                System.out.print("Ingrese el nombre del producto: ");
                String nombreP = lector.nextLine();
                nuevoDC.setNombreProducto(nombreP);

                System.out.print("Ingrese el precio del producto (use coma en vez de punto ejm: 10,50): ");
                float precioP = lector.nextFloat();
                BigDecimal BDPrecioP = BigDecimal.valueOf(precioP);
                lector.nextLine();
                nuevoDC.setPrecioProducto(precioP);

                System.out.print("Ingrese la cantidad del producto: ");
                short cantidadP = lector.nextShort();
                BigDecimal BDCantidadP = BigDecimal.valueOf(cantidadP);
                lector.nextLine();
                nuevoDC.setCantidadProducto(cantidadP);

                BigDecimal TotalProductoDC = BDPrecioP.multiply(BDCantidadP);
                System.out.print("El total del producto es de: " + TotalProductoDC);
                nuevoDC.setTotalProducto(TotalProductoDC);

                acomuladorBD = acomuladorBD.add(TotalProductoDC);

                if (i == cantidadProductosDC) {
                    System.out.println("\n==========================================");
                    System.out.print("\nEl total de todos los productos es: " + acomuladorBD);
                    nuevoDC.setTotal(acomuladorBD);
                } else {
                    nuevoDC.setTotal(BigDecimal.ZERO);
                }

                System.out.println("\n==========================================");

                if (detalleComprobanteService.adicionar(nuevoDC)) {
                    System.out.println("detalle número (" + i + ") añadido con exito");
                } else {
                    System.out.println("No se pudo añadir detalle del comprobante producto numero (" + i + "). Verifique los datos e intente nuevamente.");
                }

            }

        } else {
            System.out.println("No se pudo añadir los detalles correctamente. Verifique los datos e intente nuevamente.");
        }

    }

    public static void modificar() {

        System.out.println("\nModificación del Comprobante");
        System.out.println("===========================");

        System.out.print("Ingrese el Id del comprobante: ");
        int idModificar = lector.nextInt();
        lector.nextLine();

        Comprobante comprobante = comprobanteService.consultarPorId(idModificar);

        Comprobante comprobanteModificado = new Comprobante();

        int idModificarint = comprobante.getNumeroBoleta();
        comprobanteModificado.setNumeroBoleta(idModificarint);

        System.out.print("Ingrese el tipo de comprobante: ");
        String tipoComprobante = lector.nextLine();
        comprobanteModificado.setTipoComprobante(tipoComprobante);

        String ruc = "111111111111";
        comprobanteModificado.setRUCempresa(ruc);

        String numero = "999999999";
        comprobanteModificado.setNumeroTelefono(numero);

        System.out.print("Ingrese la fecha de creacion del comprobante: ");
        String fecha = lector.nextLine();
        comprobanteModificado.setFecha(FormatoDate.FechaParse(fecha)); //convierte String a DATE

        if (comprobanteService.modificar(idModificar, comprobanteModificado)) {
            System.out.println("Comprobante modificado con éxito.");
        } else {
            System.out.println("No se pudo modificar el Comprobante. Verifique los datos e intente nuevamente.");
        }

        
        /*modificación cliente*/
        System.out.println("¿Cuenta con información del cliente? SI(1) - NO(cualquier número)");
        byte respu = lector.nextByte();
        lector.nextLine();

        /*modificar cliente*/
        Cliente cliente = clienteService.consultarPorId(idModificar);

        Cliente clienteModificado = new Cliente();

        int numeroBoletaCliente = comprobante.getNumeroBoleta();
        clienteModificado.setNumeroBoletaCliente(numeroBoletaCliente);

        int idClienteint = cliente.getIdCliente();
        clienteModificado.setIdCliente(idClienteint);

        if (respu == 1) {

            System.out.println("\nModificación del Cliente");
            System.out.println("===========================");

            System.out.print("¿Sabe el tipo de documento del cliente? SI(1) - NO(cualquier número)");
            byte re = lector.nextByte();
            lector.nextLine();

            if (re == 1) {

                System.out.print("Ingrese el tipo de documento (identificacion del cliente): ");
                String tipoDocumento = lector.nextLine();
                clienteModificado.setTipoDocumento(tipoDocumento);
            } else {
                clienteModificado.setTipoDocumento(null);
            }

            System.out.print("¿Sabe el número de documento del cliente? SI(1) - NO(cualquier número)");
            byte re2 = lector.nextByte();
            lector.nextLine();

            if (re2 == 1) {

                System.out.print("Ingrese el número del documento: ");
                String numeroDocumento = lector.nextLine();
                clienteModificado.setNumeroDocumento(numeroDocumento);
            } else {
                clienteModificado.setNumeroDocumento(null);
            }

            System.out.print("¿Sabe el número de telefono del cliente? SI(1) - NO(cualquier número)");
            byte re3 = lector.nextByte();
            lector.nextLine();

            if (re3 == 1) {

                System.out.print("Ingrese el telefono del cliente: ");
                String telefono = lector.nextLine();
                clienteModificado.setTelefono(telefono);

            } else {
                clienteModificado.setTelefono(null);
            }

            System.out.print("¿Sabe el cliente cuenta con RUC? SI(1) - NO(cualquier número)");
            byte re4 = lector.nextByte();
            lector.nextLine();

            if (re4 == 1) {

                System.out.print("Ingrese el RUC del cliente: ");
                String rucCliente = lector.nextLine();
                clienteModificado.setRUC(rucCliente);
            } else {
                clienteModificado.setRUC(null);
            }

            if (clienteService.modificar(idModificar, clienteModificado)) {
                System.out.println("Cliente modificado con exito");
            } else {
                System.out.println("No se pudo modificar al cliente. Verifique los datos e intente nuevamente.");
            }

        } else {
            
            clienteModificado.setRUC(null);
            clienteModificado.setTelefono(null);
            clienteModificado.setNumeroDocumento(null);
            clienteModificado.setTipoDocumento(null);
            
            if (clienteService.modificar(idModificar, clienteModificado)) {
                System.out.println("Cliente modificado con exito");
            } else {
                System.out.println("No se pudo modificar al cliente. Verifique los datos e intente nuevamente.");
            }
        }

        /*agregar el tipo de carro del cliente*/
        System.out.println("¿Tiene información acerca del carro del cliente? SI(1) - NO(cualquier numero)");
        byte res = lector.nextByte();
        lector.nextLine();

        Carro nuevoCarro = carroService.consultarPorId(idModificar);

        Carro carroModificado = new Carro();

        if (res == 1) {

            System.out.println("\n Moficación de información del carro del cliente");
            System.out.println("======================");

            int numeroBoletaCarro = comprobante.getNumeroBoleta();
            carroModificado.setNumeroBoletaCarro(numeroBoletaCarro);

            int idCarroInt = nuevoCarro.getIdCarro();
            carroModificado.setIdCarro(idCarroInt);

            System.out.println("¿Sabe la placa del carro del cliente? SI(1) - NO (cualquier número)");
            byte te1 = lector.nextByte();
            lector.nextLine();
            if (te1 == 1) {
                System.out.print("Ingrese la placa del carro: ");
                String placa = lector.nextLine();
                carroModificado.setPlaca(placa);
            } else {
                carroModificado.setPlaca(null);
            }

            System.out.println("¿Sabe la Marca del carro del cliente? SI(1) - NO (cualquier número)");
            byte te2 = lector.nextByte();
            lector.nextLine();

            if (te2 == 1) {
                System.out.print("Ingrese la Marca del carro: ");
                String marca = lector.nextLine();
                carroModificado.setMarca(marca);
            } else {
                carroModificado.setMarca(null);
            }

            System.out.println("¿Sabe el año del carro del cliente? SI(1) - NO (cualquier número)");
            byte te3 = lector.nextByte();
            lector.nextLine();

            if (te3 == 1) {
                System.out.print("Ingrese el año del carro: ");
                short anio = lector.nextShort();
                lector.nextLine();
                carroModificado.setAnio(anio);
            } else {
                carroModificado.setAnio((short)0);
            }

            if (carroService.modificar(idModificar, carroModificado)) {
                System.out.println("Carro modificado con exito");
            } else {
                System.out.println("No se pudo modificar al carro. Verifique los datos e intente nuevamente.");
            }

        } else {
            carroModificado.setMarca(null);
            carroModificado.setPlaca(null);
            carroModificado.setAnio((short) 0);
            
            if (carroService.modificar(idModificar, carroModificado)) {
                System.out.println("Carro modificado con exito");
            } else {
                System.out.println("No se pudo modificar al carro. Verifique los datos e intente nuevamente.");
            }

        }

        
        
        /*Modificar detalle comprobante*/
        DetalleComprobante nuevoDC = detalleComprobanteService.consultarPorId((short) idModificar);

        System.out.println("\n Modificación de los detalles de compra");
        System.out.println("======================");

        int DCNueva = nuevoDC.getNumeroBoletaDetalleComprobante();
        eliminarDetalleComprobante(idModificar);

        System.out.print("Ingrese la cantidad de productos que tendrá el detalle de comprobante: ");
        int cantidadProductosDC = lector.nextInt();
        lector.nextLine();

        if (cantidadProductosDC > 0) {

            BigDecimal acomuladorBD = BigDecimal.ZERO;

            for (int i = 1; i <= cantidadProductosDC; i++) {

                DetalleComprobante DCModificado = new DetalleComprobante();

                System.out.println("\nIngrese el detalle del producto número " + i);
                System.out.println("======================");

                int numeroBoletaDC = DCNueva;
                DCModificado.setNumeroBoletaDetalleComprobante(numeroBoletaDC);

                int idDCint = i;
                DCModificado.setIdDetalleComprobante(idDCint);

                byte CPR = (byte) cantidadProductosDC;
                nuevoDC.setCantidadProductoRegistrar(CPR);

                System.out.print("Ingrese el nombre del producto: ");
                String nombreP = lector.nextLine();
                DCModificado.setNombreProducto(nombreP);

                System.out.print("Ingrese el precio del producto (use coma en vez de punto ejm: 10,50): ");
                float precioP = lector.nextFloat();
                BigDecimal BDPrecioP = BigDecimal.valueOf(precioP);
                lector.nextLine();
                DCModificado.setPrecioProducto(precioP);

                System.out.print("Ingrese la cantidad del producto: ");
                short cantidadP = lector.nextShort();
                BigDecimal BDCantidadP = BigDecimal.valueOf(cantidadP);
                lector.nextLine();
                DCModificado.setCantidadProducto(cantidadP);

                BigDecimal TotalProductoDC = BDPrecioP.multiply(BDCantidadP);
                System.out.print("El total del producto es de: " + TotalProductoDC);
                DCModificado.setTotalProducto(TotalProductoDC);

                acomuladorBD = acomuladorBD.add(TotalProductoDC);

                if (i == cantidadProductosDC) {
                    System.out.println("\n==========================================");
                    System.out.print("\nEl total de todos los productos es: " + acomuladorBD);
                    DCModificado.setTotal(acomuladorBD);
                } else {
                    DCModificado.setTotal(BigDecimal.ZERO);
                }

                System.out.println("\n==========================================");

                if (detalleComprobanteService.adicionar(DCModificado)) {
                    System.out.println("detalle número (" + i + ") modificado con exito");
                } else {
                    System.out.println("No se pudo modificar detalle del comprobante producto numero (" + i + "). Verifique los datos e intente nuevamente.");
                }

            }

        } else {
            System.out.println("No se pudo añadir los detalles correctamente. Verifique los datos e intente nuevamente.");
        }

    }

    public static void salirMain() {
        Main.main(new String[]{});
    }

    public static void consultarTodos() {

        System.out.println("\nConsulta Todos los Comprobantes");
        System.out.println("=============================");

        Comprobante[] comprobantes = comprobanteService.consultar();

        System.out.printf("%-30s   %-30s   %-30s   %-50s   %-30s\n", "Numero Boleta", "Fecha de compra", "Tipo Comprobante", "RUC de la empresa Import Tradign Global S.A.C.", "Número de contacto de la empresa");

        for (Comprobante comprobante : comprobantes) {
            String idConRelleno = String.format("%08d", comprobante.getNumeroBoleta());  // Relleno de ceros
            System.out.printf("%-30s   %-30s   %-30s   %-50s   %-30s\n",
                    idConRelleno,
                    FormatoDate.FechaFormat(comprobante.getFecha()),
                    comprobante.getTipoComprobante(),
                    StringsUtil.truncateString(comprobante.getRUCempresa(), 50),
                    StringsUtil.truncateString(comprobante.getNumeroTelefono(), 30));
        }

    }

    private static void consultarPorId() {

        System.out.println("\nConsulta de Comprobante por Id");
        System.out.println("===============================");

        System.out.print("Ingrese el identificador del comprobante a consultar: ");
        int idConsultar = lector.nextInt();
        lector.nextLine();

        Comprobante comprobante = comprobanteService.consultarPorId(idConsultar);
        Cliente cliente = clienteService.consultarPorId(idConsultar);
        Carro carro = carroService.consultarPorId(idConsultar);


        /*imprimir comprobante*/
        if (comprobante != null) {
            String idConRelleno = String.format("%08d", comprobante.getNumeroBoleta());  // Relleno de ceros
            System.out.printf("%-30s   %-30s   %-30s   %-50s   %-50s\n", "Numero Boleta", "Fecha de compra", "Tipo Comprobante", "RUC de la empresa Import Tradign Global S.A.C.", "Número de contacto de la empresa");
            System.out.printf("%-30s   %-30s   %-30s   %-50s   %-50s\n",
                    idConRelleno,
                    FormatoDate.FechaFormat(comprobante.getFecha()),
                    comprobante.getTipoComprobante(),
                    StringsUtil.truncateString(comprobante.getRUCempresa(), 30),
                    StringsUtil.truncateString(comprobante.getNumeroTelefono(), 30));
        } else {
            System.out.println("No se encontró el comprobante con el ID especificado.");
        }
        //========================================================

        System.out.println("======================================================================================================================================");

        /*imprimir cliente*/
        if (cliente != null) {
//            String idConRelleno = String.format("%08d", cliente.getNumeroBoletaCliente());  // Relleno de ceros
            System.out.printf("%-30s   %-30s   %-30s   %-30s\n", "Tipo Documento", "Número Documento", "Número celular cliente", "RUC de la empresa del cliente");
            System.out.printf("%-30s   %-30s   %-30s   %-30s\n",
                    //                    idConRelleno,
                    StringsUtil.truncateString(cliente.getTipoDocumento(), 20),
                    StringsUtil.truncateString(cliente.getNumeroDocumento(), 20),
                    StringsUtil.truncateString(cliente.getTelefono(), 20),
                    StringsUtil.truncateString(cliente.getRUC(), 20));
        } else {
            System.out.println("No se encontró el comprobante con el ID especificado.");
        }

        System.out.println("======================================================================================================================================");

        /*imprimir carro*/
        if (carro != null) {
//            String idConRelleno = String.format("%08d", comprobante.getNumeroBoleta());  // Relleno de ceros
            System.out.printf("%-30s   %-40s   %-30s\n", "Placa", "Marca", "Año");
            System.out.printf("%-30s   %-40s   %-30s\n",
                    //                    idConRelleno,
                    StringsUtil.truncateString(carro.getPlaca(), 20),
                    StringsUtil.truncateString(carro.getMarca(), 40),
                    carro.getAnio());
        } else {
            System.out.println("No se encontró el comprobante con el ID especificado.");
        }

        System.out.println("======================================================================================================================================");

        /*imprimir detalle comprobante*/
        consultarTodosPorCriterioOrden((short) idConsultar);

        System.out.println("======================================================================================================================================");

    }

    private static void eliminar() {

        System.out.println("\nEliminación de comprobante por Id");
        System.out.println("===============================");

        System.out.print("Ingrese el codigo del comprobante a eliminar: ");
        int idEliminar = lector.nextInt();
        lector.nextLine();

        DetalleComprobante nuevoDC = detalleComprobanteService.consultarPorId((short) idEliminar);

        if (comprobanteService.eliminar(idEliminar)) {
            System.out.println("Comprobante eliminado con éxito.");
        } else {
            System.out.println("No se pudo eliminar el comprobante. Verifique el codigo e intente nuevamente.");
        }

        if (clienteService.eliminar(idEliminar)) {
            System.out.println("cliente eliminado con éxito.");
        } else {
            System.out.println("No se pudo eliminar el cliente. Verifique el codigo e intente nuevamente.");
        }

        if (carroService.eliminar(idEliminar)) {
            System.out.println("carro eliminado con éxito.");
        } else {
            System.out.println("No se pudo eliminar el carro. Verifique el codigo e intente nuevamente.");
        }

        for (int i = 1; i <= nuevoDC.getCantidadProductoRegistrar(); i++) {
            if (detalleComprobanteService.eliminar(idEliminar)) {
                System.out.println("Detalle Comprobante eliminado con éxito.");
            } else {
                System.out.println("No se pudo eliminar el detalle comprobante. Verifique el codigo e intente nuevamente.");
            }

        }
    }

    private static void eliminarDetalleComprobante(int ideliminar) {

        short idEliminar = (short) ideliminar;

        DetalleComprobante nuevoDC = detalleComprobanteService.consultarPorId(idEliminar);

        for (int i = 1; i <= nuevoDC.getCantidadProductoRegistrar(); i++) {
            if (detalleComprobanteService.eliminar(idEliminar)) {
                System.out.println("Detalle Comprobante eliminado con éxito.");
            } else {
                System.out.println("No se pudo eliminar el detalle comprobante. Verifique el codigo e intente nuevamente.");
            }

        }
    }

    public static void salir() {
        System.exit(0);
    }

    //consultarTodosPorCriterioOrden
    private static void consultarTodosPorCriterioOrden(short comparador) {
        System.out.println("\nConsulta Total de Detalle Comprobante");
        System.out.println("==================================================");

        //crear arreglo con los comprobantes en orden
        DetalleComprobante[] detalleComprobante = detalleComprobanteService.consiltarPorCriterio(comparador);

        //imprimir comprobantes
        System.out.printf("%-40s   %-20s   %-60s   %-20s   %-50s   %-20s\n", "numero boleta", "Cantidad", "Nombre Producto", "Precio Unitario del Producto", "Total Producto", "Total");
        
        for (DetalleComprobante detallecomprobante : detalleComprobante) {
            String idConRelleno = String.format("%08d", detallecomprobante.getNumeroBoletaDetalleComprobante());   // Relleno de ceros
            System.out.printf("%-40s   %-20s   %-60s   %-20s   %-50s   %-20s \n",
                    idConRelleno,
                    detallecomprobante.getCantidadProducto(),
                    StringsUtil.truncateString(detallecomprobante.getNombreProducto(), 60),
                    detallecomprobante.getPrecioProducto(),
                    detallecomprobante.getTotalProducto(),
                    detallecomprobante.getTotal());
        }

    }

    //=============================
}
