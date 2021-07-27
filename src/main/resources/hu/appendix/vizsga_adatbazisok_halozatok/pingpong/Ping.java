package hu.appendix.vizsga_adatbazisok_halozatok.pingpong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Ping {

	private static final String HOST = "localhost";
	private static final int PORT = 12345;

	public static void main(String[] args) {

		try (
				Socket socket = new Socket(HOST, PORT);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
		) {

			// TODO ide ird az 1. feladat megoldasat

		} catch (IOException e) {
			System.out.println("Kapcsolati hiba");
		}

	}

}
