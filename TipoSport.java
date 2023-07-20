package proyectoFinal;

public class TipoSport extends Automovil {
    public TipoSport(String nombre, int precio, String imagen) {
        super("Sport", nombre, precio, imagen);
    }

    @Override
    public String descripcion() {
        return "Deportivo, 4 puertas";
    }
}
