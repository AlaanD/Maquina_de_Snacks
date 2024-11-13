package maquina_snacks_archivos_multicapa.presentacion;

import maquina_snacks_archivos_multicapa.servicio.IServicioSnacks;
import maquina_snacks_archivos_multicapa.servicio.ServicioSnacksArchivos;
import maquina_snacks_archivos_multicapa.servicio.ServicioSnacksLista;
import maquina_snacks_archivos_multicapa.dominio.Snack;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {

    public static void main(String[] args) {
        maquinaSnacks();
    }

    public static void maquinaSnacks(){
        var salir = false;
        var consola = new Scanner(System.in);

        //Creamos el objeto para obtener el servicio de snacks (lista)
        //IServicioSnacks servicioSnacks = new ServicioSnacksLista();

        //Creamos el objeto para obtener el servicio de snacks (Archivo)
        IServicioSnacks servicioSnacks = new ServicioSnacksArchivos();

        //Creamos la lista de productos de tipo snacks
        List<Snack> productos = new ArrayList<>();

        System.out.println("*** Maquina de Snacks ***");
        servicioSnacks.mostrarSnacks();

        while(!salir){
            try {
                var opcion = MaquinaSnacks.mostrarMenu(consola);
                salir = MaquinaSnacks.ejecutarOpciones(opcion, consola, productos, servicioSnacks);
            } catch (Exception e) {
                System.out.println("\nError, solo ingrese un numero entero: " + e.getMessage());
            } finally {
                System.out.println();
            }
        }
        consola.close();
    }

    private static int mostrarMenu(Scanner consola){
        System.out.println("""
                    Menu:
                    1. Comprar snack
                    2. Mostrar ticket
                    3. Agregar Nuevo Snack
                    4. Inventario de Snacks
                    5. Salir""");
        System.out.print("Elige una opcion: ");
        return Integer.parseInt(consola.nextLine().strip());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack> productos, IServicioSnacks servicioSnacks) {
        System.out.println();
        switch(opcion){
            case 1 -> MaquinaSnacks.comprarSnack(consola, productos, servicioSnacks);
            case 2 -> MaquinaSnacks.mostarTicket(productos);
            case 3 -> MaquinaSnacks.agregarSnack(consola, servicioSnacks);
            case 4 -> MaquinaSnacks.listarInventarioSnacks(consola, servicioSnacks);
            case 5 -> {
                System.out.println("¡Hasta Luego!");
                return true;
            }
            default -> System.out.println("Opcion invalida: " + opcion);
        }
        return false;
    }

    private static void listarInventarioSnacks(Scanner consola, IServicioSnacks servicioSnacks){
        servicioSnacks.mostrarSnacks();
    }

    private static void comprarSnack(Scanner consola, List<Snack> productos, IServicioSnacks servicioSnacks) {
        System.out.print("Que snack quieres comprar (id)? ");
        var idSnack = Integer.parseInt(consola.nextLine().strip());
        boolean existeSnack = false;

        for (var snack: servicioSnacks.getSnacks()){
            if(idSnack == snack.getID_SNACK()){
                productos.add(snack);
                System.out.println("Ok, Snack agregado: " + snack);
                existeSnack = true;
                break;
            }
        }

        if (!existeSnack)
            System.out.println("Id de snack no encontrado: " + idSnack);
    }

    private static void mostarTicket(List<Snack> productos) {
        var ticket = "*** Ticket de Venta ***";
        var total = 0.0;

        for(var producto: productos){
            ticket += "\n\t- " + producto.getNombre() + " - $" + producto.getPrecio();
            total += producto.getPrecio();
        }
        ticket += "\n\tTotal -> $" + total;
        System.out.println(ticket);
    }

    private static void agregarSnack(Scanner consola, IServicioSnacks servicioSnacks) {
        System.out.print("Nombre del snack: ");
        var nombre = consola.nextLine().strip();
        System.out.print("Precio del snack: ");
        var precio = Double.parseDouble(consola.nextLine().strip());
        servicioSnacks.agregarSnack(new Snack(nombre, precio));
        System.out.println("\nTu snack se ha agregado correctamente");
        servicioSnacks.mostrarSnacks();
    }
}
