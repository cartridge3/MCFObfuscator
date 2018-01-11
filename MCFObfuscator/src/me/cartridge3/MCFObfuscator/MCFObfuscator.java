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

	// <String,ObfuscatedString>
	protected static HashMap<String, String> objectivesMap = new HashMap<>();

	public static void main(String[] args) {

		String in = "test.mcfunction";
		String obs = PATH + "obs.txt";
		String out = "testOBF.mcfunction";

		LOGGER.log("Starting up...");
		LOGGER.log("Reading objectives...");

		List<String> objectives = convertObjectives(obs);

		LOGGER.log("Obfuscating objective names");
		
		for (int i = 0; i < objectives.size(); i++) {

			objectivesMap.put(objectives.get(i), generateRandomString(6));
			
		}
		
	
		
		
		
		
		

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
		
		for(int i = 0; i<length; i++) {
			sb.append(chars.charAt(r.nextInt(chars.length())));
		}
		
		LOGGER.log(sb.toString());
		
		return sb.toString();
		
	}
	
	
	
	
	
	
	

}
