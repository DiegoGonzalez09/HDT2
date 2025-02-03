/**
 * Implementación de una calculadora que evalúa expresiones en notación postfija.
 */
public class PostfixCalculator implements ICalculadora {
    private IStack<Integer> stack;
    
    /**
     * Constructor que inicializa la calculadora con una pila dada.
     * 
     * @param stack la pila utilizada para la evaluación de la expresión
     */
    public PostfixCalculator(IStack<Integer> stack) {
        this.stack = stack;
    }
    
    /**
     * Evalúa una expresión en notación postfija.
     * 
     * @param expression la expresión en notación postfija a evaluar
     * @return el resultado de la evaluación
     * @throws Exception si la expresión es inválida o hay errores durante la evaluación
     */
    @Override
    public int evaluate(String expression) throws Exception {
        // Añadir manejo explícito de expresiones vacías
        if (expression == null || expression.trim().isEmpty()) {
            throw new CalculatorException("La expresión no puede estar vacía");
        }
        
        String[] tokens = expression.trim().split("\\s+");
        
        for (String token : tokens) {
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new Exception("Operandos insuficientes para el operador: " + token);
                }
                int operandB = stack.pop();
                int operandA = stack.pop();
                int result = performOperation(operandA, operandB, token);
                stack.push(result);
            } else {
                try {
                    stack.push(Integer.parseInt(token));
                } catch (NumberFormatException e) {
                    throw new Exception("Operando inválido: " + token);
                }
            }
        }
        
        if (stack.size() != 1) {
            throw new Exception("Expresión inválida: demasiados operandos");
        }
        
        return stack.pop();
    }
    
    /**
     * Verifica si un token es un operador aritmético válido.
     * 
     * @param token el token a evaluar
     * @return true si es un operador, false en caso contrario
     */
    private boolean isOperator(String token) {
        return token.matches("[+\\-*/%]");
    }
    
    /**
     * Realiza la operación aritmética entre dos operandos.
     * 
     * @param a el primer operando
     * @param b el segundo operando
     * @param operator el operador a aplicar
     * @return el resultado de la operación
     * @throws Exception si se encuentra un operador desconocido o hay una operación inválida
     */
    private int performOperation(int a, int b, String operator) throws Exception {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) throw new Exception("División por cero");
                return a / b;
            case "%":
                if (b == 0) throw new Exception("Módulo por cero");
                return a % b;
            default:
                throw new Exception("Operador desconocido: " + operator);
        }
    }
}
