package me.cartridge3.MCFObfuscator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MCFObfuscator {

	protected static final Parser PARSER = new Parser();
	protected static final Logger LOGGER = new Logger();
	protected static final String PATH = "C:/Users/" + System.getProperty("user.name")
			+ "/git/MCFObfuscator/MCFObfuscator/src/me/cartridge3/MCFObfuscator/";
	protected static final String IN = PATH + "test.mcfunction";
	protected static final String OBJECTIVES = PATH + "obs.txt";
	protected static final String OUT = PATH + "testOBF.mcfunction";

	// <String,ObfuscatedString>
	protected static HashMap<String, String> objectivesMap = new HashMap<>();

	public static void main(String[] args) {

		LOGGER.log("Starting up...");
		LOGGER.log("Reading objectives...");

		LOGGER.log("Parsing commands");

		List<String> commands = PARSER.parse(IN);

		LOGGER.log("Obfuscating...");

		List<String> obfCommands = obfuscate(commands);

		for (int i = 0; i < obfCommands.size(); i++) {
			LOGGER.log(obfCommands.get(i));
		}

	}

	private static List<String> obfuscate(List<String> commands) {

		int commandCount = commands.size();

		List<String> objectives = convertObjectives(OBJECTIVES);

		LOGGER.log("Obfuscating objective names");

		for (int i = 0; i < objectives.size(); i++) {

			objectivesMap.put(objectives.get(i), generateRandomString(6));

		}

		for (int a = 0; a < objectives.size(); a++) {
			for (int i = 0; i < commandCount; i++) {
				if (commands.get(i).contains(objectives.get(a))) {

					commands.set(i,
							commands.get(i).replaceAll(objectives.get(a), objectivesMap.get(objectives.get(i))));

				}
			}
		}

		return commands;

	}

	public static List<String> convertObjectives(String obs) {
		List<String> obsList = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(obs))) {
			String line;

			while ((line = br.readLine()) != null) {

				obsList.add(line);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.err("Error whilest reading objectives file: Cannot find objectives file.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.err("Error whilest reading objectives file: Failed I/O Operation: " + e.getMessage());

		}

		return obsList;

	}

	public static String generateRandomString(int length) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder sb = new StringBuilder();
		Random r = new Random();

		for (int i = 0; i < length; i++) {
			sb.append(chars.charAt(r.nextInt(chars.length())));
		}

		LOGGER.log(sb.toString());

		return sb.toString();

	}

}
