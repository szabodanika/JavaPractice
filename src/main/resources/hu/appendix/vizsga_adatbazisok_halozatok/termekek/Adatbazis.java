package hu.appendix.vizsga_adatbazisok_halozatok.termekek;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class Adatbazis {

	static Connection conn = null;

	private Adatbazis(){}

	static void csatlakozas() {
		System.out.println("Csatlakozas...");
		try {
			// TODO ide ird a 3. feladat megoldasat
			System.out.println("JDBC meghajto sikeresen betoltve.");
		} catch (Exception exception) {
			System.out.println("Nem sikerult betolteni a JDBC meghajtot!");
		}

		try {
			// TODO ide ird a 4. feladat megoldasat
			System.out.println("Sikeresen csatlakozva a MySQL adatbazishoz.");
		} catch (Exception exception) {
			System.out.println("Nem sikerult csatlakozni a MySQL adatbazishoz!: " + exception.getMessage());
		}
	}

	static List<Termek> lekerdezes(String lekerdezes) {
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(lekerdezes)){

			List<Termek> termekek = new ArrayList<>();

			// TODO ide ird a 5. feladat megoldasat

			return termekek;
		} catch (SQLException sqlException){
			System.out.println("SQL Lekerdezes hiba: " + sqlException.getMessage());
			return null;
		}
	}

	static void bezaras() {
		// TODO ide ird a 6. feladat megoldasat
	}

}

