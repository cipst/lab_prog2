public class TestTryCatch {

 public static void m() //solleva una IllegalStateException 
  {throw new IllegalStateException("non dovevi chiamarmi");}

 public static void main(String[] args) {
  try{
     m();//otteniamo una IllegalStateException: prossima riga saltata
     System.out.println( "ce l'ho fatta! ho la risposta di m()");
  }
  catch (RuntimeException e) { 
   //Questa clausola scatta perche'
   //RuntimeException include IllegalStateException
   System.out.println( "catturata IllegalStateException");
  } 
  catch (Exception e) {
   //Questo catch verrebbe raggiunto da 
   //eccezioni diverse da IllegalStateException
   System.out.println( "catturata eccezione " + e);
  } 
  finally { 
   //qui volendo posso aggiungere una clausola 
   //che sara' eseguita sia che arriviamo da try che da un catch
   System.out.println( "clausola finale");
  }
 }
}//end class
