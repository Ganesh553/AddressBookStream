package service;

import model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    public void deletingPerson(String FirstName) {
        if(al.isEmpty())
            System.out.println("No Address Present");
        else {
            for(Person obj:al) {
                if(obj.getFirstName().equals(FirstName))
                {
                    al.remove(obj);
                    System.out.println("Deleted is Successful");
                    break;
                }
            }
        }
    }
    public void display() {
        if(al.isEmpty())
            System.out.println("No Address Present");
        else {
            for(Person obj : al) {
                System.out.print("FirstName: "+ obj.getFirstName()+" LastName: " + obj.getLastName()+" Address: " + obj.getAddress()+" City: "+ obj.getCity()+" State: " + obj.getState()+" Zip: " + obj.getZip()+" phoneNumber: " + obj.getPhoneNumber());
                System.out.println();
            }
        }
    }
    public void duplicatEntry() {
        if(al.isEmpty())
            System.out.println("No element in Address Book");
        else {
            for(Person obj : al) {
                System.out.println("Enter First name");
                String firstName = sc.next();
                if (obj.getFirstName().equals(firstName))
                {
                    System.out.println("Dublicate entry is not allowed");
                    break;
                }
                else {
                    System.out.println("There is no duplicate, Continue..");
                    break;
                }
            }
        }
    }
    public void searchState(String searchState) {
        if(al.isEmpty())
            System.out.println("No Address Present");
        else {
            for(Person obj:al) {
                if(obj.getState().equals(searchState))
                    System.out.println(obj.getFirstName());
            }
        }
    }
    public void searchCity(String searchCity) {
        if(al.isEmpty())
            System.out.println("No Address Present");
        else {
            for(Person obj:al) {
                if(obj.getCity().equals(searchCity))
                    System.out.println(obj.getFirstName());
            }
        }
    }
    public void searchPerson(String searchName) {
        if(al.isEmpty())
            System.out.println("No Address is Present");
        else {
            for(Person obj:al) {
                if(obj.getFirstName().equals(searchName)) {
                    System.out.println("Select 1. For State");
                    System.out.println("Select 2. For City");
                    int select = sc.nextInt();
                    switch(select) {
                        case 1: System.out.println(obj.getState());
                            break;
                        case 2: System.out.println(obj.getCity());
                            break;
                    }
                }
            }
        }
    }
    public void sortingByFirstName() {
        if(al.isEmpty())
            System.out.println("No Address is Present");
        else {
            System.out.println("Sorting an person object,Select 1:FirstName 2:State 3:City");
            int select = sc.nextInt();
            switch(select) {
                case 1: List<Person> sortedListfName = al.stream()
                        .sorted(Comparator.comparing(Person::getFirstName))
                        .collect(Collectors.toList());
                    sortedListfName.forEach(System.out::println);
                    break;
                case 2: List<Person> sortedListState = al.stream()
                        .sorted(Comparator.comparing(Person::getState))
                        .collect(Collectors.toList());
                    sortedListState.forEach(System.out::println);
                    break;
                case 3: List<Person> sortedListCity = al.stream()
                        .sorted(Comparator.comparing(Person::getCity))
                        .collect(Collectors.toList());
                    sortedListCity.forEach(System.out::println);
                    break;
            }
        }
    }
    public void getContactByState(String getByState) {
        if(al.isEmpty())
            System.out.println("No Address is Present");
        else {
            for(Person obj:al) {
                if(obj.getState().equals(getByState))
                    System.out.println(obj.getPhoneNumber());
                else
                    System.out.println("No such State is Present");
            }
        }
    }

    public void getContactByCity(String getByCity) {
        if(al.isEmpty())
            System.out.println("No Address is Present");
        else {
            for(Person obj:al) {
                if(obj.getCity().equals(getByCity))
                    System.out.println(obj.getPhoneNumber());
                else
                    System.out.println("No such City is present");
            }
        }
    }
}
