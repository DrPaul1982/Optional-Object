package src.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private final List<User> users;
    UserRepository() {
        this.users = new ArrayList<>();
    }

    void addUser(User user) {
        users.add(user);
    }

    Optional<User> findUserById(int id){
        return users.stream()
                .filter(user -> user.getId() == id).findFirst();
    }

    Optional<User> findUserByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    Optional<List<User>> findAllUsers() {
        return Optional.of(users);
    }

}
