package com.markwryan;

import com.markwryan.model.Entry;
import com.markwryan.util.AddressBookFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Address Book program.
 */
public class AddressBook {
    //List of Entries in the Address Book
    protected List<Entry> addressBookEntries;
    //Scanner to handle user input
    private Scanner scanner;

    public AddressBook() {
        addressBookEntries = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Prompt and wait for user command.
     */
    public void waitForUserCommand() {
        System.out.println("Please enter a command (add|list|exit): ");
        String command = scanner.next();
        if(command.contains("add")) {
            waitForUserAddressBookEntry();
        } else if(command.contains("list")) {
            listAddressBookEntries();
        } else if(command.contains("exit")) {
            exit();
        } else {
            waitForUserCommand();
        }
    }

    /**
     * Prompt and wait for new Address Book entry. Call handle method.
     */
    public void waitForUserAddressBookEntry() {
        System.out.println("[first],[last],[organization],[phone],[email]: ");
        String input = scanner.next();
        handleUserAddressBookEntry(input);
        waitForUserCommand();
    }

    /**
     * Handle user inputting a new entry.
     *
     * @param input - User Input
     */
    public void handleUserAddressBookEntry(String input) {
        try {
            addressBookEntries.add(AddressBookFactory.createEntry(input));
        } catch (IllegalArgumentException iae) {
            waitForUserAddressBookEntry();
        }

    }

    /**
     * Output the Address Book entries, sorted by last name.
     */
    public void listAddressBookEntries() {
        addressBookEntries.sort((a,b) -> a.getLastName().compareTo(b.getLastName()));
        addressBookEntries.forEach(System.out::println);
        waitForUserCommand();
    }

    /**
     * Quit the program
     */
    public void exit() {
        return;
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.waitForUserCommand();
    }
}
