public class Nil extends List {
    public List insert(int n, int x) throws IndexOutOfBoundsException {
        try {
            if (x > 0)
            throw new IndexOutOfBoundsException("ERRORE! Eccedi di " + x + " posizioni");
            return new Cons(n, this);
        } catch (IndexOutOfBoundsException err) {
            System.out.println(err);
        }
        return this;
    }

    public String toString() {
        return "";
    }
}