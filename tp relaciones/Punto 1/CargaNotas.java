import java.util.ArrayList;
import java.util.Scanner;

public class CargaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Alumno> alumnos = new ArrayList<>();

        System.out.print("Ingrese la cantidad de alumnos: ");
        int cantidadAlumnos = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.print("Ingrese nombre completo del alumno: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el legajo: ");
            long legajo = scanner.nextLong();
            scanner.nextLine();

            Alumno alumno = new Alumno(nombre, legajo);
            System.out.print("Ingrese la cantidad de notas del alumno: ");
            int cantidadNotas = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < cantidadNotas; j++) {
                System.out.print("Ingrese la cátedra: ");
                String catedra = scanner.nextLine();
                System.out.print("Ingrese la nota: ");
                double notaExamen = scanner.nextDouble();
                scanner.nextLine();

                alumno.agregarNota(new Nota(catedra, notaExamen));
            }

            alumnos.add(alumno);
        }

        System.out.println("\nInformación de los alumnos:");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
            System.out.println();
        }

        scanner.close();
    }
}
