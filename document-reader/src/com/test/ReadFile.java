package com.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadFile {

	public static void main(String args[])  {


		String docContent = null;
		boolean unsupportedFile = false;
		boolean fileExists = false;
		Scanner input = null;
		ReaderUtility read = null;
		
		try {
			
			/*
			 * Get the file path from user
			 */
			input = new Scanner(System.in);
			System.out.println("Enter file path: ");
			String filePath = input.nextLine();
			File file = new File(filePath);
			fileExists = file.exists();
			
			/*
			 * Check if it's plain directory or does it have valid file
			 */
			if (file.isDirectory() || !fileExists) {
				System.out.println("Please check the file path enetered. Either file name(and/or extension) is missing or the file does not exists in the path");
			}else {
				read = new ReaderUtility();
				
				/* Check for file types. This program is designed to run only text files, .doc and docx
				 *   For valid files, read the file and return file content as string 	
				 */    
				
				String fileName = Paths.get(filePath).getFileName().toString();
				if (fileName.contains(".docx")) {
					docContent = read.readDocxFile(file);
				}else if (fileName.contains(".doc")) {
					docContent = read.readDocFile(file);
				}else if(fileName.contains(".txt") || !fileName.contains(".") ) {
					if(file.length() != 0) {
						docContent = read.readTextFile(file); 	
					}
				}else {
					System.out.println("Only text, word (doc & docx) format is supported. Thank you!");
					unsupportedFile = true;
				}

				/*
				 * If it's a valid file, check for maximum length of string from the context
				 */
				if(!unsupportedFile) {
					String result = null ;
					if(docContent != null )
						result = read.maxLengthWord(docContent);
					
					if(result != null) 
					{
						StringBuilder sb = new StringBuilder(result);
						System.out.println("Longest word in file is :" + result); 
						System.out.println("Transposed word " + sb.reverse()); 
					}else {
						System.out.println("File content is empty"); 

					}
				}

			}

		/*
		 * Catch error and try to show it with a meaningful message
		 */
			
		}catch(InputMismatchException inex) {
			System.out.println("Please enter valid file path. Error message:  "+ inex);
		}catch(FileNotFoundException fex) {
			System.out.println("Mentioned file is not found. Please make sure file is in right format. Error message:  "+ fex);
		}catch(IOException ioex) {
			System.out.println("Could not process input file. Error message:  "+ ioex);
		}catch(Exception e) {
			System.out.println("Error occured in program due to some unlikely condition. Error message:  "+ e);

		}

	}


}

