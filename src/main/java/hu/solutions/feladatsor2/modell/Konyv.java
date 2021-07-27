package hu.solutions.feladatsor2.modell;

import hu.solutions.feladatsor2.modell.Szerzo;
import hu.solutions.feladatsor2.modell.Kiado;
public class Konyv {

	// TODO Ide ird az 1. feladat megoldasat

	private int szam;
	private String cim;
	private Szerzo szerzo;
	private Kiado kiado;
	private int ev;
	private int oldal;
	private int ar;
	private boolean kemenyboritos;

	public Konyv(int szam, String cim, Szerzo szerzo, Kiado kiado, int ev, int oldal, int ar, boolean kemenyboritos) {
		this.szam = szam;
		this.cim = cim;
		this.szerzo = szerzo;
		this.kiado = kiado;
		this.ev = ev;
		this.oldal = oldal;
		this.ar = ar;
		this.kemenyboritos = kemenyboritos;
	}

	@Override
	public String toString() {
		return "Konyv{" +
				"szam=" + szam +
				", cim='" + cim + '\'' +
				", szerzo=" + szerzo +
				", kiado=" + kiado +
				", ev=" + ev +
				", oldal=" + oldal +
				", ar=" + ar +
				", kemenyboritos=" + kemenyboritos +
				'}';
	}

	public int getSzam() {
		return szam;
	}

	public String getCim() {
		return cim;
	}

	public Szerzo getSzerzo() {
		return szerzo;
	}

	public Kiado getKiado() {
		return kiado;
	}

	public int getEv() {
		return ev;
	}

	public int getOldal() {
		return oldal;
	}

	public int getAr() {
		return ar;
	}

	public boolean isKemenyboritos() {
		return kemenyboritos;
	}
}
