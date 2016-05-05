package com.markwryan;

import com.markwryan.model.Entry;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple AddressBook.
 */
public class AddressBookTest {
    private AddressBook addressBook;

    @Before
    public void setUp() {
        addressBook = new AddressBook();
    }


    @Test
    public void handleUserAddressBookEntry_AddsEntryToAddressBook() {
        final String entry = "mark,ryan,veritix,216-555-1231,notmyemail@fakeemail.com";
        final Entry expectedEntry = new Entry("mark", "ryan", "veritix", "216-555-1231", "notmyemail@fakeemail.com");

        addressBook.handleUserAddressBookEntry(entry);

        assertEquals(1, addressBook.addressBookEntries.size());
        assertEquals(expectedEntry, addressBook.addressBookEntries.get(0));
    }
}
