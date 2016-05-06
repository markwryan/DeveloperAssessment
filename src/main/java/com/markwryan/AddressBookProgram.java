package com.markwryan;

import java.util.Scanner;

/**
 * Address Book program.
 */
public class AddressBookProgram {
    private AddressBook addressBook;
    //Scanner to handle user input
    private Scanner scanner;

    //Available Commands
    private enum Command {
        ADD, LIST, SEARCH, EXIT
    }

    public AddressBookProgram() {
        scanner = new Scanner(System.in);
        addressBook = new AddressBook();
    }

    /**
     * Prompt and wait for user command.
     */
    public void waitForUserCommand() {
        System.out.println("Please enter a command (add|list|search|exit): ");
        String input = scanner.next();

        Command command;
        try {
            command = Command.valueOf(input.trim().toUpperCase());
        }catch (IllegalArgumentException iae) {
            waitForUserCommand();
            return;
        }

        switch(command) {
            case ADD:
                waitForUserAddressBookEntry();
                break;
            case LIST:
                listAddressBookEntries();
                break;
            case SEARCH:
                waitForUserOrganizationSearch();
            case EXIT:
                exit();
        }
    }

    /**
     * Prompt and wait for new Address Book entry. Call handle method.
     */
    public void waitForUserAddressBookEntry() {
        System.out.println("[first],[last],[organization],[phone],[email]: ");
        String input = scanner.next();
        handleUserAddressBookEntry(input.trim());
        waitForUserCommand();
    }

    public void waitForUserOrganizationSearch() {
        System.out.println("Enter organization name: ");
        String input = scanner.next();
        handleUserOrganizationSearch(input.trim());
        waitForUserCommand();
    }

    /**
     * Handle user inputting a new entry.
     *
     * @param input - User Input
     */
    public void handleUserAddressBookEntry(String input) {
        boolean result = addressBook.add(input);
        if(result) {
            waitForUserCommand();
        } else {
            System.out.println("Looks like an incorrect entry.");
            waitForUserAddressBookEntry();
        }
    }

    /**
     * Output the Address Book entries, sorted by last name.
     */
    public void listAddressBookEntries() {
        addressBook.all().forEach(System.out::println);
        waitForUserCommand();
    }

    public void handleUserOrganizationSearch(String input) {
        addressBook.search(input).forEach(System.out::println);
    }
    /**
     * Quit the program
     */
    public void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        AddressBookProgram addressBookProgram = new AddressBookProgram();
        addressBookProgram.waitForUserCommand();
    }
}
