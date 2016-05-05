package com.markwryan;

import java.util.Scanner;

/**
 * Main Application file.
 */
public class AddressBook {
    public void waitForUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
    }

    public static void printUsage() {}


    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.waitForUserInput();
    }
}
