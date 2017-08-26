package ru.alternation.examples.youtube.csc.testing.defensive;
import static com.google.common.base.Preconditions.checkNotNull;

public class UserService {

    private final UserPersistence persistence;

    public UserService(UserPersistence persistence) {
        checkNotNull(persistence, "persistence");
        this.persistence = persistence;
    }

    public boolean userExists(String name) {
        return persistence.findUserByName(name) != null;
    }
}
