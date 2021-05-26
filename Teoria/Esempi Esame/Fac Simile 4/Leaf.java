public class Leaf<T> extends Tree<T> {
    public Tree<T> detach(T x) {
        return this;
    }

    public String toString() {
        return "Leaf";
    }
}
