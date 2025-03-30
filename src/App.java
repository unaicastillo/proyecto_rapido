import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class App {

    public static Scanner sc = new Scanner(System.in);
    public static String directory = "input/";

    public static void main(String[] args) throws Exception {

        menuPrincipal();

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
        boolean continuar = false;
        int opcion = sc.nextInt();
        do {

            switch (opcion) {
                case 1:
                    System.out.println("Seleccionar carpeta...");
                    directory = selectCarpeta();
                    break;
                case 2:
                    seleccionarFichero();
                    break;
                case 3:
                    System.out.println("Llendo al menu de conversion...");
                    menuConverion();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    continuar = true;
                    break;
                default:
                    System.out.println("opcion incorrecta, vuelve a intentarlo.");

            }
        } while (continuar == false);

    }

    // Menú para elegir el tipo de archivo al que se quiere convertir
    public static void menuConverion() {
        boolean continuar = false;

        try {

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
                int opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Convirtiendo a CSV...");
                        GestionFicheros.escribirCsv(GestionFicheros.leerCsv(directory));
                        break;
                    case 2:
                        System.out.println("Convirtiendo a JSON...");
                        GestionFicheros.escribirJson(GestionFicheros.leerJson(directory));
                        break;
                    case 3:
                        System.out.println("Convirtiendo a XML...");
                        GestionFicheros.escribirXml(GestionFicheros.leerXml(directory));
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        menuPrincipal();
                    default:
                        System.out.println("opcion incorrecta, vuelve a intentarlo.");

                }
            } while (continuar == false);
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void seleccionarFichero() {
        System.out.println("Seleccionando fichero...");
        System.out.println("   ________________________");
        System.out.println("  |     MENÚ Ficheros      |");
        System.out.println("  |________________________|");
        System.out.println("   |  1. CSV              |");
        System.out.println("   |  2. JSON             |");
        System.out.println("   |  3. XML              |");
        System.out.println("   |  0. Salir.           |");
        System.out.println("   \\______________________/");
        System.out.println("Introduce la opción que quieras realizar: ");
        int opcion = sc.nextInt();
        boolean continuar = false;
        ArrayList arrayList = null;
        try {
            do {

                switch (opcion) {
                    case 1:
                        arrayList = GestionFicheros.leerCsv(directory);
                        break;
                    case 2:
                        arrayList = GestionFicheros.leerJson(directory);
                        break;
                    case 3:
                        arrayList = GestionFicheros.leerXml(directory);
                        break;
                    case 0:
                        System.out.println("Opcopm elegida: " + opcion + ", Saliendo...");
                        menuPrincipal();
                    default:
                        System.out.println("opcion incorrecta, vuelve a intentarlo.");
                }

                if (arrayList != null) {
                    GestionFicheros.pintarArrayList(arrayList);
                    arrayList = null;
                    menuPrincipal();
                }

            } while (continuar == false);
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String selectCarpeta() {
        System.out.println(
                "Escribe el nombre de la carpeta a utilizar (nota, por defecto los ficheros se encuentran en input y si no se da valor utilizara esta ruta por defecto): ");
        String nombreCarpeta = sc.nextLine();

        return nombreCarpeta;

    }
}
