package maquina_snacks_archivos_multicapa.servicio;

import maquina_snacks_archivos_multicapa.dominio.Snack;

import java.util.List;

public interface IServicioSnacks {
    void agregarSnack(Snack snack);
    void mostrarSnacks();
    List<Snack> getSnacks();
}
