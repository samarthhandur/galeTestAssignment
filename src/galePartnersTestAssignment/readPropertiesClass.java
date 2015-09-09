package galePartnersTestAssignment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readPropertiesClass {
	public String getProp(String key){
		File file = new File("/Users/Samarth/Documents/Selenium/Workspace/galePartnersTestAssignment/src/galePartnersTestAssignment/object.properties");
	    FileInputStream inputFile = null;
		try{
	    	inputFile = new FileInputStream(file);
	    }catch (FileNotFoundException e){
	    	System.out.print("file not found. Please ensure file is present with RW access");
	    }
	Properties property = new Properties();
	//load property file
	try{
		property.load(inputFile);
	}catch(IOException e){
	System.out.print("fatal: i/o load error..!!!");	
	}
	return property.getProperty(key);
   
	}
}
