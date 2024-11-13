package maquina_snacks_archivos_multicapa.servicio;

import maquina_snacks_archivos_multicapa.dominio.Snack;
import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksLista implements IServicioSnacks {
    private static final List<Snack> listaSnacks;

    //bloque static inicializador
    //para inicializar clases
    static {
        listaSnacks = new ArrayList<>();
        listaSnacks.add(new Snack("Papas", 70));
        listaSnacks.add(new Snack("Gaseosa", 50));
        listaSnacks.add(new Snack("Sandwich", 120));
    }

    public void agregarSnack(Snack snack){
        ServicioSnacksLista.listaSnacks.add(snack);
    }

    public void mostrarSnacks(){
        var inventarioSnacks = "";
        for (var snack: ServicioSnacksLista.listaSnacks){
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println("--- Snacks en el Inventario ---");
        System.out.println(inventarioSnacks);
    }

    public List<Snack> getSnacks() {
        return ServicioSnacksLista.listaSnacks;
    }

}
