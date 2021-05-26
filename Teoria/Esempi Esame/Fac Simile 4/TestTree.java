public class TestTree {
    public static void main(String[] args) {
        Tree<Integer> t = new Branch<Integer>(2, 
                            new Branch<Integer>(-3, 
                                new Leaf<Integer>(), 
                                new Branch<Integer>(1, new Leaf<Integer>(), new Leaf<Integer>())), 
                            new Leaf<Integer>());
        Tree<Integer> ris = t.detach(1);
        System.out.println("t.detach(1) = " + ris);
        ris = t.detach(2);
        System.out.println("t.detach(2) = " + ris);
        ris = t.detach(-3);
        System.out.println("t.detach(-3) = " + ris);
    }
}
