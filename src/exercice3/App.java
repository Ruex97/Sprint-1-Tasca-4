package exercice3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

	public class App {
	
	public static void main(String[] args) {
			if (args.length > 0) {					
				File myFile = new File(args[0]);
				if (myFile.isDirectory()) {
					writeRecursively(myFile);
				}
				
		} else {
			System.out.println("You have to specify the path");
		}
	}
		
	static ArrayList<String> orderAlphabetically(File myFile) {
		ArrayList<String> directoryFiles = new ArrayList<String>();
		String [] fileList = myFile.list();
			if (fileList == null) {
				System.out.println("Empty");
			} else {
				for (int i=0; i<fileList.length; i++) {
					directoryFiles.add(fileList[i]);
				}
			}
			
			Collections.sort(directoryFiles);
			return directoryFiles;
	
		}
	
	
	static void writeRecursively(File myFile) {
		long modificationTime = myFile.lastModified();
		Date date = new Date(modificationTime);
		
		ArrayList<String> sorted = orderAlphabetically(myFile);
		
		try {
			FileWriter myWriter = new FileWriter("C:/Users/xavir/Desktop/testdir/pruebaka.txt");
			if (myFile.isDirectory()) {
				
				myWriter.write(myFile.toString() + "  It's a directory --> D"
					                             + " Last modified: " + date + "\n");
				
				File [] list = myFile.listFiles();
				for (int i=0; i<list.length; i++) {
					if (!list[i].isDirectory()) {
						
						myWriter.write(list[i] + "  It's a file --> F" 
											   +" Last modified: " + date + "\n");
						
					} else {
						
						orderAlphabetically(list[i]);
						writeRecursively(list[i]);
					}
				}
			} 
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	

	
}
	


