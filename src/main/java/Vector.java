/**
 * Interfaz que define las operaciones básicas de una pila (stack).
 * @param <T> Tipo genérico de los elementos almacenados en la pila
 */
public interface Vector<T> {
    /**
     * Añade un elemento al tope de la pila.
     * @param item El elemento a añadir
     */
    void push(T item);

    /**
     * Remueve y retorna el elemento del tope de la pila.
     * @return El elemento del tope
     * @throws IllegalStateException si la pila está vacía
     */
    T pop();

    /**
     * Retorna el elemento del tope sin removerlo.
     * @return El elemento del tope
     * @throws IllegalStateException si la pila está vacía
     */
    T peek();

    /**
     * Verifica si la pila está vacía.
     * @return true si la pila está vacía, false en caso contrario
     */
    boolean isEmpty();

    /**
     * Retorna el número de elementos en la pila.
     * @return La cantidad de elementos
     */
    int size();
}
