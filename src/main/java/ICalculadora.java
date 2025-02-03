/**
 * Interfaz que define la operación de evaluación de expresiones en notación postfija.
 */
public interface ICalculadora {

    /**
     * Evalúa una expresión en notación postfija y devuelve el resultado.
     * 
     * @param expression La expresión en notación postfija a evaluar.
     * @return El resultado de la evaluación.
     * @throws Exception Si la expresión contiene operadores inválidos o si hay un error en la evaluación.
     */
    int evaluate(String expression) throws Exception;
}
