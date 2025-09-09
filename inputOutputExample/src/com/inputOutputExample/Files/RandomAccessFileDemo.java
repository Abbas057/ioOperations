package com.inputOutputExample.Files;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
    public static void main(String[] args) {
    	
        File file = new File("D:\\eclipse-workspace\\inputOutputExample\\src\\com\\inputOutputExample\\Files\\RandomAccessfile.txt");

       try(RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
    	   // Write initial content
    	   raf.writeBytes("Hello java RandomAccessFile!\n");	
    	   System.out.println("Wrote initial content");
    	   
    	  // Check current position in file
    	   int cp = (int) raf.getFilePointer();
    	   System.out.println("Current position: "+cp);
    	   
    	  // read first 5 bytes
    	  raf.seek(0);
    	  byte[] firstFive = new byte[5];
    	  raf.read(firstFive, 0,5);
    	  System.out.println("First 5 bytes: " + new String(firstFive));
    	  
    	  // Append text
    	  raf.seek(raf.length());
    	  raf.writeBytes("Append the text in the end\n");
    	  System.out.println("Append text");
    	  
    	  // Seek 10 bytes from start and overwrite some bytes
    	  raf.seek(10);
    	  raf.writeBytes("<<Hello>>");
    	  System.out.println("Overwrite text");
    	  
          // Display final state of file
    	  
    	  raf.seek(0);
    	  System.out.println("\n--- Final file content ---");
    	  String line;
    	  while((line=raf.readLine()) != null) {
    		  System.out.println(line);
    	  }
    	  
    	  
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}
    }
}
