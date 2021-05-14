public class TestBottiglia {
 public static void main(String[] args) {
 // una capacita' negativa 
 // causa il lancio dell'eccezione non controllata 
 // IllegalArgumentException nel costruttore di Bottiglia
  try{new Bottiglia(-10);}
  catch(IllegalArgumentException e) //Catturo l'eccezione e la scrivo
      {System.out.println(e.toString());}
      
  // dato che IllegalArgumentException non e' controllata NON
  // sono obbligato a catturare l'eccezione: se non lo faccio
  // una eccezione interrompe l'esecuzione del programma.
  System.out.println
   ("\nLa prossima richiesta fa interrompere il programma\n");
  new Bottiglia(-5);
 }
}