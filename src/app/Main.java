package src.app;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        userRepository.addUser(new User(301, "Alex", "Alex@ukr.net"));
        userRepository.addUser(new User(302, "Viktor", "Viktor@g,gmail.com"));
        userRepository.addUser(new User(303, "Alice", "Alice@ukr.net"));
        userRepository.addUser(new User(304, "Ann", "Ann@gmail.com"));
        userRepository.addUser(new User(305, "Diana", "LediDi@ukr.net"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user id: ");
        int id = scanner.nextInt();

        System.out.println("Enter user email: ");
        String email = scanner.next();

        Optional<User> userById = userRepository.findUserById(id);
        userById.ifPresentOrElse(System.out::println,
                () -> System.out.println("User with id " + id + " not found."));

        Optional<User> userByEmail = userRepository.findUserByEmail(email);
        userByEmail.ifPresentOrElse(System.out::println,
                () -> System.out.println("User with email " + email + " not found."));

        Optional<List<User>> allUsers = userRepository.findAllUsers();
        allUsers.ifPresentOrElse(users -> users.forEach(System.out::println),
                () -> System.out.println("No users found."));

      allUsers.ifPresent(users -> System.out.println("\nTotally there is " + users.size() + " users."));

    }
}
