package at.htlleonding.diegaertner.cc2023.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {
	private FileUtils() {}

	public static List<String> getInput(String filename) {
		try {
			return Files.readAllLines(Paths.get("input/" + filename + ".in"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void write(String filename, String text) {
		try {
			Files.write(Paths.get("output/" + filename + ".out"), text.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<String> readAllLines(String path) {
		try {
			return Files.readAllLines(Paths.get(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String readAllText(String path) {
		try {
			return Files.readString(Paths.get(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
