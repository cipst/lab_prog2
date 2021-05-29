/* Implementare un metodo 'modifica' che elimina tutti gli elementi
 * negativi di una lista.
 *
 * Ecco alcuni esempi di liste prima e dopo l'esecuzione del metodo:
 *
 * prima :
 * dopo  :
 *
 * prima : 5, -5
 * dopo  : 5
 *
 * prima : -3, 2, -1, 5
 * dopo  : 2, 5
 *
 * prima : -3, -1, -4
 * dopo  :
 *
 * NON E` CONSENTITO:
 * - usare break o continue all'interno di cicli
 * - usare strutture dati ausiliarie (ad esempio array)
 * - creare nodi oltre a quelli gia` presenti nella lista
 * - modificare il codice al di fuori dal metodo da implementare
 *
 */

class Node {
    private int elem;
    private Node next;

    public Node(int elem, Node next) {
        this.elem = elem;
        this.next = next;
    }

    public int getElem() {
        return elem;
    }

    public void setElem(int elem) {
        this.elem = elem;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class List {
    private Node first;

    public List() {
        first = null;
    }

    public void insertFirst(int elem) {
        first = new Node(elem, first);
    }

    public String toString() {
        String s = "";
        for (Node p = first; p != null; p = p.getNext()) {
            if (p != first)
                s += ", ";
            s += p.getElem();
        }
        return s;
    }

    public void modifica() {
        if (first != null) {
            // il primo elemento suppongo sia accettabile
            Node p = first;
            
            // prendo il next del primo
            Node q = first.getNext();

            // vado avanti finchè next != null
            while (q != null) {

                // se l'elemento del next è > 0 --> setto il next di p a questo q
                // mi sposto su p
                if (q.getElem() > 0) {
                    p.setNext(q);
                    p = p.getNext();
                } else {
                    // altrimenti questo q non è accettabile --> setto il next di p al next di q
                    // ipotizzando che il next di q sia accettabile
                    // lo andrò a vedere nell'iterazione successiva
                    p.setNext(q.getNext());
                }

                q = q.getNext();
            }

            // controllo che il primo elemento sia accettabile
            // altrimenti sposto il first al suo successivo
            if (first.getElem() < 0) {
                first = first.getNext();
            }

        }
    }
}

public class Main3 {
    public static void main(String[] args) {
        test(crea(), "");
        test(crea(5, -5), "5");
        test(crea(-3, 2, -1, 5), "2, 5");
        test(crea(-3, -1, -4), "");
        test(crea(-3, -1, -4, -5, -7, -1, -4), "");
        test(crea(1, -1, -4, -5, -7, -1, -4), "1");
        test(crea(1, -1, -4, -5, -7, -1, 2), "1, 2");
        test(crea(1, -1, -4, 7, 3, -1, 2), "1, 7, 3, 2");
    }

    public static void test(List l, String atteso) {
        System.out.println("lista    : " + l);
        l.modifica();
        System.out.println("ottenuto : " + l);
        System.out.println("atteso   : " + atteso);
        System.out.println(l.toString().equals(atteso) ? "=== OK" : "=== ERRORE");
        System.out.println();
    }

    public static List crea(Integer... v) {
        List l = new List();
        for (int i = v.length - 1; i >= 0; i--)
            l.insertFirst(v[i]);
        return l;
    }
}
