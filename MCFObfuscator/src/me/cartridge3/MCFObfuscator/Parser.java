package me.cartridge3.MCFObfuscator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

	private String mainpath = "";
	
	public List<String> parse(String filename)
	{
		if(mainpath.isEmpty()) {
		
			mainpath = new File(filename).getPath().replace(new File(filename).getName(), "");
			MCFObfuscator.LOGGER.log("New mainpath: " + mainpath);
			filename = mainpath + new File(filename).getName();
		}
		
		
	
		List<String> cmds = new ArrayList<String>();
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;

			while ((line = br.readLine()) != null) {

			
				if(!line.isEmpty()) {
					
					
					if(line.startsWith("function")) {
						String function = mainpath + line.split(" ")[1].replace(MCFObfuscator.PREFIX, "").replace("/", "\\") + ".mcfunction";
						
					    MCFObfuscator.LOGGER.log("Indexing function \"" + function +"\"");
						List<String> result = parse(function);
						
						for(int i=0;i<result.size();i++) {
							cmds.add(result.get(i));
						}
						
						
					} else {
					
					cmds.add(line);
					}
					
					
				}
				
				
					

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			MCFObfuscator.LOGGER.err("!!! Called function doesn't exist !!! " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			MCFObfuscator.LOGGER.err("Error whilest reading input file: Failed I/O Operation: " + e.getMessage());

		}

		
		return cmds;
		
		
	}
	
	
}
