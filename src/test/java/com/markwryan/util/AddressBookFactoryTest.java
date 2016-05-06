package com.markwryan.util;

import com.markwryan.model.Entry;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mark on 5/5/16.
 */
public class AddressBookFactoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void createEntry_ThrowsExceptionForBadInput() {
        AddressBookFactory.createEntry("bad entry");
    }

    @Test
    public void createEntry_CreatesEntryFromValidInput() {
        final String input = "corey,kluber,indians,216-555-7777,klubot@tribe.com";
        final String firstName = "corey";
        final String lastName = "kluber";
        final String organization = "indians";
        final String phone = "216-555-7777";
        final String email = "klubot@tribe.com";

        Entry result = AddressBookFactory.createEntry(input);

        assertEquals(firstName, result.getFirstName());
        assertEquals(lastName, result.getLastName());
        assertEquals(organization, result.getOrganization());
        assertEquals(phone, result.getPhone());
        assertEquals(email, result.getEmail());
    }
}
