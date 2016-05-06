package com.markwryan;

import com.markwryan.model.Entry;
import com.markwryan.util.AddressBookFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mark on 5/5/16.
 */
public class AddressBook {
    //List of Entries in the Address Book
    protected List<Entry> addressBookEntries;

    public AddressBook() {
        addressBookEntries = new ArrayList<>();
    }

    public boolean add(String input) {
        try {
            addressBookEntries.add(AddressBookFactory.createEntry(input));
            return true;
        } catch (IllegalArgumentException iae) {
            return false;
        }
    }

    public List<Entry> all() {
        addressBookEntries.sort((a,b) -> a.getLastName().compareTo(b.getLastName()));
        return addressBookEntries;
    }
}
