package me.cartridge3.MCFObfuscator;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MCFObfuscator {

	protected static final Parser PARSER = new Parser();
	protected static final Logger LOGGER = new Logger();

	protected static final String PATH = "C:/Users/" + System.getProperty("user.name")
			+ "/git/MCFObfuscator/MCFObfuscator/src/me/cartridge3/MCFObfuscator/";

	protected static String IN = "";
	protected static String OBJECTIVES = "";
	protected static String OUT = "";

	protected static String PREFIX = "";
	protected static final String SUFFIX = ".mcfunction";

	protected static int charat = 0;
	protected static int charsave = -1;
	protected static String appendChar = "";
	// <String,ObfuscatedString>
	protected static HashMap<String, String> objectivesMap = new HashMap<>();

	public static void start() {

		LOGGER.log("Starting up...");
		LOGGER.log("Reading objectives...");

		LOGGER.log("Parsing commands");

		List<String> commands = PARSER.parse(IN);

		LOGGER.log("Obfuscating...");

		List<String> obfCommands = obfuscate(commands);

		LOGGER.log("Done");

	}

	private static List<String> obfuscate(List<String> commands) {

		int commandCount = commands.size();

		LOGGER.log("Obfuscating objective names");

		List<String> objectives = convertObjectives(OBJECTIVES);
		List<String> uselessObjectives = new ArrayList<String>();
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

		LOGGER.log("Adding useless objectives");
		Random r = new Random();

		int uselessObjectivesCount = r.nextInt(4) + 4;

		for (int i = 0; i < uselessObjectivesCount; i++) {

			objectivesMap.put("Useless" + i, generateRandomString(6));
			uselessObjectives.add(objectivesMap.get("Useless" + i));

		}

		LOGGER.log("Confusing flow of control");

		File newFile = null;

		String nextFileName = generateRandomFileName();
		int fileCountNewFile = 0;

		for (int i = 0; i < commandCount; i++) {

			if (i == fileCountNewFile) {
				fileCountNewFile = fileCountNewFile + r.nextInt(7) + 1;

				try {
					if (newFile != null)
						Files.write(Paths.get(newFile.getAbsolutePath()),
								("\nfunction " + PREFIX + nextFileName).getBytes(), StandardOpenOption.APPEND);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				newFile = new File(OUT + nextFileName.replaceAll(PREFIX, "") + SUFFIX);
				try {
					newFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				nextFileName = generateRandomFileName();
			}

			int generatedCase = 0;
			String cmdToAppend = "";
			int randomObjective = r.nextInt(objectivesMap.size() - 1);
			int anotherRandomObjective = r.nextInt(objectivesMap.size() - 1);
			int randomNumber = r.nextInt(1);
			int anotherRandomNumber = r.nextInt(20);
			int reach = r.nextInt(2);
			if (reach == 0) {
				generatedCase = r.nextInt(29);

				switch (generatedCase) {
				case 0:
					cmdToAppend = "scoreboard players set @a[score_" + uselessObjectives.get(randomObjective)
							+ "_min=1] " + uselessObjectives.get(anotherRandomObjective) + " " + randomNumber;
					break;
				case 1:
					cmdToAppend = "scoreboard players set @a[score_" + uselessObjectives.get(randomObjective) + "=1]"
							+ uselessObjectives.get(anotherRandomObjective) + " " + randomNumber;
					break;
				case 2:
					cmdToAppend = "scoreboard players set @a[score_" + uselessObjectives.get(randomObjective) + "_min="
							+ r.nextInt(30) + "] " + uselessObjectives.get(anotherRandomObjective) + " " + randomNumber;
					break;
				case 3:
					cmdToAppend = "scoreboard players set @a[score_" + uselessObjectives.get(randomObjective) + "="
							+ r.nextInt(30) + "] " + uselessObjectives.get(anotherRandomObjective) + " " + randomNumber;
					break;

				case 4:
					cmdToAppend = "scoreboard players reset @a[score_" + uselessObjectives.get(randomObjective)
							+ "_min=1] " + uselessObjectives.get(anotherRandomObjective);
					break;
				case 5:
					cmdToAppend = "scoreboard players reset @a[score_" + uselessObjectives.get(randomObjective) + "=1] "
							+ uselessObjectives.get(anotherRandomObjective);
					break;
				case 6:
					cmdToAppend = "scoreboard players reset @a[score_" + uselessObjectives.get(randomObjective)
							+ "_min=" + uselessObjectives.get(anotherRandomObjective) + "]";
					break;
				case 7:
					cmdToAppend = "scoreboard players reset @a[score_" + uselessObjectives.get(randomObjective) + "="
							+ uselessObjectives.get(anotherRandomObjective) + "]";
					break;

				case 8:
					cmdToAppend = "scoreboard players set @e[score_" + uselessObjectives.get(randomObjective)
							+ "_min=1] " + uselessObjectives.get(anotherRandomObjective) + " " + randomNumber;
					break;
				case 9:
					cmdToAppend = "scoreboard players set @e[score_" + uselessObjectives.get(randomObjective) + "=1]"
							+ uselessObjectives.get(anotherRandomObjective) + " " + randomNumber;
					break;
				case 10:
					cmdToAppend = "scoreboard players set @e[score_" + uselessObjectives.get(randomObjective) + "_min="
							+ uselessObjectives.get(anotherRandomObjective) + "] " + randomNumber;
					break;
				case 11:
					cmdToAppend = "scoreboard players set @e[score_" + uselessObjectives.get(randomObjective) + "="
							+ uselessObjectives.get(anotherRandomObjective) + "] " + randomNumber;
					break;

				case 12:
					cmdToAppend = "scoreboard players reset @e[score_" + uselessObjectives.get(randomObjective)
							+ "_min=1] " + uselessObjectives.get(anotherRandomObjective);
					break;
				case 13:
					cmdToAppend = "scoreboard players reset @e[score_" + uselessObjectives.get(randomObjective) + "=1] "
							+ uselessObjectives.get(anotherRandomObjective);
					break;
				case 14:
					cmdToAppend = "scoreboard players reset @e[score_" + uselessObjectives.get(randomObjective)
							+ "_min=" + r.nextInt(30) + "] " + uselessObjectives.get(anotherRandomObjective);
					break;
				case 15:
					cmdToAppend = "scoreboard players reset @e[score_" + uselessObjectives.get(randomObjective) + "="
							+ r.nextInt(30) + "] " + uselessObjectives.get(anotherRandomObjective);
					break;

				case 16:
					cmdToAppend = "scoreboard players set @a[score_" + uselessObjectives.get(randomObjective)
							+ "_min=1] " + uselessObjectives.get(anotherRandomObjective) + " " + anotherRandomNumber;
					break;
				case 17:
					cmdToAppend = "scoreboard players set @a[score_" + uselessObjectives.get(randomObjective) + "=1]"
							+ uselessObjectives.get(anotherRandomObjective) + " " + anotherRandomNumber;
					break;
				case 18:
					cmdToAppend = "scoreboard players set @a[score_" + uselessObjectives.get(randomObjective) + "_min="
							+ r.nextInt(30) + "] " + uselessObjectives.get(anotherRandomObjective) + " "
							+ anotherRandomNumber;
					break;
				case 19:
					cmdToAppend = "scoreboard players set @a[score_" + uselessObjectives.get(randomObjective) + "="
							+ r.nextInt(30) + "] " + uselessObjectives.get(anotherRandomObjective) + " "
							+ anotherRandomNumber;
					break;

				case 20:
					cmdToAppend = "scoreboard players set @e[score_" + uselessObjectives.get(randomObjective)
							+ "_min=1] " + uselessObjectives.get(anotherRandomObjective) + " " + anotherRandomNumber;
					break;
				case 21:
					cmdToAppend = "scoreboard players set @e[score_" + uselessObjectives.get(randomObjective) + "=1]"
							+ uselessObjectives.get(anotherRandomObjective) + " " + anotherRandomNumber;
					break;
				case 22:
					cmdToAppend = "scoreboard players set @e[score_" + uselessObjectives.get(randomObjective) + "_min="
							+ uselessObjectives.get(anotherRandomObjective) + "] " + anotherRandomNumber;
					break;
				case 23:
					cmdToAppend = "scoreboard players set @e[score_" + uselessObjectives.get(randomObjective) + "="
							+ uselessObjectives.get(anotherRandomObjective) + "] " + anotherRandomNumber;
					break;

				case 24:
					cmdToAppend = "scoreboard players set @a " + uselessObjectives.get(anotherRandomObjective) + " "
							+ randomNumber;
					break;
				case 25:
					cmdToAppend = "scoreboard players set @e " + uselessObjectives.get(anotherRandomObjective) + " "
							+ randomNumber;
					break;

				case 26:
					cmdToAppend = "scoreboard players reset @a " + uselessObjectives.get(anotherRandomObjective);
					break;
				case 27:
					cmdToAppend = "scoreboard players reset @e " + uselessObjectives.get(anotherRandomObjective);
					break;

				case 28:
					cmdToAppend = "scoreboard players set @a " + uselessObjectives.get(anotherRandomObjective) + " "
							+ anotherRandomNumber;
					break;

				case 29:
					cmdToAppend = "scoreboard players set @e " + uselessObjectives.get(anotherRandomObjective) + " "
							+ anotherRandomNumber;
					break;

				}

				try {
					Files.write(Paths.get(newFile.getAbsolutePath()), cmdToAppend.getBytes(),
							StandardOpenOption.APPEND);
					Files.write(Paths.get(newFile.getAbsolutePath()), (System.lineSeparator().getBytes()),
							StandardOpenOption.APPEND);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			try {
				Files.write(Paths.get(newFile.getAbsolutePath()), (commands.get(i)).getBytes(),
						StandardOpenOption.APPEND);
				Files.write(Paths.get(newFile.getAbsolutePath()), (System.lineSeparator().getBytes()),
						StandardOpenOption.APPEND);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

	public static String generateRandomFileName() {
		String charsUp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String charsDown = "abcdefghijklmnopqrstuvwxyz";

		String filename = "";
		if (charsUp.length() == charat) {
			charsave++;
			appendChar = appendChar + charsUp.charAt(charsave);
			charat = 0;
			filename = appendChar + charsDown.charAt(charat);
		} else {

			if (appendChar.isEmpty()) {

				filename = String.valueOf(charsUp.charAt(charat));
			} else {
				filename = appendChar + charsDown.charAt(charat);
			}
		}

		charat++;

		return filename;

	}

}
