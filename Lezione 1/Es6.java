//ESAERCIZIO 6
class Calcolatrice {
    // stack = pila che contiene fino a 100 interi */
    // private int[] stack = new int[100];

    // size = numero di interi introdotti: all'inizio 0
    // le posizioni occupate dell'array hanno indice: 0, 1, ..., size-1
    // private int size = 0;

    //aggiungo l'elemento x allo stack e restituisco size incrementato di 1
    private int push(int x, int[] stack, int size) {
        stack[size] = x;
        return ++size;
    }

    //restituisco l'elemento di stack in posizione size (diminuita nella chiamata del main)
    private int pop(int[] stack, int size) {
        return stack[size];
    }

    public int esegui(String istruzioni, int[] stack, int size) {
        int numeroIstruzioni = istruzioni.length();
        int pc = 0;

        while (pc < numeroIstruzioni) {
            char c = istruzioni.charAt(pc);

            if (c >= '0' && c <= '9') {
                size = push(c - '0', stack, size);
            } else if (c == '+') {
                int ultimo = pop(stack, --size); //devo decrementare size prima di passarlo
                int penultimo = pop(stack, --size);
                size = push(penultimo + ultimo, stack, size);
            } else if (c == '*') {
                int ultimo = pop(stack, --size);
                int penultimo = pop(stack, --size);
                size = push(penultimo * ultimo, stack, size);
            } else if (c == '/') {
                int ultimo = pop(stack, --size);
                int penultimo = pop(stack, --size);
                size = push(penultimo / ultimo, stack, size);
            } else if (c == '-') {
                int ultimo = pop(stack, --size);
                int penultimo = pop(stack, --size);
                size = push(penultimo - ultimo, stack, size);
            } else if (c == '%') {
                int ultimo = pop(stack, --size);
                int penultimo = pop(stack, --size);
                size = push(penultimo % ultimo, stack, size);
            } else if (c == '#') {
                stampa(stack, size);
            }

            pc++;
        }

        return pop(stack, --size);
    }

    private void stampa(int[] stack, int size) {
        System.out.println("Dimensione: " + size);
        for (int i = 0; i < size; ++i) {
            System.out.println("Stack: " + stack[i]);
        }
        System.out.println();
    }
}

// Un esperimento di uso della classe calcolatrice
// Classe eseguibile pubblica, deve stare in CalcolatriceDemo.java

public class Es6 {
    public static void main(String[] args) {
        Calcolatrice C = new Calcolatrice();
        int[] stack = new int[100];
        int size = 0;

        System.out.println("Eseguo istruzioni 23+ (due piu' tre)");
        System.out.println(C.esegui("#23+", stack, size) + "\n");

        System.out.println("Eseguo istruzioni 23* (due per tre) ");
        System.out.println(C.esegui("23*", stack, size) + "\n");

        System.out.println("Eseguo istruzioni 23*9+ (due per tre piu' nove) ");
        System.out.println(C.esegui("23*9+", stack, size) + "\n");

        System.out.println("Eseguo istruzioni 99*9* (nove per nove per nove) ");
        System.out.println(C.esegui("99*9*", stack, size) + "\n");

        System.out.println("Eseguo istruzioni 99*9*1+ (nove per nove per nove piu' uno) ");
        System.out.println(C.esegui("99*9*1+", stack, size) + "\n");

        /*
         * // Esercizio 1 System.out.
         * println("Eseguo istruzioni (15+16)*17 (quindici piu' sedici per diciasette) "
         * ); System.out.println(C.esegui("87+88++89+*") + "\n");
         * 
         * System.out.println("Eseguo istruzioni 10! (dieci fattoriale) ");
         * System.out.println(C.esegui("12345678991+*********") + "\n");
         * 
         * System.out.println("Eseguo istruzioni - vado in overflow");
         * System.out.println(C.esegui(
         * "999999999999999999999999***********************") + "\n");
         * 
         * // Esercizio 2 System.out.println("Eseguo istruzioni 12- (1 meno 2) ");
         * System.out.println(C.esegui("12-") + "\n");
         * 
         * System.out.println("Eseguo istruzioni 32/ (tre diviso due) ");
         * System.out.println(C.esegui("32/") + "\n");
         * 
         * System.out.println("Eseguo istruzioni 53% (cinque modulo tre) ");
         * System.out.println(C.esegui("53%") + "\n");
         * 
         * // Esercizio 3 System.out.println("Eseguo istruzioni 12- (1 meno 2) ");
         * System.out.println(C.esegui("#11+1+#") + "\n");
         * 
         * //Esercizio 5 //s == 1+2%
         * System.out.println("Eseguo istruzioni 21+2% (due piu' uno modulo due) ");
         * System.out.println(C.esegui("21+2%") + "\n");
         * 
         * System.out.println("Eseguo istruzioni 01+2% (zero piu' uno modulo due) ");
         * System.out.println(C.esegui("01+2%") + "\n");
         * 
         * System.out.println("Eseguo istruzioni 11+2% (uno piu' uno modulo due) ");
         * System.out.println(C.esegui("11+2%") + "\n");
         * 
         * System.out.println("Eseguo istruzioni 71+2% (7 piu' uno modulo due) ");
         * System.out.println(C.esegui("71+2%") + "\n");
         */
    }
}