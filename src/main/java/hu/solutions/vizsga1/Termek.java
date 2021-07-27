package hu.solutions.vizsga1;

public class Termek {

	// TODO ennek az osztalynak a kiegeszitese az 1. feladat

	private String elnevezes;
	private String kategoria;
	private int ar;

	public Termek(String elnevezes, String kategoria, int ar) {
		this.elnevezes = elnevezes;
		this.kategoria = kategoria;
		this.ar = ar;
	}

	public String toString() {
		return elnevezes + "\t" + kategoria + "\t" + ar + " Ft";
	}

	String getElnevezes() {
		return elnevezes;
	}

	String getKategoria() {
		return kategoria;
	}

	int getAr() {
		return ar;
	}
}
