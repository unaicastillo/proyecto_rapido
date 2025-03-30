import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;

public class GestionFicheros {
    //static String  pathInput = "input/";
    static String pathOutput = "output/";

    public static ArrayList leerXml(String pathInput) throws ParserConfigurationException, SAXException, IOException{
        File fXml = new File(pathInput+"coches.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXml);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("coche");
       
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>(); 
        HashMap<String, String> mapaCoches;

        for(int i = 0 ; i < nList.getLength(); i++){
            Node node = nList.item(i);
            
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                mapaCoches = new HashMap<>();               

                
                String marca = element.getElementsByTagName("Marca").item(0).getTextContent();
                String modelo = element.getElementsByTagName("Modelo").item(0).getTextContent();
                String color = element.getElementsByTagName("Color").item(0).getTextContent();

                String precio = element.getElementsByTagName("Precio").item(0).getTextContent();
                
                mapaCoches.put("Marca", marca);
                mapaCoches.put("Modelo", modelo);
                mapaCoches.put("Color", color);
                mapaCoches.put("Precio", precio);

                arrayList.add(mapaCoches); 

                
            }

            


        } 
        return arrayList;
        
    } 


    public static ArrayList leerCsv(String pathInput){
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        String archivoCsv = pathInput+"coches.csv"; 
        HashMap<String, String> mapaCoches ;
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCsv))) {
            String line;
            String lineReader=br.readLine();
            String[] encabezados = lineReader.split(","); 

            while ((line = br.readLine()) != null) {
                mapaCoches = new HashMap<>();
                String[] valores = line.split(",");
                
                
                for (int i = 0; i < encabezados.length; i++) {
                    mapaCoches.put(encabezados[i], valores[i]); 
                }
                
                
                arrayList.add(mapaCoches);
                
            }

            


        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        return arrayList;

    }




    public static ArrayList leerJson(String pathInput){
        JSONParser parser = new JSONParser();
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        HashMap<String, String> mapaCoches;
        try {
            JSONArray arrayJson = (JSONArray) parser.parse(new FileReader(pathInput + "coches.json"));

            for (int i = 0; i < arrayJson.size(); i++) {
                mapaCoches = new HashMap<>();
                JSONObject jsonObject = (JSONObject) arrayJson.get(i);
                
                String marca = (String) jsonObject.get("Marca");
                String modelo = (String) jsonObject.get("Modelo");
                String color = (String) jsonObject.get("Color");
                Long anio = (Long) jsonObject.get("Año");
                Double precio = (Double) jsonObject.get("Precio");
                mapaCoches.put("Marca", marca);
                mapaCoches.put("Modelo", modelo);
                mapaCoches.put("Color", color);
                mapaCoches.put("Año", ""+anio);
                mapaCoches.put("Precio", ""+precio);
                arrayList.add(mapaCoches);

            }
            

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arrayList;

    }

    

    public static void  pintarArrayList(ArrayList arrayList){
        for (int i = 0; i < arrayList.size(); i++) {
            HashMap<String, String> mapaCoches = (HashMap<String, String>) arrayList.get(i);
            System.out.println("Marca: " + mapaCoches.get("Marca") + ", Modelo: " + mapaCoches.get("Modelo")+ ", Año: "+ mapaCoches.get("Año") + ", Color: " + mapaCoches.get("Color") + 
            ", Precio: " + mapaCoches.get("Precio"));
        }
    }


    public static void escribirCsv(ArrayList<HashMap<String, String>> lista) {
        String archivoCsv = pathOutput+"coches.csv";
        
        
        PrintWriter writer;
        try {
            writer = new PrintWriter(archivoCsv, "UTF-8");
            
            
            writer.println("Marca,Modelo,Año,Color,Precio");
            
            for (int i = 0 ; i < lista.size(); i++) {
                HashMap<String, String> mapaCoches = lista.get(i);
                writer.println(mapaCoches.get("Marca") + "," + mapaCoches.get("Modelo") + "," + mapaCoches.get("Año") + "," + mapaCoches.get("Color") + "," + mapaCoches.get("Precio"));
            }
            
            writer.close();
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   
    }
    public static void escribirXml(ArrayList<HashMap<String, String>> lista) {
        String archivoXml = pathOutput+"coches.xml";


       
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            FileOutputStream output = new FileOutputStream(archivoXml);
            Element rootElement, cocheElement, marcaCoche, modeloCoche, anioCoche, colorCoche, precioCoche;
            rootElement = doc.createElement("coches");

            HashMap<String, String> mapaCoches ;
            doc.appendChild(rootElement);
            

            for (int i = 0; i < lista.size(); i++) {
                mapaCoches = lista.get(i);
                cocheElement = doc.createElement("coche");

                rootElement.appendChild(cocheElement);
                
                marcaCoche= doc.createElement("Marca");
                marcaCoche.appendChild(doc.createTextNode(mapaCoches.get("Marca")));
                cocheElement.appendChild(marcaCoche);

                modeloCoche= doc.createElement("Modelo");
                modeloCoche.appendChild(doc.createTextNode(mapaCoches.get("Modelo")));
                cocheElement.appendChild(modeloCoche);

                anioCoche= doc.createElement("Año");
                anioCoche.appendChild(doc.createTextNode(mapaCoches.get("Año")));
                cocheElement.appendChild(anioCoche);

                colorCoche= doc.createElement("Color");
                colorCoche.appendChild(doc.createTextNode(mapaCoches.get("Color")));
                cocheElement.appendChild(colorCoche);

                precioCoche= doc.createElement("Precio");
                precioCoche.appendChild(doc.createTextNode(mapaCoches.get("Precio")));
                cocheElement.appendChild(precioCoche);
            }


            
            





            saveFile(doc, output);
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }


    private static void saveFile(Document doc, OutputStream filePath) {
        try {
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(filePath);

            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void escribirJson(ArrayList lista) {
        String archivoJson = pathOutput+"coches.json";
        List<JSONObject> jsonObj = new ArrayList<JSONObject>();
        HashMap<String, String> mapaCoches; 
        JSONObject obj;

        
        try {
            FileWriter file = new FileWriter(archivoJson);
            ObjectMapper objectMapper = new ObjectMapper();
            String json;
            json = objectMapper.writeValueAsString(lista);
                        
            file.write(json);
            file.close();


        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
        
    
    }
}
