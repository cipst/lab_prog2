
import java.util.Arrays;

// Rubrica.java
public class Rubrica {
    /**
     * Invariante: (i) una volta costruita, una rubrica non contiene lo stesso nome
     * due volte, (ii) (0<=numContatti <= lunghezza vettore contatti)
     */

    // numero dei contatti attualmente memorizzati nella rubrica
    private int numContatti; // all'inizio parte a 0
    // array pre-allocato di contatti
    private Contatto[] contatti; // all'inizio vale null

    public Rubrica(int maxContatti) {
        // costruisce una rubrica con max. num. di contatti = maxContatti
        numContatti = 0;
        // all'inizio i contatti significativi nella rubrica sono 0
        contatti = new Contatto[maxContatti];/**
                                              * all'inizio tutti i contatti nella rubrica non sono significativi: hanno
                                              * nome e email uguali a null
                                              */
    }
    // La nuova rubrica costruita soddisfa l'invariante

    public int getNumContatti() {
        return numContatti;
    }

    /**
     * NOTA: non forniamo un metodo get per ottenere il vettore dei contatti:
     * conoscendolo, un'altra classe potrebbe leggere e modificare i contatti in
     * modo errato (in contraddizione con l’invariante)
     */

    public void scriviOutput() {
        int i = 0;
        System.out.println("Num. contatti = " + numContatti);
        // Stampiamo i contatti di indice da 0 fino a numContatti-1.
        // Gli altri contatti sono privi di significato
        while (i < numContatti) {
            contatti[i].scriviOutput();
            ++i;
        }
    }

    private int cercaIndice(String n) {
        return cercaIndiceBinario(n, 0, this.numContatti - 1);
    }

    private int cercaIndiceBinario(String n, int l, int r) {
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
      
            //l'elemento che sto cercando è  in mid => return mid 
            if (this.contatti[mid].getNome().equals(n)) 
                return mid; 
      
            //L'elemento che sto cercando è minore 
            //cerco nel sottoarray l ... mid-1
            if (this.contatti[mid].getNome().compareTo(n) > 0) 
                return cercaIndiceBinario(n, l, mid - 1); 
      
            //L'elemento che sot cercando è maggiore
            //cerco nel sottoarray mid+1 ... r
            return cercaIndiceBinario(n, mid + 1, r); 
        } 
      
        // Non ho trovato nulla
        return this.numContatti; 
    }

    /**
     * usando cercaIndice(n) possiamo stabilire se il nome n e' presente nella
     * rubrica
     */
    public boolean presente(String n) {
        return (cercaIndice(n) < numContatti);
    }

    /**
     * usando cercaIndice(n) possiamo trovare quale e-mail corrisponde a un nome
     * presente nella rubrica (restituiamo "" per nome assente)
     */
    public String cercaEmail(String n) {
        int i = cercaIndice(n);
        if (i < numContatti)
            return contatti[i].getEmail();
        else
            return "";
    }

    /**
     * controlliamo se una rubrica e' piena, cioe' se il numContatti e' uguale al
     * numero di elementi che possiamo inserire nel vettore contatti
     */
    public boolean piena() {
        return (numContatti == contatti.length);
    }

    // Aggiungi un nuovo contatto. Se non e' possibile, ritorna false
    public boolean aggiungi(String n, String e) {
        if (presente(n))
            return false; // rubrica contiene n: fallimento
        if (piena())
            contatti = raddoppia(); // rubrica piena: raddoppio

        // aggiungo il nuovo contatto nella prima posizione disponibile
        contatti[numContatti] = new Contatto(n, e);
        ++numContatti; // aggiorno il numero degli elementi

        bubbleSort();
        return true; // successo
    }

    // Rimuovi un contatto di nome @n, e riposiziona tutti i
    // contatti che seguono per ricompattare l'array.
    public boolean rimuovi(String n) {
        int i = cercaIndice(n);
        if (i == numContatti)
            return false; // il contatto manca: fallimento

        // se invece il contatto c'e': diminuiamo di uno i contatti
        --numContatti;
        // spostiamo tutti i contatti indietro di uno sovrascrivendo
        // il contatto numero i con il successore
        while (i < numContatti) {
            contatti[i] = contatti[i + 1];
            ++i;
        }

        bubbleSort();
        return true; // successo
    }

    // cerco un contatto di nome n e se lo trovo cambio il nome a n2
    public boolean cambiaNome(String n, String n2) {
        int i = cercaIndice(n), j = cercaIndice(n2);

        // contatto di nome n non trovato oppure di nome n2 trovato:fallimento
        if ((i == numContatti) || (j < numContatti))
            return false;

        // Altrimenti cambiamo il nome del contatto i da n a n2
        contatti[i].setNome(n2);
        bubbleSort();
        return true;
    }

    // cerco un contatto di nome n e se lo trovo cambio la email a e2
    public boolean cambiaEmail(String n, String e2) {
        int i = cercaIndice(n);
        if (i == numContatti)
            return false; // contatto di nome n non trovato: fallimento
        // se n e' presente modifichiamo la email
        contatti[i].setEmail(e2);
        return true;
    }

    private Contatto[] raddoppia() {
        Contatto[] b = new Contatto[2 * this.contatti.length];
        for (int i = 0; i < this.contatti.length; ++i) {
            b[i] = this.contatti[i];
        }
        return b;
    }

    private void bubbleSort() {
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
