
import org.junit.jupiter.api.Test;
import verseny.Versenyauto;
import verseny.Versenyzo;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		Versenyzo versenyzo = new Versenyzo("Teszt Versenyzo", 2000);
		assertEquals("Teszt Versenyzo (2000)", versenyzo.toString());
	}
}