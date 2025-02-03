/**
 * Interfaz para la calculadora de expresiones postfix.
 * Define el método principal para evaluar expresiones matemáticas en notación postfija.
 */
public interface IPostfixCalculator {
    /**
     * Evalúa una expresión matemática en notación postfija.
     * @param expression La expresión a evaluar en formato String
     * @return El resultado de la evaluación
     * @throws CalculatorException Si hay un error en el formato o cálculo de la expresión
     */
    int evaluateExpression(String expression) throws CalculatorException;
}
