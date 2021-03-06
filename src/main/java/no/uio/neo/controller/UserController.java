package no.uio.neo.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import no.uio.neo.model.User;
import no.uio.neo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public User getCurrentUser(HttpServletRequest request, HttpServletResponse response) {
        return userService.getCurrentUser();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Collection<User> getAllUsers(HttpServletRequest request, HttpServletResponse response) {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable("userId") int userId, HttpServletRequest request, HttpServletResponse response) {
        return userService.getUser(userId);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, consumes = "application/json")
    public User postUser(@RequestBody User user) {
        int id = userService.addUser(user);
        return userService.getUser(id);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<User> putUser(@PathVariable("userId") int userId, @RequestBody User user) {
        logger.trace("user put:" + user.getUsername());

        if (userId != user.getUserId()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.ok(userService.updateUser(user));
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable("userId") int userId, HttpServletRequest request, HttpServletResponse response) {
        userService.delUser(userId);
        return null;
    }
}
