package DenisTasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class User {
    private String name;
    private String role;

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Denis", "mentor"));
        users.add(new User("Evgenii", "intern"));
        users.add(new User("Ekaterina", "intern"));
        users.add(new User("Valentina", "intern"));

        User newUser = new User("Anna", "intern");


        // Task 1: using Predicate to get interns list
        Predicate<User> predicate = user -> user.getRole().equals("intern");

        List<User> justInternList = new ArrayList<>();
        for (User user : users) {
            if (predicate.test(user)) {
                justInternList.add(user);
            }
        }
        System.out.println("1.Get interns list:");
        System.out.println(justInternList);

        // Task 2: using Function to add to the list new user and return a number of users with the same role.
        List<Integer> indexStudentsSameRole = new ArrayList<>();
        int count = 0;
        Function<User, List<Integer>> function = someUser -> {
            List<Integer> list = new ArrayList<>();
            for(User oldUser : users) {
                if(someUser.getRole().equals(oldUser.getRole())) {
                    list.add(users.indexOf(oldUser));
                }
            }
            return list;
        };

        indexStudentsSameRole = function.apply(newUser);
        for(Integer number : indexStudentsSameRole) count++;
        System.out.println("\n" + "2.Return a number of users with role like new User:");
        System.out.println("-Number of users: " + count);
        System.out.println("-User's index: " + indexStudentsSameRole);

        // Task 3: using Consumer to do pretty output the given user.
        System.out.println("\n" + "3.To do pretty output the given user:");
        Consumer<User> consumer = user -> System.out.println("Aaaaaand... NEW! User of the teeeaaam...." + user.getName() + "!!!" + "We have a one more " + user.getRole());
        consumer.accept(newUser);

        // Task 4: Add new field, like "luck". using Supplier to randomly set luck (0 - 100)
        Supplier<Integer> supplier = () -> new Random().nextInt(101);
        int luck = supplier.get();

        System.out.println("\n" + "4.To create field 'luck' generating random digit (0-100):");
        System.out.println("luck =" + luck);
    }
    User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "<- " + "name: " + name + ", role: " + role + " ->";
    }

}