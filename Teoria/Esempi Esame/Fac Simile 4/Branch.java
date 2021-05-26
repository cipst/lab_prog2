public class Branch<T> extends Tree<T> {
    private T elem;
    private Tree<T> left;
    private Tree<T> right;

    public Branch(T elem, Tree<T> left, Tree<T> right) {
        this.elem = elem;
        this.left = left;
        this.right = right;
    }

    public Tree<T> detach(T x) {
        if (x.equals(this.elem)) {
            return new Leaf<T>();
        } else {
            //return new Branch<T>(this.elem, left.detach(x), right.detach(x));
            left = left.detach(x);
            right = right.detach(x);
            return this;
        }
    }

    public String toString() {
        return "Branch(" + elem + "," + left + "," + right + ")";
    }
}