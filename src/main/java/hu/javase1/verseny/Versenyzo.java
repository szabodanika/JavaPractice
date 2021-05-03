package hu.javase1.verseny;

public class Versenyzo {

	public String nev;

	public int szuletesiEv;

	public Versenyzo(String nev, int szuletesiEv) {
		// TODO 1. feladat
	}

	public String getNev() {
		// TODO 1. feladat
		return "";
	}

	public int getSzuletesiEv() {
		// TODO 1. feladat
		return 0;
	}

	@Override
	public String toString() {
		return this.nev + " (" + this.szuletesiEv + ")";
	}
}
