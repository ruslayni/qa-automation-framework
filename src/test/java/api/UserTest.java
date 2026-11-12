package api;

import org.example.User;
import org.example.UserManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;



public class UserTest{
    UserManager manager;
    Map<Integer, User> usersMap;
    User user;
    User userTest = new User(2,"Test","testing",true);
    User userTestDuplicate = new User(2,"lol","testingduplicate",true);;

@BeforeEach
public void setUp(){
     usersMap = new HashMap<>();
    manager = new UserManager() ;
    usersMap.put(1, new User(1, "Ruslan", "gaga", true));
     user = new User(7,"Ruslan","lalalend@gmail.com",false);

}

@Test
    public void shouldCreateUser(){
        manager.addUser(usersMap,user);
    assertTrue(usersMap.containsKey(user.getId()));
}

    @Test
    public void shouldUpdateEmail() {
        manager.addUser(usersMap, user);

        String newEmail = "new@gmail.com";

        manager.updateUserEmail(usersMap,user.getId(),newEmail);

        assertEquals(newEmail,usersMap.get(user.getId()).getEmail()
        );}

    @Test
    public void shouldDeactivateUser(){
        manager.deactivateUser(user);
        assertFalse(user.isActive());
    }

    @Test
    public void shouldThrowExceptionForBlankName() {

        assertThrows(IllegalArgumentException.class, () -> {
            new User(1, "", "gmail.gmail@gmail.com", true);
        });
    }

    @Test
    public void shouldThrowExceptionForBlankEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            new User(1, "Ruslan", "", true);
        });
    }

    @Test
    public void shouldRemoveUser(){
        usersMap.put(userTest.getId(), userTest);
        manager.removeUser(usersMap, userTest.getId());
        assertFalse(usersMap.containsKey(userTest.getId()));

    }

    @Test
    public void shouldNotAddDuplicateUser(){
        manager.addUser(usersMap,userTest);
        int initialSize = usersMap.size();
        manager.addUser(usersMap,userTestDuplicate);

        assertEquals(initialSize, usersMap.size());
        assertEquals("Test", usersMap.get(2).getName());
        assertEquals("testing", usersMap.get(2).getEmail());
    }

    //Negative tests
    @Test
    public void shouldNotUpdateEmailForUnknownUser() {

        int initialSize = usersMap.size();
        String originalEmail = usersMap.get(1).getEmail();

        manager.updateUserEmail(usersMap, 1000, "bmw@gmail.com");

        assertEquals(initialSize, usersMap.size());

        assertEquals(originalEmail, usersMap.get(1).getEmail());

        assertFalse(usersMap.containsKey(1000));
    }
}