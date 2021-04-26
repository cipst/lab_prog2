public class NodeUtil<T> {

    public static <T> int size(Node<T> p) {
        if (p == null)
            return 0;
        else
            return 1 + size(p.getNext());
    }// size()

    public static <T> int occurrences(Node<T> p, T x) {
        if (p == null)
            return 0;
        else
            return ((x.equals(p.getElem()) ? 1 : 0) + occurrences(p.getNext(), x));
    }// occurrences()

    public static <T> boolean included(Node<T> p, Node<T> q) {
        while (p != null && q != null) {
            if (p.getElem().equals(q.getElem())) {
                p = p.getNext();
            }
            q = q.getNext();
        }
        return p == null;
    }// included()

    public static <T> Node<T> reverse(Node<T> p) {
        Node<T> tmp = null;
        while (p != null) {
            tmp = new Node<T>(p.getElem(), tmp);
            p = p.getNext();
        }
        return tmp;
    }// reverse()

    public static <T> void printList(Node<T> p) {
        while (p != null) {
            System.out.print(p.getElem() + ", ");
            p = p.getNext();
        }
    }// printList()

    public static <T> Node<Integer> cardinalita(Node<Node<T>> p) {
        Node<Integer> tmp = null;
        while (p != null) {
            tmp = new Node<Integer>(size(p.getElem()), tmp);
            p = p.getNext();
        }
        return tmp;
    }
}// class