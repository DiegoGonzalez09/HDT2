import java.util.Vector;

/**
 * Implementación de una pila utilizando un Vector como estructura de datos subyacente.
 * @param <T> Tipo de elementos almacenados en la pila
 */
public class VectorStack<T> implements IStack<T> {
    private Vector<T> vector;
    
    /**
     * Constructor que inicializa la pila con un nuevo vector.
     */
    public VectorStack() {
        vector = new Vector<>();
    }
    
    @Override
    public void push(T item) {
        vector.add(item);
    }
    
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return vector.remove(vector.size() - 1);
    }
    
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return vector.get(vector.size() - 1);
    }
    
    @Override
    public boolean isEmpty() {
        return vector.size() == 0;
    }
    
    @Override
    public int size() {
        return vector.size();
    }
}
