package test.java;
import java.io.*;
import java.util.*;

/*
 * Phone directory
 */
public class Phone {
	/*
	 * The member function of this class can do:
	1.	Add an entry to the directory
	2.	Delete an entry from the directory
	3.	Look up a phone number
	4.	Change someone’s entry in the phone directory

	 */
	

	/*
	 * @param name name of the person
	 * @param number number of the person
	 */
	public void addEntry(String name,String number){  // this method adds the name and number 
		Properties property = new Properties();
		try{
			OutputStream outputStream = new FileOutputStream("src/main/resources/phone.properties",true);
			property.setProperty(name,number);
			property.store(outputStream,null);
			outputStream.close();
		}
		
		catch(IOException ex){
			System.out.println("Unable to open file : "+ex);
		}	
		
		
		
	}
	

	public void DeleteEntry(String name){ //this method is to delete the entry
		
		Properties property = new Properties();
		try{
			InputStream inputStream = new FileInputStream("src/main/resources/phone.properties");  
			property.load(inputStream);
			String check = property.getProperty(name);
			if(check==null){
				System.out.println("ERROR! name not found");
				return;
			}
			property.remove(name);
			inputStream.close();
			
			OutputStream outputStream = new FileOutputStream("src/main/resources/phone.properties"); 
			property.store(outputStream , null);
			outputStream.close();
			System.out.println(name + "is deleted!");
		}
		catch(FileNotFoundException ex){
			System.out.println("Unable to oepn file");
		}
		catch(IOException ex){
			System.out.println("File not opened.");
		}
		
	}
	

	public String getNumber(String name){ //this 
		String number="";
		Properties property = new Properties();
		try{
			InputStream inputStream  = new FileInputStream("src/main/resources/phone.properties");
			property.load(inputStream);
			number = property.getProperty(name);
			inputStream.close();			
		}
		
		catch(Exception e){
			System.out.println("File not found");
		}
		return number;
		
	}
	
	public void changeEntry(String name,String number){
		
		Properties property = new Properties();
		try{		
			InputStream inputStream = new FileInputStream("src/main/resources/phone.properties");
			property.load(inputStream);
			String check = property.getProperty(name);
			if(check==null){
				System.out.println("ERROR! The name not found");
				return;
			}
			property.replace(name, number);
			inputStream.close();
		
			OutputStream outputStream = new FileOutputStream("src/main/resources/phone.properties"); 
			property.store(outputStream, null);
			outputStream.close();
		}
		catch(FileNotFoundException ex){
			System.out.println("Unable to oepn file");
		}
		catch(IOException ex){
			System.out.println("File not opened.");
		}
	}
}