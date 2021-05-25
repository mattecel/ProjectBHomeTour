package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import game.Game;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in;
		String input;
		String output;
		Game game = new Game();
		in = new BufferedReader(new InputStreamReader(System.in));
		game.showIntro();
		do {
			System.out.println("> ");
			input = in.readLine();
			output = game.RunCommand(input);
			System.out.println(output);
		} while (!"q".equals(input));
	}
}
