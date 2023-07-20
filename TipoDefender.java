package proyectoFinal;

public class TipoDefender extends Automovil {
    public TipoDefender(String nombre, int precio, String imagen) {
        super("Defender", nombre, precio, imagen);
    }

    @Override
    public String descripcion() {
        return "Minivagoneta, de 4 puertas, ";
    }
}
