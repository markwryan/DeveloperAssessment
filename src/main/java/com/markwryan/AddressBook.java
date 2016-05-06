package com.markwryan;

import com.markwryan.model.Entry;
import com.markwryan.util.AddressBookFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            Entry entry = AddressBookFactory.createEntry(input);
            //Entry.equals looks only add First and Last name
            addressBookEntries.remove(entry);
            addressBookEntries.add(entry);
            return true;
        } catch (IllegalArgumentException iae) {
            return false;
        }
    }

    public List<Entry> all() {
        addressBookEntries.sort((a,b) -> a.getLastName().compareTo(b.getLastName()));
        return addressBookEntries;
    }

    public List<Entry> search(String input) {
        return addressBookEntries.stream()
                .filter((entry) -> entry.getOrganization().equals(input))
                .collect(Collectors.toList());
    }
}
