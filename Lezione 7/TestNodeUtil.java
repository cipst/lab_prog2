public class TestNodeUtil {

    public static void main(String[] args) {
        Node<Integer> p = new Node<Integer>(0, null);
        p = new Node<Integer>(1, p);
        p = new Node<Integer>(2, p);
        p = new Node<Integer>(1, p);
        p = new Node<Integer>(3, p);
        System.out.println("p = [ 3 | 1 | 2 | 1 | 0 ]");

        // Esercizio 1
        System.out.println(" - size(p) = " + NodeUtil.size(p) + "\n");

        // Esercizio 2
        System.out.println(" - occurrences(p, 1) = " + NodeUtil.occurrences(p, 1));
        System.out.println(" - occurrences(p, 5) = " + NodeUtil.occurrences(p, 5) + "\n");

        // Esercizio 3
        Node<Double> p3 = new Node<Double>(3.0, null);
        p3 = new Node<Double>(2.0, p3);
        p3 = new Node<Double>(1.0, p3);
        Node<Double> q3 = new Node<Double>(4.0, null);
        q3 = new Node<Double>(3.0, q3);
        q3 = new Node<Double>(0.0, q3);
        q3 = new Node<Double>(2.0, q3);
        q3 = new Node<Double>(2.0, q3);
        q3 = new Node<Double>(1.0, q3);
        q3 = new Node<Double>(0.0, q3);
        System.out.println("p3 = [ 1 | 2 | 3 ]");
        System.out.println("q3 = [ 0 | 1 | 2 | 2 | 0 | 3 | 4 ]");
        System.out.println(" - included(p3, q3) = " + NodeUtil.included(p3, q3) + "\n");

        // Esercizio 4
        Node<String> p4 = new Node<String>("O", null);
        p4 = new Node<String>("A", p4);
        p4 = new Node<String>("I", p4);
        p4 = new Node<String>("C", p4);
        Node<String> q4 = NodeUtil.reverse(p4);
        System.out.print("p4: ");
        NodeUtil.printList(p4);
        System.out.print("\np4 (reversed): ");
        NodeUtil.printList(q4);
        System.out.println();

        //Esercizio 6
        Node<Integer> p7 = new Node<Integer>(3, null);
        p7 = new Node<Integer>(1, p7);
        p7 = new Node<Integer>(3, p7);
        p7 = new Node<Integer>(2, p7);
        p7 = new Node<Integer>(3, p7);
        p7 = new Node<Integer>(1, p7);
        p7 = new Node<Integer>(4, p7);
        p7 = new Node<Integer>(3, p7);
        
        Node<Integer> p8 = new Node<Integer>(1, null);
        p8 = new Node<Integer>(2, p8);
        p8 = new Node<Integer>(1, p8);
        p8 = new Node<Integer>(4, p8);

        Node<Node<Integer>> p6 = new Node<Node<Integer>>(p7, null);
        p6 = new Node<Node<Integer>>(p8, p6);
        p6 = new Node<Node<Integer>>(null, p6);

        System.out.println(" - cardinalita': ");
        NodeUtil.printList(NodeUtil.cardinalita(p6));
    }// main

}// class
