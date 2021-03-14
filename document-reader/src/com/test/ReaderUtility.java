package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class ReaderUtility {

	/* Description: Utility method to read content of .doc file
	 * Input: File object;	
	 * Return: String; (Content of the file)
	 */
	protected String readDocFile(File file) throws IOException {

		FileInputStream fis = new FileInputStream(file);
		HWPFDocument wordDoc = new HWPFDocument(fis);
		String docText = wordDoc.getDocumentText();	
		wordDoc.close();
		return docText;
	}

	/* Description: Utility method to read content of .docx file
	 * Input: File object;	
	 * Return: String; (Content of the file)
	 */
	protected String readDocxFile(File file) throws IOException {

		FileInputStream fis = new FileInputStream(file);
		XWPFDocument document = new XWPFDocument(fis);
		XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(document);
		String docText = xwpfWordExtractor.getText();
		xwpfWordExtractor.close();
		return docText;

	}

	/* Description: Utility method to read content of text file
	 * Input: File object;	
	 * Return: String; (Content of the file)
	 */
	protected String readTextFile(File file) throws FileNotFoundException {
	    try (Scanner sc = new Scanner(file)) {
			sc.useDelimiter("\\Z"); 
			return(sc.next());
		} 

	}
	
	/* Description: Utility method to check for word with maximum length
	 * Input: String; (String to be checked)
	 * Return: String; (Returns the string with maximum length)
	 */
	protected String maxLengthWord(String content) {
		
		long max = 0;
		String result = null;
		String[] strs = content.split("\\s+");
		
		for(String s: strs) {
			if(s.length() > max && !s.isEmpty()) {
				max = s.length();
				result = s;
			}

		}	
		return result;
	}

}
