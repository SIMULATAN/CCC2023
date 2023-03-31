package at.htlleonding.diegaertner.cc2023;

import at.htlleonding.diegaertner.cc2023.util.FileUtils;

import java.util.List;
import java.util.Objects;

public abstract class Level {

	private final int level;
	protected int subLevels;
	protected String levelTemplate;
	private final boolean debug;

	public Level(boolean debug) {
		this.level = Integer.parseInt(this.getClass().getSimpleName().substring("Level".length(), "Level".length() + 1));
		this.subLevels = 0;
		this.levelTemplate = "level%level%_%sublevel%";
		this.debug = debug;
	}

	public final void solve() {
		System.out.println("---- Solving level " + level + " ----");
		if (debug) {
			String levelName = levelTemplate
				.replace("%level%", String.valueOf(level))
				.replace("%sublevel%", "example");

			Object result = solve(FileUtils.getInput(levelName), -1);
			System.out.println("Result: " + result);
			FileUtils.write(levelName, Objects.toString(result));
			return;
		}

		for (int i = 1; i <= subLevels; i++) {
			System.out.println("---- Solving sublevel " + i + " ----");
			String levelName = levelTemplate
				.replace("%level%", String.valueOf(level))
				.replace("%sublevel%", String.valueOf(i));

			Object result = solve(FileUtils.getInput(levelName), i);
			System.out.println("Result: " + result);
			FileUtils.write(levelName, Objects.toString(result));
		}
	}

	protected abstract Object solve(List<String> input, int subLevel);
}
