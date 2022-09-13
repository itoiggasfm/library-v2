//class Member contains a two String instance veriables name and familyName, an character veriable gender and an ineger veriable age.

import java.util.Scanner;
public class Member{
	private int ID; // instance variable
	private String name;  // instance variable
	private String familyName; // instance variable
	private char gender; // instance variable
	private int age; // instance variable
	
	Scanner input = new Scanner(System.in);
	
	
	//method setID sets the ID of member
	public void setID(int ID){
			this.ID = ID;
	}// end of method getID
	
	//method getID gets the ID of member
	public int getID(){
		return ID;
	}// end of method getID
	
		
	//method setName sets the name of member
	public void setName(String name){
		if(name == null)
			this.name = name;
		else
			this.name = name.substring(0 ,1).toUpperCase() + name.substring(1);
	}// end of method setName
	
	//method getName gets the name of member
	public String getName(){
		return name;
	}// end of method getName
	
	
	
	//method setFamilyName sets the family name of member
	public void setFamilyName(String familyName){
		if(familyName == null)
			this.familyName = familyName;
		else
			this.familyName = familyName.substring(0 ,1).toUpperCase() + familyName.substring(1);
	}// end of method setName
	
	//method getFamilyNmae gets the family name of member
	public String getFamilyName(){
		return familyName;
	}// end of method getName
	
	
	
	//method setGender sets the gender of member
	public void setGender(char gender){
		if(gender == '\u0000')
			this.gender = gender;
		else{
				while(!(gender == 'M' || gender == 'm' || gender == 'F' || gender == 'f')){
				System.out.printf("Gender((M)male, (F)female): ");
				gender = input.next().charAt(0);
			}
			this.gender = Character.toUpperCase(gender);
		}
	}// end of method setGender
	
	//method getGender gets the gender of member
	public char getGender(){
		return gender;
	}// end of method getGender
	
	
	
	//method setAge sets the age of member
	public void setAge(int age){
		this.age = age;
	}// end of method setName
	
	//method getAge gets the age of member
	public int getAge(){
		return age;
	}// end of method getAge
	
	
	
	
	
	
	

	
	
}//end of class Member