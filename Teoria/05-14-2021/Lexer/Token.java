//Token.java
public class Token { 
 private Tag tag; private String text;
 public Token(){}
 public Token (Tag tag, String text) 
    {this.tag = tag; this.text = text;}
 public Tag getTag(){return tag;}
 public String getText(){return text;} 
//niente metodi set: non ho bisogno di modificare un token 

//Produco una descrizione di un Token come stringa
 public String toString() 
 {return "--------------- >  <" + this.tag + ", " + this.text + ">";}

 public static void main(String[] args) {
  Token prova1 = new Token(Tag.NUM, "123");
  Token prova2 = new Token(Tag.ID, "pippo");
  System.out.println(prova1);
  System.out.println(prova2);
 }
}
