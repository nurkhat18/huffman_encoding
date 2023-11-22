/*
 * Swarn
 * This is for testing account
 */
package application;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    //Testing whether an account can be created or not
    void testAccountCreation() {
        account acc = new account("user1", "pass123");
        assertNotNull(acc);
        assertEquals("user1", acc.getUserName());
        assertEquals("pass123", acc.getPassword());
    }

    @Test
    //Testing the observable list of an account which holds messages
    void testObservableList() {
        account acc = new account("user2", "pass456");
        ObservableList<text> list = acc.returnList();
        assertNotNull(list);
        assertTrue(list.isEmpty());
    }

}
