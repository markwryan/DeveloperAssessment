package com.markwryan.util;

import com.markwryan.model.Entry;

/**
 * Created by mark on 5/5/16.
 */
public class AddressBookFactory {

    /**
     * Take in user input in the following form and return a Entry.
     *
     * [first name],[last name],[organization],[phone number],[email]
     *
     * @param input - User input
     * @return new Entry
     */
    public static Entry createEntry(String input) {
        String[] parsedInput = input.split(",");
        if(parsedInput.length == 5) {
            return new Entry(parsedInput[0], parsedInput[1], parsedInput[2], parsedInput[3], parsedInput[4]);
        }
        throw new IllegalArgumentException("Invalid input.");
    }
}
