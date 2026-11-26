public class ItemCarrito {
    private Producto producto;
    private int cantidad;

    public ItemCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public double calcularSubtotal() {
        if (producto == null || cantidad <= 0) {
            return 0.0;
        }
        return producto.getPrecio() * cantidad;
    }

    public String mostrarInformacion() {
        String infoProducto = (producto != null) ? producto.mostrarInformacion() : "Producto no disponible";
        return infoProducto + " | Cantidad: " + cantidad + " | Subtotal: $" + String.format("%.2f", calcularSubtotal());
    }
}
