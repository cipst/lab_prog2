//EsempiEccezioni.java 
/* Per diverse eccezioni che descrivono errori interni a un programma scriviamo un metodo che solleva quella eccezione */
public class EsempiEccezioni {

public static void test_ArithmeticException() 
 {System.out.println(1 / 0);} //divisione per 0

public static void test_ClassCastException()
 {Object obj = "ciao"; Float f = (Float) obj;} 
//non e' possibile convertire String a Float

public static void test_NumberFormatException () 
 {Integer.parseInt("ciao");} 
 // parseInt trasforma una stringa in un  intero, ma "ciao" non 
 // rappresenta un intero

 public static void test_IndexOutOfBoundsException() 
  {int[] a = new int[10]; a[10] = 0;} //a[10] non esiste

 public static void test_NullPointerException() 
  {Object obj = null; System.out.println(obj.toString());}
 // Non possiamo mandare un metodo dinamico come toString a null


 public static void main(String[] args) {
 // Ognuna delle prossime righe solleva una eccezione
 // test_ArithmeticException();
 // test_ClassCastException();
 // test_NumberFormatException();
 // test_IndexOutOfBoundsException();      
 // test_NullPointerException();
 }
}

 /* Ci sono altri tipi di eccezioni, tipicamente causate da errori esterni al programma. Per esempio: FileNotFoundException, quando chiedo di aprire un file inesistente, oppure IOException, quando ho errori durante la lettura/scrittura da un file o dalla rete. Per avere le classi di eccezioni IO devo scrivere import java.io.*;

 Infine, ci sono gli errori, che sono eccezioni particolarmente gravi. Per esempio, un comando assert cond:”messaggio”; solleva un errore di tipo AssertionError quando la condizione cond è falsa, terminando così il programma, e invia un messaggio di errore. Abbiamo già visto come usare un assert per segnalare errori.
 
  **Eccezioni non controllate e controllate**. Si fa una prima distinzione tra le eccezioni causate da errori interni al programma, che vengono dette eccezioni non controllate, e quelle prodotte da cause esterne, che vengono dette eccezioni controllate. Le eccezioni non controllate vengono chiamate così perché è responsabilità del programmatore decidere se gestirle come eccezioni oppure porre rimedio a quegli errori che impediscono al programma di non terminare correttamente, quindi di eliminare la loro comparsa invece di gestirle se accadono. Invece il programmatore è tenuto a trattare le eccezioni controllate con una parte di programma apposita, perché sono causate da eventi che non dipendono dal suo codice, ma da fattori esterni che non si possono prevedere nel programma stesso. 
  
  NON controllate: si può decidere se gestirle o no (normalmente per errori "interni").
  Controllate: si deve gestirle (normalmente per errori "esterni").
 */
