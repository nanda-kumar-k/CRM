package views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ClientFile {
	public static void main(String[] args) {
		try {
		      File myObj = new File("client.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getAbsolutePath());
		      } else {
		        System.out.println("File already exists." + myObj.getAbsolutePath());
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	  }

}
