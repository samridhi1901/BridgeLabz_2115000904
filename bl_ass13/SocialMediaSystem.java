import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }

    public void addFriend(int friendId) {
        if (!friendIds.contains(friendId)) {
            friendIds.add(friendId);
        }
    }

    public void removeFriend(int friendId) {
        friendIds.remove(Integer.valueOf(friendId));
    }
}

class SocialMedia {
    private User head;
    private Map<Integer, User> userMap;

    public SocialMedia() {
        this.head = null;
        this.userMap = new HashMap<>();
    }

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
        userMap.put(userId, newUser);
    }

    public void addFriendConnection(int userId1, int userId2) {
        User user1 = userMap.get(userId1);
        User user2 = userMap.get(userId2);
        if (user1 != null && user2 != null) {
            user1.addFriend(userId2);
            user2.addFriend(userId1);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = userMap.get(userId1);
        User user2 = userMap.get(userId2);
        if (user1 != null && user2 != null) {
            user1.removeFriend(userId2);
            user2.removeFriend(userId1);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void displayFriends(int userId) {
        User user = userMap.get(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friendIds);
        } else {
            System.out.println("User not found.");
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        User user1 = userMap.get(userId1);
        User user2 = userMap.get(userId2);
        if (user1 != null && user2 != null) {
            List<Integer> mutualFriends = new ArrayList<>(user1.friendIds);
            mutualFriends.retainAll(user2.friendIds);
            System.out.println("Mutual friends of " + user1.name + " and " + user2.name + ": " + mutualFriends);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void searchUser(int userId) {
        User user = userMap.get(userId);
        if (user != null) {
            System.out.println("User found: " + user.name + ", Age: " + user.age);
        } else {
            System.out.println("User not found.");
        }
    }

    public void searchUser(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("User found: ID: " + temp.userId + ", Age: " + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    public void countFriends(int userId) {
        User user = userMap.get(userId);
        if (user != null) {
            System.out.println(user.name + " has " + user.friendIds.size() + " friends.");
        } else {
            System.out.println("User not found.");
        }
    }
}

public class SocialMediaSystem {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        sm.addUser(1, "Sam", 25);
        sm.addUser(2, "Anu", 30);
        sm.addUser(3, "Divya", 28);
        sm.addUser(4, "Tanu", 27);

        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 4);
        sm.addFriendConnection(3, 4);

        sm.displayFriends(1);
        sm.displayFriends(2);

        sm.findMutualFriends(1, 2);
        sm.findMutualFriends(1, 3);

        sm.countFriends(1);

        sm.searchUser(3);
        sm.searchUser("Sam");

        sm.removeFriendConnection(1, 3);
        sm.displayFriends(1);
    }
}
