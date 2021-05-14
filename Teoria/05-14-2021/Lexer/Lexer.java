/* Definiamo ora una classe “Lexer” di analizzatori di testo lexer. Un lexer legge da tastiera un testo, che rappresenta una espressione fatta con numeri, parentesi e le quattro operazioni, restituisce il primo token che trova in questo testo, e si ferma al primo carattere dopo il token. Un lexer restituisce il token speciale “EOF” quando raggiunge la fine del testo, e restituisce una eccezione quando trova un carattere non previsto. In questo caso il lexer lancia una eccezione controllata IOException, che siamo obbligati poi a catturare e a trattare in qualche modo.
 Attributi e metodi di Lexer sono:
1.	char peek. È l’unico attributo (privato) di un lexer, e rappresenta il carattere all’inizio del prossimo token da leggere. All’inizio e ogni volta che finisco il testo pongo peek=' '.
2.	void readch(). Legge un carattere da tastiera se c’è, altrimenti ferma l’esecuzione finche’ noi non inseriamo nuovi caratteri da tastiera. readch() usa la primitiva System.in.read(), e quest’ultima se la lettura del carattere fallisce lancia una IOException, controllata. readch() cattura questa eccezione e la rimpiazza con il carattere EOF=-1.  
3.	Token scan() throws IOException. Raggruppa in un token i caratteri da peek in poi. Poi scan() porta peek al primo carattere dopo il token. Se il carattere trovato non è tra quelli previsti, scan() lancia una IOException, controllata, che deve venir trattata da chi usa scan().
*/

//Lexer.java. Classe degli analizzatori di testo per espressioni
import java.io.*; // Per avere la classe IOException, che altrimenti 
//devo descrivere come: java.io.IOException
  
public class Lexer { 
  private char peek = ' '; //valore iniziale peek: 
 //riassegno peek=' ' quando finiscono i token

 public void readch(){
  try {peek = (char) System.in.read();} //puo' lanciare IOException 
  catch (IOException exc) {peek = (char) -1; }
  //Rappresento l'eccezione con il carattere -1.
 }

 public Token scan() throws IOException{
  //Salto il valore iniziale di peek e gli spazi bianchi nell'input
  while (peek == ' ' || peek == '\t' || peek == '\n')
           {readch();}
  //Leggo il primo pezzo significativo: il carattere -1 (End Of File)
  //una operazione +,*,-,/, oppure un intero. Se raggiungo EOF pongo 
  // peek=' '. Se trovo una operazione mando avanti peek di 1.
  switch (peek) {
   case (char) -1: peek=' '; return new Token(Tag.EOF,    "");
   case '+':       readch(); return new Token(Tag.PLUS,   "+");
   case '*':       readch(); return new Token(Tag.TIMES,  "*");      
   case '-':       readch(); return new Token(Tag.MINUS,  "-");  
   case '/':       readch(); return new Token(Tag.DIVIDE, "/");
   default:
 /* Se trovo una cifra, raccolgo tutte le cifre consecutive che trovo per formare una stringa che etichetto come NUM (intero). Mi fermo al primo carattere dopo il token e NON mando piu' avanti peek. */
   if (Character.isDigit(peek)){
    String s = "";
    do {s = s + peek; readch();} 
    while (Character.isDigit(peek));
    //Restituisco la stringa raccolta, e la etichetto come NUM
    return new Token(Tag.NUM, s);
   } 
   else {
     peek=' '; //fine token, riassegno peek al valore iniziale
     throw new IOException("Carattere inserito ne' cifra ne' +*-/");
   }
  }//end switch
 }

//NOTA. Un metodo che usa un metodo che solleva eccezioni controllate
//deve a sua volta essere commentato con il "throws"
//altrimenti non viene accettato. Per esempio devo scrivere:
 
   public Token scan2() throws IOException {return scan();}
   
//Come esperimento, inserisco una stringa e la scompongo in token
//Se la stringa contiene un carattere diverso da una cifra oppure una
//delle 4 operazioni +.*,-,/ allora scan() solleva una eccezione,
//inserisce un messaggio e esce dal while
 
// main di prova
 public static void main(String[] args) {
  Lexer lex = new Lexer();
  Token t = new Token();
  System.out.println( "Scrivere espressione con: naturali +-*/");
  System.out.println( "Per finire inserite qualunque altra cosa");
  
  while (t.getTag() != Tag.EOF) 
  /** Uso scan() finche' arrivo a fine testo. Non stampo il token di fine testo. */
   try {t = lex.scan(); System.out.println( "Token: " + t);}
   catch(IOException e) 
  /** quando viene inserito un carattere non previsto scrivo un 
messaggio di errore e poi termino il ciclo con un tag EOF */
   {System.out.println(e.getMessage());t = new Token(Tag.EOF,"");}
 }
}