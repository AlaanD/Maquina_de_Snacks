package maquina_snacks;

import java.util.ArrayList;
import java.util.List;

public class ListaSnack {
    private static final List<Snack> listaSnacks;

    //bloque static inicializador
    //para inicializar clases
    static {
        listaSnacks = new ArrayList<>();
        listaSnacks.add(new Snack("Papas", 70));
        listaSnacks.add(new Snack("Gaseosa", 50));
        listaSnacks.add(new Snack("Sandwich", 120));
    }

    public static void agregarSnack(Snack snack){
        ListaSnack.listaSnacks.add(snack);
    }

    public static void mostrarSnacks(){
        var inventarioSnacks = "";
        for (var snack: ListaSnack.listaSnacks){
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println("--- Snacks en el Inventario ---");
        System.out.println(inventarioSnacks);
    }

    public static List<Snack> getListaSnacks() {
        return ListaSnack.listaSnacks;
    }

}
