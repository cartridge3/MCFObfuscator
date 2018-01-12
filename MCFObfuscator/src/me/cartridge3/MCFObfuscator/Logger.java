package me.cartridge3.MCFObfuscator;

import javax.swing.SwingUtilities;

public class Logger {

	private final String PREFIX = "[MCFObfuscator] ";
	
	public void log(Object o) {
	
		
		
		GUIMain.addToLog(o);
		
		
	}
	
	public void err(Object o) {
		GUIMain.addToLog(o);
	}
	 
	
	
}
