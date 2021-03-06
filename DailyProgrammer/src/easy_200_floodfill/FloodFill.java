package easy_200_floodfill;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FloodFill {
	private static void printPicture(ArrayList<String> picture) {
		for(String line : picture) System.out.println(line);
	}
	
	private static ArrayList<String> constructPicture(BufferedReader fileRead) throws IOException {
		ArrayList<String> picture = new ArrayList<String>();
		String line = null;
		while((line = fileRead.readLine()) != null) {
			picture.add(line);
		}
		return picture;
	}
	
	public static void main(String[] args) throws IOException {
		String file = args[0];
		BufferedReader fileRead = new BufferedReader(new FileReader(new File(file)));
		printPicture(constructPicture(fileRead));
	}
}
