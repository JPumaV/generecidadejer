import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tipo de dato (integer/double): ");
        String tipo = scanner.next().toLowerCase();

        if (tipo.equals("integer")) {
            System.out.print("Ingrese un número entero: ");
            Integer valor = scanner.nextInt();
            OperacionesMatInteger op = new OperacionesMatInteger(valor);
            ejecutarMenu(scanner, op, Integer.class);
        } else if (tipo.equals("double")) {
            System.out.print("Ingrese un número decimal: ");
            Double valor = scanner.nextDouble();
            OperacionesMatDouble op = new OperacionesMatDouble(valor);
            ejecutarMenu(scanner, op, Double.class);
        } else {
            System.out.println("Tipo de dato no válido.");
        }

        scanner.close();
    }

    public static <E extends Number> void ejecutarMenu(Scanner scanner, Operable<E> op, Class<E> tipoClase) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\nMenú de Operaciones:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Producto");
            System.out.println("4. División");
            System.out.println("5. Potencia");
            System.out.println("6. Raíz Cuadrada");
            System.out.println("7. Raíz Cúbica");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 5) {
                System.out.print("Ingrese el segundo valor: ");
                E otro = leerValor(scanner, tipoClase);

                switch (opcion) {
                    case 1:
                        System.out.println("Resultado: " + op.suma(otro));
                        break;
                    case 2:
                        System.out.println("Resultado: " + op.resta(otro));
                        break;
                    case 3:
                        System.out.println("Resultado: " + op.producto(otro));
                        break;
                    case 4:
                        System.out.println("Resultado: " + op.division(otro));
                        break;
                    case 5:
                        System.out.println("Resultado: " + op.potencia(otro));
                        break;
                }
            } else if (opcion == 6) {
                System.out.println("Resultado: " + op.raizCuadrada());
            } else if (opcion == 7) {
                System.out.println("Resultado: " + op.raizCubica());
            } else if (opcion == 8) {
                salir = true;
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    public static <E extends Number> E leerValor(Scanner scanner, Class<E> tipoClase) {
        if (tipoClase == Integer.class) {
            return tipoClase.cast(scanner.nextInt());
        } else if (tipoClase == Double.class) {
            return tipoClase.cast(scanner.nextDouble());
        } else {
            throw new IllegalArgumentException("Tipo de dato no soportado.");
        }
    }
}