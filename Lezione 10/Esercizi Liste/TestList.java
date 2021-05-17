public class TestList {
    public static void main(String[] args) {
        List l = new Cons(1, new Cons(2, new Cons(3, new Nil())));
        l = l.insert(-1, 3);
        System.out.println(l.toString());

        l = l.insert(10, 9);
        System.out.println(l.toString());

        l = l.insert(8, -1);
        System.out.println(l.toString());

        l = l.insert(6, 3);
        System.out.println(l.toString());
    }
}
