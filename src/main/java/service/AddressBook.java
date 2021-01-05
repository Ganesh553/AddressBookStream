package service;

import model.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    ArrayList<Person> al = new ArrayList<Person>();
    Scanner sc = new Scanner(System.in);

    public void addingNewPerson(Person obj) {
        al.add(obj);
    }
    public void editingPerson(String editName) {
        boolean flag = true;
        for (Person obj : al) {
            System.out.println("1");
            if (obj.getFirstName().equals(editName)) {
                System.out.println("2");
                while (flag == true) {
                    System.out.println("Editing block...");
                    System.out.println("1 for Address");
                    System.out.println("2 for city");
                    System.out.println("3 for state");
                    System.out.println("4 for zip");
                    System.out.println("5 for Phone Number");
                    System.out.println("6 for Exiting");
                    System.out.println("7 for Continue");
                    System.out.println("Select which you want to edit");
                    int choice = sc.nextInt();
                    System.out.println("1");
                    switch (choice) {
                        case 1:
                            System.out.println("Enter Address");
                            String Address = sc.next();
                            obj.setAddress(Address);
                            System.out.println("Address is changed");
                            break;
                        case 2:
                            System.out.println("Enter City");
                            String City = sc.next();
                            obj.setCity(City);
                            break;
                        case 3:
                            System.out.println("Enter State");
                            String State = sc.next();
                            obj.setState(State);
                            break;
                        case 4:
                            System.out.println("Enter Zip");
                            int zip = sc.nextInt();
                            obj.setZip(zip);
                            break;
                        case 5:
                            System.out.println("Enter Phone Number");
                            Long phoneNumber = sc.nextLong();
                            obj.setPhoneNumber(phoneNumber);
                            break;
                        case 6:
                            System.out.println("Exiting...");
                            flag = false;
                            break;
                        case 7:
                            System.out.println("Do you want to continue with other option y/n");
                            char ans = sc.next().charAt(0);
                            if (ans == 'y')
                                flag = true;
                            else
                                flag = false;
                    }
                }
            }
        }
    }
}
