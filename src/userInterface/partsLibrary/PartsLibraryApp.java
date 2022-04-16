package userInterface.partsLibrary;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import partsLibrary.Library;
import partsLibrary.Parts;
import partsLibrary.PartsLibrary;

public class PartsLibraryApp {

	public static void main(String[] args) {

		int menuchoice = 1;
		while (menuchoice != 0) {

		try {		//try and catch and exit if the mainprogram craches
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		keyboard.useDelimiter(System.lineSeparator());

		String filename = "partslibrarylist.txt";
		Library<Parts> parts= new PartsLibrary();

		populateLibrary(parts);
		parts.readItems(filename);

		do { // Menu system
				System.out.print("\n Parts DataBase Menu\n\n"
						+ " 1 - Present complete content\n"
						+ " 2 - Add part to database\n"
						+ " 3 - Remove part from database\n"
						+ " 4 - Search for a part by part no, descripton, where to buy, buy date\n"
						+ " 5 - Store current database content in file\n"
						+ " 6 - Read content from file to database\n"
						+ " 7 - Export to *.csv\n"
						// + " 8 - Import *.csv\n"
						+ " 0 - Exit application\n\n : ");

				menuchoice = keyboard.nextInt();

				switch(menuchoice) {

				case 1:
					System.out.println("\n PartsLibrary list");
					System.out.println(
							"  _________________________________________________________________________________________________________________________");
					parts.showLibraryOnTextConsole();
					System.out.println(
							"  =========================================================================================================================");
				break;

				case 2:	
					
					int itemId = parts.getNoOfItems()+1;
					
					System.out.print(" Enter part number: ");
					String partNum = keyboard.next();
					int partNo = Integer.parseInt(partNum);

					System.out.print(" Enter decription: ");
					String description = keyboard.next();

					System.out.print(" Enter where to buy: ");
					String whereToBuy = keyboard.next();

					System.out.print(" Enter buy date: ");
					String buyDate = keyboard.next();

					System.out.print(" Price to buy: ");
					float price = keyboard.nextFloat();

					int stored = 0;

					Parts temp = new Parts(itemId, partNo, description,
							whereToBuy, buyDate, price, stored);
					parts.addItem(temp);
					break;

				case 3:
					System.out.println("\n Parts Library list");
					System.out.println("  ________________________________________________________________________________________________________________");
					parts.showLibraryContents();
					System.out.println("  ================================================================================================================");
					
					System.out.format(
							"\n Are you sure you want to delete part from list? ");
					String ok=keyboard.next();
					if(ok.contains("Y")||ok.contains("y")) {
						
						System.out.print("\n Chose part[id=] to remove: ");
						int index = keyboard.nextInt();
						Parts tempParts = parts.getItem(index);
						if (tempParts != null) {
							parts.removeItem(tempParts);
						}
						else {
							System.out.println(" Part item number not found");
						}
						
					}
					else {
						if(ok.contains("N")||ok.contains("n")) {
							System.out.format("\n List not saved\n");
						}
						else {
							System.out.format("\n Not a valid input, try again!\n");
						}
					}
					break;
 
				case 4:
					System.out.print(
							"\n Enter part no, descripton, where to buy, buy date, price (exact match search): ");
					String search=keyboard.next();
					System.out.println();
					List<Parts> searchPartsList = new ArrayList<>();
					searchPartsList = parts.searchItem(search);
					if (searchPartsList != null) {
						int i=0;
						System.out.format("  Search result\n"
								+ "  ________________________________________________________________________________________________________________\n");
						for (Parts result : searchPartsList) {
							i++;
							System.out.format(" %s\n", result);
						}
						System.out.format("  ================================================================================================================\n");
						System.out.format("  %d partss found\n\n", i);
					}	
					break;

				case 5:
					System.out.println("  ________________________________________________________________________________________________________________");
					parts.showLibraryContents();
					System.out.println("  ================================================================================================================");
					System.out.format("\n Do you want to save current list to file?\n"
							+ " Previous saved %s will be overwritten (Y/N): ", filename);
					String ok5=keyboard.next();
					if(ok5.contains("Y")||ok5.contains("y")) {
						parts.storeItems(filename);
					}
					else {
						if(ok5.contains("N")||ok5.contains("n")) {
							System.out.format("\n List not saved\n");
						}
						else {
							System.out.format("\n Not a valid input, try again!\n");
						}
					}
					break; 

				case 6:
					System.out.format("\n Are you sure you want to read list from saved file?\n"
							+           " Unsaved changes will be lost and [id=] renumbered(Y/N): ");
					String ok6=keyboard.next();
					if(ok6.contains("Y")||ok6.contains("y")) {

						System.out.format(" Content of %s\n", filename);
						parts.readItems(filename);
					}
					else {
						if(ok6.contains("N")||ok6.contains("n")) {
							System.out.format(
									"\n Saved partslist not uploaded from file\n");
						}
						else {
							System.out.format("\n Not a valid input, try again!\n");
						}
					}
					break;

				case 7:
					filename = "partslist.csv";
					System.out.println(
							"  ____________________________________________________________________________________________________________________");
					parts.showLibraryContents();
					System.out.println(
							"  ====================================================================================================================");
					System.out.format(
							"\n Do you want to save current list to *.csv?\n"
									+ " Previous saved %s will be overwritten (Y/N): ",
							filename);
					String okSaveCSV = keyboard.next();
					if (okSaveCSV.contains("Y") || okSaveCSV.contains("y")) {
						parts.storeItemsAsCSV(filename);
					} else {
						if (okSaveCSV.contains("N")
								|| okSaveCSV.contains("n")) {
							System.out.format("\n List not saved\n");
						} else {
							System.out.format(
									"\n Not a valid input, try again!\n");
						}
					}
					break;

				case 0:
					System.out.println(" Exit program");
					System.out.format("\n Do you want to save current list to file?\n"
							+ " Previous saved %s will be overwritten (Y/N): ", filename);
					String exit = keyboard.next();
					if (exit.contains("Y") || exit.contains("y")) {
						parts.storeItems(filename);
					} else {
						if (exit.contains("N") || exit.contains("n")) {
							System.out.format("\n List not saved\n");
						} else {
							System.out.format("\n Not a valid input, try again!\n");
						}
					}
					break;

				default:
					System.out.println(" Not a valid input, try again!");
					break;
				}

		}while(menuchoice!=0);
		}
		catch(InputMismatchException e) {
//			System.out.println(" Not a valid input " + e);
			System.out.println(" Not a valid input, try again!");
		}
		}
	}
	
	/**
	 * This method sets up a test library
	 * @param lib a reference to the Library implementation to use in application
	 */
	static void populateLibrary(Library<Parts> lib) {

		Parts[] myParts = new Parts[3];

		myParts[0] = new Parts(0, 41015979, "ESP32 Feather", "Electrokit",
				"2020-11-10", 279, 0);
		myParts[1] = new Parts(0, 41015302, "Teensy 3.5", "Electrokit",
				"2020-11-10", 379, 0);
		myParts[2] = new Parts(0, 41015979, "ESP32 Feather", "Electrokit",
				"2021-05-15", 279, 0);

		for (Parts m : myParts) {
			lib.addItem(m);
		}
	}

//	static void startLibrary(Library<Parts> lib) {
//
//		parts.readItems(filename);
//		
//	}

}
