/**
 * 
 */
package collegeCost;

import java.util.Scanner;
/**
 * @author Maruti on 3/21/2017 at 4:21 AM
 *
 */
public class CollegeCost {

	/**
	 * @param args
	 */
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		String name = getName();
		printTotal(name);

	}
	
	public static String getName() {
		System.out.println("Enter the name of the student: ");
		String name = in.nextLine();
		return name;
	}
	
	
	public static void printTotal(String name){
		double total = 0;
		if(onCampus(name)){
			total = calculateTotal(estimatedLivingExpenses(),
					booksAndSupplies(), creditHours(), costPerCredit());
		}
		else{
			total = calculateTotal(booksAndSupplies(), creditHours(), costPerCredit());
		}
		String year = getYear();
		if(year.equalsIgnoreCase("other"))
			System.out.printf("Total cost for " +name+ " is $%6.2f", total);
		else
			System.out.printf("Total cost for " +name+ " as a " +year+ " is $%6.2f", total);
		System.out.println();
	}
	
	public static boolean onCampus(String name) {
		boolean invalidResponse = true;
		do{
			System.out.println("Is "+name+"living on campus? (Yes/No)");
			String response = in.nextLine();
			if(response.equalsIgnoreCase("yes"))
				return true;
			else if(response.equalsIgnoreCase("no"))
				return false;
			else
				System.out.println("Invalid response");
		}while(invalidResponse);
		return false;
	}
	
	public static double estimatedLivingExpenses() {
		double total = 0;
		try{
			System.out.println("How many weeks will the student stay on campus?");
			String value = in.nextLine();
			int weeks = Integer.parseInt(value);
			System.out.println("What are the estimate weekly living expenses?");
			value = in.nextLine();
			double weeklyExpenses = Double.parseDouble(value);
			System.out.println("What is the room and board for the year");
			value = in.nextLine();
			double roomBoard = Double.parseDouble(value);
			total = weeks * weeklyExpenses + roomBoard;
		}
		catch(Exception e){
			System.out.println("Invalid Data type");
			e.printStackTrace();
		}
		return total;
	}
	

	public static double booksAndSupplies() {
		System.out.println("What is the estimated cost of Books and Supplies: ");
		double cost = in.nextDouble();
		return cost;
	}
	
	
	public static int creditHours() {
		System.out.println("How many credit hours is the student planning to take?");
		int hours = in.nextInt();
		return hours;
	}
	
	
	public static double costPerCredit() {
		System.out.println("What is the cost of the credit per Hour?");
		double costCredit = in.nextDouble();
		return costCredit;
	}
	
	
	public static double calculateTotal(double livingExpenses, double books, int credit,
			double cost) {
		return livingExpenses + books + (credit * cost);
	}
	
	
	public static double calculateTotal(double books, int credit,
			double cost) {
		return books + (credit * cost);
	}
	
	
	public static String getYear() {
		System.out.println("What year is the student(Freshman, Sophomore, Junior, Senior, Other?");
		String year = in.next();
		return year;
	}

}
