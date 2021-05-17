public class Cons extends List {
    private int elem; // Elemento memorizzato
    private List next; // Riferimento al nodo successore

    public Cons(int elem, List next) {
        this.elem = elem;
        this.next = next;
    }

    public String toString() {
        return elem + ", " + next.toString();
    }

    public List insert(int n, int x) throws IndexOutOfBoundsException {
        try {
            if (x < 0)
                throw new IndexOutOfBoundsException("Non puoi inserire un elemento in posizione " + x);
            if (x == 0)
                return new Cons(n, this);
            else
                return new Cons(elem, next.insert(n, x - 1));
        } catch (IndexOutOfBoundsException err) {
            System.out.println(err);
        }
        return this;
    }
}
