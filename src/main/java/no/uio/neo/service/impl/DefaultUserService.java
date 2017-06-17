package no.uio.neo.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
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
