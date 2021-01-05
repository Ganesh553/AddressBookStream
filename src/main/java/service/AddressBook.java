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
}