package no.uio.neo.service;

import java.util.Collection;
import java.util.Locale;

import no.uio.neo.model.User;

public interface UserService {
    Collection<User> getAllUsers();

    void delUser(int userId);

    User getUser(int userId);

    int addUser(User user);

    User updateUser(User user);
}
