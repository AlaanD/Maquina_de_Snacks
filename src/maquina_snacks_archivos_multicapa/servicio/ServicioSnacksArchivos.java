package maquina_snacks_archivos_multicapa.servicio;

import maquina_snacks_archivos_multicapa.dominio.Snack;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksArchivos implements IServicioSnacks{
    private final String NOMBRE_ARCHIVO = "snacks.txt";
    private List<Snack> snacks = new ArrayList<>();

    public ServicioSnacksArchivos(){
        //Creamos el archivo si no existe
        var archivo = new File(this.NOMBRE_ARCHIVO);
        var existe = false;
        try {
            existe = archivo.exists();
            if (existe){
                this.snacks = obtenerSnacks();
            }else {
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
                //Si no existe, cargamos algunos snacks iniciales
                cargarSnacksIniciales();
            }
        } catch (Exception e){
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    private void cargarSnacksIniciales() {
        this.agregarSnack(new Snack("Papas", 70));
        this.agregarSnack(new Snack("Gaseosa", 50));
        this.agregarSnack(new Snack("Sandwich", 120));
    }

    private List<Snack> obtenerSnacks() {
        var snacks = new ArrayList<Snack>();
        try{
            List<String> lineas = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
            for (String linea: lineas){
                /*
                El metodo split divide la cadena linea en partes utilizando
                la coma como delimitador y devuelve un array que contiene esas partes.
                El tamaño del array resultante depende del número de comas en la
                cadena original, por lo que no se necesita especificar el tamaño
                del array manualmente.
                */
                String[] lineaSnack = linea.split(",");
                var nombre = lineaSnack[1];
                var precio = Double.parseDouble(lineaSnack[2]);
                var snack = new Snack(nombre, precio);
                //agregamos el snack leido a la lista
                snacks.add(snack);
            }
        }catch (Exception e){
            System.out.println("Error al leer archivo de snacks: " + e.getMessage());
            e.printStackTrace();
        }
        return snacks;
    }

    @Override
    public void agregarSnack(Snack snack) {
        //Agregamos el nuevo snack a la lista en memoria
        this.snacks.add(snack);
        //Guardamos el nuevo snack en el archivo
        this.agregarSnackArchivo(snack);
    }

    private void agregarSnackArchivo(Snack snack) {
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(snack.escribirSnack());
            salida.close();
        }catch (Exception e){
            System.out.println("Error al agregar snack: " + e.getMessage());
        }
    }

    @Override
    public void mostrarSnacks() {
        System.out.println("--- Snacks en el Inventario ---");
        //Mostramos la lista de snacks en el archivo
        var inventarioSnacks = "";
        for (var snack: this.snacks){
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println(inventarioSnacks);
    }

    @Override
    public List<Snack> getSnacks() {
        return this.snacks;
    }
}
