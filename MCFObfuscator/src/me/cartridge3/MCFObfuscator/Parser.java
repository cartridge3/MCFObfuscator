package me.cartridge3.MCFObfuscator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

	
	public List<String> parse(String filename)
	{
		
		List<String> cmds = new ArrayList<String>();
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;

			while ((line = br.readLine()) != null) {

				cmds.add(line);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			MCFObfuscator.LOGGER.err("Error whilest reading input file: Cannot find objectives file.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			MCFObfuscator.LOGGER.err("Error whilest reading input file: Failed I/O Operation: " + e.getMessage());

		}

		
		return cmds;
		
		
	}
	
	
}
