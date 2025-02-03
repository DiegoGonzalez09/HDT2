import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase principal que permite seleccionar un archivo de una carpeta específica,
 * leer expresiones matemáticas en notación postfija desde el archivo y evaluarlas.
 */
public class Main {
    
    /**
     * Muestra una lista de archivos disponibles en la carpeta "src/resources" y
     * permite al usuario seleccionar uno.
     * 
     * @return La ruta absoluta del archivo seleccionado.
     */
    private static String selectFile() {
        File folder = new File("src/resources");
        File[] files = folder.listFiles();
        
        if (files == null || files.length == 0) {
            System.out.println("No hay archivos en la carpeta resources");
            System.exit(1);
        }

        System.out.println("Archivos disponibles:");
        for (int i = 0; i < files.length; i++) {
            System.out.printf("%d. %s%n", i + 1, files[i].getName());
        }

        Scanner scanner = new Scanner(System.in);
        int selection;
        do {
            System.out.print("Seleccione un archivo (1-" + files.length + "): ");
            selection = scanner.nextInt();
        } while (selection < 1 || selection > files.length);

        return files[selection - 1].getPath();
    }

    /**
     * Método principal que gestiona la lectura del archivo seleccionado,
     * evalúa cada expresión en notación postfija y muestra el resultado.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        try {
            // Creación de la pila y la calculadora para evaluar expresiones postfijas.
            IStack<Integer> stack = new VectorStack<>();
            ICalculadora calculator = new PostfixCalculator(stack);
            
            // Selección del archivo a procesar.
            String selectedFile = selectFile();
            BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
            String expression;
            int lineNumber = 1;
            
            // Lectura y evaluación de cada línea del archivo.
            while ((expression = reader.readLine()) != null) {
                try {
                    int result = calculator.evaluate(expression);
                    System.out.printf("Expresión %d: %s = %d%n", lineNumber, expression, result);
                } catch (Exception e) {
                    System.err.printf("Error en línea %d: %s%n", lineNumber, e.getMessage());
                }
                lineNumber++;
            }
            reader.close();
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
