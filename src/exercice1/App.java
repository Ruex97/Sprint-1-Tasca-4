package exercice1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

 	public class App {
 		
 		public static void main(String[] args) {
 			if (args.length > 0) {					
 				ArrayList<String> sortedDirectory = orderAlphabetically(args[0]);
 				for (String data: sortedDirectory) {
 	 				System.out.println(data);
 	 			}
			} else {
				System.out.println("You have to specify the path");
			}
 		}
 		
 		
 		static ArrayList<String> orderAlphabetically(String args) {
 			ArrayList<String> directoryFiles = new ArrayList<String>();
 			File myFile = new File(args);  // I'm passing a path as argument
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
 		
 	
 	}

		
 		