
// Quadrato.java  quadrato=una possibile forma di una Figura
// Definiamo Quadrato come una sottoclasse di Figura
import java.awt.*; //Abstract Window Toolkit

public class Quadrato extends Figura {
  // Un quadrato e' definito dal suo lato
  private int lato;

  // centro del quadrato
  private int x, y;

  // colore del perimetro quadrato
  private Color c;
  // colre dell'area del quadrato
  private Color d;

  // COSTRUTTORE di un quadrato
  public Quadrato(int x, int y, int lato, Color c, Color d) {
    this.x = x;
    this.y = y;
    this.lato = lato;
    this.c = c;
    this.d = d;
  }

  // OVERRIDE: RI-definiamo il metodo draw (per ora vuoto)
  // per disegnare una figura nel caso di un quadrato.
  // Scegliamo il quadrato centrato nell'origine e orizzontale.
  // Scegliamo il colore arancio per le prossime linee in g.
  public void draw(Graphics g) {
    g.setColor(this.c);
    int m = lato / 2;
    g.drawLine(x + m, y + m, x - m, y + m); // disegno primo lato in g
    g.drawLine(x - m, y + m, x - m, y - m); // disegno secondo lato in g
    g.drawLine(x - m, y - m, x + m, y - m); // disegno terzo lato in g
    g.drawLine(x + m, y - m, x + m, y + m); // disegno quarto lato in g

    g.setColor(this.d);
    int[] xPoints = { x + m, x - m, x - m, x + m };
    int[] yPoints = { y + m, y + m, y - m, y - m };
    g.fillPolygon(xPoints, yPoints, 4);
  }
}
