package test0709;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Read {
	public static String[] readFile(String filename) {
	ArrayList<String> lines = new ArrayList<String>();
	try (FileReader fr =new FileReader(filename);){
		BufferedReader br = new BufferedReader(fr);  //讀取檔案
		while(br.ready()) {
			String line = br.readLine();             //將讀到的資料存入line中
			if (line.charAt(0) == '#')               //如果字串中的第一個字元為#字號
				continue;                            //跳過這一次
			lines.add(line);                         //將line存入lines中
		}
	} catch (Exception e) {
		e.printStackTrace();
		}
	return lines.toArray(new String[lines.size()]);  //將lines轉成String Array回傳
	}
}