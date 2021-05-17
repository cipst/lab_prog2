public class Rubrica {
    /**
     * Invariante: (i) una volta costruita, una rubrica non contiene lo stesso nome
     * due volte, (ii) (0<=numContatti <= lunghezza vettore contatti)
     */

    // numero dei contatti attualmente memorizzati nella rubrica
    private int numContatti; // all'inizio parte a 0
    // array pre-allocato di contatti
    private Contatto[] contatti; // all'inizio vale null

    // Costruttore: inizializza una Rubrica con @maxContatti preallocati.
    public Rubrica(int maxContatti) {
        // costruisce una rubrica con max. num. di contatti = maxContatti
        numContatti = 0;
        // all'inizio i contatti significativi nella rubrica sono 0
        contatti = new Contatto[maxContatti];
        /**
         * all'inizio tutti i contatti nella rubrica non sono significativi: hanno nome
         * e email uguali a null
         */
    }
    // La nuova rubrica costruita soddisfa l'invariante

    public int getNumContatti() {
        return numContatti;
    }

    // non viene fornito un metodo get per ottenere il vettore dei contatti:
    // conoscendolo, un'altra classe potrebbe leggere e modificare
    // i contatti in modo errato

    public void scriviOutput() {
        int i = 0;
        System.out.println("Num. contatti = " + numContatti);
        // Vengono stampati i contatti di indice da 0 fino a numContatti-1.
        // Gli altri contatti nell'array sono privi di significato
        while (i < numContatti) {
            contatti[i].scriviOutput();
            ++i;
        }
    }

    // Il metodo cercaIndice(n) restituisce l'unico indice i di un contatto di nome
    // n
    // restituisce numContatti se non viene trovato
    // Il metodo cercaIndice(n) e' privato per evitare che
    // le altre classi modifichino un contatto in modo errato
    private int cercaIndice(String n) {
        return cercaIndiceBinario(n, 0, this.numContatti - 1);
    }

    private int cercaIndiceBinario(String n, int l, int r) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // l'elemento che sto cercando è in mid => return mid
            if (this.contatti[mid].getNome().equals(n))
                return mid;

            // L'elemento che sto cercando è minore
            // cerco nel sottoarray l ... mid-1
            if (this.contatti[mid].getNome().compareTo(n) > 0)
                return cercaIndiceBinario(n, l, mid - 1);

            // L'elemento che sot cercando è maggiore
            // cerco nel sottoarray mid+1 ... r
            return cercaIndiceBinario(n, mid + 1, r);
        }

        // Non ho trovato nulla
        return this.numContatti;
    }

    // Stabilisce se il nome n e' presente nella rubrica
    public boolean presente(String n) {
        return (cercaIndice(n) < numContatti);
    }

    // Ritrorna true se la rubrica e' piena
    public boolean piena() {
        return (numContatti == contatti.length);
    }

    // Aggiunge un nuovo contatto con nome @n e email @e.
    // Se il contatto esiste gia', il metodo non effettua l'inserimento.
    // Ritorna true se viene aggiunto false altrimenti.
    public boolean aggiungi(String n, String e) {
        if (presente(n))
            return false;// la rubrica contiene gia' n: fallimento
        if (piena())
            return false; // rubrica e' piena: fallimento

        // aggiungo il nuovo contatto nella prima posizione disponibile
        contatti[numContatti] = new Contatto(n, e);
        ++numContatti; // aggiorno il numero degli elementi

        sort();

        return true; // successo
    }

    // Rimuove un conbtatto di nome @n, se esiste.
    // Ritorna true se la rimozione e' stata effettuata.
    public boolean rimuovi(String n) {
        int i = cercaIndice(n);
        if (i == numContatti)
            return false; // il contatto non esiste: fallimento

        // Per rimuovere sposto indietro di uno tutti i contatti che seguono il contatto
        // rimosso
        --numContatti;
        while (i < numContatti) {
            contatti[i] = contatti[i + 1];
            ++i;
        }
        return true; // successo
    }

    // Cambia il nome di un contatto @n ad @n2.
    // Ritorna true in caso di successo (rinominazione effettuata), false
    // altrimenti.
    public boolean cambiaNome(String n, String n2) {
        int i = cercaIndice(n);
        if (i == numContatti)
            return false; // contatto di nome n non trovato:fallimento
        int i2 = cercaIndice(n2);
        if (i2 != numContatti)
            return false; // contatto di nome n2 gia' esiste:fallimento
        // se troviamo il contatto ne modifichiamo il nome
        contatti[i].setNome(n2);

        sort();

        return true;
    }

    // Cambia l'email di un contatto di nome @n ad @e2.
    // Ritorna true in caso di successo (cambio email effettuato), false altrimenti.
    public boolean cambiaEmail(String n, String e2) {
        int i = cercaIndice(n);
        if (i == numContatti)
            return false; // contatto di nome n non trovato:fallimento
        // se troviamo il contatto ne modifichiamo la email
        contatti[i].setEmail(e2);
        return true;
    }

    private void sort() {
        for (int i = 0; i < this.numContatti; i++) {
            boolean flag = false;
            for (int j = 0; j < this.numContatti - 1 && !flag; j++) {
                // Se l' elemento j e maggiore del successivo allora
                // scambiamo i valori
                if (this.contatti[j].getNome().compareTo(this.contatti[j + 1].getNome()) > 0) {
                    Contatto tmp = this.contatti[j];
                    this.contatti[j] = this.contatti[j + 1];
                    this.contatti[j + 1] = tmp;
                    flag = true; // Lo setto a true per indicare che é avvenuto uno scambio
                }
            }
        }
    }
}
