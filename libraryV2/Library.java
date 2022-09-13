
import java.util.Scanner;
public class Library {
	
	//constant instance veriable LIBRARY_CAPACITY
	private static final int LIBRARY_CAPACITY = 10;
	
	public int libraryCapacity(){
		return LIBRARY_CAPACITY;
	}

public static void main(String[] args) {

	//Library libCap = new Library();

	//creates an array of instances from class Member
	Member[] member = new Member[LIBRARY_CAPACITY];
	for(int i=0; i<member.length; ++i){
		member[i] = new Member();
	}
	
	//creates an instances from class Search
	//Search srch = new Search();
	
	/*
	for(int i=0; i<member.length; ++i){
		System.out.printf("%n%s       %s       %c       %d", member[i].getName(), member[i].getFamilyName(), member[i].getGender(), member[i].getAge());
	}
	*/
	
	Scanner input = new Scanner(System.in);
							
	String isProgramOpen = "open";
	//program opens
	programLoop: while(isProgramOpen == "open"){
		//prompts for user choice whether he wants to add a nember or do member affairs
		System.out.printf(
							"%n1) Add member"+
							"%n2) Members affairs"+
							"%n3) Exit the program"+
							"%nPlease enter a number between 1 and 3: ");
		String firstMenu = input.next();
		//checking the validity of user choice
		while(!(firstMenu.equalsIgnoreCase("1") || firstMenu.equalsIgnoreCase("2") || firstMenu.equalsIgnoreCase("3"))){
			System.out.printf(
								"%n1) Add member"+
								"%n2) Members affairs"+
								"%n3) Exit the program"+
								"%nPlease enter a number between 1 and 3: ");
			firstMenu = input.next();
		}
		
		// taking actions on the choice of user in that adding  a member or handling previous members
		switch(Integer.parseInt(firstMenu)){
			// adding a member
			case 1:{
				// this block checks if there is free space for new membership
				int freePlace = member.length;
		
				for(int i=0; i<member.length; ++i)
					if(member[i].getName() != null)
						--freePlace;
				if(freePlace == 0)
				{
					System.out.printf("%nWe're sorry to say that the the membership list of the lobrary is full at the moment and we can't accept a new member.%n");
						continue programLoop;
				}

				// There is space for new member and enrollment process begins
				System.out.printf(
									"%n1) Enter new member profile"+
									"%n2) Back to previous menu"+
									"%n3) Exit the program"+
									"%nPlease enter a number between 1 and 3: ");
				String readyToBeMember = input.next();
				while(!(readyToBeMember.equalsIgnoreCase("1") || readyToBeMember.equalsIgnoreCase("2") || readyToBeMember.equalsIgnoreCase("3")))
				{
					System.out.printf(
										"%n1) Enter new member profile"+
										"%n2) Back to previous menu"+
										"%n3) Exit the program"+
										"%nPlease enter a number between 1 and 3: ");
					readyToBeMember = input.next();
				}

				switch(Integer.parseInt(readyToBeMember))
				{
					// new member identity profile are recieved
					case 1:
					{
						
						// find the first free place for member to save
						int placeID = 0;
						for(int i=0; i<member.length; ++i)
							if(member[i].getName() == null)
							{
								placeID = i;
								break;
							}
		
						// getting and saving member profile and then gets back to previous menu
						member[placeID].setID(placeID+1);
						
						System.out.printf("Name: ");
						member[placeID].setName(input.next());
				
						System.out.printf("Family name: ");
						member[placeID].setFamilyName(input.next());
								
						System.out.printf("Gender((M)male, (F)female): ");
						member[placeID].setGender(input.next().charAt(0));
						

						System.out.printf("Age: ");
						member[placeID].setAge(input.nextInt());
	
						System.out.printf("%nMembership ID is: %d.%n", placeID+1);


						for(int i=0; i<member.length; ++i)
							System.out.printf("%n%b, %d, %s, %s, %c, %d" ,member[i].getName() != null, member[i].getID(), member[i].getName(), member[i].getFamilyName(), member[i].getGender(), member[i].getAge());
						System.out.printf("%n");
						
						continue programLoop;
					}
					 // end of case 1, getting user profile and saving 
					//break;
					
					//gets back to previous menu (add member or member affairs
					case 2:
					{
						continue programLoop;
					}
					//break;
					
					//first menu option 3: exit program
					case 3:
					{
						isProgramOpen = "closed";
						continue programLoop;
					}
				}
				// end of switch(Integer.parseInt(readyToBeMember)), getting member profile
			}
			// end of case 1, option: add a member
			break;
			
			//first menu, option 2: member affairs
			case 2:{
				//first menu, option 2: member affairs
				membersAffairsLoop: while (Integer.parseInt(firstMenu) == 2){
					
					// prompt for user to semect, checks tbe choice validity
					System.out.printf(
										"%n1) Search"+
										"%n2) Show member profile"+
										"%n3) Edit member profile"+
										"%n4) Delete member"+
										"%n5) Back to previous menu"+
										"%n6) Exit the program"+
										"%nPlease enter a number from 1 to 5: ");
					String membersAffairs = input.next();
					while(!(membersAffairs.equalsIgnoreCase("1") || membersAffairs.equalsIgnoreCase("2") || membersAffairs.equalsIgnoreCase("3") || membersAffairs.equalsIgnoreCase("4") || membersAffairs.equalsIgnoreCase("5") || membersAffairs.equalsIgnoreCase("6"))){
						System.out.printf(
											"%n1) Search"+
											"%n2) Show member profile"+
											"%n3) Edit member profile"+
											"%n4) Delete member"+
											"%n5) Back to previous menu"+
											"%n6) Exit the program"+
											"%nPlease enter a number from 1 to 5: ");
					membersAffairs = input.next();
					}
					 
					// member affairs
					switch(Integer.parseInt(membersAffairs)){
						//searchs about members
						case 1:{
				searchLoop: while(Integer.parseInt(membersAffairs) == 1){
								System.out.printf(
													"%nSearch by:"+
													"%n1) ID"+
													"%n2) Name"+
													"%n3) Family name"+
													"%n4) Gender"+
													"%n5) Age"+
													"%n6) Back to previous menu"+
													"%n7) Exit the program"+
													"%nPlease enter a number from 1 to 7: ");
								String searchBy = input.next();
								while(!(searchBy.equalsIgnoreCase("1") || searchBy.equalsIgnoreCase("2") || searchBy.equalsIgnoreCase("3") || searchBy.equalsIgnoreCase("4") || searchBy.equalsIgnoreCase("5") || searchBy.equalsIgnoreCase("6") || searchBy.equalsIgnoreCase("7"))){
									System.out.printf(
														"%nSearch by:"+
														"%n1) ID"+
														"%n2) Name"+
														"%n3) Family name"+
														"%n4) Gender"+
														"%n5) Age"+
														"%n6) Back to previous menu"+
														"%n7) Exit the program"+
														"%nPlease enter a number from 1 to 7: ");				
									searchBy = input.next();
								}
		
								//takes action on user's search chioce	
								switch(Integer.parseInt(searchBy)){
									//search by ID
									case 1:{
										System.out.printf("%nID: ");
										int searchID = input.nextInt();
								
										//Validity of search ID is ckecked and the previous profile is shown
										if(member[searchID-1].getName() != null){
											System.out.printf("%nID   Name          Family name   Gender   Age   ");
											System.out.printf("%n------------------------------------------------");
											System.out.printf("%n%-5d%-14s%-14s%-9c%-6d%n", member[searchID-1].getID(), member[searchID-1].getName(), member[searchID-1].getFamilyName(), member[searchID-1].getGender(), member[searchID-1].getAge());
										}
										else
											System.out.printf("%nID not found.%n");
									}
									//end of case 1, search by ID
									break;
									
									//search by name
									case 2:{
										System.out.printf("Name or part of the Name: ");
										String searchName = input.next();
								
										//checks if there is occurrances of name of search case. if so, counts.						
										int counter=0;
										for(int i=0; i<member.length; ++i){
											if(member[i].getName() == null)
												continue;
								
											if(member[i].getName().toLowerCase().contains(searchName.toLowerCase()))
												++counter;
										}//end of counting age occurrances
							
										//displays the occurances of age of search case found						
										if(counter == 0)
											System.out.printf("%nNothing found.%n");
										else{
											System.out.printf("%nID   Name          Family name   Gender   Age   ");
											System.out.printf("%n------------------------------------------------");
											for(int i=0; i<member.length; ++i)
											{
												if(member[i].getName() == null)
												continue;
									
												if(member[i].getName().toLowerCase().contains(searchName.toLowerCase()))
													System.out.printf("%n%-5d%-14s%-14s%-9c%-6d", i+1, member[i].getName(), member[i].getFamilyName(), member[i].getGender(), member[i].getAge());
											}
										}
											System.out.printf("%n");
									}
									//end of case 2, search by name
									break;
									
									//search by family name
									case 3:{
										System.out.printf("Family name or part of the family name: ");
										String searchFamilyName = input.next();
								
										//checks if there is occurrances of name of search case. if so, counts.						
										int counter=0;
										for(int i=0; i<member.length; ++i){
												if(member[i].getFamilyName() == null)
													continue; 	
								
												if(member[i].getFamilyName().toLowerCase().contains(searchFamilyName.toLowerCase()))
													++counter;
											}//end of counting age occurrances
							
										//displays the occurances of age of search case found						
										if(counter == 0)
											System.out.printf("%nNothing found.%n");
										else{
											System.out.printf("%nID   Name          Family name   Gender   Age   ");
											System.out.printf("%n------------------------------------------------");
											for(int i=0; i<member.length; ++i){
												if(member[i].getFamilyName() == null)
													continue;
											
												if(member[i].getFamilyName().toLowerCase().contains(searchFamilyName.toLowerCase()))
													System.out.printf("%n%-5d%-14s%-14s%-9c%-6d", i+1, member[i].getName(), member[i].getFamilyName(), member[i].getGender(), member[i].getAge());
											}
											System.out.printf("%n");
										}
									}
									//end of search by family name
									break;
									
									//search by gender
									case 4:{
										System.out.printf("Gender((M)male, (F)female): ");
										char searchGender = input.next().charAt(0);
										while(!(searchGender == 'M' || searchGender == 'm' || searchGender == 'F' || searchGender == 'f')) {
											System.out.printf("Gender((M)male, (F)female): ");
											searchGender = input.next().charAt(0);
										}
										
										//checks if there is occurrances of gender of search case. if so, counts.						
										int counter=0;
										for(int i=0; i<member.length; ++i){
											if(member[i].getGender() == Character.toUpperCase(searchGender))
												++counter;
										}//end of counting gender occurrances
									
										//displays the occurances of gender of search case found						
										if(counter == 0)
											System.out.printf("%nNothing found.%n");
										else{
											System.out.printf("%nID   Name          Family name   Gender   Age   ");
											System.out.printf("%n------------------------------------------------");
											for(int i=0; i<member.length; ++i)
												if(member[i].getGender() == Character.toUpperCase(searchGender))
													System.out.printf("%n%-5d%-14s%-14s%-9c%-6d", i+1, member[i].getName(), member[i].getFamilyName(), member[i].getGender(), member[i].getAge());
											System.out.printf("%n");	
										}
									}
									//end of search by gender
									break;
									
									//search by age
									case 5:{
										System.out.printf("Age: ");
										int searchAge = input.nextInt();
										
										//checks if there is occurrances of age of search case. if so, counts.						
										int counter=0;
										for(int i=0; i<member.length; ++i){
											if(member[i].getAge() == searchAge)
												++counter;
										}//end of counting age occurrances
									
										//displays the occurances of age of search case found						
										if(counter == 0)
											System.out.printf("%nNothing found.%n");
										else{
											System.out.printf("%nID   Name          Family name   Gender   Age   ");
											System.out.printf("%n------------------------------------------------");
											for(int i=0; i<member.length; ++i)
												if(member[i].getAge() == searchAge)
													System.out.printf("%n%-5d%-14s%-14s%-9c%-6d", i+1, member[i].getName(), member[i].getFamilyName(), member[i].getGender(), member[i].getAge());
											System.out.printf("%n");
										}
									}
									//end of search by age
									break;
									
									//back to previous menu
									case 6:{
										continue membersAffairsLoop;
									}
									
									//serch by menu, option 7: exit program
									case 7:{
										isProgramOpen = "closed";
										continue programLoop;
									}
									
								}
								// end of dealing with user search choice
							}
							// end of searchLoop: while(Integer.parseInt(membersAffairs) == 1)
								
						}
						 //end of case 1, search about members
						break;
							 
						 //show member
						case 2:{
							// Your membership profile will be shown
							// Show ID is recieved to show profile
							System.out.printf("%nEnter ID: ");
							int showID = input. nextInt();

							//Validity of show ID is ckecked and the previous specification is shown
							if(member[showID-1].getName() != null){
								System.out.printf("%nID: %d", member[showID-1].getID());
								System.out.printf("%nName: %s", member[showID-1].getName());
								System.out.printf("%nFamily name: %s", member[showID-1].getFamilyName());
								System.out.printf("%nGender: %c", member[showID-1].getGender());
								System.out.printf("%nAge: %d%n", member[showID-1].getAge());
							}
							else
								System.out.printf("%nID not found.%n");
						}
						 // end of case 2, show member
						break;
						 
						 //edit member
						case 3:{
							// Edit ID is recieved to show profile
							System.out.printf("%nEnter ID: ");
							int editID = input.nextInt();
							

							//Validity of edit ID is ckecked and the previous specification is shown
							if(member[editID-1].getName() != null){
								System.out.printf("%nID: %d", member[editID-1].getID());
								System.out.printf("%nName: %s", member[editID-1].getName());
								System.out.printf("%nFamily name: %s", member[editID-1].getFamilyName());
								System.out.printf("%nGender: %c", member[editID-1].getGender());
								System.out.printf("%nAge: %d%n", member[editID-1].getAge());
								
								// New specification is recieved in order to be updated
								System.out.printf("%nNew Name: ");
								member[editID-1].setName(input.next());
								
								System.out.printf("New family name: ");
								member[editID-1].setFamilyName(input.next());
												
								System.out.printf("New Gender((M)male, (F)female): ");
								member[editID-1].setGender(input.next().charAt(0));
								
								System.out.printf("New Age: ");
								member[editID-1].setAge(input.nextInt());
								
								System.out.printf("%nThe memeber updated successfully.%n");
							}
							else
								System.out.printf("%nID not found.%n");
						}
						 // end od case 3, edit member
						break;
						 
						 //delete member
						case 4:{
							// delete your membership

							// Delete ID is recieved
							System.out.printf("%nEnter ID: ");
							int deleteID = input.nextInt();
							
							// Validity of delete is checked and member of that ID is deleted
							if(member[deleteID-1].getName() != null){
								System.out.printf("%nID: %d", member[deleteID-1].getID());
								System.out.printf("%nName: %s", member[deleteID-1].getName());
								System.out.printf("%nFamily name: %s", member[deleteID-1].getFamilyName());
								System.out.printf("%nGender: %c", member[deleteID-1].getGender());
								System.out.printf("%nAge: %d%n", member[deleteID-1].getAge());
								
								System.out.printf("%nAre you sure about deleting member with ID %d? ( Y(Yes), N(No))", deleteID);
								char confirmDeleteID = input.next().charAt(0);
								while(!(confirmDeleteID == 'Y' || confirmDeleteID == 'y' || confirmDeleteID == 'N' || confirmDeleteID == 'n')){
									System.out.printf("%nAre you sure about deleting member with ID %d? ( Y(Yes), N(No) ) ", deleteID);
									confirmDeleteID = input.next().charAt(0);
								}
								
								if(confirmDeleteID == 'Y' || confirmDeleteID == 'y'){
									member[deleteID-1].setID(0);
									member[deleteID-1].setName(null);
									member[deleteID-1].setFamilyName(null);
									member[deleteID-1].setGender('\u0000');
									member[deleteID-1].setAge(0);
									System.out.printf("%nThe memeber deleted successfully.%n");
								}
								else
									System.out.printf("%nThe memeber was not deleted.%n");
								
							}
							else
								System.out.printf("%nID not found.%n");
						}
						 // end of case 4, delete member
						 break;
						 
						 //back to previous menu
						case 5:
						{
							// to go back to first menu(
							continue programLoop;
						}
						//break;
						 
						 //exit the program
						case 6:
						{
							isProgramOpen = "closed";
							continue programLoop;
						}
					}
					// end of switch(Integer.parseInt(membersAffairs)): members affairs
				}
				//while(Integer.parseInt(firstMenu) == 2), first menu, option 2: member affairs       
			}
			// end of case2, option: member affairs
			break;
			
			//first menu, option 3: exit program
			case 3:{
				isProgramOpen = "closed";
			}		
		}
		// end of switch(Integer.parseInt(firstMenu)), taking actions on the choice of user if he adds a member or handles previous members
	}
	// end of programLoop, program is closed

}//end of method main
} // end class Library