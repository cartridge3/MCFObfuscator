package me.cartridge3.MCFObfuscator;

import javax.swing.SwingUtilities;
import javax.swing.text.DefaultCaret;

public class Logger {

	private final String PREFIX = "[MCFObfuscator] ";
	
	public void log(Object o) {
	
		 SwingUtilities.invokeLater(new Runnable() {
			    public void run() {
			    	try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	
			    	
			    	GUIMain.addToLog(o);
			    	GUIMain.textArea.setCaretPosition(GUIMain.textArea.getText().length()); 
			        
			    }
			    
			  });
		
		
		
		
	}
	
	public void err(Object o) {
		GUIMain.addToLog(o);
	}
	 
	
	
}
