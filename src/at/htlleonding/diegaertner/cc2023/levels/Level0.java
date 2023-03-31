package at.htlleonding.diegaertner.cc2023.levels;

import at.htlleonding.diegaertner.cc2023.Level;

import java.util.List;

public class Level0 extends Level {

	public Level0(boolean debug) {
		super(debug);
		this.subLevels = 1;
		System.out.println("Level0 created in debug mode: " + debug);
	}

	@Override
	public Object solve(List<String> input, int sublevel) {
		System.out.println("Input for sublevel " + sublevel + ":");
		input.forEach(System.out::println);
		return "testing output";
	}
}
