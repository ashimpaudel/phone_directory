package main.java;
import test.java.Phone;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args){
		/* 
		 * name = name of user input
		 * number = phone number of user input
		 * recall = allows user different functions multiple times
		 */
		String name,number,recall;
		System.out.println("HI");
		System.out.println("\tPress 1 to add the entry on phonebook. \tPress 2 to delete the entry on phonebook.\tpress 3 to get number from on phonebook. \tPress 4 to change contact");
		int choice;
		Phone object=new Phone();	//creating the new object of phone object	
		do{
			System.out.println("Enter your choice : ");
			Scanner in = new Scanner(System.in);
			choice=in.nextInt();
			if(choice ==1){
				Scanner name_object = new Scanner(System.in);
				Scanner number_object= new Scanner(System.in);
				System.out.println("Enter the entry name : ");
				name=name_object.nextLine();
				System.out.println("Enter the entry number : ");
				number=number_object.nextLine();
				/*
				 * Above entries are inputeed in the file
				 */
				object.addEntry(name, number);
			}
			else if(choice==2){
							
						Scanner name_object= new Scanner(System.in);
						System.out.println("Enter the name to be deleted : ");
						/*
						 * This name is passed as an arugment to be removed
						 */
						name=name_object.nextLine();
						object.DeleteEntry(name);
				}
				
			else if(choice==3){
					Scanner name_object= new Scanner(System.in);
					System.out.println("Enter the name you want to find: ");
					name = name_object.nextLine();
					number=object.getNumber(name);
					if(number.equals(null)){
						System.out.println("ERROR! name not found");
					}
					/*
					 * The name is passed as an argument and the number is returned back
					 */
					else{
						System.out.println("The number is : " + number);
					}
				}
			else if(choice==4){
					Scanner name_object= new Scanner(System.in);
					Scanner number_object= new Scanner(System.in);
					System.out.println("Enter the name to be modified : ");
					name=name_object.nextLine();
					System.out.println("Enter the number to be modified : ");
					number=number_object.nextLine();
					/*
					 * The name and number is passed as an argument to be modified.
					 */
					object.changeEntry(name, number);
								
				}
			
			else{
				/*
				 * If the user choice is invalid.
				 */
				System.out.println("Wrong choice entered");
			}
			System.out.println("Do you want to continue : (yes, y)");
			Scanner reapeat_object=new Scanner (System.in);
			recall=reapeat_object.nextLine();
			/*
			 * This loop will execute till the user presses yes
			 */
		}while((recall.equals("yes"))||(recall.equals("y")));
	}
	
}