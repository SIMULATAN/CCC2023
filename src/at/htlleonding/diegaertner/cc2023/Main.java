package at.htlleonding.diegaertner.cc2023;

import at.htlleonding.diegaertner.cc2023.levels.Level0;

public class Main {
	public static void main(String[] args) {
		boolean debug = args.length > 0 && args[0].equals("debug");

		Level level = new Level0(debug);

		level.solve();
	}
}