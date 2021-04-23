public class Nil extends List {

    // un nodo Nil è sempre vuoto per definizione
    public boolean empty() {
        return true;
    }// empty()

    // tramite binding dinamico viene chiamato il size() opportuno
    // se next è di tipo Cons viene chiamato ricorsivamente questo metodo (size+1);
    // se next è di tipo Nil viene chiamato il size di Nil (0);
    public int size() {
        return 0;
    }// size()

    // tramite binding dinamico viene chiamato il contains() opportuno
    // se next è di tipo Cons viene chiamato ricorsivamente questo metodo;
    // se next è di tipo Nil viene chiamato il contains di Nil
    // ( == false --> per definizione Nil è vuoto );
    public boolean contains(int x) {
        return false;
    }// contains()

    // tramite binding dinamico viene chiamato l'insert() opportuno
    public List insert(int x) {
        return new Cons(x, this);
    }// insert()

    public List append(List l) {
        return l;
    }// append()

    @Override
    public String toString() {
        return "";
    }// toString()

}// Nil extends List
