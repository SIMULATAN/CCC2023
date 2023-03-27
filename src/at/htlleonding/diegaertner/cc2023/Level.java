package at.htlleonding.diegaertner.cc2023;

import at.htlleonding.diegaertner.cc2023.util.FileUtils;

import java.util.List;

public class Level {

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
			solve(FileUtils.getInput(levelTemplate
					.replace("%level%", String.valueOf(level))
					.replace("%sublevel%", "example")),
				-1
			);
			return;
		}

		for (int i = 1; i <= subLevels; i++) {
			System.out.println("---- Solving sublevel " + i + " ----");
			solve(FileUtils.getInput(levelTemplate
					.replace("%level%", String.valueOf(level))
					.replace("%sublevel%", String.valueOf(i))),
				i
			);
		}
	}

	public void solve(List<String> input, int subLevel) {
		// implemented by inheritors
	}
}
