public class Cons extends List {

    private int elem;
    private List next;

    protected Cons(int elem, List next) {
        this.elem = elem;
        this.next = next;
    }// constructor

    // un nodo Cons non può mai essere vuoto per definizione
    public boolean empty() {
        return false;
    }// empty()

    // tramite binding dinamico viene chiamato il size() opportuno
    // se next è di tipo Cons viene chiamato ricorsivamente questo metodo (size+1);
    // se next è di tipo Nil viene chiamato il size di Nil (0);
    public int size() {
        return 1 + next.size();
    }// size()

    // tramite binding dinamico viene chiamato il contains() opportuno
    // se next è di tipo Cons viene chiamato ricorsivamente questo metodo;
    // se next è di tipo Nil viene chiamato il contains di Nil
    // ( == false --> per definizione Nil è vuoto );
    public boolean contains(int x) {
        return (x == elem || next.contains(x));
    }// contains()

    // tramite binding dinamico viene chiamato l'insert() opportuno
    public List insert(int x) {
        // se (x < this.elem) ==> x deve essere messo prima di this.elem
        // ==> creo un nuovo nodo Cons con elem = x e next = this
        if (x < this.elem)
            return new Cons(x, this);

        // se (x == this.elem) ==> x ed this.elem sono lo stesso elemento
        // ==> non devo inserire un nuovo nodo perchè è una lista ordinata
        // (NON ci devono essere ripetizioni per definizione)
        else if (x == this.elem)
            return this;

        // se (x > this.elem) ==> x deve essere messo dopo this.elem
        // ==> faccio ricorsivamente l'insert() su this.next
        // ==> >> se next è di tipo Cons viene chiamato ricorsivamente questo metodo;
        // ==> >> se enxt è di tipo Nil viene chiamato l'insert() di Nil
        // ==> >> (che quindi creerà un nodo Cons con elem = x e next = l'oggetto Nil )
        else
            return new Cons(this.elem, next.insert(x));

    }// insert()

    public List append(List l) {
        if (l.empty())
            return this;
        else {
            // sono obbligato a fare il DOWNCAST perchè il compilatore vede come tipo
            // apparente List e il tipo List non ha elem o next
            // -> essendo nel ramo else: l.empty() == false -> il tipo di l è Cons
            // -> quindi posso fare un DOWNCAST!
            int x = ((Cons) l).elem;
            List m = ((Cons) l).next;

            // faccio l'insert() di x (questo vuol dire che x verrà inserito in modo
            // ordinato)
            // tramite binding dinamico avrò:
            // >> se tipo vero restituito da insert() è Cons: chiamata a questo metodo;
            // >> se tipo vero restituito da insert() è Nil: chiamata a metodo di Nil;
            return insert(x).append(m);
        }
    }// append()

    @Override
    public String toString() {
        return this.elem + " " + this.next.toString();
    }// toString()

}// Cons extends List
