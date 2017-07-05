package no.uio.neo.dao;

import java.util.Collection;
import java.util.Locale;

import no.uio.neo.model.User;

public interface UserDAO {
    /**
     * return a user
     *
     * @param id the id of the user
     * @return the user
     */
    User getUser(int id);

    /**
     * return a user
     *
     * @param username of the user
     * @return the user
     */
    User getUser(String username);

    /**
     * save a user
     *
     * @param user the user to be saved
     * @return the new id generated
     */
    int saveUser(User user);

    /**
     * Returns all users
     *
     * @return Collection of all users
     */
    Collection<User> getAllUsers();

    /**
     * Delete a user from the database
     *
     * @param user the user to delete
     */
    void delUser(User user);

    /**
     * Merge a changed user back into the database
     *
     * @param user changed user
     * @return the resulting user, read from the database
     */
    User updateUser(User user);
}
