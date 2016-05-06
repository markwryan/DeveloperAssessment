package com.markwryan;

import com.markwryan.model.Entry;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for AddressBook.
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
        final Entry entry1 = new Entry("mark", "ryan", "veritix", "216-555-1231", "mark@markwryan.com");
        final Entry entry2 = new Entry("danny", "salazar", "indians", "216-555-3141", "d.salazar@tribe.com");
        final Entry entry3 = new Entry("jason", "kipnis", "tribe", "212-555-1142", "jkkid@tribe.com");

        final List<Entry> expected = new ArrayList<>();
        expected.add(entry3);
        expected.add(entry1);
        expected.add(entry2);

        addressBook.addressBookEntries.add(entry1);
        addressBook.addressBookEntries.add(entry2);
        addressBook.addressBookEntries.add(entry3);

        List<Entry> result = addressBook.all();

        assertTrue(expected.size() == result.size());
        for(int i = 0; i < expected.size(); i++) {
            assertTrue(expected.get(i).equals(result.get(i)));
        }
    }

    @Test
    public void all_ReturnsEmptyArrayList_IfNoneAdded() {
        List<Entry> result = addressBook.all();
        assertEquals(0, result.size());
    }

    @Test
    public void search_ReturnsExpectedEntries_ForOrganization() {
        final String searchInput = "indians";
        final Entry entry1 = new Entry("mark", "ryan", "veritix", "216-555-1231", "mark@markwryan.com");
        final Entry entry2 = new Entry("danny", "salazar", searchInput, "216-555-3141", "d.salazar@tribe.com");
        final Entry entry3 = new Entry("jason", "kipnis", searchInput, "212-555-1142", "jkkid@tribe.com");

        addressBook.addressBookEntries.add(entry1);
        addressBook.addressBookEntries.add(entry2);
        addressBook.addressBookEntries.add(entry3);

        List<Entry> result = addressBook.search(searchInput);
        assertEquals(2, result.size());
        for(Entry entry : result) {
            assertTrue(entry.getOrganization().equals(searchInput));
        }
    }

    @Test
    public void search_ReturnsEmptyList_IfNoMatch() {
        final Entry entry1 = new Entry("mark", "ryan", "veritix", "216-555-1231", "mark@markwryan.com");
        final Entry entry2 = new Entry("danny", "salazar", "indians", "216-555-3141", "d.salazar@tribe.com");
        final Entry entry3 = new Entry("jason", "kipnis", "indians", "212-555-1142", "jkkid@tribe.com");

        addressBook.addressBookEntries.add(entry1);
        addressBook.addressBookEntries.add(entry2);
        addressBook.addressBookEntries.add(entry3);

        List<Entry> result = addressBook.search("tigers");
        assertEquals(0, result.size());
    }
}
