/**
 * Excepción personalizada para errores de la calculadora.
 */
public class CalculatorException extends Exception {
    /**
     * Constructor que acepta un mensaje de error.
     * @param message El mensaje describiendo el error
     */
    public CalculatorException(String message) {
        super(message);
    }
}
