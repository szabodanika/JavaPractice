package hu.solutions.feladatsor2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import hu.solutions.feladatsor2.modell.*;

public class Feladatok {

	static List<Konyv> konyvek = new ArrayList<>();
	static List<Szerzo> szerzok = new ArrayList<>();
	static List<Kiado> kiadok = new ArrayList<>();

	static void feladat2() throws IOException {
		// TODO Ide ird a 2. feladat megoldasat
		// szerzok beolvasasa
		BufferedReader br = new BufferedReader(new FileReader("./src/main/java/hu/solutions/feladatsor2/szerzok.csv"));
		String s;
		String[] e;
		br.readLine();
		while ((s = br.readLine()) != null) {
			e = s.split(",");
			szerzok.add(new Szerzo(
					Integer.parseInt(e[0]),
					e[1],
					Integer.parseInt(e[2])
			));
		}
		br.close();

		// kiadok beolvasasa
		br = new BufferedReader(new FileReader("./src/main/java/hu/solutions/feladatsor2/kiadok.csv"));
		br.readLine();
		while ((s = br.readLine()) != null) {
			e = s.split(",");
			kiadok.add(new Kiado(
					Integer.parseInt(e[0]),
					e[1],
					e[2]
			));
		}
		br.close();

		// konyvek beolvasasa
		br = new BufferedReader(new FileReader("./src/main/java/hu/solutions/feladatsor2/konyvek.csv"));
		br.readLine();
		while ((s = br.readLine()) != null) {
			e = s.split(",");
			konyvek.add(new Konyv(
					Integer.parseInt(e[0]),
					e[1],
					szerzok.get(Integer.parseInt(e[2]) - 1),
					kiadok.get(Integer.parseInt(e[3]) - 1),
					Integer.parseInt(e[4]),
					Integer.parseInt(e[5]),
					Integer.parseInt(e[6]),
					e[7].equals("1")
			));
		}
		br.close();
		// olvasd be az ertekeket csv-bol
	}

	static void feladat3() {
		// TODO Ide ird a 3. feladat megoldasat

		for (int i = 0; i < 2; i++) {
			System.out.println(szerzok.get(i));
		}

		for (int i = 0; i < 2; i++) {
			System.out.println(kiadok.get(i));
		}

		for (int i = 0; i < 2; i++) {
			System.out.println(konyvek.get(i));
		}



		// ird ki az osszes konyvet, szerzot es kiadot
	}

	static void feladat4() {
		// TODO Ide ird a 4. feladat megoldasat

		float atlag = 0;
		for(Konyv k : konyvek) atlag += k.getAr();
		atlag/=konyvek.size();

		System.out.printf("Atlagos konyv ar: %.2f Ft\n", atlag);

		// szamold ki az atlagos konyv arat
	}

	static void feladat5() {
		// TODO Ide ird a 5. feladat megoldasat

		HashMap<Szerzo, Integer> szerzoKonyvDarab = new HashMap<>();

		for(Konyv k : konyvek) {
			if(szerzoKonyvDarab.containsKey(k.getSzerzo())){
				szerzoKonyvDarab.put(k.getSzerzo(), szerzoKonyvDarab.get(k.getSzerzo()) + 1);
			} else {
				szerzoKonyvDarab.put(k.getSzerzo(), 0);
			}
		}

		Szerzo legtobbKonyv = null;

		for(Map.Entry<Szerzo, Integer> e : szerzoKonyvDarab.entrySet()) {
			if(legtobbKonyv == null) legtobbKonyv = e.getKey();
			else if(e.getValue() > szerzoKonyvDarab.get(legtobbKonyv)) legtobbKonyv = e.getKey();
		}

		System.out.printf("A legtobb konyve %s szerzonek van: %d db\n", legtobbKonyv.getNev(), szerzoKonyvDarab.get(legtobbKonyv));

		// melyik szerzonek van a legtobb konyve?
	}

	static void feladat6() {
		// TODO Ide ird a 6. feladat megoldasat

		Konyv legdragabb = konyvek.get(0);

		for(Konyv k : konyvek) {
			if (legdragabb.getAr() < k.getAr()) legdragabb = k;
		}

		System.out.printf("A legdragabb konyv %s - %d Ft\n", legdragabb.getCim(), legdragabb.getAr());
		// szamold ki az legdragabb konyv arat
	}

	static void feladat7() {
		// TODO Ide ird a 7. feladat megoldasat

		List<Integer> evek = new ArrayList<>();
		for(Konyv k : konyvek) {
			if(!evek.contains(k.getEv())) evek.add(k.getEv());
		}

		evek.sort(Integer::compare);

		for(int i : evek) {
			System.out.println(i);
		}

		// listazd az osszes evet amiben lett konyv kiadva (minden evet egyszer, novekvo sorrendben)
	}

	static void feladat8() {
		// TODO Ide ird a 8. feladat megoldasat

		float atlag = 0;
		int szam = 0;
		for(Konyv k : konyvek) {
			if(k.getSzerzo().getSzuletesiEv() > 1990) {
				atlag += k.getAr();
				szam++;
			}
		}
		atlag/=szam;

		System.out.printf("1990 utan szuletett szerzok konyveinek atlagos ara: %.2f Ft\n", atlag);

		// szamold ki az 1990 utan szuletett szerzok konyveinek atlagarat
	}

	static void feladat9() {
		// TODO Ide ird a 9. feladat megoldasat

		Kiado max = kiadok.get(0);
		int maxDarab = -1;

		for(Kiado k : kiadok) {
			int szam = 0;
			for(Konyv kv : konyvek) {
				if(kv.getSzerzo().getSzuletesiEv() > 1990 && kv.getKiado().equals(k)) {
					szam++;
				}
			}

			if(szam > maxDarab) {
				max = k;
				maxDarab = szam;
			}
		}

		System.out.printf("A legtobb 1990 utani szuletesu szerzo altal irt konyvet %s adta ki: %d db\n",max.getNev(), maxDarab);

		// melyik konyvkiado adott ki a legtobb konyvet 1990 utan szuletett szerzoktol?
	}

	static void feladat10() {
		// TODO Ide ird a 10. feladat megoldasat

		Kiado max = kiadok.get(0);
		float oldalAr = -1;

		for(Kiado k : kiadok) {
			int oldalOsszeg = 0;
			int arOsszeg = 0;
			for(Konyv kv : konyvek) {
				if(kv.getKiado().equals(k)) {
					oldalOsszeg += kv.getOldal();
					arOsszeg += kv.getAr();
				}
			}

			if((float) arOsszeg/oldalOsszeg > oldalAr) {
				max = k;
				oldalAr = (float) arOsszeg/oldalOsszeg;
			}
		}

		System.out.printf("A legnagyobb atlagos Ft/oldal erteku kiado %s: %.2f Ft\n", max.getNev(), oldalAr);

		// melyik konyvkiado atlagos ar/oldal erteke a legnagyobb?
	}

}
