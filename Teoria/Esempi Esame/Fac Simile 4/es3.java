public class es3 {

    public static void main(String[] args) {
        Node<Integer> n = new Node<Integer>(1, null);
        n = new Node<Integer>(3, n);
        n = new Node<Integer>(4, n);
        n = new Node<Integer>(5, n);
        //System.out.println(n.toString());
        es3.metodo(n, 0);
        //System.out.println(n.toString());
    }

    public static <T extends Comparable<T>> void metodo(Node<T> p, T x) {
        assert check(p, x) : "Errore";
        while (x.compareTo(p.elem) < 0)
            p = p.next;
        p.next = null;
    }

    public static <T extends Comparable<T>> boolean check(Node<T> p, T x) {
        if (x == null)
            return false;

        while (p != null && x.compareTo(p.elem) < 0) {
            p = p.next;
        }
        return p != null;
    }

}

class Node<T> {
    public T elem;
    public Node<T> next;

    public Node(T elem, Node<T> next) {
        this.elem = elem;
        this.next = next;
    }

    public String toString() {
        return elem + " " + next.toString();
    }

}
