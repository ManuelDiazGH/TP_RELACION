import java.util.ArrayList;

public class Plato {
    private String nombreCompleto;
    private double precio;
    private boolean esBebida;
    private ArrayList<Ingrediente> ingredientes;

    public Plato(String nombreCompleto, double precio, boolean esBebida) {
        this.nombreCompleto = nombreCompleto;
        this.precio = precio;
        this.esBebida = esBebida;
        this.ingredientes = new ArrayList<>();
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombreCompleto).append("\nPrecio: $").append(precio).append("\n");
        if (!esBebida) {
            sb.append("Ingredientes:\n");
            for (Ingrediente ingrediente : ingredientes) {
                sb.append(ingrediente).append("\n");
            }
        }
        return sb.toString();
    }
}
