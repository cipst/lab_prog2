import java.util.*; 
import java.io.*; //per IOException 

class DenZeroException extends IOException{ //controllata
 private int den;
 public DenZeroException(int den){super(); this.den=den;}
 public int getDen(){return den;}
} 

class Frazione {
  private int num; private int den; 
  // Invariante classe: il denominatore deve essere > 0
  public Frazione(){num=1; den=1;} //costruttore pubblico:
  //restituisce un valore di default = 1/1

  // uso un costruttore private: siccome puo' creare frazioni 
  // non ben formate non e' accessibile dall'esterno:
  private Frazione(int n, int d) {num = n; den = d;}

  // Inserisco l'eccezione in un metodo create() static pubblico. 
  // Il metodo create() usa il costruttore privato 
  // e se necessario solleva un’eccezione. Questo tipo di metodo è
  // un "factory method", che è un design pattern.
  public static Frazione create(int n, int d) 
      throws DenZeroException{
   if (d<=0) throw new DenZeroException(d); 
   return new Frazione(n,d);
  }
  /* Quando uso il metodo create() devo inserire il metodo dentro un   
  "try" e aggiungere un "catch" per trattare il caso dell'eccezione di tipo "DenZeroException".

  DenZeroException è infatti una eccezione controllata: se un metodo la sollevo si è obbligati ad aggiungere "throws DenZeroException" alla 
  segnatura del metodo (per esempio, create()) e si deve catturare l’eccezione ogni volta che si usa il metodo.
  */

   
  public String toString(){return num + "/" + den;}

} //end class Frazione

public class ProvaFrazione {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);//per leggere input
    boolean done = false;
    int n, d; Frazione f = new Frazione(); //f=default=1/1 
    //f = Frazione.create(2,3); 
    //NO: solleva come eccezione: “unreported 
    //exception”, non ho catturato DenZeroException             
    while (!done) {
      try {
       System.out.println("Inserisci il numeratore:");
       n = scanner.nextInt();
       System.out.println("Inserisci il denominatore (>0):");
       d = scanner.nextInt();
       f = Frazione.create(n,d); //posso usare create solo dentro try{}
       done = true;
       }
    catch (DenZeroException err) {//Se leggo un d<=0 chiedo di nuovo
      System.out.println
         ("Den. " + err.getDen() + "<= 0!. Inserisci ancora:");
      }
    } // fine while
   System.out.println("Hai inserito " + f);
  }
 }
