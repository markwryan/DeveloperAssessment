package com.markwryan;

import com.markwryan.model.Entry;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


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
    public void add_AddsValidEntryToAddressBook_AndReturnsTrue() {
        final String entry = "mark,ryan,veritix,216-555-1231,notmyemail@fakeemail.com";
        final Entry expectedEntry = new Entry("mark", "ryan", "veritix", "216-555-1231", "notmyemail@fakeemail.com");

        boolean result = addressBook.add(entry);
        assertTrue(result);
        assertEquals(1, addressBook.addressBookEntries.size());
        assertEquals(expectedEntry, addressBook.addressBookEntries.get(0));
    }

    @Test
    public void add_DoesNotAdd_AndReturnsFalse_ForInvalidEntry() {
        boolean result = addressBook.add("bad bad string");
        assertFalse(result);
        assertEquals(0, addressBook.addressBookEntries.size());
    }

    @Test
    public void all_ReturnsEntries_SortedByLastName() {
        
    }
}
