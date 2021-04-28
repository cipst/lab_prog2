
// Cerchio.java cerchio = una possibile forma di una Figura: 
// definiamo Cerchio come una sotto-classe di Figura.
import java.awt.*; //Abstract Window Toolkit

public class Cerchio extends Figura {
   // Un cerchio e' definito dal suo raggio r
   private int raggio;

   // Centro del cerchio
   private int x, y;

   // Colore del perimetro cerchio
   private Color c;
   // Colore dell'area del cerchio
   private Color d;

   // COSTRUTTORE di un quadrato
   public Cerchio(int x, int y, int raggio, Color c, Color d) {
      this.x = x;
      this.y = y;
      this.raggio = raggio;
      this.c = c;
      this.d = d;
   }

   // OVERRIDE: RI-definiamo il metodo draw per disegnare una figura
   // in un oggetto grafico g, nel caso la figura sia un cerchio.
   // Disegnamo il cerchio nel rettangolo di angolo in basso a sinistra
   // (-r, -r) e di dimensioni 2r x 2r.
   // Scegliamo il colore rosso per le prossime linee in g

   public void draw(Graphics g) {
      g.setColor(this.c);
      g.drawOval(x - raggio, y - raggio, 2 * raggio, 2 * raggio);

      g.setColor(this.d);
      g.fillOval(x - raggio, y - raggio, 2 * raggio, 2 * raggio);
   }
}
