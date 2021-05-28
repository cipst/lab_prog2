/* Implementare un metodo 'elimina' che elimina da una lista di
 * numeri tutti gli elementi preceduti da un elemento piu` grande.
 *
 * Ecco alcuni esempi di liste prima e dopo l'esecuzione del metodo:
 *
 * prima :
 * dopo  :
 *
 * prima : 7
 * dopo  : 7
 *
 * prima : 3, 7, 1
 * dopo  : 3, 7
 *
 * prima : 7, 3, 4, 9, 1
 * dopo  : 7, 9
 *
 * NON E` CONSENTITO:
 * - usare break o continue all'interno di cicli
 * - usare strutture dati ausiliarie (ad esempio array)
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

    public void elimina() {
        if (first != null) {
            // il primo elemento non è preceduto da nulla ==> rimane sempre nella lista
            Node max = first;
            int m = first.getElem();

            // quindi parto dal secondo elemento
            Node q = first.getNext();

            // vaod avanti finché non arrivo all'ultimo elemento
            while (q != null) {

                // se l'elemento di q è > di m ==> quel nodo diventa il massimo
                if (q.getElem() > m) {
                    m = q.getElem(); // il massimo diventa questo elemento
                    max.setNext(q); // il successivo del nodo massimo diventa questo nodo
                    max = max.getNext(); // il massimo adesso diventa questo nodo
                }

                // se il nodo dopo q è null, vuol dire che sono alla fine
                // quindi il next del nodo massimo diventa null
                // perchè tanto il controllo per verificare se q fosse il massimo l'ho fatto
                // sopra, quindi mi rimane solo assicurarmi che il massimo punti a null in modo
                // tale da non avere altri elementi tra l'ultimo nodo massimo e la fine della
                // lista (identificata da null)
                if (q.getNext() == null) {
                    max.setNext(null);
                }

                q = q.getNext(); // mi sposto al nodo successivo
            }
        }
    }
}

public class Main1 {
    public static void main(String[] args) {
        test(crea(), "");
        test(crea(7), "7");
        test(crea(3, 7, 1), "3, 7");
        test(crea(7, 3, 4, 9, 1), "7, 9");
        test(crea(7, 3, 4, 9, 1, 2, 10), "7, 9, 10");
        test(crea(7, 8, 4, 9, 1, 2, 3), "7, 8, 9");
    }

    public static void test(List l, String atteso) {
        System.out.println("lista    : " + l);
        l.elimina();
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
