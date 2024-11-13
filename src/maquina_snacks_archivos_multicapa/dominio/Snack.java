package maquina_snacks_archivos_multicapa.dominio;

import java.io.Serializable;
import java.util.Objects;

public class Snack implements Serializable {
    private static int contadorSnacks;
    private final int ID_SNACK;
    private String nombre;
    private double precio;

    public Snack(){
        this.ID_SNACK = ++Snack.contadorSnacks;
    }

    public Snack(String nombre, double precio){
        //se llama al constructor vacios, debe ser la primer linea
        this();
        this.nombre = nombre;
        this.precio = precio;
    }

    public static int getContadorSnacks() {
        return contadorSnacks;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getID_SNACK() {
        return this.ID_SNACK;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "ID_SNACK=" + ID_SNACK +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public String escribirSnack() {
        return this.ID_SNACK + "," + this.nombre + "," + this.precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return ID_SNACK == snack.ID_SNACK;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ID_SNACK);
    }
}
