package me.cartridge3.MCFObfuscator;

public class Logger {

	private final String PREFIX = "[MCFObfuscator] ";
	
	public void log(Object o) {
		System.out.println(PREFIX + o);
	}
	
	public void err(Object o) {
		System.err.println(PREFIX + o);
	}
	 
	
	
}
