import java.util.Scanner;

public class App {
    
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            menuPrincipal();
            opcion = sc.nextInt();
            sc.nextLine();  // Consume newline
            switch (opcion) {
                case 1:
                    System.out.println("opcion 1");
                case 2:
                    System.out.println("opcion 2");
                case 3:
                    menuConverion();
                case 0:
                    System.out.println("Saliendo...");
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
        while (opcion != 0);
        sc.close();
    }

    private static void menuPrincipal() {
        System.out.println("   ________________________");
        System.out.println("  |                        |");
        System.out.println("  |     MENÚ PRINCIPAL     |");
        System.out.println("  |________________________|");
        System.out.println(" /                         \\");
        System.out.println("|  1. Seleccionar carpeta.  |");
        System.out.println("|  2. Letura de fichero.    |");
        System.out.println("|  3. Conversión a...       |");
        System.out.println("|  0. Salir.                |");
        System.out.println(" \\_________________________/");
        System.out.print("Elije una opción: ");
    }

    //Menú para elegir el tipo de archivo al que se quiere convertir
    public static void menuConverion(){
        boolean continuar = true;
        do {
            System.out.println("   ________________________");
            System.out.println("  |     MENÚ CONVERSIÓN    |");
            System.out.println("  |________________________|");
            System.out.println("   |  1. CSV              |");
            System.out.println("   |  2. JSON             |");
            System.out.println("   |  3. XML              |");
            System.out.println("   |  0. Salir.           |");
            System.out.println("   \\______________________/");
            System.out.println("Introduce la opción que quieras realizar: ");
            

            switch (sc.nextInt()) {
                case 1: 
                    System.out.println("Convirtiendo a CSV...");
                    continuar = false;
                case 2: 
                    System.out.println("Convirtiendo a JSON...");
                    continuar = false;
                case 3:
                    System.out.println("Convirtiendo a XML...");
                    continuar = false;
                case 0:
                    System.out.println("Saliendo...");
                    continuar = false;
                default:
                    System.out.println("opcion incorrecta, vuelve a intentarlo.");

            }
        } while (continuar);

    }
}
