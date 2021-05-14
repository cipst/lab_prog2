public class Es1 {
        public static void main(String[] args) {
            Node<Integer> p1 = new Node<Integer>(7, null);
            p1 = new Node<Integer>(5, p1);
            Node<Integer> q1 = new Node<Integer>(2, null);
            q1 = new Node<Integer>(7, q1);
            q1 = new Node<Integer>(8, q1);
            Node<Integer> p2 = new Node<Integer>(4, null);
            p2 = new Node<Integer>(3, p2);
            p2 = new Node<Integer>(2, p2);
            Node<Integer> q2 = new Node<Integer>(4, null);
            q2 = new Node<Integer>(3, q2);
            q2 = new Node<Integer>(2, q2);
    
            System.out.println(inComune(p1, q1));
            System.out.println(inComune(p2, q2));
            System.out.println(inComune(null, p1));
            System.out.println(inComune(null, null));
        }
    
        public static <T> boolean inComune(Node<T> p, Node<T> q) {
            if (p == null || q == null)
                return false;
            else
                return p.getElem().equals(q.getElem()) || inComune(p.getNext(), q.getNext());
        }
    
    
}
