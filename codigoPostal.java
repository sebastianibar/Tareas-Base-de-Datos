import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class codigoPostal {
    public static final String SEPARATOR = ","; //separador que usa el CSV
    public static final String QUOTE = "\""; //esto es para comillas, lo puse ms que nada por si se me ofrece mas adelante

    public static void main(String[] args) {
        String archivo = "codigos_postales_hmo.csv";
        //creamos un HashMap para contar cuantas veces se repit eel codigo postal
        Map<String, Integer> conteo = new HashMap<>();

        //utilizamos BufferedReader para leer el archivo, y seleciconamos la ruta correspondiente
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line; //nos permite leer por lineas el archivo

            while ((line = br.readLine()) != null) { // nos permite leer lineas del documento mientras haya
                String[] fields = line.split(SEPARATOR); //// divide la línea por comas para poder identificar las columnas en un arreglo
                    String codigoP = fields[0]; // aquí usas la columna que corresponda

                   
                    int cantAct = conteo.getOrDefault(codigoP, 0); // es el valor default, que es 0
                    cantAct++;                                     // incrementa en 1 sucesivamente dependiendo las veces que se reputa
                    conteo.put(codigoP, cantAct);                 // guarda de nuevo en Hash
                
            }
        } catch (Exception e) {
            e.printStackTrace(); //es mas que nada por si algo sale mal
        }

        for (Map.Entry<String, Integer> entry : conteo.entrySet()) { //el for nos permite recorrer todos los elementos del hash, para asi imprimir cada código postal con su conteo correspondiente.
            System.out.println("Codigo postal: " + entry.getKey() + " - Numero de asentamientos: " + entry.getValue());
             //entry.getKey() → devuelve el código postal 
             //entry.getValue() → devuelve cuántas veces apareció ese código postal

             //las keys las utilizamos para que solo imprima una vez el codigo postal, con su respectivo contador
        }
    }
}

