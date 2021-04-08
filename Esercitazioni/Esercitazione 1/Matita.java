// Matita.java
public class Matita {
	// Attributi statici (comuni a tutte le istanze di Matita) e final (non
	// modificabili)
	public static final int minStelo = 2;
	public static final int maxStelo = 15;
	public static final int maxPunta = 4;

	// Attributi non statici (proprii di ogni istanza) stelo e punta
	// Notare l'uso di attributi privati
	private int stelo;
	private int punta;

	/** Metodo costruttore */
	public Matita(int lunghezzaStelo) {
		assert (lunghezzaStelo >= minStelo && lunghezzaStelo <= maxStelo) : "Lo stelo deve essere compreso tra " + minStelo + " e " + maxStelo;
		stelo = lunghezzaStelo;
		punta = maxPunta;
	}

	/**
	 * disegna restituisce true quando la matita ha ancora punta, e ne riduce la
	 * punta di 1 mm. Restituisce false se la punta e' finita.
	 */
	public boolean disegna() {
		if (punta >= 1) {
			--punta;
			return true;
		} else
			return false;
	}

	/**
	 * "tempera" riduce di un 1mm la matita, e allunga di 1mm la punta a meno che la
	 * lunghezza della punta sia gia' il massimo.
	 */
	public boolean tempera() {
		if (stelo > minStelo) {
			--stelo;
			punta = Math.min(++punta, maxPunta);
			return true;
		} else
			return false;
	}

	/** Metodi getters per stelo e punta */
	public int getStelo() {
		return stelo;
	}

	public int getPunta() {
		return punta;
	}
}
