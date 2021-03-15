# JavaWordProcessor
Word processor reads a file content from .doc, .docx and text file. It returns the largest word and it's transpose from the file.

To keep simplicity for the project and the time, I haven't added much of the functionalities.
Trying to list down some improvements that I will do on the existing project in future:

## Execution setup instruction

There are two ways you can execute this file in your machine. 
  -  One way is to download WordReader.jar from GitHub to your local machine. You only need this jar file and do not need any other files from GitHub.
      - Before executing the jar, please make sure you have the right version of java/jre installed. This program requires a minimum of java 1.8 and it works with more recent java version too (I tested in 15.0.2 as well as Java version 1.8)
      - To check java version on your machine, open command prompt(Windows) or Terminal(mac) and type java -version. If it says Java version 1.7 or below, Please update your java version. If it says Java version 1.8 or above, you are good to go. I will leave a section below on how to update your java version.
  -  Another way is if you have eclipse or other IDE in your, you can download this Java project from GitHub. Download the whole project from GitHub and open it as existing java project in your IDE. You can point IDE from this root folder "document-reader" to pick up all files. Please make sure your IDE JRE is set to java 1.8 or above to execute this project. Run the ReadFile.java as a java application. Use command line to enter file path along with file name.

## Execution instruction
  - The program supports text file, doc and docx files
  - When prompted to enter file path Please enter complete path along with file name 
      - Ex: C:/test.txt in windows; /Users/localuser/Documents/Test_DOC.doc in mac
      - Note in mac text files don't have .txt extension
  - The program then searches for words with maximum length and print it. It also prints a transpose of that word
  - If there are words of same lenght, program retruns the first found word.
  - There are few limitations and I have mentioned some of them in Future Improvements section. Please take a look at them. I have also mentioned about out of scope items in Test cases excel file.


## Install or update java version
  - Download JRE from https://www.java.com/en/download/manual.jsp
  - Double click on the .dmg or .exe(windows)
  - After installation, launch terminal and check for java -version. It should show java version 8 (1.8)


## Future improvements
- Add support for PDF
- Add support for validation on document encryption
- Add support for password protected files
- More exception handling and retry
- Check program performance under unexpected condition like memory leaks and resource utilization.
