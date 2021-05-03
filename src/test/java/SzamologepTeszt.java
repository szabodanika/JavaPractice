import org.junit.jupiter.api.Test;
import szamologep.Szamologep;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SzamologepTeszt {

	private Szamologep szamologep = new Szamologep();

	@Test
	void osszead() {
		assertEquals(3, szamologep.osszead(1, 2));
		assertEquals(2, szamologep.osszead(-2, 4));
		assertEquals(-5, szamologep.osszead(-2, -3));
		assertEquals(0, szamologep.osszead(0, 0));
	}

	@Test
	void kivon() {
		assertEquals(1, szamologep.kivon(4, 3));
		assertEquals(-5.5, szamologep.kivon(-2.5f, 3));
		assertEquals(-2.25, szamologep.kivon(0, -2.25f));
		assertEquals(0, szamologep.kivon(0, 0));
	}

	@Test
	void szoroz() {
		assertEquals(0, szamologep.szoroz(0, 2));
		assertEquals(4, szamologep.szoroz(1, 4));
		assertEquals(6, szamologep.szoroz(2, 3));
		assertEquals(-2, szamologep.szoroz(2, -1));
		assertEquals(1, szamologep.szoroz(10, 0.1f));
	}

	@Test
	void oszt() {
		assertEquals(2, szamologep.oszt(4, 2));
		assertEquals(-0.5, szamologep.oszt(-4, 8));
		assertEquals(Float.MIN_VALUE, szamologep.oszt(3, 0));
	}

	@Test
	void hatvany() {
		assertEquals(8, szamologep.hatvany(2, 3));
		assertEquals(0.5, szamologep.hatvany(2, -2));
		assertEquals(0, szamologep.hatvany(0, 2.25f));
	}

	@Test
	void negyzetgyok() {
		assertEquals(2, szamologep.negyzetgyok(4));
		assertEquals(1, szamologep.negyzetgyok(1));
		assertEquals(-1, szamologep.negyzetgyok(0));
	}
}