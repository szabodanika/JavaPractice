package hu.vizsga1;

public class Aruhaz {

	private static Termek[] termekek;

	public static void main(String[] args) {
		termekek = new Termek[]{
				new Termek("Alma", "Elelmiszer", 50),
				new Termek("Banan", "Elelmiszer", 40),
				new Termek("Korte", "Elelmiszer", 45),
				new Termek("Csokolade", "Elelmiszer", 75),
				new Termek("Tej 1L", "Elelmiszer", 50),
				new Termek("Tej 2L", "Elelmiszer", 80),
				new Termek("Tojas", "Elelmiszer", 15),
				new Termek("Piros Telefon", "Elektronika", 21200),
				new Termek("Kek Telefon", "Elektronika", 22200),
				new Termek("AA Elem", "Elektronika", 560),
				new Termek("USB kabel", "Elektronika", 2280),
				new Termek("Memoria Kartya", "Elektronika", 3920),
				new Termek("Laptop", "Elektronika", 43920),
				new Termek("Hangszoro", "Elektronika", 13920),
				new Termek("Eger", "Elektronika", 5920)
		};

		// 2. feladat
		megjelenit();

		// 3. feladat
		termekekSzama();

		// 4. feladat
		elektronikaiTermekekSzama();

		// 5. feladat
		legdragabbTermek();

		// 6. feladat
		elelmiszerekAtlagAra();

	}

	private static void megjelenit() {
		//TODO ide ird az 2. feladat megoldasat
		System.out.println();
	}

	private static void termekekSzama() {
		int eredmeny = 0;
		//TODO ide ird az 3. feladat megoldasat
		System.out.println(eredmeny);
	}

	private static void elektronikaiTermekekSzama() {
		int eredmeny = 0;
		//TODO ide ird a 4. feladat megoldasat
		System.out.println(eredmeny);
	}

	private static void legdragabbTermek() {
		Termek termek = null;
		//TODO ide ird a 5. feladat megoldasat
		System.out.println(termek);
	}

	private static void elelmiszerekAtlagAra() {
		int eredmeny = 0;
		//TODO ide ird a 6. feladat megoldasat
		System.out.println(eredmeny);
	}

}
