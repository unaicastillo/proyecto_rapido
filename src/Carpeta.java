public class Carpeta {
    private String path;
    private String nombre;
    
    public Carpeta(String path, String nombre){
        this.path=path;
        this.nombre=nombre;
    }


    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

