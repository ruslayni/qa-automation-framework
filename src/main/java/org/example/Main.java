package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public Main() {
    }

     static void main() {
UserManager manager = new UserManager();
        //List practice
        List<User> usersList = new ArrayList<>();

        User user1 = new User(1, "Ruslan", "dog@gmail.com", true);
        User user2 = new User(2, "Oleksandr", "oleksa@gmail.com", true);
        User user3 = new User(3, "Daria", "daria@gmail.com", false);
        User user4 = new User(4, "Alex", "alex@gmail.com", true);

        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);
        usersList.add(user4);

        //Display all users
        usersList.forEach(User::displayInfo);

        List<User> activeUsers = manager.getActiveUsers(usersList);
        System.out.println("Active users: " + activeUsers);

        User foundUser = manager.findById(5, usersList);

        // HashMap practice
        Map<Integer,User> usersMap = new HashMap<>();

        usersMap.put(1,user1);
        usersMap.put(2,user2);
        usersMap.put(3,user3);
        usersMap.put(4,user4);

        //Adding users with created method
        manager.addUser(usersMap,user1);
       manager.addUser(usersMap, new User(5, "John", "john@gmail.com", true));
        manager.addUser(usersMap, new User(5, "Mike", "mike@gmail.com", true));
         manager.displayAllUsers(usersMap);

        //Fid user by Id
       System.out.println(manager.findUserById(usersMap,10));
       System.out.println(manager.findUserById(usersMap,2));

        //Remove user
         manager.displayAllUsers(usersMap);
         manager.removeUser(usersMap,15);
         manager.displayAllUsers(usersMap);

        //email update
         manager.updateUserEmail(usersMap,100,"dota2enjoyer@gmail.com");
        System.out.println(usersMap.get(5));
    }


    }

