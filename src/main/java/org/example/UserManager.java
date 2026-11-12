package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserManager {
    public UserManager() {
    }

    public  User findUserById(Map<Integer,User> usersMap, int id){
        User user = usersMap.get(id);

        if (user != null) {
            System.out.println("User with ID " + id + " found.");
            return user;
        }

        System.out.println("User with ID " + id + " wasn't found.");
        return null;
    }

    public  void displayAllUsers(Map<Integer,User> usersMap){
        for (Map.Entry<Integer, User> entry : usersMap.entrySet()) {
            System.out.println("\n"+entry.getKey() + " -> " + entry.getValue());
        }
    }

    public  void removeUser(Map<Integer,User> usersMap, int id){
        if (!usersMap.containsKey(id)) {
            System.out.println("User with ID " + id + " doesn't exist.");
            return;
        }

        usersMap.remove(id);
        System.out.println("User successfully removed.");
    }

    public  void updateUserEmail(Map<Integer,User> usersMap, int id, String email){
        User user = usersMap.get(id);
        if(user == null){
            System.out.println("We don't have the user with "+id+" ID\nThe email wasn't changed.");
            return;
        }
        findUserById(usersMap,id).setEmail(email);
    }

    public  User findById(int id, List<User> users) {

        for (User user : users) {
            if (user.getId() == id) {
                System.out.println("\nSearched id: "+id+"\nUser found: "+user);
                return user;
            }
        }


        System.out.println("\nUser with "+id+" id is not existing in our DB(");

        return null;
    }

    public  List<User> getActiveUsers(List<User> array){
        List<User> sortedList = new ArrayList<>();
        int count=0;
        for(User user: array){
            if(user.isActive()){
                count++;
                sortedList.add(user);
            }

        }
        System.out.println("Count of active users: "+count);
        return  sortedList;
    }

    public void addUser(Map<Integer,User> usersMap, User user){
        if (usersMap.containsKey(user.getId())) {
            System.out.println("User with ID " + user.getId() + " already exists.");
            return;
        }

        usersMap.put(user.getId(), user);
        System.out.println("User successfully added.");
    }

    public void deactivateUser(User user){
        user.deactivate();
    }
}
