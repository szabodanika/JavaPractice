package hu.javase1;

import hu.javase1.tombok.Tombok;

import static org.junit.jupiter.api.Assertions.*;

class TombokTeszt {

	private Tombok tombok = new Tombok();

	@org.junit.jupiter.api.Test
	void szum() {
		assertEquals(0, tombok.szum(new int[]{}));
		assertEquals(0, tombok.szum(new int[]{-2, 2}));
		assertEquals(6, tombok.szum(new int[]{1, 2, 3}));
	}

	@org.junit.jupiter.api.Test
	void ujTomb10HosszuIntTomb() {
		assertEquals(new int[]{0,0,0,0,0,0,0,0,0,0}, tombok.uj10HosszuIntTomb());
	}

	@org.junit.jupiter.api.Test
	void ujIntTombMegadottSzamokkal() {
		assertEquals(new int[]{1, 2, 3, 4}, tombok.ujIntTombMegadottSzamokkal(1, 2, 3, 4));
		assertEquals(new int[]{5, 5, 5, 5}, tombok.ujIntTombMegadottSzamokkal(5, 5, 5, 5));
	}

	@org.junit.jupiter.api.Test
	void tombHossz() {
		assertEquals(0, tombok.tombHossz(new int[]{}));
		assertEquals(2, tombok.tombHossz(new int[]{-2, 2}));
		assertEquals(3, tombok.tombHossz(new int[]{1, 2, 3}));
	}

	@org.junit.jupiter.api.Test
	void legkisebb() {
		assertEquals(-1, tombok.legkisebb(new int[]{}));
		assertEquals(-2, tombok.legkisebb(new int[]{-2, 2}));
		assertEquals(1, tombok.legkisebb(new int[]{1, 2, 3}));
	}

	@org.junit.jupiter.api.Test
	void legnagyobb() {
		assertEquals(-1, tombok.legnagyobb(new int[]{}));
		assertEquals(2, tombok.legnagyobb(new int[]{-2, 2}));
		assertEquals(3, tombok.legnagyobb(new int[]{1, 2, 3}));
	}

	@org.junit.jupiter.api.Test
	void atlag() {
		assertEquals(0, tombok.atlag(new int[]{}));
		assertEquals(0, tombok.atlag(new int[]{-2, 2}));
		assertEquals(2, tombok.atlag(new int[]{1, 2, 3}));
		assertEquals(3, tombok.atlag(new int[]{2, 0, 5, 7}));
	}

	@org.junit.jupiter.api.Test
	void keres() {
		assertEquals(1, tombok.keres(new int[]{1, 3, 6}, 3));
		assertEquals(-1, tombok.keres(new int[]{1, 3, 6}, 2));
	}

	@org.junit.jupiter.api.Test
	void szamol() {
		assertEquals(1, tombok.keres(new int[]{1, 3, 3}, 1));
		assertEquals(2, tombok.keres(new int[]{1, 3, 3}, 3));
		assertEquals(0, tombok.keres(new int[]{1, 3, 3}, 2));
	}

	@org.junit.jupiter.api.Test
	void tukroz() {
		int[] tomb = {1, 2, 3, 4, 5};
		tombok.tukroz(tomb);
		assertEquals(new int[]{5, 4, 3, 2, 1}, tomb);
		tombok.tukroz(tomb);
		assertEquals(new int[]{1, 2, 3, 4, 5}, tomb);
	}

	@org.junit.jupiter.api.Test
	void osszefuz() {
		assertEquals("java", tombok.osszefuz(new String[]{"j", "a", "v", "a"}));
		assertEquals("hello world!", tombok.osszefuz(new String[]{"hello", " ", "world!"}));
		assertEquals("", tombok.osszefuz(new String[]{}));
	}
}