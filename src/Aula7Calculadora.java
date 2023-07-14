public class Aula7Calculadora<T> {
    private T[] elementos;
    private int topo;

    @SuppressWarnings("unchecked")
    public Aula7Calculadora(int capacidade) {
        elementos = (T[]) new Object[capacidade];
        topo = -1;
    }

    public void push(T elemento) {
        if (isFull()) {
            throw new IllegalStateException("A pilha está cheia.");
        }
        elementos[++topo] = elemento;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia.");
        }
        T elemento = elementos[topo];
        elementos[topo--] = null; // Remover o elemento do array e atualizar o topo
        return elemento;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia.");
        }
        return elementos[topo];
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == elementos.length - 1;
    }

    public int size() {
        return topo + 1;
    }
}
