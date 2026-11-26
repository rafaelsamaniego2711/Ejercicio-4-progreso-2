public class Main {
    public static void main(String[] args) {
        Carrito carrito = new Carrito();
        System.out.println("Carrito vacío - items: " + carrito.obtenerCantidadItems());

        Producto p1 = new Producto("P01", "Mouse", 25.50);
        Producto p2 = new Producto("P02", "Teclado", 40.00);
        Producto p3 = new Producto("P03", "Audífonos", 55.00);

        carrito.agregarProducto(p1, 2);
        carrito.agregarProducto(p2, 1);
        carrito.agregarProducto(p3, 2);
        carrito.agregarProducto(p1, 0); // Ignorado por cantidad <= 0

        System.out.println(carrito.mostrarResumen());
        System.out.printf("Total calculado: $%.2f%n", carrito.calcularTotal());

        ItemCarrito mayor = carrito.obtenerItemMayorSubtotal();
        System.out.println("Mayor subtotal: " + (mayor != null ? mayor.mostrarInformacion() : "Ninguno"));

        System.out.println("Eliminar posición 1: " + carrito.eliminarItem(1));
        System.out.println("Eliminar posición 99: " + carrito.eliminarItem(99));
        System.out.println("\nResumen tras eliminar:\n" + carrito.mostrarResumen());
    }
}
