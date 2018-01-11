package me.cartridge3.MCFObfuscator;

import java.io.File;

public class MCFObfuscator {

	protected static final Parser PARSER = new Parser();
	protected static final Logger LOGGER = new Logger();
	
	protected final File in = new File("test.mcfunction");
	protected final File objectives = new File("obs.txt");
	protected File out = new File("testOBF.mcfunction");
	
	
	public static void main(String[] args) {
		
		LOGGER.log("Starting up...");
		
		

	}

}
