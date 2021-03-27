public class NodeUtilDemo {
    public static void main(String[] args) {
        System.out.println("Le stampe sono tutte in ordine inverso");
        System.out.println("---------------------");
        Node q = new Node(10, null);
        q = new Node(20, q);
        q = new Node(30, q);
        q = new Node(40, q);
        System.out.println("Lista q:");
        NodeUtil.scriviOutput(q);
        System.out.println("---------------------");
        Node p = new Node(30, q);
        p = new Node(20, p);
        p = new Node(10, p);
        System.out.println("Lista p:");
        NodeUtil.scriviOutput(p);
        System.out.println("---------------------");
        System.out.println("1. length(p) = " + NodeUtil.length(p));
        System.out.println("1. length_rec(p) = " + NodeUtil.length_rec(p));
        System.out.println("---------------------");
      /*  System.out.println("2. sum(p) = " + NodeUtil.sum(p));
        System.out.println("2. sum_rec(p) = " + NodeUtil.sum_rec(p));
        System.out.println("---------------------");
        System.out.println("3. max(p) = " + NodeUtil.max(p));
        System.out.println("3. maxr_rec(p) = " + NodeUtil.max_rec(p));
        System.out.println("---------------------");
        System.out.println("4. member(p,30) = " + NodeUtil.member(p, 30));
        System.out.println("4. member(p,50) = " + NodeUtil.member(p, 50));
        System.out.println("4. member_rec(p,30) = " + NodeUtil.member_rec(p, 30));
        System.out.println("4. member_rec(p,50) = " + NodeUtil.member_rec(p, 50));
        System.out.println("---------------------");
        System.out.println("5. toString(q) = " + NodeUtil.toString(q));
        System.out.println("5. toString(p) = " + NodeUtil.toString(p));
        System.out.println("---------------------");
        System.out.println("6. sorted(q) = " + NodeUtil.sorted(q));
        System.out.println("6. sorted(p) = " + NodeUtil.sorted(p));
        System.out.println("---------------------");
        System.out.println("7. equals(p,q) = " + NodeUtil.equals(p, q));
        System.out.println("7. equals(p,p) = " + NodeUtil.equals(p, p));
        System.out.println("7. equals(q,q) = " + NodeUtil.equals(q, q));
        System.out.println("7. equals(q,p) = " + NodeUtil.equals(q, p));*/
    }
}