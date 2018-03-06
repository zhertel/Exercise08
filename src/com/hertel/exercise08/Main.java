package com.hertel.exercise08;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ContactCollection contactList = new ContactCollection();
        contactList.addContact(new Contact("Tim McPerson", "genericemail@gmail.com"));
        contactList.addContact(new Contact("A Literal Potato", "frenchfryguy@gmail.com"));
        contactList.addContact(new BusinessContact("Kylo Ren", "vaderfan1@gmail.com", "(873) 342-8798"));
        contactList.addContact(new BusinessContact("Batman", "notbrucewayne@gmail.com", "(472) 348-7324"));

        contactList.displayAll();

        System.out.println("Total Contacts: " + Contact.contactTotal);
        System.out.println("Total Business Contacts: " + BusinessContact.bContactTotal);
    }
}

class Contact {
    private String name;
    private String email;

    static int contactTotal;

    public Contact() {
        contactTotal++;
    }

    public Contact(String name, String email) {
        contactTotal++;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void display() {
        System.out.println("Contact name: " + getName());
        System.out.println("-" + getName() + "'s email: " + getEmail());
    }
}

class BusinessContact extends Contact {
    private String phoneNumber;

    static int bContactTotal;

    public BusinessContact() {
        bContactTotal++;
    }

    public BusinessContact(String name, String email, String phoneNumber){
        super(name, email);
        this.phoneNumber = phoneNumber;
        bContactTotal++;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("-" + getName() + "'s phone number: " + getPhoneNumber());
    }
}

class ContactCollection {
    private Contact contact;

    private List<Contact> contacts = new ArrayList<Contact>();

    public ContactCollection(){
    }

    public void addContact(Contact newContact){
        contacts.add(newContact);
    }

    public void displayAll(){
        for (Contact person:contacts){
            person.display();
        }
    }
}