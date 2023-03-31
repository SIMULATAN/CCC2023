package at.htlleonding.diegaertner.cc2023.levels;

import at.htlleonding.diegaertner.cc2023.Level;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Level4 extends Level {

	public Level4(boolean debug) {
		super(false);
		this.subLevels = 5;
		System.out.println("Level1 created in debug mode: " + debug);
	}

	@Override
	public Object solve(List<String> input, int sublevel) {
		if (sublevel == 1) return null;

		input.remove(0);
		input.remove(0);

		List<String> result = new LinkedList<>();
		List<String> currentComb = new LinkedList<>();
		for (int lineIndex = 0; lineIndex < input.size(); lineIndex++) {
			String line = input.get(lineIndex);
			if (line.equals("") || lineIndex == input.size() - 1) {
				if (lineIndex == input.size() - 1) currentComb.add(line);

				final int waspY = IntStream.range(0, currentComb.size()).filter(i -> currentComb.get(i).contains("W")).findFirst().getAsInt();
				final int waspX = currentComb.stream().filter(s -> s.contains("W")).findFirst().get().indexOf("W");

				boolean x = solveComb(currentComb, waspX, waspY);
				System.out.println(x);
				result.add(x ? "FREE" : "TRAPPED");
				currentComb.clear();
			} else {
				currentComb.add(line);
			}
		}

		return String.join("\n", result.toArray(String[]::new));
	}

	private boolean solveComb(List<String> currentComb, int waspX, int waspY) {
		System.out.println("-----");
		System.out.println(currentComb);

		// check if wasp is trapped, if yes, return false

		currentComb.set(waspY, currentComb.get(waspY).substring(0, waspX) + "W" + currentComb.get(waspY).substring(waspX + 1));

		if (isWAtEdge(currentComb)) return true;

		// call solveComb for all possible directions, hex is 6 directions

		// up right
		if (waspY > 0 && waspX < currentComb.get(waspY - 1).length() && currentComb.get(waspY - 1).charAt(waspX + 1) == 'O') {
			if (solveComb(currentComb, waspX + 1, waspY - 1)) return true;
		}

		// up left
		if (waspY > 0 && waspX > 0 && currentComb.get(waspY - 1).charAt(waspX - 1) == 'O') {
			if (solveComb(currentComb, waspX - 1, waspY - 1)) return true;
		}

		// right
		if (waspX < currentComb.get(waspY).length() - 2 && currentComb.get(waspY).charAt(waspX + 2) == 'O') {
			if (solveComb(currentComb, waspX + 2, waspY)) return true;
		}

		// left
		if (waspX - 1 > 0 && currentComb.get(waspY).charAt(waspX - 2) == 'O') {
			if (solveComb(currentComb, waspX - 2, waspY)) return true;
		}

		// down right
		if (waspY < currentComb.size() - 1 && waspX < currentComb.get(waspY + 1).length() - 1 && currentComb.get(waspY + 1).charAt(waspX + 1) == 'O') {
			if (solveComb(currentComb, waspX + 1, waspY + 1)) return true;
		}

		// down left
		if (waspY < currentComb.size() - 1 && waspX > 0 && currentComb.get(waspY + 1).charAt(waspX - 1) == 'O') {
			if (solveComb(currentComb, waspX - 1, waspY + 1)) return true;
		}

		return false;
	}

	private boolean isWAtEdge (List<String> input){
		input = input.subList(1, input.size());
		if (input.get(0).contains("W") || input.get(input.size()-1).contains("W")){
			return true;
		}
		for (int i = 0; i < input.size(); i++) {
			if (input.get(i).charAt(0) == 'W' || input.get(i).charAt(1) == 'W' || input.get(i).charAt(input.get(i).length()-1) == 'W' || input.get(i).charAt(input.get(i).length()-2) == 'W'){
				return true;
			}
		}
		return false;
	}

	private int count(char c, List<String> input){
		int result = 0;

		for (int i = 0; i < input.size(); i++) {
			for (int j = 0; j < input.get(i).length(); j++) {
				if (input.get(i).charAt(j) == c) {
					result++;
				}
			}
		}
		return result;
	}
}
