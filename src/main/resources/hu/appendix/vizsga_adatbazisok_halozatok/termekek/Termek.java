package hu.appendix.vizsga_adatbazisok_halozatok.termekek;

public class Termek {
	private int id;
	private String megnevezes;
	private int ar;

	public Termek(int id, String megnevezes, int ar) {
		this.id = id;
		this.megnevezes = megnevezes;
		this.ar = ar;
	}

	@Override
	public String toString() {
		return "Termek{" +
				"id=" + id +
				", megnevezes='" + megnevezes + '\'' +
				", ar=" + ar +
				'}';
	}

	public int getId() {
		return id;
	}

	public String getMegnevezes() {
		return megnevezes;
	}

	public int getAr() {
		return ar;
	}
}
