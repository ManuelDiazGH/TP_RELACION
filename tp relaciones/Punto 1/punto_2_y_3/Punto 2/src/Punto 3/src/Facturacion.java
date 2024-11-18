import java.util.Scanner;

public class Facturacion {
    private static final String[][] articulos = {
            {"101", "Leche", "25"},
            {"102", "Gaseosa", "30"},
            {"103", "Fideos", "15"},
            {"104", "Arroz", "28"},
            {"105", "Vino", "120"},
            {"106", "Manteca", "20"},
            {"107", "Lavandina", "18"},
            {"108", "Detergente", "46"},
            {"109", "Jabón en Polvo", "96"},
            {"110", "Galletas", "60"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Factura factura = new Factura();

        System.out.print("Ingrese la fecha de la factura: ");
        factura.setFechaFactura(scanner.nextLine());

        System.out.print("Ingrese el número de la factura: ");
        long numeroFactura;
        do {
            numeroFactura = scanner.nextLong();
            scanner.nextLine(); // Consumir el salto de línea
            if (numeroFactura <= 0) {
                System.out.println("El número de factura debe ser mayor a 0. Intente nuevamente.");
            }
        } while (numeroFactura <= 0);
        factura.setNumeroFactura(numeroFactura);

        System.out.print("Ingrese el nombre del cliente: ");
        String cliente;
        do {
            cliente = scanner.nextLine();
            if (cliente.isEmpty()) {
                System.out.println("El cliente no puede estar vacío. Intente nuevamente.");
            }
        } while (cliente.isEmpty());
        factura.setCliente(cliente);

        while (true) {
            System.out.print("Ingrese el código del artículo (o '0' para finalizar): ");
            String codigo = scanner.nextLine();
            if (codigo.equals("0")) {
                break;
            }

            String[] articulo = buscarArticulo(codigo);
            if (articulo == null) {
                System.out.println("El código ingresado no existe. Intente nuevamente.");
                continue;
            }

            System.out.print("Ingrese la cantidad a facturar: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            DetalleFactura detalle = new DetalleFactura(
                    articulo[0],
                    articulo[1],
                    cantidad,
                    Double.parseDouble(articulo[2])
            );
            factura.agregarDetalle(detalle);
        }

        factura.calcularMontoTotal();
        System.out.println("\nFactura generada:");
        System.out.println(factura);

        scanner.close();
    }

    private static String[] buscarArticulo(String codigo) {
        for (String[] articulo : articulos) {
            if (articulo[0].equals(codigo)) {
                return articulo;
            }
        }
        return null;
    }
}
