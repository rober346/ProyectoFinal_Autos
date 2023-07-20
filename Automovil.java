package proyectoFinal;

public abstract class Automovil {
    
    private String tipo;
    private String nombre;
    private int precio;
    private String imagen; // Agregamos el atributo para la ruta de la imagen

    public Automovil(String tipo, String nombre, int precio, String imagen) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen; // Inicializamos el atributo con la ruta de la imagen
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public abstract String descripcion();

    public String getImagen() { // Agregamos el getter para la ruta de la imagen
        return imagen;
    }
}
