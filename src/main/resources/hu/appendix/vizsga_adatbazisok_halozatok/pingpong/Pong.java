package hu.appendix.vizsga_adatbazisok_halozatok.pingpong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Pong {

	private static final int PORT = 12345;

	public static void main(String[] args) {
		while (true) {
			System.out.println("Pong varakozik...");
			try (
					ServerSocket serverSocket = new ServerSocket(PORT);
					Socket clientSocket = serverSocket.accept();
					PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
					BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
			) {

				// TODO ide ird a 2. feladat megoldasat

			} catch (IOException ioException) {
				System.out.println("Kapcsolati hiba!");
			}
		}
	}


}
