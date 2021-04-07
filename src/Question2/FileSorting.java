package Question2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.print.DocFlavor.URL;

public class FileSorting {

	public static void main(String[] args) {
		ArrayList<Volume> vols = ReadFile("src/Question2/myfile.txt");
		
		if(vols.isEmpty()) {
			System.out.println("Empty file");
			return;
		}
		
		System.out.println("-----SORTED-----");
		
		Collections.sort(vols);
		
		for(Volume vol: vols){
			System.out.println(vol.toString());
		}
	}
	
	static ArrayList<Volume> ReadFile(String path) {
		ArrayList<Volume> vols = new ArrayList<Volume>();

	    File inputFile = new File("./src/Question2/file.txt");
	    try {
	        Scanner reader = new Scanner(inputFile);
	        while (reader.hasNextLine()) {
	           String data = reader.nextLine();
			   String[] split = data.split(" ");
 		   
 			   vols.add(new Volume(split[0], Long.parseLong(split[1])));
 			   
 			   System.out.println(data);
	            
	        }
	        reader.close();
	    } catch (FileNotFoundException e) {
	        System.out.println("scanner error");
	        e.printStackTrace();
	    }
		return vols;
	}

}
