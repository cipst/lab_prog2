//Elicottero.java
public class Elicottero {
	// Attributi di ogni istanza della classe
	private int x, y, altitude, speed, verticalSpeed;
	private double track;// track: angolo in radianti tra 0 e 2pi --> 0 e 360 gradi

	/**
	 * Costruiamo un elicottero sospeso nelle coordinate (0,0,altitude) con
	 * velocita' nulle e angolo di direzione 0
	 */
	public Elicottero(int x, int y, int altitude) {
		assert altitude >= 0 : "L'altitudine non puo' essere negativa!";
		this.x = x;
		this.y = y;
		this.altitude = altitude;
		speed = 0;
		track = 0.0;
	}

	// Aggiungiamo un metodo get() per ogni attributo della classe
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getAltitude() {
		return altitude;
	}

	public int getSpeed() {
		return speed;
	}

	public int getVerticalSpeed() {
		return verticalSpeed;
	}

	public double getTrack() {
		return track;
	}

	/**
	 * Metodi set per speed, verticalSpeed e track. Non consento invece di cambiare
	 * le coordinate "istantaneamente"
	 */
	public void setSpeed(int speed) {
		assert speed >= 0 : "La valocita' non puo' essere negativa!";
		this.speed = speed;
	}

	public void setVerticalSpeed(int verticalSpeed) {
		this.verticalSpeed = verticalSpeed;
	}

	public void setTrack(double track) {
		assert (track >= 0.0 && track <= 360.0) : "La direzione deve essere compresa tra 0 e 360 gradi (0 e 2pi)";
		this.track = track;
	}

	/** Consento di cambiare le coordinate con lo scorrere del tempo */
	public void elapse(double time) {
		this.y = (int) ((this.speed * time) * Math.sin(this.track)); // this.speed * time ==> ricavo lo spostamento
																		// effettivo in base al tempo(km/h * h = km)
																		// siccome mi sposto su y (ordinate) devo
																		// moltiplicare per il seno dell'angolo
		this.x = (int) ((this.speed * time) * Math.cos(this.track));// this.speed * time ==> ricavo lo spostamento
																	// effettivo in base al tempo(km/h * h = km)
																	// siccome mi sposto su x (ascisse) devo
																	// moltiplicare per il coseno dell'angolo
		this.altitude += (int) (this.verticalSpeed * time);// this.verticalSpeed * time ==> ricavo lo spostamento
															// verticale effettivo in base al tempo(km/h * h = km)
															// siccome mi sposto su this.altitude, sommo allo
															// spostamento effettivo il precedente valore dell'altitude
	}
}
