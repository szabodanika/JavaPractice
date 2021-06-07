package hu.feladatsor1;

import hu.feladatsor1.ciklusok.Ciklusok;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CiklusokTeszt {

	private Ciklusok ciklusok = new Ciklusok();

	@Test
	void szamOsszeg10ig() {
		assertEquals(1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10, ciklusok.szamOsszeg10ig());
	}

	@Test
	void szamOsszeg() {
		assertEquals(-6, ciklusok.szamOsszeg(-3));
		assertEquals(0, ciklusok.szamOsszeg(0));
		assertEquals(10, ciklusok.szamOsszeg(4));
	}

	@Test
	void legnagyobbPrim() {
		assertEquals(-1, ciklusok.legnagyobbPrim(0));
		assertEquals(2, ciklusok.legnagyobbPrim(2));
		assertEquals(7, ciklusok.legnagyobbPrim(10));
	}

	@Test
	void fibonacci() {
		assertEquals(-1, ciklusok.fibonacci(-1));
		assertEquals(1, ciklusok.fibonacci(1));
		assertEquals(13, ciklusok.fibonacci(7));
	}

	@Test
	void legnagyobbKozosOszto() {
		assertEquals(-1, ciklusok.legnagyobbKozosOszto(0, 4));
		assertEquals(1, ciklusok.legnagyobbKozosOszto(3, 7));
		assertEquals(6, ciklusok.legnagyobbKozosOszto(54, 24));
	}
}