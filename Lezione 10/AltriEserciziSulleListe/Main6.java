/* 
 * Implementare un metodo moveMaxToEnd() che, in una lista di oggetti di tipo T, 
 * (dove T implementa Comparable) muove in ultima posizione l'elemento massimo
 *
 * Si assuma che l'elemento di un nodo non sia mai null.
 *
 * Seguono alcuni esempi di risultati attesi da moveMaxToEnd().
 *
 * lista  :
 * atteso :
 *
 * lista  : 1
 * atteso : 1
 *
 * lista  : 2, 1
 * atteso : 1, 2
 *
 * lista  : 2, 3, 1, 3, 2
 * atteso : 2, 1, 3, 2, 3
  *
 * Non e` consentito usare break o continue all'interno di
 * cicli.
 *
 * Non e` consentito modificare in alcun modo il codice al di fuori
 * del metodo "moveMaxToEnd".
 *
 */

class Node<T> {
    public T elem;
    public Node<T> next;

    public Node(T elem, Node<T> next) {
        this.elem = elem;
        this.next = next;
    }
}

class List<T extends Comparable<T>> {
    private Node<T> first;

    public List() {
        first = null;
    }

    public void insertFirst(T elem) {
        first = new Node<>(elem, first);
    }

    public String toString() {
        String s = "";
        for (Node<T> p = first; p != null; p = p.next) {
            if (p != first)
                s += ", ";
            s += p.elem;
        }
        return s;
    }

    public void moveMaxToEnd() {
        // devo apportare modifiche solo se ho una lista NON nulla
        if (first != null) {

            // prevMax contiene il nodo prima del massimo
            Node<T> prevMax = null;

            // max contiene il nodo massimo (supopongo che il max sia il primo nodo)
            Node<T> max = first;

            // parto dal first
            Node<T> p = first;

            // se first ha un next allora passo a controllare ciò che viene dopo;
            // altrimenti la lista ha un solo elemento: OK
            if (p.next != null) {
                while (p.next != null) {

                    // se max.elem è più piccolo di p.next.elem ==> p.next diventa il nodo massimo
                    // e p diventa il precedente di max
                    if (max.elem.compareTo(p.next.elem) == -1) {
                        max = p.next;
                        prevMax = p;
                    }

                    p = p.next;
                }

                // se prevMax è null vuol dire che il massimo è in prima posizione
                // --> sposto il massimo al nodo successivo ('cancellando' il massimo)
                // altrimenti il nodo massimo è all'interno della lista
                // --> il next del precedente del massimo diventa il next del massimo
                // ('cancellando' il massimo)
                if (prevMax == null)
                    first = first.next;
                else
                    prevMax.next = max.next;

                // p rappresenta l'ultimo nodo della lista
                // quindi faccio puntare il next dell'ultimo nodo al massimo
                // e il next del massimo a null
                p.next = max;
                max.next = null;
            }
        }
    }
}

public class Main6 {
    public static void main(String[] args) {
        test(crea(), "");
        test(crea(1), "1");
        test(crea(2, 1), "1, 2");
        test(crea(2, 3, 1, 3, 2), "2, 1, 3, 2, 3");
        test(crea(2, 3, 1, 1, 4, 2), "2, 3, 1, 1, 2, 4");
        test(crea(5, 3, 1, 1, 4, 2), "3, 1, 1, 4, 2, 5");
        test(crea(5, 3, 1, 6, 4, 2), "5, 3, 1, 4, 2, 6");
    }

    private static void test(List<Integer> l, String atteso) {
        System.out.println("lista    : " + l);
        l.moveMaxToEnd();
        System.out.println("ottenuto : " + l);
        System.out.println("atteso   : " + atteso);
        System.out.println(l.toString().equals(atteso) ? "=== OK" : "=== ERRORE");
        System.out.println();
    }

    @SafeVarargs
    private static <T extends Comparable<T>> List<T> crea(T... v) {
        List<T> l = new List<>();
        for (int i = v.length - 1; i >= 0; i--)
            l.insertFirst(v[i]);
        return l;
    }
}
