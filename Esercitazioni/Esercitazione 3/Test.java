import javax.swing.*; //estensione di awt per interfacce grafiche
import java.awt.*;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		int m = 70, t = 90, n = 120;
		Random r = new Random();

		// Array di n figure: all’inizio ogni figura vale null
		Figura[] figure = new Figura[n];

		// Assegnamo le n figure: scegliamo m quadrati e (n-m) cerchi
		// Possiamo farlo perche' quadrati e cerchi sono particolari figure
		for (int i = 0; i < m; i++) {
			figure[i] = new Quadrato(r.nextInt(200) - 150, r.nextInt(200) - 150, i, Color.red, Color.black);
		}
		for (int i = m; i < t; i++) {
			figure[i] = new Cerchio(r.nextInt(200) - 50, r.nextInt(200) - 50, i, Color.green, Color.cyan);
		}
		for (int i = t; i < n; i++) {
			figure[i] = new Triangolo(r.nextInt(200) + 75, r.nextInt(200) + 75, i, i, Color.blue, Color.MAGENTA);
		}

		// Definiamo un disegno con array di figure proprio “figure"
		Disegno frame = new Disegno(figure);// Jframe con array di figure

		// ESEMPI DI EREDITARIETA' (SENZA OVERRIDE) DALLA CLASSE JFRAME
		// Scegliamo di terminare la figura quando ne chiudiamo la finestra
		// (il metodo setDefaultCloseOperation viene ereditato da JFrame)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Scegliamo la dimensione della finestra grafica:
		// (il metodo setSize viene ereditato da JFrame)
		frame.setSize(600, 600);

		// setVisible(true) rende il disegno visibile, inviando un oggetto
		// il metodo paint all’oggetto frame insieme con un parametro g:
		// (il metodo setVisible viene ereditato da JFrame)
		frame.setVisible(true);
	}
}