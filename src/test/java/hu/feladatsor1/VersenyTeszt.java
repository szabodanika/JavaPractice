package hu.feladatsor1;

import hu.feladatsor1.verseny.Verseny;
import hu.feladatsor1.verseny.Versenyauto;
import hu.feladatsor1.verseny.Versenyzo;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class VersenyTeszt {

	@Test
	void konstruktor() {
		Versenyzo versenyzo = new Versenyzo("Teszt Versenyzo", 2000);
		assertEquals("Teszt Versenyzo", versenyzo.nev);
		assertEquals(2000, versenyzo.szuletesiEv);

		Versenyauto versenyauto = new Versenyauto("Gyarto", 1000, 10, versenyzo);
		assertEquals("Gyarto", versenyauto.gyarto);
		assertEquals(1000, versenyauto.tomeg);
		assertEquals(10, versenyauto.sebesseg);
	}

	@Test
	void getter() {
		Versenyzo versenyzo = new Versenyzo("Teszt Versenyzo", 2000);
		Versenyauto versenyauto = new Versenyauto("Gyarto", 1000, 10, versenyzo);
		assertEquals("Gyarto", versenyauto.getGyarto());
		assertEquals(1000, versenyauto.getTomeg());
		assertEquals(10, versenyauto.getSebesseg());

	}

	@Test
	void gyorsit() {
		Versenyzo versenyzo = new Versenyzo("Teszt Versenyzo", 2000);
		Versenyauto versenyauto = new Versenyauto("Gyarto", 800, 0, versenyzo);
		versenyauto.gyorsit(0);
		assertEquals(0, versenyauto.getSebesseg());
		versenyauto.gyorsit(10);
		assertEquals(10, versenyauto.getSebesseg());
		versenyauto.gyorsit(15);
		assertEquals(25, versenyauto.getSebesseg());
		versenyauto.gyorsit(20);
		assertEquals(40, versenyauto.getSebesseg());

		while (versenyauto.getSebesseg() < 200) versenyauto.gyorsit(15);

		assertEquals(200, versenyauto.getSebesseg());

		versenyauto = new Versenyauto("Gyarto", 1200, 0, versenyzo);
		versenyauto.gyorsit(0);
		assertEquals(0, versenyauto.getSebesseg());
		versenyauto.gyorsit(10);
		assertEquals(10, versenyauto.getSebesseg());
		versenyauto.gyorsit(15);
		assertEquals(20, versenyauto.getSebesseg());
		versenyauto.gyorsit(20);
		assertEquals(30, versenyauto.getSebesseg());

		while (versenyauto.getSebesseg() < 200) versenyauto.gyorsit(10);

		assertEquals(200, versenyauto.getSebesseg());

	}

	@Test
	void fekez() {
		Versenyzo versenyzo = new Versenyzo("Teszt Versenyzo", 2000);
		Versenyauto versenyauto = new Versenyauto("Gyarto", 800, 200, versenyzo);
		versenyauto.fekez(0);
		assertEquals(200, versenyauto.getSebesseg());
		versenyauto.fekez(10);
		assertEquals(190, versenyauto.getSebesseg());
		versenyauto.fekez(15);
		assertEquals(175, versenyauto.getSebesseg());
		versenyauto.fekez(20);
		assertEquals(160, versenyauto.getSebesseg());

		while (versenyauto.getSebesseg() > 0) versenyauto.fekez(15);

		assertEquals(0, versenyauto.getSebesseg());

		versenyauto = new Versenyauto("Gyarto", 1200, 200, versenyzo);
		versenyauto.fekez(0);
		assertEquals(200, versenyauto.getSebesseg());
		versenyauto.fekez(10);
		assertEquals(190, versenyauto.getSebesseg());
		versenyauto.fekez(15);
		assertEquals(180, versenyauto.getSebesseg());
		versenyauto.fekez(20);
		assertEquals(170, versenyauto.getSebesseg());

		while (versenyauto.getSebesseg() > 0) versenyauto.fekez(10);

		assertEquals(0, versenyauto.getSebesseg());
	}

	@Test
	void testVersenyAutoToString() {
		Versenyzo versenyzo = new Versenyzo("Teszt Versenyzo", 2000);
		Versenyauto versenyauto = new Versenyauto("Gyarto", 800, 200, versenyzo);
		assertEquals("""
				Nev: Teszt Versenyzo (2000)
				Auto: Gyarto (800kg)
				""", versenyauto.toString());
	}

	@Test
	void testVersenyzoToString() {
		Versenyzo versenyzo = new Versenyzo("Teszt Versenyzo", 2000);
		assertEquals("Teszt Versenyzo (2000)", versenyzo.toString());
	}

	@Test
	void verseny() {
		Verseny verseny = new Verseny();

		Versenyzo versenyzo1 = new Versenyzo("Teszt Versenyzo 1", 2000);
		Versenyzo versenyzo2 = new Versenyzo("Teszt Versenyzo 2", 2000);

		// elso versenyzo nyer
		Versenyauto versenyauto1 = new Versenyauto("Gyarto", 800, 200, versenyzo1);
		Versenyauto versenyauto2 = new Versenyauto("Gyarto", 1000, 200, versenyzo2);

		assertEquals(versenyauto1.getVersenyzo().nev, verseny.verseny(versenyauto1, versenyauto2));

		// masodik versenyzo nyer
		versenyauto1.tomeg = 1000;
		versenyauto2.tomeg = 800;

		assertEquals(versenyauto2.getVersenyzo().nev, verseny.verseny(versenyauto1, versenyauto2));


		//mindketto nyer
		versenyauto2.tomeg = 1000;

		Versenyauto finalVersenyauto1 = versenyauto1;
		Versenyauto finalVersenyauto2 = versenyauto2;
		assertTimeout(Duration.ofSeconds(1), () -> {
			while (!verseny.verseny(finalVersenyauto1, finalVersenyauto2).equals(versenyauto1.getVersenyzo().nev));
			while (!verseny.verseny(finalVersenyauto1, finalVersenyauto2).equals(versenyauto2.getVersenyzo().nev));
		}, "Egyenlo tomegu versenyautok versenyzesenel mindket versenyzonek legyen lehetosege nyerni!");
	}
}