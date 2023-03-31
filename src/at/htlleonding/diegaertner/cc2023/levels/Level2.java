package at.htlleonding.diegaertner.cc2023.levels;

import at.htlleonding.diegaertner.cc2023.Level;

import java.util.List;

public class Level2 extends Level {

	public Level2(boolean debug) {
		super(debug);
		this.subLevels = 5;
		System.out.println("Level0 created in debug mode: " + debug);
	}

	@Override
	public Object solve(List<String> input, int sublevel) {
		System.out.println("Input for sublevel " + sublevel + ":");
		//input.forEach(System.out::println);


		StringBuilder sb = new StringBuilder();

		int result = 0;

		int lastEnd = 2;

		for (int i = 2; i < input.size(); i++) {
			if (input.get(i).equals("")|| i == input.size()-1) {
				sb.append(result);
				sb.append("\n");
				lastEnd = i;
				result = 0;
			}
			for (int j = 0; j < input.get(i).length(); j++) {
				if (input.get(i).charAt(j) == 'W') {
					try {

						if (input.get(i - 1).charAt(j - 1) == 'O') {
							result++;
						}
						if (input.get(i - 1).charAt(j + 1) == 'O') {
							result++;
						}
						if (input.get(i + 1).charAt(j - 1) == 'O') {
							result++;
						}
						if (input.get(i + 1).charAt(j + 1) == 'O') {
							result++;
						}
						if (input.get(i).charAt(j - 2) == 'O') {
							result++;
						}
						if (input.get(i).charAt(j + 2) == 'O') {
							result++;
						}
					} catch (Exception e) {

					}
				}
			}
		}

		System.out.println("W "+  count('W', input));
		System.out.println(sb.toString());
		return sb.toString();
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
