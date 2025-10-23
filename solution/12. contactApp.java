       /** Add Contact - Store name, multiple phone numbers, and email
        Search Contacts - Find contacts by name (partial matching)
        Display All Contacts - Show formatted contact list
        Update Contact - Modify existing contact information
        Delete Contact - Remove contacts from the system
        Sort Contacts - Alphabetically sort contacts by name
        Find Duplicates - Detect contacts with similar names or same phone numbers
        **/
import java.util.ArrayList;
import java.util.Scanner;

public class contactApp {
    static ArrayList<String> name = new ArrayList<String>();
    static ArrayList<String> phoneNum = new ArrayList<String>();
    static ArrayList<String> email = new ArrayList<String>();
    static Scanner sc = new Scanner(System.in);
    static final int maxContact = 5;
    public static int currentContact = 0;
    public static int contactLeft =maxContact;



    public static void main(String[] args) {
//      Var initialization
        int choice;
        boolean lagi = true;
        String menu = """
                ===--Contact Management System---===
                1. Add Contact
                2. Display All Contacts
                3. Search Contact
                4. Show Contact Count
                5. Delete Contact
                6. Exit             
                
                """;
        System.out.println(menu);
        do {
            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            if(choice <= 0 || choice> 6){
                System.out.println("invalid choice!");
                System.out.print("Enter Your Choice: ");
                choice = sc.nextInt();
            }else if (choice == 6) lagi=false;
            switch (choice){
               case 1-> addContact();
               case 2-> displayAllContact();
               case 3-> searchContact();
               case 4-> showStats();
               case 5->delete();
            }
        }while(lagi);
        System.out.println("bye!");

    }
    //       Add contact section
    static void addContact() {
        if(contactLeft != 0){
        System.out.println("--- ADD CONTACT ---");
        System.out.print("Enter contact name: ");
        String inputName = sc.nextLine();
        name.add(inputName);
        System.out.print("Enter phone number: ");
        String inputNum = sc.nextLine();
        phoneNum.add(inputNum);
        System.out.print("Enter Email: ");
        String inputEmail = sc.nextLine();
        email.add(inputEmail);
        System.out.println("✓ Contact added successfully!");
            currentContact++;
            contactLeft--;
        }else{
            System.out.println("Contact Storage Full!");
        }
    }
    static void displayAllContact(){

        int arrSize = name.size();
        if(arrSize<1){
            System.out.println("Data is empty! ");
        }else{
        System.out.println("--- ALL CONTACTS ---");
        System.out.println("Total Contacts: "+ name.size());
        System.out.println("Contact details: \n");
        for(int i =0; i<arrSize;i++){
            System.out.printf("#%d Name: %s \n %6s: %s \n %6s: %s \n",(i+1),name.get(i),"Phone",phoneNum.get(i), "Email", email.get(i));
            System.out.println();
        }

        }
    }

    static void searchContact() {
        int arrSize = name.size();

        System.out.print("Enter name to search: ");
        String searchedName = sc.nextLine();
        int nContact = 0;

        boolean foundContact = false;
        for (int i = 0; i < arrSize; i++) {
            String currentName = name.get(i);

            if (currentName.toLowerCase().contains(searchedName)) {
                System.out.printf("#%d Name: %s \n %6s: %s \n %6s: %s \n", (i + 1), name.get(i), "Phone", phoneNum.get(i), "Email", email.get(i));
                nContact++;
                foundContact = true;
            }
        }
        if (!foundContact) {
            System.out.println("No contacts found matching '" + searchedName + "'.");
        } else {
            System.out.println("--------------------");
            System.out.println("Found " + nContact + " matching contact(s).");
        }
    }
    static void showStats(){
        System.out.println("Total Contacts: "+ currentContact);
        System.out.println("Contacts Capacity: "+ maxContact);
        System.out.println("Available Capacity: "+ contactLeft);
    }

    static void delete(){
        int arrSize = name.size();
        System.out.println("""
                --- DELETE CONTACT ---
                Current Contacts:
                """);
        for (int i= 0; i<arrSize;i++){
            System.out.println((i+1)+". "+ name.get(i));
        }
        System.out.print("Enter number to delete: ");
        int selectedDelNum = sc.nextInt();
        if(selectedDelNum<=0 || selectedDelNum>arrSize){
            System.out.println("Invalid num!");
        }else {
            name.remove((selectedDelNum-1));
            phoneNum.remove((selectedDelNum-1));
            email.remove((selectedDelNum-1));
            System.out.println("✓ Contact '"+selectedDelNum+ ". 'deleted successfully!");
        }


    }
}
