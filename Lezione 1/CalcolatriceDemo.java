// Salviamo il tutto nel file CalcolatriceDemo.java

class Calcolatrice { // classe non eseguibile e non pubblica
    // una calcolatrice e' una pila che contiene fino a 100 interi.
    // L'ultimo intero e' il risultato delle operazioni fatte finora
    // e la prossima operazione agisce sugli ultimi due interi a,b
    // e li rimpiazza con a+b (per una addizione) oppure a*b (per una
    // moltiplicazione)

    // stack = pila che contiene fino a 100 interi */
    private int[] stack = new int[100];

    // size = numero di interi introdotti: all'inizio 0
    // le posizioni occupate dell'array hanno indice: 0, 1, ..., size-1
    private int size = 0;

    // push(x): aggiunge un intero x allo stack dopo la parte utilizzata
    // e aumenta di 1 la parte di stack utilizzata (variabile size)
    private void push(int x) {
        stack[size] = x;
        size++;
    }

    // pop(): restituisce l'ultima intero dello stack
    // e lo "cancella" riducendo di 1 la parte di stack utilizzata (variabize size)
    private int pop() {
        size--;
        return stack[size];
    }

    // questo e' un metodo pubblico
    public int esegui(String istruzioni) {
        int numeroIstruzioni = istruzioni.length(); // lunghezza
        int pc = 0; // inizio leggendo la prima istruzione, in posizione 0

        while (pc < numeroIstruzioni) { // eseguo le istruzioni in ordine
            char c = istruzioni.charAt(pc); // c = carattere di posto pc

            if (c >= '0' && c <= '9') { // vero se c e' una cifra
                push(c - '0'); // questa formula mi da' il valore della cifra c
            } else if (c == '+') {
                int ultimo = pop(); // risultato ultimo calcolo
                int penultimo = pop(); // risultato penultimo calcolo
                push(penultimo + ultimo);
            } else if (c == '*') {
                int ultimo = pop(); // risultato ultimo calcolo
                int penultimo = pop(); // risultato penultimo calcolo
                push(penultimo * ultimo);
            } else if (c == '/') {
                int ultimo = pop();
                int penultimo = pop();
                push(penultimo / ultimo);
            } else if (c == '-') {
                int ultimo = pop();
                int penultimo = pop();
                push(penultimo - ultimo);
            } else if (c == '%') {
                int ultimo = pop();
                int penultimo = pop();
                push(penultimo % ultimo);
            } else if (c == '#') {
                stampa();
            }

            pc++; // passiamo alla prossima istruzione
        }

        return pop(); // alla fine restituisco l'ultimo risultato ottenuto
    }

    private void stampa() {
        System.out.println("Dimensione: " + size);
        for (int i=0; i<size; ++i) {
            System.out.println("Stack: " + stack[i]);
        }
        System.out.println();
    }
}

// Un esperimento di uso della classe calcolatrice
// Classe eseguibile pubblica, deve stare in CalcolatriceDemo.java

public class CalcolatriceDemo {
    public static void main(String[] args) {
        Calcolatrice C = new Calcolatrice();

        System.out.println("Eseguo istruzioni 23+ (due piu' tre)");
        System.out.println(C.esegui("#23+") + "\n");

        System.out.println("Eseguo istruzioni 23* (due per tre) ");
        System.out.println(C.esegui("23*") + "\n");

        System.out.println("Eseguo istruzioni 23*9+ (due per tre piu' nove) ");
        System.out.println(C.esegui("23*9+") + "\n");

        System.out.println("Eseguo istruzioni 99*9* (nove per nove per nove) ");
        System.out.println(C.esegui("99*9*") + "\n");

        System.out.println("Eseguo istruzioni 99*9*1+ (nove per nove per nove piu' uno) ");
        System.out.println(C.esegui("99*9*1+") + "\n");

        // Esercizio 1
        System.out.println("Eseguo istruzioni (15+16)*17 (quindici piu' sedici per diciasette) ");
        System.out.println(C.esegui("87+88++89+*") + "\n");

        System.out.println("Eseguo istruzioni 10! (dieci fattoriale) ");
        System.out.println(C.esegui("12345678991+*********") + "\n");

        System.out.println("Eseguo istruzioni (overflow)");
        System.out.println(C.esegui("999999999999999999999999***********************") + "\n");

        // Esercizio 2
        System.out.println("Eseguo istruzioni 12- (1 meno 2) ");
        System.out.println(C.esegui("12-") + "\n");

        System.out.println("Eseguo istruzioni 32/ (tre diviso due) ");
        System.out.println(C.esegui("32/") + "\n");

        System.out.println("Eseguo istruzioni 53% (cinque modulo tre) ");
        System.out.println(C.esegui("53%") + "\n");

        // Esercizio 3
        System.out.println("Eseguo istruzioni 12- (1 meno 2) ");
        System.out.println(C.esegui("#11+1+#") + "\n");

        //Esercizio 5
        //s == 1+2%
        System.out.println("Eseguo istruzioni 21+2% (due piu' uno modulo due) ");
        System.out.println(C.esegui("21+2%") + "\n");

        System.out.println("Eseguo istruzioni 01+2% (zero piu' uno modulo due) ");
        System.out.println(C.esegui("01+2%") + "\n");

        System.out.println("Eseguo istruzioni 11+2% (uno piu' uno modulo due) ");
        System.out.println(C.esegui("11+2%") + "\n");

        System.out.println("Eseguo istruzioni 71+2% (sette piu' uno modulo due) ");
        System.out.println(C.esegui("71+2%") + "\n");
    }
}