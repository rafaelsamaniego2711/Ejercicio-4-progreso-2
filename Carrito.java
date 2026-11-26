import java.util.ArrayList;

public class Carrito {
    private ArrayList<ItemCarrito> items;

    public Carrito() {
        items = new ArrayList<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if (producto == null || cantidad <= 0) {
            return;
        }
        items.add(new ItemCarrito(producto, cantidad));
    }

    public int obtenerCantidadItems() {
        return items.size();
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemCarrito item : items) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public boolean eliminarItem(int posicion) {
        if (posicion < 0 || posicion >= items.size()) {
            return false;
        }
        items.remove(posicion);
        return true;
    }

    public ItemCarrito obtenerItemMayorSubtotal() {
        if (items.isEmpty()) {
            return null;
        }
        ItemCarrito mayor = items.get(0);
        for (ItemCarrito item : items) {
            if (item.calcularSubtotal() > mayor.calcularSubtotal()) {
                mayor = item;
            }
        }
        return mayor;
    }

    public String mostrarResumen() {
        if (items.isEmpty()) {
            return "El carrito está vacío.\nTotal: $0.00";
        }
        String resumen = "";
        for (ItemCarrito item : items) {
            resumen += item.mostrarInformacion() + "\n";
        }
        resumen += "Total: $" + String.format("%.2f", calcularTotal());
        return resumen;
    }
}
