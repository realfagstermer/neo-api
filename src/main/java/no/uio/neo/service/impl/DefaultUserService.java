package no.uio.neo.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import no.uio.neo.dao.UserDAO;
import no.uio.neo.model.User;
import no.uio.neo.service.UserService;

@Transactional
@Service
public class DefaultUserService implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public User getCurrentUser() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            SAMLCredential credential = (SAMLCredential) authentication.getCredentials();
            // List<Attribute> attributes = credential.getAttributes();
            String username = credential.getAttributeAsString("eduPersonPrincipalName");
            String name = credential.getAttributeAsString("cn");
            User user = userDAO.getUser(username);

            if (user == null) {
                // User not registered in database
                user = new User(username, name);
            }

            return user;
        } catch (Exception e) {
            // user not authenticated
            return null;
        }
    }

    @Override
    public Collection<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void delUser(int userId) {
        final User user = userDAO.getUser(userId);
        userDAO.delUser(user);
    }

    @Override
    public User getUser(int userId) {
        return userDAO.getUser(userId);
    }

    @Override
    public int addUser(User user) {
        return userDAO.saveUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userDAO.updateUser(user);
    }

}
