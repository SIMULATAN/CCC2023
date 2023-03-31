package at.htlleonding.diegaertner.cc2023.levels;

import at.htlleonding.diegaertner.cc2023.Level;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Level3 extends Level {

	public Level3(boolean debug) {
		super(false);
		this.subLevels = 5;
		System.out.println("Level1 created in debug mode: " + debug);
	}

	@Override
	public Object solve(List<String> input, int sublevel) {
		input.remove(0);
		input.remove(0);

		List<String> result = new LinkedList<>();
		List<String> currentComb = new LinkedList<>();
		for (int lineIndex = 0; lineIndex < input.size(); lineIndex++) {
			String line = input.get(lineIndex);
			if (line.equals("") || lineIndex == input.size() - 1) {
				if (lineIndex == input.size() - 1) currentComb.add(line);

				boolean x = solveComb(currentComb);
				System.out.println(x);
				result.add(x ? "FREE" : "TRAPPED");
				currentComb.clear();
			} else {
				currentComb.add(line);
			}
		}

		return String.join("\n", result.toArray(String[]::new));
	}

	private boolean solveComb(List<String> currentComb) {
		System.out.println("-----");
		System.out.println(currentComb);

		final int waspY = IntStream.range(0, currentComb.size()).filter(i -> currentComb.get(i).contains("W")).findFirst().getAsInt();
		final int waspX = currentComb.stream().filter(s -> s.contains("W")).findFirst().get().indexOf("W");

		System.out.println("Wasp at " + waspX + " " + waspY);

		// check to right
		boolean works = true;
		for (int i = waspX + 2; i < currentComb.get(waspY).length(); i += 2) {
			if (currentComb.get(waspY).charAt(i) == 'X') {
				works = false;
				break;
			}
		}
		if (works) {
			System.out.println("works in RIGHT");
			return true;
		}

		// check to left
		works = true;
		for (int i = waspX - 2; i >= 0; i -= 2) {
			if (currentComb.get(waspY).charAt(i) == 'X') {
				works = false;
				break;
			}
		}

		if (works) {
			System.out.println("works in LEFT");
			return true;
		}

		// check to bottom right
		works = true;
		for (int i = waspY + 1, j = waspX + 1; i < currentComb.size() && j < currentComb.get(i).length(); i++, j++) {
			if (currentComb.get(i).charAt(j) == 'X') {
				works = false;
				break;
			}
		}

		if (works) {
			System.out.println("works in BOTTOM RIGHT");
			return true;
		}

		// check to bottom left
		works = true;
		for (int i = waspY + 1, j = waspX - 1; i < currentComb.size() && j >= 0; i++, j--) {
			if (currentComb.get(i).charAt(j) == 'X') {
				works = false;
				break;
			}
		}

		if (works) {
			System.out.println("works in BOTTOM LEFT");
			return true;
		}

		// check to top right
		works = true;
		for (int i = waspY - 1, j = waspX + 1; i >= 0 && j < currentComb.get(i).length(); i--, j++) {
			if (currentComb.get(i).charAt(j) == 'X') {
				works = false;
				break;
			}
		}

		if (works) {
			System.out.println("works in TOP RIGHT");
			return true;
		}

		// check to top left
		works = true;
		for (int i = waspY - 1, j = waspX - 1; i >= 0 && j >= 0; i--, j--) {
			if (currentComb.get(i).charAt(j) == 'X') {
				works = false;
				break;
			}
		}

		if (works) {
			System.out.println("works in TOP LEFT");
			return true;
		}
		return false;
	}
}
