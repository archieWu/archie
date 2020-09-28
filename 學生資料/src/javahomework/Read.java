package javahomework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Read {
	public static String[] readFile(String filename) {
	ArrayList<String> lines = new ArrayList<String>();
	try (
		FileReader fr =new FileReader(filename);		
	)
	{
		BufferedReader br = new BufferedReader(fr);
		while(br.ready()) {
			String line = br.readLine();
			if (line.charAt(0) == '#')
				continue;
			lines.add(line);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	return lines.toArray(new String[lines.size()]);
}
}
