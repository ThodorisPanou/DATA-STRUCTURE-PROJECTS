import java.util.Scanner;

public class RBSTmain {
	static RandomizedBST r = new RandomizedBST();
	
	public static void main(String[] args) {
		
	try {	
		while(true) {
			System.out.println();
			System.out.println("PRESS 1 TO Enter THE FILE NAME TO BE UPLOADED");
			System.out.println("PRESS 2 TO INSERT A NEW SUSPECT");
			System.out.println("PRESS 3 TO UPDATE THE SAVINGS OF A SUSPECT");
			System.out.println("PRESS 4 TO FIND A SUSPECT BY AFM");
			System.out.println("PRESS 5 TO FIND A SUSPECT BY HIS LAST NAME");
			System.out.println("PRESS 6 TO REMOVE A SUSPECT FROM THE SUSPECT LIST");
			System.out.println("PRESS 7 TO SEE THE AVERAGE AMOUNT OF SUSPECT'S SAVINGS");
			System.out.println("PRESS 8 TO SEE THE TOP SUSPECTS");
			System.out.println("PRESS 9 TO SEE THE SUSPECTS AFM SORTED");
			Scanner sc = new Scanner(System.in);
		    int select = sc.nextInt();
		    
		    if (select==1) {
		    	System.out.print("Enter file name: ");
		    	String s = sc.next();
		    	r.load(s);
		    }
		    else if (select==2) {
		    	Suspect sus = new Suspect();
		    	System.out.print("Enter suspect first name: ");
		    	String firstname = sc.next();
		    	sus.setFirstName(firstname);
		    	System.out.print("Enter suspect last name: ");
		    	String lastname = sc.next();
		    	sus.setLastName(lastname);
		    	System.out.print("Enter suspect afm: ");
		    	int afm = sc.nextInt();
		    	sus.setKey(afm);
		    	System.out.print("Enter suspect savings: ");
		    	int savings = sc.nextInt();
		    	sus.setSavings(savings);
		    	System.out.print("Enter suspect taxedIncome: ");
		    	int income = sc.nextInt();
		    	sus.setTaxedIncome(income);
		    	r.insert(sus);
		    }
		    else if (select==3) {
		    	System.out.print("Enter suspect's AFM: ");
		    	int afm = sc.nextInt();
		    	System.out.print("Enter suspect's savings: ");
		    	int savings = sc.nextInt();
		    	r.updateSavings(afm, savings);
		    }
		    else if (select==4) {
		    	System.out.print("Enter AFM: ");
		    	int afm = sc.nextInt();
		    	System.out.println(r.searchByAFM(afm));
		    }
		    else if (select==5) {
		    	System.out.print("Enter suspect's last name: ");
		    	String s = sc.next();
		    	System.out.println(r.searchByLastName(s));
		    }
		    else if (select==6) {
		    	System.out.print("Enter suspect afm: ");
		    	int afm = sc.nextInt();
		    	r.remove(afm);
		    }
		    else if(select==7) {
		    	System.out.println("Avergae amount of savings is: " +r.getMeanSavings());
		    }
		    else if (select==8) {
		    	System.out.println("How many top suspects do you want to see?");
		    	int k = sc.nextInt();
		    	r.printTopSuspects(k);
		    }
		    else if (select==9) {
		    	r.printByAFM();
		    }
		    System.out.println("DO YOU WISH TO CONTINUE?TYPE 1 IF YES ,OR ANY OTHER KEY IF NOT");
		    int answer=sc.nextInt();
		    if(answer!=1) {break;}
			
			}
		}
	
	catch(Exception e) {
		System.out.println("WRONG INPUT");
	}
		
	}
}


