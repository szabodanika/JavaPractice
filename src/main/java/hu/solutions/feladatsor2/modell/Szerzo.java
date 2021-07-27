package hu.solutions.feladatsor2.modell;

public class Szerzo {

	// TODO Ide ird az 1. feladat megoldasat

	private int szam;
	private String nev;
	private int szuletesiEv;

	public Szerzo(int szam, String nev, int szuletesiEv) {
		this.szam = szam;
		this.nev = nev;
		this.szuletesiEv = szuletesiEv;
	}

	@Override
	public String toString() {
		return "Szerzo{" +
				"szam=" + szam +
				", nev='" + nev + '\'' +
				", szuletesiEv=" + szuletesiEv +
				'}';
	}

	public int getSzam() {
		return szam;
	}

	public String getNev() {
		return nev;
	}

	public int getSzuletesiEv() {
		return szuletesiEv;
	}
}
