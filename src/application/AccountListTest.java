/*
 * Swarn 
 * This is for testing accountList.
 */
package application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

class AccountListTest {

    private accountList accList;

    @BeforeEach
    //just setting up an example user with a password to run some tests
    void setup() {
        accList = new accountList();
        accList.add("user1", "pass123");
    }

    @Test
    //Test to see if the user exists
    void testCheckUser() {
        assertTrue(accList.checkUser("user1", "pass123"));
        assertFalse(accList.checkUser("user1", "wrongpass"));
        assertFalse(accList.checkUser("nonexistent", "pass123"));
    }


    @Test
    // Test to get the account 
    void testGetAccount() {
        Set<account> accounts = accList.getAccount();
        assertNotNull(accounts);
        assertEquals(1, accounts.size());
    }
}
