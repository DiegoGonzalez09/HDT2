import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase principal que ejecuta la calculadora postfix.
 * Lee expresiones desde un archivo y muestra los resultados.
 */
public class Main {
    public static void main(String[] args) {
        try {
            // Inicializar calculadora
            IStack<Integer> stack = new VectorStack<>();
            IPostfixCalculator calculator = new PostfixCalculator(stack);
            
            // Leer archivo
            BufferedReader reader = new BufferedReader(new FileReader("src/resources/datos.txt"));
            String expression;
            int lineNumber = 1;
            
            // Procesar cada línea
            while ((expression = reader.readLine()) != null) {
                try {
                    int result = calculator.evaluateExpression(expression);
                    System.out.printf("Expresión %d: %s = %d%n", lineNumber, expression, result);
                } catch (CalculatorException e) {
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
