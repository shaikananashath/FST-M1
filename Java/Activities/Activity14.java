package activities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

public class Activity14 {

	public static void main(String[] args) throws IOException {
	 try{
		//Create file
		File file = new File("src/main/resources/TestActivity14.txt");
		boolean fStatus = file.createNewFile();
		//Write file
		if(fStatus==true) {
			System.out.println("File created");
			FileUtils.writeStringToFile(file, "This is activity 14", Charset.defaultCharset());
		}
		else {
			System.out.println("File already exists in the path");
		}
		//Read file
		System.out.println("Data in file: "+ FileUtils.readFileToString(file, "UTF8"));
		//Create new dir
		File destDir = new File("src/main/resources/destDir");
		//Copy file
		FileUtils.copyFileToDirectory(file, destDir);
		//Get file from new dir
		File dirFile = FileUtils.getFile(destDir,"TestActivity14.txt");
		//Read data from file
		String dirFileData = FileUtils.readFileToString(dirFile, "UTF8");
		System.out.println("Data in new file: "+ dirFileData);
	   }
	 catch(IOException e) {
		System.out.println(e.getMessage());
	   }
	}

}