
abstract class List {
    public abstract double eval(double x);
}

class Nil extends List {
    public double eval(double x) {
        return 0.0;
    }
}

class Cons extends List {
    private double elem;
    private List next;

    public Cons(double elem, List next) {
        this.elem = elem;
        this.next = next;
    }

    public double eval(double x) {   
        return this.elem + x * this.next.eval(x);
    }
}

public class es3 {
    public static void main(String[] args) {
        List l = new Cons(1, new Cons(2, new Cons(3, new Nil())));
        System.out.println(l.eval(5));
    }
}// class