package ru.alternation.Trash.Youtube.CSC.testing.defensive;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class User {

    private final String name;

    public User(String name) {
        checkNotNull(name, "name");
        checkArgument(0 < name.length() && name.length() < 10, "Name must consist of 1..10 characters but got %s", name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
