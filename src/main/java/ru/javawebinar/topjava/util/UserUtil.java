package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class UserUtil {
    public static final List<User> USERS = Arrays.asList(
            new User(1, "user1", "user1@test.com", "user1", 1000, true, EnumSet.of(Role.ROLE_USER)),
            new User(2, "user2", "user2@test.com", "user2", 2000, true, EnumSet.of(Role.ROLE_ADMIN))
    );
}
