package at.htlleonding.diegaertner.cc2023.levels;

import at.htlleonding.diegaertner.cc2023.Level;

import java.util.List;

public class Level1 extends Level {

	public Level1(boolean debug) {
		super(false);
		this.subLevels = 5;
		System.out.println("Level1 created in debug mode: " + debug);
	}

	@Override
	public Object solve(List<String> input, int sublevel) {
		System.out.println("Input for sublevel " + sublevel + ":");
		input.forEach(System.out::println);
		// count all "O"s in the lines
		int count = 0;
		for (String line : input) {
			for (char c : line.toCharArray()) {
				if (c == 'O') {
					count++;
				}
			}
		}
		return count;
	}
}
