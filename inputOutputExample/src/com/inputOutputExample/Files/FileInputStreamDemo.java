package com.inputOutputExample.Files;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileInputStreamDemo {
	public static void main(String[] args) {
		File file = new File(
				"D:\\eclipse-workspace\\inputOutputExample\\src\\com\\inputOutputExample\\Files\\FilesFileInputStream.txt");

		if (!file.exists()) {
			System.out.println("File not found! Creating and writing sample text");
			try (FileOutputStream fos = new FileOutputStream(file)) {
				fos.write("Hello java FileInputSTream".getBytes());
			} catch (IOException e) {
			}
		}
		
		try(
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis, 8124);){
			
			System.out.println("Reading with FileInputStream.read() one byte at a time:");
			int b;
			while ((b=fis.read())!= -1) {
				System.out.print((char)b);
			}
			
			System.out.println("\n\nReading with BufferedInputStream and byte array:");
			byte[] buffer = new byte[8];
			int byteReader;
			bis.skip(0); // reset position, illustrative only
			while((byteReader= bis.read(buffer))!= -1) {
				System.out.println(new String(buffer, 0, byteReader));
			}	
			
		}catch (IOException e) {
		}
		
		try (
	            FileInputStream fis2 = new FileInputStream(file);
	            Reader reader = new InputStreamReader(fis2, StandardCharsets.UTF_8);
	            BufferedReader br = new BufferedReader(reader);
	        ) {
	            System.out.println("\n\nReading using Reader (characters):");
	            String line;
	            while ((line = br.readLine()) != null) {
	                System.out.println(line);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
