package exercice2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

	public class App {
	
	public static void main(String[] args) {
			if (args.length > 0) {					
				File myFile = new File(args[0]);
				if (myFile.isDirectory()) {
					readRecursively(myFile);
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
	
	
	static void readRecursively(File myFile) {
		
		long modificationTime = myFile.lastModified();
		Date date = new Date(modificationTime);
		ArrayList<String> sorted = orderAlphabetically(myFile);
		
		if (myFile.isDirectory()) {
			System.out.println(myFile.toString() + "  IT'S A DIRECTORY --> D" 
											     + " Last modified: " + date);
			File [] list = myFile.listFiles();
			for (int i=0; i<list.length; i++) {
				
				if (!list[i].isDirectory()) {
					
					System.out.println(sorted.get(i) + "  IT'S A FILE --> F" +
													   " Last modified: " + date);
					
				} else {
					
					orderAlphabetically(list[i]);
					readRecursively(list[i]);
				}
			}
		} 	
	}
	


}
