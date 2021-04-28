//Disegno.java
import java.awt.*;    //Abstract Window Toolkit (finestre grafiche)
import javax.swing.*; //estensione di awt per interfacce grafiche

public class Disegno extends JFrame{ /* Un "disegno" e' un JFrame con 
	parte grafica = tutte le figure di un array di figure */
	private Figura[] figure;

	//COSTRUTTORE basato sul costruttore della classe superiore JFrame
	public Disegno(Figura[] figure){
		super();               //Assegnamo tutti i parametri di un JFrame
		this.figure = figure;  //Aggiungiamo un array di figure
	}
  
	// OVERRIDE: ridefiniamo il metodo paint di JFrame
	// chiedendo di inizializzare una finestra grafica, poi
	// di disegnare tutte le figure dell’array figure di g
	public void paint(Graphics g) { //INIZIALIZZO g
		int w = getSize().width;  // base    di g
		int h = getSize().height; // altezza di g
		g.clearRect(0, 0, w, h);  // azzero  il contenuto di g
		g.translate(w/2,h/2); //traslo sistema di riferimento al centro di g

		//DISEGNO tutte le figure dell’array figure
		for(int i=0;i<figure.length;++i) {
			figure[i].draw(g);
		}
	}
	//BINDING per il metodo draw. Quale metodo draw viene scelto? //Dipende dal tipo esatto di figura[i]. Se figura[i] ha tipo esatto
	//Quadrato, allora viene scelto il metodo draw per i quadrati e non 
	//il metodo draw per le figure (che sarebbe un metodo vuoto)


}
