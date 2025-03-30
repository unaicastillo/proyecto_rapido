import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        
        ArrayList arrayList = new ArrayList<>();
        System.out.println("CSV");
        arrayList=GestionFicheros.leerCsv();
        GestionFicheros.pintarArrayList(arrayList);
        System.out.println("XML");
        arrayList=GestionFicheros.leerXml();
        GestionFicheros.pintarArrayList(arrayList);
        System.out.println("JSON");
        arrayList=GestionFicheros.leerJson();
        GestionFicheros.pintarArrayList(arrayList);

        GestionFicheros.escribirCsv(arrayList);
        GestionFicheros.escribirXml(arrayList);

        
    }
}
