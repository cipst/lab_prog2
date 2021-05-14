import java.io.*; //per le IOException
public class TestError{
  public static void m()  
   //Error e` non controllato, non devo scrivere throws
   //ma posso farlo: se lo faccio, devo mettere le sue chiamate in
   //try-catch
   {throw new Error( "error" );} 
   //viene chiamato il costruttore della classe Error, che
   //prende un parametro String --> le eccezioni sono oggetti!
  
  public static void m2() throws IOException 
   //IOException e' controllata, devo scrivere throws
   //e la chiamata di m2() deve stare in un try-catch
      {throw new IOException( "io exception" );}
   //{}
  
  public static void m3() //throws RuntimeException
   //RuntimeException e' non controllata, non devo scrivere throws
   //ma posso farlo: se lo faccio, però, devo mettere le sue chiamate in
   //try-catch
   {throw new RuntimeException( "runtime exception" );}

  public static void main(String[] args){
    try {m(); m2(); m3();}
    catch (Throwable e) //catturo tutti gli errori o eccezioni
      {System.out.println("Captured: " + e);}
    //finito il body del catch, non si prosegue nel try, 
    //ma si prosegue con il programma:
    System.out.println("Sono fuori dal try-catch!");
  }
  /* Se scrivo:
  
     public static void main(String[] args){
       m2();
       try {m(); m3();}
       catch (Throwable e) //catturo tutti gli errori o eccezioni
         {System.out.println("Captured: " + e);}
       System.out.println("Sono fuori dal try-catch!");
     }
       
      il compilatore dice:
       TestError.java:21: error: unreported exception IOException; must be caught or declared to be thrown
       m2();
         ^
       perché nella firma di m2() c'è la clausola 'throws' che obbliga la gestione (o il rilancio) dell'eccezione sollevata. Siccome quell'eccezione è "controllata", la clausola 'throws' e la conseguente gestione sono obbligatorie. Per le eccezioni "non controllate" decide il programmatore se mettere la clausola 'throws' e quindi gestirle.
         
      Se scrivo:
      
      public static void main(String[] args){
        m(); m3(); 
        try {m2();}
        catch (Throwable e) //catturo tutti gli errori o eccezioni
          {System.out.println("Captured: " + e);}
        System.out.println("Sono fuori dal try-catch!");
      }
    
      Il compilatore compila perché m() e m3() non dichiarano di lanciare l'eccezione con la 'throws' nella firma, quindi accetta le due chiamate anche fuori dal 'try', ma l'eccezione lanciata da m() (o da m3()) non viene gestita e si ha l'interruzione del programma. In particolare la stampa System.out.println("Sono fuori dal try-catch!") non sarà eseguita.
    
   */
  }
  
