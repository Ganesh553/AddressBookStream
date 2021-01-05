package controller;

import model.Person;
import org.junit.Test;
import service.AddressBook;

import java.util.Scanner;

public class AddressBookMain {

    @Test
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AddressBook ab = new AddressBook();
        int choice=0;
        boolean flag=true;

        while(flag==true) {
            System.out.println("1. Adding new Person");
            System.out.println("2. Editing Person");
            System.out.println("3. deleting Person");
            System.out.println("4. Display all Contact details");
            System.out.println("5. Check duplicate element");
            System.out.println("6. Search by using State");
            System.out.println("7. Search by using City");
            System.out.println("8. Search State or city by using Person First Name");
            System.out.println("9. Sorting by  Person First Name");
            System.out.println("10. Get Contact number by State or City");
            choice = sc.nextInt();
            switch(choice) {
                case 1: System.out.println("Adding New User");
                    System.out.println("Enter First Name");
                    String firstName=sc.next();
                    System.out.println("Enter Last Name");
                    String lastName=sc.next();
                    System.out.println("Enter Address");
                    String address=sc.next();
                    System.out.println("Enter city");
                    String city=sc.next();
                    System.out.println("Enter state");
                    String state=sc.next();
                    System.out.println("Enter Zip");
                    int zip=sc.nextInt();
                    System.out.println("Enter phone number");
                    long phoneNumber=sc.nextLong();
                    Person person = new Person(firstName,lastName,address,city,state,zip,phoneNumber);
                    ab.addingNewPerson(person);
                    break;
                case 2: System.out.println("Editing Person");
                    System.out.println("Enter the firstName of the Person that you wish to edit");
                    String editName=sc.next();
                    ab.editingPerson(editName);
                    break;
                case 3: System.out.println("Deleting Person");
                    System.out.println("Enter the firstName of the person that you wish to delete");
                    String deleteName=sc.next();
                    ab.deletingPerson(deleteName);
                    break;
                case 4: System.out.println("Displaying all the contacts ");
                    ab.display();
                    break;
                case 5: System.out.println("Enter the First name to check duplicate");
                    ab.duplicatEntry();
                    break;
                default: System.out.println("your not selected between 1 to 10");
            }
            System.out.println("Do you wish to continue y/n");
            char ans = sc.next().charAt(0);
            if(ans=='y') {
                flag=true;
            }
            else {
                System.out.println("Thank you");
                flag=false;
            }
        }
    }

}
}