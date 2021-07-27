package hu.feladatsor2;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		System.out.println("###		FELADAT 2		###");
		try {
			Feladatok.feladat2();
			if(!Feladatok.konyvek.isEmpty() && !Feladatok.kiadok.isEmpty() && !Feladatok.szerzok.isEmpty()) {
				System.out.println("Beolvasas Sikeres!");
			} else {
				System.out.println("Beolvasas Hianyos!");
			}
		} catch (IOException ioException) {
			System.out.println("Beolvasas Sikertelen!");
			System.out.println(ioException.getMessage());
		}
		System.out.println("###		FELADAT 3		###");
		Feladatok.feladat3();
		System.out.println("###		FELADAT 4		###");
		Feladatok.feladat4();
		System.out.println("###		FELADAT 5		###");
		Feladatok.feladat5();
		System.out.println("###		FELADAT 6		###");
		Feladatok.feladat6();
		System.out.println("###		FELADAT 7		###");
		Feladatok.feladat7();
		System.out.println("###		FELADAT 8		###");
		Feladatok.feladat8();
		System.out.println("###		FELADAT 9		###");
		Feladatok.feladat9();
		System.out.println("###		FELADAT 10		###");
		Feladatok.feladat10();
	}


}
