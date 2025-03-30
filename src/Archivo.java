import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Archivo {
    public ArrayList<HashMap<String,String>> lista;
    public HashMap<String, String> mapa;
    public String path;
    public String formato;


    public Archivo(ArrayList<HashMap<String,String>> lista, String path, String formato) {
        this.lista = lista;
        this.path = path;
        this.formato = formato;
    }

    public ArrayList<HashMap<String,String>> getLista() {
        return this.lista;
    }

    public void setLista(ArrayList<HashMap<String,String>> lista) {
        this.lista = lista;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFormato() {
        return this.formato;
    }

    public void setFormato(String formato) {    
        this.formato = formato;
    }

    
    

   
}