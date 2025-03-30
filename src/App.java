import java.io.File;
import java.util.Scanner;

public class App {
    
    public static Scanner sc = new Scanner(System.in);
    public static boolean continuar=true;   //Usado para controlar el bucle de los menús
    public static void main(String[] args) throws Exception {
        System.out.println("Hello");
        menuPrincipal();

    }
    
    // MENÚ PRINCIPAL
    public static void menuPrincipal(){

        continuar=true;
        while(continuar){
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

            switch (sc.nextInt()) {
                case 1: 
                    System.out.println("opcion 1");
                case 2: 
                    System.out.println("opcion 2");
                case 3:
                    System.out.println("opcion 3");

                case 0:
                    continuar=false;
                default:
                    System.out.println("opcion incorrecta, vuelve a intentarlo.");
            }
        }
    }

    //Menú para elegir el tipo de archivo al que se quiere convertir
    public static void menuConverion(){

        continuar=true;
        while(continuar){
            System.out.println("   ________________________");
            System.out.println("  |     MENÚ CONVERSIÓN    |");
            System.out.println("  |________________________|");
            System.out.println("   |  1. CSV              |");
            System.out.println("   |  2. JSON             |");
            System.out.println("   |  3. XML              |");
            System.out.println("   |  0. Salir.           |");
            System.out.println("   \\______________________/");

            switch (sc.nextInt()) {
                case 1: 
                    System.out.println("opcion 1");
                    continuar=false;
                    break;
                case 2: 
                    System.out.println("opcion 2");
                    continuar=false;
                    break;
                case 3:
                    System.out.println("opcion 3");
                    continuar=false;
                    break;
                case 0:
                    continuar=false;
                    break;
                default:
                    System.out.println("opcion incorrecta, vuelve a intentarlo.");
                    break;  
            }

        }
        continuar=true;

    }
}
